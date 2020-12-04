package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.mapper.NoticesDao;
import com.ssafy.happyhouse.model.dto.NoticesDto;



@Service
public class NoticesServiceImpl implements NoticesService {
	
    @Autowired
	private NoticesDao noticesDao;

    @Override
	@Transactional(readOnly=true)
	public List<NoticesDto> topNotices() throws Exception {
		return noticesDao.topNotices();
	}
    
    @Override
	@Transactional(readOnly=true)
	public List<NoticesDto> defaultNotices() throws Exception {
		return noticesDao.defaultNotices();
	}

	@Override
	public NoticesDto detailNotice(int no) throws Exception {
		return noticesDao.detailNotice(no);
	}

	@Override
	public void addNotice(NoticesDto dto) throws Exception {
		noticesDao.addNotice(dto);
	}

	@Override
	public void deleteNotice(int no) throws Exception {
		noticesDao.deleteNotice(no);
	}
	
	@Override
	public void updateNotice(NoticesDto dto) throws Exception {
		noticesDao.updateNotice(dto);
	}

	@Override
	public List<NoticesDto> selectBoardLimitOffset(int limit, int offset) {
		// TODO Auto-generated method stub
		return noticesDao.selectBoardLimitOffset(limit,offset);
	}

	@Override
	public int selectBoardTotalCount() {
		// TODO Auto-generated method stub
		return noticesDao.selectBoardTotalCount();
	}
	
}
