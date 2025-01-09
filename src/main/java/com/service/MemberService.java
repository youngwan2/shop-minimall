package com.service;

import com.dao.MemberDao;
import com.dto.MemberDTO;
import com.dto.RequestLoginDTO;
import com.dto.ResponseUserInfoDTO;

public interface MemberService {
	
	
	public void setDao(MemberDao dao);
	public MemberDTO idCheck(String userid);
	public boolean registerMember(MemberDTO memberDto);
	public ResponseUserInfoDTO login(RequestLoginDTO reqeustLoginDto);

}
