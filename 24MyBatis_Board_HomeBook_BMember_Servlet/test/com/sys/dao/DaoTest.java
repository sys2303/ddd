package com.sys.dao;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.HomeBookDAO;
import com.sys.dto.HomeBook;

public class DaoTest {

	public static void main(String[] args) {
		SqlSession session =MBUtils.getSession();
		HomeBookDAO dao = session.getMapper(HomeBookDAO.class);
		HomeBook vo = new HomeBook();
		vo.setSerialno(0L);
		vo.setDay("2019-08-01");
		vo.setSection("수입");
		vo.setAccountTitle("급료");
		vo.setRemark("8월 급료 수령");
		vo.setRevenue(4500000);
		vo.setExpense(0);
		vo.setUserId("hgd");
		System.out.println("저장될VO정보:");
		System.out.println(vo);
		dao.insert(vo);
		session.rollback();
	
		List<HomeBook> data = dao.selectAll();
		for(HomeBook x:data) {
			System.out.println(x);
		}
		session.close();
	}

}
