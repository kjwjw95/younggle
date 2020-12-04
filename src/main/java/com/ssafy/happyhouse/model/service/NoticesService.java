package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.NoticesDto;


public interface NoticesService {
	
	public List<NoticesDto> topNotices() throws Exception;
	public List<NoticesDto> defaultNotices() throws Exception;
	public NoticesDto detailNotice(int no) throws Exception;
	public void addNotice(NoticesDto dto) throws Exception;
	public void deleteNotice(int no) throws Exception;
	public void updateNotice(NoticesDto dto) throws Exception;
	public List<NoticesDto> selectBoardLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
	public int selectBoardTotalCount();
}
