package com.h3.with.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3.with.service.WithImgUploadService;


@WebServlet(urlPatterns = "/with/imgUpload")
public class WithImgUploadController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String base64Img = req.getParameter("img");
		String realPath = req.getServletContext().getRealPath("/resources/upload/with/");
		String data = new WithImgUploadService().saveImgReturnUrl(base64Img,realPath);
		
		resp.getWriter().write(data);
	}
}
