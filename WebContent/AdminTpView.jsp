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
   out.println(tp_idx);
%>
<!-- DAO -->
<%
   //temp_tb자료
   AdTempDAO ato = new AdTempDAO();
   TempProjectBean tpBeans = new TempProjectBean();
   tpBeans = ato.getTp(tp_idx);
   String tp_title = tpBeans.getTp_title();
   String tp_short_title = tpBeans.getTp_short_title();
   String tp_img = tpBeans.getTp_img();
   String tp_summary = tpBeans.getTp_summary();
   String tp_category = tpBeans.getTp_category();
   String tp_url = tpBeans.getTp_url();
   String tp_search_tag = tpBeans.getTp_search_tag();
   String tp_profile_img = tpBeans.getTp_profile_img();
   String tp_leader_nm = tpBeans.getTp_leader_nm();
   String tp_leader_intro = tpBeans.getTp_leader_intro();
   String tp_leader_loc = tpBeans.getTp_leader_loc();
   String tp_end_dt = tpBeans.getTp_end_dt();
   String tp_intro_video = tpBeans.getTp_intro_video();
   String tp_u_idx = Integer.toString(tpBeans.getTp_u_idx());
   String tp_story = tpBeans.getTp_story();
   String tp_obj_price = tpBeans.getTp_obj_price();
   String tp_reg_dt = tpBeans.getTp_reg_dt();
   String tp_ac_no = tpBeans.getTp_ac_no();
   String tp_ah = tpBeans.getTp_ah();
   String tp_bank_nm = tpBeans.getTp_bank_nm();
   String tp_st = tpBeans.getTp_st();
   String tp_ah_birth = tpBeans.getTp_ah_birth();
   
   //Debug
   System.out.println("임시 테이블 beans는 : " + tpBeans);
   System.out.println("tp_title : " + tp_title);
   System.out.println("tp_short_title : " + tp_short_title);
   System.out.println("tp_img : " + tp_img);
   System.out.println("tp_summary : " + tp_summary);
   System.out.println("tp_category : " + tp_category);
   System.out.println("tp_url : " + tp_url);
   System.out.println("tp_search_tag : " + tp_search_tag);
   System.out.println("tp_profile_img : " + tp_profile_img);
   System.out.println("tp_leader_nm : " + tp_leader_nm);
   System.out.println("tp_leader_intro : " + tp_leader_intro);
   System.out.println("tp_leader_loc : " + tp_leader_loc);
   System.out.println("tp_end_dt : " + tp_end_dt);
   System.out.println("tp_intro_video : " + tp_intro_video);
   System.out.println("tp_u_idx : " + tp_u_idx);
   System.out.println("tp_story : " + tp_story);
   System.out.println("tp_obj_price : " + tp_obj_price);
   System.out.println("tp_reg_dt : " + tp_reg_dt);
   System.out.println("tp_ac_no : " + tp_ac_no);
   System.out.println("tp_ah : " + tp_ah);
   System.out.println("tp_bank_nm : " + tp_bank_nm);
   System.out.println("tp_st : " + tp_st);
   System.out.println("tp_ah_birth : " + tp_ah_birth);
   
   //tempPresnt_tb 자료
   TempPresentBean pBeans = new TempPresentBean();
   ArrayList<TempPresentBean> pBeansList = new ArrayList<TempPresentBean>();
   pBeansList = ato.getTpPresent(tp_idx);
   
   //DEBUG
   
//   System.out.println(pBeans);
   

%>
<!-- DAO 자료 저장 -->


