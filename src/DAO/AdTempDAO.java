package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.TempPresentBean;
import Bean.TempProjectBean;
import dbConnection.DBConnectionMgr;

public class AdTempDAO {
   private DBConnectionMgr pool;

   public AdTempDAO() {
      try {
         pool = DBConnectionMgr.getInstance();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public TempProjectBean getTp(String tp_idx) {
      TempProjectBean tpBeans = new TempProjectBean();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "select tp_title, tp_short_title, tp_img, tp_summary, tp_category, tp_url, tp_search_tag"
            + ", tp_profile_img, tp_leader_nm, tp_leader_intro, tp_leader_loc, tp_end_dt, tp_intro_video, tp_u_idx"
            + ", tp_story, tp_obj_price, tp_reg_dt, tp_ac_no, tp_ah, tp_bank_nm, tp_st, tp_ah_birth from temp_tb where tp_idx = ?;";
      try{
         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tp_idx);
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            tpBeans.setTp_title(rs.getString("tp_title"));
            tpBeans.setTp_short_title(rs.getString("tp_short_title"));
            tpBeans.setTp_img(rs.getString("tp_img"));
            tpBeans.setTp_summary(rs.getString("tp_summary"));
            tpBeans.setTp_category(rs.getString("tp_category"));
            tpBeans.setTp_url(rs.getString("tp_url"));
            tpBeans.setTp_search_tag(rs.getString("tp_search_tag"));
            tpBeans.setTp_profile_img(rs.getString("tp_profile_img"));
            tpBeans.setTp_leader_nm(rs.getString("tp_leader_nm"));
            tpBeans.setTp_leader_intro(rs.getString("tp_leader_intro"));
            tpBeans.setTp_leader_loc(rs.getString("tp_leader_loc"));
            tpBeans.setTp_end_dt(rs.getString("tp_end_dt"));
            tpBeans.setTp_intro_video(rs.getString("tp_intro_video"));
            tpBeans.setTp_u_idx(rs.getInt("tp_u_idx"));
            tpBeans.setTp_story(rs.getString("tp_story"));
            tpBeans.setTp_obj_price(rs.getString("tp_obj_price"));
            tpBeans.setTp_reg_dt(rs.getString("tp_reg_dt"));
            tpBeans.setTp_ac_no(rs.getString("tp_ac_no"));
            tpBeans.setTp_ah(rs.getString("tp_ah"));
            tpBeans.setTp_bank_nm(rs.getString("tp_bank_nm"));
            tpBeans.setTp_st(rs.getString("tp_st"));
            tpBeans.setTp_ah_birth(rs.getString("tp_ah_birth"));
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt, rs);
		}
      
      return tpBeans;
   }
   
   public int returnTp (String tp_idx) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      String sql = "update temp_tb set tp_st = '작성중' where tp_idx = ?;";
      
