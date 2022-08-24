package com.h3.admin.controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
import com.h3.reportUser.vo.ReportUserVo;
@WebServlet(urlPatterns = "/admin/userDetail")
public class UserDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		ReportUserVo vo =new AdminReportService().selectUser(num);
		 
		 
		 req.setAttribute("vo", vo);
		 req.getRequestDispatcher("/views/member/admin/detail/reportUserDetail.jsp").forward(req, resp);

	}

}
