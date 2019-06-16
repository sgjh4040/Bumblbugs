<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="Bean.*"%>
<%@ page import="DAO.*"%>
<%@ page import="dbConnection.*"%>

<jsp:useBean id="ProjectDAO" class="DAO.ProjectDAO" />
<jsp:useBean id="ProjectBean" class="Bean.ProjectBean" />
<jsp:useBean id="PresentBean" class="Bean.PresentBean" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("UTF-8");
	String pj_idx = (String) session.getAttribute("pj_idx");
	String u_idx = (String) session.getAttribute("u_idx");
	String b_idx = request.getParameter("b_idx");

	ProjectBean pjbean = ProjectDAO.getProject(pj_idx); // bean set

	ArrayList<PresentBean> prlist = ProjectDAO.getPresentList(pj_idx);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><%=pjbean.getPj_title()%></title>
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/boardView.css">
<link rel="stylesheet" type="text/css" href="../css/ProjectPage.css">
<link href="../css/Main.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	function tabSetting() {
		// 탭 컨텐츠 hide 후 현재 탭메뉴 페이지만 show
		$('.tapPage').hide();
		$($('.current').find('a').attr('href')).show();

		// Tab 메뉴 클릭 이벤트 생성
		$('li').click(
				function(event) {
					var tagName = event.target.tagName; // 현재 선택된 태그네임
					var selectedLiTag = (tagName.toString() == 'A') ? $(
							event.target).parent('li') : $(event.target); // A태그일 경우 상위 Li태그 선택, Li태그일 경우 그대로 태그 객체
					var currentLiTag = $('li[class~=current]'); // 현재 current 클래그를 가진 탭
					var isCurrent = false;

					// 현재 클릭된 탭이 current를 가졌는지 확인
					isCurrent = $(selectedLiTag).hasClass('current');

					// current를 가지지 않았을 경우만 실행
					if (!isCurrent) {
						$($(currentLiTag).find('a').attr('href')).hide();
						$(currentLiTag).removeClass('current');

						$(selectedLiTag).addClass('current');
						$($(selectedLiTag).find('a').attr('href')).show();
					}

					return false;
				});
	}

	$(function() {
		// 탭 초기화 및 설정
		

		tabSetting();
	});
