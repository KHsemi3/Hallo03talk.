package com.h3.admin.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.admin.repository.AdminReportUserDao;
import com.h3.common.JDBCTemplate;
import com.h3.reportBoard.vo.ReportBoardVo;
import com.h3.reportComment.vo.ReportCommentVo;
import com.h3.reportUser.vo.ReportUserVo;

public class AdminReportService {

	public ArrayList<ReportUserVo> selectListUser() {
		Connection conn = null;
		ArrayList<ReportUserVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminReportUserDao().selectListUser(conn);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}

	

	public ArrayList<ReportCommentVo> selectListComment() {
		Connection conn = null;
		ArrayList<ReportCommentVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminReportUserDao().selectListComment(conn);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}

	public ArrayList<ReportBoardVo> selectListBoard() {
		Connection conn = null;
		ArrayList<ReportBoardVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminReportUserDao().selectListBoard(conn);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}
	
	
	public int deleteUser(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteUser(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}

	public int deleteContent(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteContent(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}



	public int deleteReply(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteReply(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}



	public int deleteContentReal(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteContentReal(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}



	public int deleteReplyReal(int[] dNum) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteReplyReal(conn,dNum);
			if(result == dNum.length) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
			
		}finally {
			close(conn);
		}
		return result;
	}

}
