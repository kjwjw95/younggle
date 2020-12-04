package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.ReservationDto;
import com.ssafy.happyhouse.model.dto.JoinDto;


public interface HouseService {
	public List<HouseDto> myList(String id) throws Exception;
	public void addHouse(HouseDto dto) throws Exception;
	public void addReservation(ReservationDto dto) throws Exception;
	public List<JoinDto> reservationList(String id) throws Exception;
	public void reservDelete(int num) throws Exception;
	public void reservModify(int num) throws Exception;
	public List<JoinDto> rereservationList(String id) throws Exception;
	public List<HouseDto> list() throws Exception;
	public List<HouseDto> list(String dongCode, String type, String houseType, String price, String monthPrice, String area, String room, String typeChoice, String keyword) throws Exception;
	public HouseDto detailHouse(int no) throws Exception;
	public void deleteHouse(int no) throws Exception;
	public void modifyHouse(HouseDto dto) throws Exception;
	public List<HouseDto> list(String dongCode) throws Exception;
	public List<HouseDto> selectBoardLimitOffset(Integer limit, Integer offset,String dongCode, String type, String houseType, String price, String monthPrice, String area, String room, String typeChoice, String keyword) throws Exception;
    public int selectBoardTotalCount(String dongCode, String type, String houseType, String price, String monthPrice, String area, String room, String typeChoice, String keyword) throws Exception;
    public int selectBoardTotalCount();
}
