package com.aaa.examination.dao.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:QuestionManageDao
 * discriptoin:
 * author:llw
 * createTime:2018-11-24 14:15
 */
public interface QuestionManageDao {

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
     * 添加单选试题
     * @param map
     * @return
     */
    int addSingleExam(Map map);
    /**
     * 添加多选试题
     * @param map
     * @return
     */
    int addmultipleExam(Map map);

    /**
     *添加判断试题
     * @param map
     * @return
     */
    int addjudgeExam(Map map);

}
