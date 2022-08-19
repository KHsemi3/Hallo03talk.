package com.h3.traveler.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerMyPageVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/travelerMpgPost/delete")
public class MpgPostDeleteController extends HttpServlet{

	
	/*
	 * traveler - 내가 쓴 글 삭제
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TravelerVo loginTraveler = (TravelerVo)req.getSession().getAttribute("travelerLoginMember");
		
		String boardKr = (String)req.getParameter("board");
		
		String board = boardKr.equals("커뮤니티") ? "community" : (boardKr.equals("장소 리뷰") ? "place_review" : "_with");
		
		String no = (String)req.getParameter("no");
	
		new TravelerService().deletePost(no, board);
	
	}
	
	
	 
}//class
