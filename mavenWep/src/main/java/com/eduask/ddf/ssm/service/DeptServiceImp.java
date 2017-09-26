package com.eduask.ddf.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduask.ddf.ssm.bean.Dept;
import com.eduask.ddf.ssm.dao.DeptMapper;

@Service
public class DeptServiceImp implements DeptService {
	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<Dept> selectByExample() {
		// TODO Auto-generated method stub
		return  deptMapper.selectByExample(null);
	}
}
