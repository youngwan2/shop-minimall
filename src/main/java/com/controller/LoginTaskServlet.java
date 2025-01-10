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
import com.dto.ResponseSessionInfoDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/login-task")
public class LoginTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String userid = request.getParameter("userid");
			String password = request.getParameter("passwd");
			
			response.setContentType("aplication/json; charset=utf-8");
			
			// 400 | 잘못된 요청
			if(userid.isEmpty() || userid == null) {
				response.setStatus(400);
				response.getWriter().write("{\"meg\":" + "\"유저 아이디 형식을 확인하세요.\"}"); // 클라이언트로 결과 메시지 전송
			}
			
			if(password.isEmpty() || password == null) {
				response.setStatus(400);
				response.getWriter().write("{\"meg\":" + "\"비밀번호 형식을 확인하세요.\"}"); // 클라이언트로 결과 메시지 전송
			}
			
	
			RequestLoginDTO dto = new RequestLoginDTO(userid, password);
			
			MemberService service = new MemberServiceImpl();
			service.setDao(new MemberDao());
			
			
			
			try {
				ResponseSessionInfoDTO userSessionInfoDto = service.login(dto);
				
			 // 200 | 조회 성공
				if( userSessionInfoDto != null) {
					HttpSession session = request.getSession();
					
					session.setAttribute("userid", userSessionInfoDto.getUserid());
					session.setAttribute("username", userSessionInfoDto.getUsername());
					
					response.setStatus(200);
					response.getWriter().write("{\"meg\":" + "\"로그인 되었습니다.\"}"); // 클라이언트로 결과 메시지 전송
				
					return;
			 // 404 | 유저 정보가 없음
				} else {
					response.setStatus(404);
					response.getWriter().write("{\"meg\":" + "\"로그인 실패하였습니다. 아이디나 비밀번호를 확인 후 재시도 해주세요.\"}"); // 클라이언트로 결과 메시지 전송
				}
				
			 // 500 | 서버 에러
			} catch(Exception ex) {
					response.setStatus(500);
					response.getWriter().write("{\"meg\":" + "\" 서버 오류 발생\"}"); // 클라이언트로 결과 메시지 전송
			}
		} 
	}
