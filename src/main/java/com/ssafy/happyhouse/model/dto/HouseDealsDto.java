package com.ssafy.happyhouse.model.dto;

public class HouseDealsDto {

	private String no;
	private String dong;
	private String AptName;
	private String code;
	
	private String dealAmount;
	private String buildYear;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String floor;
	private String jibun;
	private String type;
	private boolean check;
	
	public HouseDealsDto() {
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
		return AptName;
	}

	public void setAptName(String AptName) {
		this.AptName = AptName;
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

	public String getDealYear() {
		return dealYear;
	}

	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}

	public String getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}

	public String getDealDay() {
		return dealDay;
	}

	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public HouseDealsDto(String dong, String aptName, String code, String dealAmount, String buildYear,
			String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun, String type) {
		super();
		this.dong = dong;
		this.AptName = aptName;
		this.code = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.jibun = jibun;
		this.type = type;
	}

	@Override
	public String toString() {
		return "HouseDealDto [no=" + no + ", dong=" + dong + ", aptName=" + AptName + ", code=" + code + ", dealAmount="
				+ dealAmount + ", buildYear=" + buildYear + ", dealYear=" + dealYear + ", dealMonth=" + dealMonth
				+ ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor + ", jibun=" + jibun + ", type=" + type
				+ ", check=" + check + "]";
	}

	
	
	
}

