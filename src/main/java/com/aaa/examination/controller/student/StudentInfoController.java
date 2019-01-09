package com.aaa.examination.controller.student;

import com.aaa.examination.service.student.StudentInfoService;
import com.aaa.examination.service.student.StudentInfoServiceImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/info")
public class StudentInfoController {
    @Autowired
    StudentInfoService studentInfoService;

    /**
     * 跳转学生信息列表
     * @return
     *
     */

    @RequestMapping("/toinfo")
    public String toinfo(){
        return "student/StudentInfo";
    }

    @RequestMapping("/studentInfo")
    public String studentInfo(@RequestParam Map map, HttpSession session, Model model, HttpServletRequest request){
        Object studentId=session.getAttribute("studentId");
        map.put("studentId",studentId);
        System.out.println("------------------------------"+map);
        Object username=session.getAttribute("userName");
        model.addAttribute("userName",username);
        List<Map> maps=studentInfoService.StudentInfo(map);
        System.out.println("-----------------------"+maps);
        model.addAttribute("maps",maps.get(0));

        int i =-2;
        if (i>-2){
        i = Integer.valueOf(request.getParameter("i"));
        if(i==1){
            model.addAttribute("error","修改成功！！");
        }else if(i==0) {
            model.addAttribute("error","修改失败");
        }}
        return "student/StudentInfo";
    }

    /**
     * 查看查询到的信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/111")
    public List<Map> info(Map map){
        return studentInfoService.StudentInfo(map);
    }

    @RequestMapping("/updateinfo")
    public String updateinfo(@RequestParam Map map,HttpSession session,Model model){
      Object studentId=session.getAttribute("studentId");
      map.put("studentId",studentId);
        System.out.println("controller层的map--------"+map);

        int i=studentInfoService.updateinfo(map);
        System.out.println("控制--------------层的i"+i);


        return "redirect:/info/studentInfo?i="+i;
    }
}
