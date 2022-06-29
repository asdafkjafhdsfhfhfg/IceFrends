package com.aim.questionnaire.dao.entity;


//储存答题人信息
public class AnswerEntity {
    private String no;
    private String answerNum;
    private String answerBelong;
    private String answerPhone;
    private String answerEmail;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(String answerNum) {
        this.answerNum = answerNum;
    }

    public String getAnswerBelong() {
        return answerBelong;
    }

    public void setAnswerBelong(String answerBelong) {
        this.answerBelong = answerBelong;
    }

    public String getAnswerPhone() {
        return answerPhone;
    }

    public void setAnswerPhone(String answerPhone) {
        this.answerPhone = answerPhone;
    }

    public String getAnswerEmail() {
        return answerEmail;
    }

    public void setAnswerEmail(String answerEmail) {
        this.answerEmail = answerEmail;
    }
}
