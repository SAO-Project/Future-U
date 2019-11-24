package com.example.future_u.assessment;

public class Question {
    private String question;
    private int answer;
    private String[] answers = {"Strongly disagree", "Disagree", "Neutral", "Agree", "Strongly agree"};
    /*
    * instance of questions that assessment can have
     */
    public Question(){}

    public Question(String question){
        this.question = question;
    }

    public Question(String question, int answer){
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question){
        this.question = question;
    }
    public void setAnswer(int answer){
        this.answer = answer;
    }
}
