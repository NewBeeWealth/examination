package com.aaa.examination.service.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:QuestionManageService
 * discriptoin:
 * author:llw
 * createTime:2018-11-24 14:16
 */
public interface QuestionManageService {

    /**
     * 添加题库
     * @param map
     * @return
     */
    int itembank(Map map);
    /**
     * 题库列表
     * @return
     */
    List<Map> getQuestionList();
    /**
     * 删除一个题库
     * @param id
     * @return
     */
    int deleteQuestion(Integer id);
    /**
     * 查询指定题库
     * @param id
     * @return
     */
    List<Map> SelectByidQuestion(Integer id);
    /**
     * 添加试题
     * @param map
     * @return
     */
    int addExamination(Map map);
}
