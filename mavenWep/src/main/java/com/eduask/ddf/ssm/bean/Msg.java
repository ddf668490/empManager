package com.eduask.ddf.ssm.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	private int code;//����ɹ�100 ʧ��200
	private String info;//��Ϣ
	Map<String, Object> data = new HashMap<>();
	public static Msg success(){
		Msg msg = new Msg();
		msg.code = 100;
		msg.info = "�����ɹ�";
		return msg;
	}
	public static Msg fail(){
		Msg msg = new Msg();
		msg.code = 200;
		msg.info = "����ʧ��";
		return msg;
	}
	public  Msg add(String key,Object value) {
		this.data.put(key,value);
		return this;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
