package com.eduask.ddf.ssm.service;

import java.util.List;

import com.eduask.ddf.ssm.bean.Dept;
/**
 * 
 * @author 丁迪峰
 * 部门信息
 */
public interface DeptService {
	/**
	 * 查询所有部门
	 * @return 部门集合
	 */
	List<Dept> selectByExample();
}
