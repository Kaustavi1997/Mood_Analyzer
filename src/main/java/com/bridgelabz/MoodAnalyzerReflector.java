package com.bridgelabz;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

public class MoodAnalyzerReflector {
    public static MoodAnalyzer creatMoodAnalyser(String ... information) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(information[0]);
            if (information.length > 1) {
                Class<?> moodAnalyzerParameter = Class.forName("java.lang."+information[1]);
                Constructor<?> constructor = moodAnalyzerClass.getConstructor(moodAnalyzerParameter);
                Object moodAnalyzer = constructor.newInstance(information[2]);
                return (MoodAnalyzer) moodAnalyzer;
            } else {
                Constructor<?> constructor = moodAnalyzerClass.getConstructor();
                Object moodAnalyzer = constructor.newInstance();
                return (MoodAnalyzer) moodAnalyzer;
            }
        }catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("Class Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        }
        catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE);
        }

    }
    public static void setFieldValue(Object moodAnalyserObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = moodAnalyserObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyserObject,fieldValue);
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

