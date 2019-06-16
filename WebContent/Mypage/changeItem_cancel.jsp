
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Bean.*"%>
<jsp:useBean id="MypageDAO" class="DAO.MypageDAO" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String p_idx = request.getParameter("p_idx");
    String pay_idx = request.getParameter("pay_idx");
    String u_idx = (String) session.getAttribute("u_idx");
    String pj_idx = (String) session.getAttribute("pj_idx");
    String f_idx = request.getParameter("f_idx");

    
    PresentBean presentbean = MypageDAO.getPresent(p_idx);
    String fundprice = MypageDAO.getFundprice(u_idx, pj_idx);
    String pjImg = MypageDAO.getProjectImg(pj_idx);
    
    
    
    
    
    %>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title></title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="../css/Main.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" type="text/css" href="../css/changeItem_cancel.css">
<script type="text/javascript">
    function check()
    {
        msg = "정말로 삭제할건가요??";
        if (confirm(msg)!=0) {
             // Yes click
        	document.getElementById("delFrm").submit();
             
        } else {
            // no click
        	
            
}
    }; // myconfirm
    
    
    
    </script>




<style>

</style>
<script>


        $(function () {

        });


    </script>
</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	

	<div class="scanline">
		<div class="b-align"
			style="background-image:linear-gradient(to right, #24243e , #302b63)">
			<h1>변경하기</h1>
			<p class="dek">언제 어디서든 신선한 필름, '전국 필름 자판기 설치' 프로젝트</p>
			<ul>
				<li><a href="Mypage_payment.jsp" class="b-menu-item"><b>지불수단
						변경</b></a></li>
				<li>
					<form name="delFrm" method="post" action="delete.jsp">
						<a href="#" class="b-menu-item"><b>취소하기</b></a>
					</form>
				</li>
			</ul>

		</div>
	</div>
	<div class="b-container-wrap">
		<div class="b-container">

			<div class="cancel-box">
				<div class="cancel-box-head">취소되는 항목</div>
				<div class="cancel-box-mid">
					<div class="cancel-box-img">
						<img style="width: 200px; height: 150px;"
							src="../Bumblbugimg/<%=pjImg%>">
					</div>
					<div class="cancel-box-content">
						<strong>예약된 금액</strong> <span class="cancel-box-price"><%=fundprice%> 원</span>
						<br>
						<div style="padding-top: 20px;">
							<strong>선택한 선물: </strong><%=presentbean.getP_nm() %>
						</div>
						
						
					</div>

				</div>
			</div>
			<div class="cancel-box-footer">

				<form id="delFrm" name="delFrm" method="post"
					action="changeItem_cancelproc.jsp">
					<input class="cancel-button" type="button" value="취소하기"
						onClick="check()"> <input class="cancel-button"
						type="button" value="다시생각"
						onClick="javascript:location.href= 'Mypage_fund.jsp'"> 
						<input type="hidden" name="p_idx" value="<%=p_idx %>">
						<input type="hidden" name="f_idx" value="<%=f_idx %>">
						<input type="hidden" name="pay_idx" value="<%=pay_idx %>">
				</form>

			</div>


		</div>


	</div>




</body>

</html>
</html>