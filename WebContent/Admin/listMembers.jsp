<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*, controller.*, DAO.*, Bean.*"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<% 
	request.setCharacterEncoding("UTF-8");
MemberDAO memberDAO1 = new MemberDAO();
ArrayList<UserBean> membersList1 = memberDAO1.listMember();
	
%>



<%
int totalRecord = 0; //전체 레코드 수
int numPerPage = 5; //페이지 당 레코드수
int pagePerBlock = 10; //블럭당 페이지 수 

int totalPage=0 ; //전체 페이지 수 
int totalBlock=0; //전체 블럭수

int nowPage = 1; //현재 페이지
int nowBlock = 1; //현재블럭

int start=0; //DB의 select 쿼리문 시작번호
int end=5; //시작번호로부터 가져올 게시물의 수



%>


<%

if(request.getParameter("nowPage")!=null){
	nowPage = Integer.parseInt(request.getParameter("nowPage"));
}
start = (nowPage-1)*(numPerPage);		//select문 찾을때 첫 시작점 설정
System.out.println(start);
end = numPerPage;

totalRecord = membersList1.size();		//일단 임의로 500으로 지정
totalPage = (int)Math.ceil((double)totalRecord/numPerPage);	//전체페이지수
nowBlock = (int)Math.ceil((double)nowPage/pagePerBlock);		//전체블럭계산
totalBlock = (int)Math.ceil((double)totalPage/pagePerBlock);

MemberDAO memberDAO = new MemberDAO();
ArrayList<UserBean> membersList = memberDAO.listMember(start,end);
%>
<c:set var="membersList" value="<%=membersList%>"/>
<script type="text/javascript">

//새로고침 하기 위한 메소드
 function list(){
	 document.listFrm.action = "listMembers.jsp";
	 document.listFrm.submit();
 }
 
 //페이지 선택했을때 리스트를 바꿔주기위한 메소드
 function paging(page){
	 document.readFrm.nowPage.value = page;
	 document.readFrm.submit();
	 
 }
 //한 블럭이 넘아갈떄 쓰는 메소드
 function block(value){
	 document.readFrm.nowPage.value = <%=pagePerBlock%>*(value-1)+1;
	 document.readFrm.submit();
 }
</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<style>
a:link {text-decoration: none; color:#646464;}
a:visited {text-decoration: none; color:#646464;}
a:active {text-decoration: none; color:#646464;}
a:hover {text-decoration: none; color:red;}




</style>



</head>
<body>
<p class="cls1"></p>
<table align="center" border="1">
	<tr align="center" bgcolor="lightgreen">
		<td width="7%"><b>이름</b></td>
		<td width="7%"><b>이메일</b></td>
		<td width="7%"><b>비밀번호</b></td>
		<td width="7%"><b>활동지역</b></td>
		<td width="7%"><b>소개</b></td>
		<td width="7%" ><b>수정</b></td>
		<td width="7%" ><b>삭제</b></td>
	</tr>
	<c:choose>
		<c:when test="${membersList==null}">
			<tr>
				<td colspan=5>
					<b>등록된 회원이 없습니다.</b>
				</td>
			</tr>
		</c:when>
		<c:when test="${membersList != null}">
		<c:forEach var ="mem" items="${membersList}">
			<tr align="center">
				<td>${mem.u_nm}</td>
				<td>${mem.u_email}</td>
				<td>${mem.u_pwd}</td>
				<td>${mem.u_loc}</td>
				<td>${mem.u_intro}</td>
				<td><a href="${contextPath}/member/modMemberForm.do?u_idx=${mem.u_idx}">수정</a></td>
				<td><a href="${contextPath}/member/delMember.do?u_idx=${mem.u_idx}">삭제</a></td>
			
			</tr>
		</c:forEach>
		
		</c:when>
	
	</c:choose>
</table>
<div style="text-align: center;">
<% 
		int pageStart = (nowBlock -1)*pagePerBlock + 1 ; //하단 페이지 시작번호
	  	int pageEnd = ((pageStart + pagePerBlock ) <= totalPage) ?  (pageStart + pagePerBlock): totalPage+1; 
	  	//하단 페이지 끝번호
	  if(totalPage !=0){
		if (nowBlock > 1) {%>


	<a href="javascript:block('<%=nowBlock-1%>')">prev...</a>

	<%}%>&nbsp;

	<%for ( ; pageStart < pageEnd; pageStart++){%>

	<a href="javascript:paging('<%=pageStart %>')"> 
		 [<%=pageStart %>]
	
	</a>
	<%}//for%>&nbsp;
	<%if (totalBlock > nowBlock ) {%>
	<a href="javascript:block('<%=nowBlock+1%>')">.....next</a>
	<%}%>&nbsp;
	<%}%>
	
	</div>
	
	<a href="adminView.jsp">뒤로</a>

	<!-- 넘겨줄  -->
	<form name="listFrm" method="post">
		<input type="hidden" name="reload" value="true"> <input
			type="hidden" name="nowPage" value="1">

	</form>


	<form name="readFrm" method="get">
		<input type="hidden" name="num">
		<input type="hidden" name="nowPage" value="<%=nowPage%>">  
			
	</form>


</body>
</html>