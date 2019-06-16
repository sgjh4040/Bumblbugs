<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MainDAO" class="DAO.MainDAO" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% 	request.setCharacterEncoding("UTF-8");

		String u_idx = (String) session.getAttribute("u_idx");
		String u_img = (String) session.getAttribute("u_img");
		String u_nm = (String) session.getAttribute("u_nm");
				
		
		ArrayList<ProjectBean> pjlist 		= MainDAO.getAllProject();
		ArrayList<ProjectBean> recommlist 	= MainDAO.getRecommProject();
		ArrayList<ProjectBean> newlist 		= MainDAO.getNewProject();
		ArrayList<ProjectBean> endlist 		= MainDAO.getEndProject();
		ArrayList<ProjectBean> gamelist 	= MainDAO.getGameProject();
		ArrayList<ProjectBean> concertlist 	= MainDAO.getConcertProject();
		ArrayList<ProjectBean> foodlist 	= MainDAO.getFoodProject();
		ArrayList<ProjectBean> designlist 	= MainDAO.getDesignProject();
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatiblee" content="IE=edge,chrome=1" />
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link href="css/Main.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript"
	src="<c:url value="js/jquery-1.8.0.min.js"/>"></script>
	<script type="text/javascript"
	src="<c:url value="js/Main.js"/>"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/Main.js"></script>


<title>BumbleBug</title>
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+HK&display=swap" rel="stylesheet">

