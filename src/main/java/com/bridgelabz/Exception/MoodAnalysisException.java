package com.bridgelabz.Exception;

public class MoodAnalysisException extends RuntimeException {
    public ExceptionType type;

    public enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,NO_ACCESS,OBJECT_CREATION_ISSUE,METHOD_INVOCATION_ISSUE,NO_SUCH_FIELD
    }
    ExceptionType exceptionType;
    public MoodAnalysisException (String message,ExceptionType exceptionType ) {
        super(message);
        this.exceptionType=exceptionType;
    }
}
