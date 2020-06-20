package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyzerTest {
    @Test
    public void whenSadMessage_ShouldReturnSad(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("this is a Sad message");
        Assert.assertEquals("SAD",mood);

    }
    @Test
    public void whenHappyMessage_ShouldReturnHappy(){
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("this is a Happy message");
        Assert.assertEquals("HAPPY",mood);

    }

}
