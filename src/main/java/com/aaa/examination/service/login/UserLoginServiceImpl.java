package com.aaa.examination.service.login;

import com.aaa.examination.dao.login.UserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            }
        }
        return userList;
    }

    @Override
    public List<Map> selectIndexList(String userName) {
        List<Map> maps = userLoginDao.selectAdminList(userName);
        List<Map> maps1 = userLoginDao.selectTeacherList(userName);
        List<Map> maps2 = userLoginDao.selectStudentList(userName);
        List<Map> tempList=new ArrayList<Map>();
        Map tempmap=null;
        if(maps!=null&&maps.size()>0){//管理员
            /*for(int i=0;i<maps.size();i++){
                tempmap=new HashMap();
                if(0==Integer.valueOf(maps.get(i).get("FUNCTION_CODING")+"")){
                    tempList.add(maps.get(i));
                }else{
                    for (Map map : maps) {
                        int functionid = Integer.valueOf((map.get("FUNCTION_ID") + ""));
                        map.put("childList",userLoginDao.getChildrensByPid(functionid));
                    }
                }
                tempList.add(tempmap);
            }*/
            return maps;
        }

        if(maps1!=null&&maps1.size()>0){//老师
            /*for(int i=0;i<maps1.size();i++){
                tempmap=new HashMap();
                if(0==Integer.valueOf(maps1.get(i).get("FUNCTION_CODING")+"")){
                    tempList.add(maps1.get(i));
                }
                if(1==Integer.valueOf(maps1.get(i).get("FUNCTION_CODING")+"")){
                    for (Map map : maps1) {
                        int functionid = Integer.valueOf((map.get("FUNCTION_ID") + ""));
                        tempmap.put("childList",userLoginDao.getChildrensByPid(functionid));
                        i++;
                    }
                }
                tempList.add(tempmap);
            }*/
            return maps1;
        }

        if(maps2!=null&&maps2.size()>0){//学生
            /*for(int i=0;i<maps2.size();i++){
                tempmap=new HashMap();
                if(0==Integer.valueOf(maps2.get(i).get("FUNCTION_CODING")+"")){
                    tempList.add(maps2.get(i));
                }else{
                    for (Map map : maps2) {
                        int functionid = Integer.valueOf((map.get("FUNCTION_ID") + ""));
                        map.put("childList",userLoginDao.getChildrensByPid(functionid));
                    }
                }
                tempList.add(tempmap);
            }*/
            return maps2;
        }
        return null;
    }

}
