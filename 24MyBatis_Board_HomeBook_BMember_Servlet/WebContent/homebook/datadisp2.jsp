<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.sys.dto.HomeBook"%>
<%@ page import="com.sys.dao.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="com.sys.common.MBUtils"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력자료목록</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id=(String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		response.setContentType("text/html;charset=UTF-8");
		SqlSession sqlSession  = MBUtils.getSession(); 
		HomeBookDAO dao = sqlSession.getMapper(HomeBookDAO.class);
		List<HomeBook> data =  dao.selectAllById(id);
		sqlSession.close();
	%>
	<h1><%=name%>님 입력자료 목록
	</h1>
	<div align="right">
		<button type="button" onclick="location.href='form_homebook.jsp'">
			뒤로</a>
	</div>
	<hr>
	<table border='1'>
		<tr>
			<th>관리번호</th>
			<th>일자</th>
			<th>구분</th>
			<th>계정과목</th>
			<th>적요</th>
			<th>차변</th>
			<th>대변</th>
			<th>사용자ID</th>
			<th>수정</th>
		</tr>
		<%
			for (HomeBook x : data) {
		%>
		<tr>
			<td><%=x.getSerialno()%></td>
			<td><%=x.getDay()%></td>
			<td><%=x.getSection()%></td>
			<td><%=x.getAccountTitle()%></td>
			<td><%=x.getRemark()%></td>
			<td><%=x.getRevenue()%></td>
			<td><%=x.getExpense()%></td>
			<td><%=x.getUserId()%></td>
			<td><button type="button"
					onclick="location.href='homebookAdjust.do?no=<%=x.getSerialno()%>'">
					수정<%=x.getSerialno()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>