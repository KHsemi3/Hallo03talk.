package com.h3.report.service;

import java.sql.Connection;

import static com.h3.common.JDBCTemplate.*;
import com.h3.report.dao.ReportDao;
import com.h3.reportBoard.vo.ReportBoardVo;
import com.h3.reportComment.vo.ReportCommentVo;
import com.h3.reportUser.vo.ReportUserVo;



public class ReportService {
	
	//사용자
	public int ujoin(ReportUserVo uvo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = new ReportDao().ujoin(uvo, conn);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (Exception e) {
			
		}finally {
			close(conn);
		}
		
		
		return result;
	}
	
	//게시물
	public int bjoin(ReportBoardVo bvo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = new ReportDao().bjoin(bvo, conn);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (Exception e) {
			
		}finally {
			close(conn);
		}
		
		
		return result;
	
		
	}

	//댓글
	public int cjoin(ReportCommentVo cvo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = new ReportDao().cjoin(cvo, conn);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		} catch (Exception e) {
			
		}finally {
			close(conn);
		}
		
		
		return result;
		
	}

	

	
	


}
