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
		String[] num =req.getParameterValues("num");
		
		int[] dNum = new int [num.length];
		for(int i = 0; i< num.length; i ++)
			dNum[i] = Integer.parseInt(num[i]);
		
			
			int result = new AdminReportService().deleteUser(dNum);
				
			
		
			
			req.getRequestDispatcher("/admin/reportUser").forward(req, resp);
			
			
		
		
	}

}
