package com.h3.place.repository;

import static com.h3.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

public class PlaceDao {

	public int placeAdd(Connection conn, PlaceVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO PLACE(NO,NAME,CONTENT,ADDRESS,BOSS_NO,CATEGORY_NO) VALUES(SEQ_PLACE_NO.NEXTVAL,?,?,?,?,?)";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getBossNo());
			pstmt.setString(5, vo.getCategoryNo());
			
			result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int placePhotoAdd(Connection conn, ArrayList<PlacePhotoVo> photoVoList) {
		
		PreparedStatement pstmt = null;
		int x = 0;
		int result = 0;
		
		String sql = "INSERT INTO PLACE_PHOTO(NO,NAME,PATH,PLACE_NO) VALUES(SEQ_PLACE_PHOTO_NO.NEXTVAL,?,?,SEQ_PLACE_NO.CURRVAL)";
		
		try {
			for(int i=0; i<photoVoList.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, photoVoList.get(i).getName());
				pstmt.setString(2, photoVoList.get(i).getPath());
				
				x = pstmt.executeUpdate();
				
				result += x;
			}
			
			if (result == photoVoList.size()) {
				result = 1;
				return result;
			} else {
				result = 0;
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
