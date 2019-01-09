package com.aaa.examination.dao.teacher;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:BatchStuDao
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:59
 */
public interface BatchStuDao {

    /**
     * 学生添加
     * @param map
     * @return
     */
    int addStu(Map map);


}

