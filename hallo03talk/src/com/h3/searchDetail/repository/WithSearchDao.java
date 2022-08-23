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
	public ArrayList<WithVo> wselectList(Connection conn, WithVo vo, String widthKeyword){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WithVo> wlist = new ArrayList<WithVo>();
		String sql = "SELECT (A.NO, A.TITLE, A.CONTENT, A.START_DATE, A.END_DATE,  B.NO) FROM TABLE WITH_ A LEFT OUTER JOIN WITH_PHOTO  B ON A.NO = B.NO WHERE A.TITLE LIKE '%' || '?' ||'%' OR A.CONTENT LIKE '%' || '?' ||'%' AND A.START_DATE LIKE '?' AND A.END_DATE LIKE '?'";

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, widthKeyword);
			pstmt.setDate(2, vo.getStart_date());
			pstmt.setDate(3, vo.getEnd_date());
			

			rs = pstmt.executeQuery();

			while (rs.next()) {
				WithVo wvo = new WithVo();

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
