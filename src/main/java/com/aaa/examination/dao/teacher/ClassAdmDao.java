package com.aaa.examination.dao.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:ClassAdmDao
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-21 09:58
 */
public interface ClassAdmDao {
    /**
     * 获取班级列表
     * @return
     */
    List<Map> getClassList(Map map);

    /**
     * 添加班级
     * @param map
     * @return
     */
    int  addClass(Map map);

    /**
     * 班级修改
     * @param map
     * @return
     */
    int updateClass(Map map);

    /**
     * 班级删除
     * @param STUDENT_ID
     * @return
     */
    int deleteClass(Integer STUDENT_ID);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 获取状态列表
     * @return
     */
    List<Map> getStateList();
}
