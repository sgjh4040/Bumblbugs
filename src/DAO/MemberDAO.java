package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;


import com.oreilly.servlet.MultipartRequest;

import Bean.PayInfoBean;
import Bean.PresentBean;
import Bean.UserBean;
import dbConnection.DBConnectionMgr;

public class MemberDAO {

	private DBConnectionMgr pool;

	public MemberDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<UserBean> listMember() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<UserBean> list = new ArrayList<UserBean>();
		try {
			con = pool.getConnection();
			sql = "select * from user_TB ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				UserBean bean= new UserBean();
				bean.setNews_sub_tf(rs.getInt("news_sub_tf"));
				bean.setSns_con_tf(rs.getInt("sns_con_tf"));
				bean.setU_email(rs.getString("u_email"));
				bean.setU_idx(rs.getInt("u_idx"));
				bean.setU_img(rs.getString("u_img"));
				bean.setU_intro(rs.getString("u_intro"));
				bean.setU_loc(rs.getString("u_loc"));
				bean.setU_nm(rs.getString("u_nm"));
				bean.setU_ph(rs.getString("u_ph"));
				bean.setU_website(rs.getString("u_website"));
				bean.setU_pwd(rs.getString("u_pwd"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	};
	public ArrayList<UserBean> listMember(int start, int end) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		ArrayList<UserBean> list = new ArrayList<UserBean>();
		try {
			con = pool.getConnection();
			sql = "select * from user_TB limit ? , ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				UserBean bean= new UserBean();
				bean.setNews_sub_tf(rs.getInt("news_sub_tf"));
				bean.setSns_con_tf(rs.getInt("sns_con_tf"));
				bean.setU_email(rs.getString("u_email"));
				bean.setU_idx(rs.getInt("u_idx"));
				bean.setU_img(rs.getString("u_img"));
				bean.setU_intro(rs.getString("u_intro"));
				bean.setU_loc(rs.getString("u_loc"));
				bean.setU_nm(rs.getString("u_nm"));
				bean.setU_ph(rs.getString("u_ph"));
				bean.setU_website(rs.getString("u_website"));
				bean.setU_pwd(rs.getString("u_pwd"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	};
	
	
	public boolean modMember(UserBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "update user_tb set u_nm=?, u_email=?, u_pwd=? ,u_loc= ?, u_intro= ? where u_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getU_nm());
			pstmt.setString(2, bean.getU_email());
			pstmt.setString(3, bean.getU_pwd());
			pstmt.setString(4, bean.getU_loc());
			pstmt.setString(5, bean.getU_intro());
			pstmt.setInt(6, bean.getU_idx());
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
	
	

	public boolean updateProfile(UserBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "update user_tb set u_img=?, u_nm=?, u_loc=? ,sns_con_tf= ?, u_intro= ?, u_website= ?, u_ph= ? where u_idx = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getU_img());
			pstmt.setString(2, bean.getU_nm());
			pstmt.setString(3, bean.getU_loc());
			pstmt.setInt(4, bean.getSns_con_tf());
			pstmt.setString(5, bean.getU_intro());
			pstmt.setString(6, bean.getU_website());
			pstmt.setString(7, bean.getU_ph());
			pstmt.setInt(8, bean.getU_idx());
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

	public boolean updateAccount(UserBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;

		try {

			con = pool.getConnection();
			String sql = "update user_tb set u_email=?, u_pwd=?, sns_con_tf= ?, news_sub_tf= ? where u_idx = ?";
			System.out.println("1" + bean.getU_email());
			System.out.println("2" + bean.getU_pwd());
			System.out.println("3" + bean.getSns_con_tf());
			System.out.println("4" + bean.getNews_sub_tf());
			System.out.println("5" + bean.getU_idx());

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getU_email());
			pstmt.setString(2, bean.getU_pwd());
			pstmt.setInt(3, bean.getSns_con_tf());
			pstmt.setInt(4, bean.getNews_sub_tf());
			pstmt.setInt(5, bean.getU_idx());
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

	// 회원 정보 뽑아내는 method
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

	public boolean checkEmail(String u_email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select u_email from user_tb";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String email = rs.getString("u_email");
				if (email.equals(u_email)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}

	public boolean insertMember(UserBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {

			con = pool.getConnection();
			sql = "insert into user_tb(u_nm, u_pwd, u_email) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getU_nm());
			pstmt.setString(2, bean.getU_pwd());
			pstmt.setString(3, bean.getU_email());
			
			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	public boolean delMember(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {

			con = pool.getConnection();
			sql = "delete from user_tb where u_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			
			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	// id 패스워드 DB에 있는지 확인
	public boolean loginMember(String u_email, String u_pwd) {
		System.out.println(u_email);
		System.out.println(u_pwd);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select u_nm from user_tb where u_email = ? and u_pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_email);
			pstmt.setString(2, u_pwd);
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}

	// 이메일을 이용해 u_idx 나오게 하는 메소드
	public String getUserIdx(String u_email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String u_idx = "";

		try {
			con = pool.getConnection();
			sql = "select u_Idx from user_tb where u_email = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u_idx = rs.getString("u_idx");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return u_idx;

	}

	public String getUserNM(String u_email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String u_nm = "";

		try {
			con = pool.getConnection();
			sql = "select u_nm from user_tb where u_email = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u_nm = rs.getString("u_nm");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return u_nm;

	}

	public String getUserImg(String u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String u_img = "";

		try {
			con = pool.getConnection();
			sql = "select u_img from user_tb where u_idx = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u_img = rs.getString("u_img");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return u_img;

	}

}