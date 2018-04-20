<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>회원 정보 수정</h4>
<br><br>
	<form method="post" action="/login?cmd=member_update">
		<div class="form-group">
			<label for="inputId" class="input_title">아이디 : </label>
			<input type="text" class="@@@@@@" id="user_id" name="user_id" placeholder="${dto.login_id }" required>
	</div>
		<div class="form-group">
		<label for="inputPassword" class="input_title">비밀번호 : </label>
		<input type="password" class="@@@@@@" id="user_password1" name="user_password1" placeholder="비밀번호" required><br>
	</div>
	<div class="form-group">
		<label for="inputPasswordChec" class="input_title">비밀번호 확인 : </label>
		<input type="password" class="@@@@@@" id="user_password2" name="user_password2" placeholder="비밀번호 확인" required><br>
	</div>
	<div class="form-group">
		<label for="inputNickname" class="input_title">닉네임 : </label>
		<input type="text" class="@@@@@@" id="user_nick" name="user_nick" placeholder="사용자 닉네임이 출력됨" required>
		<input type="button" name="confrim_nickname" value="중복확인" onclick=""><br>
	</div>
	<div class="form-group">
		<label for="inputName" class="input_title">생년월일 : </label>
		<select name="birth">
		<%for(int i=2017; i>=1917; i--){ %>
	       <option value="<%=i %>"><%=i %></option>
	       <%} %>
	     </select>년&nbsp;
	     <select name="birth2">
	       <%for(int i=1; i<=12; i++){ %>
	       <option value="<%=i %>"><%=i %></option>
	       <%} %>
	     </select>
	     <select name="birth3">
	       <%for(int i=1; i<=31; i++){ %>
	       <option value="<%=i %>"><%=i %></option>
	       <%} %>
	     </select>
	</div>
		<div class="form-group">
		<label for="inputPhone" class="input_title">전화번호 : </label>
		<input type="phone" class="@@@@@@" id="user_phone" name="user_phone" placeholder="숫자만 입력해 주세요" required>
	</div>
	<div class="form-group">
		<label for="inputName" class="input_title">이메일 : </label>
		<input type="email" class="@@@@@@" id="user_email" name="user_email" placeholder="사용자 이메일이 출력됨" required>
		<input type="button" name="confrim_email" value="중복확인" onclick=""><br>
	</div>
	<input type="submit" value="수정">
	<input type="reset" value="취소">
</form>
</body>
</html>