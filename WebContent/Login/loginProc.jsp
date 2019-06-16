<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="mDAO" class="DAO.MemberDAO" />
    
    <% 
    	request.setCharacterEncoding("UTF-8");
    //getContextPath()
    	
    	String u_email = request.getParameter("u_email");
    	String u_pwd = request.getParameter("u_pwd");
    	String msg = "로그인에 실패 하였습니다.";
    	String tf = request.getParameter("tf");
    	
    	
    	if(u_email.equals("admin")&u_pwd.equals("1111")){
    		%>
    		<script>
    		
    		alert("관리자 페이지로 이동합니다.");
    		location.href="../adminView.jsp";
    		
    		
    		</script>
    		
    		<% 
    	}
    	
    	boolean result = mDAO.loginMember(u_email, u_pwd);
    	if(result & tf.equals("1")){
    		session.setAttribute("u_email", u_email);
    		String u_idx = mDAO.getUserIdx(u_email);
    		session.setAttribute("u_idx", u_idx);
    		String u_nm = mDAO.getUserNM(u_email);
    		session.setAttribute("u_nm", u_nm);
    		String u_img = mDAO.getUserImg(u_idx);
    		session.setAttribute("u_img", u_img);
    		msg = "로그인에 성공하였습니다.";
    %>
    <script>
	alert("<%=msg%>");
	location.href="../fundProject/RewardsPage.jsp";
	</script>
	<%
    	}else if(result & tf.equals("2")){
    		session.setAttribute("u_email", u_email);
    		String u_idx = mDAO.getUserIdx(u_email);
    		session.setAttribute("u_idx", u_idx);
    		String u_nm = mDAO.getUserNM(u_email);
    		session.setAttribute("u_nm", u_nm);
    		String u_img = mDAO.getUserImg(u_idx);
    		session.setAttribute("u_img", u_img);
    		msg = "로그인에 성공하였습니다.";
	%>
	<script>
	alert("<%=msg%>");
	location.href="../InsertProject/InsertProjectMain.jsp";
	</script>
	<%
    	}else if(result){
    		session.setAttribute("u_email", u_email);
    		String u_idx = mDAO.getUserIdx(u_email);
    		session.setAttribute("u_idx", u_idx);
    		String u_nm = mDAO.getUserNM(u_email);
    		session.setAttribute("u_nm", u_nm);
    		String u_img = mDAO.getUserImg(u_idx);
    		session.setAttribute("u_img", u_img);
    		msg = "로그인에 성공하였습니다.";
	%>
	<script>
	alert("<%=msg%>");
	location.href="../mainpage.jsp";
	</script>
	<%}else{ %>
	
	<script>
	alert("<%=msg%>");
	history.back();
	</script>
	<%}; %>
