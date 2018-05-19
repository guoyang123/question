package com.neuedu.service.impl;

import com.neuedu.dao.AnswerMapper;
import com.neuedu.entity.QAnswer;
import com.neuedu.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public void saveBatch(List<QAnswer> qAnswerList) {
        answerMapper.saveBatch(qAnswerList);
    }
}
