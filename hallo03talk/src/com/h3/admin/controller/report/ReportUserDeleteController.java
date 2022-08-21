package com.h3.admin.controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
@WebServlet(urlPatterns = "/admin/reportUserDelete")
public class ReportUserDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num =req.getParameter("num");
		
		int result =new AdminReportService().deleteUser(Integer.parseInt(num));
			System.out.println(result);
		if(result == 1 ) {
			resp.sendRedirect("/admin/reportUser");
			return;
		}else {
			req.setAttribute("errorMsg", "공지사항 삭제 실패");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
			return;
		}
		
	}

}
