package com.neuedu.service.impl;

import com.google.gson.Gson;
import com.neuedu.consts.Const;
import com.neuedu.dao.UserMapper;
import com.neuedu.entity.Quser;
import com.neuedu.service.UserService;
import com.neuedu.vo.QuserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.pa.CurrencyNames_pa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public QuserVo findUserByUsernameAndPwd(HttpServletRequest request, HttpServletResponse response) {

        QuserVo quserVo=new QuserVo();
       String quserinfo= request.getParameter("quser");
       Gson gson=new Gson();
       Quser quser=gson.fromJson(quserinfo,Quser.class);

        String username=quser.getUsername();
        String password=quser.getPassword();

        if(username==null||username.equals("")||password==null||password.equals("")){
            quserVo.setResultCode(-1);
            quserVo.setMsg("用户名或者密码不 能为空");
        }else{ //根据用户名或密码查询用户

            quser =userMapper.findUserByUsernameAndPwd(quser);
             if(quser!=null){
                 quserVo.setResultCode(1);
                 quserVo.setMsg("登录成功");
                 quser.setPassword("");
                 quserVo.setQuser(quser);
             }else{
                 quserVo.setResultCode(-1);
                 quserVo.setMsg("用户名或者密码错误");
             }
        }

        request.getSession().setAttribute(Const.USER_FROM_SESSION,quserVo);
        return quserVo;
    }
}
