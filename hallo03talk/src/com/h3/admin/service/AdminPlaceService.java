package com.h3.admin.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.admin.repository.AdminPlaceDao;
import com.h3.common.JDBCTemplate;
import com.h3.place.vo.PlaceVo;

public class AdminPlaceService {

	public ArrayList<PlaceVo> selectListPlace() {
		Connection conn = null;
		ArrayList<PlaceVo> voList = null;
		try {
			conn = JDBCTemplate.getConnection();
			
			
			
			//DAO 호출
			voList = new AdminPlaceDao().selectListPlace(conn);
			
			//실행결과 리턴
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return voList;
	}

}
