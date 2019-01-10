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
     * 获取所有添加过题的题库
     * @return
     */
    List<Map> getBankName(String name);

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
     * 修改题库
     * @param map
     * @return
     */
    int bankUpdate(Map map);

    /**
     * 查询题库名称
     * @return
     */
    List<Map> selectBankName();

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

    /**
     * 获取试题列表
     * @return
     */
    List<Map> getSmjlist();

    /**
     * 查询学生列表
     * @return
     */
    List<Map> selecetclass();

    /**
     * 查询班级名称
     * @return
     */
    List<Map> selectclname(int id);

    /**
     * 查询学生名称
     * @param id
     * @return
     */
    List<Map> selectpername(int id);
    /**
     * 查询学生
     * @param id
     * @return
     */
    List<Map> selecetPerson(int id);

    /**
     * 添加试卷
     * @return
     */
    int addexam(Map userMap);

    /**
     * 添加试卷班级
     * @return
     */
    int insertexam(Map selectclname);
    /**
     * 添加试卷学生
     * @return
     */
    int insertstude(Map map);

    /**
     * 获取文件列表
     * @return
     */
    List<Map> getFtpList();

}
