package com.bridgelabz.moodanalysis.exception;

public class MoodAnalysisException extends Exception{

    public enum MoodException
    {
        EXCEPTION_OF_NULL,
        EXCEPTION_OF_EMPTY,
        NO_SUCH_CLASS,
        NO_SUCH_OBJECT,
        NO_SUCH_METHOD,
        NO_ACCESS,
        OBJECT_CREATION_ISSUE,
        NO_SUCH_FIELD

    }
    public MoodException moodException;

    public MoodAnalysisException(MoodException moodException, String message) {
        super(message);
        this.moodException=moodException;
    }

    public MoodAnalysisException(String message, Throwable cause, MoodException moodException) {
        super(message, cause);
        this.moodException = moodException;
    }

    public MoodAnalysisException(String message, MoodException moodException) {
        super(message);
        this.moodException = moodException;
    }
}
