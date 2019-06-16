package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.PresentBean;
import Bean.TempBean;
import Bean.TempPresentBean;
import Bean.UserBean;
import dbConnection.DBConnectionMgr;

public class ProjectInsertDAO {

private DBConnectionMgr pool;
	
	public ProjectInsertDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//user_tb 정보 가져오기
	public UserBean MemberInfo(String u_email, String u_pwd) {
			
	    	Connection con = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet  rs = null;
	    	String sql = null;
	    	UserBean bean = new UserBean();
	    	
	    try {
	    	con = pool.getConnection();
	    	sql = "select u_idx, u_img, u_nm, u_intro, u_loc, u_email, u_ph from USER_TB where u_email=? and u_pwd=?";
	    	pstmt = con.prepareStatement(sql);
	    	pstmt.setString(1,u_email);
	    	pstmt.setString(2,u_pwd);
	    	rs = pstmt.executeQuery();
	    
	    if(rs.next()) {
	    	bean.setU_idx(rs.getInt("u_idx"));
	    	bean.setU_img(rs.getString("u_img"));
	    	bean.setU_nm(rs.getString("u_nm"));
	    	bean.setU_intro(rs.getString("u_intro"));
	    	bean.setU_loc(rs.getString("u_loc"));
	    	bean.setU_email(rs.getString("u_email"));
	    	bean.setU_ph(rs.getString("u_ph"));
	    }
	    
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally{
	    	pool.freeConnection(con, pstmt,rs);
	    	}
		return bean;
	    }
	
	  //user_tb (idx용) 정보 가져오기(완)
    public UserBean MemberInfo(String u_idx) {
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet  rs = null;
    	String sql = null;
    	UserBean bean = new UserBean();
    	
    try {
    	con = pool.getConnection();
    	sql = "select u_idx, u_img, u_nm, u_intro, u_loc, u_email, u_ph from USER_TB where u_idx=? ";
    	pstmt = con.prepareStatement(sql);
    	pstmt.setString(1,u_idx);
    	rs = pstmt.executeQuery();

    if(rs.next()) {
    	bean.setU_img(rs.getString("u_img"));
    	bean.setU_nm(rs.getString("u_nm"));
    	bean.setU_intro(rs.getString("u_intro"));
    	bean.setU_loc(rs.getString("u_loc"));
    	bean.setU_email(rs.getString("u_email"));
    	bean.setU_ph(rs.getString("u_ph"));
    }

    }catch(Exception e) {
    	e.printStackTrace();
    }finally{
    	pool.freeConnection(con, pstmt,rs);
    	}
    return bean;
    }
	
    
  //user_tb (idx용) 정보 가져오기(완)
    public TempBean TempInfo(String u_idx) {
       	
       	Connection con = null;
       	PreparedStatement pstmt = null;
       	ResultSet  rs = null;
       	String sql = null;
       	TempBean bean = new TempBean();
       	int idx= 0;
       	
       try {
       	con = pool.getConnection();
       	sql = "select tp_idx from TEMP_TB where tp_u_idx= ?";
       	pstmt = con.prepareStatement(sql);
       	pstmt.setString(1,u_idx);
       	rs = pstmt.executeQuery();

       if(rs.next()) {
       	bean.setTp_idx(rs.getInt("tp_idx"));
       }

       }catch(Exception e) {
       	e.printStackTrace();
       }finally{
       	pool.freeConnection(con, pstmt,rs);
       	}
       return bean;
       }  
    
    //임시요청 눌렀을 때 temp에 값이 있는지 확인
 public boolean TempCheckInfo(String u_idx) {
       	
       	Connection con = null;
       	PreparedStatement pstmt = null;
       	ResultSet  rs = null;
       	String sql = null;
       	TempBean bean = new TempBean();
       	boolean flag = false;
       	
       try {
       	con = pool.getConnection();
       	sql = "select tp_idx from TEMP_TB where tp_u_idx= ?, ";
       	pstmt = con.prepareStatement(sql);
       	pstmt.setString(1,u_idx);
       	rs = pstmt.executeQuery();

       if(rs.next()) {
       	bean.setTp_idx(rs.getInt("tp_idx"));
       }

       }catch(Exception e) {
       	e.printStackTrace();
       }finally{
       	pool.freeConnection(con, pstmt,rs);
       	}
       return flag;
       }  
    

 //임시테이블 불러오기
    public TempBean TempTbInfo(String tp_idx) {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet  rs = null;
    	String sql = null;
    	TempBean bean = new TempBean();
    	
    	try {
    		con = pool.getConnection();
    		sql = "select tp_title,tp_short_title,tp_img,tp_summary,tp_category,tp_url, tp_search_tag,tp_profile_img,"
    				+ "tp_leader_nm, tp_leader_intro, tp_leader_loc, tp_end_dt, tp_intro_video, tp_story, tp_obj_price, "
    				+ "tp_reg_dt,tp_ac_no,tp_ah,tp_bank_nm,tp_ah_birth, tp_u_idx from TEMP_TB where tp_idx = ?";
    		pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, tp_idx);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			bean.setTp_title(rs.getString("tp_title"));
    			bean.setTp_short_title(rs.getString("tp_short_title"));
    			bean.setTp_img(rs.getString("tp_img"));
    			bean.setTp_summary(rs.getString("tp_summary"));
    			bean.setTp_category(rs.getString("tp_category"));
    			bean.setTp_url(rs.getString("tp_url"));
    			bean.setTp_search_tag(rs.getString("tp_search_tag"));
    			bean.setTp_profile_img(rs.getString("tp_profile_img"));
    			bean.setTp_leader_nm(rs.getString("tp_leader_nm"));
    			bean.setTp_leader_intro(rs.getString("tp_leader_intro"));
    			bean.setTp_leader_loc(rs.getString("tp_leader_loc"));
    			bean.setTp_end_dt(rs.getString("tp_end_dt"));
    			bean.setTp_intro_video(rs.getString("tp_intro_video"));
    			bean.setTp_story(rs.getString("tp_story"));
    			bean.setTp_obj_price(rs.getString("tp_obj_price"));
    			bean.setTp_reg_dt(rs.getString("tp_reg_dt"));
    			bean.setTp_ac_no(rs.getString("tp_ac_no"));
    			bean.setTp_ah(rs.getString("tp_ah"));
    			bean.setTp_bank_nm(rs.getString("tp_bank_nm"));
    			bean.setTp_ah_birth(rs.getString("tp_ah_birth"));
    			bean.setTp_u_idx(rs.getInt("tp_u_idx"));
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		pool.freeConnection(con, pstmt,rs);
		}
		return bean;
    }
    
