package com.aaa.examination.service.studentexam;

import java.util.List;
import java.util.Map;

/**
 * className:StudentExamService
 * discriptoin:
 * author:dzq
 * createTime:2018-11-26 16:25
 */
public interface StudentExamService {
    /**
     * 查询考试试卷
     * @param map
     * @return
     */
    List<Map> chooseExam(Map map);

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
     * 保存单项选择题答案
     * @param silId
     * @param silAnswer
     * @param stuId
     * @return
     */
    int saveSingleAnswer(String silId,Object silAnswer,Object stuId,Object examId,Object singleScore);

    /**
     * 保存多选题答案
     * @param mlId
     * @param mulAnswer
     * @param stuId
     * @return
     */
    int saveMulAnswer(String mlId,String mulAnswer,Object stuId,Object examId,Object mulScore);

    /**
     * 保存判断题答案
     * @param jdeId
     * @param jdeAnswer
     * @param stuId
     * @return
     */
    int saveJudgeAnswer(String jdeId,Object jdeAnswer,Object stuId,Object examId,Object judgeScore);

    /**
     * 保存总成绩
     * @param studentId
     * @param examId
     * @param totalScore
     * @return
     */
    int saveTotalScore(Object studentId,Object examId,int totalScore);
}
