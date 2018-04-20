<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel="stylesheet" href="/resources/css/couponList.css">
<div class="couponWrap">
<h1>보유쿠폰리스트</h1>
<hr>
<c:if test="${list ne null }">
<c:forEach var="vo" items="${list }"> 
	<div class="coupon">
		<ul>
			<li><h4>${vo.coupon_subject }</h4></li>
			<li><h2>${vo.coupon_discount }원 할인</h3></li>
			<li>(결제금액 ${vo.coupon_value } 원 이상 결제시 사용가능)</li>
			<li>${vo.coupon_startDate } ~ ${vo.coupon_endDate } 까지</li>
		</ul>
	</div>
</c:forEach>
</c:if>	
<c:if test="${list eq null }">
	보유하신 쿠폰이 없습니다.
</c:if>

</div>