      try {
         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tp_idx);
         return pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt);
		}
      
      return -1;
   }
   
   public int acceptedTp (String tp_idx) {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql = "update temp_tb set tp_st = '완료' where tp_idx = ?;";
      
      try {
         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tp_idx);
         return pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt);
		}
      
      return -1;
   }
   
   // 임시테이블에서 프로젝트 테이블에 추가
   public int insertPj(TempProjectBean tpBeans) {
      String sql = "insert into pj_tb(pj_title, pj_short_title, pj_img, pj_summary, "
            + "pj_category, pj_url, search_tag, profile_img, leader_nm, leader_intro, "
            + "leader_loc, pj_end_dt, pj_intro_video, pj_u_idx, pj_story, obj_price, pj_reg_dt, "
            + "ac_no, ah, bank_nm, ah_birth)"
            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
      Connection conn = null;
      PreparedStatement pstmt = null;      
      
      try {
         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tpBeans.getTp_title());
         pstmt.setString(2, tpBeans.getTp_short_title());
         pstmt.setString(3, tpBeans.getTp_img());
         pstmt.setString(4, tpBeans.getTp_summary());
         pstmt.setString(5, tpBeans.getTp_category());
         pstmt.setString(6, tpBeans.getTp_url());
         pstmt.setString(7, tpBeans.getTp_search_tag());
         pstmt.setString(8, tpBeans.getTp_profile_img());
         pstmt.setString(9, tpBeans.getTp_leader_nm());
         pstmt.setString(10, tpBeans.getTp_leader_intro());
         pstmt.setString(11, tpBeans.getTp_leader_loc());
         pstmt.setString(12, tpBeans.getTp_end_dt());
         pstmt.setString(13, tpBeans.getTp_intro_video());
         pstmt.setInt(14, tpBeans.getTp_u_idx());
         pstmt.setString(15, tpBeans.getTp_story());
         pstmt.setString(16, tpBeans.getTp_obj_price());
         pstmt.setString(17, tpBeans.getTp_reg_dt());
         pstmt.setString(18, tpBeans.getTp_ac_no());
         pstmt.setString(19, tpBeans.getTp_ah());
         pstmt.setString(20, tpBeans.getTp_bank_nm());
         pstmt.setString(21, tpBeans.getTp_ah_birth());
         
         return pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt);
		}
      
      return -1;
   }
   
   // 임시프로젝트의 타이틀과 프로젝트 타이틀이 같은 pj idx 찾기
   public int getPjIdx(String tp_title) {
      String sql = "select pj_idx from pj_tb p left outer join temp_tb t on (p.pj_title = ?);";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      int pj_idx = 0;
      
      
      try {
         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tp_title);
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            pj_idx = rs.getInt("pj_idx");
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt, rs);
		}
      
      return pj_idx;
   }
   
   //임시 선물 테이블에서 선물 테이블로 추가
   public int insertPresent(TempPresentBean pBeans, int pj_idx) {
      String sql = "insert into present_tb(min_price, p_nm, p_explain, due_dt, "
            + "limit_amount, pj_p_idx) values (?,?,?,?,?,?);";
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, pBeans.getTp_min_price());
         pstmt.setString(2, pBeans.getTp_p_nm());
         pstmt.setString(3, pBeans.getTp_p_explain());
         pstmt.setString(4, pBeans.getTp_due_dt());
         pstmt.setInt(5, pBeans.getTp_limit_amount());
         pstmt.setInt(6, pj_idx);
         return pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt);
		}
      
      return -1;
   }
   // 임시 선물테이블에서 정보 가져오기
   public ArrayList<TempPresentBean> getTpPresent(String tp_pj_idx) {
      ArrayList<TempPresentBean> list = new ArrayList<TempPresentBean>();
      
      String sql = "select tp_p_idx, tp_min_price, tp_p_nm, tp_due_dt, "
            + "tp_limit_amount, tp_p_explain from temp_present_tb where tp_pj_idx = ?;";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {

         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tp_pj_idx);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            TempPresentBean tpBeans = new TempPresentBean();
            int tp_p_idx = rs.getInt("tp_p_idx");
            int tp_min_price = rs.getInt("tp_min_price");
            String tp_p_nm = rs.getString("tp_p_nm");
            String tp_due_dt = rs.getString("tp_due_dt");
            int tp_limit_amount = rs.getInt("tp_limit_amount");
            String tp_p_explain = rs.getString("tp_p_explain");
            
            System.out.println("선물 이름은 " + tp_p_nm);
            
            tpBeans.setTp_p_idx(tp_p_idx);
            tpBeans.setTp_min_price(tp_min_price);
            tpBeans.setTp_p_nm(tp_p_nm);
            tpBeans.setTp_due_dt(tp_due_dt);
            tpBeans.setTp_limit_amount(tp_limit_amount);
            tpBeans.setTp_p_explain(tp_p_explain);
            
            list.add(tpBeans);
            
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt, rs);
		}
      return list;
   }

   public ArrayList<TempProjectBean> getList(String tp_st) {

      ArrayList<TempProjectBean> list = new ArrayList<TempProjectBean>();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "select tp_idx, tp_title, tp_leader_nm, tp_end_dt, tp_st from temp_tb where tp_st = ?;";
      try {
         conn = pool.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tp_st);
         rs = pstmt.executeQuery();

         while (rs.next()) {

        	 TempProjectBean tpBeans = new TempProjectBean();

            tpBeans.setTp_idx(rs.getInt("tp_idx"));
            tpBeans.setTp_title(rs.getString("tp_title"));
            tpBeans.setTp_leader_nm(rs.getString("tp_leader_nm"));
            tpBeans.setTp_st(rs.getString("tp_st"));
            tpBeans.setTp_end_dt(rs.getString("tp_end_dt"));

            list.add(tpBeans);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
			pool.freeConnection(conn, pstmt, rs);
		}

      return list;
   }

}