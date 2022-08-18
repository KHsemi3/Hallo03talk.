package com.h3.community.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.h3.common.JDBCTemplate.*;

import com.h3.community.dao.CommDao;
import com.h3.community.vo.CommVo;

public class CommService {

	public ArrayList<CommVo> getList() {
		ArrayList<CommVo> result = null;
		Connection conn = null;

		try {
			conn = getConnection();
			
			result = new CommDao().getlist(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return result;
	}

}
