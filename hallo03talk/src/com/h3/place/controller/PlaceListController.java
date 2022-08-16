package com.h3.place.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.place.service.PlaceService;
import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

@WebServlet("/place/list")
public class PlaceListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		int cnt = new PlaceService().getCount();
		List<PlaceVo> voList = new PlaceService().getList();
		List<PlacePhotoVo> photoList = new PlaceService().getProfile();
		
		req.setAttribute("placeList", voList);
		req.setAttribute("photoList", photoList);
		
		req.getRequestDispatcher("/views/place/placeList.jsp").forward(req, resp);
	}
	
}
