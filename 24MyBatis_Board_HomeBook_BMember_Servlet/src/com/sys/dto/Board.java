package com.sys.dto;

import java.io.Serializable;

public class Board  implements Serializable{
	private long bno;//게시판번호
	private String mid;//등록회원 아이디
	private String btitle;//게시글 제목
	private String bcontent;//게시글 내용
	private String bdate;// 게시일자
	private int bhit;// 조회수
	private int bgroup;// 게시글 그룹
	private int bstep;// 댓글 스탭
	private int bindent; // 들여쓰기 정보 
	
	public long getBno() {
		return bno;
	}
	public void setBno(long bno) {
		this.bno = bno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", mid=" + mid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate="
				+ bdate + ", bhit=" + bhit + ", bgroup=" + bgroup + ", bstep=" + bstep + ", bindent=" + bindent + "]";
	} 
	
}
