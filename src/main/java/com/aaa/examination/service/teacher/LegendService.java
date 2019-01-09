package com.aaa.examination.service.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:LegendService
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-29 14:44
 */
public interface LegendService {
    /**
     * 获取班级数量信息
     * @return
     */
    List<Map> getClassCount();

    /**
     * 获取学生数量信息
     * @return
     */
    List<Map> getStuCount();

    /**
     * 获取试题信息
     * @return
     */
    List<Map> getQuestionsCount();

    /**
     * 获取题库信息
     * @return
     */
    List<Map> getBankCount();

    /**
     * 获取成绩信息
     * @return
     */
    List<Map> getScoreCount();
}
