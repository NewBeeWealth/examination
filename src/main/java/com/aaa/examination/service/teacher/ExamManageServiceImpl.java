package com.aaa.examination.service.teacher;

import com.aaa.examination.dao.teacher.ExamManageDao;
import com.aaa.examination.entity.TreeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:ExamManageServiceImpl
 * discriptoin:
 * author:llw
 * createTime:2018-12-03 22:46
 */
@Service
public class ExamManageServiceImpl implements ExamManageService{

    @Autowired
    private ExamManageDao examManageDao;

    @Override
    public List<Map> getQuestionBank() {
        return examManageDao.getQuestionBank();
    }

    @Override
    public List<Map> getSingleList(Map map) {
        return examManageDao.getSingleList(map);
    }

    @Override
    public int getSinglePageCount(Map map) {
        return examManageDao.getSinglePageCount(map);
    }

    @Override
    public int delete(Integer empNo) {
        return examManageDao.delete(empNo);
    }

    @Override
    public int update(Map map) {
        return examManageDao.update(map);
    }

    @Override
    public int add(Map map) {
        return examManageDao.add(map);
    }

    @Override
    public List<Map> getOccupationList(Map map) {
        return examManageDao.getOccupationList(map);
    }

    @Override
    public int getOccupationCount(Map map) {
        return examManageDao.getOccupationCount(map);
    }

    @Override
    public List<Tree> getRole(Map map) {
        return examManageDao.getRole(map);
    }

    @Override
    public List<TreeRole> getList() {
        List<TreeRole> list = examManageDao.getList();
        List<TreeRole> treeNodesList = new ArrayList<TreeRole>();
        if(list!=null&&list.size()>0){
            for (TreeRole treeNode : list) {
                //一级菜单
                if(treeNode.getFunctioncoding()==0){
                    treeNodesList.add(treeNode);
                    //循环绑定子节点
                    bindChirdren(treeNode,list);
                }
            }
        }
        return treeNodesList;
    }

    /**
     * 修改权限
     * @param map
     * @return
     */
    @Override
    public int addPower(Map map) {
        int roleId = Integer.valueOf(map.get("roleId")+"");
        examManageDao.delFun(roleId);
        String str = (String) map.get("ids");
        String[] strArray = str.split(",");
        List<Map> list= new ArrayList();
        Map tempMap = null;
        for(int i=0;i<strArray.length;i++){
            tempMap =new HashMap();
            tempMap.put("pid", strArray[i]);
            tempMap.put("roleId",roleId);
            list.add(tempMap);
        }
        return examManageDao.addPower(list);
    }

    /**
     * 递归绑定子节点
     * @param treeNode
     * @param treeNodesList
     */
    public void bindChirdren(TreeRole treeNode,List<TreeRole> treeNodesList){
        for (TreeRole node : treeNodesList) {
            if(node.getFunctioncoding()==treeNode.getId()){
                List<TreeRole> children = treeNode.getChildren();
                if(children==null){
                    children=new ArrayList<TreeRole>();
                }
                children.add(node);
                treeNode.setChildren(children);
                //递归调用自己
                bindChirdren(node,treeNodesList);
            }
        }
    }


}
