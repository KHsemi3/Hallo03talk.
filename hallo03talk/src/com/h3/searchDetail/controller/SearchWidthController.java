package com.h3.searchDetail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.searchDetail.service.SearchWidthService;
import com.h3.with.vo.WithVo;

@WebServlet (urlPatterns = "/searchWidth/searchWidthDetail")
public class SearchWidthController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<WithVo> wvoList = new SearchWidthService().wselectList();
		
		System.out.println(wvoList);
		
		
		//결과에 따라 화면 만들기
		req.setAttribute("wvoList", wvoList);
		req.getRequestDispatcher("/views/search/searchWidthDetail.jsp").forward(req, resp);
		
	}
	

}
