<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/member/member_detail_menu.css" type="text/css">

<div id="wrap" style="width:200px;margin:auto;">
	<div id="member_menu">
		<div id="member_logo">
			<a href="<c:url value='/member/myOrder'/>"><img src="/resources/gonggu_uploadImg/member_mypage.jpg" style="width:200px;height:200px;"></a>
		</div>
		<div id="menu1">
			<h3>쇼핑내역</h3>
			<a href="<c:url value='/orderList'/>">주문/배송조회</a><br>
			<a href="<c:url value='/cancelList.do'/>">취소/반품/교환 내역</a><br>
		</div>
		<div id="menu2">
			<h3>혜택관리</h3>
			<a href="">나의 등급보기</a><br>
			<a href="<c:url value='/couponList'/>">쿠폰 리스트</a><br>
		</div>
		<div id="menu3">
			<h3>관심목록</h3>
			<a href="<c:url value='/cart'/>">장바구니</a><br>
			<a href="<c:url value='/jjim'/>">위시리스트</a><br>
			
		</div>
		<!--  
		<div id="menu4">
			<h3>쇼핑지식</h3>
			<a href="">상품 Q&A</a><br>
			<a href="">1:1 문의/상담</a><br>
			<a href="">상품 구매후기</a>
		</div>
		-->
		<div id="menu5">
			<h3>회원정보</h3>
			<a href="<c:url value='/member/member_checkpwd'/>">회원정보 수정</a><br>
			<a href="<c:url value='/member/member_drop'/>">회원탈퇴</a>
		</div>
	</div>
</div>
