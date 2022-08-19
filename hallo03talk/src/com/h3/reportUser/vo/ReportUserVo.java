package com.h3.reportUser.vo;

import java.sql.Timestamp;

public class ReportUserVo {
	
	public ReportUserVo() {
		
	}
	
	
	private int no;
	private String guilty;
	private String content;
	private String process;
	private String reportedTravelerNo;
	
	
	public ReportUserVo(int no, String guilty, String content, String process, String reportedTravelerNo) {
		super();
		this.no = no;
		this.guilty = guilty;
		this.content = content;
		this.process = process;
		this.reportedTravelerNo = reportedTravelerNo;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getGuilty() {
		return guilty;
	}


	public void setGuilty(String guilty) {
		this.guilty = guilty;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getProcess() {
		return process;
	}


	public void setProcess(String process) {
		this.process = process;
	}


	public String getReportedTravelerNo() {
		return reportedTravelerNo;
	}


	public void setReportedTravelerNo(String reportedTravelerNo) {
		this.reportedTravelerNo = reportedTravelerNo;
	}


	@Override
	public String toString() {
		return "ReportUserVo [no=" + no + ", guilty=" + guilty + ", content=" + content + ", process=" + process
				+ ", reportedTravelerNo=" + reportedTravelerNo + "]";
	}
	
	
	
	
	
	
	
	

	

	
	

	
	
	
	

}
