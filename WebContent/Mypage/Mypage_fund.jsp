<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MypageDAO" class="DAO.MypageDAO" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String u_idx = (String) session.getAttribute("u_idx");
	if (u_idx == null || u_idx.equals("")) {
		response.sendRedirect("../mainpage.jsp");
	} ;
%>

<%
	String u_img = (String) session.getAttribute("u_img");
	String u_nm = (String) session.getAttribute("u_nm");
	ArrayList<FundBean> list = MypageDAO.getFundBox(u_idx);
	ArrayList<FundBean> list1 = MypageDAO.getFundBoxing(u_idx);
	ArrayList<FundBean> list2 = MypageDAO.getFundBoxend(u_idx);

	int count = list.size();
	int count1 = list1.size();
	int count2 = list2.size();
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="count" value="<%=count%>" />
<c:set var="count1" value="<%=count1%>" />
<c:set var="count2" value="<%=count2%>" />
<c:set var="u_img" value="<%=u_img%>" />


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<title>후원현황 :: 텀블벅</title>
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="../css/Main.css" rel="stylesheet" type="text/css"
	media="all">
<link href="../css/Mypage_fund.css" rel="stylesheet" type="text/css"
	media="all">

<script>
	/*프로젝트 찾기위한 AJAX 구현 메소드*/
	function searchProject() {
		var input = document.getElementById("typing").value;
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = function() {
			if (httpRequest.readyState == XMLHttpRequest.DONE
					&& httpRequest.status == 200) {

				document.getElementById("searching").innerHTML = httpRequest.responseText;
			}
		};
		// POST 방식의 요청은 데이터를 Http 헤더에 포함시켜 전송함.
		httpRequest.open("POST", "SearchProjectProc.jsp", true);
		httpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		httpRequest.send("search=" + input); //변수에 데이터 넣으면 post방식
	}

	$(function() {
		$("#typing").keydown(
				function(key) {
					if (key.keyCode == 13) {
						$(".show-funding").attr("style", "display:none;");
						$("#searching").attr("style", "display:block;");
						if ($(".none_click_2").hasClass("click_1")) {
							$(".none_click_2").removeClass("click_1")
									.children().removeClass("click_icon_1");
						}
						searchProject();

					}

				});

		$(".none_click_2").on(
				"click",
				function() {
					$("#searching").attr("style", "display:none;");
					if ($(this).hasClass("click_1")) {
						$(this).removeClass("click_1").children().removeClass(
								"click_icon_1");
					} else {
						$(this).addClass("click_1").children().addClass(
								"click_icon_1");
						$(this).siblings().removeClass("click_1").children()
								.removeClass("click_icon_1");
					}

					if ($("#all-fund").hasClass("click_1")) {
						$("#all").attr("style", "display:block;");
					} else {
						$("#all").attr("style", "display:none;");
					}
					if ($("#ing-fund").hasClass("click_1")) {
						$("#ing").attr("style", "display:block;");
					} else {
						$("#ing").attr("style", "display:none;");
					}
					if ($("#ed-fund").hasClass("click_1")) {
						$("#end").attr("style", "display:block;");
					} else {
						$("#end").attr("style", "display:none;");
					}
				});

		$("#search-icon").on(
				'click',
				function() {
					$(".show-funding").attr("style", "display:none;");
					$("#searching").attr("style", "display:block;");
					if ($(".none_click_2").hasClass("click_1")) {
						$(".none_click_2").removeClass("click_1").children()
								.removeClass("click_icon_1");

					}
				});

	});

	/* --------------------------------------------------------------------------------------------------------------------------------- */
</script>


</head>


