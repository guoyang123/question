package com.neuedu.dao;

import com.neuedu.entity.QAnswer;
import com.neuedu.entity.Quser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "answerMapper")
public interface AnswerMapper {
    int  saveBatch(List<QAnswer> answerList);
    List<QAnswer> findAllByQno(String qno);
    List<QAnswer> findAnswerByQid(int qid);
}

