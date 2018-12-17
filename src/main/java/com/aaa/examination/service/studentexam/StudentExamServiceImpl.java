package com.aaa.examination.service.studentexam;

import com.aaa.examination.dao.studentexam.StudentExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * className:StudentExamServiceImpl
 * discriptoin:
 * author:dzq
 * createTime:2018-11-26 16:25
 */
@Service
public class StudentExamServiceImpl implements StudentExamService {
    @Autowired
    StudentExamDao studentExamDao;

    @Override
    public List<Map> chooseExam(Map map) {
        Date date = new Date();
        map.put("nowDate",date);
        map.put("state",1);
        //System.out.println("*****"+map);
        List<Map> person = studentExamDao.getPerson(map);
        //System.out.println("--+++"+person);
        List<Map> totals = new ArrayList();
        if (person!=null){
            for (Map persons : person) {
                map.put("examId",persons.get("STUDENTEXAM_EXAM"));
                //System.out.println(map);
                List<Map> maps = studentExamDao.chooseExam(map);
                //System.out.println("*-*-"+maps);
                if (maps!=null&&maps.size()>0){
                    totals.add(maps.get(0));
                }
            }
            /*Object examId = person.get(0).get("STUDENTEXAM_EXAM");
            map.put("examId",examId);*/
            //System.out.println(totals);
            return totals;
        }else {
            return null;
        }
    }

    @Override
    public List<Map> examTop(Object examId) {
        List<Map> examTopmap = studentExamDao.examTop(examId);
        return examTopmap;
    }

    @Override
    public List<Map> getSingleQuestion(Object examId) {
        List<Map> singleQuestion = studentExamDao.getSingleQuestion(examId);
        return singleQuestion;
    }

    @Override
    public List<Map> getMulQuestion(Object examId) {
        List<Map> mulQuestion = studentExamDao.getMulQuestion(examId);
        return mulQuestion;
    }

    @Override
    public List<Map> getJudgeQuestion(Object examId) {
        List<Map> judgeQuestion = studentExamDao.getJudgeQuestion(examId);
        return judgeQuestion;
    }

    @Override
    public List<Map> getMsg(Map map) {
        return studentExamDao.getMsg(map);
    }

    @Override
    public int saveSingleAnswer(String silId, Object silAnswer, Object stuId,Object examId,Object singleScore) {
        int singleId = Integer.valueOf(silId);
        String singleAnswer = silAnswer+"";
        int studentId = Integer.valueOf(stuId+"");
        int singleSco = Integer.valueOf(singleScore+"");
        Map map = new HashMap();
        map.put("singleId",singleId);
        map.put("singleAnswer",singleAnswer);
        map.put("studentId",studentId);
        map.put("examId",examId);
        int singleScores=0;
        //查询正确答案
        List<Map> singleResult = studentExamDao.getSingleResult(singleId);
        if (singleResult!=null&&singleResult.size()>0){
            if (singleResult.get(0).get("SINGLE_RESULT").equals(singleAnswer)){
                singleScores=singleSco;
            }
            map.put("singleScores",singleScores);
            studentExamDao.saveSingleAnswer(map);
        }
        //System.out.println("******"+singleScores);
        return singleScores;
    }

    @Override
    public int saveMulAnswer(String mlId, String mulAnswer, Object stuId,Object examId,Object mulScore) {
        int mulId = Integer.valueOf(mlId);
        int studentId = Integer.valueOf(stuId+"");
        int mulSco = Integer.valueOf(mulScore+"");
        Map map = new HashMap();
        map.put("mulId",mulId);
        map.put("mulAnswer",mulAnswer);
        map.put("studentId",studentId);
        map.put("examId",examId);
        int mulScores=0;
        //查询正确答案
        List<Map> mulResult = studentExamDao.getMulResult(mulId);
        if (mulResult!=null&&mulResult.size()>0){
            if (mulResult.get(0).get("MUL_RESULT").equals(mulAnswer)){
                mulScores=mulSco;
            }
            map.put("mulScores",mulScores);
            studentExamDao.saveMulAnswer(map);
        }
        //System.out.println("/////////"+mulScores);
        return mulScores;
    }

    @Override
    public int saveJudgeAnswer(String jdeId, Object jdeAnswer, Object stuId,Object examId,Object judgeScore) {
        int judgeId = Integer.valueOf(jdeId);
        String judgeAnswer = jdeAnswer+"";
        int studentId = Integer.valueOf(stuId+"");
        int judgeSco = Integer.valueOf(judgeScore+"");
        Map map = new HashMap();
        map.put("judgeId",judgeId);
        map.put("judgeAnswer",judgeAnswer);
        map.put("studentId",studentId);
        map.put("examId",examId);
        int judgeScores=0;
        //查询正确答案
        List<Map> judgeResult = studentExamDao.getJudgeResult(judgeId);
        if (judgeResult!=null&&judgeResult.size()>0){
            if (judgeResult.get(0).get("JUDGE_RESULT").equals(judgeAnswer)){
                judgeScores=judgeSco;
            }
            map.put("judgeScores",judgeScores);
            studentExamDao.saveJudgeAnswer(map);
        }
        //System.out.println("----"+judgeScores);
        return judgeScores;
    }

    @Override
    public int saveTotalScore(Object studentId, Object examId, int totalScore) {
        Map map = new HashMap();
        map.put("studentId",studentId);
        map.put("examId",examId);
        map.put("totalScore",totalScore);
        studentExamDao.changeState(map);
        return studentExamDao.saveTotalScore(map);
    }
}
