package com.sys.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.BMemberDAO;
import com.sys.dao.HomeBookDAO;
import com.sys.dto.BMember;
import com.sys.dto.HomeBook;

public class HomeBookInsertService implements Service {
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 가계부 자료를 데이터베이스에 반영
		System.out.println("가계부 자료를 등록합니다.....");
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		// String id = (String) session.getAttribute("mid");
		SqlSession sqlSession = MBUtils.getSession();

		HomeBookDAO dao = sqlSession.getMapper(HomeBookDAO.class);
		HomeBook vo = new HomeBook();
		response.setContentType("text/html;charset=UTF-8");
		// vo.setSerialno(serialno);// 자동이기때문에
		vo.setDay(request.getParameter("day"));
		vo.setSection(request.getParameter("section"));
		vo.setAccountTitle(request.getParameter("accountTitle"));
		vo.setRemark(request.getParameter("remark"));
		vo.setRevenue(Integer.parseInt(request.getParameter("revenue")));
		vo.setExpense(Integer.parseInt(request.getParameter("expense")));
		vo.setUserId(request.getParameter("userId"));

		PrintWriter writer = response.getWriter();

		try {
			dao.insert(vo);
			sqlSession.commit();// 빠트리지 마시압!
			sqlSession.close();
			writer.print("<h1>등록한 가계부 내역</h1><hr>");
			writer.print(vo);
			
			
			writer.print("<a href='form_homebook.jsp'>처음화면</a>");

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
