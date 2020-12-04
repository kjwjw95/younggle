package com.ssafy.happyhouse.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticesDto;


public interface NoticesDao {
	public List<NoticesDto> topNotices() throws Exception;
	public List<NoticesDto> defaultNotices() throws Exception;
	public NoticesDto detailNotice(int no) throws Exception;
	public void addNotice(NoticesDto dto) throws Exception;
	public void deleteNotice(int no) throws Exception;
	public void updateNotice(NoticesDto dto) throws Exception;
	public List<NoticesDto> selectBoardLimitOffset(int limit,int offset);

	public int selectBoardTotalCount();
	
//	public Qna_BoardDto findQnaById(int id) throws Exception;
	//public  int getEmployeesTotal()throws Exception;
//	public List<Qna_BoardDto> findLikeQna(String name) throws Exception;
//	public void addQna(Qna_BoardDto emp) throws Exception;
	//public List<Qna_BoardDto> findAllDepartments() throws Exception;
//	public int findAfterAdd() throws Exception;
//	public List<Qna_BoardDto> findAllTitles() throws Exception;
//	public boolean updateQna(Qna_BoardDto emp) throws Exception;
//	public int deleteQna(int id) throws Exception;
	

	
//	public List<DepCountDto> findAllDepCounts()throws Exception;
//	public List<EmployeeDto>  findEmployeesByManagerId(int managerId)throws Exception;
//	
//	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id)throws Exception;
//	public List<EmployeeDto> findDepartmentsByname(String name)throws Exception;
//
//	public List<DepartmentEmpDto> findAllDeptEmps()throws Exception;
	
}
