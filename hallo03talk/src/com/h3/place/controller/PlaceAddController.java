package com.h3.place.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.h3.place.service.PlaceService;
import com.h3.place.vo.PlaceVo;
import com.h3.placePhoto.vo.PlacePhotoVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 100,
		maxRequestSize = 1024 * 1024 * 100 * 1
)
@WebServlet("/place/add")
public class PlaceAddController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = (String)req.getParameter("placeName");
		String content = (String)req.getParameter("placeContent");
		String address = (String)req.getParameter("placeAddr");
		String bossNo = "1";
		String categoryNo = (String)req.getParameter("category_no");
		
		PlaceVo placeVo = new PlaceVo();
		placeVo.setName(name);
		placeVo.setContent(content);
		placeVo.setAddress(address);
		placeVo.setBossNo(bossNo);
		placeVo.setCategoryNo(categoryNo);
		
//		사진 한장 저장시
		PlacePhotoVo photoVo = new PlacePhotoVo();
//		슬라이드 사진 저장
		ArrayList<PlacePhotoVo> photoVoList = new ArrayList<PlacePhotoVo>();
		ArrayList<Part> fileList = (ArrayList<Part>) req.getParts();
		String realPath = req.getServletContext().getRealPath("/resources/upload/place");
//		에러날시 파일 삭제를 위한 파일명들
		ArrayList<String> delPhotos = new ArrayList<String>();
		
		
		
		for(int i = 0; i < fileList.size(); i++ ) {
			if(fileList.get(i).getName().equals("slideImgs")) {
				Part f = fileList.get(i);
				String originName = f.getSubmittedFileName();
				String photoName = new PlaceService().changeName(originName);
				
				InputStream is = f.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				
				FileOutputStream os = new FileOutputStream(realPath+File.separator+photoName);
				BufferedOutputStream bos = new BufferedOutputStream(os);
				
				
				byte [] buf = new byte[1024];
				int size = 0;
				while((size=bis.read(buf)) != -1) {
					bos.write(buf,0,size);
				}
				
				bos.flush();
				bis.close();
				bos.close();
				
				PlacePhotoVo pv = new PlacePhotoVo();
				delPhotos.add(photoName);
				pv.setName(photoName);
				pv.setPath(realPath);
				
				photoVoList.add(pv);
			}
		}
		
		
		
		
		int result = new PlaceService().placeAdd(placeVo,photoVoList);
		
		if(result == 1) {
			
		} else {
			for(int i = 0; i < delPhotos.size(); i++ ) {
					new File(realPath + File.separator + delPhotos.get(i)).delete();
			}
		}
		
		System.out.println(result);
	}
}