    //임시저장 업테이트 
    public boolean UpdateTempTb(TempBean bean) {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet  rs = null;
    	String sql = null;
    	boolean flag = false;
    	
    	System.out.println(bean.getTp_idx());
    	
    	try {
    		con = pool.getConnection();
    		sql= "update TEMP_TB set tp_title= ?, tp_short_title = ?, tp_img=?, tp_summary=?,tp_category=?, tp_url=?,tp_search_tag=?,"
    				+ "tp_profile_img=?, tp_leader_nm=?, tp_leader_intro=?, tp_leader_loc=?, tp_end_dt=?, tp_intro_video=?, tp_story=?,"
    				+ "tp_obj_price=?, tp_reg_dt=?, tp_ac_no=?, tp_ah=?, tp_bank_nm=?, tp_ah_birth=? where tp_idx=?";
    		pstmt = con.prepareStatement(sql);
		    pstmt.setString(1,bean.getTp_title());
       	    pstmt.setString(2,bean.getTp_short_title());
       	    pstmt.setString(3,bean.getTp_img());
       	    pstmt.setString(4,bean.getTp_summary());
       	    pstmt.setString(5,bean.getTp_category());
       	    pstmt.setString(6,bean.getTp_url());
       	    pstmt.setString(7,bean.getTp_search_tag());
       	    pstmt.setString(8,bean.getTp_profile_img());
       	    pstmt.setString(9,bean.getTp_leader_nm());
       	    pstmt.setString(10,bean.getTp_leader_intro());
       	    pstmt.setString(11,bean.getTp_leader_loc());
       	    pstmt.setString(12,bean.getTp_end_dt());
       	    pstmt.setString(13,bean.getTp_intro_video());
       	    pstmt.setString(14,bean.getTp_story());
       	    pstmt.setString(15,bean.getTp_obj_price());
       	    pstmt.setString(16,bean.getTp_reg_dt());
       	    pstmt.setString(17,bean.getTp_ac_no());
       	    pstmt.setString(18,bean.getTp_ah());
       	    pstmt.setString(19,bean.getTp_bank_nm());
       	    pstmt.setString(20,bean.getTp_ah_birth());
       	    pstmt.setInt(21, bean.getTp_idx());
    		
    		if(pstmt.executeUpdate() == 1)
    			flag = true;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		pool.freeConnection(con, pstmt,rs);
		}
		return flag;
		
    }
 
