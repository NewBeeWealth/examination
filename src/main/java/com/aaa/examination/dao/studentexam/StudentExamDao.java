package com.aaa.examination.dao.studentexam;


import java.util.List;
import java.util.Map;

/**
 * className:StudentExamDao
 * discriptoin:
 * author:dzq
 * createTime:2018-11-26 16:01
 */
public interface StudentExamDao {
    /**
     * 查询考试试卷
     * @param map
     * @return
     */
    List<Map> chooseExam(Map map);

    /**
     * 查询用户是否有获取试题权限
     * @param map
     * @return
     */
    List<Map> getPerson(Map map);

    /**
     * 根据试卷id查试卷信息
     * @param examId
     * @return
     */
    List<Map> examTop(Object examId);

    /**
     * 根据试卷id查询单选试题
     * @param examId
     * @return
     */
    List<Map> getSingleQuestion(Object examId);

    /**
     * 根据试卷id查询多选试题
     * @param examId
     * @return
     */
    List<Map> getMulQuestion(Object examId);

    /**
     * 根据试卷id查询判断题
     * @param examId
     * @return
     */
    List<Map> getJudgeQuestion(Object examId);

    /**
     * 查询是否答过题
     * @param map
     * @return
     */
    List<Map> getMsg(Map map);

    /**
     * 查询单选题正确答案
     * @param singleId
     * @return
     */
    List<Map> getSingleResult(int singleId);

    /**
     * 保存单项选择题答案
     * @param map
     * @return
     */
    int saveSingleAnswer(Map map);

    /**
     * 查询多选题正确答案
     * @param mulId
     * @return
     */
    List<Map> getMulResult(int mulId);

    /**
     * 保存多选题答案
     * @param map
     * @return
     */
    int saveMulAnswer(Map map);

    /**
     * 查询判断题正确答案
     * @param judgeId
     * @return
     */
    List<Map> getJudgeResult(int judgeId);

    /**
     * 保存判断题答案
     * @param map
     * @return
     */
    int saveJudgeAnswer(Map map);

    /**
     * 保存总成绩
     * @param map
     * @return
     */
    int saveTotalScore(Map map);

    /**
     * 修改试卷状态
     * @param map
     * @return
     */
    int changeState(Map map);
}
