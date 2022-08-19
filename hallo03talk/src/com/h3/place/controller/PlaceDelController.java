package com.h3.place.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.place.service.PlaceService;

@WebServlet("/place/del")
public class PlaceDelController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String placeNo = (String)req.getParameter("placeNo");
		
		int result = new PlaceService().placeDel(placeNo);
		
		if (result == 1) {
			
		} else {
			
		}
		
	}
}
