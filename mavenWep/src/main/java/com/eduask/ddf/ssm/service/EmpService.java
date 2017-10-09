package com.eduask.ddf.ssm.service;

import java.util.List;

import com.eduask.ddf.ssm.bean.Emp;
/**
 * 
 * @author ���Ϸ�
 * Ա����Ϣ
 */
public interface EmpService {
	/**
	 * ��ѯȫ��Ա����Ϣ
	 * @return Ա�����ϰ�������
	 */
	List<Emp> selectEmpWithDept();
	/**
	 * ɾ��Ա��
	 * @param empId
	 * @return
	 */
	int deleteByEmpId(int empId);
	/**
	 * ���Ա��
	 * @param record
	 * @return
	 */
	int insertSelective(Emp record);
	/**
	 * ��ѯ����Ա����Ϣ
	 * @param empId
	 * @return
	 */
	Emp selectByPrimaryKey(Integer empId);
	/**
	 * �޸�Ա����Ϣ
	 * @param emp
	 * @return
	 */
	int updateEmp(Emp emp);
}
