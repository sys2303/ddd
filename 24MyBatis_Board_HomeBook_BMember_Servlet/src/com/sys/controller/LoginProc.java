package com.sys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import com.sys.common.MBUtils;
import com.sys.dao.BMemberDAO;
import com.sys.dto.BMember;


/**
 * Servlet implementation class LoginProc
 */
@WebServlet("/LP" )
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProc() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("서블릿객체가 생성됩니다.");
    }
    @PostConstruct
    public void init() {
    	System.out.println("처음 한번만 호출됩니다. ");
    }
    @PreDestroy
    public void destroy() {
    	System.out.println("자원 해지시 한번만 호출됩니다.");
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// 파라미터 값의 문자타입을 지정  
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 응답 인코딩 방식
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//테그로 인식하지 않게 하기  
		//response.setContentType("text/plain;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		//BMemberDAO dao = new BMemberDAO();
		SqlSession session = MBUtils.getSession();
		// 인터페이스를 별도의 구현없이 사용하기 위해 메퍼와 바로연결
		BMemberDAO dao = session.getMapper(BMemberDAO.class);
		BMember mem = null;
		try{
			mem = dao.selectById(id);
			if(mem.getMpassword().equals(password)){
				writer.print("로그인 성공<BR/>");
				writer.print("<a href='./homebook/frm_homebook.jsp'>가계부입력</a>");
			}else{
				writer.print("로그인 실패<BR/>");
				writer.print("<a href='./login/formLogin.jsp'>로그인</a> ");
				writer.print("<a href='./mymember/memberJoin.jsp'>회원가입</a>");
			}
		}catch(Exception e){
			writer.print("로그인 실패<BR/>");
			writer.print("<a href='./login/formLogin.jsp'>로그인</a>");
			writer.print("<a href='./mymember/memberJoin.jsp'>회원가입</a>");
		}
		writer.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		doGet(request, response);
	}
}
