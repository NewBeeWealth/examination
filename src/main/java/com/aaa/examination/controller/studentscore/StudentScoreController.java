package com.aaa.examination.controller.studentscore;

import com.aaa.examination.service.studentscore.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:StudentScoreController
 * discriptoin:
 * author:dzq
 * createTime:2019-01-07 10:58
 */
@Controller
@RequestMapping("score")
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;

    /**
     * 获取每场考试的所有班级
     * @param model
     * @return
     */
    @RequestMapping("getExamClass")
    public String getExamClass(Model model){
        List<Map> examClass = studentScoreService.getExamClass();
        System.out.println(examClass);
        model.addAttribute("examClassList",examClass);
        return "studentscore/studentScore";
    }

    /**
     * 获取班级所有学生成绩
     * @param model
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("getScoreDetail")
    public String getScoreDetail(Model model, HttpServletRequest request, @RequestParam Map map){
        String classId = request.getParameter("classId");
        String examId = request.getParameter("examId");
        map.put("classId",classId);
        map.put("examId",examId);
        System.out.println(map);
        List<Map> studentScoreList = studentScoreService.getStudentScore(map);
        System.out.println("***"+studentScoreList);
        model.addAttribute("studentScoreList",studentScoreList);
        return "studentscore/scoreDetail";
    }
}
