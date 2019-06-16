<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MypageDAO" class="DAO.MypageDAO" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
request.setCharacterEncoding("UTF-8");
	String u_idx = (String) session.getAttribute("u_idx");
	
	String search = request.getParameter("search");
	ArrayList<ProjectBean> list = MypageDAO.getSearchAJAX(search);
	int count = list.size();
%>

<c:set var="list" value="<%=list%>" />
<c:set var="count" value="<%=count %>" />


<c:forEach var="projectbean" items="${list}">

<a href="../fundProject/ProjectPage.jsp?pj_idx=${projectbean.pj_idx}"><div class="search-name">${projectbean.pj_title}</div></a>
</c:forEach>

















