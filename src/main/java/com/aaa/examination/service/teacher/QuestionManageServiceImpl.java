package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.QuestionManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:QuestionManageServiceImpl
 * discriptoin:
 * author:llw
 * createTime:2018-11-24 14:16
 */
@Service
public class QuestionManageServiceImpl implements QuestionManageService{

    @Autowired
    private QuestionManageDao questionManageDao;

    @Override
    public int itembank(Map map) {
        return questionManageDao.itembank(map);
    }

    @Override
    public List<Map> getQuestionList() {
        return questionManageDao.getQuestionList();
    }

    @Override
    public int deleteQuestion(Integer id) {
        return questionManageDao.deleteQuestion(id);
    }

    @Override
    public List<Map> SelectByidQuestion(Integer id) {
        return questionManageDao.SelectByidQuestion(id);
    }

    @Override
    public int addExamination(Map map) {
        if(map.get("qutype").equals("0")){//单选
            map.put("qutype","单选");
            questionManageDao.addSingleExam(map);
        }else if(map.get("qutype").equals("1")){//多选
            map.put("qutype","多选");
            questionManageDao.addmultipleExam(map);
        }else {//判断
            map.put("qutype","判断");
            questionManageDao.addjudgeExam(map);
        }
        return 0;
    }
}
