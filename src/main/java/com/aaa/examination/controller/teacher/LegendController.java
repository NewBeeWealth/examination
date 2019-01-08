package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.LegendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:LegendController
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-29 14:47
 */
@Controller
@RequestMapping("/legend")
public class LegendController {
    //依赖注入
    @Autowired
    private LegendService legendService;
    /**
     * 跳转班级
     * @return
     */
    @RequestMapping("/toClassLegend")
    public String toListC(){
        return "teacher/classLegend";
    }

    /**
     * 跳转学生
     * @return
     */
    @RequestMapping("/toStuLegend")
    public String toListS(){
        return "teacher/stuImgLegend";
    }

    /**
     * 跳转试题
     * @return
     */
    @RequestMapping("/toQuestionLegend")
    public String toListQ(){
        return "teacher/questionLegend";
    }

    /**
     * 跳转成绩
     * @return
     */
    @RequestMapping("/toScoreLegend")
    public String toListSC(){
        return "teacher/scoreLegend";
    }



    /**
     * 班级统计
     * @return
     */
    @ResponseBody
    @RequestMapping("/classCount")
    public Object testcCount(){
        List<Map> count = legendService.getClassCount();

        //List<Map> modeCount = legendService.getModeCount();
        //count.addAll(modeCount);
        return count;
    }
    /**
     * 学生统计
     * @return
     */
    @ResponseBody
    @RequestMapping("/stuCount")
    public Object testsCount(){
        List<Map> count = legendService.getClassCount();

        //List<Map> modeCount = legendService.getModeCount();
        //count.addAll(modeCount);
        return count;
    }
}
