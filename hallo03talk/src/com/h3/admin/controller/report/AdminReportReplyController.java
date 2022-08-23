package com.h3.admin.controller.report;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
import com.h3.reportComment.vo.ReportCommentVo;
@WebServlet(urlPatterns = "/admin/reportReply")
public class AdminReportReplyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReportCommentVo> voList  =new AdminReportService().selectListComment();
		
		//결과에 따라 화면 선택
		
		
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/member/admin/reportReplyAdmin.jsp").forward(req, resp);
		
	}

}
