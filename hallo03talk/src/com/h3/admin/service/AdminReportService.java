package com.h3.admin.service;

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

}
