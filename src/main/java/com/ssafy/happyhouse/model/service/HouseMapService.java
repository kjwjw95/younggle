package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.util.PageNavigation;

public interface HouseMapService {
	
	PageNavigation makePageNavigation(int currentPage, int sizePerpage, String dong) throws Exception;
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong) throws Exception;

    List<HouseInfoDto> getAptInDong(int currentPage, int sizePerPage, String dong);
}
