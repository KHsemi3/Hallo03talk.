package com.h3.traveler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/traveler/ajax")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
public class TravelerAjaxUploadController extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==");
		
	Part part = req.getPart("f");
	
	System.out.println("part "+ part);
	
	System.out.println("part "+ part.getName());
	}
	
	
}//class
