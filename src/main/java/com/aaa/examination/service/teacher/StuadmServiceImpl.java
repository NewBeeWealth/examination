package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.StuadmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:StuadmServiceImpl
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-05 15:24
 */
@Service
public class StuadmServiceImpl implements StuadmService {
    //依赖注入
    @Autowired
    private StuadmDao stuadmDao;

    @Override
    public List<Map> getStuList(Map map) {
        return stuadmDao.getStuList(map);
    }

    @Override
    public int getPageCount(Map map) {
        return stuadmDao.getPageCount(map);
    }

    @Override
    public int addStu(Map map) {
        return stuadmDao.addStu(map);
    }

    @Override
    public int updateStu(Map map) {
        return stuadmDao.updateStu(map);
    }

    @Override
    public int deleteStu(Integer STUDENT_ID) {
        return stuadmDao.deleteStu(STUDENT_ID);
    }

    @Override
    public int batchDelete(String ids) {
        boolean isAdd=true;
        if(ids!=null&&!"".equals(ids)){
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                int i= stuadmDao.deleteStu(Integer.valueOf(id));
                if(i<1) isAdd=false;
            }
        }
        if(isAdd) return 1;
        else  return 0;
    }

    @Override
    public List<Map> getClassList() {
        return stuadmDao.getClassList();
    }


}
