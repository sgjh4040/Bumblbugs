<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String p_idx = request.getParameter("p_idx");
    String pay_idx = request.getParameter("pay_idx");
    String f_idx = request.getParameter("f_idx");
    
    
    %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>jQuery Style</title>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <link href="../css/Main.css" rel="stylesheet" type="text/css" media="all">
    <link rel="stylesheet" type="text/css" href="../css/MypagePresentbox.css">
   
   
    
    
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            color: #676363;
            font-family: 'Nanum Gothic', sans-serif;

        }
        ul{
            color: #676363;
            font-size: 15px;
            list-style: none;

        }
        li{
            display: inline-block;
        }

        body{
            overflow-x: hidden;
            min-height: 100%;
            height: auto;
        }
        .header{
            width: 100%;
            background-color: #fff;
            border-bottom: 1px solid #efefef;
            text-align: center;
            
        }
        .header-title{
            
            font-size: 22px;
            padding: 20px;
            text-decoration: none;
           
        }
        .scanline{
            width: 100%;
            
            position: relative;
            background: #fafafa
        }
        .b-align{
            text-align: center;
            padding: 50px;
            background-repeat: no-repeat;
            background-position: 50%;
            background-size: cover;
            
        }
        .b-menu-item{
            padding: 10px;
            text-decoration: none;
            
        }
        
        .dek{
            margin-top: 20px;
            margin-bottom: 20px;
        }
        .b-container-wrap{
            padding-top: 20px;
            position: relative;
        }
        .b-container{
            width: 700px;
            margin: 0 auto;
        }
        
        
    </style>
   
</head>

<body>
    <jsp:include page="../header.jsp"></jsp:include>

    <div class="scanline">
        <div class="b-align" style="background-image:linear-gradient(to right, #24243e , #302b63)">
            <h1>변경하기</h1>
            <p class="dek">
                    언제 어디서든 신선한 필름, '전국 필름 자판기 설치' 프로젝트
            </p>
            <ul>
                <li>
                    <a href="changeItem.jsp" class="b-menu-item"> <b>선물/금액변경</b></a>
                </li>
                <li>
                    <a href="Mypage_payment.jsp" class="b-menu-item"><b>지불수단 변경</b></a>
                </li>
                <li>
                
                    <a href="changeItem_cancel.jsp?p_idx=<%=p_idx %>&pay_idx=<%=pay_idx %>&f_idx=<%=f_idx%>" class="b-menu-item"><b>취소하기</b></a>
               
                </li>
            </ul>

        </div>
    </div>
    <div class="b-container-wrap">
        <div class="b-container">
            
	<!-- ------------------------------------------------------------ -->
            <jsp:include page="MypagePresentbox.jsp"></jsp:include>
    <!-- ------------------------------------------------------------ -->        
        </div>

    </div>

    


</body>

</html>