  //임시테이블 입력
    public int insertTemp(TempBean bean, String u_idx) {
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int idx = -1;
    	String sql1 = null;
    	String sql2 = null;
    	
    	
    	try {
    		con = pool.getConnection();
    		sql1 = "insert TEMP_TB(tp_title,tp_short_title,tp_img,tp_summary,tp_category,tp_url," + 
    				"tp_search_tag,tp_profile_img,tp_leader_nm,tp_leader_intro," + 
    				"tp_leader_loc,tp_end_dt,tp_intro_video,tp_story,tp_obj_price," + 
    				"tp_reg_dt,tp_ac_no,tp_ah,tp_bank_nm,tp_ah_birth, tp_u_idx)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	    pstmt = con.prepareStatement(sql1);
    	    pstmt.setString(1,bean.getTp_title());
    	    pstmt.setString(2,bean.getTp_short_title());
    	    pstmt.setString(3,bean.getTp_img());
    	    pstmt.setString(4,bean.getTp_summary());
    	    pstmt.setString(5,bean.getTp_category());
    	    pstmt.setString(6,bean.getTp_url());
    	    pstmt.setString(7,bean.getTp_search_tag());
    	    pstmt.setString(8,bean.getTp_profile_img());
    	    pstmt.setString(9,bean.getTp_leader_nm());
    	    pstmt.setString(10,bean.getTp_leader_intro());
    	    pstmt.setString(11,bean.getTp_leader_loc());
    	    pstmt.setString(12,bean.getTp_end_dt());
    	    pstmt.setString(13,bean.getTp_intro_video());
    	    pstmt.setString(14,bean.getTp_story());
    	    pstmt.setString(15,bean.getTp_obj_price());
    	    pstmt.setString(16,bean.getTp_reg_dt());
    	    pstmt.setString(17,bean.getTp_ac_no());
    	    pstmt.setString(18,bean.getTp_ah());
    	    pstmt.setString(19,bean.getTp_bank_nm());
    	    pstmt.setString(20,bean.getTp_ah_birth());
    	    pstmt.setInt(21,bean.getTp_u_idx());
    	    pstmt.executeUpdate();
    	    
    	    sql2 = "select tp_idx from temp_tb where tp_title=? and tp_u_idx=? and tp_short_title=? ";
    	    pstmt = con.prepareStatement(sql2);
    	    pstmt.setString(1, bean.getTp_title());
    	    pstmt.setInt(2, bean.getTp_u_idx());
    	    pstmt.setString(3, bean.getTp_short_title());
    	    rs = pstmt.executeQuery();
    	    
    	    if(rs.next()) {
    	    	idx= rs.getInt("tp_idx");
    	    }
    	   
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		pool.freeConnection(con, pstmt);
       	}
       return idx;
       }

    
  //임시테이블 승인 변경
    public boolean insertTempWaitCheck(TempBean bean) {
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = null;
    	boolean flag = false;
    		
    	try {
    		con = pool.getConnection();
    		sql= "update TEMP_TB set tp_title= ?, tp_short_title = ?, tp_img=?, tp_summary=?,tp_category=?, tp_url=?,tp_search_tag=?,"
    				+ "tp_profile_img=?, tp_leader_nm=?, tp_leader_intro=?, tp_leader_loc=?, tp_end_dt=?, tp_intro_video=?, tp_story=?,"
    				+ "tp_obj_price=?, tp_reg_dt=?, tp_ac_no=?, tp_ah=?, tp_bank_nm=?, tp_ah_birth=?, tp_st = ? where tp_idx=?";
    		
    		pstmt = con.prepareStatement(sql);
		    pstmt.setString(1,bean.getTp_title());
       	    pstmt.setString(2,bean.getTp_short_title());
       	    pstmt.setString(3,bean.getTp_img());
       	    pstmt.setString(4,bean.getTp_summary());
       	    pstmt.setString(5,bean.getTp_category());
       	    pstmt.setString(6,bean.getTp_url());
       	    pstmt.setString(7,bean.getTp_search_tag());
       	    pstmt.setString(8,bean.getTp_profile_img());
       	    pstmt.setString(9,bean.getTp_leader_nm());
       	    pstmt.setString(10,bean.getTp_leader_intro());
       	    pstmt.setString(11,bean.getTp_leader_loc());
       	    pstmt.setString(12,bean.getTp_end_dt());
       	    pstmt.setString(13,bean.getTp_intro_video());
       	    pstmt.setString(14,bean.getTp_story());
       	    pstmt.setString(15,bean.getTp_obj_price());
       	    pstmt.setString(16,bean.getTp_reg_dt());
       	    pstmt.setString(17,bean.getTp_ac_no());
       	    pstmt.setString(18,bean.getTp_ah());
       	    pstmt.setString(19,bean.getTp_bank_nm());
       	    pstmt.setString(20,bean.getTp_ah_birth());
       	    pstmt.setString(21, "승인대기중");
       	    pstmt.setInt(22, bean.getTp_idx());
       	    
       	    if(pstmt.executeUpdate() == 1)
       	    	flag = true;
    	 
 
    	   
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		pool.freeConnection(con, pstmt);
       	}
       return flag;
       }
    
