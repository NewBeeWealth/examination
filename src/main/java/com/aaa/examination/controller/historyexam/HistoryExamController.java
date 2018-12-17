package com.aaa.examination.controller.historyexam;

import com.aaa.examination.service.historyexam.HistoryExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:HistoryExamController
 * discriptoin:
 * author:dzq
 * createTime:2018-12-04 16:57
 */
@Controller
@RequestMapping("history")
public class HistoryExamController {
    @Autowired
    HistoryExamService historyExamService;

    /**
     * 分页查询所有历史考试
     * @param map
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("getList")
    public Object getList(@RequestBody Map map, HttpSession session){
        Object studentId = session.getAttribute("studentId");
        Map rMap = new HashMap();
        if (studentId!=null){
            map.put("studentId",studentId);
            //System.out.println("++++++"+map);
            List<Map> list = historyExamService.getList(map);
            for (int i=0;i<list.size();i++){
                Object examTotleScore = list.get(i).get("EXAM_TOTLESCORE");
                Integer integer = Integer.valueOf(examTotleScore + "");
                double a = integer*0.6;
                list.get(i).put("lineScore",a);
            }
            rMap.put("data",list);
            rMap.put("total",historyExamService.getPageCount(map));
        }
        //System.out.println(rMap);
        return rMap;
    }

    /**
     * 跳转到历史考试界面
     * @return
     */
    @RequestMapping("toList")
    public String toList(){
        return "historyexam/history";
    }

    /**
     * 考试详情
     * @return
     */
    @RequestMapping("/getDetail/{examId}")
    public String getDetail(@RequestParam Map map, HttpSession session, Model model, @PathVariable Object examId){
        Object studentId = session.getAttribute("studentId");
        //Map detailMap = new HashMap();
        if (studentId!=null){
            map.put("studentId",studentId);
            map.put("examId",examId);
            //System.out.println("****"+map);
            List<Map> detailTopList = historyExamService.examTop(map);
            model.addAttribute("detailMap",detailTopList.get(0));
            List<Map> singleQuestion = historyExamService.getSingleDetail(map);//查询单选题详情
            //System.out.println("*************"+singleQuestion);
            model.addAttribute("singleQuestion",singleQuestion);
            List<Map> mulQuestion = historyExamService.getMulDetail(map);//查询多选题详情
            model.addAttribute("mulQuestion",mulQuestion);
            List<Map> judgeQuestion = historyExamService.getJudgeDetail(map);//查询判断题详情
            //System.out.println("..............."+judgeQuestion);
            model.addAttribute("judgeQuestion",judgeQuestion);
        }
        //System.out.println("*-*-*-*-*");
        return "historyexam/detail";
    }
}
