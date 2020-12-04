package com.ssafy.happyhouse.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.Member;

@Repository
public class MemberDaompl implements MemberDao {

	@Autowired
	SqlSession session;

	@Override
	public Member login(String id, String pw) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		Member mem = session.selectOne("ssafy.member.login", map);
		return mem;
	}

	@Override
	public void insert(String id, String pw, String name, String tel) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		map.put("name", name);
		map.put("tel", tel);
		session.insert("ssafy.member.insert", map);
	}

	@Override
	public Member check(Member member) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", member.getEmail());
		map.put("name", member.getName());
		map.put("tel", member.getTel());
		return session.selectOne("ssafy.member.check", map);
	}

	@Override
	public void update(String id, String pw, String name, String tel) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		map.put("name", name);
		map.put("tel", tel);
		Member mem = session.selectOne("ssafy.member.update", map);
	}
	
	@Override
	public void update(String id, String pw) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		Member mem = session.selectOne("ssafy.member.update2", map);
	}

	@Override
	public void delete(String id) throws Exception {
		session.delete("ssafy.member.delete", id);
	}

	@Override
	public List<Member> list() throws Exception {
		return session.selectList("ssafy.member.list");
	}

	@Override
	public List<Member> list(String id) throws Exception {
		return session.selectList("ssafy.member.list2", "%" + id + "%");
	}
}
