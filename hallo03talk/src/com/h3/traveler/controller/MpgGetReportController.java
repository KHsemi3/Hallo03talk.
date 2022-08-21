package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/traveler/getReport")
public class MpgGetReportController extends HttpServlet{

	
	/*
	 * traveler - 신고 받은 내역
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		// 화면 보여주기 
		req.getRequestDispatcher("/views/member/traveler/travelerGetReportView.jsp").forward(req, resp);
			
	
	
	}//doGet
	
	
}//class
