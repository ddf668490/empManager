package com.eduask.ddf.ssm.bean;
/**
 * @author 丁迪峰
 * 部门实体类 
 */
public class Dept {
    private Integer did;

    private String dname;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }
}