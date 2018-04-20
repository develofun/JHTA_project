<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="fboard.do?cmd=fboard_update_form">
		<input type="text"style="display: none;" name="detail_num" value="${detail_num }">
		<input type="text"style="display: none;" name="fboard_num" value="${fboard_num}">
		<input type="text"style="display: none;" name="fboard_area" value="${fboard_area}">
		<input type="text"style="display: none;" name="fboard_city" value="${fboard_city}">
		<input type="text"style="display: none;" name="fboard_category" value="${fboard_category}">
	<h1>글수정 실패</h1>
	<input type="submit" value="글수정 페이지로">
	</form>
</body>
</html>