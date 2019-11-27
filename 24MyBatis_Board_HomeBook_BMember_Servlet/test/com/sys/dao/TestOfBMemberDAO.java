package com.sys.dao;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.sys.common.MBUtils;
import com.sys.dto.BMember;


public class TestOfBMemberDAO {
	private BMemberDAO dao;
	private SqlSession session;

	@Before // 각 테스트케이스가 실행되기전 작업할 것
	public void init() {
		session = MBUtils.getSession();
		dao = session.getMapper(BMemberDAO.class);
	}

	@AfterClass // 모든 테스트케이스가 종료 된후 마지막 작업
	public static void byebye() {
		System.out.println("BMemberDAO 테스트를 종료합니다.");
	}

	@Test
	public void 자료입력성공테스트() {
		BMember vo = new BMember();
		vo.setMid("PDJ");
		vo.setMname("박두진");
		vo.setMpassword("1234");
		vo.setMphone("010-2222-3333");
		vo.setMjoinDate("2019-08-02");
		
		try {
			dao.insert(vo);
			assertTrue(true);// 파란줄 내보내라
			session.rollback();// 테스트영향을 없애기 위해 
		} catch (Exception e) {
			assertTrue(false);// 빨간줄 내보내라
			session.rollback();
		}
		session.close();//메모리 청소 
	}

	@Test
	public void 자료입력실패테스트() {
		BMember vo = new BMember();
		//vo.setMid("PDJ");
		vo.setMname("박두진");
		vo.setMpassword("1234");
		vo.setMphone("010-2222-3333");
		vo.setMjoinDate("2019-08-02");
	
		try {
			dao.insert(vo);
			assertTrue(false);// 빨간줄내보내라
			session.rollback();
		} catch (Exception e) {
			assertTrue(true);// 녹색줄내보내라 
			session.rollback();
		}
		session.close();
	}
//
	@Test
	public void 자료삭제실패테스트() {
		int num = dao.delete("xxxxxxxxxxxx");// 없는 번호
		if (num>0) { 
			assertTrue(false);
		}else {
			assertTrue(true);
		}
		session.rollback();
		session.close();
	}
	
	@Test
	public void 자료삭제실패테스트2() {
		// 제약조건으로 연결된 자료가 있는 경우 
		// 무결성강화 확인 
		int num =0;
		try {
			num = dao.delete("hgd");
			assertTrue(false);
		}catch(Exception e) {
			assertTrue(true);
		}
		session.rollback();
		session.close();
	}
	
	@Test
	public void 자료삭제성공테스트() {
		// 제약조건으로 연결된 자료가 없는 경우 
		// 무결성강화와 관련없는 회원 
		int num =0;
		try {
			num = dao.delete("ggc");
			assertTrue(true);
		}catch(Exception e) {
			assertTrue(false);
		}
		session.rollback();
		session.close();
	}
		
	@Test 
	public void 자료수정테스트() {
		BMember vo = dao.selectById("hgd"); 
		String old = vo.getMname(); 
		vo.setMname(old+"999");
		String oldDate = vo.getMjoinDate();
		vo.setMjoinDate(oldDate.substring(0,10));
		dao.update(vo);
		session.commit();//업데이트의 완성 
		// 
		vo = dao.selectById("hgd"); 
		boolean isModified = vo.getMname().contains("999");
		if(isModified) {
			assertTrue(true);
			// 원상복구작업 : 
			// 테스트로 인해 정상적인 데이터에 영향을 주면 안되기때문에
			vo.setMname(old);
			vo.setMjoinDate(oldDate.substring(0,10));
			dao.update(vo);
			session.commit();
		}else {
			assertTrue(false);
		}
		session.close();
	}
//	
	@Test 
	public void 모든자료읽기() {
		List<BMember> allData =dao.selectAll(); 
		if(allData!=null) {
			for(BMember x:allData) {
				System.out.println(x);
			}
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		session.close();
	}
}
