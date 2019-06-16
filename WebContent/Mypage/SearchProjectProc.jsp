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
	ArrayList<FundBean> list = MypageDAO.getSearchFundBox(u_idx, search);
	int count = list.size();
%>

<c:set var="list" value="<%=list%>" />
<c:set var="count" value="<%=count %>" />

<div class="result_funding">
	<div class="result_funding_in">
		<i class="list_lmg"> <img src="../Bumblbugimg/list.png"
			style="width: 23px; height: 17px;">
		</i> 총 ${count }건의 후원 결과가 있습니다.
	</div>
</div>
<div class="gift_box">
	<div id="searchBox">




		<c:forEach var="fundbean" items="${list}">
			<c:url var="detailurl" value="MypageUpdateFund.jsp">
				<c:param name="f_pj_idx" value="${fundbean.f_pj_idx}" />
				<c:param name="f_idx" value="${fundbean.f_idx}" />
			</c:url>


			<c:set var="now" value="<%=new java.util.Date()%>" />
			<fmt:parseNumber value="${now.time / (1000*60*60*24)}"
				integerOnly="true" var="nowdayfull" scope="request" />
			<fmt:formatDate value="${now}" var="nowdate" pattern="yyyy-MM-dd" />
			<fmt:parseDate var="deadline"
				value="${fundbean.projectbean.pj_end_dt}" pattern="yyyy-MM-dd" />
			<fmt:parseNumber value="${deadline.time / (1000*60*60*24)}"
				integerOnly="true" var="deadlinefull" scope="request" />
			<c:set var="remainday" value="${deadlinefull-nowdayfull}" />



			<a href='${detailurl}'
				style="text-decoration: none; color: rgba(0, 0, 0, .87);">

				<div class="pj_container">
					<div class="box_header">
						<b>${fundbean.f_dt}</b> <span class="box_number">후원번호 <b>:${fundbean.f_idx}</b>
						</span>
					</div>
					<div class="box_body">

						<div class="box_body_in">
							<div class="pic">
								<img src="../Bumblbugimg/${fundbean.projectbean.pj_img}"
									style="width: 150px; height: auto;">
							</div>
							<div class="pic_right_text">
								<c:choose>
									<c:when test='${remainday >=0}'>
										<div>
											<label class="fund_ing"> 펀딩 진행중 </label>
										</div>
									</c:when>
									<c:otherwise>
										<div>
											<label class="fund_end"> 펀딩 마감 </label>
										</div>
									</c:otherwise>

								</c:choose>

								<div class="text_1">프로젝트 제목:
									${fundbean.projectbean.pj_title}</div>
									<br>
								<div class="text_2">선물: ${fundbean.presentbean.p_nm}</div>
								<br>
								<div class="text_3">
									<b>${fundbean.f_price}원</b>을 후원하셨습니다

								</div>
							</div>
						</div>
					</div>
				</div>
		</c:forEach>




	</div>
</div>

<div class="number_chart">
	<div class="text_number_div">
		<numberchart class="number_start">1</numberchart>
	</div>
</div>


















