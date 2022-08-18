package com.h3.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.h3.common.JDBCTemplate.*;
import com.h3.community.vo.CommVo;

public class CommDao {

	public ArrayList<CommVo> getlist(Connection conn) throws Exception {
		ArrayList<CommVo> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT C.NO, C.TITLE, C.CONTENT, C.ENROLL_DATE, C.MODIFY_DATE, C.CNT, T.NICK AS WRITER, T.STATUS, CA.NAME AS CATEGORY FROM COMMUNITY C JOIN TRAVELER T ON C.WRITER = T.NO JOIN COMMUNITY_CATEGORY CA ON C.CATEGORY_NO = CA.NO WHERE C.STATUS = 'Y' ORDER BY c.enroll_date DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<CommVo>();
			
			while(rs.next()) {
				
				CommVo vo = new CommVo();
				
				vo.setNo(rs.getString("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setEnroll_date(rs.getTimestamp("ENROLL_DATE"));
				vo.setModify_date(rs.getTimestamp("MODIFY_DATE"));
				vo.setCnt(rs.getInt("CNT"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setStatus(rs.getString("STATUS"));
				vo.setCategory(rs.getString("CATEGORY"));
				
				result.add(vo);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}

}
