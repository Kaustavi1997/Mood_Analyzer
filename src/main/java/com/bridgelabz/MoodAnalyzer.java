package com.bridgelabz;

public class MoodAnalyzer {
        String message;
        public MoodAnalyzer() {
        this.message = "";
        }

        public MoodAnalyzer(String message) {
        this.message = message;
        }

        public String analyzeMood()throws MoodAnalysisException {
            try{
                if(message.length()==0)
                    throw new MoodAnalysisException("Please enter valid mood message. It's Empty",MoodAnalysisException.ExceptionType.ENTERED_EMPTY);
                if (message.contains("Sad"))
                    return "SAD";
                else
                    return "HAPPY";
            }catch (NullPointerException e){
                throw new MoodAnalysisException("Please enter valid mood message.It's Null",MoodAnalysisException.ExceptionType.ENTERED_NULL);
            }
        }
    @Override
    public boolean equals(Object another) {
        if (this.message.equals(((MoodAnalyzer)another).message))
            return true;
        else
            return false;
    }
}
