package com.neuedu.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.neuedu.consts.Const;
import com.neuedu.entity.Qinfo;
import com.neuedu.entity.Question;
import com.neuedu.entity.Quser;
import com.neuedu.service.AnswerService;
import com.neuedu.service.QuestionService;
import com.neuedu.service.impl.QinfoServiceImpl;
import com.neuedu.vo.QinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 主要负责后台问卷的处理，包括保存问卷，保存编辑问卷。
 * */
@Controller
public class BackQuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QinfoServiceImpl qinfoService;
    @Autowired
    private AnswerService answerService;

    /**
     * 创建问卷调查
     * */
    @RequestMapping("/back/home")
    public String homepage(HttpSession session){
         Quser quser=new Quser();
         quser.setId(1);
         session.setAttribute(Const.USER_FROM_SESSION,quser);
        return "create";
    }
    /**
     * 进入问卷调查设计页面
     * */
    @RequestMapping("/back/designnew")
    public String designnew(HttpServletRequest request,Model model){
        System.out.println("=======designnew====");
        //问卷标题
        String qtitle= request.getParameter("qtitle");
        //用户id
        int userid=1;
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

    model.addAttribute("qinfoVo",qinfoVo);

        return "designnew";
    }




    /**
     * 获取创建的问卷信息
     * */
    @RequestMapping(value = "/questions")
    @ResponseBody
  public  String  getQuestions(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
      String ques=request.getParameter("ques");
        System.out.println("======json="+ques);
      //将Json字符串解析为数组对象
        Gson gson=new Gson();
        List<Question> questionList= gson.fromJson(ques,new TypeToken<List<Question>>() {}.getType());
         questionService.saveQuestions(questionList);

       //session中获取用户id
       Object o=session.getAttribute(Const.USER_FROM_SESSION);
        Quser quser=null;
       if(o!=null){
            quser=(Quser)o;
           request.setAttribute("quser",quser);
           request.setAttribute("qno",questionList.get(0).getQno());
       }
        List<Qinfo> qinfos= qinfoService.findAllByUserId(request);
        System.out.println("userid="+quser.getId()+" qno="+questionList.get(0).getQno()+" size="+qinfos.size());
       /**将某位用户的所有问卷查询出来*/
        session.setAttribute("qinfos",qinfos);

        return "{\"value\":1}";
  }


  @RequestMapping(value = "/findallques")
    public String findallques(){
        return "qdetail";
  }


  /**iframe提交src跳转到不同的页面*/
  @RequestMapping("/skip")
  public String  skippage(){

      return "content";
  }


  /**
   * 根据qno查询答案信息并将excel下载到本地
   * */
  @RequestMapping(value = "/{qno}/download")
  @ResponseBody
  public void download(@PathVariable("qno") String qno,HttpServletResponse response){
      System.out.println("================download==controller===");
      answerService.findAllByQno(qno,response);
     // answerService.downloadFile(response);

  }

}
