package com.h3.place.controller;

import java.io.IOException;
import java.util.ArrayList;
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
public class PlaceListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("categoryNo") != null && req.getParameter("cityNo") != null
				&& req.getParameter("insideNo") != null) {
			
			int categoryNo = Integer.parseInt(req.getParameter("categoryNo"));
			int cityNo = Integer.parseInt(req.getParameter("cityNo"));
			int insideNo = Integer.parseInt(req.getParameter("insideNo"));
			List<PlaceVo> placeList = new PlaceService().getList(categoryNo,cityNo,insideNo);

			req.setAttribute("categoryNo", categoryNo);
			req.setAttribute("cityNo", cityNo);
			req.setAttribute("insideNo", insideNo);
			req.setAttribute("placeList", placeList);
			
		} else {
			req.setAttribute("placeAlert", "변수 없음");
		}

		req.getRequestDispatcher("/views/place/placeList.jsp").forward(req, resp);
	}

}
