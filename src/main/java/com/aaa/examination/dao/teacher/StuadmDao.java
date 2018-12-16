package com.aaa.examination.dao.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:StuadmDao
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-05 13:33
 */
public interface StuadmDao {
    /**
     * 获取学生列表
     * @return
     */
    List<Map> getStuList(Map map);

    /**
     * 添加学生
     * @param map
     * @return
     */
    int  addStu(Map map);

    /**
     * 学生修改
     * @param map
     * @return
     */
    int updateStu(Map map);

    /**
     * 学生删除
     * @param STUDENT_ID
     * @return
     */
    int deleteStu(Integer STUDENT_ID);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 获取班级列表
     * @return
     */
    List<Map> getClassList();

}
