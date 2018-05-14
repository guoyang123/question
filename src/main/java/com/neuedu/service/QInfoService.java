package com.neuedu.service;

import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Question;

import java.util.List;


public interface QInfoService {
    /**保存问卷信息*/
    int saveQinfo(Qinfo qinfo);
}
