package com.aaa.examination.controller.teacher;

import com.aaa.examination.entity.TreeRole;
import com.aaa.examination.service.teacher.ExamManageService;
import com.aaa.examination.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:ExamManage
 * discriptoin:
 * author:llw
 * createTime:2018-12-03 22:44
 */
@Controller
@RequestMapping("exammanage")
public class ExamManageController {

    @Autowired
    private ExamManageService examManageService;

    /**
     * 查询所有题库
     * @return
     */
    @ResponseBody
    @RequestMapping("getQuestionBank")
    public Object getQuestionBank(){
        System.out.println("||||"+examManageService.getQuestionBank());
        return examManageService.getQuestionBank();
    }

    /**
     * 试题列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getQuestionList")
    public Object getQuestionList(@RequestBody Map map){
        System.out.println("6666666"+map);
        Map rmap=new HashMap();
        List<Map> singleList = examManageService.getSingleList(map);
        System.out.println("888"+singleList);
        rmap.put("data",singleList);
        rmap.put("total",examManageService.getSinglePageCount(map));
        return rmap;
    }

    /**
     * 删除
     * @param SINGLE_ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{SINGLE_ID}")
    public Object del(@PathVariable Integer SINGLE_ID){
        System.out.println("kkk"+SINGLE_ID);
        return  examManageService.delete(SINGLE_ID);
    }
    /**
     * 添加
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return examManageService.update(map);
    }
    /**
     * 添加使用ftp 上传
     * @param map
     * @return
     */
    @RequestMapping("/addUseFtp")
    public String addUseFtp(@RequestParam Map map, @RequestParam MultipartFile pic){
        if(pic!=null&&!pic.isEmpty()){
            //String s = FileUtil.uploadFile(filePath, pic);
            final String s =  FtpUtil.upLoad(pic);
            map.put("filePath",s);
            map.put("fileName",pic.getOriginalFilename());
        }
        examManageService.add(map);
        return "redirect:/question/batchadd";
    }

    /**
     * 跳转到角色管理
     * @return
     */
    @RequestMapping("/toUserPower")
    public String toUserPower(){
        return "teacher/rolelist";
    }
    /**
     * 角色管理列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/userPower")
    public Object userPower(@RequestBody Map map){
        Map rmap=new HashMap();
        List<Map> singleList = examManageService.getOccupationList(map);
        rmap.put("data",singleList);
        rmap.put("total",examManageService.getOccupationCount(map));
        return rmap;
    }
    /**
     * 权限表数据
     * @return
     */
    @RequestMapping("/role")
    @ResponseBody
    public Object roleList(@RequestBody Map map){
        System.out.println(map);
        System.out.println(map.get("roleId"));
        //List<Tree> role = examManageService.getRole(map);
        //System.out.println(role);
        return null;
    }

    /**
     * 列表数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object list(){
        List<TreeRole> list = examManageService.getList();
        return list;
    }
    /**
     * 批量添加角色权限关联表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/poweradd")
    public Object add(@RequestBody Map map){
        //System.out.println(map.get("ids")+"----"+map.get("roleId"));
        //System.out.println(map.get("roleId"));

        //int i = powerService.delFun(id);
/*        int i=0;
        if (i>0){
            System.out.println("权限清除成功！！");
        }else {
            System.out.println("权限清除失败！！");
        }*/
        //powerService.delFun();
        //powerService.add(map);
        int i = examManageService.addPower(map);
        return i;
    }
}
