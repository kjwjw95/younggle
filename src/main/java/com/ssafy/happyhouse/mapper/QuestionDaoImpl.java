package com.ssafy.happyhouse.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.NoticesDto;
import com.ssafy.happyhouse.model.dto.QuestionDto;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	private String ns = "com.ssafy.vue.dao.QuestionMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<QuestionDto> list(String id) throws Exception {
		return sqlSession.selectList(ns + "list", id);
	}

	@Override
	public List<QuestionDto> allList() throws Exception {
		return sqlSession.selectList(ns + "allList");
	}

	@Override
	public void addQuestion(QuestionDto dto) throws Exception {
		sqlSession.insert(ns + "addQuestion", dto);
	}

	@Override
	public QuestionDto detailQuestion(int no) throws Exception {
		return sqlSession.selectOne(ns + "detailQuestion", no);
	}

	@Override
	public void deleteQuestion(int no) throws Exception {
		sqlSession.delete(ns + "deleteQuestion", no);
	}

	@Override
	public void addQuestionReply(QuestionDto dto) throws Exception {
		sqlSession.update(ns + "addQuestionReply", dto);
	}
	@Override
	public List<QuestionDto> selectBoardLimitOffset(int limit, int offset) {
		Map<String, Integer> map =new HashMap<String, Integer>();
		map.put("limit", limit);
		map.put("offset", offset);
		return sqlSession.selectList(ns+"questionList",map);
	}

	@Override
	public int selectBoardTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"questionCount");
	}
}
