<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	session.setAttribute("homebookroot", "homebook/");
	session.setAttribute("imageroot", "images/");
	session.setAttribute("loginroot", "login/");
	session.setAttribute("memberroot","mymember/");
	session.setAttribute("boardroot","board/");
	request.setCharacterEncoding("utf-8");
%>
</head>
<body>
	<%@include file="Top.jsp"%>
	<center>
	<img src="images/LOGOBIG.png" 
		height="500" alt="main image">
	</center>
	<%@include file="Bottom.jsp"%>
</body>
</html>