package com.sys.service;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.sys.common.MBUtils;
import com.sys.dto.HomeBook;
import com.sys.dto.TotalVO;
import com.sys.service.JDBCService;
import com.sys.service.ServiceDAO;

public class TestOfServiceDAO {
	private SqlSession session;
	private ServiceDAO service;
	private Connection conn;
	@Before
	public void init() {
		session = MBUtils.getSession();
		service = session.getMapper(ServiceDAO.class);
		conn = session.getConnection(); 
	}
	@AfterClass
	public static void bye() {
		System.out.println("서비스 테스트를 마칩니다.~~ ");
	}
	
	@Test 
	public void 회원별가계부총집계테스트() {
		List<TotalVO> sumData = service.getTotalList(); 
		for(TotalVO x:sumData) {
			System.out.println(x);
		}
		assertTrue(true);
		session.close();
		
	}
	@Test 
	public void 게시판게시글자료수테스트() {
		long total = service.countRows();
		System.out.println("게시글 총자료수는 "+total+"개 입니다.");
		session.close();
	} 
	
	@Test 
	public void 회원아이디로조회하는가계부내역() {
		List<HomeBook> data = 
				service.selectByUserId("hgd"); 
		System.out.println(">>> 지정아이디자료조회 <<<");
		for(HomeBook x:data) {
			
			System.out.println(x);
		}
		session.close();
	}
	
	@Test 
	public void 아이디와기간으로조회테스트() {
		//WHERE DAY BETWEEN #{startDay} AND #{endDay}
		//AND USER_ID = #{userId}
		Map<String,String> map = new HashMap<>();
		map.put("startDay", "2019-08-01");
		map.put("endDay", "2019-08-31");
		map.put("userId", "hgd");
		
		List<HomeBook> data = 
				service.selectBetweenData(map); 
		
		System.out.println(">>> 기간자료조회 <<<");
		for(HomeBook x:data) {
			System.out.println(x);
		}
		session.close();
	}
	
	@Test 
	public void jdbcServiceTest() throws SQLException {
		JDBCService service = new JDBCService(); 
		Map<String,Long> map = 
				service.getMemberInfor("hgd"); 
		System.out.println(map);
		System.out.println(">>>hgd회원의 사용정보<<<");
		System.out.println("===================================");
		System.out.println("게시글:"+map.get("boardNum")+"건");
		System.out.println("가계부사용건:"+map.get("homebookNum")+"건");
		System.out.println("총수입:"+map.get("revenueSum")+"건");
		System.out.println("총지출:"+map.get("expenseSum")+"건");
		System.out.println("===================================");

		
		
	}
	@Test
	public void homework() {
		Map<String,Long> map = 
				service.getUserInfor("hgd");
		System.out.println(map);
	}
	
	
}
