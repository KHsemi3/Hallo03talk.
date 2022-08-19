package com.h3.party.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.h3.common.JDBCTemplate.*;


public class PartyDao {

	public int getCount(Connection conn) {
		
		String sql = "SELECT COUNT(NO) AS COUNT FROM PARTY WHERE STATUS = 'Y' AND PARTY_CATEGORY = 1";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			count = rs.getInt("COUNT");
		}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(rs);
		}

		
		
		return count;
		
		
	}
}	