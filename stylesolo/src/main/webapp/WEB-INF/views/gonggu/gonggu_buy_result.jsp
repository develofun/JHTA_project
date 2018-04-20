<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_buy_result.css" type="text/css">

<div id="wrap" style="width:1000px;margin:auto;">
	<div id="result" style="margin-top:40px;">

		<c:choose>
			<c:when test="${result=='success' }">
				<h2>공구 구매 성공!</h2>
				<img src="/resources/img/result_happy.jpg" style="width:500px;"><br>
			</c:when>
			<c:otherwise>
				<h2>공구 구매 실패...</h2>
				<img src="/resources/img/result_sad.jpg"><br>
			</c:otherwise>
		</c:choose>
		<br>
		
		<div class="result_table">
		    <div class="result_tr">
		        <div class="result_td" style="width:100px;height:40px;">은행명</div>
		        <div class="result_td" style="width:200px;">${membervo.gonggu_insert_bankname }</div>
		    </div>
		    <div class="result_tr">
		    	<div class="result_td" style="width:100px;height:40px;">예금주</div>
		    	<div class="result_td" style="width:200px;">${membervo.member_privacy_name}</div>
		    </div>
		    <div class="result_tr">
		    	<div class="result_td" style="width:100px;height:40px;">계좌번호</div>
		    	<div class="result_td" style="width:200px;">${membervo.gonggu_insert_account }</div>
		    </div>
		</div>
		<br>
		구매결정 후 7일 이내로 입금해 주셔야 결제완료가 가능합니다.<br>
		<br>
		<br>
		
		<a href="<c:url value='/'/>">
			<input type="button" value="메인페이지로">
		</a>
		<br>
		<br>
	</div>
</div>