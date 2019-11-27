package com.sys.service;
import java.util.List;
import java.util.Map;

import com.sys.dto.HomeBook;
import com.sys.dto.TotalVO;
public interface ServiceDAO {
	// 테이블당 CRUD하는 작업외의 기능과
	// 여러 개의 DAO를 사용하여 만들어 내는 새로운 기능을 
	// 정의하여 쓰거나,
	// 웹의 경우 웹 화면단기능(웹서비스) 중심으로 
	// 서버 프로그램의 기능을 엮은 것을 말합니다. 
	
	public List<TotalVO> getTotalList(); 
	public long countRows(); 
	public List<HomeBook> selectByUserId(String userId);
	//(String userId,String startDay,String endDay);
	public List<HomeBook> selectBetweenData(Map<String,String> map);
	public Map<String,Long> getUserInfor(String id);
	// 
}