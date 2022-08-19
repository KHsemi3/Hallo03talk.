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
import com.h3.traveler.vo.TravelerVo;
import com.h3.zzim.service.ZzimService;
import com.h3.zzim.vo.ZzimVo;

@WebServlet("/place/list")
public class PlaceListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<PlaceVo> placeList = new PlaceService().getList();
		List<PlacePhotoVo> photoList = new PlaceService().getProfile();
		
		req.setAttribute("placeList", placeList);
		req.setAttribute("photoList", photoList);
		
		req.getRequestDispatcher("/views/place/placeList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("categoryNo") != null) {
			String categoryNo = req.getParameter("categoryNo");
			
			List<PlaceVo> placeList = new PlaceService().getList(categoryNo);
			List<PlacePhotoVo> photoList = new PlaceService().getProfile(categoryNo);
		}
		
		
		
	}
	
}
