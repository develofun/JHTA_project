<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h4>아이디 찾기</h4>
		<form method="post" action="/member.do?cmd=member_find">
		<div class="form-group">
			<label for="inputName" class="input_title">이름 : </label>
			<input type="text" class="@@@@@@" id="user_name" name="user_name" placeholder="이름" required>
		</div>
		<div class="form-group">
			<label for="inputName" class="input_title">이메일 : </label>
			<input type="email" class="@@@@@@" id="user_email" name="user_email" placeholder="이메일" required>
		</div>
		<input type="submit" value="찾기">
	</form>
	<br><br><br><br>
	<h4>비밀번호 찾기</h4>
	<form method="post" action="/member.do?cmd=member_find">
		<div class="form-group">
				<label for="inputId" class="input_title">아이디 : </label>
				<input type="text" class="@@@@@@" id="user_id" name="user_id" placeholder="아이디" required>
		</div>
		<div class="form-group">
			<label for="inputName" class="input_title">이름 : </label>
			<input type="text" class="@@@@@@" id="user_name" name="user_name" placeholder="이름" required>
		</div>
		<div class="form-group">
			<label for="inputName" class="input_title">이메일 : </label>
			<input type="email" class="@@@@@@" id="user_email" name="user_email" placeholder="이메일" required>
		</div>
		<input type="submit" value="찾기">
	</form>
</div>