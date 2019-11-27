package com.sys.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import com.sys.common.MBUtils;
import com.sys.dto.Board;
import com.sys.dto.HomeBook;

public class TestOfBoardDAO {
	private BoardDAO dao;
	private SqlSession session;

	@Before // 각 테스트케이스가 실행되기전 작업할 것
	public void init() {
		session = MBUtils.getSession();
		dao = session.getMapper(BoardDAO.class);
	}

	@AfterClass // 모든 테스트케이스가 종료 된후 마지막 작업
	public static void byebye() {
		System.out.println("BoardDAO 테스트를 종료합니다.");
	}

	@Test
	public void 자료입력성공테스트() {
//		private long bno;//게시판번호
//		private String mid;//등록회원 아이디
//		private String btitle;//게시글 제목
//		private String bcontent;//게시글 내용
//		private String bdate;// 게시일자
//		private int bhit;// 조회수
//		private int bgroup;// 게시글 그룹
//		private int bstep;// 댓글 스탭
//		private int bindent; // 들여쓰기 정보 
		Board vo = new Board();
		vo.setBno(0L);// 자동증가필드기 때문에 의미없다.
		vo.setMid("hgd");
		vo.setBtitle("무더위의 연속");
		vo.setBcontent("연일 무더위가 연속되니 몸관리 잘하세요~~");
		vo.setBdate("2019-08-02");
		vo.setBhit(0);
		vo.setBgroup(1);
		vo.setBstep(1);
		vo.setBindent(0);
		
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
	public void 자료입력실패테스트() {
		Board vo = new Board();
		vo.setBno(0L);// 자동증가필드기 때문에 의미없다.
		//vo.setMid("hgd");
		//vo.setBtitle("무더위의 연속");
		vo.setBcontent("연일 무더위가 연속되니 몸관리 잘하세요~~");
		vo.setBdate("2019-08-02");
		vo.setBhit(0);
		vo.setBgroup(1);
		vo.setBstep(1);
		vo.setBindent(0);
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
	public void 자료삭제실패테스트() {
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
	public void 자료삭제성공테스트() {
		int num = dao.delete(2L);
		if (num>0) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		session.rollback();
		session.close();
	}
//	
	@Test 
	public void 자료수정테스트() {
		Board vo = dao.selectById(2L); 
		String old = vo.getBtitle(); 
		vo.setBtitle(old+"~~~~~메롱");
		String oldDate = vo.getBdate();
		vo.setBdate(oldDate.substring(0,10));
		dao.update(vo);
		session.commit();//업데이트의 완성 
		// 
		vo = dao.selectById(2L); 
		boolean isModified = vo.getBtitle().contains("~~~~~메롱");
		if(isModified) {
			assertTrue(true);
			// 원상복구작업 : 
			// 테스트로 인해 정상적인 데이터에 영향을 주면 안되기때문에
			vo.setBtitle(old);
			vo.setBdate(oldDate.substring(0,10));
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
		List<Board> allData =dao.selectAll(); 
		if(allData!=null) {
			for(Board x:allData) {
				System.out.println(x);
			}
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		session.commit();
		session.close();
	}
}