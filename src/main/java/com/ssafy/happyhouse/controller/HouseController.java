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

import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.ReservationDto;
import com.ssafy.happyhouse.model.dto.JoinDto;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.util.NumberResult;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/house")
public class HouseController {
	public static final Logger logger = LoggerFactory.getLogger(HouseController.class);

	@Autowired
	private HouseService houseService;

	@ApiOperation(value = "매물 등록", response = List.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addHouse(@RequestBody HouseDto dto) throws Exception {
		houseService.addHouse(dto);
	}

	@ApiOperation(value = "예약 등록", response = NumberResult.class)
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public void addReservation(@RequestBody ReservationDto dto) throws Exception {
		houseService.addReservation(dto);
	}
	
	@ApiOperation(value = "id의 매물 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<JoinDto>> reservationList(@PathVariable String id) throws Exception {
		List<JoinDto> reservation = houseService.reservationList(id);
		if (reservation.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<JoinDto>>(reservation, HttpStatus.OK);
	}
	
	@ApiOperation(value = "id의 매물 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/rereservation/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<JoinDto>> rereservationList(@PathVariable String id) throws Exception {
		List<JoinDto> reservation = houseService.rereservationList(id);
		if (reservation.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<JoinDto>>(reservation, HttpStatus.OK);
	}
	
	@ApiOperation(value = "id의 매물 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/myList/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<HouseDto>> myList(@PathVariable String id) throws Exception {
		List<HouseDto> house = houseService.myList(id);
		if (house.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HouseDto>>(house, HttpStatus.OK);
	}

	@ApiOperation(value = "매물 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<HouseDto>> list() throws Exception {
		List<HouseDto> house = houseService.list();
		if (house.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HouseDto>>(house, HttpStatus.OK);
	}

	@ApiOperation(value = "매물 목록을 반환한다.", response = List.class)
	@RequestMapping(value = "/list/{dongCode}/{type}/{typeHouse}/{price}/{monthPrice}/{area}/{room}/{typeChoice}/{keyword}", method = RequestMethod.GET)
	public ResponseEntity<List<HouseDto>> list(@PathVariable String dongCode, @PathVariable String type,
			@PathVariable String typeHouse, @PathVariable String price, @PathVariable String monthPrice,
			@PathVariable String area, @PathVariable String room, @PathVariable String typeChoice, @PathVariable String keyword) throws Exception {
		List<HouseDto> house = houseService.list(dongCode, type, typeHouse, price, monthPrice, area, room, typeChoice, keyword);
		if (house.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HouseDto>>(house, HttpStatus.OK);
	}

	@ApiOperation(value = "선택된 문의 하나를 반환한다.", response = List.class)
	@RequestMapping(value = "/{no}", method = RequestMethod.GET)
	public ResponseEntity<HouseDto> detailQuestion(@PathVariable int no) throws Exception {
		HouseDto notice = houseService.detailHouse(no);
		if (notice == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HouseDto>(notice, HttpStatus.OK);
	}

	@ApiOperation(value = "no를 가진 매물을 삭제한다.", response = List.class)
	@RequestMapping(value = "/{no}", method = RequestMethod.DELETE)
	public void deleteHouse(@PathVariable int no) throws Exception {
		houseService.deleteHouse(no);
	}

	@ApiOperation(value = "no예약을 삭제한다.", response = List.class)
	@RequestMapping(value = "/reservation/{num}", method = RequestMethod.DELETE)
	public void reservDelete(@PathVariable int num) throws Exception {
		System.out.println(num);
		houseService.reservDelete(num);
	}

	@ApiOperation(value = "no예약을 허락한다.", response = List.class)
	@RequestMapping(value = "/reservation/{num}", method = RequestMethod.PUT)
	public void reservModify(@PathVariable int num) throws Exception {
		houseService.reservModify(num);
	}
	
	@ApiOperation(value = "no를 가진 매물을 수정한다.", response = List.class)
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void modifyHouse(@RequestBody HouseDto dto) throws Exception {
		houseService.modifyHouse(dto);
	}
	
	@ApiOperation(value = "해당 동의 매물을 반환한다.", response = List.class)
    @RequestMapping(value = "/list/{dongCode}", method = RequestMethod.GET)
    public ResponseEntity<List<HouseDto>> listdong(@PathVariable String dongCode) throws Exception {
        List<HouseDto> house = houseService.list(dongCode);
        if (house.isEmpty()) {
           return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HouseDto>>(house, HttpStatus.OK);
    }

   @ApiOperation(value = "limit offset 에 해당하는 게시글의 정보를 반환한다.  ", response = List.class)   ///////////////페이징 때문에 추가
   @GetMapping(value = "/pagelink")
   public ResponseEntity<List<HouseDto>> selectBoardLimitOffset(int limit, int offset, String dongCode,String type, String houseType,
         String price, String monthPrice, String area, String room, String typeChoice, String keyword) throws Exception {
      System.out.println("limit : " + limit + " / offset : " + offset);
      List<HouseDto> list =houseService.selectBoardLimitOffset(limit, offset,dongCode, type, houseType, price, monthPrice, area, room, typeChoice, keyword);
      for(HouseDto h : list)
         System.out.println(">>>>>>>>>>>"+h);
      return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
   }

   @ApiOperation(value = "게시글의 전체 건수를 반환한다.  ", response = List.class)   ///////////////페이징 때문에 추가
   @GetMapping(value = "/pagelink/count")
   public ResponseEntity<Integer> selectBoardTotalCount() throws Exception {
      logger.debug("selectBoardTotalCount - 호출");
      return new ResponseEntity<Integer>(houseService.selectBoardTotalCount(), HttpStatus.OK);
   }
   
   @ApiOperation(value = "limit offset 에 해당하는 게시글의 숫자를 반환한다.  ", response = List.class)   ///////////////페이징 때문에 추가
   @GetMapping(value = "/pagelink/counts")
   public ResponseEntity<Integer> selectBoardLimitOffsetTotalCount(String dongCode,String type, String houseType,
         String price, String monthPrice, String area, String room, String typeChoice, String keyword) throws Exception {
      Integer count =houseService.selectBoardTotalCount(dongCode, type, houseType, price, monthPrice, area, room, typeChoice, keyword);
      System.out.println(">>>>>>>>"+count+"<<<<<<<<<<");
      return new ResponseEntity<Integer>(count, HttpStatus.OK);
   }

}
