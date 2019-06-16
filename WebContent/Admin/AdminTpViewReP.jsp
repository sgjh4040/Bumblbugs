<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "DAO.AdTempDAO" %>
<%@ page import = "Bean.TempProjectBean" %>
<%@ page import = "Bean.TempPresentBean" %>    
<!-- request -->
<%
	request.setCharacterEncoding("UTF-8");
	String tp_idx = (String)request.getParameter("tp_idx");
%>    
<%
	AdTempDAO ato = new AdTempDAO();
	int flag = ato.returnTp(tp_idx);
	out.println(flag);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		alert('거절 되었습니다.');
		location.href="./AdminPage.jsp";
	</script>
</body>
</html>