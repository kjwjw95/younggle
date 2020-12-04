package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.NoticesDto;
import com.ssafy.happyhouse.model.dto.QuestionDto;
import com.ssafy.happyhouse.model.service.QuestionService;
import com.ssafy.happyhouse.util.NumberResult;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/question")
public class QuestionController {
	public static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService; 

    @ApiOperation(value = "문의내역을 반환한다.", response = List.class)
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<QuestionDto>> list(@PathVariable String id) throws Exception {
		List<QuestionDto> question = questionService.list(id);
		if (question.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QuestionDto>>(question, HttpStatus.OK);
	}
    
    @ApiOperation(value = "1:1 문의 추가", response = NumberResult.class)
 	@RequestMapping(value = "/", method = RequestMethod.POST)
 	public void addQuestion(@RequestBody QuestionDto dto) throws Exception {
	  	questionService.addQuestion(dto);
 	}
    
    @ApiOperation(value = "선택된 문의 하나를 반환한다.", response = List.class)
	@RequestMapping(value = "/{no}", method = RequestMethod.GET)
	public ResponseEntity<QuestionDto> detailQuestion(@PathVariable int no) throws Exception {
    	QuestionDto notice = questionService.detailQuestion(no);
		if (notice == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<QuestionDto>(notice, HttpStatus.OK);
	}

    @ApiOperation(value = "no를 가진 문의내역을 삭제한다.", response = List.class)
	@RequestMapping(value = "/{no}", method = RequestMethod.DELETE)
	public void deleteQuestion(@PathVariable int no) throws Exception {
    	questionService.deleteQuestion(no);
	}
    
    @ApiOperation(value = "no를 가진 문의내역의 답변을 추가한다.", response = List.class)
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void addQuestionReply(@RequestBody QuestionDto dto) throws Exception {
    	questionService.addQuestionReply(dto);
	}
    
    @GetMapping(value = "/pagelink")
	public ResponseEntity<List<QuestionDto>> selectBoardLimitOffset(int limit, int offset) throws Exception {
		logger.debug("selectBoardLimitOffset - 호출");
		System.out.println("limit : " + limit + " / offset : " + offset);
		return new ResponseEntity<List<QuestionDto>>(questionService.selectBoardLimitOffset(limit, offset), HttpStatus.OK);
	}

	@GetMapping(value = "/pagelink/count")
	public ResponseEntity<Integer> selectBoardTotalCount() throws Exception {
		logger.debug("selectBoardTotalCount - 호출");
		return new ResponseEntity<Integer>(questionService.selectBoardTotalCount(), HttpStatus.OK);
	}
}
