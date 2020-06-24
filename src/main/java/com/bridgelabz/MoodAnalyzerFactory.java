package com.bridgelabz;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer creatMoodAnalyser()throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObj = moodConstructor.newInstance();
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("Class Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}

