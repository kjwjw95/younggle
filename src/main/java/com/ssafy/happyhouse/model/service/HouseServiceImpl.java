package com.ssafy.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.mapper.HouseDao;
import com.ssafy.happyhouse.model.dto.HouseDto;
import com.ssafy.happyhouse.model.dto.JoinDto;
import com.ssafy.happyhouse.model.dto.ReservationDto;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDao;

	@Override
	@Transactional(readOnly = true)
	public List<HouseDto> myList(String id) throws Exception {
		return houseDao.myList(id);
	}

	@Transactional(readOnly = true)
	public List<HouseDto> list() throws Exception {
		return houseDao.list();
	}

    @Transactional(readOnly = true)
    public List<HouseDto> list(String dongcode) throws Exception {
		return houseDao.list(dongcode);
    }

	@Transactional(readOnly = true)
	public List<HouseDto> list(String dongCode, String type, String houseType, String price, String monthPrice,
			String area, String room, String typeChoice, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		if (dongCode.equals("0")) {
			map.put("dongCode", null);
			map.put("dongLang", null);
		} else {
			map.put("dongCode", dongCode);
			map.put("dongLang", dongCode.length() + "");
		}
		if (type.equals("0"))
			map.put("type", null);
		else
			map.put("type", type);
		if (houseType.equals("0"))
			map.put("houseType", null);
		else
			map.put("houseType", houseType);
		if (price.equals("0"))
			map.put("price", null);
		else
			map.put("price", price);
		if (monthPrice.equals("0"))
			map.put("monthPrice", null);
		else
			map.put("monthPrice", monthPrice);
		if (area.equals("0"))
			map.put("area", null);
		else
			map.put("area", area);
		if (room.equals("0"))
			map.put("room", null);
		else
			map.put("room", room);
		if (typeChoice.equals("0"))
			map.put("typeChoice", null);
		else
			map.put("typeChoice", typeChoice);
		if (keyword.equals("0"))
			map.put("keyword", null);
		else
			map.put("keyword", "%" + keyword + "%");
		return houseDao.list(map);
	}

	@Override
	public void addHouse(HouseDto dto) throws Exception {
		houseDao.addHouse(dto);
	}

	@Override
	public void addReservation(ReservationDto dto) throws Exception {
		houseDao.addReservation(dto);
	}
	
	@Override
	public HouseDto detailHouse(int no) throws Exception {
		return houseDao.detailHouse(no);
	}

	@Override
	public void deleteHouse(int no) throws Exception {
		houseDao.deleteHouse(no);
	}

	@Override
	public void reservDelete(int num) throws Exception {
		houseDao.reservDelete(num);
	}

	@Override
	public void reservModify(int num) throws Exception {
		houseDao.reservModify(num);
	}
	
	@Override
	public void modifyHouse(HouseDto dto) throws Exception {
		houseDao.modifyHouse(dto);
	}

	@Override
	public List<JoinDto> reservationList(String id) throws Exception {
		return houseDao.reservationList(id);
	}
	
	@Override
	public List<JoinDto> rereservationList(String id) throws Exception {
		return houseDao.rereservationList(id);
	}

    @Override
    public List<HouseDto> selectBoardLimitOffset(Integer limit, Integer offset, String dongCode, String type, String houseType, String price, String monthPrice, String area, String room, String typeChoice, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (dongCode.equals("0")) {
           map.put("dongCode", null);
           map.put("dongLang", null);
        } else {
           map.put("dongCode", dongCode);
           map.put("dongLang", dongCode.length() + "");
        }
        if (type.equals("0"))
           map.put("type", null);
        else
           map.put("type", type);
        if (houseType.equals("0"))
           map.put("houseType", null);
        else
           map.put("houseType", houseType);
        if (price.equals("0"))
           map.put("price", null);
        else
           map.put("price", price);
        if (monthPrice.equals("0"))
           map.put("monthPrice", null);
        else
           map.put("monthPrice", monthPrice);
        if (area.equals("0"))
           map.put("area", null);
        else
           map.put("area", area);
        if (room.equals("0"))
           map.put("room", null);
        else
           map.put("room", room);
        if (typeChoice.equals("0"))
           map.put("typeChoice", null);
        else
           map.put("typeChoice", typeChoice);
        if (keyword.equals("0"))
           map.put("keyword", null);
        else
           map.put("keyword", "%" + keyword + "%");
        map.put("limit", limit);
        map.put("offset", offset);
        return houseDao.selectBoardLimitOffset(map);
     }
     @Override
     public int selectBoardTotalCount(String dongCode, String type, String houseType, String price, String monthPrice,
           String area, String room, String typeChoice, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (dongCode.equals("0")) {
           map.put("dongCode", null);
           map.put("dongLang", null);
        } else {
           map.put("dongCode", dongCode);
           map.put("dongLang", dongCode.length() + "");
        }
        if (type.equals("0"))
           map.put("type", null);
        else
           map.put("type", type);
        if (houseType.equals("0"))
           map.put("houseType", null);
        else
           map.put("houseType", houseType);
        if (price.equals("0"))
           map.put("price", null);
        else
           map.put("price", price);
        if (monthPrice.equals("0"))
           map.put("monthPrice", null);
        else
           map.put("monthPrice", monthPrice);
        if (area.equals("0"))
           map.put("area", null);
        else
           map.put("area", area);
        if (room.equals("0"))
           map.put("room", null);
        else
           map.put("room", room);
        if (typeChoice.equals("0"))
           map.put("typeChoice", null);
        else
           map.put("typeChoice", typeChoice);
        if (keyword.equals("0"))
           map.put("keyword", null);
        else
           map.put("keyword", "%" + keyword + "%");

        return houseDao.selectBoardTotalCount(map);
    }

    @Override
    public int selectBoardTotalCount() {
        // TODO Auto-generated method stub
        return houseDao.selectBoardTotalCount();
    }

}
