package com.h3.zzim.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.place.vo.PlaceVo;
import com.h3.traveler.vo.TravelerVo;
import com.h3.zzim.service.ZzimService;

@WebServlet("/zzim/add")
public class ZzimAddController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		TravelerVo tv = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
		PlaceVo pv = (PlaceVo) req.getAttribute("placeVo");
		
		
		System.out.println(pv.getNo());
		
		
		int result = new ZzimService().zzimAdd(tv,pv);
		
		
		
	}
}
