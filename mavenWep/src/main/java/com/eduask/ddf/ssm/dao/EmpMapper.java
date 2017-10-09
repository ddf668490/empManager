package com.eduask.ddf.ssm.dao;

import com.eduask.ddf.ssm.bean.Emp;
import com.eduask.ddf.ssm.bean.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);
    /**
     * ɾ��Ա��
     * @param empId
     * @return
     */
    int deleteByPrimaryKey(Integer empId);
    /**
     * ���Ա��
     * @param record
     * @return
     */
    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);
    /**
     * ��ѯ����Ա����Ϣ
     * @param empId
     * @return
     */
    Emp selectByPrimaryKey(Integer empId);
    /**
     * ��ѯ����Ա����Ϣ���������ţ�
     * @param example
     * @return
     */
    List<Emp> selectByExampleWithDept(EmpExample example);
    /**
     * ��ѯ����Ա����Ϣ���������ţ�
     * @param empId��Ա��id�ţ�
     * @return
     */
    Emp selectByPrimaryKeyWithDept(Integer empId);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);
    /**
     * ����Ա����Ϣ
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}