package com.neuedu.service;

import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Question;

import java.util.List;


public interface QInfoService {
    /**保存问卷信息*/
    int saveQinfo(Qinfo qinfo);
    /**根据qno查询问卷内容*/
    Qinfo findByQno(String qno);
}
