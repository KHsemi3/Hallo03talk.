package com.h3.reportComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.reportUser.controller.reportService;


public class ReportComment extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String reCommNo = req.getParameter("reCommNo");
		String reCommGuil = req.getParameter("reCommGuil");
		String reCommContent = req.getParameter("reCommContent");
		String reCommPro = req.getParameter("reCommPro");
		String reCommType = req.getParameter("reCommType");
		String reCommContentNo = req.getParameter("reCommContentNo");
		
		
		//신고 타입 없을때에 방어
		String guilty = "";
		if(reCommContentNo != null) {
			guilty = String.join(",", reCommContentNo);
		}
		
		//		ReportUserVo vo = new ReportUserVo(
		//		reUserGuil,
		//		reUserContent,
		//		reUserPro,
		//		reUserType,
		//		reUserTravelerNo,
		//		guilty
		//		);  
		
		//객체 이용해서 신고 진행
		int result = new reportService().join(vo);
		
		//insert 결과를 가지고, 화면 선택
		if(result == 1) {
			//신고 성공
			// + 메세지 담기 //alert 창으로 
			resp.sendRedirect("/hallo03talk");
		}else {
			//신고 실패 //이전 페이지로 옮기기
			resp.sendRedirect("/hallo03talk/index.jsp");
		}

	}

}
