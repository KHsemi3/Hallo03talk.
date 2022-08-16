package com.h3.with.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.h3.common.JDBCTemplate.*;
import com.h3.with.dao.WithDao;
import com.h3.with.vo.WithVo;

public class WithService {

	public ArrayList<WithVo> getList() {
		Connection conn = null;
		ArrayList<WithVo> result =null;
		
		try {
			conn = getConnection();
			result = new WithDao().getList(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}

	public WithVo getOne(String no) {
		WithVo result = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			int isIncreased = new WithDao().increaseCnt(conn, no);
			
			if(isIncreased == 1) {				
				result = new WithDao().getOne(conn, no);
				commit(conn);
			}else {
				rollback(conn);
				return null;
			}
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

}
