package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

/**问卷类*/
public class Qinfo implements Serializable {
    private int id ;
    private String qno   ;         //问卷编号
    private String  qtitle ;//问卷标题
    private String qdesc         ;// 问卷描述
     private int        userid;//创建人

    private List<Question> questionList;

    public Qinfo() {

    }

    public Qinfo(int id, String qno, String qtitle, String qdesc, int userid) {
        this.id = id;
        this.qno = qno;
        this.qtitle = qtitle;
        this.qdesc = qdesc;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQno() {
        return qno;
    }

    public void setQno(String qno) {
        this.qno = qno;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public String getQdesc() {
        return qdesc;
    }

    public void setQdesc(String qdesc) {
        this.qdesc = qdesc;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Qinfo{" +
                "id=" + id +
                ", qno='" + qno + '\'' +
                ", qtitle='" + qtitle + '\'' +
                ", qdesc='" + qdesc + '\'' +
                ", userid=" + userid +
                ", questionList=" + questionList +
                '}';
    }
}
