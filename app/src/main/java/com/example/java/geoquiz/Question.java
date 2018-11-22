package com.example.java.geoquiz;

public class Question {
    private int questionResID;
    private boolean answer;

    public Question(int questionResID, boolean answer) {
        this.questionResID = questionResID;
        this.answer = answer;
    }

    public int getQuestionResID() {
        return questionResID;
    }

    public void setQuestionResID(int questionResID) {
        this.questionResID = questionResID;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
