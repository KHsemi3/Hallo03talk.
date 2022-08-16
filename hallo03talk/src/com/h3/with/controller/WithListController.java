package com.h3.with.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.with.service.WithService;
import com.h3.with.vo.WithVo;

@WebServlet(urlPatterns = "/with/list")
public class WithListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<WithVo> voList = new WithService().getList();
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/with/with_list.jsp").forward(req, resp);
	}
}
