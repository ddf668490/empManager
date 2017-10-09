package com.eduask.ddf.ssm.service;

import java.util.List;

import com.eduask.ddf.ssm.bean.Emp;
/**
 * 
 * @author 丁迪峰
 * 员工信息
 */
public interface EmpService {
	/**
	 * 查询全部员工信息
	 * @return 员工集合包含部门
	 */
	List<Emp> selectEmpWithDept();
	/**
	 * 删除员工
	 * @param empId
	 * @return
	 */
	int deleteByEmpId(int empId);
	/**
	 * 添加员工
	 * @param record
	 * @return
	 */
	int insertSelective(Emp record);
	/**
	 * 查询单个员工信息
	 * @param empId
	 * @return
	 */
	Emp selectByPrimaryKey(Integer empId);
	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	int updateEmp(Emp emp);
}
