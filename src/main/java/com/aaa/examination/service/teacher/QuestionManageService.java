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
     * 添加试题
     * @param map
     * @return
     */
    int addExamination(Map map);
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
    List<Map> selectclname(String id);

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    List<Map> selectpename(String id);
    /**
     * 查询学生
     * @param id
     * @return
     */
    List<Map> selecetPerson(int id);

    /**
     * 提交试卷
     * @return
     */
    int submitPapers(Map userMap,List<Map> selectclname,List<Map> selectpername);
    /**
     * 获取文件列表
     * @return
     */
    List<Map> getFtpList();
}
