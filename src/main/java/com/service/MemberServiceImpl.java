package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDao;
import com.dto.MemberDTO;
import com.dto.RequestLoginDTO;
import com.dto.ResponseSessionInfoDTO;
import com.dto.ResponseUserProfileDTO;

public class MemberServiceImpl implements MemberService {
	
	MemberDao memberDao;
	@Override
	public void setDao(MemberDao dao) {
		this.memberDao = dao;
		
	}
    // 아이디 중복 확인
	@Override
	public MemberDTO idCheck(String userid) {
		MemberDTO memberDto  = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			memberDto = memberDao.idCheck(session, userid);
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally{
			session.close();
		}
		return memberDto;
	}


	//	회원가입
	@Override
	public boolean registerMember(MemberDTO memberDto) {
		boolean isRegister=false;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			if(memberDao.registerMember(session, memberDto) != 0) {
				isRegister = true;
				session.commit();
				
			} else {
				isRegister = false;
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally{
			session.close();
		}
		return isRegister;
	}

	// 로그인 처리
	@Override
	public ResponseSessionInfoDTO login(RequestLoginDTO reqeustLoginDto) {
		ResponseSessionInfoDTO dto =null;
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			  dto = memberDao.login(session, reqeustLoginDto) ;
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			
		} finally {
			session.close();
		}
		
		return dto ;
	}

	// 유저 프로필 정보 조회
	@Override
	public ResponseUserProfileDTO getUserProfile(String userid) {
		ResponseUserProfileDTO dto =null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			dto = memberDao.getUserProfile(session, userid);
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}
		
		return dto;
	}
	
	// 유저 프로필 정보 수정
	@Override
	public boolean updateUserProfile(MemberDTO memberDTO) {
		boolean isUpdatedProfile = false;
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			if(memberDao.updateUserProfile(session, memberDTO) != 0) {
				isUpdatedProfile = true;
				session.commit();
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally{
			session.close();
		}
		
		return isUpdatedProfile;
	}

}