</script>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="wrap">
		<div class="header"></div>
		<div class="pro-container">
			<div class="ProjectIntro">
				<!-- 프로젝트 소개(상단) -->
				<div class="Container">
					<div class="ProjectIntro_Wrapper">
						<div class="ProjectIntro_Outline">
							<!-- 프로젝트 name -->
							<div class="ProjectIntro_OutlineInner">
								<span class="ProjectIntro_ProjectCategory"> <%=pjbean.getPj_category()%>
								</span>
								<h1 class="ProjectIntro_Title">
									<%=pjbean.getPj_title()%>
								</h1>
								<div class="ProjectIntro_Creator">
									<span class="ProjectIntro_Profileimg"></span> <span
										class="ProjectIntro_CreatorName"> <%=pjbean.getLeader_nm()%>
									</span>
								</div>
							</div>
						</div>

						<div class="ProjectIntro_Main">
							<!-- 프로젝트 메인 img -->
							<figure class="ProjectIntro_MainCoverImgFigure">
								<img class="ProjectIntro_MainCoverImg"
									src="../Bumblbugimg/<%=pjbean.getPj_img()%>"
									alt="프로젝트 커버 img">
							</figure>
						</div>

						<aside class="ProjectIntro_Sub">
							<!-- 프로젝트 후원 현황 -->
							<div class="ProjectIntro_FundingStatus">
								<div class="ProjectIntro_Matric">
									<div class="ProjectIntro_StatusTitle">모인금액</div>
									<div class="ProjectIntro_StatusValue">
										<%
											int s_price = Integer.parseInt(pjbean.getPj_f_price());
											String str = String.format("%,d", s_price);
										%>
										<%=str%>
										<span class="ProjectIntro_Small"> 원 </span> <span
											class="ProjectIntro_FundingRate"> <%
 	String cprice = pjbean.getPj_f_price(); // 현재까지 모인 금액
 	String gprice = pjbean.getObj_price(); // 목표 금액

 	String goalAmount = ProjectDAO.goalAmount(cprice, gprice);
 %> <%=goalAmount + '%'%>
										</span>
									</div>
								</div>
								<div class="ProjectIntro_Matric">
									<div class="ProjectIntro_StatusTitle">남은시간</div>
									<div class="ProjectIntro_StatusValue">
										<c:set var="now" value="<%=new java.util.Date()%>" />
										<fmt:parseNumber value="${now.time / (1000*60*60*24)}"
											integerOnly="true" var="nowdayfull" scope="request" />
										<fmt:formatDate value="${now}" var="nowdate"
											pattern="yyyy-MM-dd" />

										<fmt:parseDate var="deadline"
											value="<%=pjbean.getPj_end_dt()%>" pattern="yyyy-MM-dd" />

										<fmt:parseNumber value="${deadline.time / (1000*60*60*24)}"
											integerOnly="true" var="deadlinefull" scope="request" />
										${deadlinefull - nowdayfull} <span class="ProjectIntro_Small">
											일 </span>
									</div>
								</div>
								<div class="ProjectIntro_Matric">
									<div class="ProjectIntro_StatusTitle">후원자</div>
									<div class="ProjectIntro_StatusValue">
										<%=pjbean.getPj_sup_num()%>
										<span class="ProjectIntro_Small"> 명 </span>
									</div>
								</div>
							</div>
							<div class="ProjectIntro_FundingInfo">
								<div class="ProjectIntro_InfoInner">
									<div>펀딩 진행중</div>
									<span> 목표 금액인 <%
										int g_price = Integer.parseInt(pjbean.getObj_price());
										String g_str = String.format("%,d", g_price);
									%> <%=g_str%>원이 모여야만 결제됩니다.<br>
										결제는 <%=pjbean.getPj_end_dt()%> 에 다함께 진행됩니다.
									</span>
								</div>
							</div>
							<div class="ProjectIntro_ProjectBtn">
								<div class="ProjectIntro_BtnInner">
									<div class="ProjectIntro_PrimaryBtn">
										<%
											Boolean flag = ProjectDAO.fundPjCheck(pj_idx, u_idx);
										%>
										<c:set var="flag" value="<%=flag%>" />

										<c:choose>
											<c:when test="${flag eq true}">
												<button type="button" class="Btn_not" disabled>
													<b>이미 후원한 프로젝트입니다</b>
												</button>
											</c:when>
											<c:otherwise>
												<button type="button" class="Btn"
													onclick="location.href='RewardsPage.jsp'">프로젝트
													밀어주기</button>
											</c:otherwise>
										</c:choose>
									</div>

								</div>
							</div>
						</aside>
					</div>
				</div>
			</div>
			<div class="ContentsNav">
				<!-- 프로젝트 상세 페이지 네비 -->
				<span style="font-size: 0px;"></span>
				<nav class="ContentsNav_Nav">
					<div class="ContentsNav_NavInner">
						<ul class="ContentsNav_NavLeft">
							<li class="tabMenu"><a class="ContentsNav_NavItem"
								href="#tabContent01"> 스토리 </a></li>
							<li class="tabMenu current"><a class="ContentsNav_NavItem"
								href="#tabContent02"> 커뮤니티 </a></li>
						</ul>
					</div>
				</nav>
			</div>
			<div class="ProjectPage">
				<!-- 프로젝트 상세 설명 + 상품 선택 -->
				<div class="Container">
					<div class="ProjectPage_ProjectContents">
						<div class="ProjectPage_ContentsMain">
							<div class="ProjectPage_MaineInner">
								<div id="tabContent01" class="tapPage"> 
									<div class="Card">
										<div class="StoryCard">
											<div class="StoryContent">
												<c:set var="video" value="<%=pjbean.getPj_intro_video()%>" />
												<c:choose>
													<c:when test="${empty video}">

													</c:when>
													<c:otherwise>
														<video width="600px;" height=auto controls autoplay
															preload>
															<source src="../Bumblbugimg/${video}" type="video/mp4">

														</video>
													</c:otherwise>
												</c:choose>


												<p><%=pjbean.getPj_story()%></p>
											</div>
										</div>
									</div>
								</div>
								<div id="tabContent02" class="tapPage">
									<jsp:include page="board/boardView.jsp">
									<jsp:param value="<%=b_idx%>" name="b_idx"/>
									</jsp:include>
								</div>
							</div>
						</div>
						<div class="ProjectPage_ContentsSub">
							<div class="ProjectPage_SubInner">
								<div class="Rewards">
									<div class="Rewards_Label">
										선택할 수 있는 <b><%=prlist.size()%></b>개의 선물이 있습니다.
									</div>
									<div class="RewardCard_CardWrapper">

										<c:set var="list" value="<%=prlist%>" />
										<c:forEach var="Presentbean" items="${list}">
											<div class="Card">
												<div class="RewardCard_CardInner">
													<div class="RewardCard_Header">
														<span class="RewardCard_PledgeAmount">
															${Presentbean.supmem_cnt}명이 선택 </span>
														<c:set var="limit" value="${Presentbean.limit_amount}" />
														<c:choose>
															<c:when test="${limit eq null || limit eq 0}">
															</c:when>
															<c:otherwise>
																<c:set var="rest"
																	value="${Presentbean.limit_amount - Presentbean.supmem_cnt}" />
																<c:choose>
																	<c:when test="${rest eq 0}">
																		<span class="RewardCard_QuantityLimited"> <span
																			class="RewardCard_LimitedRewardLabel"> 선착순 마감
																		</span>
																		</span>
																	</c:when>
																	<c:otherwise>
																		<span class="RewardCard_QuantityLimited"> <span
																			class="RewardCard_LimitedRewardLabel">
																				${Presentbean.limit_amount - Presentbean.supmem_cnt}개
																				남음 </span>
																		</span>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
													</div>
													<div class="RewardCard_Contents">
														<div class="RewardCard_MinPledgeAmount">
															${Presentbean.min_price}원 +</div>
														<div class="RewardCard_Description">
															${Presentbean.p_explain}</div>
													</div>
													<div class="RewardCard_Items">
														<li class="RewardCard_ItemList">${Presentbean.p_nm}</li>
													</div>
													<div class="RewardCard_DeliveryDate">
														<span> 예상 전달일 <b>${Presentbean.due_dt}</b></span>
													</div>
													<div class="Divider"></div>
													<!-- 추가 -->
													<c:set var="flag" value="<%=flag%>" />
													<c:choose>
														<c:when test="${flag eq true || rest eq 0}">
															<button type="Button" class="Button_not" disabled>
																<b>선물 선택하고 밀어주기</b>
															</button>
														</c:when>
														<c:otherwise>
															<button class="Button"
																onclick="location.href='RewardsPage.jsp'">선물
																선택하고 밀어주기</button>
														</c:otherwise>
													</c:choose>
													<!--  -->
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>