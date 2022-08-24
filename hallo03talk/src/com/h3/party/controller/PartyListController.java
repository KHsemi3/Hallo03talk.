package com.h3.party.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossVo;
import com.h3.party.service.PartyPageService;


@WebServlet(urlPatterns="/party/list")
public class PartyListController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//이벤트 게시판 목록
		req.getRequestDispatcher("/views/party/list.jsp").forward(req,resp);
	

	}
}
