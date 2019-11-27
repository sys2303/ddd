package com.sys.dto;

public class BMember {
	
	private String mid;//회원아이디
	private String mname;//회원이름
	private String mpassword;//회원패스워드
	private String mphone;//회원전화번호
	private String mjoinDate;//가입일자 
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMjoinDate() {
		return mjoinDate;
	}
	public void setMjoinDate(String mjoinDate) {
		this.mjoinDate = mjoinDate;
	}
	@Override
	public String toString() {
		return "BMember [mid=" + mid + ", mname=" + mname + ", mpassword=" + mpassword + ", mphone=" + mphone
				+ ", mjoinDate=" + mjoinDate + "]";
	}
	
	
}
