package com.sys.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.sys.common.MBUtils;
import com.sys.dto.HomeBook;

public class TestOfHomeBookDAO {
	private HomeBookDAO dao;
	private SqlSession session;

	@Before // 각 테스트케이스가 실행되기전 작업할 것
	public void init() {
		session = MBUtils.getSession();
		dao = session.getMapper(HomeBookDAO.class);
	}

	@AfterClass // 모든 테스트케이스가 종료 된후 마지막 작업
	public static void byebye() {
		System.out.println("HomeBookDAO 테스트를 종료합니다.");
	}

	@Test
	public void 가계부자료입력성공테스트() {
		HomeBook vo = new HomeBook();
		vo.setSerialno(0L);// 자동증가필드기 때문에 의미없다.
		vo.setDay("2019-08-01");
		vo.setSection("수입");
		vo.setAccountTitle("급료");
		vo.setRemark("8월 급료 수령");
		vo.setRevenue(4500000);
		vo.setExpense(0);
		vo.setUserId("hgd");
		try {
			dao.insert(vo);
			assertTrue(true);// 에러가 나지않으면 정상
			session.rollback();
		} catch (Exception e) {
			assertTrue(false);// 에러가 나면 비정상
			session.rollback();
		}
		session.close();
	}

	@Test
	public void 가계부자료실패테스트() {
		HomeBook vo = new HomeBook();
		vo.setDay("2019-08-02");
		// 아래 2개의 정보를 배제시켜 db입력 에러를 유도
		// 왜 에러가 날까요? ~ 테이블 생성시 not null 조건을 주었기 때문에
		vo.setSection("수입");
		vo.setAccountTitle("급료");
		vo.setRemark("8월 급료 수령");
		vo.setRevenue(4500000);
		vo.setExpense(0);
		// vo.setUserId("hgd");//왜래키여서 null이 될수 없다.
		try {
			dao.insert(vo);
			assertTrue(false);// 에러 나지 않으면 비정상
			session.rollback();
		} catch (Exception e) {
			assertTrue(true);// 에러가 나면 정상
			session.rollback();
		}
		session.close();
	}

	@Test
	public void 가계부자료삭제실패테스트() {
		int num = dao.delete(999L);// 없는 번호
		if (num>0) {
			assertTrue(false);
		}else {
			assertTrue(true);
		}
		session.rollback();
		session.close();
	}
	@Test
	public void 가계부자료삭제성공테스트() {
		int num = dao.delete(1L);// 없는 번호
		if (num>0) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		session.rollback();
		session.close();
	}
	
	@Test 
	public void 가계부자료수정테스트() {
		HomeBook vo = dao.selectById(1L); 
		String old = vo.getRemark(); 
		vo.setRemark(old+":수정추가~~");
		String oldDate = vo.getDay();
		vo.setDay(oldDate.substring(0,10));
		dao.update(vo);
		session.commit();//업데이트의 완성 
		// 
		vo = dao.selectById(1L); 
		boolean isModified = vo.getRemark().contains(":수정추가~~");
		if(isModified) {
			assertTrue(true);
			// 원상복구작업 : 
			// 테스트로 인해 정상적인 데이터에 영향을 주면 안되기때문에
			vo.setRemark(old);
			vo.setDay(oldDate.substring(0,10));
			dao.update(vo);
			session.commit();
		}else {
			assertTrue(false);
		}
		session.close();
	}
	
	@Test 
	public void 가계부의모든자료읽기() {
		List<HomeBook> allData =dao.selectAll(); 
		if(allData!=null) {
			for(HomeBook x:allData) {
				System.out.println(x);
			}
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		session.close();
	}
}
