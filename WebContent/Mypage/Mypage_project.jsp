<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MypageDAO" class="DAO.MypageDAO" />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");

	String u_idx = (String) session.getAttribute("u_idx");

	if (u_idx == null || u_idx.equals("")) {
		response.sendRedirect("../mainpage.jsp");
	} ;
	String u_img = (String) session.getAttribute("u_img");
	String u_nm = (String) session.getAttribute("u_nm");
	ArrayList<TempBean> list = MypageDAO.getTempProjectList(u_idx);
	ArrayList<ProjectBean> Mylist = MypageDAO.getProjectList(u_idx);
	int listnumber = list.size();
	int mylistnumber = Mylist.size();
%>
<c:set var="u_idx" value="<%=u_idx%>" />
<c:set var="u_img" value="<%=u_img%>" />
<c:set var="list" value="<%=list%>" />
<c:set var="Mylist" value="<%=Mylist%>" />
<c:set var="listnumber" value="<%=listnumber%>" />
<c:set var="mylistnumber" value="<%=mylistnumber%>" />
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<title><%=u_nm%>님이 만든 프로젝트</title>
<link href="../css/Main.css" rel="stylesheet" type="text/css"
	media="all">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/Mypage_project.css">

<script type="text/javascript">
    function check()
    {
        msg = "정말로 삭제 하겠습니까?";
        if (confirm(msg)!=0) {
             // Yes click
        	document.getElementById("delFrm").submit();
             
        } else {
            // no click
        	
            
}
    }; // myconfirm
    
    
    
    </script>



</head>

<body>
	<!-- --------header------------ -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- --------header------------ -->
	<div class="container_1">
		<div class="upstyle">
			<div class="smile_img_line">
				<div class="smile_last_lay">
					<div class="smile_line_lay">
						<div class="img_ready">
							<!-- ----------------프로필 사진--------------------- -->
							<c:choose>
								<c:when test='${empty u_img}'>
									<img src="../Bumblbugimg/smile.png" alt="profile"
										style="width: auto; height: 100px; border-radius: 50%">
								</c:when>
								<c:otherwise>
									<img src="../Bumblbugimg/<%=u_img%>" alt="profile"
										style="width: auto; height: 100px; border-radius: 50%">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="smile_down_text_lay">
							<h1 class="text_setting">${u_nm}</h1>
						</div>
						<div style="color: #898080;">저희는 당신의 멋진 프로젝트를 기다립니다</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container_2">
		<div class="makeing_project_1">
			<div class="makeing_project_list">
				<div class="makeing_pro_text">
					<div class="text_start_1">
						<h3 class="text_start_2">내가 만든 프로젝트</h3>
						<span class="font_color" style="margin-left: 6px">${mylistnumber}</span>
						개
					</div>
				</div>
				<div class="container_3">

					<!-- -------------내가만든 프로젝트--------------------------------->

					<c:forEach var="projectbean" items="${Mylist}">
						<c:set var="now" value="<%=new java.util.Date()%>" />

						<fmt:parseNumber value="${now.time / (1000*60*60*24)}"
							integerOnly="true" var="nowdayfull" scope="request" />
						<fmt:parseDate var="deadline" value="${projectbean.pj_end_dt}"
							pattern="yyyy-MM-dd" />
						<fmt:parseNumber var="deadlinefull"
							value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"
							scope="request" />

						<a href="../fundProject/ProjectPage.jsp?pj_idx=${projectbean.pj_idx}">
							<div class="project_list_lay">

								<c:choose>
									<c:when test="${empty projectbean.pj_img }">
										<div>
											<img src="../Bumblbugimg/project.PNG"
												class="project_list_head_img">
										</div>
									</c:when>
									<c:otherwise>
										<div>
											<img src="../Bumblbugimg/${projectbean.pj_img}"
												style="width: 100%; height: 190px;"
												class="project_list_head_img">
										</div>
									</c:otherwise>
								</c:choose>



								<div class="project_name">
									<div class="text_setting_1">${projectbean.pj_short_title}</div>
									<p class="text_setting_1"><%=u_nm%>의 프로젝트
									</p>

									<p class="text_setting_2">${projectbean.pj_summary}</p>


									<div class="money_time">
										<div class="time_1">
											<span class="money_2">모인 금액</span> <span class="money_2_1">${projectbean.pj_f_price}원<span
												class="money_2_2"><fmt:formatNumber
														value='${projectbean.pj_f_price/projectbean.obj_price*100}'
														pattern="#.00" /> %</span></span>
										</div>
										<div class="time_1">
											<span class="time_2">남은 시간</span> <span class="time_2_1">${deadlinefull-nowdayfull}일</span>
										</div>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
					<!-- ---------------------------------------------------------->
				</div>
			</div>
		</div>
	</div>


	<div class="container_2">
		<div class="makeing_project_1">
			<div class="makeing_project_list">
				<div class="makeing_pro_text">
					<div class="text_start_1">
						<h3 class="text_start_2">만드는 중 프로젝트</h3>
						<span class="font_color" style="margin-left: 6px">${listnumber}</span>
						개
					</div>
				</div>
				<div class="container_3">

					<!-- -------------만드는중 프로젝트--------------------------------->

					<c:forEach var="tempbean" items="${list}">
						<a
							href="../InsertProject/InsertProjectMain.jsp?tp_idx=${tempbean.tp_idx }" style="">
							<div class="project_list_lay">

								<c:choose>
									<c:when test="${empty tempbean.tp_img }">
										<div>
											<img src="../Bumblbugimg/project.PNG"
												class="project_list_head_img">
										</div>
									</c:when>
									<c:when test="${tempbean.tp_img == 'null' }">
										<div>
											<img src="../Bumblbugimg/project.PNG"
												class="project_list_head_img">
										</div>
									</c:when>
									<c:otherwise>
										<div>
											<img src="../Bumblbugimg/${tempbean.tp_img}"
												style="width: 100%; height: 190px;z-index: 1000;"
												class="project_list_head_img">
										</div>
									</c:otherwise>
								</c:choose>


							
								
							
								<div class="project_name">
									<div class="text_setting_1">${tempbean.tp_short_title}</div>
									<p class="text_setting_1"><%=u_nm%>의 프로젝트
									</p>

									<p class="text_setting_2" >${tempbean.tp_summary}</p>


									<div class="money_time">
										<div class="time_1">
											<span class="money_2">모인 금액</span> <span class="money_2_1">0원<span
												class="money_2_2">0 %</span></span>
										</div>
										<div class="time_1">
											<span class="time_2">남은 시간</span> <span class="time_2_1">0일</span>
										</div>
									</div>
								</div>
								</a>
								<form id="delFrm" name="delFrm" method="post"action="delTpProject.jsp">
								<div style="text-align: right">
									<input class="cancel-button" type="button" onClick="check()" value="삭제">
								</div>
								<input type="hidden" name="tp_idx" value="${tempbean.tp_idx}">
								</form>
							</div>
						
					</c:forEach>
					<!-- ---------------------------------------------------------->
				</div>
			</div>
		</div>
	</div>
</body>

</html>