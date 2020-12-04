package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.DongCodeDto;
import com.ssafy.happyhouse.model.service.RegionService;
import com.ssafy.happyhouse.util.NumberResult;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/region")
public class RegionController {
	public static final Logger logger = LoggerFactory.getLogger(RegionController.class);
	
	@Autowired
	private RegionService regionService;
    
//    @ApiOperation(value = "매물 등록", response = NumberResult.class)
// 	@RequestMapping(value = "/", method = RequestMethod.POST)
// 	public void addHouse(@RequestBody HouseDto dto) throws Exception {
//    	houseService.addHouse(dto);
// 	}
//
//    @ApiOperation(value = "id의 매물 목록을 반환한다.", response = List.class)
//	@RequestMapping(value = "/myList/{id}", method = RequestMethod.GET)
//	public ResponseEntity<List<HouseDto>> myList(@PathVariable String id) throws Exception {
//		List<HouseDto> house = houseService.myList(id);
//		if (house.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<HouseDto>>(house, HttpStatus.OK);
//	}
//
//    @ApiOperation(value = "매물 목록을 반환한다.", response = List.class)
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public ResponseEntity<List<HouseDto>> list() throws Exception {
//		List<HouseDto> house = houseService.list();
//		if (house.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<HouseDto>>(house, HttpStatus.OK);
//	}

    @ApiOperation(value = "시도 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/sidoList", method = RequestMethod.GET)
	public ResponseEntity<List<DongCodeDto>> sidoList() throws Exception {
		List<DongCodeDto> sido = regionService.sidoList();
		if (sido.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DongCodeDto>>(sido, HttpStatus.OK);
	}

    @ApiOperation(value = "시구군 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/gugunList/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<DongCodeDto>> gugunList(@PathVariable int no) throws Exception {
		List<DongCodeDto> gugun = regionService.gugunList(no);
		if (gugun.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DongCodeDto>>(gugun, HttpStatus.OK);
	}

    @ApiOperation(value = "동 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/dongList/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<DongCodeDto>> dongList(@PathVariable int no) throws Exception {
    	System.out.println(no);
		List<DongCodeDto> dong = regionService.dongList(no);
		if (dong.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DongCodeDto>>(dong, HttpStatus.OK);
	}

}
