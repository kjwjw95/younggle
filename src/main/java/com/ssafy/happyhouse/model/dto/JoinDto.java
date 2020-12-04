package com.ssafy.happyhouse.model.dto;

public class JoinDto {
	private int num;
	private String id;
	private int no;
	private String date;
	private String reservDate;
	private String value;
	private String tel;
	private String addr;
	private String addAddr;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReservDate() {
		return reservDate;
	}
	public void setReservDate(String reservDate) {
		this.reservDate = reservDate;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddAddr() {
		return addAddr;
	}
	public void setAddAddr(String addAddr) {
		this.addAddr = addAddr;
	}
	
	@Override
	public String toString() {
		return "JoinDto [num=" + num + ", id=" + id + ", no=" + no + ", date=" + date + ", reservDate=" + reservDate
				+ ", value=" + value + ", tel=" + tel + ", addr=" + addr + ", addAddr=" + addAddr + "]";
	}
	
}
