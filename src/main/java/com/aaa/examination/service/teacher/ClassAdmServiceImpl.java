package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.ClassAdmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ClassAdmServiceImpl
 * discriptoin:
 * author:FLZ
 * createTime:2018-12-21 09:58
 */
@Service
public class ClassAdmServiceImpl implements ClassAdmService{
    //依赖注入
    @Autowired
    private ClassAdmDao classAdmDao;
    @Override
    public List<Map> getClassList(Map map) {
        return classAdmDao.getClassList(map);
    }

    @Override
    public int getPageCount(Map map) {
        return classAdmDao.getPageCount(map);
    }

    @Override
    public int addClass(Map map) {
        return classAdmDao.addClass(map);
    }

    @Override
    public int updateClass(Map map) {
        return classAdmDao.updateClass(map);
    }

    @Override
    public int deleteClass(Integer CLASSID) {
        return classAdmDao.deleteClass(CLASSID);
    }

    @Override
    public int batchDelete(String ids) {
        boolean isAdd=true;
        if(ids!=null&&!"".equals(ids)){
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                int i= classAdmDao.deleteClass(Integer.valueOf(id));
                if(i<1) isAdd=false;
            }
        }
        if(isAdd) return 1;
        else  return 0;
    }

    @Override
    public List<Map> getStateList() {
        return classAdmDao.getStateList();
    }
}
