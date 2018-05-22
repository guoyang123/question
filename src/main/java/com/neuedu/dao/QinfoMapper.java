package com.neuedu.dao;

import com.neuedu.entity.Qinfo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "qinfoMapper")
public interface QinfoMapper {
    int  save(Qinfo qinfo);
    Qinfo findByQno(String qno);
    List<Qinfo> findAllByUserId(Integer userid);
    /**修改题量参数*/
    Integer  updateTotalQ(Qinfo qinfo);
}

