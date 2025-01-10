<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<style>
 .header-right-nav{
 	display:flex;
 	align-items:center;
 	
 }
</style>
 <header class="border-bottom border-light border-5">
            <div class="container">
                <div class="row">
                    <nav class="navbar navbar-expand-lg">
                        <div class="collapse navbar-collapse">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="/shop">Home</a>
                                </li>
                            </ul>
                        </div>
                        
                        <!-- 로그인/ 회원가입 페이지 버튼 -->
                        <c:if test="${empty username}">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                               <a class="nav-link" href="/shop/login">Login</a>
                            
                            </li>
                             <li class="nav-item">
                               <a class="nav-link" href="/shop/signup">signup</a>
                            </li>
                        </ul>
                        </c:if>
                        <c:if test="${username != null}">
                        <ul class="navbar-nav header-right-nav">
                        	<li class="nav-item">
                        	   ${username}님! 환영합니다.
                            </li>
                            <li class="nav-item">
                               <a class="nav-link" href="/shop/mypage">Mypage</a>
                            </li>
                        </ul>
                        </c:if>
                    </nav>
                </div>
            </div>
        </header>