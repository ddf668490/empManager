package com.eduask.ddf.ssm.service;

import java.util.List;

import com.eduask.ddf.ssm.bean.Dept;
/**
 * 
 * @author ���Ϸ�
 * ������Ϣ
 */
public interface DeptService {
	/**
	 * ��ѯ���в���
	 * @return ���ż���
	 */
	List<Dept> selectByExample();
}
