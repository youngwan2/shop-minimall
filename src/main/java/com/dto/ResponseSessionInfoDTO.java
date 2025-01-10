package com.dto;

public class ResponseSessionInfoDTO {
	String userid;
	String username;
	public ResponseSessionInfoDTO() {
	}
	public ResponseSessionInfoDTO(String userid, String username) {
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
		return "ResponseSessionInfoDTO [userid=" + userid + ", username=" + username + "]";
	}
	
	
}
