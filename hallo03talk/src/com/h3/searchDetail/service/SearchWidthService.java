package com.h3.searchDetail.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.searchDetail.repository.WithSearchDao;
import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

public class SearchWidthService {
	
	private final WithVo wvo = new WithVo();
	private String widthKeyword;
	private String cate4;
	private String cate5;
	
	//장소
		public ArrayList<WithVo> wselectList(){
			
			Connection conn = null;
			ArrayList<WithVo> wvoList = null;
			
			try {
				conn = getConnection();
				
				wvoList = new WithSearchDao().wselectList(conn, wvo, widthKeyword, cate4, cate5);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(conn);
			}
			
			return wvoList;
		}

}
