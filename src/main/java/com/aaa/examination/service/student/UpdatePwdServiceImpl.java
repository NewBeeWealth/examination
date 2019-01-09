package com.aaa.examination.service.student;

import com.aaa.examination.dao.student.UpdatePwdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class UpdatePwdServiceImpl implements UpdatePwdService{

    @Autowired
  private   UpdatePwdDao updatePwdDao;
    @Override
    public List<Map> selectPwd(Map map) {
        return updatePwdDao.selectPwd(map);
    }

    /**
     * 修改密码
     * @return
     */
    @Override
    public int updatePwd(Map map) {
        return updatePwdDao.updatePwd(map);
    }
}
