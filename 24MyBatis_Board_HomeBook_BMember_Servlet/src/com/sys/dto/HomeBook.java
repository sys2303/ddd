package com.sys.dto;

public class HomeBook {
	private long serialno;
	private String day;// 
	private String section; 
	private String accountTitle;// ACCOUNT_TITLE 
	private String remark; 
	private int revenue;
	private int expense;
	private String userId; //USER_ID 
	
	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getAccountTitle() {
		return accountTitle;
	}
	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "HomeBook [serialno=" + serialno + ", day=" + day + ", section=" + section + ", accountTitle="
				+ accountTitle + ", remark=" + remark + ", revenue=" + revenue + ", expense=" + expense + ", userId="
				+ userId + "]";
	}

}
