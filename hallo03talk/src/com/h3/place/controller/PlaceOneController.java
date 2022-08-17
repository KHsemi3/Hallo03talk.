package com.h3.place.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.boss.service.BossService;
import com.h3.boss.vo.BossVo;
import com.h3.place.service.PlaceService;
import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

@WebServlet("/place/one")
public class PlaceOneController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String placeNo = (String) req.getParameter("placeNo");

		PlaceVo pv = new PlaceService().placeOne(placeNo);
		int result = new PlaceService().getCnt(placeNo);
		ArrayList<PlacePhotoVo> photoList = new PlaceService().photoOne(placeNo);
		BossVo bv = new BossService().selectOneByNo(Integer.parseInt(pv.getBossNo()));
		
		req.setAttribute("placeVo", pv);
		req.setAttribute("photoList", photoList);
		req.setAttribute("bossVoForShow", bv);
		
		if (result==1 && pv != null && photoList != null) {
			// 성공
			req.getRequestDispatcher("/views/place/onePlace.jsp").forward(req, resp);
		} else {
			// 실패
		}

	}
}
