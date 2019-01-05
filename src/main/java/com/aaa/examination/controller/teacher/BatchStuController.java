package com.aaa.examination.controller.teacher;

import com.aaa.examination.service.teacher.BatchStuService;
import com.aaa.examination.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.aaa.examination.util.FtpUtilA;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * className:BatchStuController
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:24
 */
@Controller
@RequestMapping("/batch")
public class BatchStuController {
    @Autowired
   private BatchStuService batchStuService;

    @Autowired
    private FtpUtilA ftpUtil;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${upload.path}")
    private String filePath; // D:/images/

    @Autowired
    public BatchStuController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 跳转
     * @return
     */
    @RequestMapping("/toList")
    public String toList(){
        return "teacher/batchAddStu";
    }

    @RequestMapping("/upload")
    public String ss(){
        return "teacher/upload";
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
        batchStuService.add(map);
        return "redirect:/question/batchadd";
    }

    /**
     * 跳转到下载
     * @return
     */
//    @RequestMapping("batchadd")
//    public String batchAdd(Model model){
//        model.addAttribute("ftpList",batchStuService.getFtpList());
//        return "teacher/ftplistshow";
//    }

    /**
     * ftp文件下载
     * @param fileName
     */
    @RequestMapping("/downFtpFile")
    public void downFtpFile(String fileName,HttpServletResponse response){
        ftpUtil.downLoad(fileName,response);
    }


//    /**
//     * 批量导入
//     * @return
//     */
//    @RequestMapping("/batchAdd")
//    public String batchAdd(@RequestParam MultipartFile excelFile,@RequestParam Map userMap){
//        batchStuService.batchAdd(excelFile,userMap);
//        return "/teacher/exammanage1";
//    }


    /**
     * 上传
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadPic")
    public Object uploadPic(@RequestParam MultipartFile file){
        /*System.out.println(file.getOriginalFilename()+"..............");*/
        final String s =  FtpUtil.upLoad(file);
        System.out.println(s);
        batchStuService.insertUrl(s);
        return s;
    }

    /**
     * ftp图片显示方法
     * @param fileName
     * @return
     */
    @RequestMapping("/show")
    public ResponseEntity showFtp(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("ftp://groupsix:admin@172.16.22.24/" + fileName);
            return ResponseEntity.ok(resourceLoader.getResource("ftp://groupsix:admin@172.16.22.24/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseBody
    @RequestMapping("/getUpload")
    public Object getUpload(){
        /*System.out.println(file.getOriginalFilename()+"..............");*/
        System.out.println(batchStuService.getUpload());
        //Map map = new HashMap();
        return  batchStuService.getUpload();
    }
}
