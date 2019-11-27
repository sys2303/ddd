package com.sys.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.BMemberDAO;
import com.sys.dao.HomeBookDAO;
import com.sys.dto.BMember;
import com.sys.dto.HomeBook;

public class AllHomeBookListService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 관리자가 모든 회원의 정보를 얻는 서비스 
		System.out.println("모든 가계부 정보를 조회합니다.");
		request.setCharacterEncoding("utf-8");
		SqlSession sqlSession = MBUtils.getSession();
		HomeBookDAO dao = sqlSession.getMapper(HomeBookDAO.class);
		List<HomeBook> bookList = dao.selectAll(); 
		response.setContentType("text/html;charset=UTF-8" );
		// 다른 페이지로 넘겨서 처리하는 방법 
		HttpSession session = request.getSession();
		session.setAttribute("bookList",bookList);
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/homebook/allBookList.jsp"); 
		dispatcher.forward(request,response);
		return true;
	}

}
