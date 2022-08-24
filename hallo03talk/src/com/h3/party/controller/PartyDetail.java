package com.h3.party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.party.service.PartyService;
import com.h3.party.vo.PartyVo;

@WebServlet(urlPatterns = "/notice/detail")
public class PartyDetail extends HttpServlet {
	
	
	/*
	 * 공지사항 상세조회 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// num번 공지사항 조회수 증가
		String num = req.getParameter("num");
		
		int result = new PartyService().increaseParty(num);
		
		if(result == 1) {
			// 디비에 가서, 특정 공지사항 정보 조회
			PartyVo vo = new PartyService().selectOne(num);
			
			// 정보를 req에 담아서 , 다음타자한테 포워딩
			if(vo != null) {
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/views/party/list.jsp").forward(req, resp);
			}else {
				//조회 실패
				req.setAttribute("errorMsg", "이벤트 안내 상세 조회 실패..");
				req.getRequestDispatcher("/views/party/errorPage.jsp").forward(req, resp);
			}
			
		}else {
			// 조회 실패
			//req 에 데이터 담고, 다음타자(화면)
			req.setAttribute("errorMsg", "이벤트 안내 상세 조회 실패..");
			req.getRequestDispatcher("/views/party/errorPage.jsp").forward(req, resp);
		}
		
		
		
	}

}//class

























