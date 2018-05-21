package com.neuedu.entity;

import java.io.Serializable;
/**
 * 答案实体类
 * */
public class QAnswer implements Serializable {

    private int   id       ;
    private int  qid ;
    private String  qtitle;// 问题标题
    private String qno;//问卷编号
    private String answer     ;// 问题答案
    private String answertime  ;// 提交时间
    private String userip      ;// ip


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public String getQno() {
        return qno;
    }

    public void setQno(String qno) {
        this.qno = qno;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswertime() {
        return answertime;
    }

    public void setAnswertime(String answertime) {
        this.answertime = answertime;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }
}
