package com.neuedu.controller;

import com.neuedu.entity.Qinfo;
import com.neuedu.service.impl.QinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/front")
public class FrontQuestionController {

    @Autowired
    private QinfoServiceImpl qinfoService;
    @RequestMapping(value = "/generate/{qno}")
    public String  frontQ(@PathVariable("qno") String qno,Model model){
        //根据qno查询问卷内容
         Qinfo qinfo= qinfoService.findByQno(qno);
        System.out.println(qinfo);
        model.addAttribute("qinfo",qinfo);

        return "front";
    }

    /**接受表单数据*/
    @RequestMapping(value = "/answer")
    public  String answer(HttpServletRequest request){


        return "";
    }

}
