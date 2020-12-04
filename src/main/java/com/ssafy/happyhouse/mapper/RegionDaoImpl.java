package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.DongCodeDto;

@Repository
public class RegionDaoImpl implements RegionDao {

	private String ns = "com.ssafy.vue.dao.RegionMapper.";

	@Autowired
	private SqlSession sqlSession;

//	@Override
//	public List<HouseDto> myList(String id) throws Exception {
//		return sqlSession.selectList(ns + "myList", id);
//	}
//
//	@Override
//	public void addHouse(HouseDto dto) throws Exception {
//		sqlSession.insert(ns + "addHouse", dto);
//	}
//
//	@Override
//	public HouseDto detailHouse(int no) throws Exception {
//		return sqlSession.selectOne(ns + "detailHouse", no);
//	}
//	
//	@Override
//	public void deleteHouse(int no) throws Exception {
//		sqlSession.delete(ns + "deleteHouse", no);
//	}
//
//	@Override
//	public void modifyHouse(HouseDto dto) throws Exception {
//		sqlSession.update(ns + "modifyHouse", dto);
//	}

	@Override
	public List<DongCodeDto> sidoList() throws Exception {
		return sqlSession.selectList(ns + "sidoList");
	}

	@Override
	public List<DongCodeDto> gugunList(int no) throws Exception {
		return sqlSession.selectList(ns + "gugunList", no);
	}

	@Override
	public List<DongCodeDto> dongList(int no) throws Exception {
		return sqlSession.selectList(ns + "dongList", no);
	}
	
}
