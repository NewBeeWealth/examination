package com.aaa.examination.controller.student;

import com.aaa.examination.service.student.UpdatePwdServiceImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Maps;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/up")
public class UpdatePwdController {
    @Autowired
    private UpdatePwdServiceImpl updatePwdService;

    /**
     * 获得查询到的密码
     * @return
     */

    @RequestMapping("/select")
    public String selectPwd( HttpSession session, Model model){
        Object userName = session.getAttribute("userName");
        model.addAttribute("userName",userName);
        return "student/UpdatePwd";
    }
    /**
     * 密码修改
     */
    @RequestMapping("/Update")
    public String Update(@RequestParam Map map, Model model,HttpSession session){
        Object studentId = session.getAttribute("studentId");
        Object userName = session.getAttribute("userName");
        model.addAttribute("userName",userName);
        map.put("studentId",studentId);
        map.put("userName",userName);
        List<Map> maps = updatePwdService.selectPwd(map);
        Object student_pwd = maps.get(0).get("STUDENT_PWD");
        Object oldpwd = map.get("oldpwd");
        if(map!=null&&map.size()>0&&student_pwd.equals(oldpwd)){
            updatePwdService.updatePwd(map);
            model.addAttribute("error","修改成功！！");
        }else if(student_pwd!=oldpwd){
            model.addAttribute("error","输入密码错误！！！");
        }
        return "student/UpdatePwd";
    }
}
