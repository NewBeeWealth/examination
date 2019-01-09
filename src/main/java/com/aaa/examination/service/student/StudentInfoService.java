package com.aaa.examination.service.student;

import java.util.List;
import java.util.Map;

public interface StudentInfoService {
    /**
     * 查询学生信息
     *
     * @return
     */
    List<Map> StudentInfo(Map map);

    /**
     * 修改信息
     *
     * @param map
     * @return
     */
    int updateinfo(Map map);
}

