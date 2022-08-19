package com.h3.searchDetail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/searchDetail")
public class SearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//list?f=title&q=a >>이런 형식으로 받아오는
		String field_ = req.getParameter("f");
		String query_ = req.getParameter("p");
		
		//입력값이 null일때
		String field = "title";
		if(field_ !=null) {
			field = field_;
		}
		
		String query = "";
		if(query_ !=null) {
			query = query_;
		}
	}

	
}


