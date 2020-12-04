package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.mapper.HouseMapDao;
import com.ssafy.happyhouse.mapper.HouseMapDaoImpl;
import com.ssafy.happyhouse.util.PageNavigation;
import com.ssafy.happyhouse.model.service.HouseMapService;
import com.ssafy.happyhouse.model.service.HouseMapServiceImpl;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	@Autowired
	private HouseMapDao dao;

	private HouseMapServiceImpl() {}
	
	@Override
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage, String dong) {
		int naviSize = 10;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);

		int totalCount = dao.getTotalCount(dong);
		System.out.println("total: "  + totalCount);
		pageNavigation.setTotalCount(totalCount);

		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		System.out.println(totalCount+" "+sizePerPage+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+totalPageCount);
		pageNavigation.setTotalPageCount(totalPageCount);

		boolean startRange = currentPage <= naviSize;
		System.out.println(startRange);
		pageNavigation.setStartRange(startRange);

		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		System.out.println(endRange);
		pageNavigation.setEndRange(endRange);

		pageNavigation.makeNavigator();
		System.out.println(pageNavigation.toString());
		return pageNavigation;
	}

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return dao.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return dao.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return dao.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return dao.getAptInDong(dong);
	}

	// 페이징
	@Override
	public List<HouseInfoDto> getAptInDong(int currentPage, int sizePerPage, String dong) {
		System.out.println("1");
		return dao.getAptInDong(dong, currentPage, sizePerPage);
	}

}
