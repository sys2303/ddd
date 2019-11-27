package com.sys.dto;

public class TotalVO {
	// 테이블과 직접 매핑 되지 않습니다.
	// 질의결과나 뷰와 매핑시킬 수 있습니다. 
	// 2개의 테이블과 관련되어 있습니다. 
	// BMember, HomeBook 
	private String memId; 
	private String memName; 
	private int sumOfRevenue; 
	private int sumOfExpense;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getSumOfRevenue() {
		return sumOfRevenue;
	}
	public void setSumOfRevenue(int sumOfRevenue) {
		this.sumOfRevenue = sumOfRevenue;
	}
	public int getSumOfExpense() {
		return sumOfExpense;
	}
	public void setSumOfExpense(int sumOfExpense) {
		this.sumOfExpense = sumOfExpense;
	}
	@Override
	public String toString() {
		return "TotalVO [memId=" + memId + ", memName=" + memName + ", sumOfRevenue=" + sumOfRevenue + ", sumOfExpense="
				+ sumOfExpense + "]";
	} 
	
}
