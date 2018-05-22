package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

/**问卷类*/
public class Qinfo implements Serializable {
    private int id ;
    private String qno   ;         //问卷编号
    private String  qtitle ;//问卷标题
    private String qdesc         ;// 问卷描述
    private String createtime;
     private int        userid;//创建人
    private int totalQ;//题量

    private List<Question> questionList;
    private boolean isSelect;
    public Qinfo() {

    }

    public Qinfo(int id, String qno, String qtitle, String qdesc, int userid) {
        this.id = id;
        this.qno = qno;
        this.qtitle = qtitle;
        this.qdesc = qdesc;
        this.userid = userid;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getTotalQ() {
        return totalQ;
    }

    public void setTotalQ(int totalQ) {
        this.totalQ = totalQ;
    }

    @Override
    public String toString() {
        return "Qinfo{" +
                "id=" + id +
                ", qno='" + qno + '\'' +
                ", qtitle='" + qtitle + '\'' +
                ", qdesc='" + qdesc + '\'' +
                ", createtime='" + createtime + '\'' +
                ", userid=" + userid +
                ", totalQ=" + totalQ +
                ", questionList=" + questionList +
                ", isSelect=" + isSelect +
                '}';
    }
}
