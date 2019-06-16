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
    String d_nm = request.getParameter("name");
    out.println(d_nm);
	MypageDAO.updateName(d_idx, d_nm);

	
    %>

<script>location.href = "MypageUpdateFund.jsp?f_pj_idx=<%=f_pj_idx%>&f_idx=<%=f_idx%>"</script>