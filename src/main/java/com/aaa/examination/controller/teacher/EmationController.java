package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.EmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
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
    public String messageExamination(Model model){
        List<Map> examList = emationService.getExamList();
        System.out.println(examList);
        model.addAttribute("maps",examList);
        return "teacher/messageexamination";
    }

    /**
     * 删除试卷
     * @param id
     * @return
     */
    @RequestMapping("delexam")
    public String delexam(Integer id){
        emationService.delexam(id);
        return "redirect:/exam/messageexamination";
    }

    /**
     * 通过id获取试卷信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("getExamById")
    public String getExamById(Integer id,Model model){
        List<Map> examById = emationService.getExamById(id);
        System.out.println("||||||"+examById);
        Map map = examById.get(0);
        map.put("EXAM_STARTTIME",map.get("EXAM_STARTTIME").toString().replace(" ","T"));
        map.put("EXAM_ENDTIME",map.get("EXAM_ENDTIME").toString().replace(" ","T"));
        System.out.println("===="+map);
        model.addAttribute("examMsg",map);
        return "teacher/examupdate";
    }

    /**
     * 修改试卷信息
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("examUpdate")
    public String examUpdate(@RequestParam Map map,Model model){
        map.put("examStartTime",map.get("examStartTime").toString().replace("T"," ").replace(".0",""));
        map.put("examEndTime",map.get("examEndTime").toString().replace("T"," ").replace(".0",""));
        System.out.println("?????"+map);
        int i = emationService.examUpdate(map);
        if (i>0){
            return "redirect:/exam/messageexamination";
        }else {
            model.addAttribute("error","修改失败");
            return "teacher/examupdate";
        }
    }

    /**
     * 配置试题时，选择题库
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("toCheckBank")
    public String toCheckBank(int id,Model model){
        List<Map> allBank = emationService.getAllBank();
        model.addAttribute("allBank",allBank);
        model.addAttribute("id",id);
        return "/teacher/checkbank";
    }
    /**
     * 跳转到添加试卷
     * @return
     */
    @RequestMapping("addexamination")
    public Object addexamination(Integer id,Model model,@RequestParam Map map){
        System.out.println(map);
        List<Map> singleList = emationService.getSingleExamList(map);//单选题
        List<Map> multipleList = emationService.getMultipleExamList(map);//多选
        List<Map> judgeList = emationService.getJudgeExamList(map);//判断
        System.out.println(judgeList);
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
    public Object submitExamination(@RequestParam Map userMap, HttpSession session){
        emationService.addscore(userMap,session);
        return "redirect:/exam/messageexamination";
    }

}
