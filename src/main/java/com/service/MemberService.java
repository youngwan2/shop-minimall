package com.service;

import com.dao.MemberDao;
import com.dto.MemberDTO;
import com.dto.RequestLoginDTO;
import com.dto.ResponseSessionInfoDTO;
import com.dto.ResponseUserProfileDTO;

public interface MemberService {
	
	
	public void setDao(MemberDao dao);
	public MemberDTO idCheck(String userid);
	public boolean registerMember(MemberDTO memberDto);
	public ResponseSessionInfoDTO login(RequestLoginDTO reqeustLoginDto);
	public ResponseUserProfileDTO getUserProfile(String userid);

}
