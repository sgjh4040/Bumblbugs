package DAO;

import java.io.File;
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
import Bean.TempBean;
import Bean.UserBean;
import dbConnection.DBConnectionMgr;

public class MypageDAO {

	private DBConnectionMgr pool;

	public MypageDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//배송 테이블 전화번호 업데이트
	public boolean updateName(String d_idx, String d_nm) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "update del_tb set d_nm= ? where d_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d_nm);
			pstmt.setString(2, d_idx);
			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	
	//배송 테이블 전화번호 업데이트
	public boolean updatePhnum(String d_idx, String d_ph) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "update del_tb set d_ph= ? where d_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d_ph);
			pstmt.setString(2, d_idx);
			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//배송 테이블 배송주소 업데이트
		public boolean updateAddress(DelBean delbean) {
			Connection con = null;
			PreparedStatement pstmt = null;
			boolean flag = false;

			try {

				con = pool.getConnection();
				String sql = "update del_tb set d_zipcode= ?, d_addr=?, d_detail_addr=? where d_idx = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, delbean.getD_zipcode());
				pstmt.setString(2, delbean.getD_addr());
				pstmt.setString(3, delbean.getD_detail_addr());
				pstmt.setInt(4, delbean.getD_idx());
				int count = pstmt.executeUpdate();
				if (count > 0)
					flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
	
	
	
	
	
	
	public String getProjectImg(String pj_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String img = "";
		
		try {
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select pj_img from pj_tb where pj_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pj_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				img = rs.getString("pj_img");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return img;
		
	}

	
	public String getFundprice(String u_idx, String pj_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String price = "";
		
		try {
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select f_price from fund_tb where supmem_idx=? and f_pj_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			pstmt.setString(2, pj_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				price = rs.getString("f_price");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return price;
		
	}
	
	public boolean updatepjPrice(String price, String pj_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "update pj_tb set pj_f_price=pj_f_price+ ? where pj_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, price);
			pstmt.setString(2, pj_idx);

			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	public boolean deleteFund(String f_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "delete from fund_tb where f_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, f_idx);
			

			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	public boolean deletePay(String pay_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "delete from pay_tb where pay_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pay_idx);
			

			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	public void changePresent(String u_idx,  String pj_idx, String f_price,  String p_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = pool.getConnection();
			String sql = "UPDATE fund_tb SET f_price = ?,f_p_idx = ?  WHERE supmem_idx= ? and f_pj_idx= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, f_price);
			pstmt.setString(2, p_idx);
			pstmt.setString(3, u_idx);
			pstmt.setString(4, pj_idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		};

	}
	//PAY_tb 에서 결제금액 변경
	public void changePricePaytb(String f_idx, String pay_price) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = pool.getConnection();
			String sql = "UPDATE pay_tb SET pay_price = ? WHERE pay_f_idx=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pay_price);
			pstmt.setString(2, f_idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		};

	}
	
	
	
	// 선물 count up
	public void countupPresent(String p_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = pool.getConnection();
			String sql = "UPDATE present_tb SET supmem_cnt = supmem_cnt + 1 WHERE p_idx=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		};

	}
	// 선물 count down
	public void countdownPresent(String p_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = pool.getConnection();
			String sql = "UPDATE present_tb SET supmem_cnt = supmem_cnt - 1 WHERE p_idx=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		};

	}
	//프로젝트 테이블 count down
	public void countdownProject(String pj_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = pool.getConnection();
			String sql = "UPDATE pj_tb SET pj_sup_num = pj_sup_num - 1 WHERE pj_idx=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pj_idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		};

	}
	
	
	
	//지불정보 처음일떄 가입
	public boolean insertPayment(PayInfoBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {

			con = pool.getConnection();
			sql = "insert into pay_info_tb(pay_u_idx, pay_info_means, card_no, card_valid, owner_birth, card_pwd, owner_ph) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getPay_u_idx());
			pstmt.setString(2, bean.getPay_info_means());
			pstmt.setString(3, bean.getCard_no());
			pstmt.setString(4, bean.getCard_valid());
			pstmt.setString(5, bean.getOwner_birth());
			pstmt.setString(6, bean.getCard_pwd());
			pstmt.setString(7, bean.getOwner_ph());
			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	
	//지불정보 업데이트!
	public boolean updatePayment(PayInfoBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		System.out.println(bean.getCard_pwd());

		try {

			con = pool.getConnection();
			String sql = "update pay_info_tb set card_no=?, card_valid=?, owner_birth=? ,card_pwd= ?, owner_ph= ? where pay_u_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getCard_no());
			pstmt.setString(2, bean.getCard_valid());
			pstmt.setString(3, bean.getOwner_birth());
			pstmt.setString(4, bean.getCard_pwd());
			pstmt.setString(5, bean.getOwner_ph());
			pstmt.setInt(6, bean.getPay_u_idx());

			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	
	
	public boolean checkPayment(String pay_u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select pay_u_idx from pay_info_tb where pay_u_idx=?";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
					flag = true;
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	public PresentBean getPresent(String p_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PresentBean bean = new PresentBean();
		try {
			con = pool.getConnection();
			sql = "select * from present_TB where p_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setDue_dt(rs.getString("due_dt"));
				bean.setLimit_amount(rs.getInt("limit_amount"));
				bean.setMin_price(rs.getInt("min_price"));
				bean.setP_explain(rs.getString("p_explain"));
				bean.setP_idx(rs.getInt("p_idx"));
				bean.setP_nm(rs.getString("p_nm"));
				bean.setPj_p_idx(rs.getInt("pj_p_idx"));
				bean.setSupmem_cnt(rs.getInt("supmem_cnt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	

	public ProjectBean getProject(String pj_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ProjectBean bean = new ProjectBean();
		try {
			con = pool.getConnection();
			sql = "select * from PJ_TB where pj_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pj_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setPj_idx(rs.getInt("pj_idx"));
				bean.setPj_title(rs.getString("pj_title"));
				bean.setPj_short_title(rs.getString("pj_short_title"));
				bean.setPj_img(rs.getString("pj_img"));
				bean.setPj_summary(rs.getString("pj_summary"));
				bean.setPj_category(rs.getString("pj_category"));
				bean.setPj_url(rs.getString("pj_url"));
				bean.setSearch_tag(rs.getString("search_tag"));
				bean.setProfile_img(rs.getString("profile_img"));
				bean.setLeader_intro(rs.getString("leader_intro"));
				bean.setLeader_loc(rs.getString("leader_loc"));
				bean.setLeader_nm(rs.getString("leader_nm"));
				bean.setPj_end_dt(rs.getString("pj_end_dt"));
				bean.setPj_intro_video(rs.getString("pj_intro_video"));
				bean.setPj_sup_num(rs.getInt("pj_sup_num"));
				bean.setPj_u_idx(rs.getShort("pj_u_idx"));
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
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}

	public PayInfoBean getPayInfo(String pay_u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		PayInfoBean bean = new PayInfoBean();
		try {
			con = pool.getConnection();
			sql = "select * from pay_info_tb where pay_u_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pay_u_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setCard_no(rs.getString("card_no"));
				bean.setCard_pwd(rs.getString("card_pwd"));
				bean.setCard_valid(rs.getString("card_valid"));
				bean.setOwner_birth(rs.getString("owner_birth"));
				bean.setOwner_ph(rs.getString("owner_ph"));
				bean.setPay_info_idx(rs.getInt("pay_info_idx"));
				bean.setPay_info_means(rs.getString("pay_info_means"));
				bean.setPay_u_idx(rs.getInt("pay_u_idx"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}

	// 선물 테이블 정보 뽑아내기. 하나가 아닐수 있어서 Arraylist
	public ArrayList<PresentBean> getPresentList(String pj_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<PresentBean> list = new ArrayList<PresentBean>();
		try {
			con = pool.getConnection();
			sql = "select * from present_TB where pj_p_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pj_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PresentBean bean = new PresentBean();
				bean.setDue_dt(rs.getString("due_dt"));
				bean.setLimit_amount(rs.getInt("limit_amount"));
				bean.setMin_price(rs.getInt("min_price"));
				bean.setP_explain(rs.getString("p_explain"));
				bean.setP_idx(rs.getInt("p_idx"));
				bean.setP_nm(rs.getString("p_nm"));
				bean.setPj_p_idx(rs.getInt("pj_p_idx"));
				bean.setSupmem_cnt(rs.getInt("supmem_cnt"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	public ArrayList<TempBean> getTempProjectList(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<TempBean> list = new ArrayList<TempBean>();
		try {
			con = pool.getConnection();
			sql = "select * from temp_TB where tp_u_idx = ? and tp_st= '작성중'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TempBean bean = new TempBean();
				bean.setTp_ac_no("234");
				bean.setTp_ah(rs.getString("tp_ah"));
				bean.setTp_ah_birth(rs.getString("tp_ah_birth"));
				bean.setTp_bank_nm(rs.getString("tp_bank_nm"));
				bean.setTp_category(rs.getString("tp_category"));
				bean.setTp_end_dt(rs.getString("tp_end_dt"));
				bean.setTp_idx(rs.getInt("tp_idx"));
				bean.setTp_img(rs.getString("tp_img"));
				bean.setTp_intro_video(rs.getString("tp_intro_video"));
				bean.setTp_leader_intro(rs.getString("tp_leader_intro"));
				bean.setTp_leader_loc(rs.getString("tp_leader_loc"));
				bean.setTp_leader_nm(rs.getString("tp_leader_nm"));
				bean.setTp_obj_price(rs.getString("tp_obj_price"));
				bean.setTp_profile_img(rs.getString("tp_obj_price"));
				bean.setTp_reg_dt(rs.getString("tp_reg_dt"));
				bean.setTp_search_tag(rs.getString("tp_search_tag"));
				bean.setTp_short_title(rs.getString("tp_short_title"));
				bean.setTp_st(rs.getString("tp_st"));
				bean.setTp_story(rs.getString("tp_story"));
				bean.setTp_summary(rs.getString("tp_summary"));
				bean.setTp_title(rs.getString("tp_title"));
				bean.setTp_u_idx(rs.getInt("tp_u_idx"));
				bean.setTp_url(rs.getString("tp_url"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	
	

	//
	public ArrayList<ProjectBean> getProjectList(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<ProjectBean> list = new ArrayList<ProjectBean>();
		try {
			con = pool.getConnection();
			sql = "select * from PJ_TB where pj_u_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProjectBean bean = new ProjectBean();
				bean.setPj_idx(rs.getInt("pj_idx"));
				bean.setPj_title(rs.getString("pj_title"));
				bean.setPj_short_title(rs.getString("pj_short_title"));
				bean.setPj_img(rs.getString("pj_img"));
				bean.setPj_summary(rs.getString("pj_summary"));
				bean.setPj_category(rs.getString("pj_category"));
				bean.setPj_url(rs.getString("pj_url"));
				bean.setSearch_tag(rs.getString("search_tag"));
				bean.setProfile_img(rs.getString("profile_img"));
				bean.setLeader_intro(rs.getString("leader_intro"));
				bean.setLeader_loc(rs.getString("leader_loc"));
				bean.setLeader_nm(rs.getString("leader_nm"));
				bean.setPj_end_dt(rs.getString("pj_end_dt"));
				bean.setPj_intro_video(rs.getString("pj_intro_video"));
				bean.setPj_sup_num(rs.getInt("pj_sup_num"));
				bean.setPj_u_idx(rs.getShort("pj_u_idx"));
				bean.setPj_f_price(rs.getString("pj_f_price"));
				bean.setPj_story(rs.getString("pj_story"));
				bean.setObj_price(rs.getString("obj_price"));
				bean.setPj_reg_dt(rs.getString("pj_reg_dt"));
				bean.setAc_no(rs.getString("ac_no"));
				bean.setAh(rs.getString("ah"));
				bean.setBank_nm(rs.getString("bank_nm"));
				bean.setAh_birth(rs.getString("ah_birth"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<FundBean> getUserFundList(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<FundBean> list = new ArrayList<FundBean>();
		try {
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select * from FUND_TB where supmem_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FundBean bean = new FundBean();
				bean.setF_d_idx(rs.getInt("f_d_idx"));
				bean.setF_d_idx(rs.getInt("f_d_idx"));
				bean.setF_deadline(rs.getString("f_deadline"));
				bean.setF_dt(rs.getString("f_dt"));
				bean.setF_idx(rs.getInt("f_idx"));
				bean.setF_p_idx(rs.getInt("f_p_idx"));
				bean.setF_pj_idx(rs.getInt("f_pj_idx"));
				bean.setF_price(rs.getInt("f_price"));
				bean.setSupmem_idx(rs.getInt("supmem_idx"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	// 마이페이지-> 나의 후원 현황에 쓰인다. 회원 idx를 이용하여 회원 프로젝트를 다 불러오는 메소드

	public ArrayList<FundBean> getFundBox(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<FundBean> list = new ArrayList<FundBean>();
		try {
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select FT.f_pj_idx, FT.f_dt , FT.f_price , FT.f_idx ,PET.p_nm, PET.p_explain ,PT.pj_end_dt,PT.obj_price, PT.pj_f_price, PT.pj_title, PT.pj_img from PJ_TB PT Inner Join Fund_TB FT on PT.pj_idx = FT.f_pj_idx Inner Join PRESENT_TB PET on FT.f_p_idx = PET.p_idx where FT.supmem_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FundBean Fundbean = new FundBean();
				ProjectBean Projectbean = new ProjectBean();
				PresentBean Presentbean = new PresentBean();
				Fundbean.setF_pj_idx(rs.getInt("f_pj_idx"));
				Fundbean.setF_dt(rs.getString("f_dt"));
				Fundbean.setF_price(rs.getInt("f_price"));
				Fundbean.setF_idx(rs.getInt("f_idx"));
				///// 프로젝트 제목, 이미지 ///////
				Projectbean.setPj_title(rs.getString("pj_title"));
				Projectbean.setPj_img(rs.getString("pj_img"));
				Projectbean.setPj_f_price(rs.getString("pj_f_price"));
				Projectbean.setObj_price(rs.getString("obj_price"));
				Projectbean.setPj_end_dt(rs.getString("pj_end_dt"));
				Fundbean.setProjectbean(Projectbean);
				////// 선물소개/////////////////
				Presentbean.setP_explain(rs.getString("p_explain"));
				Presentbean.setP_nm(rs.getString("p_nm"));
				Fundbean.setPresentbean(Presentbean);

				list.add(Fundbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<FundBean> getFundBoxing(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<FundBean> list = new ArrayList<FundBean>();
		try {
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select FT.f_pj_idx, FT.f_dt , FT.f_price , FT.f_idx ,PET.p_nm, PET.p_explain ,PT.pj_end_dt,PT.obj_price, PT.pj_f_price, PT.pj_title, PT.pj_img from PJ_TB PT Inner Join Fund_TB FT on PT.pj_idx = FT.f_pj_idx Inner Join PRESENT_TB PET on FT.f_p_idx = PET.p_idx where FT.supmem_idx = ? AND PT.pj_end_dt >= now()";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FundBean Fundbean = new FundBean();
				ProjectBean Projectbean = new ProjectBean();
				PresentBean Presentbean = new PresentBean();
				Fundbean.setF_pj_idx(rs.getInt("f_pj_idx"));
				Fundbean.setF_dt(rs.getString("f_dt"));
				Fundbean.setF_price(rs.getInt("f_price"));
				Fundbean.setF_idx(rs.getInt("f_idx"));
				///// 프로젝트 제목, 이미지 ///////
				Projectbean.setPj_title(rs.getString("pj_title"));
				Projectbean.setPj_img(rs.getString("pj_img"));
				Projectbean.setPj_f_price(rs.getString("pj_f_price"));
				Projectbean.setObj_price(rs.getString("obj_price"));
				Projectbean.setPj_end_dt(rs.getString("pj_end_dt"));
				Fundbean.setProjectbean(Projectbean);
				////// 선물소개/////////////////
				Presentbean.setP_explain(rs.getString("p_explain"));
				Presentbean.setP_nm(rs.getString("p_nm"));
				Fundbean.setPresentbean(Presentbean);

				list.add(Fundbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	public ArrayList<FundBean> getFundBoxend(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<FundBean> list = new ArrayList<FundBean>();
		try {
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select FT.f_pj_idx, FT.f_dt , FT.f_price , FT.f_idx ,PET.p_nm, PET.p_explain ,PT.pj_end_dt,PT.obj_price, PT.pj_f_price, PT.pj_title, PT.pj_img from PJ_TB PT Inner Join Fund_TB FT on PT.pj_idx = FT.f_pj_idx Inner Join PRESENT_TB PET on FT.f_p_idx = PET.p_idx where FT.supmem_idx = ? AND PT.pj_end_dt < now()";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FundBean Fundbean = new FundBean();
				ProjectBean Projectbean = new ProjectBean();
				PresentBean Presentbean = new PresentBean();
				Fundbean.setF_pj_idx(rs.getInt("f_pj_idx"));
				Fundbean.setF_dt(rs.getString("f_dt"));
				Fundbean.setF_price(rs.getInt("f_price"));
				Fundbean.setF_idx(rs.getInt("f_idx"));
				///// 프로젝트 제목, 이미지 ///////
				Projectbean.setPj_title(rs.getString("pj_title"));
				Projectbean.setPj_img(rs.getString("pj_img"));
				Projectbean.setPj_f_price(rs.getString("pj_f_price"));
				Projectbean.setObj_price(rs.getString("obj_price"));
				Projectbean.setPj_end_dt(rs.getString("pj_end_dt"));
				Fundbean.setProjectbean(Projectbean);
				////// 선물소개/////////////////
				Presentbean.setP_explain(rs.getString("p_explain"));
				Presentbean.setP_nm(rs.getString("p_nm"));
				Fundbean.setPresentbean(Presentbean);

				list.add(Fundbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	
	public ArrayList<ProjectBean> getSearchAJAX(String pj_title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<ProjectBean> list1 = new ArrayList<ProjectBean>();

		if (pj_title == "" || pj_title == null) {
			return list1;
		}

		ArrayList<ProjectBean> list = new ArrayList<ProjectBean>();
		try {
			String like = "%" + pj_title + "%";
			System.out.println(like);
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select pj_title, pj_idx from pj_tb where pj_title like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, like);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProjectBean Projectbean = new ProjectBean();
				
				Projectbean.setPj_title(rs.getString("pj_title"));
				Projectbean.setPj_idx(rs.getInt("pj_idx"));
				list.add(Projectbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	
	
	
	

	public ArrayList<FundBean> getSearchFundBox(String u_idx, String pj_title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		System.out.println(pj_title);
		if (pj_title == "") {
			return null;
		}

		ArrayList<FundBean> list = new ArrayList<FundBean>();
		try {
			String like = "%" + pj_title + "%";
			System.out.println(like);
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select FT.f_pj_idx, FT.f_dt , FT.f_price , FT.f_idx , PET.p_explain,PET.p_nm ,PT.pj_end_dt,PT.obj_price, PT.pj_f_price, PT.pj_title, PT.pj_img from PJ_TB PT Inner Join Fund_TB FT on PT.pj_idx = FT.f_pj_idx Inner Join PRESENT_TB PET on FT.f_p_idx = PET.p_idx where FT.supmem_idx = ? and PT.pj_title like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			pstmt.setString(2, like);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FundBean Fundbean = new FundBean();
				ProjectBean Projectbean = new ProjectBean();
				PresentBean Presentbean = new PresentBean();
				Fundbean.setF_pj_idx(rs.getInt("f_pj_idx"));
				Fundbean.setF_dt(rs.getString("f_dt"));
				Fundbean.setF_price(rs.getInt("f_price"));
				Fundbean.setF_idx(rs.getInt("f_idx"));
				///// 프로젝트 제목, 이미지 ///////
				Projectbean.setPj_title(rs.getString("pj_title"));
				Projectbean.setPj_img(rs.getString("pj_img"));
				Projectbean.setPj_f_price(rs.getString("pj_f_price"));
				Projectbean.setObj_price(rs.getString("obj_price"));
				Projectbean.setPj_end_dt(rs.getString("pj_end_dt"));
				Fundbean.setProjectbean(Projectbean);
				////// 선물소개/////////////////
				Presentbean.setP_explain(rs.getString("p_explain"));
				Presentbean.setP_nm(rs.getString("p_nm"));
				Fundbean.setPresentbean(Presentbean);

				list.add(Fundbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	
	//선물 , pay , fund table 필요
	public ArrayList<FundBean> getFunddetailBox(String u_idx, String f_pj_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<FundBean> list = new ArrayList<FundBean>();
		try {
			con = pool.getConnection();
			// 펀드 table에서 후원자 Idx 일치하는 행
			sql = "select FT.f_deadline, FT.f_dt , FT.f_price ,FT.f_d_idx, FT.f_idx ,PET.p_idx, PET.p_explain ,PET.due_dt,PT.pay_idx, PT.pay_means, PT.pay_price, PT.pay_dt from pay_TB PT Inner Join Fund_TB FT on PT.pay_f_idx = FT.f_idx Inner Join PRESENT_TB PET on FT.f_p_idx = PET.p_idx where FT.supmem_idx = ? and FT.f_pj_idx= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			pstmt.setString(2, f_pj_idx);
			rs = pstmt.executeQuery();

			int f_d_idx = 0;
			if (rs.next()) {
				FundBean Fundbean = new FundBean();
				PayBean Paybean = new PayBean();
				PresentBean Presentbean = new PresentBean();
				DelBean Delbean = new DelBean();

				// Fund table 정보
				Fundbean.setF_deadline(rs.getString("f_deadline"));
				Fundbean.setF_dt(rs.getString("f_dt"));
				Fundbean.setF_price(rs.getInt("f_price"));
				f_d_idx = rs.getInt("f_d_idx");
				Fundbean.setF_d_idx(rs.getInt("f_d_idx"));
				Fundbean.setF_idx(rs.getInt("f_idx"));
				///// 결제 table ///////
				Paybean.setPay_means(rs.getString("pay_means"));
				Paybean.setPay_price(rs.getInt("pay_price"));
				Paybean.setPay_dt(rs.getString("pay_dt"));
				Paybean.setPay_idx(rs.getInt("pay_idx"));
				Fundbean.setPaybean(Paybean);
				////// 선물table/////////////////
				Presentbean.setP_explain(rs.getString("p_explain"));
				Presentbean.setDue_dt(rs.getString("due_dt"));
				Presentbean.setP_idx(rs.getInt("p_idx"));
				Fundbean.setPresentbean(Presentbean);

				sql = "select * from DEL_TB where d_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, f_d_idx);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					Delbean.setD_addr(rs.getString("d_addr"));
					Delbean.setD_detail_addr(rs.getString("d_detail_addr"));
					Delbean.setD_idx(rs.getInt("d_idx"));
					Delbean.setD_ph(rs.getString("d_ph"));
					Delbean.setD_u_idx(rs.getInt("d_u_idx"));
					Delbean.setD_zipcode(rs.getString("d_zipcode"));
					Delbean.setD_nm(rs.getString("d_nm"));
					Fundbean.setDelbean(Delbean);
					list.add(Fundbean);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	public void deleteTemp(String tp_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "delete from temp_tb where tp_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tp_idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	public void deleteTempPresent(String tp_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "delete from temp_present_tb where tp_pj_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tp_idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}



}
