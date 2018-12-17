package com.aaa.examination.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:userController
 * discriptoin:
 * author:llw
 * createTime:2018-12-11 20:56
 */
@Controller
@RequestMapping("/user")
public class userController {

    /*@RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("name","HelloWorld");
        return "shiro/test";
    }

    @RequestMapping("/Auth")
    public String noAuth(){
        return "shiro/noAuth";
    }*/
    /*
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //使用shiro编写认证
        //Subject subject=SecurityUtils.getSubject();
        //封装用户数据
        //UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        //执行登录方法
       *//* try {
            subject.login(token);
            return "redirect:/user/testThymeleaf";
        } catch (UnknownAccountException e) {
//            e.printStackTrace();
            model.addAttribute("msg","用户名不存在");
            return "shiro/login";
        }catch (IncorrectCredentialsException e) {
//            e.printStackTrace();
            model.addAttribute("msg","密码错误");
            return "shiro/login";
        }*//*
       return null;
    }*/


}
