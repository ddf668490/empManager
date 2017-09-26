package com.eduask.ddf.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduask.ddf.ssm.bean.Emp;
import com.eduask.ddf.ssm.bean.EmpExample;
import com.eduask.ddf.ssm.bean.EmpExample.Criteria;
import com.eduask.ddf.ssm.dao.EmpMapper;
@Service
public class EmpServiceImp implements EmpService {
	@Autowired
	private EmpMapper empMapper;
	@Override
	public List<Emp> selectEmpWithDept() {
		EmpExample example = new EmpExample();
		example.setOrderByClause("emp_id");
		// TODO Auto-generated method stub
		return empMapper.selectByExampleWithDept(example);
	}
	@Override
	public int deleteByEmpId(int empId) {
		return empMapper.deleteByPrimaryKey(empId);
	}
	@Override
	public int insertSelective(Emp record) {
		// TODO Auto-generated method stub
		return empMapper.insert(record);
	}
	@Override
	public Emp selectByPrimaryKey(Integer empId) {
		// TODO Auto-generated method stub
		return empMapper.selectByPrimaryKey(empId);
	}
	@Override
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empMapper.updateByPrimaryKeySelective(emp);
	}
}
