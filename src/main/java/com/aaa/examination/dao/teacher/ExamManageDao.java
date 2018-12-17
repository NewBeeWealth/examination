package com.aaa.examination.dao.teacher;

import com.aaa.examination.entity.TreeRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Map;

/**
 * className:ExamManageDao
 * discriptoin:
 * author:llw
 * createTime:2018-12-03 22:45
 */
public interface ExamManageDao {

    /**
     * 单选试题列表
     * @return
     */
    @Select({"<script>" +
        "select * from (select rownum rn,t.* from tbl_exam_singlechoice  t where  rownum &lt; #{end} "
       /* +"<if test=\"id!=null and id!=''\"> and empno=#{id} </if>"
        +"<if test=\"name!=null and name!=''\"> and ename like '%'||#{name}||'%' </if>"
        +"<if test=\"deptNo!=null and deptNo!=0\"> and deptno=#{deptNo} </if>"*/
        +")  a where a.rn &gt; #{start} " +
        "</script>"})
    List<Map> getSingleList(Map map);
    /**
     * 插叙分页总数量
     * @param map
     * @return
     */
    @Select({"<script>" +"select count(*) from tbl_exam_singlechoice " +
       /* "<where>"+
        +"<if test=\"id!=null and id!=''\"> and empno=#{id} </if>"
        +"<if test=\"name!=null and name!=''\"> and ename like '%'||#{name}||'%' </if>"
        +"<if test=\"deptNo!=null and deptNo!=0\"> and deptno=#{deptNo} </if>"+
        "</where>" +*/
        "</script>"})
    int getSinglePageCount(Map map);

    /**
     * 删除试题
     * @param empNo
     * @return
     */
    @Delete("delete from tbl_exam_singlechoice where SINGLE_ID=#{empNo}")
    int delete(Integer empNo);
    /**
     * 更新试题
     * @param map
     * @return
     */
    @Update("update tbl_exam_singlechoice set SINGLE_MAIN=#{SINGLE_MAIN},SINGLE_BANK=#{SINGLE_BANK} where SINGLE_ID=#{SINGLE_ID}")
    int update(Map map);

    /**
     * ftp上传
     * @return
     */
    @Insert("insert into tbl_addexcel(FILE_ID,FILE_PATH,FILE_NAME) values(file_excel.nextval,#{filePath},#{fileName})")
    int add(Map map);

    /**
     * 单选试题列表
     * @return
     */
    @Select({"<script>" +
        "select * from (select rownum rn,t.* from tbl_occupation  t where  rownum &lt; #{pageSize} "
       /* +"<if test=\"id!=null and id!=''\"> and empno=#{id} </if>"
        +"<if test=\"name!=null and name!=''\"> and ename like '%'||#{name}||'%' </if>"
        +"<if test=\"deptNo!=null and deptNo!=0\"> and deptno=#{deptNo} </if>"*/
        +")  a where a.rn &gt; #{pageNo} " +
        "</script>"})
    List<Map> getOccupationList(Map map);
    /**
     * 插叙分页总数量
     * @param map
     * @return
     */
    @Select({"<script>" +"select count(*) from tbl_occupation " +
       /* "<where>"+
        +"<if test=\"id!=null and id!=''\"> and empno=#{id} </if>"
        +"<if test=\"name!=null and name!=''\"> and ename like '%'||#{name}||'%' </if>"
        +"<if test=\"deptNo!=null and deptNo!=0\"> and deptno=#{deptNo} </if>"+
        "</where>" +*/
        "</script>"})
    int getOccupationCount(Map map);
    /**
     * 权限表数据
     * @param map
     * @return
     */
    @Select("select * from tbl_function")
    List<Tree> getRole(Map map);

    /**
     *
     * @return
     */
    @Select("select function_id as id,function_name as label,function_coding as functioncoding,function_url as functionurl  from tbl_function")
    List<TreeRole> getList();

    /**
     * 清除该id的权限
     * @param id
     * @return
     */
    @Delete("delete from TBL_FUNCTION_OCCUPATION where FUN_OCC_OCCUPATION=#{roleId}")
    int delFun(int id);
    /**
     * 批量添加
     * @param map
     * @return
     */
    @Insert({"<script>"
        +"insert into TBL_FUNCTION_OCCUPATION "
        +"<foreach item='map' collection='list' separator='union'>"
        +" select #{map.pid},#{map.roleId} from dual "
        +"</foreach>"
        +"</script>"})
    int addPower(List<Map> map);
}
