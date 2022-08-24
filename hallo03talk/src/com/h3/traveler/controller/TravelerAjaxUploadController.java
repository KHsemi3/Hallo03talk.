package com.h3.traveler.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.h3.traveler.service.TravelerService;
import com.h3.traveler.vo.TravelerAttachmentVo;
import com.h3.traveler.vo.TravelerVo;

@WebServlet(urlPatterns = "/traveler/ajax")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
public class TravelerAjaxUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			TravelerVo loginTraveler = (TravelerVo) req.getSession().getAttribute("travelerLoginMember");
			
			String no = Integer.toString(loginTraveler.getNo());
			
			Part file = req.getPart("file");

			String originName = file.getSubmittedFileName();

			System.out.println(originName);

			// 서비스 호출
			String changeName = new TravelerService().createChangeName(originName);

			// 인풋 스트림 준비
			InputStream is = file.getInputStream();

			BufferedInputStream bis = new BufferedInputStream(is);

			// 아웃풋 스트림 준비 (서버에 저장하기 위함)
			String realPath = req.getServletContext().getRealPath("/resources/upload/traveler_profile");
			String savePath = realPath + File.separator + changeName;
			FileOutputStream os = new FileOutputStream(savePath); 
			BufferedOutputStream bos = new BufferedOutputStream(os); 

			byte[] buf = new byte[1024];
			int size = 0; // 사이즈 초기값 설정

			while ((size = bis.read(buf)) != -1) { 
													
				bos.write(buf, 0, size); 
			}

			bos.flush();
			bis.close();
			bos.close();

			// Attachment 테이블 관련데이터는 위에 준비 되어있는 상태임.(원본파일명, 변경파일명, 경로)
			// 준비된 데이터를 이용하여, 객체로 뭉치기
			TravelerAttachmentVo tav = new TravelerAttachmentVo();
			tav.setOriginName(originName);
			tav.setChangeName(changeName);
			tav.setFilePath(realPath);
			tav.setTravelerNo(no);
			
			new TravelerService().uploadProfilePic(tav);
			
			// 마이 페이지 내에서 사진 변경시 새션에도 새로 저장
			req.getSession().setAttribute("travelerAttachment", tav);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
