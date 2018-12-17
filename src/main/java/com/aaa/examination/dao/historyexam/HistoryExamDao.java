package com.aaa.examination.dao.historyexam;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryExamDao
 * discriptoin:
 * author:dzq
 * createTime:2018-12-04 16:57
 */
public interface HistoryExamDao {
    /**
     * 获取所有历史考试
     * @param map
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 查询已经考过的试卷的id
     * @param map
     * @return
     */
    List<Map> getExamId(Map map);

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
