package com.bridgelabz;
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
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.exceptionType);
        }
    }
    @Test
    public void whenEmptyMessage_InformUser(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        }catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.exceptionType);
        }
    }
    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser();
        Assert.assertEquals(new MoodAnalyzer(),moodAnalyzer);
    }
    @Test
    public void givenClassName_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.exceptionType);
        }
    }
    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.exceptionType);
        }
    }
    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject_Parameter() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("I am in happy mood");
        Assert.assertEquals(new MoodAnalyzer("I am in happy mood"),moodAnalyzer);
    }
    @Test
    public void givenClassName_WhenImproper_ShouldThrowException_Parameter() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.exceptionType);
        }
    }
    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowException_Parameter() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerReflector.creatMoodAnalyser("I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.exceptionType);
        }
    }
    @Test
    public void givenHappyMessageProper_ShouldReturnHappy() {
            Object analyseMood = MoodAnalyzerReflector.invokeMethod(MoodAnalyzerReflector.creatMoodAnalyser("I am in happy mood"), "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
    }

}
