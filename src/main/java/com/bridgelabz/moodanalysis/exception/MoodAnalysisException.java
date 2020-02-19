package com.bridgelabz.moodanalysis.exception;

public class MoodAnalysisException extends Exception{

    public enum MoodException
    {
        EXCEPTION_OF_NULL,
        EXCEPTION_OF_EMPTY
    }
    public MoodException moodException;

    public MoodAnalysisException(MoodException moodException, String message) {
        super(message);
        this.moodException=moodException;
    }
}
