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
	public ArrayList<PlaceVo> pselectList(Connection conn, String placeKeyword, String cate1, String cate2, String cate3){
		
		String sql = "SELECT A.NO , A.NAME , A.CONTENT , A.ADDRESS , B.NAME FROM PLACE A LEFT OUTER JOIN PLACE_PHOTO B ON A.NO = B.PLACE_NO WHERE  A.NAME LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql2 = "SELECT A.NO , A.NAME , A.CONTENT , A.ADDRESS , B.NAME FROM PLACE A LEFT OUTER JOIN PLACE_PHOTO B ON A.NO = B.PLACE_NO WHERE A.NAME LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql3 = "SELECT A.NO , A.NAME , A.CONTENT , A.ADDRESS , B.NAME FROM PLACE A LEFT OUTER JOIN PLACE_PHOTO B ON A.NO = B.PLACE_NO WHERE  A.NAME LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql4 = "SELECT A.NO , A.NAME , A.CONTENT , A.ADDRESS , B.NAME FROM PLACE A LEFT OUTER JOIN PLACE_PHOTO B ON A.NO = B.PLACE_NO WHERE  A.NAME LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceVo> plist = new ArrayList<PlaceVo>();
		
		try {
			
			//main.jsp에서 받아온 cate1, cate2, cate3 값은 어떻게 처리...??
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeKeyword);
			pstmt.setString(2, placeKeyword); 
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, cate1);
			pstmt.setString(2, cate1);
			
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, cate2);
			pstmt.setString(2, cate2);
			
			pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1, cate3);
			pstmt.setString(2, cate3);
			
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
	public ArrayList<PlaceReviewVo> rselectList(Connection conn, String placeKeyword, String cate1, String cate2, String cate3){
		
		String sql = "SELECT A.NO, A.TITLE, A.CONTENT, B.NAME FROM PLACE_REVIEW A LEFT OUTER JOIN PLACE_REVIEW_PHOTO B ON A.NO = B.REVIEW_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql2 = "SELECT A.NO, A.TITLE, A.CONTENT, B.NAME FROM PLACE_REVIEW A LEFT OUTER JOIN PLACE_REVIEW_PHOTO B ON A.NO = B.REVIEW_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql3 = "SELECT A.NO, A.TITLE, A.CONTENT, B.NAME FROM PLACE_REVIEW A LEFT OUTER JOIN PLACE_REVIEW_PHOTO B ON A.NO = B.REVIEW_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql4 = "SELECT A.NO, A.TITLE, A.CONTENT, B.NAME FROM PLACE_REVIEW A LEFT OUTER JOIN PLACE_REVIEW_PHOTO B ON A.NO = B.REVIEW_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlaceReviewVo> rlist = new ArrayList<PlaceReviewVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeKeyword);
			pstmt.setString(2, placeKeyword);
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, cate1);
			pstmt.setString(2, cate1);
			
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, cate2);
			pstmt.setString(2, cate2);
			
			pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1, cate3);
			pstmt.setString(2, cate3);
			
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				
				PlaceReviewVo rvo = new PlaceReviewVo();
				rvo.setNo(no);
				rvo.setTitle(title);
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
	public ArrayList<CommVo> cselectList(Connection conn, String placeKeyword, String cate1, String cate2, String cate3){
		
		String sql = "SELECT A.NO, A.TITLE, A.CONTENT, A.WRITER, B.NAME FROM COMMUNITY A LEFT OUTER JOIN COMMUNITY_PHOTO B ON A.NO = B.COMMUNITY_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql2 = "SELECT A.NO, A.TITLE, A.CONTENT, A.WRITER, B.NAME FROM COMMUNITY A LEFT OUTER JOIN COMMUNITY_PHOTO B ON A.NO = B.COMMUNITY_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql3 = "SELECT A.NO, A.TITLE, A.CONTENT, A.WRITER, B.NAME FROM COMMUNITY A LEFT OUTER JOIN COMMUNITY_PHOTO B ON A.NO = B.COMMUNITY_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		String sql4 = "SELECT A.NO, A.TITLE, A.CONTENT, A.WRITER, B.NAME FROM COMMUNITY A LEFT OUTER JOIN COMMUNITY_PHOTO B ON A.NO = B.COMMUNITY_NO WHERE A.TITLE LIKE '%' || ? ||'%' OR A.CONTENT LIKE '%' || ? ||'%'";
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommVo> clist = new ArrayList<CommVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeKeyword);
			pstmt.setString(2, placeKeyword);
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, cate1);
			pstmt.setString(2, cate1);
			
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, cate2);
			pstmt.setString(2, cate2);
			
			pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1, cate3);
			pstmt.setString(2, cate3);
			
			
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



