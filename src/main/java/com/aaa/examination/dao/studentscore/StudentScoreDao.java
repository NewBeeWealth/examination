package com.aaa.examination.dao.studentscore;

import java.util.List;
import java.util.Map;

/**
 * className:StudentScoreDao
 * discriptoin:
 * author:dzq
 * createTime:2019-01-05 20:37
 */
public interface StudentScoreDao {
    /**
     * 获取考试名称
     * @return
     */
    List<Map> getExamName();

    /**
     * 获取每门考试的所有班级
     * @return
     */
    List<Map> getExamClass(Object examId);

    /**
     * 获取班级所有学生id
     * @param map
     * @return
     */
    List<Map> getStudentId(Map map);
    /**
     * 获取学生考试成绩
     * @param map
     * @return
     */
    List<Map> getStudentScore(Map map);
}
