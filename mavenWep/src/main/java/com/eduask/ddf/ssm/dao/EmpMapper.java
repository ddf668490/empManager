package com.eduask.ddf.ssm.dao;

import com.eduask.ddf.ssm.bean.Emp;
import com.eduask.ddf.ssm.bean.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);
    /**
     * 删除员工
     * @param empId
     * @return
     */
    int deleteByPrimaryKey(Integer empId);
    /**
     * 添加员工
     * @param record
     * @return
     */
    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);
    /**
     * 查询单个员工信息
     * @param empId
     * @return
     */
    Emp selectByPrimaryKey(Integer empId);
    /**
     * 查询多条员工信息（包含部门）
     * @param example
     * @return
     */
    List<Emp> selectByExampleWithDept(EmpExample example);
    /**
     * 查询单条员工信息（包含部门）
     * @param empId（员工id号）
     * @return
     */
    Emp selectByPrimaryKeyWithDept(Integer empId);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);
    /**
     * 更新员工信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}