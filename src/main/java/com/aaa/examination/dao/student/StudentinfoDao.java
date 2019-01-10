package com.aaa.examination.dao.student;

import java.util.List;
import java.util.Map;

public interface StudentinfoDao {
    /**
     * 学生信息列表
     * @return
     */
    List<Map> studentInfo(Map map);

    /**
     * 修改信息 姓名
     * @param map
     * @return
     */
    int updateinfo(Map map);

}
