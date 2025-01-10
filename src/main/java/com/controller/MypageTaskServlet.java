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
		
		
		
		
		   // 폼 데이터 받기
        String post = request.getParameter("post");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String email3 = request.getParameter("email3");
        
        // email2 는 사용자가 직접 입력한 도메인이므로 빈 값인 경우 email3 의 선택형 도메인으로 대체
        if(email2.isEmpty() || email2 !=null) {
        	email2 = email3;
        }
        
        
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
        
        // 회원가입 처리
        boolean isRegistered = service.registerMember(memberDto);
        
        // 응답 처리
        response.setContentType("aplication/json; charset=utf-8");
        if (isRegistered) {
        	 response.setStatus(201);
        	 response.getWriter().write("{\"meg\":" + "\"회원가입 되었습니다.\"}"); // 클라이언트로 결과 메시지 전송
        } else {
        	response.setStatus(500);
        	response.getWriter().write("{\"meg\":" + "\"회원가입에 실패하였습니다.\"}"); // 클라이언트로 결과 메시지 전송
        }
		
	}

}
