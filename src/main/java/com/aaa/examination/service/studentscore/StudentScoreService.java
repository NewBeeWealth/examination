package com.aaa.examination.service.studentscore;

import java.util.List;
import java.util.Map;

/**
 * className:StudentScoreService
 * discriptoin:
 * author:dzq
 * createTime:2019-01-07 09:58
 */
public interface StudentScoreService {
    /**
     * 获取每场考试的所有班级
     * @return
     */
    List<Map> getExamClass();
    /**
     * 获取学生考试成绩
     * @param map
     * @return
     */
    List<Map> getStudentScore(Map map);
}
