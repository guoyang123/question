package com.neuedu.service.impl;

import com.neuedu.dao.QuestionMapper;
import com.neuedu.entity.Question;
import com.neuedu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{


    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public void saveQuestions(List<Question> questionList) {
       questionMapper.saveQues(questionList);
    }
}
