package com.h3.boss.repository;

import static com.h3.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.h3.boss.vo.BossVo;
import com.h3.traveler.vo.TravelerVo;

public class BossDao {

	/*
	 * 회원가입
	 */
	public int join(BossVo vo, Connection conn) {
	
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			// 커넥션준비 - 생략
			
			//SQL 준비
			String sql = "INSERT INTO BOSS (NO , ID , PWD , PHONE , EMAIL) VALUES(SEQ_BOSS_NO.NEXTVAL, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			
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
	public BossVo login(Connection conn, BossVo vo) throws SQLException {

		BossVo BossLoginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOSS WHERE ID = ? AND PWD = ? AND STATUS ='Y'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int BossNo = rs.getInt("NO");
				String BossId = rs.getString("ID");
				String BossPhone = rs.getString("PHONE");
				String BossEmail = rs.getString("EMAIL");
				Timestamp BossEnrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp BossModifyDate = rs.getTimestamp("MODIFY_DATE");

				BossLoginMember = new BossVo();
				BossLoginMember.setNo(BossNo);
				BossLoginMember.setId(BossId);
				BossLoginMember.setPhone(BossPhone);
				BossLoginMember.setEmail(BossEmail);
				BossLoginMember.setEnrollDate(BossEnrollDate);
				BossLoginMember.setModifyDate(BossModifyDate);

			}
		}
		finally {
			//자원 반납
			close(pstmt);
			close(rs);
		}
		
		// SQL 실행결과 리턴
		return BossLoginMember;
	
	
	}//login



	/*
	 * 마이페이지 - 회원정보 변경
	 * 
	 */
	public int edit(Connection conn, BossVo vo) {

		String sql = "UPDATE BOSS SET  PHONE = ? , EMAIL = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPhone());
			pstmt.setString(2, vo.getEmail());
			pstmt.setInt(3, vo.getNo());

			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
		}
		
		//SQL 실행결과 리턴
		return result;
	
	
	
	
	}//edit


	
	/*
	 * 다시한번 회원 정보 조회(회원번호): 정보 변경 된 것을 조회
	 */
	public BossVo selectOneByNo(Connection conn, int num) {

	
		// sql 준비
		String sql = "SELECT * FROM BOSS WHERE NO = ? AND STATUS ='Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BossVo vo = null;
		
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
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				
				vo = new BossVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setPhone(phone);
				vo.setEmail(email);
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
	public int changePwd(Connection conn, String bossJoinId, String bossJoinPwd, String bossJoinPwdNew,
			String bossJoinPwdNew2) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE BOSS SET PWD = ? WHERE ID = ? AND PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bossJoinPwdNew);
			pstmt.setString(2, bossJoinId);
			pstmt.setString(3, bossJoinPwd);

			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}//changePwd



	/*
	 * 회원 탈퇴
	 */
	public int quit(Connection conn, String bossJoinId, String bossJoinPwd, String bossJoinPwd2) {

		String sql = "UPDATE BOSS SET STATUS = 'N' , MODIFY_DATE = SYSDATE WHERE ID = ? AND PWD = ? ";
		
		PreparedStatement pstmt = null;
		int result = 0;
		

		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bossJoinId);
			pstmt.setString(2, bossJoinPwd);
	
			
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);

		}
		
		return result;
	
	}//quit

	
}//class
