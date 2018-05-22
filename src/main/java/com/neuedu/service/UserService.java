package com.neuedu.service;

import com.neuedu.entity.Quser;
import com.neuedu.vo.QuserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    QuserVo findUserByUsernameAndPwd(HttpServletRequest request, HttpServletResponse response);
}
