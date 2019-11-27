package com.sys.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("pw");
		session.removeAttribute("loginOk");
		String root = (String)session.getAttribute("root");
		response.sendRedirect("../main.do");
		return true;
	}

}
