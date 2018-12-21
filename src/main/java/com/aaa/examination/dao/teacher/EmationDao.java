package com.aaa.examination.dao.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:EmationDao
 * discriptoin:
 * author:llw
 * createTime:2018-11-29 22:16
 */
public interface EmationDao {

    int add(Map map);

    /**
     *批量添加单选
     * @param map
     * @return
     */
    int addSingle(Map map);

    /**
     * 批量添加多选
     * @param map
     * @return
     */
    int addMultiple(Map map);

    /**
     * 批量添加判断题
     * @param map
     * @return
     */
    int addJudge(Map map);

    /**
     *试卷列表
     * @return
     */
    List<Map> getExamList();

    /**
     * 获取单选试题
     * @return
     */
    List<Map>  getSingleExamList();
    /**
     * 获取多选试题
     * @return
     */
    List<Map>  getMultipleExamList();
    /**
     * 获取判断试题
     * @return
     */
    List<Map>  getJudgeExamList();

    /**
     * 获取单选题型
     * @return
     */
    List<Map> findSingleExamType(Map map);
    /**
     * 获取多选题型
     * @return
     */
    List<Map> findMultipleExamType(Map map);
    /**
     * 获取判断题型
     * @return
     */
    List<Map> findJudegeExamType(Map map);

    /**
     * 添加总分
     * @param map
     * @return
     */
    int addTotalScore(Map map);

    /**
     * 添加单选
     * @return
     */
    int addSingleExamType(Map map);
    /**
     * 添加多选
     * @return
     */
    int addMultipleExamType(Map map);
    /**
     * 添加判断
     * @return
     */
    int addJudegeExamType(Map map);

}
