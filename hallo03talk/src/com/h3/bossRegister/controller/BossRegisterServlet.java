package com.h3.bossRegister.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원으로 로그인한 상태에서 장소 클릭했을 때, 장소 목록이 보여지지만, 사장님이 장소를 클릭헀을 경우, 사장님 인증 페이지로 넘어가게 해야함.

@WebServlet(urlPatterns="/bossRegister")
public class BossRegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//사장님 인증받기
			
			//사업자등록번호(숫자)
			req.setCharacterEncoding("UTF-8");
			String num = req.getParameter("busNum");
			//업태?
			String status = req.getParameter("busStatus");
			//상호명
			String name = req.getParameter("busName");
			//대표자명
			String bossName = req.getParameter("busBoss");
			//생년월일S
			String birth = req.getParameter("busBirth");
			//주소
			String address = req.getParameter("busAddress");
			
			//데이터 확인
			boolean isSuccess = true;
			
			//DB 가져오기
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String id="C##H3";
			String pwd="H3";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,id,pwd);
			
			String sql = SELECT NO, NUM, STATUS, NAME, BOSSNAME, BIRTH, ADDRESS FROM REGISTER WHERE NUM= ? AND BIRTH= ? ;
			
			
			//결과 보여주기
			req.getRequestDispatcher("views/member/boss/registerOk.jsp").forward(req, resp);

		}catch(Exception e) {
			System.out.println("인증 실패");
			e.printStackTrace();
		}
		
		
	}

}
