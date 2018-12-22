package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.BatchStuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:BatchStuServiceImpl
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:23
 */
@Service
public class BatchStuServiceImpl implements BatchStuService{
    @Autowired
    private BatchStuDao batchStuDao;

    @Override
    public int add(Map map) {
        return batchStuDao.add(map);
    }
}
