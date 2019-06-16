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
    	String p_idx = request.getParameter("p_idx");
    	String pj_idx = (String)session.getAttribute("pj_idx");
    	String f_idx = request.getParameter("f_idx");
    	String pay_idx = request.getParameter("pay_idx");
    	
    	out.println("f_idx: " +f_idx);
    	out.println("pay_idx: "+pay_idx);
    	
    	String fundprice = MypageDAO.getFundprice(u_idx, pj_idx);
    	//프로젝트 금액 변경
    	MypageDAO.updatepjPrice("-"+fundprice, pj_idx);
    	MypageDAO.countdownPresent(p_idx);
    	MypageDAO.countdownProject(pj_idx);
    	MypageDAO.deleteFund(f_idx);
    	MypageDAO.deletePay(pay_idx);

    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
		alert("후원이 취소 되었습니다.");
		location.href = "Mypage_fund.jsp";

</script>

</body>
</html>