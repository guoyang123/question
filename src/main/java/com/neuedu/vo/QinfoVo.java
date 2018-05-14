package com.neuedu.vo;



import java.io.Serializable;
/**
 * 创建问卷后返回前端的vo类
 *
 * */
public class QinfoVo implements Serializable {

    private String qno;//编号
    private String qtitle;//问卷标题
    private String result;// 1:succ 0:fail
    private String message;//失败信息

    public QinfoVo() {

    }
    public QinfoVo(String qno, String qtitle, String result, String message) {
        this.qno = qno;
        this.qtitle = qtitle;
        this.result = result;
        this.message = message;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "QinfoVo{" +
                "qno='" + qno + '\'' +
                ", qtitle='" + qtitle + '\'' +
                ", result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