    //임시테이블 등록및 요청
    public int insertTempWait(TempBean bean, String u_idx) {
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int idx = -1;
    	String sql1 = null;
    	String sql2 = null;
    	
    	
    	try {
    		con = pool.getConnection();
    		sql1 = "insert TEMP_TB(tp_title,tp_short_title,tp_img,tp_summary,tp_category,tp_url," + 
    				"tp_search_tag,tp_profile_img,tp_leader_nm,tp_leader_intro," + 
    				"tp_leader_loc,tp_end_dt,tp_intro_video,tp_story,tp_obj_price," + 
    				"tp_reg_dt,tp_ac_no,tp_ah,tp_bank_nm,tp_ah_birth, tp_u_idx,tp_st)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	    pstmt = con.prepareStatement(sql1);
    	    pstmt.setString(1,bean.getTp_title());
    	    pstmt.setString(2,bean.getTp_short_title());
    	    pstmt.setString(3,bean.getTp_img());
    	    pstmt.setString(4,bean.getTp_summary());
    	    pstmt.setString(5,bean.getTp_category());
    	    pstmt.setString(6,bean.getTp_url());
    	    pstmt.setString(7,bean.getTp_search_tag());
    	    pstmt.setString(8,bean.getTp_profile_img());
    	    pstmt.setString(9,bean.getTp_leader_nm());
    	    pstmt.setString(10,bean.getTp_leader_intro());
    	    pstmt.setString(11,bean.getTp_leader_loc());
    	    pstmt.setString(12,bean.getTp_end_dt());
    	    pstmt.setString(13,bean.getTp_intro_video());
    	    pstmt.setString(14,bean.getTp_story());
    	    pstmt.setString(15,bean.getTp_obj_price());
    	    pstmt.setString(16,bean.getTp_reg_dt());
    	    pstmt.setString(17,bean.getTp_ac_no());
    	    pstmt.setString(18,bean.getTp_ah());
    	    pstmt.setString(19,bean.getTp_bank_nm());
    	    pstmt.setString(20,bean.getTp_ah_birth());
    	    pstmt.setInt(21,bean.getTp_u_idx());
    	    pstmt.setString(22, "승인대기중");
    	    pstmt.executeUpdate();
    	    
    	    sql2 = "select tp_idx from temp_tb where tp_title=? and tp_u_idx=? ";
    	    pstmt = con.prepareStatement(sql2);
    	    pstmt.setString(1, bean.getTp_title());
    	    pstmt.setInt(2, bean.getTp_u_idx());
    	    rs = pstmt.executeQuery();
    	    
    	    if(rs.next()) {
    	    	idx= rs.getInt("tp_idx");
    	    }
    	   
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		pool.freeConnection(con, pstmt);
       	}
       return idx;
       }
   
    
  //임시선물구성 입력
 	public boolean insertTempPresent(TempPresentBean bean,String tp_idx) {
 		
 		Connection con = null;
 		PreparedStatement pstmt = null;
 		String sql = null;
 		ResultSet  rs = null;
 		
 		boolean flag = false;
 		try {
 			con = pool.getConnection();	
 			sql = "insert TEMP_PRESENT_TB(tp_min_price, tp_p_nm, tp_due_dt, "
 					+ "tp_limit_amount, tp_pj_idx, tp_p_explain)values(?,?,?,?,?,?)";
 			pstmt = con.prepareStatement(sql);
 			pstmt.setInt(1, bean.getTp_min_price());
 			pstmt.setString(2, bean.getTp_p_nm());
 			pstmt.setString(3, bean.getTp_due_dt());
 			pstmt.setInt(4, bean.getTp_limit_amount());
 			pstmt.setString(5, tp_idx);
 			pstmt.setString(6,bean.getTp_p_explain());
 			
 			if(pstmt.executeUpdate() == 1) {
 				flag = true;
 			}
 			
 			
 			
 		}catch(Exception e) {
 			e.printStackTrace();
 		}finally{
 			pool.freeConnection(con, pstmt);
 		}
 		return false;
 	}
    
