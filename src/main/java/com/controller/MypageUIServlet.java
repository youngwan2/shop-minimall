package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.MemberDao;
import com.dto.ResponseUserProfileDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/mypage")
public class MypageUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		
		// 401 | 세션 정보 없음 
		if (userid == null) {
			request.setAttribute("error", "로그인이 필요합니다." );
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
		    return;
		}

		
		MemberService service = new MemberServiceImpl();
		service.setDao(new MemberDao());

		try {
			ResponseUserProfileDTO responseUserProfileDTO =  service.getUserProfile(userid);
		
		// 200 | 조회 성공
		if(responseUserProfileDTO != null) {
			request.setAttribute("profile", responseUserProfileDTO);
			
		// 404 | 유저 정보 없음
		} else {
			request.setAttribute("error", "유저 정보를 찾을 수 없습니다.");
		}

		// 500 | 서버 측 에러
		} catch(Exception ex) {
			request.setAttribute("error", "서버 문제가 발생하였습니다. 나중에 재시도 해주세요.");
		}
		
		
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}
}
