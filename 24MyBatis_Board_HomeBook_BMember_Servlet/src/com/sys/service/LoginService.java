package com.sys.service;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import com.sys.common.MBUtils;
import com.sys.dao.BMemberDAO;
import com.sys.dto.BMember;

public class LoginService implements Service {
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8"); 
		String id = request.getParameter("id"); 
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		SqlSession sqlSession = MBUtils.getSession();
		BMemberDAO dao = sqlSession.getMapper(BMemberDAO.class);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		BMember mem = null; 
		try {
			mem = dao.selectById(id);
			if(mem.getMpassword().equals(password)) {
				writer.print("로그인 성공");
				session.setAttribute("id",id); 
				session.setAttribute("name",mem.getMname()); 
				session.setAttribute("pw",password); 
				session.setAttribute("loginOk","ok"); 
				String main = request.getContextPath(); 
				response.sendRedirect("../Main.jsp");
			}else {
				writer.print("로그인 실패!"); 
				writer.print(
				"<button type='button' onclick=\"location.href ='../Main.jsp'\" >메인가기</button>"
				);
			}
		}catch(Exception e) {
			writer.print("로그인 실패!"); 
			writer.print(
			"<button type='button' onclick=\"location.href ='../Main.jsp'\" >메인가기</button>"
			);
		}		
		return true;
	}
}