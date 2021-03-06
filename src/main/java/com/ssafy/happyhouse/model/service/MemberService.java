package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Member;

public interface MemberService {

	Member login(String id, String pw) throws Exception;
	void insert(String id, String pw, String name, String tel) throws Exception;
	void delete(String id) throws Exception;
	void update(String id, String pw, String name, String tel) throws Exception;
	void update(String id, String pw) throws Exception;
	boolean check(Member member) throws Exception;
	List<Member> list() throws Exception;
	List<Member> list(String input) throws Exception;

}
