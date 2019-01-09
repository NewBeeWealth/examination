package com.aaa.examination.service.student;

import com.aaa.examination.dao.student.StudentinfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class StudentInfoServiceImpl implements StudentInfoService{
    @Autowired
    StudentinfoDao studentinfoDao;

    /**
     * 查询信息
     * @param map
     * @return
     */
    @Override
    public List<Map> StudentInfo(Map map) {

        return studentinfoDao.studentInfo(map);
    }

    /**
     * 修改信息 姓名
     * @param map
     * @return
     */
    @Override
    public int updateinfo(Map map) {
        int i = studentinfoDao.updateinfo(map);
        System.out.println("i============"+i);
        System.out.println("-------------修改的map------"+map);
        return i;
    }

}
