package com.h3.place.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

public class PlaceDao {

//	장소 추가
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

//	장소 사진 추가
	public int placePhotoAdd(Connection conn, ArrayList<PlacePhotoVo> photoVoList) {

		PreparedStatement pstmt = null;
		int x = 0;
		int result = 0;

		String sql = "INSERT INTO PLACE_PHOTO(NO,NAME,PATH,PLACE_NO,PHOTO_PROFILE) VALUES(SEQ_PLACE_PHOTO_NO.NEXTVAL,?,?,SEQ_PLACE_NO.CURRVAL,?)";

		try {
			for (int i = 0; i < photoVoList.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, photoVoList.get(i).getName());
				pstmt.setString(2, photoVoList.get(i).getPath());
				if (i == photoVoList.size() - 1) {
					pstmt.setString(3, "Y");
				} else {
					pstmt.setString(3, "N");
				}
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

//	목록 불러오기
	public List<PlaceVo> getList(Connection conn) {

		PreparedStatement pstmt = null;
		List<PlaceVo> voList = new ArrayList<PlaceVo>();
		ResultSet rs = null;

		String sql = "SELECT NO,NAME,CONTENT,ADDRESS,BOSS_NO,CATEGORY_NO,ENROLL_DATE,CNT FROM PLACE WHERE STATUS='Y'";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlaceVo pv = new PlaceVo();
				pv.setNo(rs.getString("NO"));
				pv.setName(rs.getString("NAME"));
				pv.setContent(rs.getString("CONTENT"));
				pv.setAddress(rs.getString("ADDRESS"));
				pv.setBossNo(rs.getString("BOSS_NO"));
				pv.setCategoryNo(rs.getString("CATEGORY_NO"));
				pv.setEnrollDate(rs.getString("ENROLL_DATE"));
				pv.setCnt(Integer.parseInt(rs.getString("CNT")));
				voList.add(pv);
			}
			return voList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return voList;
	}

//	목록 총 개수
	public int getCount(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		String sql = "SELECT COUNT(NO) FROM PLACE WHERE STATUS='Y'";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return cnt;
	}

//	장소 프로필 사진 전부 가져오기
	public List<PlacePhotoVo> getProfile(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PlacePhotoVo> photoList = new ArrayList<PlacePhotoVo>();

		String sql = "SELECT H.NO , H.NAME,H.PATH,H.ENROLL_DATE,H.PLACE_NO FROM PLACE_PHOTO H JOIN PLACE P ON P.NO = H.PLACE_NO WHERE H.STATUS='Y' AND H.PHOTO_PROFILE='Y'";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlacePhotoVo ppv = new PlacePhotoVo();
				ppv.setNo(rs.getString(1));
				ppv.setName(rs.getString(2));
				ppv.setPath(rs.getString(3));
				ppv.setEnrollDate(rs.getString(4));
				ppv.setPlaceNo(rs.getString(5));
				photoList.add(ppv);
			}
			return photoList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return photoList;
	}

//	장소하나 가져오기
	public PlaceVo placeOne(Connection conn, String placeNo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PlaceVo pv = new PlaceVo();

		String sql = "SELECT NO,NAME,CONTENT,ADDRESS,BOSS_NO,CATEGORY_NO,ENROLL_DATE,CNT FROM PLACE WHERE STATUS='Y' AND NO=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pv.setNo(rs.getString("NO"));
				pv.setName(rs.getString("NAME"));
				pv.setContent(rs.getString("CONTENT"));
				pv.setAddress(rs.getString("ADDRESS"));
				pv.setBossNo(rs.getString("BOSS_NO"));
				pv.setCategoryNo(rs.getString("CATEGORY_NO"));
				pv.setEnrollDate(rs.getString("ENROLL_DATE"));
				pv.setCnt(Integer.parseInt(rs.getString("CNT")));
			}

			return pv;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return pv;
	}

//	해당 장소의 사진 전부 가져오기
	public ArrayList<PlacePhotoVo> photoOne(Connection conn, String placeNo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PlacePhotoVo> photoList = new ArrayList<PlacePhotoVo>();

		String sql = "SELECT NO,NAME,PATH,PHOTO_PROFILE,ENROLL_DATE FROM PLACE_PHOTO WHERE STATUS='Y' AND PLACE_NO=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placeNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PlacePhotoVo ppv = new PlacePhotoVo();
				ppv.setNo(rs.getString("NO"));
				ppv.setName(rs.getString("NAME"));
				ppv.setPath(rs.getString("PATH"));
				ppv.setProfile(rs.getString("PHOTO_PROFILE"));
				ppv.setEnrollDate(rs.getString("ENROLL_DATE"));
				
				photoList.add(ppv);
			}
			return photoList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return photoList;
	}

}
