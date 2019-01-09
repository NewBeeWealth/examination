package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.LegendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:LegendServiceImpl
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-29 14:45
 */
@Service
public class LegendServiceImpl implements  LegendService{
    //依赖注入
    @Autowired
    private LegendDao legendDao;

    /**
     * 班级
     * @return
     */
    @Override
    public List<Map> getClassCount() {
        return legendDao.getClassCount();
    }

    /**
     * 学生
     * @return
     */
    @Override
    public List<Map> getStuCount() {
        return legendDao.getStuCount();
    }

    /**
     * 试题
     * @return
     */
    @Override
    public List<Map> getQuestionsCount() {
        return legendDao.getQuestionsCount();
    }

    /**
     * 题库
     * @return
     */
    @Override
    public List<Map> getBankCount() {
        return null;
    }

    /**
     * 成绩
     * @return
     */
    @Override
    public List<Map> getScoreCount() {
        return legendDao.getScoreCount();
    }
}
