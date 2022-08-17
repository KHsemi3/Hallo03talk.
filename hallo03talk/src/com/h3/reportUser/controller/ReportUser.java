package com.h3.reportUser.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.reportUser.vo.ReportUserVo;


public class ReportUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String reUserNo = req.getParameter("reUserNo");
		String reUserGuil = req.getParameter("reUserGuil");
		String reUserContent = req.getParameter("reUserContent");
		String reUserPro = req.getParameter("reUserPro");
		String reUserType = req.getParameter("reUserType");
		String reUserTravelerNo = req.getParameter("reUserTravelerNo");
		
		
		//신고 타입 없을때에 방어
		String guilty = "";
		if(reUserGuil != null) {
			guilty = String.join(",", reUserGuil);
		}
		
//		ReportUserVo vo = new ReportUserVo(
//				reUserNo,
//				reUserGuil,
//				reUserContent,
//				reUserPro,
//				reUserType,
//				reUserTravelerNo,
//				guilty
//				);  


		
	}
	
}
