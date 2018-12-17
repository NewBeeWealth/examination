package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.QuestionManageService;
import com.aaa.examination.util.FtpUtilA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @Autowired
    private FtpUtilA ftpUtilA;

    private ResourceLoader resourceLoader;

    @Value("${upload.path}")
    private String filePath;



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
        System.out.println(id+"------------");

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
     * 跳转到下载试题
     * @return
     */
    @RequestMapping("batchadd")
    public String batchAdd(Model model){
        model.addAttribute("ftpList",questionManageService.getFtpList());
        return "teacher/ftplistshow";
    }
    /**
     * 跳转到下载试题
     * @return
     */
    @RequestMapping("excelbatchadd")
    public String excelBatchAdd(Model model){
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
    public String toexammmanage(){
        return "teacher/exammanage1";
    }

    /**
     * 试卷提交
     * @return
     */
    @RequestMapping("createExamination")
    public String createExamination(@RequestParam Map userMap,HttpServletRequest request){
        List<Map> selectclname =(List<Map>) request.getSession().getAttribute("selectclname");
        List<Map> selectpername =(List<Map>) request.getSession().getAttribute("selectpername");
        questionManageService.submitPapers(userMap,selectclname,selectpername);
        return "redirect:/exam/messageexamination";
    }
    /**
     * 跳转到管理试题
     * @return
     */
    @RequestMapping("exammanage")
    public String exammanage(Model model){
        model.addAttribute("smjlist",questionManageService.getSmjlist());
        return "teacher/exammanage";
    }

    /**
     * 跳转选择年级
     * @return
     */
    @RequestMapping("toSelecetClass")
    public String toSelecetClass(Model model){
        model.addAttribute("selecetclass",questionManageService.selecetclass());
        return "teacher/selecetclass";
    }
    /**
     * 跳转选择年级
     * @return
     */
    @RequestMapping("toSelecetPerson")
    public String toSelecetPerson(Model model,HttpServletRequest request){
        List<Map> list1 =(List<Map>) request.getSession().getAttribute("selectclname");

        List list=new ArrayList();
        if(list1!=null&&list1.size()>0){
            for(int i=0;i<list1.size();i++){
                int classid = Integer.valueOf(list1.get(i).get("classid")+"");
                List<Map> maps = questionManageService.selecetPerson(classid);
                for(int j=0;j<maps.size();j++){
                    list.add(maps.get(j));
                }
            }
        }
        model.addAttribute("selecetperson",list);
        return "teacher/selecetperson";
    }
    /**
     * 跳转选择年级
     * @return
     */
    @ResponseBody
    @RequestMapping("setcla")
    public Object setCla(Model model,String tempchecked,HttpServletRequest request){
        List<Map> selectclname = questionManageService.selectclname(tempchecked);
        HttpSession session = request.getSession();
        session.setAttribute("selectclname",selectclname);
        return selectclname;
    }
    /**
     * 跳转选择学生
     * @return
     */
    @ResponseBody
    @RequestMapping("setperson")
    public Object setPerson(Model model,String tempchecked,HttpServletRequest request){
        List<Map> selectpername = questionManageService.selectpename(tempchecked);
        HttpSession session = request.getSession();
        session.setAttribute("selectpername",selectpername);
        return selectpername;
    }

    /**
     * 跳转到创建试卷
     * @return
     */
    @RequestMapping("toTempchange")
    public String toSelecetClass(){
//        String tempdata,Model model,HttpServletRequest request
       // model.addAttribute("tempdata",tempdata);
        //List<Map> list =(List<Map>) request.getSession().getAttribute("selectclname");
        return "teacher/createexamination";
    }
    /**
     * 跳转到上传试卷
     * @return
     */
    @RequestMapping("uploadMessage")
    public String uploadMessage(){
        return "teacher/uploadmessage";
    }
    /**
     * ftp文件下载
     * @param fileName
     */
    @RequestMapping("/downFtpFile")
    public void downFtpFile(String fileName,HttpServletResponse response){
        ftpUtilA.downLoad(fileName,response);
    }
}
