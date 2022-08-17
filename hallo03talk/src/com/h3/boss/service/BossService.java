package com.h3.boss.service;

import static com.h3.common.JDBCTemplate.close;
import static com.h3.common.JDBCTemplate.commit;
import static com.h3.common.JDBCTemplate.getConnection;
import static com.h3.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.h3.boss.repository.BossDao;
import com.h3.boss.vo.BossVo;
import com.h3.traveler.repository.TravelerDao;
import com.h3.traveler.vo.TravelerVo;

public class BossService {
	private final BossDao dao = new BossDao();

	/*
	 * 회원가입
	 */
	public int join(BossVo vo) {

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
	
	}//join

	
	/*
	 * 로그인
	 */
	public BossVo login(BossVo vo) {

		Connection conn = null;
		BossVo BossLoginMember = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			BossLoginMember = dao.login(conn, vo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		//실행결과 리턴
		return BossLoginMember;
	
	
	}//login


	
	/*
	 * 마이페이지 - 회원정보 변경
	 * 
	 */
	public BossVo edit(BossVo vo) {

		Connection conn = null;
		int result = 0;
		BossVo updateVo = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			result = dao.edit(conn, vo);
			
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
	public BossVo selectOneByNo(int no) {

		Connection conn = null;
		BossVo vo = null;
		
		try {
			conn = getConnection();
			
			// dao 호출
			vo = new BossDao().selectOneByNo(conn, no);
			

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
	public int changePwd(String bossJoinId, String bossJoinPwd, String bossJoinPwdNew, String bossJoinPwdNew2) {

		// 비지니스 로직 검사
		if(bossJoinPwdNew.equals(bossJoinPwdNew2) == false) {
			System.out.println("신규 비밀번호가 일치하지 않습니다.");
			return -1;
		}
		
		
		Connection conn = null;
		int result = 0;
		
		try{
			conn = getConnection();
			
			// dao 호출
			result = dao.changePwd(conn, bossJoinId, bossJoinPwd, bossJoinPwdNew, bossJoinPwdNew2);
			
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
	public int quit(String bossJoinId, String bossJoinPwd, String bossJoinPwd2) {

		if(bossJoinPwd.equals(bossJoinPwd2) == false) {
			System.out.println("탈퇴-비밀번호가 서로 일치하지 않음");
			return -1;
		}
		
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			conn = getConnection();

			// dao 호출
			result = dao.quit(conn, bossJoinId, bossJoinPwd, bossJoinPwd2);
			
			
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
		
	
	
	}

	
}//class
