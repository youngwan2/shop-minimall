package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;
import com.dto.RequestLoginDTO;
import com.dto.ResponseSessionInfoDTO;
import com.dto.ResponseUserProfileDTO;

public class MemberDao {
	
	// 중복 아이디 체크
	public MemberDTO idCheck(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.config.MemberMapper.idCheck", userid);
		return dto;
	}
	
	// 회원가입
	public int registerMember(SqlSession session, MemberDTO memberDto) {
		return session.insert("com.config.MemberMapper.registerMember", memberDto);
	}
	
	// 로그인
	public ResponseSessionInfoDTO login(SqlSession session, RequestLoginDTO requestLoginDto) {
		return session.selectOne("com.config.MemberMapper.selectUserSessionInfo", requestLoginDto);
	}
	
	// 프로필 조회
	public ResponseUserProfileDTO getUserProfile(SqlSession session, String userid) {
		return session.selectOne("com.config.MemberMapper.selectUserProfile", userid);
	}
	
	// 프로필 수정
	public int updateUserProfile(SqlSession session, MemberDTO memberDto) {
		return session.update("com.config.MemberMapper.updateUserProfile", memberDto);
		
	}
}
