package com.neuedu.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neuedu.entity.Question;
import com.neuedu.service.QuestionService;
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
    /**
     * 获取后台信息
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
