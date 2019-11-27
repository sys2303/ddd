package com.sys.service;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import com.sys.common.MBUtils;
import com.sys.dao.HomeBookDAO;
import com.sys.dto.HomeBook;

public class HomeBookInforService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/homebook/datadisp2.jsp"); 
		dispatcher.forward(request,response);
		return true;
	}

}