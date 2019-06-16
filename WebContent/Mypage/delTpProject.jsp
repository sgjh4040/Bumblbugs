<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MypageDAO" class="DAO.MypageDAO" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Context 이름 설정 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
    
    <% 
    	request.setCharacterEncoding("UTF-8");
    	String u_idx = (String)session.getAttribute("u_idx");
    	String tp_idx = request.getParameter("tp_idx");
    	
    	MypageDAO.deleteTemp(tp_idx);
    	MypageDAO.deleteTempPresent(tp_idx);
    	
    	

    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
		location.href = "Mypage_project.jsp";

</script>

</body>
</html>