package com.bridgelabz;

import com.bridgelabz.moodanalysis.exception.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {


    public static MoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Class<?> moodAnalyzerClass=Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> constructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObject = constructor.newInstance(message);
            MoodAnalyzer myobject1=(MoodAnalyzer)moodObject;
            return myobject1;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

        //UC4:Default Constructor
    public static MoodAnalyzer createMoodAnalyzer() {
        try {
            Class<?> moodAnalyzerClass=Class.forName("com.bridgelabz.MoodAnalyzer");
            Constructor<?> constructor = moodAnalyzerClass.getConstructor();
            Object moodObject = constructor.newInstance();
            MoodAnalyzer myobject1=(MoodAnalyzer)moodObject;
            return myobject1;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> getClass(String name) throws MoodAnalysisException {
        try {
            Class<?> className=Class.forName(name);
            return className;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_SUCH_CLASS,e.getMessage());
        }
    }
    //UC4:With Default Constructor
    public static Constructor<?> defaultConstructor() throws MoodAnalysisException {
        try {
            Class<?> className = Class.forName("com.bridgelabz.MoodAnalyzerNotFound");
            Constructor<?> constructor=className.getConstructor();
            return constructor;
        }
        catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_SUCH_CLASS,e.getMessage());
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_SUCH_METHOD,e.getMessage());
        }
    }

    //UC5:With Parameter Constructor
    public static Constructor<?> getConstructor(Class<?> ... stringClass) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            return moodAnalyzerClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_SUCH_METHOD,e.getMessage());
        }
        catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_SUCH_CLASS,e.getMessage());
        }
    }

    //UC6
    public static Object getObject(Constructor<?> constructor,Object ... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_SUCH_OBJECT,e.getMessage());
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_ACCESS,e.getMessage());
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.OBJECT_CREATION_ISSUE, e.getMessage());
        }
    }


    public static Object invokeMethod(Object moodObject, String message) throws MoodAnalysisException {
        try {
            return moodObject.getClass().getMethod(message).invoke(moodObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_SUCH_METHOD,"NO_SUCH_METHOD");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.NO_ACCESS,"NO_ACCESS");
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MoodException.OBJECT_CREATION_ISSUE,"OBJECT_CREATION_ISSUE");
        }
    }

}
