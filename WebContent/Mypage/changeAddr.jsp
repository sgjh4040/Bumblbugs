<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MypageDAO" class="DAO.MypageDAO" />
<%
	request.setCharacterEncoding("UTF-8");
	String f_pj_idx = request.getParameter("f_pj_idx");
	String f_idx = request.getParameter("f_idx");
	String d_idx = request.getParameter("d_idx");
	String postcode = request.getParameter("postcode");
	String address = request.getParameter("address");
	String detailAddress = request.getParameter("detailAddress");
	
	DelBean delbean = new DelBean();
	
	delbean.setD_addr(address);
	delbean.setD_detail_addr(detailAddress);
	delbean.setD_zipcode(postcode);
	delbean.setD_idx(Integer.parseInt(d_idx));
	
	MypageDAO.updateAddress(delbean);
    
	
    %>
<script>location.href = "MypageUpdateFund.jsp?f_pj_idx=<%=f_pj_idx%>&f_idx=<%=f_idx%>"</script>

