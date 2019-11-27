package com.sys.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.BMemberDAO;
import com.sys.dto.BMember;

public class MemberInforService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인된 회원 정보를 출력 합니다.....");
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter writer = response.getWriter(); 
		SqlSession sqlSession = MBUtils.getSession();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		BMemberDAO dao = null;
		BMember loginVo = null;
			try {
				dao = sqlSession.getMapper(BMemberDAO.class);
				loginVo = dao.selectById(id);
				System.out.println(loginVo);
				sqlSession.close();
				writer.print("<h1>"+loginVo+"</h1>");
				writer.print("<a href='../main.do'>메인화면</a><br>");
	
			} catch(Exception e) {
				//e.printStackTrace();
				//writer.print("<script>alert('로그인후 사용가능!');</script>");
				response.sendRedirect("../main.do");
				return false; 
			}	
		return true;
	}
}