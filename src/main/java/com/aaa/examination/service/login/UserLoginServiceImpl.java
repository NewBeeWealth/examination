package com.aaa.examination.service.login;

import com.aaa.examination.dao.login.UserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserLoginServiceImpl
 * discriptoin:
 * author:dzq
 * createTime:2018-11-24 09:58
 */
@SuppressWarnings("all")
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

    @Override
    public List<Map> selectIndexList(String userName) {
        List<Map> maps = userLoginDao.selectAdminList(userName);
        List<Map> maps1 = userLoginDao.selectTeacherList(userName);
        List<Map> maps2 = userLoginDao.selectStudentList(userName);
        System.out.println(maps1);
        List<Map> tempList=new ArrayList<Map>();
        Map tempmap=null;
        if(maps!=null&&maps.size()>0){//管理员
            for(int i=0;i<maps.size();i++){
                tempmap=new HashMap();
                if(0==Integer.valueOf(maps.get(i).get("FUNCTION_CODING")+"")){
                    tempList.add(maps.get(i));
                }else{
                    tempmap.put("children",maps.get(i));
                }
                tempList.add(tempmap);
            }
            return tempList;
        }
        if(maps1!=null&&maps1.size()>0){//老师
            for(int i=0;i<maps1.size();i++){
                tempmap=new HashMap();
                if(0==Integer.valueOf(maps1.get(i).get("FUNCTION_CODING")+"")){
                    tempList.add(maps1.get(i));
                }else{
                    tempmap.put("children",maps1.get(i));
                }
                tempList.add(tempmap);
            }
            return tempList;
        }
        if(maps2!=null&&maps2.size()>0){//学生
            for(int i=0;i<maps2.size();i++){
                tempmap=new HashMap();
                if(0==Integer.valueOf(maps2.get(i).get("FUNCTION_CODING")+"")){
                    tempList.add(maps2.get(i));
                }else{
                    tempmap.put("children",maps2.get(i));
                }
                tempList.add(tempmap);
            }
            return tempList;
        }
        return null;
    }

}
