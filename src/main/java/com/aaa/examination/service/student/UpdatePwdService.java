package com.aaa.examination.service.student;

import java.util.List;
import java.util.Map;

public interface UpdatePwdService {
    /**
     * 查询密码
     */
    List<Map> selectPwd(Map map);

    /**
     * 修改密码
     * @return
     */
    int updatePwd(Map map);

}
