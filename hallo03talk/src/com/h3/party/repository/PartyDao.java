package com.h3.party.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h3.party.vo.PartyVo;

import static com.h3.common.JDBCTemplate.*;


public class PartyDao {

	public ArrayList<PartyVo> getlist(Connection conn) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs= null;
		
		ArrayList<PartyVo> list = new ArrayList<PartyVo>();
		
		String sql = "SELECT P.NO, P.TITLE, P.CONTENT, P.CNT, P.ENROLL_DATE, PC.NAME CATEGORY_NAME, B.ID BOSS_ID FROM PARTY P JOIN PARTY_CATEGORY PC ON P.PARTY_CATEGORY = PC.NO JOIN BOSS B ON B.NO = P.BOSS_NO WHERE P.STATUS = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PartyVo vo = new PartyVo();
				vo.setNo(rs.getInt("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setCnt(rs.getInt("CNT"));
				vo.setEnrollDate(rs.getTimestamp("ENROLL_DATE"));
				vo.setCategoryName(rs.getString("CATEGORY_NAME"));
				vo.setBossId(rs.getString("BOSS_ID"));
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}//class
}	