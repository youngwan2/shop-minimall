package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dao.MemberDao;
import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/id-check")
public class MemberCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberService service = new MemberServiceImpl();
        service.setDao(new MemberDao());
        
        StringBuilder jsonData = new StringBuilder();
        String line;
        try(BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        }
        
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        String userid = null;
        
        try {
            obj = (JSONObject) parser.parse(jsonData.toString());
            userid = (String) obj.get("userid");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        System.out.println(userid);
        
        // 아이디 중복 체크
        MemberDTO memberDto = service.idCheck(userid);
        String meg = "아이디 사용 가능";
        
        if (memberDto != null) {
            meg = "아이디 중복";
        }
        
        // 응답 처리
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(200); // 200 OK 상태 코드로 수정
        response.getWriter().write("{\"meg\":" + "\""+meg+"\"}"); // 클라이언트로 결과 메시지 전송
    }
}
