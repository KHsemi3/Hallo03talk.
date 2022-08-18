package com.h3.zzim.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.h3.place.vo.PlaceVo;
import com.h3.traveler.vo.TravelerVo;
import com.h3.zzim.repository.ZzimDao;

public class ZzimService {
	
	private ZzimDao dao = new ZzimDao();
	
	public int zzimAdd(TravelerVo tv, PlaceVo pv) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.zzimAdd(conn, tv, pv);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return 0;
	}

}