</head>
<body>
	<div class="header-wrap">
		<div class="header">
			<div class="hpName-wrap">
				<a class="hpName" href="mainpage.jsp">Bumblbug</a>
			</div>
			<div class="leftproject-bar">
				<a class="view-project" href="Project/tour.jsp">프로젝트 둘러보기</a> 
				<a class="view-project" href="InsertProject/InsertProjectMain.jsp">프로젝트 올리기</a>

			</div>
			<c:choose>
				<c:when test='${empty u_idx}'>
					<div class="rightproject-bar">
						<button class="search"></button>
						<a href="Login/login.jsp" class="view-login">로그인/회원가입</a> <img
							src="Bumblbugimg/smile.png" alt="profile"
							style="width: auto; height: 35px;border-radius: 50%">

					</div>
				</c:when>
				<c:when test='${!empty u_img}'>
					<div class="rightproject-bar">
						<button class="search"></button>
						<span class="view-project" style="padding: 0 10px;"><%=u_nm%></span>
						<a href="Mypage/Mypage_menu.jsp" class="view-login"> <img
							src="Bumblbugimg/<%=u_img%>" alt="profile"
							style="width: auto; height: 35px;border-radius: 50%">
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="rightproject-bar">
						<button class="search"></button>
						<span class="view-project" style="padding: 0 10px;"><%=u_nm%></span>
						<a href="Mypage/Mypage_menu.jsp" class="view-login"> <img
							src="Bumblbugimg/smile.png" alt="profile"
							style="width: auto; height: 35px;border-radius: 50%">
						</a>
					</div>



				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<!--//////////////////////////////////////////////////////////////////////////////////-->
	<div class="container">

		<div class="pr_project">
			<div class="pr">
				<div class="box">
					<c:set var="pjlist" value="<%=pjlist %>" />

					<a href="fundProject/ProjectPage.jsp?pj_idx=<%=pjlist.get(24).getPj_idx()%>"><img
						src="Bumblbugimg/<%=pjlist.get(24).getPj_img()%>" class="ph"></a>
					<a href="fundProject/ProjectPage.jsp?pj_idx=<%=pjlist.get(25).getPj_idx()%>"><img
						src="Bumblbugimg/<%=pjlist.get(25).getPj_img()%>"
						class="ph novisual"></a> <a href="fundProject/ProjectPage.jsp?pj_idx=<%=pjlist.get(26).getPj_idx()%>"><img
						src="Bumblbugimg/<%=pjlist.get(26).getPj_img()%>"
						class="ph novisual"></a> <a href="fundProject/ProjectPage.jsp?pj_idx=<%=pjlist.get(27).getPj_idx()%>"><img
						src="Bumblbugimg/<%=pjlist.get(27).getPj_img()%>"
						class="ph novisual"></a> <a href="fundProject/ProjectPage.jsp?pj_idx=<%=pjlist.get(28).getPj_idx()%>"><img
						src="Bumblbugimg/<%=pjlist.get(28).getPj_img()%>"
						class="ph novisual"></a>
						
					<span class="header-PJ_title"><%=pjlist.get(24).getPj_title()%></span>
					<span class="header-PJ_title novisual"><%=pjlist.get(25).getPj_title()%></span>
					<span class="header-PJ_title novisual"><%=pjlist.get(26).getPj_title()%></span>
					<span class="header-PJ_title novisual"><%=pjlist.get(27).getPj_title()%></span>
					<span class="header-PJ_title novisual"><%=pjlist.get(28).getPj_title()%></span>


					<ul class="control_box">
						<li class="cont"><img
							src="Bumblbugimg/<%=pjlist.get(24).getPj_img()%>" alt="사진1"></li>
						<li class="cont"><img
							src="Bumblbugimg/<%=pjlist.get(25).getPj_img()%>" alt="사진2"></li>
						<li class="cont"><img
							src="Bumblbugimg/<%=pjlist.get(26).getPj_img()%>" alt="사진3"></li>
						<li class="cont"><img
							src="Bumblbugimg/<%=pjlist.get(27).getPj_img()%>" alt="사진4"></li>
						<li class="cont"><img
							src="Bumblbugimg/<%=pjlist.get(28).getPj_img()%>" alt="사진5"></li>
					</ul>
					
				</div>

			</div>
		</div>
		<!-- ..........................................................................-->

		<div class="recommend_project">
			<div class="recommend_header">
				<a class="recommend" href="Project/recommproject.jsp">추천 프로젝트</a>
			</div>

			<div class="project_card_section">
				<c:set var="recommlist" value="<%=recommlist %>" />
				
				<!-- ----------날짜계산------------------------ -->
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<fmt:parseNumber value="${now.time / (1000*60*60*24)}"
					integerOnly="true" var="nowdayfull" scope="request" />
				<fmt:formatDate value="${now}" var="nowdate" pattern="yyyy-MM-dd" />
				<c:forEach var="pjBean" items="${recommlist}" begin="0" end="3">
					<fmt:parseDate var="deadline" value="${pjBean.pj_end_dt}"
						pattern="yyyy-MM-dd" />
					<fmt:parseNumber var="deadlinefull"
						value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
						scope="request" />
						
						
						<!-- ----------날짜계산------------------------ -->



					<div class="project_card"
						onclick="location.href='fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">

						<div class="card_content">
							<div class="imgbox">
								<img src="Bumblbugimg/${pjBean.pj_img}"
									style="width: 210px; height: 150px;" alt="">
							</div>

							<div class="textbox">
								<div id="title">${pjBean.pj_title}</div>
								<div id="leader">${pjBean.leader_nm}</div>
							</div>
							<div class="analyzebox">
								<progress class="progress"
									value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>
								<div class="nowbox">
									<div
										style="color: red; width: 15px; margin-right: 7px; float: left;">${deadlinefull - nowdayfull} </div>
									일 남음
									<div style="float: right;">
										<fmt:formatNumber
											value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#' />
										%
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- ///////////////////////////////////////////////////////////// -->

		<div class="new_project">
			<div class="new_header">
				<a class="new" href="Project/newproject.jsp">새로운 프로젝트</a>

			</div>

			<div class="project_card_section">
				<c:set var="newlist" value="<%=newlist %>" />
				<c:forEach var="pjBean" items="${newlist}" begin="0" end="3">
				<fmt:parseDate var="deadline" value="${pjBean.pj_end_dt}"
						pattern="yyyy-MM-dd" />
					<fmt:parseNumber var="deadlinefull"
						value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
						scope="request" />
					<div class="project_card"
						onclick="location.href='fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">

						<div class="card_content">
							<div class="imgbox">
								<img src="Bumblbugimg/${pjBean.pj_img}"
									style="width: 210px; height: 150px;" alt="">
							</div>

							<div class="textbox">
								<h4>${pjBean.pj_title}</h4>
								<h6>${pjBean.leader_nm}</h6>
							</div>

							<div class="analyzebox">
								<progress class="progress"
									value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>
								<div class="nowbox">
									<div
										style="color: red; width: 15px; margin-right: 7px; float: left;">${deadlinefull - nowdayfull}</div>
									일 남음
									<div style="float: right;">
										<fmt:formatNumber
											value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#' />
										%
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- ///////////////////////////////////////////////////////////// -->

		<div class="end_project">
			<div class="end_header">
				<a class="end" href="Project/endproject.jsp">마감 앞둔 프로젝트</a>

			</div>
			<div class="project_card_section">
				<c:set var="endlist" value="<%=endlist%>" />
				<c:forEach var="pjBean" items="${endlist}" begin="0" end="3">
				<fmt:parseDate var="deadline" value="${pjBean.pj_end_dt}"
						pattern="yyyy-MM-dd" />
					<fmt:parseNumber var="deadlinefull"
						value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
						scope="request" />
					<div class="project_card"
						onclick="location.href='fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">

						<div class="card_content">
							<div class="imgbox">
								<img src="Bumblbugimg/${pjBean.pj_img}"
									style="width: 210px; height: 150px;" alt="">
							</div>

							<div class="textbox">
								<h4>${pjBean.pj_title}</h4>
								<h6>${pjBean.leader_nm}</h6>
							</div>

							<div class="analyzebox">
								<progress class="progress"
									value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>
								<div class="nowbox">
									<div
										style="color: red; width: 15px; margin-right: 7px; float: left;">${deadlinefull - nowdayfull}</div>
									일 남음
									<div style="float: right;">
										<fmt:formatNumber
											value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#' />
										%
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- ///////////////////////////////////////////////////////////// -->
		<div class="category_project">
			<div class="category_header">
				<ul class="category_tab">
					<li class="game current" data-tab="game_section">게임</li>
					<li class="concert" data-tab="concert_section">콘서트</li>
					<li class="food" data-tab="food_section">푸드</li>
					<li class="design" data-tab="design_section">디자인</li>
				</ul>

			</div>

			<div id="game_section" class="category_section current">
				<c:set var="gamelist" value="<%=gamelist %>" />
				<c:forEach var="pjBean" items="${gamelist}" begin="0" end="3">
				<fmt:parseDate var="deadline" value="${pjBean.pj_end_dt}"
						pattern="yyyy-MM-dd" />
					<fmt:parseNumber var="deadlinefull"
						value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
						scope="request" />
					<div class="project_card"
						onclick="location.href='fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">

						<div class="card_content">
							<div class="imgbox">
								<img src="Bumblbugimg/${pjBean.pj_img}"
									style="width: 210px; height: 150px;" alt="">
							</div>

							<div class="textbox">
								<h4>${pjBean.pj_title}</h4>
								<h6>${pjBean.leader_nm}</h6>
							</div>

							<div class="analyzebox">
								<progress class="progress"
									value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>
								<div class="nowbox">
									<div
										style="color: red; width: 15px; margin-right: 7px; float: left;">${deadlinefull - nowdayfull}</div>
									일 남음
									<div style="float: right;">
										<fmt:formatNumber
											value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#' />
										%
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div id="concert_section" class="category_section">
				<c:set var="concertlist" value="<%=concertlist %>" />
				<c:forEach var="pjBean" items="${concertlist}" begin="0" end="3">
				<fmt:parseDate var="deadline" value="${pjBean.pj_end_dt}"
						pattern="yyyy-MM-dd" />
					<fmt:parseNumber var="deadlinefull"
						value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
						scope="request" />
					<div class="project_card"
						onclick="location.href='fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">

						<div class="card_content">
							<div class="imgbox">
								<img src="Bumblbugimg/${pjBean.pj_img}"
									style="width: 210px; height: 150px;" alt="">
							</div>

							<div class="textbox">
								<h4>${pjBean.pj_title}</h4>
								<h6>${pjBean.leader_nm}</h6>
							</div>

							<div class="analyzebox">
								<progress class="progress"
									value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>
								<div class="nowbox">
									<div
										style="color: red; width: 15px; margin-right: 7px; float: left;">${deadlinefull - nowdayfull} </div>
									일 남음
									<div style="float: right;">
										<fmt:formatNumber
											value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#' />
										%
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div id="food_section" class="category_section">
				<c:set var="foodlist" value="<%=foodlist %>" />
				<c:forEach var="pjBean" items="${foodlist}" begin="0" end="3">
				<fmt:parseDate var="deadline" value="${pjBean.pj_end_dt}"
						pattern="yyyy-MM-dd" />
					<fmt:parseNumber var="deadlinefull"
						value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
						scope="request" />
					<div class="project_card"
						onclick="location.href='fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">

						<div class="card_content">
							<div class="imgbox">
								<img src="Bumblbugimg/${pjBean.pj_img}"
									style="width: 210px; height: 150px;" alt="">
							</div>

							<div class="textbox">
								<h4>${pjBean.pj_title}</h4>
								<h6>${pjBean.leader_nm}</h6>
							</div>

							<div class="analyzebox">
								<progress class="progress"
									value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>
								<div class="nowbox">
									<div
										style="color: red; width: 15px; margin-right: 7px; float: left;">${deadlinefull - nowdayfull}</div>
									일 남음
									<div style="float: right;">
										<fmt:formatNumber
											value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#' />
										%
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div id="design_section" class="category_section">
				<c:set var="designlist" value="<%=designlist %>" />
				<c:forEach var="pjBean" items="${designlist}" begin="0" end="3">
				<fmt:parseDate var="deadline" value="${pjBean.pj_end_dt}"
						pattern="yyyy-MM-dd" />
					<fmt:parseNumber var="deadlinefull"
						value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
						scope="request" />
					<div class="project_card"
						onclick="location.href='fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">

						<div class="card_content">
							<div class="imgbox">
								<img src="Bumblbugimg/${pjBean.pj_img}"
									style="width: 210px; height: 150px;" alt="">
							</div>

							<div class="textbox">
								<h4>${pjBean.pj_title}</h4>
								<h6>${pjBean.leader_nm}</h6>
							</div>

							<div class="analyzebox">
								<progress class="progress"
									value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>
								<div class="nowbox">
									<div
										style="color: red; width: 15px; margin-right: 7px; float: left;">${deadlinefull - nowdayfull}</div>
									일 남음
									<div style="float: right;">
										<fmt:formatNumber
											value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#' />
										%
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>

	<!--//////////////////////////////////////////////////////////////////////////////////-->
	<div class="footer">
		<div class="footerSet">
			<div class="foot_1">
				<a class="notice"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">공지사항</a><br>
				<a class="hire"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">채용</a><br>
				<a class="createGuide"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">창작자가이드</a><br>
				<a class="settlement"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">결산</a>
			</div>
			<!--첫번째 텍스트박스-->
			<div class="foot_2">
				<a class="termsOfService"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">이용약관</a><br>
				<a class="privacyPolicy"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">개인정보
					처리방침</a><br> <a class="feePolicy"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">수수료
					정책</a><br> <a class="helpCenter"
					href="C:\Users\user\Desktop\Project\footer\noticePage.html">헬프
					센터</a><br>
			</div>
			<!--두번째 텍스트박스-->
			<div class="foot_3">
				<ul>
					<li><a href="#"
						onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img
							src="./icon/sns_ka.png" width="30"></a></li>
					<li><a href="#"
						onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img
							src="./icon/sns_face.png" width="30"></a></li>
					<li><a href="#"
						onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img
							src="./icon/sns_tw.png" width="30"></a></li>
					<li><a href="#"
						onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img
							src="./icon/sns_insta.png" width="30"></a></li>
					<li><a href="#"
						onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img
							src="./icon/sns_naver.png" width="30"></a></li>

				</ul>
				

			</div>
			<!--sns /문의하기 박스-->
		</div>
		<div class="foot_4">
			<span id="notice_1">000은 텀블벅은 플랫폼 제공자로서 프로젝트의 당사자가 아니며, 직접적인
				통신판매를 진행하지 않습니다. 프로젝트의 완수 및 선물제공의 책임은 해당 프로젝트의 창작자에게 있으며, 프로젝트와 관련하여
				후원자와 발생하는 법적 분쟁에 대한 책임은 해당 창작자가 부담합니다. </span>
		</div>
		<!--세번째텍스트박스-->
		<div class="foot_5">
			<span id="notice_2"> 텀블벅(주) | 대표 염재승 105-87-52823 | 서울시 강남구
				강남대로 364, 12층 1201호 (역삼동) | 통신판매업 2019-서울강남-00797 | 대표전화
				02-6080-0760 </span>
		</div>
		<!--네번째 텍스트박스-->
	</div>


</body>
</html>



