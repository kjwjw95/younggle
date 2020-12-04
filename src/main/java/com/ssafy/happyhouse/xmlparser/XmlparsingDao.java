package com.ssafy.happyhouse.xmlparser;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseDealsDto;
@Repository
public class XmlparsingDao {
	@Autowired

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {

        this.sqlSession = sqlSession;

    }


	public void insert(List<HouseDealsDto> housese) {
		for(HouseDealsDto apart : housese) {
			//System.out.println(apart.getAptName());
			sqlSession.insert("ssafy.member.inserthouse", apart);
		}
	}
}
