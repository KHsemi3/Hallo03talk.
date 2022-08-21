package com.h3.admin.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.admin.repository.AdminReportUserDao;
import com.h3.common.JDBCTemplate;
import com.h3.reportUser.vo.ReportUserVo;

public class AdminReportService {

	public ArrayList<ReportUserVo> selectList() {
		Connection conn = null;
		ArrayList<ReportUserVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminReportUserDao().selectList(conn);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}

	public int deleteUser(int num) {
		Connection conn = null;
		int result = 0;
		
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result =new AdminReportUserDao().deleteUser(conn, num);
			if(result == 1) {
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
