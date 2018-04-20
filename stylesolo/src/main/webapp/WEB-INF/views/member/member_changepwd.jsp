<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/member/member_changepwd.css" type="text/css">

<div id="changepwd">
	<span style="font-size: 20px;font-weight: bold;">비밀번호 변경</span><br>
	<br>
	<span style="font-size: 12px;color:gray;">기존의 비밀번호와 변경하고자 하는 비밀번호를 입력해주세요.</span><br><br>
	
	<form method="post" action="/member/changePwd">
	
	<table class="member_changepwd">
		<tr>
			<th scope="row" style="width:200px;font-weight: bold; font-size: 14px;">아이디</th>
			<td style="width:560px;font-size: 13px; color: #4C4C4C;">${sessionScope.id }
			<input type="hidden" value="${sessionScope.id }" id="id" name="id">
			</td>
		</tr>
		<tr>
			<th scope="row" style="font-weight: bold; font-size: 14px;">기존 비밀번호</th>
			<td><input type="password" class="form-control" style="width:200px;height:34px;" name="pwd"></td>
		</tr>
		<tr>
			<th scope="row" style="font-weight: bold; font-size: 14px;">신규 비밀번호</th>
			<td><input type="password" class="form-control" style="width:200px;height:34px;"	name="changepwd"></td>
		</tr>
		<tr>
			<th scope="row" style="font-weight: bold; font-size: 14px;">비밀번호 확인</th>
			<td><input type="password" class="form-control" style="width:200px;height:34px;"	name="changepwd2"></td>
		</tr>
	</table>
	
	<input type="submit" id="btn_submit_changepwd" value="비밀번호변경">
	
	</form>
</div>
