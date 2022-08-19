package com.h3.boss.register.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원으로 로그인한 상태에서 장소 클릭했을 때, 장소 목록이 보여지지만, 사장님이 장소를 클릭헀을 경우, 사장님 인증 페이지로 넘어가게 해야함.

@WebServlet(urlPatterns="/member/boss/register")
public class BossRegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 받기
		//과세구분
		//사업자등록번호(숫자)
		//업태?
		//상호명
		//대표자명
		//생년월일
		//주소

		
	}

}
