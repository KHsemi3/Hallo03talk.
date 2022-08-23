package com.h3.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.h3.common.JDBCTemplate.*;

public class CommReplyDao {

	public int delete(Connection conn, String commNo, String replyNo) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FORM REPLY WHERE NO = ? AND COMMUNITY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyNo);
			pstmt.setString(2, commNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
