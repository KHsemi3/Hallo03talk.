package com.h3.admin.controller.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminReportService;
import com.h3.reportComment.vo.ReportCommentVo;
@WebServlet(urlPatterns = "/admin/replyDetatil")
public class ReplyDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	 String num =  req.getParameter("num");
	 ReportCommentVo vo =new AdminReportService().selectReply(num);
	 
	 
		 req.setAttribute("vo", vo);
		 req.getRequestDispatcher("/views/member/admin/detail/reportReplyDetail.jsp").forward(req, resp);

}
}
