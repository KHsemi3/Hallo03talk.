package com.h3.reportBoard.vo;

public class ReportBoardVo {
	
	private int reBoardNo;
	private String reBoardGuil;
	private String reBoardContent;
	private String reBoardPro;
	private String reBoardType;
	private String reBoardContentNo;
	
	
	public ReportBoardVo(int reBoardNo, String reBoardGuil, String reBoardContent, String reBoardPro,
			String reBoardType, String reBoardContentNo) {
		super();
		this.reBoardNo = reBoardNo;
		this.reBoardGuil = reBoardGuil;
		this.reBoardContent = reBoardContent;
		this.reBoardPro = reBoardPro;
		this.reBoardType = reBoardType;
		this.reBoardContentNo = reBoardContentNo;
	}


	public int getReBoardNo() {
		return reBoardNo;
	}


	public void setReBoardNo(int reBoardNo) {
		this.reBoardNo = reBoardNo;
	}


	public String getReBoardGuil() {
		return reBoardGuil;
	}


	public void setReBoardGuil(String reBoardGuil) {
		this.reBoardGuil = reBoardGuil;
	}


	public String getReBoardContent() {
		return reBoardContent;
	}


	public void setReBoardContent(String reBoardContent) {
		this.reBoardContent = reBoardContent;
	}


	public String getReBoardPro() {
		return reBoardPro;
	}


	public void setReBoardPro(String reBoardPro) {
		this.reBoardPro = reBoardPro;
	}


	public String getReBoardType() {
		return reBoardType;
	}


	public void setReBoardType(String reBoardType) {
		this.reBoardType = reBoardType;
	}


	public String getReBoardContentNo() {
		return reBoardContentNo;
	}


	public void setReBoardContentNo(String reBoardContentNo) {
		this.reBoardContentNo = reBoardContentNo;
	}


	@Override
	public String toString() {
		return "ReportBoardVo [reBoardNo=" + reBoardNo + ", reBoardGuil=" + reBoardGuil + ", reBoardContent="
				+ reBoardContent + ", reBoardPro=" + reBoardPro + ", reBoardType=" + reBoardType + ", reBoardContentNo="
				+ reBoardContentNo + "]";
	}
	
	
	
	

}
