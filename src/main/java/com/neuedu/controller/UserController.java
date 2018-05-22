package com.neuedu.controller;

import com.neuedu.service.UserService;
import com.neuedu.vo.QuserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login")
    public String login(){

        return "login";
    }

    /**表单提交登录信息*/
    @RequestMapping(value = "/login/submit")
    @ResponseBody
    public QuserVo  formsubmit(HttpServletRequest request, HttpServletResponse response){
        //获取用户名
       QuserVo quserVo= userService.findUserByUsernameAndPwd(request,response);

        return  quserVo;
    }
}
