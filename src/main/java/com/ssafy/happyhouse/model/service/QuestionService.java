package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.QuestionDto;


public interface QuestionService {
	
	public List<QuestionDto> list(String id) throws Exception;
	public void addQuestion(QuestionDto dto) throws Exception;
	public QuestionDto detailQuestion(int no) throws Exception;
	public void deleteQuestion(int no) throws Exception;
	public void addQuestionReply(QuestionDto dto) throws Exception;
	public List<QuestionDto> selectBoardLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
	public int selectBoardTotalCount();		
}
