package com.eduask.ddf.ssm.service;

import java.util.List;

import com.eduask.ddf.ssm.bean.Dept;

public interface DeptService {
	List<Dept> selectByExample();
}
