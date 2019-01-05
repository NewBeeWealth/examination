package com.aaa.examination.service.teacher;

import java.util.List;
import java.util.Map;

/**
 * className:BatchStuService
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:23
 */
public interface BatchStuService {
    /**
     * ftp上传
     * @return
     */
    int add(Map map);

    /**
     * t添加路径
     * @param s
     * @return
     */
    int insertUrl(String s);

    /**
     * 查看上传
     * @return
     */
    List<Map> getUpload();
}
