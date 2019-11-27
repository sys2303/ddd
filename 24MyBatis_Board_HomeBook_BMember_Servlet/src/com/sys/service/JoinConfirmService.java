package com.sys.service;



import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sys.dto.BMember;

// Controller를  joinConfirm.do로 호출하였을 시 수행 
// 회원가입후 가입내역을 보여주고 수정할 것이 없는지를 확인할 수
// 있도록 해주는 서비스 
public class JoinConfirmService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		BMember vo = (BMember)session.getAttribute("joinVo");
		System.out.println(vo+"를 memberInfor.jsp 페이지에서 처리하겠습니다.");
		// 여기서 직접 이 vo 정보를 처리하지 않고  
		// 코드 학습 목적상 디스페쳐를 호출하여 이 정보를 jsp페이지로 
		// 보내 보겠습니다. 
		//request.setAttribute("joinVo",vo);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/mymember/memberInfor.jsp");
		dispatcher.forward(request, response);
		return true;
	}
}