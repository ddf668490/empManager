package com.eduask.ddf.ssm.service;

import java.util.List;

import com.eduask.ddf.ssm.bean.Emp;
import com.eduask.ddf.ssm.bean.EmpExample;

public interface EmpService {
	   List<Emp> selectEmpWithDept();
	   int deleteByEmpId(int empId);
	   int insertSelective(Emp record);
	   Emp selectByPrimaryKey(Integer empId);
	   int updateEmp(Emp emp);
}
