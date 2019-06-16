<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<head>
<meta charset="UTF-8">
<title>회원 정보 수정창</title>
<style>
  .cls1 {
     font-size:40px;
     text-align:center;
   }
</style>
</head>
<body>
 <h1 class="cls1">회원 정보 수정창</h1>
<form  method="post" action="${contextPath}/member/modMember.do?u_idx=${memInfo.u_idx}">
 <table align="center" >
   <tr>
     <td width="200"><p align="right" >이름</td>
     <td width="800"><input   type="text" name="u_nm" value="${memInfo.u_nm}"></td>
     
   </tr>
 <tr>
     <td width="200"><p align="right" >이메일</td>
     <td width="800"><input   type="text" name="u_email" value="${memInfo.u_email}" >
     </td>
   </tr>
   <tr>
     <td width="200"><p align="right" >비밀번호</td>
     <td width="800"><input   type="password" name="u_pwd" value="${memInfo.u_pwd}" ></td>
   </tr>
   <tr>
     <td width="200"><p align="right" >활동지역</td>
     <td width="800"><input   type="text" name="u_loc"  value="${memInfo.u_loc}" ></td>
   </tr>
   <tr>
     <td width="200"><p align="right" >소개</td>
     <td width="800"><input   type="text"  name="u_intro" value="${memInfo.u_intro}" disabled  ></td>
   </tr>
   <tr align="center" >
    <td colspan="2" width="400"><input type="submit" value="수정하기" >
       <input type="reset" value="다시입력" > </td>
   </tr>
 </table>
</form>
</html>
