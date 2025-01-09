package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDao;
import com.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	MemberDao memberDao;
	@Override
	public void setDao(MemberDao dao) {
		this.memberDao = dao;
		
	}

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

}
