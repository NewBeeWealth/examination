package com.aaa.examination.dao.teacher;

import com.aaa.examination.entity.userAdmin;
import com.aaa.examination.entity.userOccupation;
import com.aaa.examination.entity.userStudent;
import com.aaa.examination.entity.userTeacher;

/**
 * className:UserDao
 * discriptoin:
 * author:llw
 * createTime:2018-12-11 21:03
 */
public interface UserDao {

    userAdmin getUser(String uname);

    userOccupation findByid(Integer id);

    userTeacher getUserTeacher(String uname);

    userStudent getUserStudent(String uname);

}
