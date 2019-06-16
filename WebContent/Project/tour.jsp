<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MainDAO" class="DAO.MainDAO" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
    
    ArrayList<String> taglist = MainDAO.getTagTour();

    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatiblee" content="IE=edge,chrome=1" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link href="../css/Main.css" rel="stylesheet" type="text/css"
	media="all">
<style>
* {
	font-family: 'Nanum Gothic', sans-serif;
	margin: 0;
	padding: 0;
}

a, a:hover, a:visited, a:link {
	text-decoration: none;
	color: black;
}

.search {
	background-color: transparent;
	border: none;
	cursor: pointer;
}

.search:before {
	content: '';
	display: inline-block;
	margin: 0;
	width: 24px;
	height: 24px;
	background: url("images/search.png");
	background-size: cover;
	background-repeat: no-repeat;
	/* background-position: 50% 50%; */
}

.search_box {
	padding: 0;
	margin: 2px;
	box-sizing: border-box;
	background-color: white;
}

.basic_menu {
	padding: 0;
	margin: 2px;
	height: 230px;
	box-sizing: border-box;
	background-color: white;
	box-shadow: 0px 2px 0px 0px rgba(10, 10, 10, 0.1);
}

.tag_menu {
	padding: 0;
	margin: 2px;
	height: 150px;
	box-sizing: border-box;
	background-color: white;
	box-shadow: 0px 2px 0px 0px rgba(10, 10, 10, 0.1);
}

.category_menu {
	padding: 0;
	margin: 2px;
	height: 230px;
	box-sizing: border-box;
	background-color: white;
	box-shadow: 0px 2px 0px 0px rgba(10, 10, 10, 0.1);
}

.tag_name {
	padding-top: 2px;
	font-size: 30px;
	margin: 8px 0 8px 50px;
	font-weight: bolder;
}
.search-button {
	cursor: pointer;
	display: inline-block;
	height: 2em;
	outline: none;
	border: none;
	vertical-align: bottom;
	box-shadow: 0px 0px 0px 1px transparent inset, 0px 0em 0px 0px
		rgba(0, 0, 0, 0.1) inset;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	-webkit-transition: opacity 0.1s ease, background-color 0.1s ease, color
		0.1s ease, box-shadow 0.1s ease, background 0.1s ease;
	transition: opacity 0.1s ease, background-color 0.1s ease, color 0.1s
		ease, box-shadow 0.1s ease, background 0.1s ease;
	-webkit-tap-highlight-color: transparent;
	margin: 0 .25em 0 0;
	border-radius: 0.28571429rem;
	text-transform: none;
	text-shadow: none;
	font-weight: bold;
	line-height: 1em;
	font-style: normal;
	text-align: center;
	-webkit-text-decoration: none;
	text-decoration: none;
	color: rgba(0, 0, 0, .6);
	background-color: #e7e7e7;
	background-color: #fa6462;
	color: #fff;
	font-size: 1em;
	width: 15%;
	opacity: 1;
}
.search-name{
	padding:2px;
	font-weight: bolder;

}


</style>
<script>
function searchProject1() {
	var input = document.getElementById("typing").value;
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState == XMLHttpRequest.DONE
				&& httpRequest.status == 200) {

			document.getElementById("searching").innerHTML = httpRequest.responseText;
		}
	};
	// POST 방식의 요청은 데이터를 Http 헤더에 포함시켜 전송함.
	httpRequest.open("POST", "searchProjectNav.jsp", true);
	httpRequest.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	httpRequest.send("search=" + input); //변수에 데이터 넣으면 post방식
}




        function searchFrm(){
        	document.searchProject.submit();
        }
        
        
        
        </script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<!---->
	<div class="tour_box" style="margin: auto; width: 1000px;">
		<div class="search_box">
			<p style="margin-left: 50px; margin-bottom: 20px; padding-top: 20px;">검색</p>
			<form name="searchProject" method="post" action="searchProject.jsp" style="display:inline-block;">
				<input id="typing" name="searchWord" onkeyup="searchProject1()"
					style="margin-left: 50px; margin-right: 5px; width: 700px; height: 25px;"
					type="text" placeholder="프로젝트 검색해주세요.">
					
			</form>
			<button class="search-button"
				
				onClick="searchFrm()">검색하기</button>
				
				<div class="likename" id="searching" >
					</div>
		</div>
		<div class="basic_menu">
			<p style="margin-left: 50px; margin-bottom: 5px; padding-top: 20px;">
			</p>

			<p class="tag_name">
				<a href="allproject.jsp">모든 프로젝트</a>
			</p>
			<p class="tag_name">
				<a href="recommproject.jsp">추천 프로젝트</a>
			</p>
			<p class="tag_name">
				<a href="endproject.jsp">마감 앞둔 프로젝트</a>
			</p>
			<p class="tag_name">
				<a href="newproject.jsp">새로운 프로젝트</a>
			</p>
		</div>
		<div class="tag_menu">
			<c:set var="taglist" value="<%=taglist %>" />

			<p style="margin-left: 50px; margin-bottom: 20px; padding-top: 20px;">태그</p>
			<div style="display: flex;">
				<p style="margin-left: 50px; padding-top: 2px; font-size: 30px;">
					<button type="button"
						onclick="location.href='tagproject.jsp?tag_nm=${taglist[0]}'"
						style="border:none; font-weight: bold; color: white; background-color: rgb(58, 138, 58); width: auto; height: 50px; border-radius: 10%; font-size: 25px;">#
						${taglist[0]}</button>
				</p>
				<p style="margin-left: 10px; padding-top: 2px; font-size: 30px;">
					<button type="button"
						onclick="location.href='tagproject.jsp?tag_nm=${taglist[1]}'"
						style="border:none;font-weight: bold; color: white; background-color: rgb(209, 102, 168); width: auto; height: 50px; border-radius: 10%; font-size: 25px;">#
						${taglist[1]}</button>
				</p>
				<p style="margin-left: 10px; padding-top: 2px; font-size: 30px;">
					<button type="button"
						onclick="location.href='tagproject.jsp?tag_nm=${taglist[2]}'"
						style="border:none;font-weight: bold; color: white; background-color: rgb(157, 74, 235); width: auto; height: 50px; border-radius: 10%; font-size: 25px;">#
						${taglist[2]}</button>
				</p>
				<p style="margin-left: 10px; padding-top: 2px; font-size: 30px;">
					<button type="button"
						onclick="location.href='tagproject.jsp?tag_nm=${taglist[3]}'"
						style="border:none;font-weight: bold; color: white; background-color: rgb(42, 226, 202); width: auto; height: 50px; border-radius: 10%; font-size: 25px;">#
						${taglist[3]}</button>
				</p>
			</div>

		</div>
		<div class="category_menu">
			<p style="margin-left: 50px; margin-bottom: 20px; padding-top: 20px;">카테고리</p>

			<p class="tag_name">
				<a href="gameproject.jsp">게임</a>
			</p>
			<p class="tag_name">
				<a href="designproject.jsp">디자인</a>
			</p>
			<p class="tag_name">
				<a href="foodproject.jsp">푸드</a>
			</p>
			<p class="tag_name">
				<a href="concertproject.jsp">공연</a>
			</p>
		</div>
	</div>
</body>
</html>