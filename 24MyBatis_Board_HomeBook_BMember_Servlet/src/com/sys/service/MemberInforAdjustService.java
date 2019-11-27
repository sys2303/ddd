package com.sys.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.BMemberDAO;
import com.sys.dto.BMember;

public class MemberInforAdjustService implements Service {
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("회원 가입정보를 수정 합니다.....");
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter writer = response.getWriter(); 
		BMember vo = null;
		SqlSession sqlSession = MBUtils.getSession();
		BMemberDAO dao = null;
			try {
				dao = sqlSession.getMapper(BMemberDAO.class);
				vo = new BMember(); 
				vo.setMid(request.getParameter("mid")); 
				vo.setMname(request.getParameter("mname"));
				vo.setMpassword(request.getParameter("mpassword")); 
				vo.setMphone(request.getParameter("mphone"));
				vo.setMjoinDate(request.getParameter("mjoinDate")); 
				dao.update(vo);
				sqlSession.commit();// 빠트리지 마시압!
				sqlSession.close();
				// 다른 페이지로 넘길 정보를 session객체에 수록 
				HttpSession session = request.getSession(); 
				session.setAttribute("joinVo", vo);
				//----------------------------------------------------------
				writer.print("회원정보를 수정하였습니다.");
				writer.print("<a href='main.do'>메인화면</a><br>");
				writer.print("<a href='joinConfirm.do'>수정확인</a>");
			} catch(Exception e) {
				e.printStackTrace();
				return false; 
			}
		return true;
	}
}