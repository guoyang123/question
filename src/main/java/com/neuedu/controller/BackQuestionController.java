package com.neuedu.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Question;
import com.neuedu.entity.Quser;
import com.neuedu.service.QuestionService;
import com.neuedu.service.impl.QinfoServiceImpl;
import com.neuedu.vo.QinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 主要负责后台问卷的处理，包括保存问卷，保存编辑问卷。
 * */
@RestController
public class BackQuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QinfoServiceImpl qinfoService;

    /**
     * 获取问卷名称，并生成新的问卷
     * */
    @RequestMapping(value = "/generateQ")
    public String generateQ(HttpServletRequest request){
        //问卷标题
       String qtitle= request.getParameter("qtitle");
       //用户id
       int userid=Integer.parseInt(request.getParameter("userid"));

       //生成问卷编号
        String qno=String.valueOf(System.currentTimeMillis());

        Qinfo qinfo=new Qinfo();
        qinfo.setQno(qno);
        qinfo.setQtitle(qtitle);
        qinfo.setUserid(userid);
       int result= qinfoService.saveQinfo(qinfo);
        QinfoVo qinfoVo=null;
        if(result>0){
            System.out.println("success");
             qinfoVo=new QinfoVo(qno,qtitle,"1","成功");

        }else{
            qinfoVo=new QinfoVo(qno,qtitle,"0","创建失败");

        }
        String method=request.getParameter("callback");
       return method+"("+(new Gson().toJson(qinfoVo))+")";
   }



    /**
     * 获取创建的问卷信息
     * */
    @RequestMapping(value = "/questions")
  public  String getQuestions(HttpServletRequest request){
      String ques=request.getParameter("ques");
        System.out.println("======json="+ques);
      //将Json字符串解析为数组对象
        Gson gson=new Gson();
        List<Question> questionList= gson.fromJson(ques,new TypeToken<List<Question>>() {}.getType());
         questionService.saveQuestions(questionList);
      return "success";
  }

}
