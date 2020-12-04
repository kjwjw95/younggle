package com.ssafy.happyhouse.model.dto;

public class DongCodeDto {

	private String dongCode;
	private String sido;
	private String gugun;
	private String dong;
	private String li;
	private String lat;
	private String lng;
	
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getLi() {
		return li;
	}
	public void setLi(String li) {
		this.li = li;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "DongCodeDto [dongCode=" + dongCode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", li="
				+ li + ", lat=" + lat + ", lng=" + lng + "]";
	}

}