 	//임시 선물 불러오기  
public ArrayList<TempPresentBean> getPresentList(String tp_idx) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TempPresentBean bean = null;
		
		ArrayList<TempPresentBean> list = new ArrayList<TempPresentBean>();
		
		try {
			con = pool.getConnection();
			String sql = "select * from TEMP_PRESENT_TB where tp_pj_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tp_idx);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bean = new TempPresentBean();
				bean.setTp_p_idx(rs.getInt("tp_p_idx"));
				bean.setTp_p_nm(rs.getString("tp_p_nm"));
				bean.setTp_min_price(rs.getInt("tp_min_price"));
				bean.setTp_due_dt(rs.getString("tp_due_dt"));
				bean.setTp_limit_amount(rs.getInt("tp_limit_amount"));
				bean.setTp_p_explain(rs.getString("tp_p_explain"));
				bean.setTp_pj_idx(rs.getInt("tp_pj_idx"));
				
				
				list.add(bean);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		
		return list;
	}
 
        
//임시선물 업데이트
public Boolean updatePresentp(TempPresentBean bean) {
    Connection con = null;
    PreparedStatement pstmt = null;
    Boolean flag=false;
    
    try {
       con = pool.getConnection();
       String sql = "update TEMP_PRESENT_TB set tp_min_price=?, tp_p_nm=?, tp_due_dt=?"
                   +", tp_limit_amount=?, tp_p_explain=?, tp_pj_idx=? where tp_p_idx=?";
       
       pstmt = con.prepareStatement(sql);
       pstmt.setInt(1, bean.getTp_min_price()); 
       pstmt.setString(2, bean.getTp_p_nm());
       pstmt.setString(3, bean.getTp_due_dt());
       pstmt.setInt(4, bean.getTp_limit_amount());
       pstmt.setString(5, bean.getTp_p_explain());
       pstmt.setInt(6, bean.getTp_pj_idx());
       pstmt.setInt(7, bean.getTp_p_idx());
       
       if (pstmt.executeUpdate() == 1)
          flag = true;
       
    } catch (Exception e) {
       e.printStackTrace();
    } finally {
       pool.freeConnection(con, pstmt);
    }
    return flag;
 }
        
}
