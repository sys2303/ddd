package com.sys.service;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.BMemberDAO;
import com.sys.dto.BMember;

public class AllMemberListService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 관리자가 모든 회원의 정보를 얻는 서비스 
		System.out.println("모든 회원의 정보를 조회합니다.");
		request.setCharacterEncoding("utf-8");
		SqlSession sqlSession = MBUtils.getSession();
		BMemberDAO dao = sqlSession.getMapper(BMemberDAO.class);
		List<BMember> memList = dao.selectAll(); 
		
		//response.setContentType("text/html;charset=UTF-8" );
		//PrintWriter writer = response.getWriter();
		//for(BMember x:memList) {
		//	writer.print(x.getMname()+"<br>");
		//}
		// 다른 페이지로 넘겨서 처리하는 방법 
		request.setAttribute("memList",memList);
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/mymember/allMemberList.jsp"); 
		dispatcher.forward(request,response);
		return true;
	}

}
