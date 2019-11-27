package com.sys.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MainService implements Service {
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 메인화면으로 돌리는 서비스 
		response .setContentType("text/html;charset= utf-8");
		response.sendRedirect("Main.jsp");
		return true;
	}

}
