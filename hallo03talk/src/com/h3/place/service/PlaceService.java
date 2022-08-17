package com.h3.place.service;

import static com.h3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.h3.place.repository.PlaceDao;
import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

public class PlaceService {

	private PlaceDao dao = new PlaceDao();

	public int placeAdd(PlaceVo placeVo, ArrayList<PlacePhotoVo> photoVoList) {

		Connection conn = null;
		int result = 0;
		int result2 = 0;

		try {
			conn = getConnection();

			result = dao.placeAdd(conn, placeVo);

			if (result == 1) {
				result2 = dao.placePhotoAdd(conn, photoVoList);
			} else {
				rollback(conn);
			}

			if (result * result2 == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return result * result2;
	}

	public String changeName(String originName) {
		int dot = originName.lastIndexOf(".");
		String ext = originName.substring(dot);

		String random = UUID.randomUUID().toString().replace("-", "_");

		String changeName = random + ext;

		return changeName;
	}

	public List<PlaceVo> getList() {

		Connection conn = null;
		List<PlaceVo> voList = null;

		try {
			conn = getConnection();
			voList = dao.getList(conn);
			return voList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return voList;
	}

	public int getCount() {
		
		Connection conn = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			cnt = dao.getCount(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return cnt;
	}

	public List<PlacePhotoVo> getProfile() {
		
		Connection conn = null;
		List<PlacePhotoVo> photoList = new ArrayList<PlacePhotoVo>();
		
		try {
			conn = getConnection();
			photoList = dao.getProfile(conn);
			
			return photoList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return photoList;
	}

	public PlaceVo placeOne(String placeNo) {
		Connection conn = null;
		PlaceVo pv = new PlaceVo();
		
		try {
			conn = getConnection();
			pv = dao.placeOne(conn,placeNo);
			
			return pv;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return pv;
	}

	public ArrayList<PlacePhotoVo> photoOne(String placeNo) {
		Connection conn = null;
		ArrayList<PlacePhotoVo> photoList = new ArrayList<PlacePhotoVo>();
		
		try {
			conn = getConnection();
			photoList = dao.photoOne(conn,placeNo);
			
			return photoList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return photoList;
	}

}
