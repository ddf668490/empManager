package com.eduask.ddf.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduask.ddf.ssm.bean.Dept;
import com.eduask.ddf.ssm.bean.Msg;
import com.eduask.ddf.ssm.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;

	@RequestMapping(value="/listDept",method=RequestMethod.POST)
	@ResponseBody
	public Msg listDept(){
		List<Dept> depts = deptService.selectByExample();
		return Msg.success().add("depts", depts);
	}
}
