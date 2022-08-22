package com.h3.admin.controller.report;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
import com.h3.reportUser.vo.ReportUserVo;
@WebServlet(urlPatterns = "/admin/reportUser")
public class AdminReportUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//데이터 꺼내기 (클라이언트 가 보낸)
				//데이터 뭉치기 
				
				//서비스 호출
				ArrayList<ReportUserVo> voList  =	new AdminReportService().selectListUser();
				
				//결과에 따라 화면 선택
				
				
				
				req.setAttribute("voList", voList);
				req.getRequestDispatcher("/views/member/admin/reportUserAdmin.jsp").forward(req, resp);
				
			
		
		//resp.sendRedirect("/hallo03talk/views/member/admin/reportUserAdmin.jsp");
	}
}
