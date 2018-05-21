package com.neuedu.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neuedu.entity.QAnswer;
import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Question;
import com.neuedu.service.AnswerService;
import com.neuedu.service.impl.QinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/front")
public class FrontQuestionController {

    @Autowired
    private QinfoServiceImpl qinfoService;

    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "/generate/{qno}")
    public String  frontQ(@PathVariable("qno") String qno,Model model){
        //根据qno查询问卷内容
         Qinfo qinfo= qinfoService.findByQno(qno);
        System.out.println(qinfo);
        model.addAttribute("qinfo",qinfo);

        return "front";
    }

    /**接受表单数据，提交Json数据*/
    @RequestMapping(value = "/answer")
    @ResponseBody
    public  String answer(HttpServletRequest request){
        System.out.println("==================anser=");
        Gson  gson=new Gson();
        List<QAnswer> list=gson.fromJson(request.getParameter("answers"),new TypeToken<List<QAnswer>>(){}.getType());

        //获取客户端ip地址
        String ip= request.getRemoteAddr();
        if(list!=null&&list.size()>0){
            for(QAnswer answer:list){
                answer.setUserip(ip);
            }
        }
        answerService.saveBatch(list);

        return "{\"success\":1}";
    }
}
