package com.h3.searchDetail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.place.vo.PlaceVo;
import com.h3.searchDetail.service.SearchService;


@WebServlet (urlPatterns = "/searchDetail")
public class SearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//호출
		ArrayList<PlaceVo> pvoList = new SearchService().pselectList();
		
	}
	
}


