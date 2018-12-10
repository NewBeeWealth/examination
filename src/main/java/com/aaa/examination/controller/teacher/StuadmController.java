package com.aaa.examination.controller.teacher;

import com.aaa.examination.dao.teacher.StuadmDao;
import com.aaa.examination.service.teacher.StuadmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:StuadmController
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-05 16:58
 */
@Controller
@RequestMapping("/student")
public class StuadmController {
    //依赖注入
    @Autowired
    private StuadmService stuadmService;

    /**
     * 跳转
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "teacher/stuList";
    }
    @ResponseBody
    @RequestMapping("/getList")
    public Object getList(@RequestBody Map map){

        Map rmap=new HashMap();
        rmap.put("data",stuadmService.getStuList(map));
        //System.out.println(stuadmService.getStuList(map));
        rmap.put("total",stuadmService.getPageCount(map));
        // System.out.println(map+"......abc.....");
        // System.out.println(map.get("start")+","+map.get("end"));
        System.out.println(rmap);
        return rmap;
    }


    /**
     * 删除
     * @param STUDENT_ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{STUDENT_ID}")
    public Object del(@PathVariable Integer STUDENT_ID){
        return stuadmService.deleteStu(STUDENT_ID);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchDel/{ids}")
    public Object batchDel(@PathVariable String ids){
        //1,2,3,
        return null;
    }
    /**
     * 添加
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
        // System.out.println(map+"...aaa....");
        //return 1;
        return stuadmService.addStu(map);
    }
    /**
     * 添加
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        return stuadmService.updateStu(map);
    }

    /**
     * 班级列表（返回JSON）
     * @return
     */
    @ResponseBody
    @RequestMapping("/listJson")
    public Object listJson(){

       /* Map rmap=new HashMap();
        rmap.put("options",stuadmService.getClassList(map));*/
        return stuadmService.getClassList();
    }

}
