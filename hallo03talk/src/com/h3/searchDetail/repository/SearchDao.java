package com.h3.searchDetail.repository;

import static com.h3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.h3.community.vo.CommVo;
import com.h3.place.vo.PlaceVo;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.with.vo.PageVo;
import com.h3.with.vo.WithVo;

public class SearchDao {
	
	//장소 검색
	public ArrayList<PlaceVo> pselectList(Connection conn){
		
		String sql = "SELECT A.NO , A.NAME , A.CONTENT , A.ADDRESS , B.NAME FROM PLACE A LEFT OUTER JOIN PLACE_PHOTO B ON A.NO = B.PLACE_NO WHERE B.PHOTO_PROFILE = 'Y' AND A.NAME LIKE '%?%' OR A.CONTENT LIKE '%?%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceVo> plist = new ArrayList<PlaceVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				String address = rs.getString("ADDRESS");
				
				PlaceVo pvo = new PlaceVo();
				pvo.setNo(no);
				pvo.setName(name);
				pvo.setContent(content);
				pvo.setAddress(address);
				
				plist.add(pvo);

				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return plist;
		
	}//plist
	
	
	
	//후기 검색
	public ArrayList<PlaceReviewVo> rselectList(Connection conn){
		
		String sql = "SELECT A.NO, A.TITLE, A.CONTENT, B.NAME FROM PLACE_REVIEW A LEFT OUTER JOIN PLACE_REVIEW_PHOTO B ON A.NO = B.REVIEW_NO WHERE B.STATUS = 'Y' AND A.TITLE LIKE '%?%' OR A.CONTENT LIKE '%?%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceReviewVo> rlist = new ArrayList<PlaceReviewVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				String address = rs.getString("ADDRESS");
				
				PlaceReviewVo rvo = new PlaceReviewVo();
				rvo.setNo(no);
				rvo.setTitle(sql);
				rvo.setContent(content);
				
				rlist.add(rvo);
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return rlist;
		
	}//rlist
	
	
	//커뮤니티 검색
	public ArrayList<CommVo> cselectList(Connection conn){
		
		String sql = "SELECT A.NO, A.TITLE, A.CONTENT, A.WRITER, B.NAME FROM COMMUNITY A LEFT OUTER JOIN COMMUNITY_PHOTO B ON A.NO = B.COMMUNITY_NO WHERE B.STATUS = 'Y' AND A.TITLE LIKE '%?%' OR A.CONTENT LIKE '%?%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommVo> clist = new ArrayList<CommVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				
				CommVo cvo = new CommVo();
				cvo.setNo(no);
				cvo.setTitle(title);
				cvo.setContent(content);
				cvo.setWriter(writer);
				
				clist.add(cvo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return clist;
		
	}//clist
	
	

	
}



