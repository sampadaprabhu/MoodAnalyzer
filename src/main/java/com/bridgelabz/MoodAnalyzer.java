package com.bridgelabz;

import com.bridgelabz.moodanalysis.exception.MoodAnalysisException;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer() {
        message="sampada";
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }


    public String analyzedMood() throws MoodAnalysisException {
            try {
                    if (message.isEmpty()){
                        throw new MoodAnalysisException(MoodAnalysisException.MoodException.EXCEPTION_OF_EMPTY,"Enter Proper Message!!");
                   }
                   else if (message.contains("Sad")) {
                        return "SAD";
                    }
                    else {
                        return "HAPPY";
                    }
            }
            catch (NullPointerException e) {
                throw new MoodAnalysisException(MoodAnalysisException.MoodException.EXCEPTION_OF_NULL,"Enter Proper Message!!");
            }
    }
    public boolean equals(Object another){
        if(this.message.equals(((MoodAnalyzer) another).message))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

