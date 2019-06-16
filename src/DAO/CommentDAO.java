package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.CommentBeans;
import dbConnection.DBConnectionMgr;


public class CommentDAO {
	private DBConnectionMgr pool;
	public CommentDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	   public String getImg(String c_u_idx) {
		      String img = null;
		      String sql = "select u_img from user_tb where u_idx = ?;";
		      Connection conn = null; // connection:db에접근하게 해주는 객체
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      
		      try {
		         conn=pool.getConnection();
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, c_u_idx);
		         rs = pstmt.executeQuery();
		         if(rs.next()) {
		            img = rs.getString("u_img");
		         }
		      }catch(Exception e) {
		         e.printStackTrace();
		      }finally {
					pool.freeConnection(conn, pstmt, rs);
				}
		      
		      return img;
		   }
	
	
	public int getCommentCnt(String b_idx) {
		int count = 0;
		String sql = "select count(c_idx) as c_cnt from comments_tb where c_b_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return count;
	}
	
	public String getName(String u_idx) {
		String name = null;
		String sql = "select u_nm from user_tb where u_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("댓글단 유저의 idx : " + u_idx);
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("u_nm");
				
			}
			
			return name;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		
		return "";
		
	}
	
	public int writeComment(String c_content, String c_u_idx, String c_b_idx) {
		String SQL = "insert into comments_tb (c_content, c_u_idx, c_b_idx) values (?,?,?);";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		System.out.println("쓰기위해 넘겨받은 게시판 idx : " +c_b_idx);
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, c_content);
			pstmt.setString(2, c_u_idx);
			pstmt.setString(3, c_b_idx);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
		return -1;
	}
	
	public ArrayList<CommentBeans> getComments(String b_idx){
		ArrayList<CommentBeans> list = new ArrayList<CommentBeans>();
		String sql = "select c_content, c_u_idx, c_dt from comments_tb where c_b_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentBeans cbs = new CommentBeans();
				cbs.setC_content(rs.getString(1));
				cbs.setC_u_idx(rs.getInt(2));
				cbs.setC_dt(rs.getString(3));
				list.add(cbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return list;
	}
	
}
