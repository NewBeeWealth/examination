package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.UserDao;
import com.aaa.examination.entity.userAdmin;
import com.aaa.examination.entity.userOccupation;
import com.aaa.examination.entity.userStudent;
import com.aaa.examination.entity.userTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * className:UserServiceImpl
 * discriptoin:
 * author:llw
 * createTime:2018-12-11 21:02
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public userAdmin getUser(String uname) {
        return userDao.getUser(uname);
    }

    @Override
    public userOccupation findByid(Integer id) {
        return userDao.findByid(id);
    }

    @Override
    public userTeacher getUserTeacher(String uname) {
        return userDao.getUserTeacher(uname);
    }

    @Override
    public userStudent getUserStudent(String uname) {
        return userDao.getUserStudent(uname);
    }

}
