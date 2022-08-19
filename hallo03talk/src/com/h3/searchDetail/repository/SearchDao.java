package com.h3.searchDetail.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.h3.place.vo.PlaceVo;

public class SearchDao {
	
	//장소 검색
	public ArrayList<PlaceVo> selectList(Connection conn){
		
		String sql = "SELECT A.NO , A.NAME , A.CONTENT , A.ADDRESS , B.NAME FROM PLACE A LEFT OUTER JOIN PLACE_PHOTO B ON A.NO = B.PLACE_NO WHERE B.PHOTO_PROFILE = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceVo> plist = new ArrayList<PlaceVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String 
			}
			
		} catch (Exception e) {
			
		}finally {
			
		}
		
		
	}

}
