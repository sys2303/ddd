<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
<h1 align="center">로그인</h1>
<hr>
<form name="loginFrm" action="login.do" method ="POST">
<table border="1" align="center">
	<tr><th>ID</th><td>
		<input type="text" name="id" size="20">
	</td></tr>
	<tr><th>PASSWORD</th><td>
		<input type="password" name="password" size="20">
	</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="로그인">
		<input type="reset" value="다시">
	</td></tr>
</table>
</form>
</body>
</html>