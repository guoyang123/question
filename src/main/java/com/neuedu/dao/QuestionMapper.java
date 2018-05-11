package com.neuedu.dao;

import com.neuedu.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface QuestionMapper {
    void saveQues(List<Question> questionList);
}