<body style="overflow: auto;">
	<jsp:include page="../header.jsp"></jsp:include>


	<div class="container">
		<div class="img_box">

			<c:choose>
				<c:when test='${empty u_idx}'>

					<img src="../Bumblbugimg/smile.png" alt="profile"
						style="width: auto; height: 80px; border-radius: 50%">
				</c:when>
				<c:when test='${!empty u_img}'>
					<img src="../Bumblbugimg/<%=u_img%>" alt="profile"
						style="width: auto; height: 80px; border-radius: 50%">
				</c:when>
				<c:otherwise>
					<img src="../Bumblbugimg/smile.png" alt="profile"
						style="width: auto; height: 80px; border-radius: 50%">
				</c:otherwise>
			</c:choose>





			<h3 class="text_setting"><%=u_nm%>님의 후원 현황
			</h3>
		</div>
	</div>
	<div class="container_2">

		<div class="icon_funding_pay_all_box">
			<div class="icon_funding_pay_search">
				<div class="icon_funding_pay_left">
					<a class="none_click_2 click_1" id="all-fund">모두보기
						<div class="none_icon_2 click_icon_1">
							<c:if test="${count == null}">
							0
							</c:if>
							${count}
						</div>
					</a> <a class="none_click_2" id="ing-fund">펀딩 진행중
						<div class="none_icon_2">
						<c:if test="${count1 == null}">
							0
							</c:if>
							${count1}
						
						</div>
					</a> <a class="none_click_2" id="ed-fund">결제 완료
						<div class="none_icon_2">
						<c:if test="${count2 == null}">
							0
							</c:if>
							${count2}</div>
					</a>
				</div>
				<div class="icon_funding_pay_right">
					<div class="search_1">
						<div class="search_2">

							<!-----------------------------------프로젝트 검색 기능 AJAX --------------------------------------------------------->
							<input id="typing" class="searchbox" type="typing"
								name="searchPR" placeholder="  프로젝트, 선물, 창작자를 검색하세요"
								onkeyup="searchProject()" style="width: 100%; height: 35px;">


							<!-----------------------------------프로젝트 검색 기능 AJAX --------------------------------------------------------->

							<div class="search_img">
								<img src="images/search.png" id="search-icon"
									style="width: 30px; height: 30px; padding: 1px;">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="show-funding" id="all" style="display: block">
				<div class="result_funding">
					<div class="result_funding_in">
						<i class="list_lmg"> <img src="images/list.png"
							style="width: 23px; height: 17px;">
						</i>총 ${count}건의 후원 결과가 있습니다.
					</div>
				</div>
				<div class="gift_box">

					<c:choose>
						<c:when test='${count == "0"}'>

							<div style="margin: 0 auto; text-align: center;">

								<div
									style="margin-bottom: 10em; margin-top: 10em; color: #a7a7a7 !important; font-size: 22px;">후원내역이
									없습니다.</div>

							</div>

						</c:when>
						<c:otherwise>
							<!-- -------------------------------프로젝트 박스 include ------------------------------------>
							<jsp:include page="MypageProjectbox.jsp"></jsp:include>
							<!-- -------------------------------프로젝트 박스 include ------------------------------------>

						</c:otherwise>

					</c:choose>


				</div>


			</div>
			<!-- -------------------------------------------------------->
			<div class="show-funding" id="ing" style="display: none">
				<div class="result_funding">
					<div class="result_funding_in">
						<i class="list_lmg"> <img src="images/list.png"
							style="width: 23px; height: 17px;">
						</i>총 ${count1}건의 후원 결과가 있습니다.
					</div>
				</div>
				<div class="gift_box">
					<c:choose>
						<c:when test='${count == "0"}'>

							<div style="margin: 0 auto; text-align: center;">

								<div
									style="margin-bottom: 10em; margin-top: 10em; color: #a7a7a7 !important; font-size: 22px;">후원내역이
									없습니다.</div>

							</div>

						</c:when>
						<c:otherwise>
							<!-- -------------------------------프로젝트 박스 include ------------------------------------>
							<jsp:include page="MypageProjectbox_ing.jsp"></jsp:include>
							<!-- -------------------------------프로젝트 박스 include ------------------------------------>

						</c:otherwise>

					</c:choose>




				</div>

				<div class="number_chart">
					<div class="text_number_div">
						<numberchart class="number_start">1</numberchart>
					</div>
				</div>
			</div>
			<!-- -------------------------------------------------------->


			<div class="show-funding" id="end" style="display: none">
				<div class="result_funding">
					<div class="result_funding_in">
						<i class="list_lmg"> <img src="images/list.png"
							style="width: 23px; height: 17px;">
						</i>총 ${count2}건의 후원 결과가 있습니다.
					</div>
				</div>
				<div class="gift_box">
					<c:choose>
						<c:when test='${count == "0"}'>

							<div style="margin: 0 auto; text-align: center;">

								<div
									style="margin-bottom: 10em; margin-top: 10em; color: #a7a7a7 !important; font-size: 22px;">후원내역이
									없습니다.</div>

							</div>

						</c:when>
						<c:otherwise>
							<!-- -------------------------------프로젝트 박스 include ------------------------------------>
							<jsp:include page="MypageProjectbox_end.jsp"></jsp:include>
							<!-- -------------------------------프로젝트 박스 include ------------------------------------>

						</c:otherwise>

					</c:choose>




				</div>


			</div>


			<!-- --------------------------------------------------------- -->
			<div class="show-funding" id="searching" style="display: none">

				<!-- -------------------------------------------------------------------------- -->

			</div>


		</div>
</body>

</html>