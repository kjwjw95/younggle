package com.ssafy.happyhouse.model.dto;

public class HouseDealDto {

	private String no;
	private String dong;
	private String aptName;
	private String code;
	
	private String dealAmount;
	private String buildYear;
	private String type;
	private boolean check;
	
	public HouseDealDto() {
	}

	public HouseDealDto(String no, String dong, String aptName, String code, String dealAmount, String buildYear, boolean check) {
		this.no = no;
		this.dong = dong;
		this.aptName = aptName;
		this.code = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.type = type;
		this.check = check;
	}
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "HouseDealDto [no=" + no + ", dong=" + dong + ", aptName=" + aptName + ", code=" + code + ", dealAmount="
				+ dealAmount + ", buildYear=" + buildYear + ", type=" + type + "]";
	}
	
	
}
