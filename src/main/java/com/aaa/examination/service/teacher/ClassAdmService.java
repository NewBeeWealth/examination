package com.aaa.examination.service.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:ClassAdmService
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-21 09:58
 */
public interface ClassAdmService {
    /**
     * 获取班级列表
     * @return
     */
    List<Map> getClassList(Map map);
    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

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
     * @param CLASSID
     * @return
     */
    int deleteClass(Integer CLASSID);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(String ids);

    /**
     * 获取状态列表
     * @return
     */
    List<Map> getStateList( );
}
