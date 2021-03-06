package com.neuedu.service;

import com.neuedu.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {
    /**保存问卷信息*/
    void saveQuestions(List<Question> questionList);
    /**根据qno查询问题*/
    List<Question> findAllByQno(String qno);
}
