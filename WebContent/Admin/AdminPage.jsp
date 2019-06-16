<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Bean.TempProjectBean"%>
<%@ page import="DAO.AdTempDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!-- request/session -->
<%
   request.setCharacterEncoding("UTF-8");
   String u_idx = (String)session.getAttribute("u_idx");
%>
<!-- DAO -->
<%
   AdTempDAO ato = new AdTempDAO();
   ArrayList<TempProjectBean> list = new ArrayList<TempProjectBean>();
   list = ato.getList("승인대기중");
   System.out.println(list); 
   
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>관리자 페이지 메인</title>

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

table {
   border-top: 1px solid #444444;
   border-collapse: collapse;
   margin: 0 auto;
   margin-top: 40px;
}

th, td {
   border-bottom: 1px solid #444444;
   padding: 10px;
   text-align: center;
}

thead tr {
   background-color: #0d47a1;
   color: #ffffff;
}

tbody tr:nth-child(2n) {
   background-color: #bbdefb;
}

tbody tr:nth-child(2n+1) {
   background-color: #e3f2fd;
}

a, a:link, a:visited, a:hover {
   text-decoration: none;
   color: black;
}

.logoutButton {
   cursor: pointer;
   display: inline-block;
   min-height: 1em;
   outline: none;
   border: none;
   vertical-align: baseline;
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
   margin: .75em .25em 0 0;
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
   padding: 1em 1.5em;
   font-size: 1em;
   width: 50%;
   opacity: 1;
}

.logoutButton:hover, .logoutButton:focus, .logoutButton:active {
   background-color: #d9d9d9;
   color: rgba(0, 0, 0, 8);
}

.logoutButton:hover, .logoutButton:focus, .logoutButton:active {
   background-color: #ff4543;
   color: #fff;
}
</style>
</head>

<body>
   <div class="header-wrap">
      <div class="header">
         <div class="hpName-wrap">프로젝트 관리자 페이지</div>
      </div>
   </div>
   <table>
      <thead>
         <tr width="850" align="center">
            <td width="150">프로젝트 임시번호</td>
            <td width="400">프로젝트 이름</td>
            <td width="100">리더 이름</td>
            <td width="100">마감날짜</td>
            <td width="100">상태</td>
         </tr>
      </thead>

      <tbody>
         <%
           for(int i = 0; i < list.size(); i++ ){
              String tp_idx = Integer.toString(list.get(i).getTp_idx());
              String tp_nm = list.get(i).getTp_title();
              String tp_leader_nm = list.get(i).getTp_leader_nm();
              String tp_end_dt = list.get(i).getTp_end_dt();
              String tp_st = list.get(i).getTp_st();
        %>
         <tr>
            <td><%=tp_idx %></td>
            <td><a href="AdminTpView.jsp?tp_idx=<%=tp_idx%>"><%=tp_nm %></a></td>
            <td><%=tp_leader_nm %></td>
            <td><%=tp_end_dt %></td>
            <td><%=tp_st %></td>
         </tr>
         <%
           }
        %>

      </tbody>
   </table>


   <div style="margin: 0 auto; width: 1060px; text-align: center;">
      <a href="../Mypage/logout.jsp">
         <button class="logoutButton">로그아웃</button>
      </a>
   </div>
   
</body>

</html>