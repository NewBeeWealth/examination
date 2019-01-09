package com.aaa.examination.service.studentscore;

import com.aaa.examination.dao.studentscore.StudentScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:StudentScoreServiceImpl
 * discriptoin:
 * author:dzq
 * createTime:2019-01-07 09:59
 */
@Service
public class StudentScoreServiceImpl implements StudentScoreService {
    @Autowired
    private StudentScoreDao studentScoreDao;

    @Override
    public List<Map> getExamClass() {
        List<Map> examNameList = studentScoreDao.getExamName();
        if (examNameList!=null&&examNameList.size()>0){
            for (Map map : examNameList) {
                List<Map> examClassList = studentScoreDao.getExamClass(map);
                map.put("examClassList",examClassList);
            }
        }
        return examNameList;
    }

    @Override
    public List<Map> getStudentScore(Map map) {
        List<Map> studentIdList = studentScoreDao.getStudentId(map);
        System.out.println("|||"+studentIdList);
        List studentScoreList = new ArrayList();
        if (studentIdList!=null&&studentIdList.size()>0){
            for (Map studentIdMap : studentIdList) {
                studentIdMap.put("examId",map.get("examId"));
                System.out.println("==="+studentIdMap);
                List<Map> studentScore = studentScoreDao.getStudentScore(studentIdMap);
                System.out.println("-=-=="+studentScore);
                if (studentScore!=null&&studentScore.size()>0) {
                    studentScoreList.add(studentScore.get(0));
                }
            }
        }
        return studentScoreList;
    }
}
