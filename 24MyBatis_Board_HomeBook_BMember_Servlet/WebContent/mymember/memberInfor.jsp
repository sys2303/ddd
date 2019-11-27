<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sys.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
BMember vo = (BMember)session.getAttribute("joinVo");
%>
<h1><%=vo %>회원 가입정보</h1>
<hr>
<form action ="memberInforAdjust.do" method="POST">
<table border="1">
	<tr><th>아이디</th><td>
	<input type="hidden" name="mid" value="<%=vo.getMid() %>">
	<%=vo.getMid()%>	
	</td></tr>
	<tr><th>회원이름</th><td>
		<input type="text" name="mname" value="<%=vo.getMname()%>">
	</td></tr>
	<tr><th>패스워드</th><td>
		<input type="text" name="mpassword" value="<%=vo.getMpassword()%>">
	</td></tr>
	<tr><th>전화번호</th><td>
		<input type="text" name="mphone" value="<%=vo.getMphone()%>">
	</td></tr>
	<tr><th>가입일자</th><td>
		<input type="hidden" name="mjoinDate" value="<%=vo.getMjoinDate() %>">
		<%=vo.getMjoinDate() %>
	</td></tr>
	
	<tr><td colspan="2" align="center">
		<button type="button" onclick="location.href='../login/formLogin.jsp'">로그인</button>
		<input type="submit" value="수정">
	</td></tr>
</table>
<a href = "../main.do">메인화면</a>
</form> 
</body>
</html>