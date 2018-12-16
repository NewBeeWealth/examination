package com.aaa.examination.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:TestController
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-11 14:32
 */
@Controller
@RequestMapping("/test")
public class TestController {
    /**
     * 跳转
     * @return
     */
    @RequestMapping("/toTest")
    public String toList(){
        return "login/MyHomePage";
    }
}
