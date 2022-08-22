package com.h3.bossRegister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			String busNum = req.getParameter("busNum");
			//업태?
			String busStatus = req.getParameter("busStatus");
			//상호명
			String busName = req.getParameter("busName");
			//대표자명
			String busBoss = req.getParameter("busBoss");
			//생년월일S
			String busBirth = req.getParameter("busBirth");
			//주소
			String busAddress = req.getParameter("busAddress");
			
			//DB 가져오기
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String id="C##H3";
			String pwd="H3";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,id,pwd);
			
			String sql = "SELECT NO, NUM, STATUS, NAME, BOSSNAME, BIRTH, ADDRESS FROM REGISTER WHERE NUM= ? AND BIRTH= ?" ;
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,busNum);
			pstmt.setString(2,busBirth);
			
			ResultSet rs= pstmt.executeQuery(); 
			
			if(rs.next()) {
				
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String status = rs.getString("STATUS");
				String name = rs.getString("NAME");
				String bossName = rs.getString("BOSSNAME");
				String birth = rs.getString("BIRTH");
				String address = rs.getString("ADDRESS");
				
				//System.out.println(no);
				//System.out.println(num);
				//System.out.println(status);
				//System.out.println(name);
				//System.out.println(bossName);
				//System.out.println(birth);
				//System.out.println(address);
			}
			
			rs.next();
		
			
			//결과 보여주기
			req.getRequestDispatcher("views/member/boss/registerOk.jsp").forward(req, resp);

		}catch(Exception e) {
			System.out.println("인증 실패");
			e.printStackTrace();
		}
		
		
	}

}
