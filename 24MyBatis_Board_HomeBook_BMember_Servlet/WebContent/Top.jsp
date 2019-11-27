<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
	<style>
		.top{
			background-image:url('./images/TREE.jpg');
			background-color:#D9E5FF;
		}
		.y{
			color:YELLOW;
		}
		.green{
			color:lightGREEN;
		}
	</style>
	<%
		String id = (String) session.getAttribute("id");
		String loginroot=(String)session.getAttribute("loginroot");
		String homebookroot=(String)session.getAttribute("homebookroot");
		String memberroot=(String)session.getAttribute("memberroot");
		String imageroot = (String)session.getAttribute("imageroot");
		String boardroot = (String)session.getAttribute("boardroot");
		if (id == null) {
			id = "GUEST";
		}
	%>
	</head>
	
	<body>
	
	<table width="100%">
		<tr height="70">
			<td  class="top"><a href="Main.jsp"
				style="text-decoration: none"> <img alt="로고출력자리"
					src="<%=imageroot%>LOGO.png" height="100">
			</a></td>
			<td  class="top" colspan="5">
			<div align="center">
				<h1 class="green">WEB회원제가계부</h1>
				<h3 class="y">서버구성:MyBatis/Oracle/FrontControllPattern/Model2방식</h3>
			</div>
			</td>
			<td class="top" align="center" width="200"><h3 class="y"><%=id%>님</h3>
			<%
				if(id.equals("GUEST")){
					%>
			<button onclick="location.href='<%=loginroot%>formLogin.jsp'">로그인</button>
					<%
				}else{
					%>
				<button onclick="location.href='<%=loginroot%>logout.do'">로그아웃</button>	
					<%
				}
			%>
			
			</td>
		</tr>
		
		<tr height="50">
			<td align="center" width="13%" bgcolor="black"><a href="<%=memberroot%>memberJoin.jsp"
				style="text-decoration: none"><font color="white" size="4">회원등록</font></a>
			</td>
			<td align="center" width="13%" bgcolor="gray"><a href="<%=memberroot%>memberInfor.do"
				style="text-decoration: none"><font color="white" size="4">본인정보</font></a>

			</td>
			<td align="center" width="13%" bgcolor="black"><a
				href="Instructions.jsp"
				style="text-decoration: none"><font color="white" size="4">가계부사용법</font></a>

			</td>
			<td align="center" width="13%" bgcolor="gray"><a href="<%=homebookroot%>form_homebook.jsp"
				style="text-decoration: none"><font color="white" size="4">가계부입력</font></a>
			</td>
			<td align="center" width="13%" bgcolor="black"><a href="<%=homebookroot%>allBook.do"
				style="text-decoration: none"><font color="RED" size="4">모든자료</font></a>
			</td>
			<td align="center" width="13%" bgcolor="gray"><a href="<%=memberroot%>allMember.do"
				style="text-decoration: none"><font color="RED" size="4">모든회원</font></a>
			</td>
			<td align="center" width="22%" bgcolor="gray"><a href="<%=boardroot%>boardList.jsp"
				style="text-decoration: none"><font color="RED" size="4">게시판</font></a>
			</td>
		</tr>
	</table>
	</body>
	</html>