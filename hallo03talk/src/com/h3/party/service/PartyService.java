package com.h3.party.service;

import java.sql.Connection;

import static com.h3.common.JDBCTemplate.*;
import com.h3.party.repository.PartyDao;

public class PartyService {
	
	private final PartyDao dao = new PartyDao();
	
	//총 게시글
	public int getCount() {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = dao.getCount(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);	
		}		
		return result;
	}
}
