package com.aaa.examination.dao.student;

import java.util.List;
import java.util.Map;

public interface UpdatePwdDao {
    /**
     * 查询密码
     */
    List<Map> selectPwd(Map map);

    /**
     * 修改语句
     * @return
     */
    int updatePwd(Map map);

}
