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
     * 添加成绩
     * @param map
     * @return
     */
    int addscore(Map map, HttpSession session);

}
