package com.aaa.examination.service.teacher;

import com.aaa.examination.entity.userAdmin;
import com.aaa.examination.entity.userOccupation;
import com.aaa.examination.entity.userStudent;
import com.aaa.examination.entity.userTeacher;

/**
 * className:UserService
 * discriptoin:
 * author:llw
 * createTime:2018-12-11 20:51
 */
public interface UserService {

    userAdmin getUser(String uname);
    userOccupation findByid(Integer id);
    userTeacher getUserTeacher(String uname);
    userStudent getUserStudent(String uname);


}