<!-- 해야할일 -->
   <!-- 1. 승인함. -->
   <!-- 1) 승인  - 임시테이블의 것을 프로젝트 테이블에 옮기고, 임시테이블의 상태를 '완료'로 바꾼다 -->
   
   <!-- 2) 승인 - 임시선물테이블의 것을 선물 테이블로 옮기고, 프로젝트테이블로 옮겨간 프로젝트의 idx를 선물 테이블의 프로젝트 idx에 추가한다. -->
   <!-- 3) 검색 태그를 , 단위로 쪼개서 tag테이블에 저장 -->

   <!-- 2. 거절함 -->
   <!-- 1)'승인 대기중인 임시테이블의 상태를 '작성중'으로 변경한다.  -->
   
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>임시 프로젝트 상세보기</title>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: 'Nanum Gothic', sans-serif;
            border-radius: 3px;
            font-weight: bolder;
        }
        img{
        width:200px;
        
        }

        .header-wrap {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            background-color: #ffffff;
            box-shadow: 0px 1px 2px 0px rgba(10, 10, 10, 0.1);
            background-image: linear-gradient(to right, #0d47a1 , #265396);


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

        .container {
            width: 80%;
            margin: 0 auto;
            margin-top: 40px;
            height: 100%;
            
        }

        .flex {
            display: flex;
            flex-direction: column;
            align-items: stretch;
        }

        .row {
            display: flex;
            height: 100%;
        }

        .left {
            width: 25%;
            border: 2px solid #d3d3d3;
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 20px;
            
        }

        .right {
            width: 75%;
            border: 2px solid #d3d3d3;
            display: flex;
            align-items: center;
            
        }
        .left {
            background-color: #bbdefb;
        }
        .right {
            background-color: #e3f2fd;
        }

        .loginButton {
            cursor: pointer;
            display: inline-block;
            min-height: 1em;
            outline: none;
            border: none;
            vertical-align: baseline;
            box-shadow: 0px 0px 0px 1px transparent inset, 0px 0em 0px 0px rgba(0, 0, 0, 0.1) inset;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            -webkit-transition: opacity 0.1s ease, background-color 0.1s ease, color 0.1s ease, box-shadow 0.1s ease, background 0.1s ease;
            transition: opacity 0.1s ease, background-color 0.1s ease, color 0.1s ease, box-shadow 0.1s ease, background 0.1s ease;
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
            width: 200px;
            opacity: 1;
        }

        .loginButton>i {
            margin: 0 .42857143em 0 -.21428571em;
        }

        .loginButton:hover,
        .loginButton:focus,
        .loginButton:active {
            background-color: #d9d9d9;
            color: rgba(0, 0, 0, 8);
        }

        .loginButton:hover,
        .loginButton:focus,
        .loginButton:active {
            background-color: #ff4543;
            color: #fff;
        }
        .footer{
            display: flex;
            justify-content:flex-end;
        }
    </style>


    <script>
        $(function () {

        });
    </script>

</head>

<body>
    <div class="header-wrap">
        <div class="header">
            <div class="hpName-wrap">프로젝트 승인 페이지</div>
        </div>
    </div>

    <div class="container">
        <div class="flex">
            <div class="row">
                <div class="left">
                    <span>제목</span>
                </div>
                <div class="right">
                    <%=tp_title %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>짧은제목</span>
                </div>
                <div class="right">
                    <%=tp_short_title %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>이미지</span>
                </div>
                <div class="right">
                <img src="Bumblbugimg/<%= tp_img%>" >
                    
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>요약</span>
                </div>
                <div class="right">
                    <%=tp_summary %>

                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>카테고리</span>
                </div>
                <div class="right">
                    <%=tp_category %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>URL</span>
                </div>
                <div class="right">
                    <%=tp_url %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>검색태그</span>
                </div>
                <div class="right">
                    <%=tp_search_tag %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>프로필</span>
                </div>
                <div class="right">
                <img src="Bumblbugimg/<%=tp_profile_img%>" style="width=400; height:auto;">
                    
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>진행자 이름</span>
                </div>
                <div class="right">
                    <%=tp_leader_nm %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>리더소개</span>
                </div>
                <div class="right">
                    <%=tp_leader_intro %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>활동지역</span>
                </div>
                <div class="right">
                    <%=tp_leader_loc %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>마감날짜</span>
                </div>
                <div class="right">
                    <%=tp_end_dt %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>소개영상</span>
                </div>
                <div class="right">
                <video width="300" height="200" controls preload>
               <source src="Bumblbugimg/<%=tp_intro_video %>"type="video/mp4">
            </video>
                
                    
                </div>
            </div>
            <div class="row">
                <div class="left" id="story">
                    <span>스토리</span>
                </div>
                <div class="right">
                    <%=tp_story %>

                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>등록날짜</span>
                </div>
                <div class="right">
                    <%=tp_reg_dt %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>목표금액</span>
                </div>
                <div class="right">
                    <%=tp_obj_price %>
                </div>
            </div>

            <div class="row">
                <div class="left">
                    <span>계좌번호</span>
                </div>
                <div class="right">
                    <%=tp_ac_no %>
                </div>
            </div>
            <div class="row">
                <div class="left">
                    <span>소유주 번호</span>
                </div>
                <div class="right">
                    <%=tp_ah %>
                </div>
            </div>

            <div class="row">
                <div class="left">
                    <span>소유주 이름</span>
                </div>
                <div class="right">
                    <%=tp_ah %>
                </div>
            </div>

            <div class="row">
                <div class="left">
                    <span>은행이름</span>
                </div>
                <div class="right">
                    <%=tp_bank_nm %>
                </div>
            </div>

            <div class="row">
                <div class="left">
                    <span>소유주 생년월일</span>
                </div>
                <div class="right">
                    <%=tp_ah_birth %>
                </div>
            </div>
             <div class="row">
                <div class="left">
                    <span>선물</span>
                </div>
                <div class="right">
                    <% for(int i = 0; i < pBeansList.size(); i++) { 
               //System.out.println(pBeans.get(i).getTp_p_nm());
            %>
               <%=pBeansList.get(i).getTp_p_nm()%>
               
               <%
            }
             %>
                </div>
            </div>

        </div>
        <div class="footer">        
            <a href="./AdminTpViewAcP.jsp?tp_idx=<%=tp_idx %>">
            <button class="loginButton" type="submit" value="승인">승인</button>
        </a>
        <a href="./AdminTpViewReP.jsp?tp_idx=<%=tp_idx %>">
            <button class="loginButton" type="submit" value="거절">거절</button>
        </a>

         </div>



    </div>
</body>

</html>