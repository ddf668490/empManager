package com.eduask.ddf.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduask.ddf.ssm.bean.Emp;
import com.eduask.ddf.ssm.bean.Msg;
import com.eduask.ddf.ssm.service.DeptService;
import com.eduask.ddf.ssm.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@Autowired
	private DeptService deptService;
	@RequestMapping("/emp")
	public String toEmp(@RequestParam(value="pn" ,defaultValue="1")Integer pn ,Model model){
		PageHelper.startPage(pn,5);
		List<Emp> emps = empService.selectEmpWithDept();
		PageInfo<Emp> pageInfo = new PageInfo<>(emps,5);
		model.addAttribute("pageInfo",pageInfo);
		return "emp";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String tolist(){
		return "list";
	}
	/**
	 * 分页查询员工信息
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Msg list(@RequestParam(value="pn" ,defaultValue="1")Integer pn){
		PageHelper.startPage(pn,5);
		List<Emp> emps = empService.selectEmpWithDept();
		PageInfo<Emp> pageInfo = new PageInfo<>(emps,5);
		return Msg.success().add("page", pageInfo);
	}
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	@ResponseBody
	public Msg addEmp(Emp emp){
		return Msg.success().add("i", empService.insertSelective(emp));
	}
	/**
	 * 通过id获取待员工修改信息
	 * @param emp_id
	 * @return
	 */
	@RequestMapping(value="/editEmp",method=RequestMethod.GET)
	@ResponseBody
	public Msg editEmp(Integer emp_id){
		return Msg.success().add("emp", empService.selectByPrimaryKey(emp_id)).add("depts", deptService.selectByExample());
	}
	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/updateEmp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateEmp(Emp emp){
		empService.updateEmp(emp);
		return Msg.success();
	}
	/**
	 *删除单个员工
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/delEmp",method=RequestMethod.POST)
	@ResponseBody
	public int delEmp(Integer empId){
		int line = empService.deleteByEmpId(empId);
		return line;
	}
}