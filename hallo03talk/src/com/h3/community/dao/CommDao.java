package com.h3.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.h3.common.JDBCTemplate.*;
import com.h3.community.vo.CommVo;
import com.h3.with.vo.PageVo;

public class CommDao {

	public ArrayList<CommVo> getlist(Connection conn, PageVo pageVo, String sort, String view) throws Exception {
		ArrayList<CommVo> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		String plusSql = "";

		if(view == null || "all".equals(view) || "".equals(view)) {
			if("v".equals(sort)) {
				sql = "SELECT * FROM \r\n"
						+ "    (SELECT ROWNUM AS RNUM ,S.* FROM \r\n"
						+ "        (SELECT * FROM\r\n"
						+ "            (SELECT C.NO, C.TITLE, C.CONTENT, C.ENROLL_DATE, C.MODIFY_DATE, C.CNT, T.NICK AS WRITER, T.STATUS, CA.NAME AS CATEGORY \r\n"
						+ "                FROM COMMUNITY C JOIN TRAVELER T ON C.WRITER = T.NO JOIN COMMUNITY_CATEGORY CA ON C.CATEGORY_NO = CA.NO \r\n"
						+ "                WHERE C.STATUS = 'Y' AND CA.NAME = 'notice'\r\n"
						+ "                ORDER BY C.CNT DESC)\r\n"
						+ "                \r\n"
						+ "                union ALL\r\n"
						+ "                \r\n"
						+ "                SELECT * FROM\r\n"
						+ "                (SELECT C.NO, C.TITLE, C.CONTENT, C.ENROLL_DATE, C.MODIFY_DATE, C.CNT, T.NICK AS WRITER, T.STATUS, CA.NAME AS CATEGORY \r\n"
						+ "                FROM COMMUNITY C JOIN TRAVELER T ON C.WRITER = T.NO JOIN COMMUNITY_CATEGORY CA ON C.CATEGORY_NO = CA.NO \r\n"
						+ "                WHERE C.STATUS = 'Y' AND CA.NAME != 'notice'\r\n"
						+ "                ORDER BY C.CNT DESC\r\n"
						+ "            )\r\n"
						+ "        ) S\r\n"
						+ "    ) SU \r\n"
						+ "WHERE SU.RNUM BETWEEN ? AND ?";
			
			}else {
				sql = "SELECT * FROM \r\n"
						+ "    (SELECT ROWNUM AS RNUM ,S.* FROM \r\n"
						+ "        (SELECT * FROM\r\n"
						+ "            (SELECT C.NO, C.TITLE, C.CONTENT, C.ENROLL_DATE, C.MODIFY_DATE, C.CNT, T.NICK AS WRITER, T.STATUS, CA.NAME AS CATEGORY \r\n"
						+ "                FROM COMMUNITY C JOIN TRAVELER T ON C.WRITER = T.NO JOIN COMMUNITY_CATEGORY CA ON C.CATEGORY_NO = CA.NO \r\n"
						+ "                WHERE C.STATUS = 'Y' AND CA.NAME = 'notice'\r\n"
						+ "                ORDER BY C.ENROLL_DATE DESC)\r\n"
						+ "                union ALL\r\n"
						+ "                SELECT * FROM\r\n"
						+ "                (SELECT C.NO, C.TITLE, C.CONTENT, C.ENROLL_DATE, C.MODIFY_DATE, C.CNT, T.NICK AS WRITER, T.STATUS, CA.NAME AS CATEGORY \r\n"
						+ "                FROM COMMUNITY C JOIN TRAVELER T ON C.WRITER = T.NO JOIN COMMUNITY_CATEGORY CA ON C.CATEGORY_NO = CA.NO \r\n"
						+ "                WHERE C.STATUS = 'Y' AND CA.NAME != 'notice'\r\n"
						+ "                ORDER BY C.ENROLL_DATE DESC\r\n"
						+ "            )\r\n"
						+ "        ) S\r\n"
						+ "    ) SU \r\n"
						+ "WHERE SU.RNUM BETWEEN ? AND ?";
			}
		}else {
			plusSql = "AND CA.NAME = '" + view + "'";
			if("v".equals(sort)) {
				sql = "SELECT * FROM (SELECT ROWNUM AS RNUM ,S.* FROM (SELECT C.NO, C.TITLE, C.CONTENT, C.ENROLL_DATE, C.MODIFY_DATE, C.CNT, T.NICK AS WRITER, T.STATUS, CA.NAME AS CATEGORY FROM COMMUNITY C JOIN TRAVELER T ON C.WRITER = T.NO JOIN COMMUNITY_CATEGORY CA ON C.CATEGORY_NO = CA.NO WHERE C.STATUS = 'Y' "
						+ plusSql +" ORDER BY c.cnt DESC) S) SU WHERE SU.RNUM BETWEEN ? AND ?";
			}else {
				sql = "SELECT * FROM (SELECT ROWNUM AS RNUM ,S.* FROM (SELECT C.NO, C.TITLE, C.CONTENT, C.ENROLL_DATE, C.MODIFY_DATE, C.CNT, T.NICK AS WRITER, T.STATUS, CA.NAME AS CATEGORY FROM COMMUNITY C JOIN TRAVELER T ON C.WRITER = T.NO JOIN COMMUNITY_CATEGORY CA ON C.CATEGORY_NO = CA.NO WHERE C.STATUS = 'Y' "
						+ plusSql +" ORDER BY c.enroll_date DESC) S) SU WHERE SU.RNUM BETWEEN ? AND ?";			
			}
		}
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
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

	
	public int getCount(Connection conn, String view) {

		String plusSql = "";
		
		if(view == null || "all".equals(view) || "".equals(view)) {
			plusSql = "";
		}else if("notice".equals(view)){
			plusSql = "AND CATEGORY_NO = 1";
		}else if("qna".equals(view)){
			plusSql = "AND CATEGORY_NO = 2";
		}else if("free".equals(view)){
			plusSql = "AND CATEGORY_NO = 3";
		}
		
		String sql = "SELECT COUNT(NO) AS COUNT FROM COMMUNITY WHERE STATUS = 'Y' " + plusSql;
		

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return count;
	}


	public int post(Connection conn, CommVo vo) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO COMMUNITY VALUES(SEQ_COMMUNITY_NO.NEXTVAL, ?,?,SYSDATE, SYSDATE,DEFAULT, ?, DEFAULT, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, getCategoryNumber(conn, vo.getCategory()));
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int getCategoryNumber(Connection conn, String categoryName) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM COMMUNITY_CATEGORY WHERE NAME = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, categoryName);
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			result = rs.getInt("NO");
		}else {
			result = 0;
		}
		return result;
	}

}
