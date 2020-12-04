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
import com.ssafy.happyhouse.model.service.NoticesService;
import com.ssafy.happyhouse.util.NumberResult;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notice")
public class NoticeController {
	public static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticesService noticeService; 

    @ApiOperation(value = "상단고정 공지사항을 반환한다.", response = List.class)
	@RequestMapping(value = "/topNotice", method = RequestMethod.GET)
	public ResponseEntity<List<NoticesDto>> topNotice() throws Exception {
		List<NoticesDto> notice = noticeService.topNotices();
		if (notice.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<NoticesDto>>(notice, HttpStatus.OK);
	}
    
    @ApiOperation(value = "기본 공지사항을 반환한다.", response = List.class)
	@RequestMapping(value = "/defaultNotice", method = RequestMethod.GET)
	public ResponseEntity<List<NoticesDto>> defaultNotice() throws Exception {
		List<NoticesDto> notice = noticeService.defaultNotices();
		if (notice.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<NoticesDto>>(notice, HttpStatus.OK);
	}
    
    @ApiOperation(value = "no를 가진 공지사항 하나를 반환한다.", response = List.class)
	@RequestMapping(value = "/{no}", method = RequestMethod.GET)
	public ResponseEntity<NoticesDto> detailNotice(@PathVariable int no) throws Exception {
		NoticesDto notice = noticeService.detailNotice(no);
		if (notice == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NoticesDto>(notice, HttpStatus.OK);
	}

    @ApiOperation(value = "no를 가진 공지사항을 삭제한다.", response = List.class)
	@RequestMapping(value = "/{no}", method = RequestMethod.DELETE)
	public void deleteNotice(@PathVariable int no) throws Exception {
		noticeService.deleteNotice(no);
	}
    
    @ApiOperation(value = "no를 가진 공지사항을 수정한다.", response = List.class)
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void modifyNotice(@RequestBody NoticesDto dto) throws Exception {
		noticeService.updateNotice(dto);
	}

    @ApiOperation(value = "공지사항 추가", response = NumberResult.class)
   	@RequestMapping(value = "/", method = RequestMethod.POST)
   	public void addNotice(@RequestBody NoticesDto dto) throws Exception {
   		noticeService.addNotice(dto);
   	}
    
	@GetMapping(value = "/pagelink")
	public ResponseEntity<List<NoticesDto>> selectBoardLimitOffset(int limit, int offset) throws Exception {
		logger.debug("selectBoardLimitOffset - 호출");
		System.out.println("limit : " + limit + " / offset : " + offset);
		return new ResponseEntity<List<NoticesDto>>(noticeService.selectBoardLimitOffset(limit, offset), HttpStatus.OK);
	}

	@GetMapping(value = "/pagelink/count")
	public ResponseEntity<Integer> selectBoardTotalCount() throws Exception {
		logger.debug("selectBoardTotalCount - 호출");
		return new ResponseEntity<Integer>(noticeService.selectBoardTotalCount(), HttpStatus.OK);
	}
}
