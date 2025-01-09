package com.dto;

public class ResponseUserInfoDTO {
	
	String userid;
	String username;
	public ResponseUserInfoDTO() {
		// TODO Auto-generated constructor stub
	}
	public ResponseUserInfoDTO(String userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ResponseUserInfoDTO [userid=" + userid + ", username=" + username + "]";
	}


}
