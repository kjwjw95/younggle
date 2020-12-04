package com.ssafy.happyhouse.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.NoticesDto;
@Repository
public class NoticesDaoImpl implements NoticesDao{
	
    private String ns="com.ssafy.vue.dao.NoticeMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticesDto> topNotices() throws Exception {
		return sqlSession.selectList(ns+"topNotices");
	}
	
	@Override
	public List<NoticesDto> defaultNotices() throws Exception {
		return sqlSession.selectList(ns+"defaultNotices");
	}

	@Override
	public NoticesDto detailNotice(int no) throws Exception {
		return sqlSession.selectOne(ns+"detailNotice", no);
	}

	@Override
	public void addNotice(NoticesDto dto) throws Exception {
		sqlSession.insert(ns+"addNotice",dto);
	}

	@Override
	public void deleteNotice(int no) throws Exception {
		sqlSession.delete(ns+"deleteNotice",no);
	}
	
	@Override
	public void updateNotice(NoticesDto dto) throws Exception {
		sqlSession.update(ns+"updateNotice",dto);
	}

	@Override
	public List<NoticesDto> selectBoardLimitOffset(int limit, int offset) {
		Map<String, Integer> map =new HashMap<String, Integer>();
		map.put("limit", limit);
		map.put("offset", offset);
		return sqlSession.selectList(ns+"NoticesList",map);
	}

	@Override
	public int selectBoardTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"NoticeCount");
	}
		
}
