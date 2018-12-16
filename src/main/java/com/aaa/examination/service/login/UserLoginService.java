package com.aaa.examination.service.login;

import java.util.List;
import java.util.Map;

/**
 * className:UserLoginService
 * discriptoin:
 * author:dzq
 * createTime:2018-11-24 09:51
 */
public interface UserLoginService {
    /**
     * 用户登陆
     * @param map
     * @return
     */
    List<Map> userLogin(Map map);

    List<Map> selectIndexList(String userName);
}
