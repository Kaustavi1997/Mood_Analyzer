package com.bridgelabz;

public class MoodAnalysisException extends RuntimeException {
    public enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY
    }
    ExceptionType exceptionType;
    public MoodAnalysisException (String message,ExceptionType exceptionType ) {
        super(message);
        this.exceptionType=exceptionType;
    }
}
