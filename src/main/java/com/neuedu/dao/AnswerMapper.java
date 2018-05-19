package com.neuedu.dao;

import com.neuedu.entity.QAnswer;
import com.neuedu.entity.Quser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {
    int  saveBatch(List<QAnswer> answerList);

}

