package com.h3.reportBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "경로")
public class ReportBoard extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/게시물 신고 경로").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String reBoardNo = req.getParameter("reBoardNo");
		String reBoardGuil = req.getParameter("reBoardGuil");
		String reBoardContent = req.getParameter("reBoardContent");
		String reBoardPro = req.getParameter("reBoardPro");
		String reBoardType = req.getParameter("reBoardType");
		String reBoardContentNo = req.getParameter("reBoardContentNo");
		
		
		//신고 타입 없을때에 방어
		String guilty = "";
		if(reBoardGuil != null) {
			guilty = String.join(",", reBoardGuil);
		}

	}
}
