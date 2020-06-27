package com.bridgelabz;
import com.bridgelabz.Exception.MoodAnalysisException;
import com.bridgelabz.service.MoodAnalyzer;
import com.bridgelabz.service.MoodAnalyzerReflector;
import org.junit.Assert;
import org.junit.Test;


public class MoodAnalyzerTest {
    @Test
    public void whenSadMessage_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("this is a Sad message");
        Assert.assertEquals("SAD",moodAnalyzer.analyzeMood());

    }
    @Test
    public void whenHappyMessage_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("this is a Happy message");
        Assert.assertEquals("HAPPY",moodAnalyzer.analyzeMood());

    }
    @Test
    public void whenNullMessage_InformUser(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        }catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void whenEmptyMessage_InformUser(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        }catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject() throws MoodAnalysisException {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer");
            Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
        }catch(MoodAnalysisException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassName_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.Analyzer");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject_Parameter() throws MoodAnalysisException {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood");
            Assert.assertEquals(new MoodAnalyzer("I am in happy mood"), moodAnalyzer);
        }catch(MoodAnalysisException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassName_WhenImproper_ShouldThrowException_Parameter() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.Analyzer", "String", "I am in happy mood");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowException_Parameter() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "Interger", "90");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenHappyMessageProper_ShouldReturnHappy() {
        try {
            Object analyseMood = MoodAnalyzerReflector.invokeMethod(MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood"), "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        }catch(MoodAnalysisException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessage_ImProperMethod_ShouldThrowException() {
        try {
            Object analyseMood = MoodAnalyzerReflector.invokeMethod(MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood"), "mood");
            Assert.assertEquals("HAPPY", analyseMood);
        }catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void givenHappyMessage_dynamic_ShouldReturnHappy() {
        try {
            MoodAnalyzerReflector.setFieldValue(MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood"), "message", "I am in happy mood");
            Object analyseMood = MoodAnalyzerReflector.invokeMethod(MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood"), "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        }catch(MoodAnalysisException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenSetField_Improper_ShouldThrowException() {
        try {
            MoodAnalyzerReflector.setFieldValue(MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood"), "nothing", "I am in no mood");
            Object analyseMood = MoodAnalyzerReflector.invokeMethod(MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood"), "analyzeMood");
        }catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenSetField_Null_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer =MoodAnalyzerReflector.creatMoodAnalyser("com.bridgelabz.service.MoodAnalyzer", "String", "I am in happy mood");
            MoodAnalyzerReflector.setFieldValue(moodAnalyzer, null, null);
            Object analyseMood = MoodAnalyzerReflector.invokeMethod(moodAnalyzer, "analyzeMood");
        }catch (NullPointerException e) {
            System.out.print("NullPointerException Caught");
        }

    }

}
