package com.sys.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.HomeBookDAO;
import com.sys.dto.HomeBook;

public class HomeBookAdjustService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("가계부정보를 수정 합니다.....");
		HomeBook vo = new HomeBook();
		long serialno = Long.parseLong(request.getParameter("serialno"));
		String day = request.getParameter("day").substring(0,10);
		String section = request.getParameter("section");
		String accountTitle = request.getParameter("accountTitle");
		String remark = request.getParameter("remark");
		int revenue = Integer.parseInt(request.getParameter("revenue"));
		int expense = Integer.parseInt(request.getParameter("expense"));
		String userId = request.getParameter("userId");
		vo.setSerialno(serialno);
		vo.setDay(day);
		vo.setSection(section);
		vo.setAccountTitle(accountTitle);
		vo.setRemark(remark);
		vo.setRevenue(revenue);
		vo.setExpense(expense);
		vo.setUserId(userId);
		
		
		SqlSession sqlSession  = MBUtils.getSession(); 
		HomeBookDAO dao = sqlSession.getMapper(HomeBookDAO.class);

		
		dao.update(vo);
		vo.setSerialno(serialno);
		sqlSession.commit();
		sqlSession.close();
		
		response.sendRedirect("./datadisp2.jsp");
		
		return true;
	}

}