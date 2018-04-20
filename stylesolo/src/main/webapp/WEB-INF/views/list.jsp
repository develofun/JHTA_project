<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>목록</h1>
	<table border="1" width="600">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.num }</td>
				<td>${vo.name }</td>
				<td>${vo.title }</td>
				<td>${vo.content }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>