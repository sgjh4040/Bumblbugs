<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");

	String u_idx = (String) session.getAttribute("u_idx");
	String u_img = (String) session.getAttribute("u_img");
	String u_nm = (String) session.getAttribute("u_nm");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatiblee" content="IE=edge,chrome=1" />
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>


<c:set var="u_idx" value="<%=u_idx%>" />

	<div class="header-wrap">
		<div class="header">
			<div class="hpName-wrap">
				<a class="hpName" href="${contextPath}/mainpage.jsp">Bumblbug</a>
			</div>
			<div class="leftproject-bar">
				<a class="view-project" href="../Project/tour.jsp">프로젝트
					둘러보기</a> <a class="view-project" href="../InsertProject/InsertProjectMain.jsp">프로젝트
					올리기</a>

			</div>
			<c:choose>
				<c:when test='${empty u_idx}'>
					<div class="rightproject-bar">
						<button class="search"></button>
						<a href="../Login/login.jsp" class="view-login">로그인/회원가입</a> 
						<img src="../Bumblbugimg/smile.png" alt="profile" style="width: auto; height: 35px;border-radius: 50%">
						
					</div>
				</c:when>
				<c:when test='${!empty u_img}'>
					<div class="rightproject-bar">
						<button class="search"></button>
						<span class="view-project" style="padding:0 10px;"><%=u_nm%></span>
						<a href="../Mypage/Mypage_menu.jsp" class="view-login">  <img
							src="../Bumblbugimg/<%=u_img%>" alt="profile"
							style="width: auto; height: 35px;border-radius: 50%">
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="rightproject-bar">
						<button class="search"></button>
						<span class="view-project" style="padding:0 10px;"><%=u_nm%></span>
						<a href="../Mypage/Mypage_menu.jsp" class="view-login">  <img
							src="../Bumblbugimg/smile.png" alt="profile"
							style="width: auto; height: 35px;border-radius: 50%">
						</a>
					</div>
				
				
				
				</c:otherwise>
			</c:choose>

		</div>
	</div>