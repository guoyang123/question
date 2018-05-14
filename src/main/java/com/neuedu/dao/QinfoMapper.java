package com.neuedu.dao;

import com.neuedu.entity.Qinfo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QinfoMapper {
    int  save(Qinfo qinfo);
    Qinfo findByQno(String qno);

}

