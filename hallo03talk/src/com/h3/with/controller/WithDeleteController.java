package com.h3.with.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.with.service.WithService;

@WebServlet(urlPatterns = "/with/delete")
public class WithDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		
		int result = new WithService().delete(no);
		
		if(result == 1) {
			resp.sendRedirect(req.getContextPath() + "/with/list");
		}else {
			resp.sendRedirect(req.getContextPath() + "/with/list");
		}
	}
}
