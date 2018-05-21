package com.neuedu.dao;

import com.neuedu.entity.Question;
import com.neuedu.entity.Quser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    int  save(Quser user);

}

