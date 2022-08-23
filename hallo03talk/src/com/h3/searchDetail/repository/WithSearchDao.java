package com.h3.searchDetail.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

public class WithSearchDao {
	
	//동행 검색
	public ArrayList<WithVo> wselectList(Connection conn){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WithVo> wlist = new ArrayList<WithVo>();
		String sql = "";
		
		

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				WithVo wvo = new WithVo();
				wvo.setNo(rs.getString("NO"));
				wvo.setTitle(rs.getString("TITLE"));
				wvo.setContent(rs.getString("CONTENT"));
				wvo.setTag(rs.getString("TAG").split(","));
				wvo.setEnroll_date(rs.getTimestamp("ENROLL_DATE"));
				wvo.setStatus(rs.getString("STATUS"));
				wvo.setStart_date(rs.getDate("START_DATE"));
				wvo.setEnd_date(rs.getDate("END_DATE"));
				wvo.setInsta(rs.getString("INSTA"));
				wvo.setTraveler_no(rs.getString("TRAVELER_NO"));
				wvo.setCnt(rs.getString("CNT"));
				wvo.setPlace(rs.getString("PLACE"));


				wlist.add(wvo);
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return wlist;
		
	}

}
