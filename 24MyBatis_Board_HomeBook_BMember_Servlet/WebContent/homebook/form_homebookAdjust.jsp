<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sys.dto.*" %>
<%@ page import="com.sys.dao.*" %>
<%@ page import="com.sys.common.*" %>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈북 수정화면</title>
</head>
<body>
<%
	Long serialno = Long.parseLong(request.getParameter("serialno"));
	SqlSession sqlSession = MBUtils.getSession();
	HomeBookDAO dao = sqlSession.getMapper(HomeBookDAO.class);
	HomeBook vo = dao.selectById(serialno);
	//out.print(vo);
%>
<h1>가계부개별자료 수정작업</h1>
적색부분은 수정할 수 없습니다!
<div align="right"><button type="button" onclick="history.go(-1)">뒤로</a></div>
<hr> 
<table border="1" align="left">
	<form name="homebookadjust" action="adujustProc.do" method="post">
	<tr><th bgcolor='red'>관리번호</th><td><%=vo.getSerialno()%></td></tr>
	<input type="hidden" name="serialno" value="<%=vo.getSerialno()%>">
	<tr><th bgcolor='green'>일자</th><td><input type="date" name="day" value=<%=vo.getDay()%>></td> </tr>
	<tr><th bgcolor='green'>구분</th><td><input type="text" name="section" value="<%=vo.getSection()%>"></td></tr>
	<tr><th bgcolor='green'>계정과목</th><td><input type="text" name="accountTitle" value="<%=vo.getAccountTitle()%>" size="80"></td></tr>
	<tr><th bgcolor='green'>적요</th><td><input type="text" name="remark" value="<%=vo.getRemark()%>" size="80"></td></tr>
	<tr><th bgcolor='green'>수입(차변)</th><td ><input type="text" name="revenue" value="<%=vo.getRevenue()%>" style = "text-align:right;"></td></tr>
	<tr><th bgcolor='green'>지출(대변)</th><td ><input type="text" name="expense" value="<%=vo.getExpense()%>" style = "text-align:right;"></td></tr>
	<tr><th bgcolor='red'>사용자ID</th><td><%=vo.getUserId()%></td></tr>
	<input type="hidden" name="userId" value="<%=vo.getUserId()%>">
	<tr><td colspan="2" align="center">
		<input type="submit" value="수정">&nbsp;
		<button type="button" onclick="history.go(-1)">뒤로</button>
	</td></tr>	
	</form>
</table>
</body>
</html>