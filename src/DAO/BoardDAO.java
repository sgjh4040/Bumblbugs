package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Bean.BoardBeans;
import dbConnection.DBConnectionMgr;

public class BoardDAO {
	private DBConnectionMgr pool;

	public BoardDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getImg(String b_u_idx) {
		String img = null;
		String sql = "select u_img from user_tb where u_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_u_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				img = rs.getString("u_img");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}

		return img;
	}

	public String getContent(String b_idx) {
		String content = null;
		String sql = "select b_content from notice_tb where b_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("내용을 가져올 게시글의 b_idx : " + b_idx);
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				content = rs.getString("b_content");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}

		return content;
	}

	public int deleteBoard(String b_idx) {
		String sql = "delete from notice_tb where b_idx=?;";
		int result = -1;
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			result = pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
		return result;
	}

	public int updateBoard(String b_idx, String b_content) {
		String sql = "update notice_tb set b_content = ? where b_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;

		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_content);
			pstmt.setString(2, b_idx);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}

		return -1;
	}

	   public int getDate(String b_time) { 
		      
		      String[] splitDate = null;
		      System.out.println("db에 저장된 날짜 : " + b_time);
		      b_time = b_time.trim();
		      int yY = 0;
		      int mM = 0;
		      int dD = 0;
		      splitDate = b_time.split("-");
		      
		      // 디버그      

		      if(splitDate[1].substring(0, 1).equals("0")) {
		         splitDate[1] = splitDate[1].substring(1,2);
		         System.out.println(splitDate[1]);
		      }
		      if(splitDate[2].substring(0, 1).equals("0")) {
		         splitDate[2] = splitDate[2].substring(1,2);
		         System.out.println(splitDate[2]);
		      }
		      yY = Integer.parseInt(splitDate[0]);
		      mM = Integer.parseInt(splitDate[1]);
		      dD = Integer.parseInt(splitDate[2]);
		      //날짜 계산
		      
		      //현재 시간
		      Calendar endDay = Calendar.getInstance ( );
		      endDay.add(Calendar.MONTH, 1);
		      
		      //Db에 저장된 시간
		      Calendar startDay = Calendar.getInstance ( );
		      startDay.set ( yY, mM, dD); // 기준일로 설정. month의 경우 해당월수-1을 해줍니다.
		      
		      //현재시간
		      System.out.println("현재시간 : " + endDay.get(Calendar.YEAR)+ "년" + endDay.get(Calendar.MONTH) + "월" + endDay.get(Calendar.DATE) + "일");
		      //DB에 저장된 시간
		      System.out.println("DB에 저장된 날짜 : " + yY+ "년" + mM + "월" + dD + "일");   
		      
		      
		      int count = 0;
		      boolean result = !endDay.before ( startDay );
		      System.out.println("결과는 " + result);
		      while (startDay.before(endDay))
		      {
		      
		      count++;
		      System.out.println(count);
		      startDay.add ( Calendar.DATE, 1 ); // 다음날로 바뀜
		      System.out.println("날짜는 ? " + startDay.get(Calendar.DATE));
		      
		      }

		      System.out.println ( "기준일로부터 " + count + "일이 지났습니다." );

		      return count; 
		   }

	public int write(String b_content, String b_u_idx, String b_pj_idx) {
		String SQL = "insert into notice_tb (b_content, b_pj_idx, b_u_idx) values (?,?,?);";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, b_content);
			pstmt.setString(2, b_pj_idx);
			pstmt.setString(3, b_u_idx);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt);
		}
		return -1;
	}

	public String getName(String u_idx) {
		String name = null;
		String sql = "select u_nm from user_tb where u_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("게시판을 작성한 회원의 번호는" + u_idx);
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("u_nm");

			}

			return name;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}

		return "";

	}

	public ArrayList<BoardBeans> getBoard(String b_idx) {
		ArrayList<BoardBeans> list = new ArrayList<BoardBeans>();
		String SQL = "SELECT b_content, b_u_idx, b_time from notice_tb where b_idx = ?;";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// String b_idxs = Integer.toString(b_idx);
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBeans bbs = new BoardBeans();

				bbs.setB_content(rs.getString(1));
				bbs.setB_u_idx(rs.getInt(2));
				bbs.setB_time(rs.getString(3));

				list.add(bbs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return list;
	}

	public ArrayList<BoardBeans> getList(int b_pj_idx) {

		String SQL = "SELECT b_idx, b_content, b_u_idx, b_time FROM NOTICE_TB WHERE b_pj_idx = ? ORDER BY b_time DESC LIMIT 10";
		Connection conn = null; // connection:db에접근하게 해주는 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBeans> list = new ArrayList<BoardBeans>();
		String b_pj_idxS = Integer.toString(b_pj_idx);
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, b_pj_idxS);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				BoardBeans bbs = new BoardBeans();

				bbs.setB_idx(rs.getInt(1));

				bbs.setB_content(rs.getString(2));

				bbs.setB_u_idx(rs.getInt(3));

				bbs.setB_time(rs.getString(4));

				list.add(bbs);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}finally {
			pool.freeConnection(conn, pstmt, rs);
		}

		return list;

	}

}
