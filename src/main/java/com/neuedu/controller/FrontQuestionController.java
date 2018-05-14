package com.neuedu.controller;

import com.neuedu.entity.Qinfo;
import com.neuedu.service.impl.QinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/front")
public class FrontQuestionController {

    @Autowired
    private QinfoServiceImpl qinfoService;
    @RequestMapping(value = "/generate/{qno}")
    public String  frontQ(@PathVariable("qno") String qno){
        //根据qno查询问卷内容
         Qinfo qinfo= qinfoService.findByQno(qno);
        System.out.println(qinfo);
        return "front";
    }

}
