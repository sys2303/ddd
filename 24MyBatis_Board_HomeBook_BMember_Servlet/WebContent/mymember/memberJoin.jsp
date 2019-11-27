<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버조인 화면</title>
</head>
<body>
	<h1 align="center">회원가입</h1>
	<div align="right">
		<button type="button" onclick="history.go(-1)">뒤로</button>
	</div>
	<hr>
	<form action="memberjoin.do" method="POST">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="mpassword"></td>
			</tr>
			
			<tr>
				<th>패스워드확인</th>
				<td><input type="password" name="mpassword2"></td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="mphone"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="date" name="mjoinDate"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="전송">
					<button onclick="location.href='/'">되돌아가기</button></td>
			</tr>
		</table>
	</form>
	<a href="../main.do">메인가즈아</a>

</body>
</html>