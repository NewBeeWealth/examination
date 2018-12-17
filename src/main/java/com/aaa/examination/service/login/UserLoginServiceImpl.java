package com.aaa.examination.service.login;

import com.aaa.examination.dao.login.UserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:UserLoginServiceImpl
 * discriptoin:
 * author:dzq
 * createTime:2018-11-24 09:58
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{
    @Autowired
    UserLoginDao userLoginDao;

    @Override
    public List<Map> userLogin(Map map) {
        List<Map> userList = null;
        if(map!=null&&map.size()>0){
            Integer role = Integer.valueOf(map.get("role")+"");
            if (role==1){
                userList = userLoginDao.adminLogin(map);
            }else if (role==2){
                userList = userLoginDao.teacherLogin(map);
            }else {
                userList = userLoginDao.studentLogin(map);
                Object student_id = userList.get(0).get("STUDENT_ID");
                userList.get(0).put("studentId",student_id);
            }
        }
        return userList;
    }
}
