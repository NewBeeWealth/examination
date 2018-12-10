package com.aaa.examination.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:BatchStuController
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:24
 */
@Controller
@RequestMapping("/batch")
public class BatchStuController {
    /**
     * 跳转
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "teacher/BathAddSth";
    }
}
