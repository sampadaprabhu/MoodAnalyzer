package com.bridgelabz;

import com.bridgelabz.moodanalysis.exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalyzerTest {

    String mood = null;
    @Test
    public void givenNullMoodAnalyzerShouldReturnSad(){
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Sad Mood");
        try {
            mood = moodAnalyzer.analyzedMood();
            Assert.assertEquals("SAD",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        try {
            mood = moodAnalyzer.analyzedMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodAnalyzerShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            mood = moodAnalyzer.analyzedMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MoodException.EXCEPTION_OF_NULL, e.moodException);
        }
    }

        @Test
        public void givenEmptyMoodAnalyzerShouldReturnHappy(){
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
            try {
                mood=moodAnalyzer.analyzedMood();
                Assert.assertEquals("HAPPY",mood);
            }
            catch (MoodAnalysisException e){
                Assert.assertEquals(MoodAnalysisException.MoodException.EXCEPTION_OF_EMPTY,e.moodException);
            }
        }
}
