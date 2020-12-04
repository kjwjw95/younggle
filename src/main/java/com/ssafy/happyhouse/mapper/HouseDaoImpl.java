package com.ssafy.happyhouse.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.JoinDto;
import com.ssafy.happyhouse.model.dto.ReservationDto;

@Repository
public class HouseDaoImpl implements HouseDao {

	private String ns = "com.ssafy.vue.dao.HouseMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<HouseDto> myList(String id) throws Exception {
		return sqlSession.selectList(ns + "myList", id);
	}

	@Override
	public List<JoinDto> reservationList(String id) throws Exception {
		return sqlSession.selectList(ns + "reservationList", id);
	}

	@Override
	public List<JoinDto> rereservationList(String id) throws Exception {
		return sqlSession.selectList(ns + "rereservationList", id);
	}
	
	@Override
	public void addHouse(HouseDto dto) throws Exception {
		sqlSession.insert(ns + "addHouse", dto);
	}

	@Override
	public void addReservation(ReservationDto dto) throws Exception {
		sqlSession.insert(ns + "addReservation", dto);
	}

	@Override
	public HouseDto detailHouse(int no) throws Exception {
		return sqlSession.selectOne(ns + "detailHouse", no);
	}
	
	@Override
	public void deleteHouse(int no) throws Exception {
		sqlSession.delete(ns + "deleteHouse", no);
	}
	@Override
	public void reservDelete(int num) throws Exception {
		sqlSession.delete(ns + "reservDelete", num);
	}
	@Override
	public void reservModify(int num) throws Exception {
		sqlSession.update(ns + "reservModify", num);
	}
	
	@Override
	public void modifyHouse(HouseDto dto) throws Exception {
		sqlSession.update(ns + "modifyHouse", dto);
	}

	@Override
	public List<HouseDto> list() throws Exception {
		return sqlSession.selectList(ns + "list");
	}
	
	@Override
	public List<HouseDto> list(String dongcode) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dongCode", dongcode);
		map.put("length", dongcode.length()+"");
		System.out.println(map.get("dongCode"));
		System.out.println(map.get("length"));
		if(dongcode.length() == 2)
			return sqlSession.selectList(ns + "silist",map);
		else if(dongcode.length()==5)
			return sqlSession.selectList(ns + "gulist",map);
		else
			return sqlSession.selectList(ns + "donglist",dongcode);
    }

	@Override
	public List<HouseDto> list(Map<String, String> map) throws Exception {
		return sqlSession.selectList(ns + "searchList", map);
	}

    @Override
    public List<HouseDto> selectBoardLimitOffset(Map<String, Object> map) {
        return sqlSession.selectList(ns + "selectBoardLimitOffset", map);
    }
   
    @Override
    public int selectBoardTotalCount(Map<String, Object> map) {
        return sqlSession.selectOne(ns + "selectBoardLimitOffsetCount", map);
    }

    @Override
    public int selectBoardTotalCount() {
        return sqlSession.selectOne(ns + "selectBoardTotalCount");
    }

}
