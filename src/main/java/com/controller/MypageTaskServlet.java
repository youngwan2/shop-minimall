package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.MemberDao;
import com.dto.MemberDTO;
import com.dto.ResponseUserProfileDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/mypage-task")
public class MypageTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userid = (String) session.getAttribute("userid");
		response.setContentType("application/json");
		
		// 세션 정보가 없으면 
		if(userid == null || userid.isEmpty()) {
			response.setStatus(401);
			response.getWriter().write("{\"meg\":" + "\"접근 권한이 없습니다. \"}"); // 클라이언트로 결과 메시지 전송
			return;
		}
		
		
	   // 폼 데이터 받기
        String post = request.getParameter("post");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        
        
        // 받은 데이터를 MemberDTO에 담기
        MemberDTO memberDto = new MemberDTO();
        memberDto.setUserid(userid);
        memberDto.setPost(post);
        memberDto.setAddr1(addr1);
        memberDto.setAddr2(addr2);
        memberDto.setPhone1(phone1);
        memberDto.setPhone2(phone2);
        memberDto.setPhone3(phone3);
        memberDto.setEmail1(email1);
        memberDto.setEmail2(email2);
        
        System.out.println(memberDto);
        
        // 서비스 객체를 통해 회원가입 처리
        MemberService service = new MemberServiceImpl();
        service.setDao(new MemberDao());
        
        // 프로필 정보 수정
        
        try {
	        boolean isUpdated = service.updateUserProfile(memberDto);
	        // 응답 처리
	        response.setContentType("aplication/json; charset=utf-8");
	        if (isUpdated) {
	        	 response.setStatus(201);
	        	 response.getWriter().write("{\"meg\":" + "\"프로필 정보가 수정 되었습니다.\"}"); // 클라이언트로 결과 메시지 전송
	        } else {
	        	response.setStatus(409);
	        	response.getWriter().write("{\"meg\":" + "\"프로필 수정에 실패하였습니다.\"}"); // 클라이언트로 결과 메시지 전송
	        }
        } catch(Exception ex) {
        	response.setStatus(500);
       	 	response.getWriter().write("{\"meg\":" + "\" 서버 문제 발생 \"}"); // 클라이언트로 결과 메시지 전송
        }
	}
}
