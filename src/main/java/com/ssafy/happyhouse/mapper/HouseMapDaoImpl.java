package com.ssafy.happyhouse.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

@Repository
public class HouseMapDaoImpl implements HouseMapDao {
	
	@Autowired
	SqlSession session;
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return session.selectList("ssafy.house.list");
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return session.selectList("ssafy.house.list2", sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return session.selectList("ssafy.house.list3", gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return session.selectList("ssafy.house.list4", dong);
	}

	//paging
	@Override
	public List<HouseInfoDto> getAptInDong(String dong, int currentPage, int sizePerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dong", dong);
		map.put("currentPage", currentPage);
		map.put("sizePerPage", sizePerPage);
		map.put("sp", currentPage * sizePerPage - 2);
		return session.selectList("ssafy.house.paging", map);
	}

	@Override
	public int getTotalCount(String dong) {
		return session.selectOne("ssafy.house.count", dong);
	}
}
