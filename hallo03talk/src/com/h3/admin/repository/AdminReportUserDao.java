package com.h3.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h3.common.JDBCTemplate;
import com.h3.reportBoard.vo.ReportBoardVo;
import com.h3.reportComment.vo.ReportCommentVo;
import com.h3.reportUser.vo.ReportUserVo;

public class AdminReportUserDao {

	public ArrayList<ReportUserVo> selectListUser(Connection conn) {
		String sql="SELECT R.NO, R.GUILTY, R.CONTENT, R.PROCESS, R.REPORTED_TRAVELER_NO,T.ID AS REPORT_USER_ID FROM REPORT_USER R JOIN TRAVELER T ON R.REPORTED_TRAVELER_NO = T.NO WHERE T.STATUS = 'Y' AND R.PROCESS='N' ORDER BY NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ArrayList<ReportUserVo> list = new ArrayList<ReportUserVo>();
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String no =	rs.getString("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String reportedTravelerNo =	rs.getString("REPORTED_TRAVELER_NO");
				String reportUserId =	rs.getString("REPORT_USER_ID");
//				Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				ReportUserVo vo = new ReportUserVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setReportedTravelerNo(reportedTravelerNo);
				vo.setReportUserId(reportUserId);
//				vo.setEnrollDate(enrollDate);
				
				
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
	
	public ArrayList<ReportCommentVo> selectListComment(Connection conn) {
		String sql="SELECT R.NO, R.GUILTY, R.CONTENT, R.PROCESS, R.REPORTED_TRAVELER_NO,T.ID AS REPORT_USER_ID FROM REPORT_USER R JOIN TRAVELER T ON R.REPORTED_TRAVELER_NO = T.NO WHERE T.STATUS = 'Y' AND R.PROCESS='N' ORDER BY NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ArrayList<ReportCommentVo> list = new ArrayList<ReportCommentVo>();
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String no =	rs.getString("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String type =	rs.getString("TYPE");
				String reportUserId =	rs.getString("REPORT_USER_ID");
				Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				ReportCommentVo vo = new ReportCommentVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setType(type);
				vo.setReportUserId(reportUserId);
				vo.setEnrollDate(enrollDate);
				
				
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
	
	

	public int deleteUser(Connection conn, int[] dNum) {
String sql = "UPDATE REPORT_USER SET PROCESS = 'Y' WHERE NO= ?";
	   
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<dNum.length; i ++) {
				pstmt.setInt(1, dNum[i]);
			}
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public ArrayList<ReportBoardVo> selectListBoard(Connection conn) {
		String sql="SELECT NO, GUILTY, CONTENT, PROCESS, TYPE, BOARD_NO FROM REPORT_CONTENT ORDER BY NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		ArrayList<ReportBoardVo> list = new ArrayList<ReportBoardVo>();
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				String no =	rs.getString("NO");
				String guilty =	rs.getString("GUILTY");
				String content =	rs.getString("CONTENT");
				String process =	rs.getString("PROCESS");
				String type =	rs.getString("TYPE");
				String reportUserId =	rs.getString("BOARD_NO");
				Timestamp	enrollDate = rs.getTimestamp("ENROLL_DATE");
				
				ReportBoardVo vo = new ReportBoardVo();
				vo.setNo(no);
				vo.setGuilty(guilty);
				vo.setContent(content);
				vo.setProcess(process);
				vo.setType(type);
				vo.setReportUserId(reportUserId);
				vo.setEnrollDate(enrollDate);
				
				
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
		
	}
	
	



	




