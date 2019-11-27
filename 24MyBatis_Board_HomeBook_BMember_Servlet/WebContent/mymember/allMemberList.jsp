<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sys.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 모두 출력(관리자용)</title>
</head>
<body>
	<h1 align="center">모든 회원 정보 출력</h1>
	<hr>
	<%
		List<BMember> memList = 
			(List<BMember>)request.getAttribute("memList");
		
		for(BMember x:memList){
			out.print(x.getMid()+" ");
			out.print(x.getMname()+"<br>");
		}
	%>
	<hr> 
	<a href = "main.do">메인화면</a>
	
	
	
	
	
	
</body>
</html>