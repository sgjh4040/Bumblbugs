<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MypageDAO" class="DAO.MypageDAO" />
<%
	request.setCharacterEncoding("UTF-8");
	String f_pj_idx = request.getParameter("f_pj_idx");
	String f_idx = request.getParameter("f_idx");
	String d_idx = request.getParameter("d_idx");
	out.println(d_idx);
    String d_ph = request.getParameter("phnumber");
    out.println(d_ph);
	MypageDAO.updatePhnum(d_idx, d_ph);

	
    %>

<script>location.href = "MypageUpdateFund.jsp?f_pj_idx=<%=f_pj_idx%>&f_idx=<%=f_idx%>"</script>

