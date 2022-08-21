package com.h3.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.h3.common.JDBCTemplate;
import com.h3.reportUser.vo.ReportUserVo;

public class AdminReportUserDao {

	public ArrayList<ReportUserVo> selectList(Connection conn) {
		String sql="SELECT R.NO, R.GUILTY, R.CONTENT, R.PROCESS, R.REPORTED_TRAVELER_NO,T.ID AS REPORT_USER_ID FROM REPORT_USER R JOIN TRAVELER T ON R.REPORTED_TRAVELER_NO = T.NO WHERE T.STATUS = 'Y' ORDER BY NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ArrayList<ReportUserVo> list = new ArrayList<ReportUserVo>();
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				int no =	rs.getInt("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String reportedTravelerNo =	rs.getString("REPORTED_TRAVELER_NO");
				String reportUserId =	rs.getString("REPORT_USER_ID");
				
				ReportUserVo vo = new ReportUserVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setReportedTravelerNo(reportedTravelerNo);
				vo.setReportUserId(reportUserId);
				
				
				list.add(vo);
				}
				
				
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
		return list;
	}

	public int deleteUser(Connection conn, int num) {
String sql = "UPDATE REPORT_USER SET PROCESS = 'Y' WHERE NO= ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

}
