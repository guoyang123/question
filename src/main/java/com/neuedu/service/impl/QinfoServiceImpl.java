package com.neuedu.service.impl;

import com.neuedu.consts.Const;
import com.neuedu.dao.QinfoMapper;
import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Quser;
import com.neuedu.service.QInfoService;
import com.neuedu.vo.QuserVo;
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

        Quser quser=((QuserVo)(request.getSession().getAttribute(Const.USER_FROM_SESSION))).getQuser();
        String qno=(String)request.getAttribute("qno");
        List<Qinfo> infos=null;

        if(quser!=null){
           infos= qinfoMapper.findAllByUserId(quser.getId());
           if(infos==null||infos.size()==0){
               return null;
           }
           if(qno==null||qno.equals("")){
               infos.get(0).setSelect(true);
           }else{
               for(Qinfo info:infos){
                   if(info.getQno().equals(qno)){
                       info.setSelect(true);
                   }
               }
           }


        }

        return infos;
    }

    @Override
    public int updateTotalQ(Qinfo qinfo) {
        qinfoMapper.updateTotalQ(qinfo);
        return 0;
    }
}
