package com.neuedu.entity;

import java.io.Serializable;

public class Question implements Serializable{
    private Integer qid;
    private String qno;//问卷编号
    //题目标题
    private String title;
    //题目类型
    private String qtype;

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getQno() {
        return qno;
    }

    public void setQno(String qno) {
        this.qno = qno;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qid=" + qid +
                ", title='" + title + '\'' +
                ", type='" + qtype + '\'' +
                '}';
    }
}
