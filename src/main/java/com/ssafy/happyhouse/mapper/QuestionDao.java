package com.ssafy.happyhouse.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.QuestionDto;


public interface QuestionDao {
	public List<QuestionDto> list(String id) throws Exception;
	public List<QuestionDto> allList() throws Exception;
	public void addQuestion(QuestionDto dto) throws Exception;
	public QuestionDto detailQuestion(int no) throws Exception;
	public void deleteQuestion(int no) throws Exception;
	public void addQuestionReply(QuestionDto dto) throws Exception;
	public List<QuestionDto> selectBoardLimitOffset(int limit,int offset);

	public int selectBoardTotalCount();
}
