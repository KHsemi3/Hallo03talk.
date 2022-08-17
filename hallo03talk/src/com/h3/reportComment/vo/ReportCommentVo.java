package com.h3.reportComment.vo;

public class ReportCommentVo {
	
	private int reCommNo;
	private String reCommGuil;
	private String reCommContent;
	private String reCommPro;
	private String reCommType;
	private String reCommContentNo;
	
	
	public ReportCommentVo(int reCommNo, String reCommGuil, String reCommContent, String reCommPro, String reCommType,
			String reCommContentNo) {
		super();
		this.reCommNo = reCommNo;
		this.reCommGuil = reCommGuil;
		this.reCommContent = reCommContent;
		this.reCommPro = reCommPro;
		this.reCommType = reCommType;
		this.reCommContentNo = reCommContentNo;
	}


	public int getReCommNo() {
		return reCommNo;
	}


	public void setReCommNo(int reCommNo) {
		this.reCommNo = reCommNo;
	}


	public String getReCommGuil() {
		return reCommGuil;
	}


	public void setReCommGuil(String reCommGuil) {
		this.reCommGuil = reCommGuil;
	}


	public String getReCommContent() {
		return reCommContent;
	}


	public void setReCommContent(String reCommContent) {
		this.reCommContent = reCommContent;
	}


	public String getReCommPro() {
		return reCommPro;
	}


	public void setReCommPro(String reCommPro) {
		this.reCommPro = reCommPro;
	}


	public String getReCommType() {
		return reCommType;
	}


	public void setReCommType(String reCommType) {
		this.reCommType = reCommType;
	}


	public String getReCommContentNo() {
		return reCommContentNo;
	}


	public void setReCommContentNo(String reCommContentNo) {
		this.reCommContentNo = reCommContentNo;
	}


	@Override
	public String toString() {
		return "ReportCommentVo [reCommNo=" + reCommNo + ", reCommGuil=" + reCommGuil + ", reCommContent="
				+ reCommContent + ", reCommPro=" + reCommPro + ", reCommType=" + reCommType + ", reCommContentNo="
				+ reCommContentNo + "]";
	}
	
	
	
	
	

}
