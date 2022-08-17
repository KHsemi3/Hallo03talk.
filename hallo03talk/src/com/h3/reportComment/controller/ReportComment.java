package com.h3.reportComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

	}

}
