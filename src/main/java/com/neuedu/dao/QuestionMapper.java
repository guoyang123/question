package com.neuedu.dao;

import com.neuedu.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "questionMapper")
public interface QuestionMapper {
    void saveQues(List<Question> questionList);
    List<Question> findAllByQno(String qno);
}
