package com.bridgelabz;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

public class MoodAnalyzerReflector {
    public static MoodAnalyzer creatMoodAnalyser(String ... message) throws MoodAnalysisException {
        try {
            int size=message.length;
            String messageString;
            if(size!=0) {
                messageString = message[0];
            }
            else{
                messageString = "";
            }
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> constructor[] = moodAnalyserClass.getDeclaredConstructors();
            Constructor<?> moodConstructor;
            Object moodObj;
            if(size!=0){
                moodConstructor = constructor[1];
                moodObj = moodConstructor.newInstance(messageString);
            }
            else{
                moodConstructor = constructor[0];
                moodObj = moodConstructor.newInstance();
            }
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("Class Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        }
        catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE);
        }

    }
    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException("field Not Found",
                    MoodAnalysisException.ExceptionType.NO_SUCH_FIELD);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("may be issue with data",
                    MoodAnalysisException.ExceptionType.NO_ACCESS);
        }
    }
    public static Object invokeMethod(Object moodAnalyserObject , String methodName ) throws MoodAnalysisException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method Not Found",
                    MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }catch (IllegalAccessException |InvocationTargetException e) {
            throw new MoodAnalysisException("Maybe issue with data entererd",
                    MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE);
        }
    }
}

