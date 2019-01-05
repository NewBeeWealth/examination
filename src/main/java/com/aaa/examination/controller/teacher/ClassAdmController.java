package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.ClassAdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:ClassAdmController
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-21 09:59
 */
@Controller
@RequestMapping("/classes")
public class ClassAdmController {
    //依赖注入
    @Autowired
    private ClassAdmService classAdmService;

    /**
     * 跳转
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "teacher/classAdm";
    }
    @ResponseBody
    @RequestMapping("/getList")
    public Object getList(@RequestBody Map map){

        Map rmap=new HashMap();
        rmap.put("data",classAdmService.getClassList(map));
        //System.out.println(stuadmService.getStuList(map));
        rmap.put("total",classAdmService.getPageCount(map));
        // System.out.println(map+"......abc.....");
        // System.out.println(map.get("start")+","+map.get("end"));
        //System.out.println(rmap);
        return rmap;
    }


    /**
     * 删除
     * @param CLASSID
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{CLASSID}")
    public Object del(@PathVariable Integer CLASSID){
        return classAdmService.deleteClass(CLASSID);
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
        return classAdmService.batchDelete(ids);
    }
    /**
     * 添加
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
         System.out.println(map+"...aaa....");
        //return 1;
        return classAdmService.addClass(map);
    }
    /**
     * 更新
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        System.out.println(map);
        String begin=map.get("BEGINTIME")+"";
        String end=map.get("ENDTIME")+"";
        map.put("BEGINTIME",begin.substring(0,10));
        map.put("ENDTIME",end.substring(0,10));
        System.out.println(map);
        return classAdmService.updateClass(map);

    }

    /**
     * 状态列表（返回JSON）
     * @return
     */
    @ResponseBody
    @RequestMapping("/listJson")
    public Object listJson(){
        return classAdmService.getStateList();
    }

}
