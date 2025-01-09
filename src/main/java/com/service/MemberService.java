package com.service;

import com.dao.MemberDao;
import com.dto.MemberDTO;

public interface MemberService {
	
	
	public void setDao(MemberDao dao);
	public MemberDTO idCheck(String userid);
	public boolean registerMember(MemberDTO memberDto);

}
