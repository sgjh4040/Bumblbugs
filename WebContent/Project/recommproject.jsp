<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, Bean.*" %>
<jsp:useBean id="MainDAO" class="DAO.MainDAO" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 	request.setCharacterEncoding("UTF-8");

String u_idx = (String) session.getAttribute("u_idx");
String u_img = (String) session.getAttribute("u_img");
String u_nm = (String) session.getAttribute("u_nm");
		
		ArrayList<ProjectBean> recommlist = MainDAO.getRecommProject();

%>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatiblee" content="IE=edge,chrome=1" /> 
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <link href="../css/Main.css" rel="stylesheet" type="text/css" media="all">
    <script type="text/javascript" src="<c:url value="js/jquery-1.8.0.min.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="../js/Main.js"></script>
      
      
<title>추천 프로젝트</title>


</head>
<body>
 	<jsp:include page="../header.jsp"></jsp:include>

<!--//////////////////////////////////////////////////////////////////////////////////-->
    <div class="container">

        <div class="all_project" >
            <div class="all">
                <div class="box" >
                    	추천 프로젝트
                </div>

            </div>    
        </div>
  
	   	<div class="recommend_project">
            	 <div class="recommend_header">
                		추천 프로젝트           
            	 </div>
	            
	             <div class="project_card_section">
	            	<c:set var="recommlist" value="<%=recommlist %>"/>
					<c:forEach var ="pjBean" items="${recommlist}">
					<c:set var="now" value="<%=new java.util.Date()%>" />
					<fmt:parseNumber value="${now.time / (1000*60*60*24)}" integerOnly="true" var="nowdayfull" scope="request" />
					<fmt:parseDate 		var="deadline" 		value="${pjBean.pj_end_dt}" pattern="yyyy-MM-dd" />
				<fmt:parseNumber 	var="deadlinefull" 	value="${deadline.time/ (1000*60*60*24)}" integerOnly="true"  scope="request" />                        

                <div class="project_card" onclick="location.href='../fundProject/ProjectPage.jsp?pj_idx=${pjBean.pj_idx}'">
	                   
	                    <div class="card_content">
	                        <div class="imgbox">
	                            <img src="../Bumblbugimg/${pjBean.pj_img}" style="width: 210px; height: 150px;" alt="">
	                        </div>
	                        
	                        <div class="textbox">
	                        	<h4>${pjBean.pj_title}</h4>
	                        	<h6>${pjBean.leader_nm}</h6>
	                        </div>
	                        <div class="analyzebox">
	                        	<progress class="progress" value="${pjBean.pj_f_price/pjBean.obj_price*100}" max="100">"</progress>                      
		                        <div class="nowbox">
		                            <div style="color:red; width: 15px; margin-right: 7px;   float: left;">${deadlinefull - nowdayfull}</div>일 남음                      
		                            <div style="float: right;"> <fmt:formatNumber value='${pjBean.pj_f_price/pjBean.obj_price*100}' pattern='#'/>%</div>                       
		                        </div>
                        	</div>
                    </div>
                	</div>
                	</c:forEach>
	              </div>
	    </div>  
         
    </div> <!-- end of container -->
    
<!--//////////////////////////////////////////////////////////////////////////////////-->
    <div class="footer">
        <div class="footerSet">
            <div class="foot_1">              
                <a  class="notice" href="C:\Users\user\Desktop\Project\footer\noticePage.html">공지사항</a><br>
                <a  class="hire" href="C:\Users\user\Desktop\Project\footer\noticePage.html">채용</a><br>
                <a  class="createGuide" href="C:\Users\user\Desktop\Project\footer\noticePage.html">창작자가이드</a><br>
                <a  class="settlement" href="C:\Users\user\Desktop\Project\footer\noticePage.html">결산</a> 
            </div><!--첫번째 텍스트박스-->
            <div class="foot_2">
                <a  class="termsOfService" href="C:\Users\user\Desktop\Project\footer\noticePage.html">이용약관</a><br>
                <a  class="privacyPolicy" href="C:\Users\user\Desktop\Project\footer\noticePage.html">개인정보 처리방침</a><br>
                <a  class="feePolicy" href="C:\Users\user\Desktop\Project\footer\noticePage.html">수수료 정책</a><br>
                <a  class="helpCenter" href="C:\Users\user\Desktop\Project\footer\noticePage.html">헬프 센터</a><br>
            </div><!--두번째 텍스트박스-->
            <div class="foot_3">
                <ul>
                    <li>    
                            <a href="#" onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img src="./icon/sns_ka.png" 
                            width="30"></a>
                    </li>
                    <li>
                            <a href="#" onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img src="./icon/sns_face.png" 
                            width="30"></a>
                    </li>
                    <li>
                            <a href="#" onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img src="./icon/sns_tw.png" 
                            width="30"></a>
                    </li>
                    <li>
                            <a href="#" onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img src="./icon/sns_insta.png" 
                            width="30"></a>
                    </li>
                    <li>
                            <a href="#" onclick="javascript:window.open
                            ('https://www.kakaocorp.com/service/KakaoTalk')"><img src="./icon/sns_naver.png" 
                            width="30"></a>
                    </li>

                </ul>
               

            </div><!--sns /문의하기 박스-->
        </div>
        <div class="foot_4">
                <span id="notice_1">000은 텀블벅은 플랫폼 제공자로서 프로젝트의 당사자가 아니며, 
                        직접적인 통신판매를 진행하지 않습니다. 프로젝트의 완수 및 선물제공의 책임은 
                        해당 프로젝트의 창작자에게 있으며, 
                        프로젝트와 관련하여 후원자와 발생하는 법적 분쟁에 대한 책임은 해당 창작자가 부담합니다.
                </span>
        </div><!--세번째텍스트박스-->
        <div class="foot_5">
                <span id="notice_2">
                        텀블벅(주) | 대표 염재승 105-87-52823 | 서울시 강남구 강남대로 364, 12층 1201호 (역삼동) | 통신판매업 2019-서울강남-00797 | 대표전화 02-6080-0760
                </span>
        </div><!--네번째 텍스트박스-->
   </div>    

</body>
</html>