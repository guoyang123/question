package com.neuedu.vo;

import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Quser;

public class QuserVo {

    private int  resultCode;
    private String  msg;
    private Quser quser;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Quser getQuser() {
        return quser;
    }

    public void setQuser(Quser quser) {
        this.quser = quser;
    }

    @Override
    public String toString() {
        return "QuserVo{" +
                "resultCode=" + resultCode +
                ", msg='" + msg + '\'' +
                ", quser=" + quser +
                '}';
    }
}
