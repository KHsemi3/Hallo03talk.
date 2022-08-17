package com.h3.traveler.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.h3.traveler.vo.TravelerVo;

public class TravelerDao {

	
	/*
	 * 회원가입
	 */
	public int join(TravelerVo vo, Connection conn) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			// 커넥션준비 - 생략
			
			//SQL 준비
			String sql = " INSERT INTO TRAVELER (NO , ID , PWD , NAME , NICK , GENDER , PHONE , EMAIL) VALUES(SEQ_TRAVELER_NO.NEXTVAL, ?, ?, ?, ? ,? , ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getEmail());
			
			//SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}//join

	
	/*
	 * 로그인
	 */
	public TravelerVo login(Connection conn, TravelerVo vo) throws SQLException {

	
		TravelerVo travelerLoginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// sql 준비 - try 안, 밖 아무때나 위치시켜도 됨
		String sql = "SELECT * FROM TRAVELER WHERE ID = ? AND PWD = ? AND STATUS ='Y'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				int travelerNo = rs.getInt("NO");
				String travelerId = rs.getString("ID");
				String travelerName = rs.getString("NAME");
				String travelerNick = rs.getString("NICK");
				String travelerPhone = rs.getString("PHONE");
				String travelerEmail = rs.getString("EMAIL");
				String travelerGender = rs.getString("GENDER");
				Timestamp travelerEnrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp travelerModifyDate = rs.getTimestamp("MODIFY_DATE");

				travelerLoginMember = new TravelerVo();
				travelerLoginMember.setNo(travelerNo);
				travelerLoginMember.setId(travelerId);
				travelerLoginMember.setName(travelerName);
				travelerLoginMember.setNick(travelerNick);
				travelerLoginMember.setPhone(travelerPhone);
				travelerLoginMember.setEmail(travelerEmail);
				travelerLoginMember.setGender(travelerGender);
				travelerLoginMember.setEnrollDate(travelerEnrollDate);
				travelerLoginMember.setModifyDate(travelerModifyDate);

			}
			
		}
		finally {
			//자원 반납
			close(pstmt);
			close(rs);
		}
		
		// SQL 실행결과 리턴
		return travelerLoginMember;
	
	}//login


	/*
	 *마이페이지 - 정보 변경 
	 */
	public int edit(Connection conn, TravelerVo vo) {

	
		String sql = "UPDATE TRAVELER SET NAME = ? , NICK = ? , PHONE = ? , EMAIL = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNick());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setInt(5, vo.getNo());

			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}
		
		//SQL 실행결과 리턴
		return result;
	
	}


	/*
	 * 다시한번 회원 정보 조회(회원번호): 정보 변경 된 것을 조회
	 */
	public TravelerVo selectOneByNo(Connection conn, int num) {

	
		// sql 준비
		String sql = "SELECT * FROM TRAVELER WHERE NO = ? AND STATUS ='Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TravelerVo vo = null;
		
		try {
			// sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			
			// 물음표 채우기
			pstmt.setInt(1, num);

			
			// sql 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String gender = rs.getString("GENDER");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				
				vo = new TravelerVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setName(name);
				vo.setNick(nick);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setGender(gender);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}

		return vo;
	
	
	}


	/*
	 * 비밀번호 변경
	 */
	public int changePwd(Connection conn, String travelerJoinId, String travelerJoinPwd, String travelerJoinPwdNew,
			String travelerJoinPwdNew2) {


		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE TRAVELER SET PWD = ? WHERE ID = ? AND PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, travelerJoinPwdNew);
			pstmt.setString(2, travelerJoinId);
			pstmt.setString(3, travelerJoinPwd);

			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}


	/*
	 * 회원 탈퇴
	 */
	public int quit(Connection conn, String travelerJoinId, String travelerJoinPwd, String travelerJoinPwd2) {

	
		String sql = "UPDATE TRAVELER SET STATUS = 'N' , MODIFY_DATE = SYSDATE WHERE ID = ? AND PWD = ? ";
		
		PreparedStatement pstmt = null;
		int result = 0;
		

		// AND PWD = ? 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, travelerJoinId);
			pstmt.setString(2, travelerJoinPwd);
	
			
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);

		}
		
		return result;
	
	}//quit
	
	
	

}//class
