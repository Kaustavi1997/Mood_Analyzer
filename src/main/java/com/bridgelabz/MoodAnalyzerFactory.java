package com.bridgelabz;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
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
}

