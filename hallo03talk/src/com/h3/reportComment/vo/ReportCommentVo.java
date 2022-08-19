package com.h3.reportComment.vo;

public class ReportCommentVo {
	
	public ReportCommentVo() {
		
	}
	
	private int no;
	private String guilty;
	private String content;
	private String process;
	private String type;
	private String replyNo;
	
	
	public ReportCommentVo(int no, String guilty, String content, String process, String type, String replyNo) {
		super();
		this.no = no;
		this.guilty = guilty;
		this.content = content;
		this.process = process;
		this.type = type;
		this.replyNo = replyNo;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}


	@Override
	public String toString() {
		return "ReportCommentVo [no=" + no + ", guilty=" + guilty + ", content=" + content + ", process=" + process
				+ ", type=" + type + ", replyNo=" + replyNo + "]";
	}
	
	
	
	

	
	

}
