package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.DongCodeDto;


public interface RegionService {
	
//	public List<HouseDto> myList(String id) throws Exception;
//	public void addHouse(HouseDto dto) throws Exception;
	public List<DongCodeDto> sidoList() throws Exception;
	public List<DongCodeDto> gugunList(int no) throws Exception;
	public List<DongCodeDto> dongList(int no) throws Exception;
	
//	public HouseDto detailHouse(int no) throws Exception;
//	public void deleteHouse(int no) throws Exception;
//	public void modifyHouse(HouseDto dto) throws Exception;
			
}
