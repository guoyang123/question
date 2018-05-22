package com.neuedu.service;

import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Question;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface QInfoService {
    /**保存问卷信息*/
    int saveQinfo(Qinfo qinfo);
    /**根据qno查询问卷内容*/
    Qinfo findByQno(String qno);
    /**根据userid查询该用户所有的问卷信息*/
    List<Qinfo> findAllByUserId(HttpServletRequest request);
    /**修改题量*/
    int  updateTotalQ(Qinfo qinfo);
}
