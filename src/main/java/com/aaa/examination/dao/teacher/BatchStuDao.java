package com.aaa.examination.dao.teacher;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
    int add(Map map);

    /**
     * 获取文件列表
     * @return
     */
    List<Map> getFtpList();

    /**
     * t添加路径
     * @param s
     * @return
     */
    @Insert({"<script>insert into TBL_UPLOAD(id,name,url) values(exam_exam.nextval,exam_exam.nextval,#{s})\n</script>"})
    int insertUrl(String s);

    /**
     * 查看上传
     * @return
     */
    @Select({"<script>select name,url from TBL_UPLOAD</script>"})
    List<Map> getUpload();


}

