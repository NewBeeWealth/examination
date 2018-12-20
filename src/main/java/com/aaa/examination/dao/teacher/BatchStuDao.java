package com.aaa.examination.dao.teacher;

import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * className:BatchStuDao
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:59
 */
public interface BatchStuDao {

    /**
     * ftp上传
     * @return
     */
    @Insert("insert into tbl_addexcel(FILE_ID,FILE_PATH,FILE_NAME) values(file_excel.nextval,#{filePath},#{fileName})")
    int add(Map map);

    /**
     * 获取文件列表
     * @return
     */
    List<Map> getFtpList();
}

