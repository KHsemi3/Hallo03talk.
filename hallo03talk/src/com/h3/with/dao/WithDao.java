package com.h3.with.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.h3.common.JDBCTemplate.*;
import com.h3.with.vo.WithVo;

public class WithDao {

	public ArrayList<WithVo> getList(Connection conn) throws Exception {
		ArrayList<WithVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT W.NO, W.TITLE, W.CONTENT, W.TAG, W.ENROLL_DATE, W.STATUS, W.START_DATE, W.END_DATE, W.INSTA, T.NICK AS TRAVELER_NO, W.CNT, W.PLACE FROM WITH_ W JOIN traveler T ON W.TRAVELER_NO = T.NO ORDER BY ENROLL_DATE DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WithVo vo = new WithVo();
				vo.setNo(rs.getString("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setTag(rs.getString("TAG").split(","));
				vo.setEnroll_date(rs.getTimestamp("ENROLL_DATE"));
				vo.setStatus(rs.getString("STATUS"));
				vo.setStart_date(rs.getDate("START_DATE"));
				vo.setEnd_date(rs.getDate("END_DATE"));
				vo.setInsta(rs.getString("INSTA"));
				vo.setTraveler_no(rs.getString("TRAVELER_NO"));
				vo.setCnt(rs.getString("CNT"));
				vo.setPlace(rs.getString("PLACE"));
				
				result.add(vo);  
			}
			
			
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	
	public WithVo getOne(Connection conn, String no) throws Exception {
		WithVo result = new WithVo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT W.NO, W.TITLE, W.CONTENT, W.TAG, W.ENROLL_DATE, W.STATUS, W.START_DATE, W.END_DATE, W.INSTA, T.NICK AS TRAVELER_NO, W.CNT, W.PLACE FROM WITH_ W JOIN traveler T ON W.TRAVELER_NO = T.NO WHERE W.NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new WithVo();
				result.setNo(rs.getString("NO"));
				result.setTitle(rs.getString("TITLE"));
				result.setContent(rs.getString("CONTENT"));
				result.setTag(rs.getString("TAG").split(","));
				result.setEnroll_date(rs.getTimestamp("ENROLL_DATE"));
				result.setStatus(rs.getString("STATUS"));
				result.setStart_date(rs.getDate("START_DATE"));
				result.setEnd_date(rs.getDate("END_DATE"));
				result.setInsta(rs.getString("INSTA"));
				result.setTraveler_no(rs.getString("TRAVELER_NO"));
				result.setCnt(rs.getString("CNT"));
				result.setPlace(rs.getString("PLACE"));
			}
			
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
	public int increaseCnt(Connection conn, String no) throws Exception {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE WITH_ SET CNT = CNT+1 WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
