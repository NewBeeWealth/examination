package com.aaa.examination.service.historyexam;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryExamService
 * discriptoin:
 * author:dzq
 * createTime:2018-12-04 16:57
 */
public interface HistoryExamService {
    /**
     * 查询所有历史考试
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 根据试卷id查试卷信息
     * @param map
     * @return
     */
    List<Map> examTop(Map map);

    /**
     * 根据试卷id查询历史试卷单选题
     * @param map
     * @return
     */
    List<Map> getSingleDetail(Map map);
    /**
     * 根据试卷id查询历史试卷多选题
     * @param map
     * @return
     */
    List<Map> getMulDetail(Map map);
    /**
     * 根据试卷id查询历史试卷判断题
     * @param map
     * @return
     */
    List<Map> getJudgeDetail(Map map);
}
