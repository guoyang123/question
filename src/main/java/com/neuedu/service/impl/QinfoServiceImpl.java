package com.neuedu.service.impl;

import com.neuedu.dao.QinfoMapper;
import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Quser;
import com.neuedu.service.QInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Override
    public Qinfo findByQno(String qno) {
       return qinfoMapper.findByQno(qno);

    }

    @Override
    public List<Qinfo> findAllByUserId(HttpServletRequest request) {
        Quser quser=(Quser)request.getAttribute("quser");
        String qno=(String)request.getAttribute("qno");
        List<Qinfo> infos=null;

        if(quser!=null){
           infos= qinfoMapper.findAllByUserId(quser.getId());
           for(Qinfo info:infos){
               if(info.getQno().equals(qno)){
                   info.setSelect(true);
               }
           }

        }

        return infos;
    }
}
