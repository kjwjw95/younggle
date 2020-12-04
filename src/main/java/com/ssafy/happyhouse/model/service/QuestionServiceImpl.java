package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.mapper.QuestionDao;
import com.ssafy.happyhouse.model.dto.NoticesDto;
import com.ssafy.happyhouse.model.dto.QuestionDto;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	@Transactional(readOnly = true)
	public List<QuestionDto> list(String id) throws Exception {
		if (id.equals("1540978491"))
			return questionDao.allList();
		else
			return questionDao.list(id);
	}

	@Override
	public void addQuestion(QuestionDto dto) throws Exception {
		questionDao.addQuestion(dto);
	}

	@Override
	public QuestionDto detailQuestion(int no) throws Exception {
		return questionDao.detailQuestion(no);
	}

	@Override
	public void deleteQuestion(int no) throws Exception {
		questionDao.deleteQuestion(no);
	}

	@Override
	public void addQuestionReply(QuestionDto dto) throws Exception {
		questionDao.addQuestionReply(dto);
	}
	@Override
	public List<QuestionDto> selectBoardLimitOffset(int limit, int offset) {
		// TODO Auto-generated method stub
		return questionDao.selectBoardLimitOffset(limit,offset);
	}

	@Override
	public int selectBoardTotalCount() {
		// TODO Auto-generated method stub
		return questionDao.selectBoardTotalCount();
	}
}
