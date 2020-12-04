package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.mapper.RegionDao;
import com.ssafy.happyhouse.model.dto.DongCodeDto;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionDao regionDao;

//	@Override
//	@Transactional(readOnly = true)
//	public List<HouseDto> myList(String id) throws Exception {
//		return houseDao.myList(id);
//	}
	
	@Transactional(readOnly = true)
	public List<DongCodeDto> sidoList() throws Exception {
		return regionDao.sidoList();
	}
	
	@Transactional(readOnly = true)
	public List<DongCodeDto> gugunList(int no) throws Exception {
		return regionDao.gugunList(no);
	}
	
	@Transactional(readOnly = true)
	public List<DongCodeDto> dongList(int no) throws Exception {
		return regionDao.dongList(no);
	}
	
//	@Override
//	public void addHouse(HouseDto dto) throws Exception {
//		houseDao.addHouse(dto);
//	}
//
//	@Override
//	public HouseDto detailHouse(int no) throws Exception {
//		return houseDao.detailHouse(no);
//	}
//
//	@Override
//	public void deleteHouse(int no) throws Exception {
//		houseDao.deleteHouse(no);
//	}
//
//	@Override
//	public void modifyHouse(HouseDto dto) throws Exception {
//		houseDao.modifyHouse(dto);
//	}

}
