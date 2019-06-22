<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="mDAO" class="DAO.MemberDAO" />
<%
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
	boolean result = mDAO.checkEmail(email);

	if (result) {
		
%>
<span>이메일 존재합니다.</span>
<input type="hidden" id="exist" name="exist" value="1">
<%
	} else {
%>
<input type="hidden" id="exist" name="exist" value="0">
<%
	}
%>
