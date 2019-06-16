package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.DelBean;
import Bean.FundBean;
import Bean.PayBean;
import Bean.PayInfoBean;
import Bean.PresentBean;
import Bean.ProjectBean;
import Bean.UserBean;
import dbConnection.DBConnectionMgr;

public class ProjectDAO {
	
	private DBConnectionMgr pool;

	public ProjectDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public String getTagName(String pj_idx) {
        String tag = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "select search_tag from pj_tb where pj_idx = ?;";
        ResultSet rs = null;
        
        try {
           con = pool.getConnection();
           pstmt = con.prepareStatement(sql);
           pstmt.setString(1, pj_idx);
           rs = pstmt.executeQuery();
           
           if(rs.next()) {
              tag = rs.getString(1);
           }
        }catch(Exception e) {
           e.printStackTrace();
        }
        
        
        return tag;
     }
     
     public ArrayList<String> splitTag(String tag) {
        System.out.println(tag);
        ArrayList<String> arrTag = new ArrayList<String>();
        String[] tagP = tag.split(",");
        for(int i = 0; i < tagP.length; i++) {
           arrTag.add(tagP[i].trim());
        }
        
        return arrTag;
     }

	
	
	// PJ_TB占쏙옙 占쏙옙占쌘듸옙 bean set
	public ProjectBean getProject(String pj_idx) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectBean bean = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from PJ_TB where pj_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pj_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new ProjectBean();
				bean.setPj_idx(rs.getInt("pj_idx"));
				bean.setPj_title(rs.getString("pj_title"));
				bean.setPj_short_title(rs.getString("pj_short_title"));
				bean.setPj_img(rs.getString("pj_img"));
				bean.setPj_summary(rs.getString("pj_summary"));
				bean.setPj_category(rs.getString("pj_category"));
				bean.setPj_url(rs.getString("pj_url"));
				bean.setSearch_tag(rs.getString("search_tag"));
				bean.setProfile_img(rs.getString("profile_img"));
				bean.setLeader_nm(rs.getString("leader_nm"));
				bean.setLeader_intro(rs.getString("leader_intro"));
				bean.setLeader_loc(rs.getString("leader_loc"));
				bean.setPj_end_dt(rs.getString("pj_end_dt"));
				bean.setPj_intro_video(rs.getString("pj_intro_video"));
				bean.setPj_sup_num(rs.getInt("pj_sup_num"));
				bean.setPj_u_idx(rs.getInt("pj_u_idx"));
				bean.setPj_f_price(rs.getString("pj_f_price"));
				bean.setPj_story(rs.getString("pj_story"));
				bean.setObj_price(rs.getString("obj_price"));
				bean.setPj_reg_dt(rs.getString("pj_reg_dt"));
				bean.setAc_no(rs.getString("ac_no"));
				bean.setAh(rs.getString("ah"));
				bean.setBank_nm(rs.getString("bank_nm"));
				bean.setAh_birth(rs.getString("ah_birth"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		
		return bean;
	}
	
	public UserBean getMember(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBean bean = null;
		try {
			con = pool.getConnection();
			String sql = "select * from user_tb where u_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new UserBean();
				bean.setNews_sub_tf(rs.getInt("news_sub_tf"));
				bean.setSns_con_tf(rs.getInt("sns_con_tf"));
				bean.setU_email(rs.getString("u_email"));
				bean.setU_idx(rs.getInt("u_idx"));
				bean.setU_img(rs.getString("u_img"));
				bean.setU_intro(rs.getString("u_intro"));
				bean.setU_loc(rs.getString("u_loc"));
				bean.setU_nm(rs.getString("u_nm"));
				bean.setU_ph(rs.getString("u_ph"));
				bean.setU_pwd(rs.getString("u_pwd"));
				bean.setU_website(rs.getString("u_website"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		return bean;
	}
	
	// 占쌔댐옙 占쏙옙占쏙옙占쏙옙트占쏙옙 PRESENT_TB 占쏙옙占쌘듸옙 ArrayList<Bean> set
	public ArrayList<PresentBean> getPresentList(String pj_idx) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PresentBean bean = null;
		
		ArrayList<PresentBean> list = new ArrayList<PresentBean>();
		
		try {
			con = pool.getConnection();
			String sql = "select * from PRESENT_TB where pj_p_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pj_idx);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bean = new PresentBean();
				
				bean.setP_idx(rs.getInt("p_idx"));
				bean.setMin_price(rs.getInt("min_price"));
				bean.setP_nm(rs.getString("p_nm"));
				bean.setP_explain(rs.getString("p_explain"));
				bean.setDue_dt(rs.getString("due_dt"));
				bean.setSupmem_cnt(rs.getInt("supmem_cnt"));
				bean.setLimit_amount(rs.getInt("limit_amount"));
				bean.setPj_p_idx(rs.getInt("pj_p_idx"));
				
				
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		return list;
	}
	
	// 占쏙옙占싸금억옙%
	public String goalAmount(String cprice, String gprice){
		
		double c_price = Double.valueOf(cprice);
		double g_price = Double.valueOf(gprice);
		
		int goal = (int)((c_price / g_price) * 100.0);
		
		String goalAmount = String.valueOf(goal);
		
		return goalAmount;
	}
	
	// 占쏙옙占쏙옙 占시곤옙
//	public long dDAY(String endDate) {
//		
//		try{
//	        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd", Locale.KOREA);
//	        // date1, date2 占쏙옙 占쏙옙짜占쏙옙 parse()占쏙옙 占쏙옙占쏙옙 Date占쏙옙占쏙옙占쏙옙 占쏙옙환.
//	        Date dDate = format1.parse(endDate);
//
//	        String time =  format1.format(new Date());
//	        Date today =  format1.parse(time);
//	        
//	        System.out.println(dDate + " / " + today);
//	        
//	        // Date占쏙옙 占쏙옙환占쏙옙 占쏙옙 占쏙옙짜占쏙옙 占쏙옙占쏙옙占� 占쏙옙 占쏙옙 占쏙옙占싹곤옙占쏙옙占쏙옙 long type 占쏙옙占쏙옙占쏙옙 占십깍옙화 占싹곤옙 占쌍댐옙.
//	        // 占쏙옙占쏙옙占쏙옙 -950400000. long type 占쏙옙占쏙옙 return 占싫댐옙.
//	        long calDate = dDate.getTime() - today.getTime(); 
//	        
//	        // Date.getTime() 占쏙옙 占쌔당날짜占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙1970占쏙옙 00:00:00 占쏙옙占쏙옙 占쏙옙 占십곤옙 占쎄렀占쏙옙占쏙옙占쏙옙 占쏙옙환占쏙옙占쌔댐옙. 
//	        // 占쏙옙占쏙옙 24*60*60*1000(占쏙옙 占시곤옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙) 占쏙옙 占쏙옙占쏙옙占쌍몌옙 占싹쇽옙占쏙옙 占쏙옙占승댐옙.
//	        long dDay = calDate / ( 24*60*60*1000); 
//	 
//	        dDay = Math.abs(dDay);
//	        
//	        return dDay;
//	        }
//	        catch(ParseException e)
//	        {
//	        	e.printStackTrace();
//	        	return -1;
//	        }
//		
//		
//	}
	
	// 占쌔댐옙 占쏙옙占쏙옙占쏙옙트占쏙옙占쏙옙 占쏙옙占시듸옙 占쏙옙占쏙옙 PresentBean set
	public PresentBean getPresent(int p_idx) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PresentBean bean = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from PRESENT_TB where p_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new PresentBean();
				bean.setP_idx(rs.getInt("p_idx"));
				bean.setMin_price(rs.getInt("min_price"));
				bean.setP_nm(rs.getString("p_nm"));
				bean.setP_explain(rs.getString("p_explain"));
				bean.setDue_dt(rs.getString("due_dt"));
				bean.setSupmem_cnt(rs.getInt("supmem_cnt"));
				bean.setLimit_amount(rs.getInt("limit_amount"));
				bean.setPj_p_idx(rs.getInt("pj_p_idx"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		
		return bean;
	}
	
	// 占쌔댐옙 회占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙, 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쌉뤄옙 占쏙옙황 체크
	public int checkUserCase(String u_idx) {
		
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			con = pool.getConnection();
			
			String sql1 = "select pay_info_idx from PAY_INFO_TB where pay_u_idx = ?";
			String sql2 = "select d_idx from DEL_Tb where d_u_idx = ?";
			
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, u_idx);
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, u_idx);
			
			boolean flag1 = pstmt1.executeQuery().next(); // 占쌔댐옙 회占쏙옙占쏙옙 카占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
			boolean flag2 = pstmt2.executeQuery().next(); // 占쌔댐옙 회占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙
			
			if(flag1) {
				
				if(flag2) {
					
					result = 3; // 占쌔댐옙 회占쏙옙占쏙옙 카占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙, 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙효占쏙옙.
					
				} else {
					
					result = 2; // 占쌔댐옙 회占쏙옙占쏙옙 카占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙, 占쏙옙占쏙옙占� 占쏙옙占쏙옙  占쏙옙.
					
				}
				
			} else {
				
				result = 1; // 占쌔댐옙 회占쏙옙占쏙옙 카占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙, 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙.
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		
		return result;
	}
	
	// 占쌔댐옙 회占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占� ArrayList<Bean> set
	public ArrayList<DelBean> getDelList(String u_idx) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DelBean bean = null;
		
		ArrayList<DelBean> list = new ArrayList<DelBean>();
		
		try {
			con = pool.getConnection();
			String sql = "select * from DEL_TB where d_u_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bean = new DelBean();
				bean.setD_idx(rs.getInt("d_idx"));
				bean.setD_u_idx(rs.getInt("d_u_idx"));
				bean.setD_ph(rs.getString("d_ph"));
				bean.setD_zipcode(rs.getString("d_zipcode"));
				bean.setD_addr(rs.getString("d_addr"));
				bean.setD_detail_addr(rs.getString("d_detail_addr"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		return list;
	}
	
	// DEL_TB占쏙옙 占쏙옙占쌘듸옙 bean set
	public DelBean getDel(String d_idx) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DelBean bean = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from DEL_TB where d_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new DelBean();
				bean.setD_idx(rs.getInt("d_idx"));
				bean.setD_u_idx(rs.getInt("d_u_idx"));
				bean.setD_ph(rs.getString("d_ph"));
				bean.setD_zipcode(rs.getString("d_zipcode"));
				bean.setD_addr(rs.getString("d_addr"));
				bean.setD_detail_addr(rs.getString("d_detail_addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		
		return bean;
	}
	
	// PAY_INFO_TB 占쏙옙占쌘듸옙 insert
	public void insertPayInfo(PayInfoBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "insert PAY_INFO_TB(pay_u_idx, card_no, card_valid"
					+ ", owner_birth, card_pwd, owner_ph)values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getPay_u_idx());
			pstmt.setString(2, bean.getCard_no());
			pstmt.setString(3, bean.getCard_valid());
			pstmt.setString(4, bean.getOwner_birth());
			pstmt.setString(5, bean.getCard_pwd());
			pstmt.setString(6, bean.getOwner_ph());
			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return;
	}
	
	// DEL_TB 占쏙옙占쌘듸옙 insert
	public Boolean insertDel(DelBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Boolean flag=false;
		
		try {
			con = pool.getConnection();
			String sql = "insert DEL_TB(d_u_idx, d_ph, d_zipcode, d_addr, d_detail_addr, d_nm)"
							+"values(?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getD_u_idx());
			pstmt.setString(2, bean.getD_ph());
			pstmt.setString(3, bean.getD_zipcode());
			pstmt.setString(4, bean.getD_addr());
			pstmt.setString(5, bean.getD_detail_addr());
			pstmt.setString(6, bean.getD_nm());
			
			if (pstmt.executeUpdate() == 1) {
				flag = true;
				System.out.println("del 占쏙옙占쏙옙");
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	// insertDel()占쏙옙占쏙옙 DEL_TB占쏙옙 insert占쏙옙  占쏙옙占쌘듸옙 d_idx 占쏙옙占�
		public int setDelidx(DelBean bean) {
			int d_idx = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = pool.getConnection();
				String sql = "select d_idx from DEL_TB where d_u_idx=? and d_ph=? and d_zipcode=? and d_addr=? and d_detail_addr=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bean.getD_u_idx());
				pstmt.setString(2, bean.getD_ph());
				pstmt.setString(3, bean.getD_zipcode());
				pstmt.setString(4, bean.getD_addr());
				pstmt.setString(5, bean.getD_detail_addr());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					d_idx = rs.getInt("d_idx");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con);
			}
			
			return d_idx;
		}
	
	// FUND_TB 占쏙옙占쌘듸옙 insert
	public Boolean insertFund(FundBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Boolean flag=false;
		
		try {
			con = pool.getConnection();
			String sql = "insert FUND_TB(f_dt, f_deadline, f_price, supmem_idx, f_pj_idx , f_p_idx, f_d_idx)"
							+"values(?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getF_dt());
			pstmt.setString(2, bean.getF_deadline());
			pstmt.setInt(3, bean.getF_price());
			pstmt.setInt(4, bean.getSupmem_idx());
			pstmt.setInt(5, bean.getF_pj_idx());
			pstmt.setInt(6, bean.getF_p_idx());
			pstmt.setInt(7, bean.getF_d_idx());
			
			if (pstmt.executeUpdate() == 1) {
				flag = true;
				System.out.println("fund 占쏙옙占쏙옙");}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	// insertFund()占쏙옙占쏙옙 FUND_TB占쏙옙 insert占쏙옙  占쏙옙占쌘듸옙 f_idx 占쏙옙占�
	public int setFundidx(FundBean bean) {
		int f_idx = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "select f_idx from FUND_TB where f_dt=? and f_deadline=? and f_price=? and supmem_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getF_dt());
			pstmt.setString(2, bean.getF_deadline());
			pstmt.setInt(3, bean.getF_price());
			pstmt.setInt(4, bean.getSupmem_idx());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				f_idx = rs.getInt("f_idx");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		
		return f_idx;
	}

	// PAY_TB 占쏙옙占쌘듸옙 insert
	public Boolean insertPay(PayBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Boolean flag=false;
		
		try {
			con = pool.getConnection();
			String sql = "insert PAY_TB(pay_price, pay_f_idx, pay_dt)"
							+"values(?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getPay_price());
			pstmt.setInt(2, bean.getPay_f_idx());
			pstmt.setString(3, bean.getPay_dt());
			
			if (pstmt.executeUpdate() == 1)
				flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	// 占식울옙 占싹뤄옙 占쏙옙 
	//  PJ_TB > (pj_sup_num ++) & (pj_s_price ++)
	public Boolean updateProject(ProjectBean bean, int u_idx) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Boolean flag = false;
		
		int f_price = 0;
		int s_price = 0;
		
		try {
			con = pool.getConnection();
			
			String sql1 = "select f_price from FUND_TB where f_pj_idx=? and supmem_idx=?"; // 占식울옙占쏙옙 占쌥억옙 select
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, bean.getPj_idx());
			pstmt1.setInt(2, u_idx);
			rs = pstmt1.executeQuery();
			if (rs.next()) {
				f_price = rs.getInt("f_price");
			}
			
			// 회占쏙옙占쏙옙 占식울옙占쏙옙 占쌥억옙 + 占쏙옙占쏙옙占쏙옙트 占쏙옙 占식울옙 占쌥억옙
			s_price = f_price + Integer.parseInt(bean.getPj_f_price());
			
			String sql2 = "update PJ_TB set pj_sup_num=?, pj_f_price=? where pj_idx=?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, bean.getPj_sup_num()+1); // 占식울옙占쌘쇽옙++
			pstmt2.setInt(2, s_price);
			pstmt2.setInt(3, bean.getPj_idx());
			
			if (pstmt2.executeUpdate() == 1)
				flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt1);
		}
		return flag;
	}
	
	// 占식울옙 占싹뤄옙 占쏙옙 
	// PRESENT_TB > (supmem_cnt ++)
	public Boolean updatePresent(PresentBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Boolean flag= false;
		
		try {
			con = pool.getConnection();
			String sql = "update PRESENT_TB set supmem_cnt=? where p_idx=?";
			System.out.println("移댁슫�듃: "+bean.getSupmem_cnt());
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getSupmem_cnt()+1);
			pstmt.setInt(2, bean.getP_idx());
			
			if (pstmt.executeUpdate() == 1)
				flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	   // �씠誘� �썑�썝�븳 �봽濡쒖젥�듃�씤吏� �솗�씤
	   public Boolean fundPjCheck(String pj_idx, String u_idx) {
		   
		   
	      Connection con = null;
	      PreparedStatement pstmt1 = null;
	      ResultSet rs = null;
	      Boolean flag = false;
	      ArrayList<Integer> flist = new ArrayList<Integer>();
	     
	      
	      
	      try {
	         con = pool.getConnection();
	         String sql1 = "select * from FUND_TB where supmem_idx=?";
	         pstmt1 = con.prepareStatement(sql1);
	         pstmt1.setString(1, u_idx);
	         rs = pstmt1.executeQuery();
	         while (rs.next()) {
	            flist.add(rs.getInt("f_pj_idx"));
	     
	         }
	         
	         for(int i=0; i<flist.size() ; i++) {
	        	 
	        	
	            if(Integer.parseInt(pj_idx) == flist.get(i)) {
	               flag = true;
	               break;
	               
	            } else {
	               flag = false;
	            }
	               
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         pool.freeConnection(con, pstmt1);
	      }
	   
	      return flag;
	   }

}
