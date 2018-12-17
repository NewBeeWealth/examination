package com.aaa.examination.controller.studentexam;

import com.aaa.examination.service.studentexam.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:StudentExamController
 * discriptoin:
 * author:dzq
 * createTime:2018-11-26 13:58
 */
@Controller
@RequestMapping("exam")
public class StudentExamController {
    @Autowired
    StudentExamService studentExamService;
    /**
     * 跳转到查询试卷
     * @return
     */
    /*@RequestMapping("toChooseExam")
    public String toChooseExam(){
        return "studentexam/choose";
    }*/

    /**
     * 查询试卷
     * @param map
     * @param model
     * @return
     */
    @RequestMapping("chooseExam")
    public String chooseExam(@RequestParam Map map, Model model,HttpSession session){
        Object studentId = session.getAttribute("studentId");
        if (studentId!=null){
            map.put("studentId",studentId);
            List<Map> examList = studentExamService.chooseExam(map);
            model.addAttribute("examList",examList);
        }
        return "studentexam/choose";
    }
    /**
     * 根据试卷id获取试卷试题
     * @param examId
     * @return
     */
    @RequestMapping("/question/{examId}")
    public String getQuestion(@PathVariable Object examId, Model model){
        //查询试卷头信息
        Map examMap = studentExamService.examTop(examId).get(0);
        //System.out.println("----"+examMap);
        model.addAttribute("examMap",examMap);
        //查询单选试题
        List<Map> singleQuestion = studentExamService.getSingleQuestion(examId);
        //System.out.println(singleQuestion);
        model.addAttribute("singleQuestion",singleQuestion);
        //查询多选题
        List<Map> mulQuestion = studentExamService.getMulQuestion(examId);
        //System.out.println(mulQuestion);
        model.addAttribute("mulQuestion",mulQuestion);
        //查询判断题
        List<Map> judgeQuestion = studentExamService.getJudgeQuestion(examId);
        //System.out.println(judgeQuestion);
        model.addAttribute("judgeQuestion",judgeQuestion);
        return "studentexam/exam";
    }

    /**
     * 提交答案
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("subAnswer")
    public int subAnswer(@RequestParam Map map, HttpSession session, HttpServletRequest request){
        Object studentId = session.getAttribute("studentId");//从session中拿到登陆的学生id
        System.out.println("登陆的学生id为："+studentId);
        int result=0;
        int singleTotalResult=0;
        int mulTotalResult=0;
        int judgeTotalResult=0;
        int totalScore=0;
        if (studentId!=null){
            map.put("studentId",studentId);
            List<Map> msg = studentExamService.getMsg(map);//查看是否答过此试卷
            //System.out.println("''''''''"+msg);
            if (msg==null||msg.size()==0){
                //保存单项选择题答案
                String[] singleIds = request.getParameterValues("singleId");
                for (int i=0;i<singleIds.length;i++){
                    //System.out.println(map.get("single"+singleIds[i]));
                    int singleResult=studentExamService.saveSingleAnswer(singleIds[i],map.get("single"+singleIds[i]),studentId,map.get("examId"),map.get("singleScore"+singleIds[i]));
                    //System.out.println("+-+-+-+-");
                    singleTotalResult += singleResult;
                }
                //System.out.println("+++++"+singleTotalResult);
                //保存多项选择题答案
                String[] mulIds = request.getParameterValues("mulId");
                for (int i=0;i<mulIds.length;i++){
                    String mulAnswer = new String();
                    String[] parameterValues = request.getParameterValues("mul" + mulIds[i]);
                    for (int j=0;j<parameterValues.length;j++){
                        //System.out.println("******"+parameterValues[j]);
                        String parameterValue = parameterValues[j];
                        mulAnswer += parameterValue;
                    }
                    //System.out.println("******"+silAnswer);
                    int mulResult=studentExamService.saveMulAnswer(mulIds[i],mulAnswer,studentId,map.get("examId"),map.get("singleScore"+singleIds[i]));
                    mulTotalResult += mulResult;
                }
                //System.out.println("+_+_+_+"+mulTotalResult);
                //保存判断题答案
                String[] judgeIds = request.getParameterValues("judgeId");
                for (int i=0;i<judgeIds.length;i++){
                    int judgeResult=studentExamService.saveJudgeAnswer(judgeIds[i],map.get("judge"+judgeIds[i]),studentId,map.get("examId"),map.get("singleScore"+singleIds[i]));
                    //System.out.println("*8*8*8"+judgeResult);
                    judgeTotalResult += judgeResult;
                }
                //System.out.println("&**&*&*&*&*"+judgeTotalResult);
                totalScore = singleTotalResult+mulTotalResult+judgeTotalResult;
                //System.out.println("|||||||"+totalScore);
                result=studentExamService.saveTotalScore(studentId,map.get("examId"),totalScore);
            }else {
                result=-2;
            }
        }
        return result;
    }
}
