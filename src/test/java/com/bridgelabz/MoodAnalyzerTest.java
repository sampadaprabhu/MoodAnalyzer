package com.bridgelabz;

import com.bridgelabz.moodanalysis.exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    String mood = null;
    @Test
    public void givenMoodAnalyzerShouldReturnSad(){
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
        @Test
    public void givenMoodAnalyzer_WhenProper_ShouldReturnObject(){
            try {
                Constructor constructor=Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor(String.class);
                try {
                    Object myObject = constructor.newInstance("I am in Happy Mood");
                    MoodAnalyzer myobject1=(MoodAnalyzer)myObject;

                    String mood=myobject1.analyzedMood();
                    Assert.assertEquals("HAPPY",mood);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException | MoodAnalysisException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject(){
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in Sad Mood");
            try {
                String mood=moodAnalyzer.analyzedMood();
                Assert.assertEquals("SAD",mood);
            } catch (MoodAnalysisException e) {
                e.printStackTrace();
            }
        }


        @Test
    public void givenMoodAnalyzerClass_WhenProperWork_ShouldReturnObject(){
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in Happy Mood");
                Assert.assertEquals(new MoodAnalyzer("I am in Happy Mood"),moodAnalyzer);
        }
        //UC4:Default Constructor
        @Test
        public void givenDefaultMoodAnalyzerClass_WhenProper_ShouldReturnObject(){
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            try {
                String mood=moodAnalyzer.analyzedMood();
                Assert.assertEquals(new MoodAnalyzer(),moodAnalyzer);
            } catch (MoodAnalysisException e) {
                e.printStackTrace();
            }
        }

        //4.2
    @Test
    public void givenMoodAnalyzerWrongClass_WithDefaultConstructor_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        try {
            Constructor<?> constructor=MoodAnalyzerFactory.defaultConstructor();
        } catch (MoodAnalysisException e) {
            //e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.MoodException.NO_SUCH_CLASS,e.moodException);
        }
    }

    //UC5:Create Mood Analyzer With Parameter Constructor
    @Test
    public void givenParameterMoodAnalyzerObject_WhenProper_ShouldReturnObject(){
        try {
            Constructor<?> constructor=MoodAnalyzerFactory.getConstructor(String.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    //5.2
    @Test
    public void givenMoodAnalyzerWrongClass_WithgetConstructor_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        try {
            Constructor<?> constructor=MoodAnalyzerFactory.getConstructor(String.class);
        } catch (MoodAnalysisException e) {
            //e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.MoodException.NO_SUCH_CLASS,e.moodException);
        }
    }
    //5.3
    @Test
    public void givenMoodAnalyzerWrongObject_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        try {
            Constructor<?> constructor=MoodAnalyzerFactory.getConstructor(Integer.class);
        } catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.MoodException.NO_SUCH_METHOD,e.moodException);
        }
    }
    //UC6  //UC6.1
    @Test
    public void givenMethod_WhenProper_ShouldReturnObject(){
        Object myObject=null;
        try {
            Class<?> className=MoodAnalyzerFactory.getClass("com.bridgelabz.MoodAnalyzer");
            Constructor<?> constructor=MoodAnalyzerFactory.getConstructor(className,String.class);
            Object moodObject=MoodAnalyzerFactory.getObject(constructor,"I am in Happy Mood");
            myObject=MoodAnalyzerFactory.invokeMethod(moodObject,"analyzedMood");
            MoodAnalyzer moodAnalyzer=(MoodAnalyzer)moodObject;
            String mood=moodAnalyzer.analyzedMood();
            Assert.assertEquals("HAPPY",myObject);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("HAPPY",myObject);
        }
    }

    //6.2
    @Test
    public void givenWrongMethod_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        Object myObject=null;
        try {
            Class<?> className = MoodAnalyzerFactory.getClass("com.bridgelabz.MoodAnalyzer");
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(className, String.class);
            Object moodObject = MoodAnalyzerFactory.getObject(constructor, "I am in Happy Mood");
            myObject = MoodAnalyzerFactory.invokeMethod(moodObject, "analyzerMethod");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) moodObject;
            String mood = moodAnalyzer.analyzedMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MoodException.NO_SUCH_METHOD, e.moodException);
        }
    }


}
