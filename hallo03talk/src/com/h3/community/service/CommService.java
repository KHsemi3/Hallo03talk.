package com.h3.community.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.h3.common.JDBCTemplate.*;

import com.h3.community.dao.CommDao;
import com.h3.community.vo.CommVo;
import com.h3.with.dao.WithDao;
import com.h3.with.vo.PageVo;

public class CommService {

	public ArrayList<CommVo> getList(PageVo pageVo, String sort, String view) {
		ArrayList<CommVo> result = null;
		Connection conn = null;

		try {
			conn = getConnection();
			
			result = new CommDao().getlist(conn, pageVo, sort, view);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return result;
	}

	public int getCount(String view) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			//DAO 호출
			result = new CommDao().getCount(conn, view);	//select count 쿼리
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}

	public int post(CommVo vo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = new CommDao().post(conn,vo);
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
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
