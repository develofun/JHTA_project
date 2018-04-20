<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>등록</h1>
<form method="post" action="/insert">
	번호<input type="text" name="num"><br>
	이름<input type="text" name="name"><br>
	제목<input type="text" name="title"><br>
	내용<textarea rows="5" cols="30"></textarea><br>
	<input type="submit" value="등록">
</form>
</body>
</html>