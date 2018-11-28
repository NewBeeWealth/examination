package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.QuestionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * className:QuestionManageController
 * discriptoin:
 * author:llw
 * createTime:2018-11-23 19:05
 */
@Controller
@RequestMapping("question")
public class QuestionManageController {

    @Autowired
    private QuestionManageService questionManageService;
    /**
     * 跳转到创建题库界面
     * @return
     */
    @RequestMapping("toQuestion")
    public String toLogin(){
        return "teacher/question";
    }

    /**
     * 获取题库数据到数据库
     * @return
     */
    @RequestMapping("itembank")
    public String itemBank(@RequestParam Map userMap){
        questionManageService.itembank(userMap);
        return "redirect:/question/messagetest";
    }

    /**
     * 跳转到管理题库界面
     * @return
     */
    @RequestMapping("messagetest")
    public Object QuestionList(Model model){
        List<Map> maps = questionManageService.getQuestionList();
        model.addAttribute("maps",maps);
        return "teacher/messagetest";
    }

    /**
     * 删除一个题库
     * @return
     */
    @RequestMapping("questiondelete")
    public Object questionDelete(Integer id){
        questionManageService.deleteQuestion(id);
        return "redirect:/question/messagetest";
    }
    /**
     * 查询指定id题库
     * @return
     */
    @RequestMapping("questionupdate")
    public Object UpdateQuestion(Integer id,Model model){
        List<Map> maps = questionManageService.SelectByidQuestion(id);
        model.addAttribute("maps",maps);
        return "teacher/updatequestion";
    }

    /**
     * 提交更新题库
     * @return
     */
    @RequestMapping("questionedit")
    public Object questionEdit(@RequestParam Map userMap){
        return "redirect:/question/messagetest";
    }
    /**
     * 跳转到新增试题
     * @return
     */
    @RequestMapping("toAddexamination")
    public String toAddExamination(){
        return "teacher/addexamination";
    }

    /**
     * 跳转到批量导入试题
     * @return
     */
    @RequestMapping("batchadd")
    public String batchAdd(){
        return "teacher/batchadd";
    }

    /**
     * 新增试题
     * @return
     */
    @RequestMapping("addexamination")
    public String addExamination(@RequestParam Map userMap){
        questionManageService.addExamination(userMap);
        return "redirect:/question/toExamManage";
    }
    /**
     * 跳转到管理试题
     * @return
     */
    @RequestMapping("toExamManage")
    public String exammmanage(){
        return "teacher/exammanage";
    }
}
