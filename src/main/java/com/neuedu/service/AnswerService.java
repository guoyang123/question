package com.neuedu.service;

import com.neuedu.entity.QAnswer;
import com.neuedu.entity.Question;

import java.util.List;


public interface AnswerService {
    /**保存问卷信息*/
    void saveBatch(List<QAnswer> qAnswerList);
}
