package com.h3.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.h3.common.JDBCTemplate;
import com.h3.place.vo.PlaceVo;

public class AdminPlaceDao {

	public ArrayList<PlaceVo> selectListPlace(Connection conn) {
		String sql="SELECT P.NO, P.NAME, P.CONTENT, P.ADDRESS, P.BOSS_NO, P.CATEGORY_NO, P.STATUS, P.ENROLL_DATE, P.CNT ,PP.PATH AS PHOTO FROM PLACE P JOIN PLACE_PHOTO PP ON P.NO = PP.PLACE_NO WHERE P.CATEGORY_NO = 1";
		conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceVo> list = new ArrayList<PlaceVo>();
		
		try {
			conn=JDBCTemplate.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				String address = rs.getString("ADDRESS");
				String bossNo = rs.getString("BOSS_NO");
				String categoryNo = rs.getString("CATEGORY_NO");
				String status = 	rs.getString("STATUS");
			    String enrollDate = rs.getString("ENROLL_DATE");
				int cnt = rs.getInt("CNT");
			//	int zzim = rs.getInt("ZZIM");
				String photoName = rs.getString("PHOTO");
				
			 	PlaceVo vo = new PlaceVo();
			 	vo.setNo(no);
			 	vo.setName(name);
			 	vo.setContent(content);
			 	vo.setAddress(address);
			 	vo.setBossNo(bossNo);
			 	vo.setCategoryNo(categoryNo);
			 	vo.setStatus(status);
			 	vo.setEnrollDate(enrollDate);
			 	vo.setCnt(cnt);
			 	vo.setPhotoName(photoName);
			 	
			 	list.add(vo);
				
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		//겨과 리턴
		return list;
		
	
	
	}

}
