package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.QuestionManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:QuestionManageServiceImpl
 * discriptoin:
 * author:llw
 * createTime:2018-11-24 14:16
 */
@Service
public class QuestionManageServiceImpl implements QuestionManageService{

    @Autowired
    private QuestionManageDao questionManageDao;

    @Override
    public int itembank(Map map) {
        return questionManageDao.itembank(map);
    }

    @Override
    public List<Map> getQuestionList() {
        return questionManageDao.getQuestionList();
    }

    @Override
    public int deleteQuestion(Integer id) {
        return questionManageDao.deleteQuestion(id);
    }

    @Override
    public List<Map> SelectByidQuestion(Integer id) {
        return questionManageDao.SelectByidQuestion(id);
    }

    @Override
    public int addExamination(Map map) {
        if(map.get("qutype").equals("0")){//单选
            map.put("qutype","单选");
            questionManageDao.addSingleExam(map);
        }else if(map.get("qutype").equals("1")){//多选
            map.put("qutype","多选");
            questionManageDao.addmultipleExam(map);
        }else {//判断
            map.put("qutype","判断");
            questionManageDao.addjudgeExam(map);
        }
        return 0;
    }

    @Override
    public List<Map> getSmjlist() {
        return questionManageDao.getSmjlist();
    }

    @Override
    public List<Map> selecetclass() {
        return questionManageDao.selecetclass();
    }

    @Override
    public List<Map> selectclname(String ids) {
        List list=new ArrayList();
        if(ids!=null&&!"".equals(ids)){
            String[] tempIds = ids.split(",");
            for(String id:tempIds){
                Map templist=new HashMap();
                templist.put("classname",questionManageDao.selectclname(Integer.valueOf(id)).get(0).get("CLASSNAME"));
                templist.put("classid",questionManageDao.selectclname(Integer.valueOf(id)).get(0).get("CLASSID"));
                list.add(templist);
            }
        }
        return list;
    }
    @Override
    public List<Map> selectpename(String ids) {
        List list=new ArrayList();
        if(ids!=null&&!"".equals(ids)){
            String[] tempIds = ids.split(",");
            for(String id:tempIds){
                Map templist=new HashMap();
                templist.put("student_name",questionManageDao.selectpername(Integer.valueOf(id)).get(0).get("STUDENT_NAME"));
                templist.put("student_id",questionManageDao.selectpername(Integer.valueOf(id)).get(0).get("STUDENT_ID"));
                list.add(templist);
            }
        }
        return list;
    }

    @Override
    public List<Map> selecetPerson(int id) {
        return questionManageDao.selecetPerson(id);
    }

    @Override
    public int submitPapers(Map userMap, List<Map> selectclname, List<Map> selectpername) {
       //试卷状态
        if("0".equals(userMap.get("examinatestate"))){
            userMap.put("examinatestate","开放");
        }else if("1".equals(userMap.get("examinatestate"))){
            userMap.put("examinatestate","关闭");
        }
        //公布答案
        if("0".equals(userMap.get("examinateisopen"))){
            userMap.put("examinateisopen","是");
        }else if("1".equals(userMap.get("examinateisopen"))){
            userMap.put("examinateisopen","否");
        }
        //试卷类型
        if("0".equals(userMap.get("examinateother"))){
            userMap.put("examinateother","普通试卷");
        }else if("1".equals(userMap.get("examinateother"))){
            userMap.put("examinateother","随机试卷");
        }
        //时间
        if(userMap.get("examinatestart")!=null){
            String examinatestart =(String) userMap.get("examinatestart");
            String replace = examinatestart.replace("T", " ");
            userMap.put("examinatestart",replace);
        }
        if(userMap.get("examinateend")!=null){
            String examinateend =(String) userMap.get("examinateend");
            String replace = examinateend.replace("T", " ");
            userMap.put("examinateend",replace);
        }
        if(userMap.get("examinateopen")!=null){
            String examinateopen =(String) userMap.get("examinateopen");
            String replace = examinateopen.replace("T", " ");
            userMap.put("examinateopen",replace);
        }

        questionManageDao.addexam(userMap);
        int examid =Integer.valueOf(userMap.get("EXAM_ID")+"")+1;//返回添加后主键
        System.out.println("试卷id是"+examid);
        //添加班级
        if(selectclname!=null&&selectclname.size()>0){
            for(int i=0;i<selectclname.size();i++){
                Map map=new HashMap();
                int classid = Integer.parseInt(selectclname.get(i).get("classid") + "");
                map.put("classid",classid);
                map.put("examid",examid);
                questionManageDao.insertexam(map);
            }
        }
        //添加学生
         if(selectpername!=null&&selectpername.size()>0){
            for(int i=0;i<selectpername.size();i++){
                Map map=new HashMap();
                int studentIdid = Integer.valueOf(selectpername.get(i).get("student_id") + "");
                map.put("studentIdid",studentIdid);
                map.put("examid",examid);
                map.put("studentexamstate",1);
                questionManageDao.insertstude(map);
            }
        }
        return 0;
    }

    @Override
    public List<Map> getFtpList() {
        return questionManageDao.getFtpList();
    }

}
