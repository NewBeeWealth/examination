package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.BatchStuService;
import com.aaa.examination.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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
     * 添加使用ftp 上传
     * @param map
     * @return
     */
    @RequestMapping("/addUseFtp")
    public String addUseFtp(@RequestParam Map map, @RequestParam MultipartFile pic){
        if(pic!=null&&!pic.isEmpty()){
            //String s = FileUtil.uploadFile(filePath, pic);
            final String s =  FtpUtil.upLoad(pic);
            map.put("filePath",s);
            map.put("fileName",pic.getOriginalFilename());
        }
        batchStuService.add(map);
        return "redirect:/question/batchadd";
    }
}
