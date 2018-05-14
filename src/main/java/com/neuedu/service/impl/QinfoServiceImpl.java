package com.neuedu.service.impl;

import com.neuedu.dao.QinfoMapper;
import com.neuedu.entity.Qinfo;
import com.neuedu.service.QInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 生成问卷信息服务类
 * */
@Service
public class QinfoServiceImpl implements QInfoService {

    @Autowired
    private QinfoMapper qinfoMapper;
    @Override
    public int saveQinfo(Qinfo qinfo) {

       return  qinfoMapper.save(qinfo);
    }
}
