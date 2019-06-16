<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.header-wrap {
   padding: 0;
   margin: 0;
   box-sizing: border-box;
   background-color: #ffffff;
   box-shadow: 0px 1px 2px 0px rgba(10, 10, 10, 0.1);
   background-image: linear-gradient(to right, #0d47a1, #265396);
}

.header {
   margin: 0 auto;
   width: 80%;
   height: 100px;
   position: relative;
}
.hpName-wrap {
   display: flex;
   position: absolute;
   left: 0;
   right: 0;
   top: 0;
   bottom: 0;
   align-items: center;
   justify-content: center;
   font-weight: bolder;
   font-size: 30px;
   color: white;
}


</style>
</head>
<body>
<div class="header-wrap">
      <div class="header">
         <div class="hpName-wrap">관리자 페이지</div>
      </div>
   </div>
<ol type="I" style="padding: 50px;">
	<a href="listMembers.jsp"><li>회원관리</li></a>
	<a href="AdminPage.jsp"><li>프로젝트승인</li></a>
</ol>

</body>
</html>