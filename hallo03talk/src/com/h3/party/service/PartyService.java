package com.h3.party.service;
import java.sql.Connection;
import java.util.ArrayList;


import static com.h3.common.JDBCTemplate.*;
import com.h3.party.repository.PartyDao;
import com.h3.party.vo.PartyVo;

import oracle.net.aso.c;


public class PartyService {
	
	private PartyDao dao = new PartyDao();
	
		

		public ArrayList<PartyVo> getlist() {
			Connection conn = null;
			ArrayList<PartyVo> list = null;
			
			try {
				conn = getConnection();
				list = dao.getlist(conn);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn);
			}
			return list;
		}

		
	}

	

