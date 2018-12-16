package com.aaa.examination.service.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:StuadmService
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-05 15:23
 */
public interface StuadmService {

        /**
         * 获取学生列表
         * @return
         */
        List<Map> getStuList(Map map);
        /**
         * 查询分页总数量
         * @param map
         * @return
         */
        int getPageCount(Map map);

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
         * 批量删除
         * @param ids
         * @return
         */
        int batchDelete(String ids);

        /**
         * 获取班级列表
        * @param map
       * @return
             */
        List<Map> getClassList( );

    }

