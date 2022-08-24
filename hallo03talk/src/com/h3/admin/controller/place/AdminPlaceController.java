package com.h3.admin.controller.place;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.admin.service.AdminPlaceService;
import com.h3.place.vo.PlaceVo;
@WebServlet(urlPatterns = "/admin/placeAdmin")
public class AdminPlaceController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<PlaceVo> voList  =	new AdminPlaceService().selectListPlace();
		
		//결과에 따라 화면 선택
		System.out.println(voList.size());
		
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/member/admin/placeAdmin.jsp").forward(req, resp);
		
	}

}
