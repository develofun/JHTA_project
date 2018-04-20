<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="wrap" style="width:1000px;padding-top:70px;margin:auto" align="center">
	<div id="login_img" class="display-table-row" style="width:1000px;height:540px;">
		<div class="display-table-cell" style="width:500px;">
			<img src="/resources/img/solo.png" style="width:300px;height:300px;border:4px solid black;">
		</div>
		
		<div id="why_are_you_here">
			<span style="color:red;font-size:18px;font-weight: bold;">${why_are_you_here}</span>
			<br>
			<br>
		</div>
		
		<div id="login_member" class="display-table-row" style="width:300px;">
			<form method="post" action="/member/login">
				<div class="form-group">
					<input type="text" id="id" name="id" class="form-control" placeholder="아이디">
				</div>
				<div class="form-group">
					<input type="password" id="pwd" name="pwd" class="form-control" placeholder="비밀번호">
				</div>
				<div class="form-group">
					<div id="div_memberCheck" style="font-weight: bold;color:red;">${login_errMsg }</div>
					<br>
					<input type="submit" id="btn_login" class="btn btn-primary" value="로그인">
				</div>
			</form>
			<div class="form-group" align="left">
				<span style="font-size:12px;font-weight:bold;color:gray;">아직도 StyleSolo의 회원이 아니신가요?</span>
				<a href="<c:url value='/member/forms/join'/>" style="text-decoration: none;color:gray;font-size:13px;margin-left:40px;">회원가입</a>
			</div>
			<div class="form-group">
				<span style="font-size:12px;font-weight:bold;color:gray;">아이디 또는 비밀번호를 잊어버리셨나요?</span>
				<a href="<c:url value='/member/forms/find'/>" style="text-decoration: none;color:gray;font-size:13px;margin-left:32px;">아이디/비밀번호찾기</a>
			</div>
		</div>
	</div>	
</div>