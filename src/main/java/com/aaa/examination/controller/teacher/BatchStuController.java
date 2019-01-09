package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.BatchStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * className:BatchStuController
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:24
 */
@Controller
@RequestMapping("/batch")
public class BatchStuController {
    @Autowired
   private BatchStuService batchStuService;


    /**
     * 跳转
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "teacher/batchAddStu";
    }

    /**
     * 批量导入
     * @return
     */
    @RequestMapping("/batchAdd")
    public String batchAdd(@RequestParam MultipartFile excelFile){
        batchStuService.batchAddStu(excelFile);
        return "redirect:toList";
    }

}
