package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.BatchStuDao;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:BatchStuServiceImpl
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-10 15:23
 */
@Service
public class BatchStuServiceImpl implements BatchStuService{
    //依赖注入
    @Autowired
    private BatchStuDao batchStuDao;

    @Override
    public int addStu(Map map) {
        return batchStuDao.addStu(map);
    }

    @Override
    public Map batchAddStu(MultipartFile file) {
        Map error = new HashMap();
        String errors = "";
        Workbook workbook = null;
        try {
            //利用jar提供的功能，读取文件流到Workbook对象里面
            workbook = Workbook.getWorkbook(file.getInputStream());
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //得到excel中工作簿
        Sheet sheet = workbook.getSheet(0);
        //得到第一个工作簿中一共有多少行
        int rows = sheet.getRows();
        Map map  = null;
        for(int i=1;i<rows;i++){
            try {//STUDENT_ID,STUDENT_ID,STUDENT_USERNAME,STUDENT_PWD,STU_IDNO,STU_PHONE,CLASSID,STU_ADD,STUDENT_STATE
                map = new HashMap();
                //根据行下标获取该行数据的列集合
                Cell[] row = sheet.getRow(i);
                //row[0].getContents()  获取单元格内容
                map.put("STUDENT_ID",row[0].getContents());
                map.put("STUDENT_NAME",row[1].getContents());
                map.put("STUDENT_USERNAME",row[2].getContents());
                map.put("STUDENT_PWD",row[3].getContents());
                map.put("STU_IDNO",row[4].getContents());
                map.put("STU_PHONE",row[5].getContents());
                map.put("CLASSID",row[6].getContents());
                map.put("STU_ADD",row[7].getContents());
                map.put("STUDENT_STATE",row[8].getContents());
                batchStuDao.addStu(map);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                errors+=(i+1)+" ";
            }
        }
        if(!"".equals(errors)){
            error.put("er","错误行号为："+errors);
        }else{
            error.put("er", "导入成功！！！");
        }
        return error;
    }
}
