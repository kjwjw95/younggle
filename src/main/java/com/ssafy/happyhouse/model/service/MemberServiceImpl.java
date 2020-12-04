package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dto.Member;
import com.ssafy.happyhouse.mapper.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;

	public Member login(String id, String pw) throws Exception {
		Member m = dao.login(id, pw);
		return m;
	}

	@Override
	@Transactional
	public void insert(String id, String pw, String name, String tel) throws Exception {
		dao.insert(id, pw, name, tel);
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		dao.delete(id);
	}

	@Override
	@Transactional
	public void update(String id, String pw, String name, String tel) throws Exception {
		dao.update(id, pw, name, tel);
	}
	
	@Override
	@Transactional
	public void update(String id, String pw) throws Exception {
		dao.update(id, pw);
	}

	@Override
	@Transactional
	public boolean check(Member member) throws Exception {
		Member mem = dao.check(member);
		if (mem != null)
			return true;
		else
			return false;
	}

	@Override
	public List<Member> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<Member> list(String input) throws Exception {
		return dao.list(input);
	}

}
