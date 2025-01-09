package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDao {
	
	public MemberDTO idCheck(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.config.MemberMapper.idCheck", userid);
		return dto;
	}
	
	public int registerMember(SqlSession session, MemberDTO memberDto) {
		return session.insert("com.config.MemberMapper.registerMember", memberDto);
	}
	
}
