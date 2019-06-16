package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.TagBean;
import dbConnection.DBConnectionMgr;

public class TagDAO {
	private DBConnectionMgr pool;

	public TagDAO() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setTag(TagBean tagBean) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tag_tb(tag_nm, pj_tag_idx) values (?, ?);";
		
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tagBean.getTag_nm());
			pstmt.setInt(2, tagBean.getPj_tag_idx());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
}
