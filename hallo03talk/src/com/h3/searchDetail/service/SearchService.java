package com.h3.searchDetail.service;

import static com.h3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.h3.community.vo.CommVo;
import com.h3.place.vo.PlaceVo;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.searchDetail.repository.SearchDao;

public class SearchService {
	
	private final PlaceVo pvo = new PlaceVo();
	private final CommVo cvo = new CommVo();
	private final PlaceReviewVo rvo = new PlaceReviewVo();
	
	//장소
	public ArrayList<PlaceVo> pselectList(){
		
		Connection conn = null;
		ArrayList<PlaceVo> pvoList = null;
		
		try {
			conn = getConnection();
			
			pvoList = new SearchDao().pselectList(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return pvoList;
	}
	
	//커뮤니티
	public ArrayList<CommVo> cselectList(){
		
		Connection conn = null;
		ArrayList<CommVo> cvoList = null;
		
		try {
			conn = getConnection();
			
			cvoList = new SearchDao().cselectList(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return cvoList;
	}
	
	//후기
	public ArrayList<PlaceReviewVo> rselectList(){
		
		Connection conn = null;
		ArrayList<PlaceReviewVo> rvoList = null;
		
		try {
			conn = getConnection();
			
			rvoList = new SearchDao().rselectList(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return rvoList;
	}

}
