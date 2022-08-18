package com.h3.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.service.CommService;
import com.h3.community.vo.CommVo;

@WebServlet(urlPatterns = "/comm/list")
public class CommListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<CommVo> voList = new CommService().getList();
		
		
		req.setAttribute("voList", voList);
		System.out.println(voList);
		req.getRequestDispatcher("/views/community/comm_list.jsp").forward(req, resp);
	}
}
