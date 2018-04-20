<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	/* 세션 아이피 확인 및 방문자 통계 추가 */
	$(function(){
		if("${sessionScope.ip}"==""){
			console.log("아이피 없으요~ㅎㅎ");
			$.ajax({
				url:'/ip_save_session',
				success:function(data){
					console.log(data);
				}
			});
		}else{
			console.log("아이피 있지롱~~~ ${sessionScope.ip}");
		}
	});
	
</script>
<div id="header_wrapper" style="padding:0px 0px">
	<div id="main_logo">
		<a href="/"><img src="/resources/img/solo.png" style="width:80px"></a>
	</div>
	<div id="main_menu">
		<ul style="list-style:none;">
			<li><a href="<c:url value='/recommend'/>">StyleSolo's Choice</a></li>
			<li><a href="<c:url value='/shop'/>" class="glyphicon glyphicon-shopping-cart">쇼핑</a></li>
			<li><a href="<c:url value='/gonggu/${sessionScope.id}'/>" class="glyphicon glyphicon-credit-card">공동구매</a></li>
			<li><a href="<c:url value='/event'/>" class="glyphicon glyphicon-gift">이벤트</a></li>
		</ul>
	</div>
	<div id="main_member">
		<c:choose>
			<c:when test="${not empty sessionScope.id }">
				<div id="member_menu" style="margin-left:120px;">
					<a href="<c:url value='/member/myOrder'/>" style="margin-left: 10px;">마이페이지</a>
					<a href="<c:url value='/orderList'/>" style="margin-left: 10px;">주문/배송</a>
					<a href="<c:url value='/customerService'/>" style="margin-left: 10px;">고객센터</a>
				</div>
				<div id="member_login" style="margin-left:30px;">
					<span style="font-weight: bold;font-size: 20px;color:black;margin-left:60px;">${sessionScope.id }</span>&nbsp;님 반갑습니다.
					<a style="font-size: 14px;" href="<c:url value='/logout'/>"><input type="button" class="form-control" id="btn_header_logout" value="로그아웃" style="width:80px;"></a>
				</div>
			</c:when>
			<c:otherwise>
				<div id="member_menu">
					<a href="<c:url value='/member/forms/join'/>">회원가입</a>
					<a href="<c:url value='/member/forms/find'/>" style="margin-left: 10px;">아이디/비밀번호찾기</a>
					<a href="<c:url value='/member/forms/login'/>" style="margin-left: 10px;">주문/배송</a>
					<a href="<c:url value='/customerService'/>" style="margin-left: 10px;">고객센터</a>
				</div>
				<div id="member_login">
					<form method="post" action="/member/login">
						<input type="text" name="member_privacy_id" id="id" class="form-control" placeholder="아이디" style="width:130px;">
						<input type="password" name="member_privacy_pwd" id="pwd" class="form-control" placeholder="비밀번호" style="width:130px;">
						<input type="submit" id="btn_header_login" class="form-control" value="로그인" style="width:80px;">
						<div id="errMsg" style="font-size: 11px;">${requestScope.errMsg }</div>
					</form>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>