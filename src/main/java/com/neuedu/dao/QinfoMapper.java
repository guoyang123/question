package com.neuedu.dao;

import com.neuedu.entity.Qinfo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QinfoMapper {
    int  save(Qinfo qinfo);
    Qinfo findByQno(String qno);
    List<Qinfo> findAllByUserId(Integer userid);
}

