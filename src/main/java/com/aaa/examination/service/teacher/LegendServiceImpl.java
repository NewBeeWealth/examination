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

    @Override
    public List<Map> getClassCount() {
        return null;
    }

    @Override
    public List<Map> getStuCount() {
        return null;
    }

    @Override
    public List<Map> getQuestionsCount() {
        return null;
    }

    @Override
    public List<Map> getScoreCount() {
        return null;
    }
}
