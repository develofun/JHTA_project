<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/member.do?cmd=member_login">
	<div class="form-group">
			<label for="inputId" class="input_title">아이디 : </label>
			<input type="text" class="@@@@@@" id="login_id" name="login_id" placeholder="아이디" required>
	</div>
	<div class="form-group">
		<label for="inputPassword" class="input_title">비밀번호 : </label>
		<input type="password" class="@@@@@@" id="member_password" name="member_password" placeholder="비밀번호" required><br>
		<input type="submit" value="로그인">
	</div>
</form>
</body>
</html>