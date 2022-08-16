package com.h3.party.vo;

import java.sql.Timestamp;

public class PartyVo {
	
	public PartyVo() {
		
	}
	
	public PartyVo(int no, String title, String content, int cnt, Timestamp enroll_date, String status,
			int party_category, int boss_no, Timestamp modify_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.cnt = cnt;
		this.enroll_date = enroll_date;
		this.status = status;
		this.party_category = party_category;
		this.boss_no = boss_no;
		this.modify_date = modify_date;
	}
	
	private int no;
	private String title;
	private String content;
	private int cnt;
	private Timestamp enroll_date;
	private String status;
	private int party_category;
	private int boss_no;
	private Timestamp modify_date;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Timestamp getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(Timestamp enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getParty_category() {
		return party_category;
	}
	public void setParty_category(int party_category) {
		this.party_category = party_category;
	}
	public int getBoss_no() {
		return boss_no;
	}
	public void setBoss_no(int boss_no) {
		this.boss_no = boss_no;
	}
	public Timestamp getModify_date() {
		return modify_date;
	}
	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}
	
	
	@Override
	public String toString() {
		return "PartyVo [no=" + no + ", title=" + title + ", content=" + content + ", cnt=" + cnt + ", enroll_date="
				+ enroll_date + ", status=" + status + ", party_category=" + party_category + ", boss_no=" + boss_no
				+ ", modify_date=" + modify_date + "]";
	}
	
		
}
