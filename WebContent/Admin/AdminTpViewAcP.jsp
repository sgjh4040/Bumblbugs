<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "DAO.AdTempDAO" %>
<%@ page import = "DAO.ProjectDAO" %>
<%@ page import = "DAO.TagDAO" %>
<%@ page import = "Bean.TempProjectBean" %>
<%@ page import = "Bean.TempPresentBean" %>    
<%@ page import = "Bean.TagBean" %>
<!-- request -->
<%
   request.setCharacterEncoding("UTF-8");
   String tp_idx = (String)request.getParameter("tp_idx");
%>

<%
   AdTempDAO ato = new AdTempDAO();
   TempProjectBean tpBeans = new TempProjectBean();
   tpBeans = ato.getTp(tp_idx);
   
   TempPresentBean pBeans = new TempPresentBean();
   ArrayList<TempPresentBean> pBeanList = ato.getTpPresent(tp_idx);
   
   System.out.println("tp_idx는  : " + tp_idx);
   
   //자료 저장
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
   
%>
   <%
   int flagPj = ato.insertPj(tpBeans);
   int flagTp = ato.acceptedTp(tp_idx);
   
   
   int pj_idx = ato.getPjIdx(tp_title);
   System.out.println("pj_idx = " + pj_idx);
   
   for(int i = 0; i < pBeanList.size(); i++){
      int pflag = ato.insertPresent(pBeanList.get(i), pj_idx);
      System.out.println(i + "번째 선물 성공여부" + pflag);
   }
   ProjectDAO pDAO = new ProjectDAO();
   String tag = pDAO.getTagName(Integer.toString(pj_idx));
   
   TagBean tBean = new TagBean();
   TagDAO tDAO = new TagDAO();
   
   
   ArrayList<String> arrTag = pDAO.splitTag(tag);
   System.out.println(arrTag);
   
   for(int i = 0; i < arrTag.size(); i++){
      tBean.setPj_tag_idx(pj_idx);
      tBean.setTag_nm(arrTag.get(i));
      System.out.println("tagBean은  " + tBean);
      tDAO.setTag(tBean);
      
   }
   %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
   //test code
      System.out.println(flagPj);
      System.out.println(flagTp);
      //System.out.println(flagPr);
   %>
   
   <script type="text/javascript">
      alert('승인 되었습니다.');
      location.href="./AdminPage.jsp";
   </script>
</body>
</html>