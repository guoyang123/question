package com.neuedu.entity;

import java.io.Serializable;

public class Question implements Serializable{
    private Integer id;
    //题目标题
    private String title;
    //题目类型
    private String qtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + qtype + '\'' +
                '}';
    }
}
