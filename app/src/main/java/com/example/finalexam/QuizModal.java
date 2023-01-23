package com.example.finalexam;

public class QuizModal {

    private String question;
    private String answer;
    private String questionNo;

    private int id;

    // creating getter and setter methods
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public QuizModal(String questionNo, String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.questionNo = questionNo;


    }
}

