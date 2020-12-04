package com.ssafy.happyhouse.model.dto;

public class InterDto {

	private String no;
	private String email;
	private String date;
	
	public InterDto() {
	}

	public InterDto(String no, String email, String date) {
		this.no = no;
		this.email = email;
		this.date = date;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


}
