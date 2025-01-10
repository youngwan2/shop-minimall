<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<c:if test="${empty username}">
    <form class="row g-3 m-4" id="login-form">
		  <div class="row mb-3">
		    <label for="userid" class="col-sm-2 col-form-label">아이디</label>
		    <div class="col-auto">
		      <input type="text" class="form-control" id="userid" name="userid">
		    </div>
		  </div>
		 <div class="row mb-3">
		    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
		    <div class="col-auto">
		      <input type="password" class="form-control" name="passwd" id="passwd">
		    </div>
		  </div>
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">로그인</button>
		    <button type="reset" class="btn btn-primary">취소</button>
		  </div>
 	</form>
 </c:if>
 <c:if test="${username != null}">
 		<p style="margin-top:1.25rem">현재 로그인 상태입니다.</p>
		<c:redirect url="main.jsp" /> 
 </c:if>
   
</div> 
 <script>
    	const loginForm = document.getElementById("login-form");
    	
    
    	// 로그인 요청 리스너
    	loginForm.addEventListener("submit",login);
    	
    	// 로그인 요청
    	async function login(e){
    		e.preventDefault();
    		const formData = new URLSearchParams(new FormData(loginForm)).toString();
    		const url = "/shop/login-task";
    		
    		console.log(formData)
    		const config = {
    				method:'POST',
    				headers: {
    					'Content-Type': 'application/x-www-form-urlencoded',
    				},
    				body: formData
    		}
    		
    		try {
	    		const response = await fetch(url, config);
	    		const data = await response.json();
	    		console.log(data)
	    		alert(data.meg);
	    		
	    		if(response.ok){
	    			location.href="/shop"
	    		}
    		} catch(error){
    			alert(error.message);
    		}
    	}
    	
    </script>