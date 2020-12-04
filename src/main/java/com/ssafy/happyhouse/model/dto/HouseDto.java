package com.ssafy.happyhouse.model.dto;

public class HouseDto {
	private int no;
	private String id;
	private String tel;
	private String type;
	private String houseType;
	private String postCode;
	private String dongCode;
	private String addr;
	private String addAddr;
	private String layer;
	private String area;
	private String direction;
	private String room;
	private String bathroom;
	private String yearMonth;
	private String addValue;
	private String price;
	private String monthPrice;
	private String financing;
	private String date;
	private String deal;
	private String regiDate;
	private String lat;
	private String lng;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
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
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getBathroom() {
		return bathroom;
	}
	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getAddValue() {
		return addValue;
	}
	public void setAddValue(String addValue) {
		this.addValue = addValue;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMonthPrice() {
		return monthPrice;
	}
	public void setMonthPrice(String monthPrice) {
		this.monthPrice = monthPrice;
	}
	public String getFinancing() {
		return financing;
	}
	public void setFinancing(String financing) {
		this.financing = financing;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeal() {
		return deal;
	}
	public void setDeal(String deal) {
		this.deal = deal;
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
		return "HouseDto [no=" + no + ", id=" + id + ", tel=" + tel + ", type=" + type + ", houseType=" + houseType
				+ ", postCode=" + postCode + ", dongCode=" + dongCode + ", addr=" + addr + ", addAddr=" + addAddr
				+ ", layer=" + layer + ", area=" + area + ", direction=" + direction + ", room=" + room + ", bathroom="
				+ bathroom + ", yearMonth=" + yearMonth + ", addValue=" + addValue + ", price=" + price
				+ ", monthPrice=" + monthPrice + ", financing=" + financing + ", date=" + date + ", deal=" + deal
				+ ", regiDate=" + regiDate + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
}
