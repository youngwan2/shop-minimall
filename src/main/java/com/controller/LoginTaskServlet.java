package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.MemberDao;
import com.dto.RequestLoginDTO;
import com.dto.ResponseUserInfoDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/login-task")
public class LoginTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("passwd");
		

		RequestLoginDTO dto = new RequestLoginDTO(userid, password);
		
		MemberService service = new MemberServiceImpl();
		service.setDao(new MemberDao());
		
		ResponseUserInfoDTO userInfoDto = service.login(dto);

		response.setContentType("aplication/json; charset=utf-8");
		
		if( userInfoDto == null) {
			response.setStatus(404);
			 response.getWriter().write("{\"meg\":" + "\"로그인 실패하였습니다. 아이디나 비밀번호를 확인 후 재시도 해주세요.\"}"); // 클라이언트로 결과 메시지 전송		
			return;
		}
	
			HttpSession session = request.getSession();
			session.setAttribute("userid", userInfoDto.getUserid());
			session.setAttribute("username", userInfoDto.getUsername());
			
			response.setStatus(200);
			response.getWriter().write("{\"meg\":" + "\"로그인 되었습니다.\"}"); // 클라이언트로 결과 메시지 전송

		} 
	
	
	}
