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
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.creatMoodAnalyser();
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY",mood);
        }catch(MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
}
