package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.EmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * className:emation
 * discriptoin:
 * author:llw
 * createTime:2018-11-29 22:12
 */
@Controller
@RequestMapping("exam")
public class EmationController {

    @Autowired
    private EmationService emationService;

    /**
     * 批量导入
     * @return
     */
    @RequestMapping("/batchAdd")
    public String batchAdd(@RequestParam MultipartFile excelFile,@RequestParam Map userMap){
        emationService.batchAdd(excelFile,userMap);
        return "/teacher/exammanage1";
    }

    /**
     * 跳转到管理试卷
     * @return
     */
    @RequestMapping("messageexamination")
    public Object messageExamination(Model model){
        List<Map> examList = emationService.getExamList();
        model.addAttribute("maps",examList);
        return "teacher/messageexamination";
    }
    /**
     * 跳转到添加试卷
     * @return
     */
    @RequestMapping("addexamination")
    public Object addexamination(int id,Model model){
        List<Map> singleList = emationService.getSingleExamList();//单选题
        List<Map> multipleList = emationService.getMultipleExamList();//多选
        List<Map> judgeList = emationService.getJudgeExamList();//判断

        model.addAttribute("singleList",singleList);
        model.addAttribute("multipleList",multipleList);
        model.addAttribute("judgeList",judgeList);
        model.addAttribute("tempid",id);
        return "addexam/addexamination";
    }

    /**
     * 跳转到管理试卷
     * @return
     */
    @RequestMapping("submitexamination")
    public Object submitExamination(@RequestParam Map userMap){
        emationService.addscore(userMap);
        return "redirect:/exam/messageexamination";
    }

}
