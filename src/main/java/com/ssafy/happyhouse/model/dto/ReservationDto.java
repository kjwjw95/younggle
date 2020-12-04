package com.ssafy.happyhouse.model.dto;

public class ReservationDto {
	private int num;
	private String id;
	private int no;
	private String date;
	private String regiDate;
	private String value;
	
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
	public String getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "ReservationDto [num=" + num + ", id=" + id + ", no=" + no + ", date=" + date + ", regiDate=" + regiDate
				+ ", value=" + value + "]";
	}
	
}
