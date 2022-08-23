package com.h3.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommService;
import com.h3.community.vo.CommReplyVo;
import com.h3.community.vo.CommVo;

@WebServlet(urlPatterns = "/comm/detail")
public class ConnDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no =req.getParameter("no");
		
		CommVo vo = new CommService().getOne(no);
		ArrayList<CommReplyVo> replyList = new CommService().getReplyList(no);
		
		req.setAttribute("vo", vo);
		req.setAttribute("replyList", replyList);
		
		if(vo == null) {
			req.getSession().setAttribute("alertMsg", "게시글 조회 실패");
			resp.sendRedirect(req.getContextPath()+"/comm/list");
		}else {
			req.getRequestDispatcher("/views/community/comm_detail.jsp").forward(req, resp);
		}
	}
}
