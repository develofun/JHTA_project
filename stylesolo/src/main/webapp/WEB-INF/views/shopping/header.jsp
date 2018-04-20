<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/header.css">
<div id="header">
	<a href="#"><img src="/resources/img/solo.png" id="logo"></a>
	
	<div id="menu">
		<a href="#">추천</a>
		<a href="#">쇼핑</a>
		<a href="#">공구</a>
		<a href="#">이벤트</a>
	</div>
	
	<div id="member_menu">
		<a href="#">회원가입</a>
		<a href="#">아이디/비밀번호 찾기</a>
		<a href="#">주문/배송조회</a>
		<a href="#">고객센터</a>
	</div>
	
	<div id="member_login">
		<form method="post" action="#">
			<input type="text" name="id" id="id" placeholder="아이디">
			<input type="text" name="pwd" id="pwd" placeholder="비밀번호">
			<input type="submit" value="로그인">
		</form>
	</div>
</div>