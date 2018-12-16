package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.EmationDao;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmationServiceImpl
 * discriptoin:
 * author:llw
 * createTime:2018-11-29 22:16
 */
@Service
public class EmationServiceImpl implements EmationService{

    @Autowired
    private EmationDao emationDao;

    @Override
    public Map batchAdd(MultipartFile file,Map usermap) {
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

        List list=new ArrayList();
        Map map  = null;
        for(int i=1;i<rows;i++){
            try {
                map = new HashMap();
                //根据行下标获取该行数据的列集合
                Cell[] row = sheet.getRow(i);

                if("判断".equals(row[0].getContents())){
                    map.put("dname",row[0].getContents());
                    map.put("loc",row[1].getContents());
                    if("正确".equals(row[2].getContents())){
                        map.put("loc1","Y");
                    }else{
                        map.put("loc1","N");
                    }
                    map.put("qname",usermap.get("qname"));
                    emationDao.addJudge(map);
                }
                if("单选".equals(row[0].getContents())||"多选".equals(row[0].getContents())){
                    //row[0].getContents()  获取单元格内容
                    map.put("dname",row[0].getContents());
                    map.put("loc",row[1].getContents());
                    map.put("loc1",row[2].getContents());
                    map.put("loc2",row[3].getContents());
                    map.put("loc3",row[4].getContents());
                    map.put("loc4",row[5].getContents());
                    map.put("loc5",row[6].getContents());
                    map.put("qname",usermap.get("qname"));
                    list.add(map);

                    if("单选".equals(map.get("dname"))){
                        emationDao.addSingle(map);
                    }else if("多选".equals(map.get("dname"))){
                        emationDao.addMultiple(map);
                    }
                }

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

    @Override
    public List<Map> getExamList() {
        return emationDao.getExamList();
    }

    @Override
    public List<Map> getSingleExamList() {
        return emationDao.getSingleExamList();
    }

    @Override
    public List<Map> getMultipleExamList() {
        return emationDao.getMultipleExamList();
    }

    @Override
    public List<Map> getJudgeExamList() {
        return emationDao.getJudgeExamList();
    }

    @Override
    public int addscore(Map map) {
        List<Map> examType = null;//单选
        List<Map> examType1 =null;//多选
        List<Map> examType2 =null;//判断

        for(Object key : map.keySet()){
            String value = String.valueOf(map.get(key));
            String s = String.valueOf(key+"");
            String tempnumid =  String.valueOf(map.get("examid"));//试卷id
            if(!"examid".equals(s)){
                Map map1=new HashMap();
                map1.put("tempnumid",tempnumid);
                map1.put("s",s);
                map1.put("value",value);
                examType = emationDao.findSingleExamType(map1);//单选
                examType1 = emationDao.findMultipleExamType(map1);//多选
                examType2 = emationDao.findJudegeExamType(map1);//判断
                if((examType!=null&&examType.size()>0)&&("单选".equals(examType.get(0).get("SINGLE_TYPE")))){
                    emationDao.addSingleExamType(map1);
                    continue;
                }
                if((examType1!=null&&examType1.size()>0)&&("多选".equals(examType1.get(0).get("MUL_TYPE")))){
                   emationDao.addMultipleExamType(map1);
                   continue;
                }
                if((examType2!=null&&examType2.size()>0)&&("判断".equals(examType2.get(0).get("JUDGE_TYPE")))){
                    emationDao.addJudegeExamType(map1);
                    continue;
                }
            }
        }
        return 0;
    }


}
