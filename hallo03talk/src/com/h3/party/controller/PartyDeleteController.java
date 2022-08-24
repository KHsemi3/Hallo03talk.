package com.h3.party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.party.service.PartyService;

@WebServlet(urlPatterns = "/notice/delete")
public class PartyDeleteController extends HttpServlet {
	
	/*
	 * 공지사항 삭제
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		int result = new PartyService().delete(num);
		
		if(result == 1) {
			//삭제 성공 //리스트로 보내기
			String cp = req.getContextPath();
			req.getSession().setAttribute("alertMsg", "이벤트 글 삭제 성공!");
			resp.sendRedirect(cp + "/party/list");
		}else {
			//삭제 실패 //에러페이지로 보내기
			req.setAttribute("errorMsg", "이벤트 글 삭제 실패");
			req.getRequestDispatcher("/views/party/errorPage.jsp").forward(req, resp);
		}
		
	}

}//class




















