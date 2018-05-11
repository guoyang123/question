package com.neuedu.dao;

import com.neuedu.entity.Question;
import com.neuedu.entity.Quser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int  save(Quser user);

}

