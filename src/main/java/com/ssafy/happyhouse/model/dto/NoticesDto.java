package com.ssafy.happyhouse.model.dto;

public class NoticesDto {
	private int no;
	private String title;
	private String notice_describe;
	private String writetime;
	private int top;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNotice_describe() {
		return notice_describe;
	}
	public void setNotice_describe(String notice_describe) {
		this.notice_describe = notice_describe;
	}
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	@Override
	public String toString() {
		return "NoticesDto [no=" + no + ", title=" + title + ", notice_describe=" + notice_describe + ", writetime="
				+ writetime + ", top=" + top + "]";
	}
		
}
