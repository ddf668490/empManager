package com.eduask.ddf.ssm.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eduask.ddf.ssm.bean.Emp;
import com.eduask.ddf.ssm.bean.EmpExample;
import com.eduask.ddf.ssm.bean.EmpExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestEmpMapper {
	@Autowired
	EmpMapper empMapper;
	@Test
	public void test(){
		System.out.println(empMapper);
	}
	@Test
	public void test1(){
		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameLike("%e2%");
		System.out.println(empMapper.selectByExample(example));
	
	}
	@Test
	public void test2(){
		PageHelper.startPage(2, 5);
		List<Emp> emps = empMapper.selectByExample(null);
		for (Emp emp : emps) {
			System.out.println(emp);
		}
//		PageInfo<Emp> pageInfo = new PageInfo<>(emps,5);  
//		System.out.println(pageInfo.getPageNum());
//		System.out.println(pageInfo.getPages());
//		System.out.println(pageInfo.getPageSize());
//		System.out.println(pageInfo.getTotal());
//		System.out.println(pageInfo.isHasNextPage());
//		System.out.println(pageInfo.isHasPreviousPage());
//		System.out.println(pageInfo.getNavigateFirstPage());
//		System.out.println(pageInfo.isIsFirstPage());
	}
}
