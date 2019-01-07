package com.aaa.examination.service.teacher;

import org.springframework.web.multipart.MultipartFile;

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
     * 部门添加
     * @param map
     * @return
     */
    int addStu(Map map);

    /**
     * 批量添加
     * @param file
     * @return
     */
    Map batchAddStu(MultipartFile file);
}
