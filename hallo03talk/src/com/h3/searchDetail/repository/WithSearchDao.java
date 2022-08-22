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
	public ArrayList<WithVo> wselectList(Connection conn, PageVo pageVo, String sort){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WithVo> wlist = new ArrayList<WithVo>();
		String sql = "";
		
		if("a".equals(sort)) {
			sql = "SELECT U.* FROM( SELECT ROWNUM AS RNUM, S.* FROM( SELECT W.NO, W.TITLE, W.CONTENT, W.TAG, W.ENROLL_DATE, W.STATUS, W.START_DATE, W.END_DATE, W.INSTA, T.NICK AS TRAVELER_NO, W.CNT, W.PLACE FROM WITH_ W JOIN traveler T ON W.TRAVELER_NO = T.NO WHERE W.STATUS = 'Y' ORDER BY ENROLL_DATE DESC ) S ) U WHERE U.RNUM BETWEEN ? AND ? AND W.TITLE LIKE '%?%' OR W.CONTENT LIKE '%?%'";
		}else if("v".equals(sort)) {
			sql = "SELECT U.* FROM( SELECT ROWNUM AS RNUM, S.* FROM( SELECT W.NO, W.TITLE, W.CONTENT, W.TAG, W.ENROLL_DATE, W.STATUS, W.START_DATE, W.END_DATE, W.INSTA, T.NICK AS TRAVELER_NO, W.CNT, W.PLACE FROM WITH_ W JOIN traveler T ON W.TRAVELER_NO = T.NO ORDER BY CNT DESC ) S ) U WHERE U.RNUM BETWEEN ? AND ? AND W.TITLE LIKE '%?%' OR W.CONTENT LIKE '%?%'";
		}else {
			sql = "SELECT U.* FROM( SELECT ROWNUM AS RNUM, S.* FROM( SELECT W.NO, W.TITLE, W.CONTENT, W.TAG, W.ENROLL_DATE, W.STATUS, W.START_DATE, W.END_DATE, W.INSTA, T.NICK AS TRAVELER_NO, W.CNT, W.PLACE FROM WITH_ W JOIN traveler T ON W.TRAVELER_NO = T.NO ORDER BY ENROLL_DATE DESC ) S ) U WHERE U.RNUM BETWEEN ? AND ? AND W.TITLE LIKE '%?%' OR W.CONTENT LIKE '%?%'";			
		}
		

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1)*pageVo.getBoardLimit() + 1;
			int end = start + pageVo.getBoardLimit() - 1;
			
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
