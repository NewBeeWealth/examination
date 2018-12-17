package com.aaa.examination.shiro;

import com.aaa.examination.entity.user;
import com.aaa.examination.entity.userOccupation;
import com.aaa.examination.entity.userStudent;
import com.aaa.examination.entity.userTeacher;
import com.aaa.examination.service.teacher.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * className:UserRealm
 * discriptoin:过滤配置
 * author:llw
 * createTime:2018-12-11 20:45
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();

       /* user user=(user) subject.getPrincipal();
        userOccupation dbUser=userService.findByid(Integer.valueOf(user.getAdminstate()));*/

        userTeacher userTeacher=(userTeacher) subject.getPrincipal();
        userOccupation dbUser1=userService.findByid(Integer.valueOf(userTeacher.getTeacherstate()));

        System.out.println(dbUser1+"--------------");
        //dbUser.getPerms();
        // info.addRole("userA");
        info.addStringPermission(dbUser1.getOccstate());
        return info;
    }

    @Autowired
    private UserService userService;
    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        System.out.println(token.getUsername());
        String value1=token.getUsername();
        user user=userService.getUser(value1);
        if(user!=null){
            //管理员
            return  new SimpleAuthenticationInfo(user,user.getAdminpwd(),"");
        }
        userTeacher userTeacher = userService.getUserTeacher(value1);
        if(userTeacher!=null){
            //老师
            return new SimpleAuthenticationInfo(userTeacher,userTeacher.getTeacherpwd(),"");
        }
        userStudent userStudent = userService.getUserStudent(value1);
        if(userStudent!=null){
            //学生
            return new SimpleAuthenticationInfo(userStudent,userStudent.getStudentpwd(),"");
        }
        return null;
    }
}
