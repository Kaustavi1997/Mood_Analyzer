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
    public void whenNullMessage_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        Assert.assertEquals("HAPPY",moodAnalyzer.analyzeMood());

    }

}
