package com.ssafy.happyhouse.model.dto;

public class QuestionDto {
	private int no;
	private String id;
	private String questionType;
	private String title;
	private String question_describe;
	private String reply;
	private String writetime;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion_describe() {
		return question_describe;
	}
	public void setQuestion_describe(String question_describe) {
		this.question_describe = question_describe;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	
	@Override
	public String toString() {
		return "QuestionDto [no=" + no + ", id=" + id + ", questionType=" + questionType + ", title=" + title
				+ ", question_describe=" + question_describe + ", reply=" + reply + ", writetime=" + writetime + "]";
	}
	
}
