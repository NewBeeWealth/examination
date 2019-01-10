package com.aaa.examination.service.teacher;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:EmationService
 * discriptoin:
 * author:llw
 * createTime:2018-11-29 22:16
 */
public interface EmationService {

    /**
     * 批量添加
     * @param file
     * @return
     */
    Map batchAdd(MultipartFile file,Map usermap);
    /**
     *试卷列表
     * @return
     */
    List<Map> getExamList();
    /**
     * 获取配置过的试卷
     * @param examId
     * @return
     */
    List<Map> getOKExam(Object examId);

    /**
     * 查询所有题库名称
     * @return
     */
    List<Map> getAllBank();
    /**
     * 删除试卷
     * @param id
     * @return
     */
    int delexam(Integer id);
    /**
     * 根据id获取试卷信息
     * @param id
     * @return
     */
    List<Map> getExamById(Integer id);

    /**
     * 修改试卷
     * @param map
     * @return
     */
    int examUpdate(Map map);
    /**
     * 获取单选试题
     * @return
     */
    List<Map>  getSingleExamList(Map map);
    /**
     * 获取多选试题
     * @return
     */
    List<Map>  getMultipleExamList(Map map);
    /**
     * 获取判断试题
     * @return
     */
    List<Map>  getJudgeExamList(Map map);

    /**
     * 添加成绩
     * @param map
     * @return
     */
    int addscore(Map map, HttpSession session);

}
