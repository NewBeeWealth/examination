package com.aaa.examination.service.historyexam;

import com.aaa.examination.dao.historyexam.HistoryExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:HistoryExamServiceImpl
 * discriptoin:
 * author:dzq
 * createTime:2018-12-04 16:58
 */
@Service
public class HistoryExamServiceImpl implements HistoryExamService {
    @Autowired
    HistoryExamDao historyExamDao;

    @Override
    public List<Map> getList(Map map) {
        //map.put("state",2);
        //System.out.println("******"+map);
        /*List<Map> examIds = historyExamDao.getExamId(map);
        if (examIds!=null&&examIds.size()>0){
            for (Map examId : examIds) {
                map.put("examId",examId.get("STUDENTEXAM_EXAM"));
                historyExamDao.getList(map);
            }
        }*/
        //System.out.println("/////////////"+historyExamDao.getList(map));
        return historyExamDao.getList(map);
    }

    @Override
    public int getPageCount(Map map) {
        int pageCount = historyExamDao.getPageCount(map);
        return pageCount;
    }

    @Override
    public List<Map> examTop(Map map) {
        return historyExamDao.examTop(map);
    }

    @Override
    public List<Map> getSingleDetail(Map map) {
        return historyExamDao.getSingleDetail(map);
    }

    @Override
    public List<Map> getMulDetail(Map map) {
        return historyExamDao.getMulDetail(map);
    }

    @Override
    public List<Map> getJudgeDetail(Map map) {
        return historyExamDao.getJudgeDetail(map);
    }

}
