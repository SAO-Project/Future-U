package com.example.future_u.assessment;

import java.util.ArrayList;

public class Assessment {
    private String path, major;
    private Double gpa;
    private ArrayList<Question> setOfQuestions = new ArrayList<Question>();
//    represents the question as string
    private String[] queries = {"I enjoy meeting new people.", "I like helping people.", "I sometimes make mistakes.", "I'm easily disappointed.", "I enjoy repairing things."};

    public Assessment(String path, String major, Double gpa) {
        this.path = path;
        this.major = major;
        this.gpa = gpa;
        buildSetOfQuestions();
    }

    public void buildSetOfQuestions(){
        for(String query : queries){
            Question question = new Question(query);
            setOfQuestions.add(question);
        }
    }

    public ArrayList<Question> getSetOfQuestions(){
        return this.setOfQuestions;
    }

    public double getGpa(){
        return this.gpa;
    }

    public String getMajor(){
        return this.major;
    }

}
