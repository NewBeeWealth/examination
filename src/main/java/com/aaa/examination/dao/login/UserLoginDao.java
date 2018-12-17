package com.aaa.examination.dao.login;

import java.util.List;
import java.util.Map;

/**
 * className:UserLoginDao
 * discriptoin:
 * author:dzq
 * createTime:2018-11-24 09:43
 */
public interface UserLoginDao {
    /**
     * 管理员登陆
     * @param map
     * @return
     */
    List<Map> adminLogin(Map map);

    /**
     * 教师登陆
     * @param map
     * @return
     */
    List<Map> teacherLogin(Map map);
    /**
     * 学生登录
     * @param map
     * @return
     */
    List<Map> studentLogin(Map map);

    List<Map> selectAdminList(String username);
    List<Map> selectTeacherList(String username);
    List<Map> selectStudentList(String username);
    List<Map> getChildrensByPid(int id);
}
