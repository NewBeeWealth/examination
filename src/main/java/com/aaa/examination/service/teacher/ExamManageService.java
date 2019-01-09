package com.aaa.examination.service.teacher;

import com.aaa.examination.entity.TreeRole;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Map;

/**
 * className:ExamManageService
 * discriptoin:
 * author:llw
 * createTime:2018-12-03 22:46
 */
public interface ExamManageService {
    /**
     * 查询所有题库
     * @return
     */
    List<Map> getQuestionBank();
    /**
     * 单选试题列表
     * @return
     */
    List<Map> getSingleList(Map map);
    /**
     * 插叙分页总数量
     * @param map
     * @return
     */
    int getSinglePageCount(Map map);

    /**
     * 删除试题
     * @param empNo
     * @return
     */
    int delete(Integer empNo);
    /**
     * 更新试题
     * @param map
     * @return
     */
    int update(Map map);
    /**
     * ftp上传
     * @return
     */
    int add(Map map);
    /**
     * 单选试题列表
     * @return
     */
    List<Map> getOccupationList(Map map);
    /**
     * 插叙分页总数量
     * @param map
     * @return
     */
    int getOccupationCount(Map map);

    /**
     * 权限表数据
     * @param map
     * @return
     */
    List<Tree> getRole(Map map);

    /**
     * 权限树
     * @return
     */
    List<TreeRole> getList();

    /**
     * 修改权限
     * @param map
     * @return
     */
    int addPower(Map map);
}
