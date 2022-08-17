package com.h3.reportUser.vo;

import java.sql.Timestamp;

public class ReportUserVo {
	
	public ReportUserVo() {
		
	}
	
	//신고 접수시 사용
	public ReportUserVo(
			String reUserGuil, 
			String reUserContent, 
			String reUserPro, 
			String reUserType, 
			String reUserTravelerNo) {
		this.reUserGuil = reUserGuil;
		this.reUserContent = reUserContent;
		this.reUserPro = reUserPro;
		this.reUserType = reUserType;
		this.reUserTravelerNo = reUserTravelerNo;
	}
	
	private int reUserNo;
	private String reUserGuil;
	private String reUserContent;
	private String reUserPro;
	private String reUserType;
	private String reUserTravelerNo;
	
	
	public ReportUserVo(int reUserNo, String reUserGuil, String reUserContent, String reUserPro, String reUserType,
			String reUserTravelerNo) {
		super();
		this.reUserNo = reUserNo;
		this.reUserGuil = reUserGuil;
		this.reUserContent = reUserContent;
		this.reUserPro = reUserPro;
		this.reUserType = reUserType;
		this.reUserTravelerNo = reUserTravelerNo;
	}


	public int getReUserNo() {
		return reUserNo;
	}


	public void setReUserNo(int reUserNo) {
		this.reUserNo = reUserNo;
	}


	public String getReUserGuil() {
		return reUserGuil;
	}


	public void setReUserGuil(String reUserGuil) {
		this.reUserGuil = reUserGuil;
	}


	public String getReUserContent() {
		return reUserContent;
	}


	public void setReUserContent(String reUserContent) {
		this.reUserContent = reUserContent;
	}


	public String getReUserPro() {
		return reUserPro;
	}


	public void setReUserPro(String reUserPro) {
		this.reUserPro = reUserPro;
	}


	public String getReUserType() {
		return reUserType;
	}


	public void setReUserType(String reUserType) {
		this.reUserType = reUserType;
	}


	public String getReUserTravelerNo() {
		return reUserTravelerNo;
	}


	public void setReUserTravelerNo(String reUserTravelerNo) {
		this.reUserTravelerNo = reUserTravelerNo;
	}


	@Override
	public String toString() {
		return "ReportUserVo [reUserNo=" + reUserNo + ", reUserGuil=" + reUserGuil + ", reUserContent=" + reUserContent
				+ ", reUserPro=" + reUserPro + ", reUserType=" + reUserType + ", reUserTravelerNo=" + reUserTravelerNo
				+ "]";
	}
	
	
	
	
	
	

	
	

	
	
	
	

}
