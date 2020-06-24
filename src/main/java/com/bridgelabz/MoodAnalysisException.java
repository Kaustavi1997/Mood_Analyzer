package com.bridgelabz;

public class MoodAnalysisException extends RuntimeException {
    public ExceptionType type;

    public enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD
    }
    ExceptionType exceptionType;
    public MoodAnalysisException (String message,ExceptionType exceptionType ) {
        super(message);
        this.exceptionType=exceptionType;
    }
}
