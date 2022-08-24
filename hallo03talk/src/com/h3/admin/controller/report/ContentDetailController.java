package com.h3.admin.controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
import com.h3.reportBoard.vo.ReportBoardVo;
@WebServlet(urlPatterns = "/admin/contentDetail")
public class ContentDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num = req.getParameter("num");
		
		
		
		 
		
		 //디비 가서 특정 정보 조회
		 ReportBoardVo vo =new AdminReportService().selectBoard(num);
		 
		
			 req.setAttribute("vo", vo);
			 req.getRequestDispatcher("/views/member/admin/detail/reportContentDetail.jsp").forward(req, resp);
		
	
	}

}
