<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	if (session.getAttribute("ValidMem") == null) {
%>
<jsp:forward page="login.jsp" />
<%
	}

	String name = (String) session.getAttribute("name");
	String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=name%>님 안녕하세요.
	</h1>
	<br>
	<form action="logout.do" method="post">
		<input type="submit" value="로그아웃">&nbsp;&nbsp;&nbsp; <input
			type="button" value="정보수정"
			onclick="javascript:window.location='modify.jsp'"> <br>

		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>제목</td>
				<td>날짜</td>
				<td>히트</td>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.bId }</td>
					<td>${dto.bName }</td>
					<td><c:forEach begin="1" end="${dto.bIndent }">-</c:forEach> <a
						href="content_view.do?bId=${dto.bId }">${dto.bTitle }</a></td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="3"><a href="write_view.do">글작성</a>
			</tr>
		</table>
	</form>
</body>
</html>