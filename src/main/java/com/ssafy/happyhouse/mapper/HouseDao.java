package com.ssafy.happyhouse.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.JoinDto;
import com.ssafy.happyhouse.model.dto.ReservationDto;


public interface HouseDao {
	public List<HouseDto> myList(String id) throws Exception;
	public List<HouseDto> list() throws Exception;
	public List<HouseDto> list(String dongcode) throws Exception; 
	public List<HouseDto> list(Map<String, String> map) throws Exception;
	public List<JoinDto> reservationList(String id) throws Exception;
	public void deleteHouse(int no) throws Exception;
	public void reservDelete(int num) throws Exception;
	public void reservModify(int num) throws Exception;
	public List<JoinDto> rereservationList(String id) throws Exception;
	public void addHouse(HouseDto dto) throws Exception;
	public void addReservation(ReservationDto dto) throws Exception;
	public HouseDto detailHouse(int no) throws Exception;
	public void modifyHouse(HouseDto dto) throws Exception;
	public List<HouseDto> selectBoardLimitOffset(Map<String, Object> map);
    public int selectBoardTotalCount(Map<String, Object> map);
	public int selectBoardTotalCount();
}
