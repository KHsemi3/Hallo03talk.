package com.h3.with.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.h3.common.JDBCTemplate.*;

import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

public class WithDao {

	public ArrayList<WithVo> getList(Connection conn, PageVo pageVo) throws Exception {
		ArrayList<WithVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT U.* FROM( SELECT ROWNUM AS RNUM, S.* FROM( SELECT W.NO, W.TITLE, W.CONTENT, W.TAG, W.ENROLL_DATE, W.STATUS, W.START_DATE, W.END_DATE, W.INSTA, T.NICK AS TRAVELER_NO, W.CNT, W.PLACE FROM WITH_ W JOIN traveler T ON W.TRAVELER_NO = T.NO ORDER BY ENROLL_DATE DESC ) S ) U WHERE U.RNUM BETWEEN ? AND ?";

		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
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

		} finally {
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

			if (rs.next()) {
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

		} finally {
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

	public int getCount(Connection conn) {
		// Connection 준비

		// SQL 준비
		String sql = "SELECT COUNT(NO) AS COUNT FROM WITH_";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			// SQL 을 객체에 담기 및 SQL 완성
			pstmt = conn.prepareStatement(sql);

			// SQL 실행 및 결과저장
			rs = pstmt.executeQuery();

			// 실행결과 -> 자바 데이터
			if (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		// 실행결과 리턴
		return count;
	}

}
