package com.h3.traveler.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.commit;
import static com.h3.common.JDBCTemplate.getConnection;
import static com.h3.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.h3.traveler.repository.TravelerDao;
import com.h3.traveler.vo.TravelerVo;

public class TravelerService {

	private final TravelerDao dao = new TravelerDao();

	/*
	 * 회원가입
	 */
	public int join(TravelerVo vo) {
		
		// 비밀번호 일치 검사
		if(vo.getPwd().equals(vo.getPwd2()) == false) {
			return -1;
		}

		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();

			// dao 호출
			result = dao.join(vo, conn);

			//트랜잭션 처리 (commit || rollback)
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		// 실행결과 리턴
		return result;
		
		
	}

	
	/*
	 * 로그인
	 */
	public TravelerVo login(TravelerVo vo) {

	
		Connection conn = null;
		TravelerVo travelerLoginMember = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			travelerLoginMember = dao.login(conn, vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		//실행결과 리턴
		return travelerLoginMember;
	
	
	}//login

	

	/*
	 *마이페이지 - 정보 변경 
	 */
	public TravelerVo edit(TravelerVo vo) {

	
		Connection conn = null;
		int result = 0;
		TravelerVo updateVo = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			result = new TravelerDao().edit(conn, vo);
			
			//트랜잭션 처리 (commit || rollback)
			if(result == 1) {
				commit(conn);
				// 다시한번 회원정보 조회 (회원번호)  // 서비스의 selectOneByNo 메소드 호출하기
				updateVo = selectOneByNo(vo.getNo());
			}else {
				rollback(conn);
			}
		}catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		 //실행결과 리턴
		return updateVo;
		
	
	}


	/*
	 * 다시한번 회원 정보 조회(회원번호): 정보 변경 된 것을 조회
	 */
	private TravelerVo selectOneByNo(int no) {

		Connection conn = null;
		TravelerVo vo = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			vo = new TravelerDao().selectOneByNo(conn, no);
			

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		 //실행결과 리턴
		return vo;
	
	}


	/*
	 * 비밀번호 변경
	 */
	public int changePwd(String travelerJoinId, String travelerJoinPwd, String travelerJoinPwdNew,
			String travelerJoinPwdNew2) {

		// 비지니스 로직 검사
		if(travelerJoinPwdNew.equals(travelerJoinPwdNew2) == false) {
			System.out.println("신규 비밀번호가 일치하지 않습니다.");
			return -1;
		}
		
		
		Connection conn = null;
		int result = 0;
		
		try{
			conn = getConnection();
			
			// dao 호출
			result = new TravelerDao().changePwd(conn, travelerJoinId, travelerJoinPwd, travelerJoinPwdNew, travelerJoinPwdNew2);
			
			// 트랜잭션 처리
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	
	
	
	}//changePwd


	/*
	 * 회원 탈퇴
	 */
	public int quit(String travelerJoinId, String travelerJoinPwd, String travelerJoinPwd2) {
		
		if(travelerJoinPwd.equals(travelerJoinPwd2) == false) {
			System.out.println("탈퇴-비밀번호가 서로 일치하지 않음");
			return -1;
		}
		
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			conn = getConnection();

			// dao 호출
			result = new TravelerDao().quit(conn, travelerJoinId, travelerJoinPwd, travelerJoinPwd2);
			
			
			// 트랜잭션 처리
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
		
		
	}//hallo03talk
	
	
	

}//class