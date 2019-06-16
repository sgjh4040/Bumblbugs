<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="Bean.*"%>
<%@ page import="DAO.*"%>
<%@ page import="dbConnection.*"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% 	
	String u_idx = (String)session.getAttribute("u_idx");
	String pj_idx = (String)session.getAttribute("pj_idx");
	String u_img = (String)session.getAttribute("u_img");
	System.out.println("로그인 회원 idx : " + u_idx);
	System.out.println("로그인 회원 이미지 : " + u_img);

%>

<jsp:useBean id="ProjectDAO" class="DAO.ProjectDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록 보기 페이지</title>
<!-- <link rel="stylesheet" href="board2.css">-->
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="../../css/boardList.css">

</head>
<body>
	<%
		
		//로긴한사람이라면	 userID라는 변수에 해당 아이디가 담기고 그렇지 않으면 null값
		
		

	%>
	<div id="test"></div>

	<div id="container_community">
		<%
	
		
		if(u_idx == null){ 
		
		%>
		<div class="upload_msg">
				<!-- 글쓰기 페이지로 이동 -->
				<div class="content_container">
					<span class="profile_img"></span> 창작자에게 응원 한마디!
				</div>

			</div>
		
		<%
		}else if(u_idx != null){
			System.out.println("boardList.jsp에 fundProjectCheck의 pj_idx 값은 " + pj_idx);
			Boolean flag = ProjectDAO.fundPjCheck(pj_idx, u_idx);
			System.out.println("boardList.jsp에 fundProjectCheck의 flag 값은 " + flag);
			if(flag == false){
				%>
				<div class="upload_msg">
				<!-- 글쓰기 페이지로 이동 -->
				<div class="content_container">
					<span class="profile_img"></span> 창작자에게 응원 한마디!
				</div>

			</div>
			<%
			}else{
			%>
			
			<a href="../fundProject/ProjectPageBWrite.jsp">
			<div class="upload_msg">
				<!-- 글쓰기 페이지로 이동 -->
				<div class="content_container">
					<span class="profile_img"></span> 창작자에게 응원 한마디!
				</div>

			</div>
		</a>

		<%
		}
		}
		%>

		<div class="community_button">
			<div class="board_button_container">
				<div class="board_button">모든 게시글</div>
			</div>
		</div>
		<%
        	CommentDAO commentDAO = new CommentDAO();
        	
        	BoardDAO boardDAO = new BoardDAO();
        	int b_pj_idx = Integer.parseInt(pj_idx);
        	ArrayList<BoardBeans> list = boardDAO.getList(b_pj_idx);
        	//System.out.println(list);
        	for(int i = 0; i< list.size(); i++){
        		String b_nm = boardDAO.getName(Integer.toString(list.get(i).getB_u_idx()));
        		String b_u_idx = Integer.toString(list.get(i).getB_u_idx());
        		System.out.println("게시판을 작성한 회원의 번호 : " + b_u_idx);
        		int b_idx = list.get(i).getB_idx();
        		int c_cnt = commentDAO.getCommentCnt(Integer.toString(b_idx));
        		String b_dt = list.get(i).getB_time().substring(0, 11);
        		String b_content = list.get(i).getB_content();
        		String b_u_img = boardDAO.getImg(b_u_idx);
        		System.out.println("게시판에 글 쓴 사람의 프로필 이미지이미지 : " + b_u_img + "\n");
        		if(b_u_idx.equals(u_idx)){
        			// 자기가 쓴 게시글이 있는경우
        %>
		<!-- 후원한 회원 게시 카드 -->
		<div class="card_board">
			<div class="card_info">
				<!--<div class="maker_alert_box">창작자 업데이트</div>-->
				<div class="card_wirter_profile">
				<% if(b_u_img != null){ %>
					<img class="cd_profile_img" src="../Bumblbugimg/<%=b_u_img%>">
				<% }else{
					%>
					<img class="cd_profile_img" src="../Bumblbugimg/smile.png">
				<%
				}
				%>
					<div class="bd_info">
						<div class="bd_name">
							<div class="bd_name_content"><%=b_nm %></div>
						</div>
						<span class="bd_reg_dt"><%=b_dt %></span>
					</div>
					<!-- 글수정 페이지로 이동 -->
					<a href="../fundProject/ProjectPageBEdit.jsp?b_idx=<%= b_idx %>">
						<img class="aaaa" style="width: 30px; height: 30px;"
						src="../fundProject/board/images/gearIcon.png">
					</a>
				</div>
			</div>

			<!-- view 페이지 -->
			<a href="../fundProject/ProjectPageBView.jsp?b_idx=<%=b_idx%>">
				<div class="card_content_st">
					<div class="card_content">
						<%= b_content%>
					</div>

				</div>
			</a> 
			<a href="../fundProject/ProjectPageBView.jsp?b_idx=<%=b_idx%>">
				<div class="card_comment_no">
					<i class="comment_icon"><img style="width: 16px; height: 16px;"
						src="../fundProject/board/images/kakao.png"></i>
					<%=c_cnt %>
				</div>
			</a>
		</div>

		<%
        		}else{
 						//자신이 쓴 게시글이 없는경우
        		 %>

		<!-- 후원한 회원 게시 카드 -->
		<div class="card_board">
			<div class="card_info">
				<!--<div class="maker_alert_box">창작자 업데이트</div>-->
				<div class="card_wirter_profile">
					<div class="card_wirter_profile">
				<% if(b_u_img != null){ %>
					<img class="cd_profile_img" src="../Bumblbugimg/<%=b_u_img%>">
				<% }else{
					%>
					<img class="cd_profile_img" src="../Bumblbugimg/smile.png">
				<%
				}
				%>
					<div class="bd_info">
						<div class="bd_name">
							<div class="bd_name_content"><%=b_nm %></div>
						</div>
						<span class="bd_reg_dt"><%=b_dt %></span>
					</div>
				</div>
			</div>
			</div>
			<a href="../fundProject/ProjectPageBView.jsp?b_idx=<%=b_idx%>">
				<div class="card_content_st">
					<div class="card_content">
						<%= b_content %>
					</div>

				</div>
			</a> 
			<a href="../fundProject/ProjectPageBView.jsp?b_idx=<%=b_idx%>">
				<div class="card_comment_no">
					<i class="comment_icon"><img style="width: 16px; height: 16px;"
						src="board/images/kakao.png"></i>
					<%=c_cnt %>
				</div>
			</a>
		</div>

		<%
        	}
       	}
%>


	</div>

</body>
</html>