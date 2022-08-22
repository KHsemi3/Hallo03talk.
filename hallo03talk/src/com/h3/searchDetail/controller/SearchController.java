package com.h3.searchDetail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.community.vo.CommVo;
import com.h3.place.vo.PlaceVo;
import com.h3.placeReview.vo.PlaceReviewVo;
import com.h3.searchDetail.service.SearchService;
import com.h3.with.vo.WithVo;



@WebServlet (urlPatterns = "/searchPlace/searchDetail")
public class SearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//호출
		ArrayList<PlaceVo> pvoList = new SearchService().pselectList();
		ArrayList<PlaceReviewVo> rvoList = new SearchService().rselectList();
		ArrayList<CommVo> cvoList = new SearchService().cselectList();
		
		
		//결과에 따라 화면 만들기
		req.setAttribute("pvoList", pvoList);
		req.getRequestDispatcher("/views/search/searchDetail.jsp").forward(req, resp);
		
		req.setAttribute("rvoList", rvoList);
		req.getRequestDispatcher("/views/search/searchDetail.jsp").forward(req, resp);
		
		req.setAttribute("cvoList", cvoList);
		req.getRequestDispatcher("/views/search/searchDetail.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String placeKeyword =req.getParameter("placeKeyword");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String cate3 = req.getParameter("cate3");
		
		PlaceVo pvo = new PlaceVo();
		CommVo cvo = new CommVo();
		PlaceReviewVo rvo = new PlaceReviewVo();
		

	}
	
}


