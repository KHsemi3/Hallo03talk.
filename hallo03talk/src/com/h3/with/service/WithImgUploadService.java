package com.h3.with.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;


public class WithImgUploadService {

	public String saveImgReturnUrl(String base64Img, String realPath) {

		String fileName = UUID.randomUUID().toString() + ".jpg";
		String savePath = realPath + fileName;
		System.out.println(savePath);
		String base64 = base64Img.replace("data:image/jpeg;base64,", "");

		byte[] decode = Base64.getDecoder().decode(base64);
		
		//savePath에 저장
		try {
			FileOutputStream imageOutput = new FileOutputStream(savePath);
			imageOutput.write(decode);
			imageOutput.flush();
			imageOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return savePath;
	}

	
}
