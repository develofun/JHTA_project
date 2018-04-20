<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/orderlist.css">

<div class="orderlist_wrap">
<h2>전체 주문목록 조회하기</h2>
	<div id="search">
		<form method="post" action="orderList.do">
			주문조회&nbsp;<input type="date" name="start_date" id="start_date">&nbsp;
			~ &nbsp; <input type="date" name="end_date" id="end_date">&nbsp;
			<input type="submit" value="검색하기" id="search_order">
		</form>
	</div>
	<div id="order_list">
		<table>
				<tr>
					<th>주문번호</th>
					<th>주문날짜</th>
					<th>대표상품명</th>
					<th>결제금액</th>
					<th>주문정보</th>
					<th>배송정보</th>
					<th>취소/환불</th>
				</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td><a href="order_desc?order_num=${vo.shop_payment_ordernum }">${vo.shop_payment_ordernum }</a></td>
					<td>${vo.shop_payment_w_date }</td>
					<td>${vo.shop_item_name }</td>
					<td>${vo.shop_payment_total_payment }원</td>
					<td>${vo.shop_order_history }</td>
					<td>${vo.shop_delivery_history }</td>
					<td><a href="order_cancel?order_num=${vo.shop_payment_ordernum }">취소신청</a></td>
				</tr>
			</c:forEach>
		</table>
		<div id="paging">
			<c:if test="${pu.startPageNum!=1 }">
				<a href="orderList.do?pageNum=${pu.startPageNum-1 }">이전</a>
			</c:if>
			<c:forEach var="vo" begin="${pu.startPageNum }" end="${pu.endPageNum }">
				<c:choose>
					<c:when test="${vo==pageNum }">
						<a href="orderList.do?pageNum=${vo }&start_date=${start_date }&end_date=${end_date }"><span style="color:red">[${vo }]</span></a>
					</c:when>
					<c:otherwise>
						<a href="orderList.do?pageNum=${vo }&start_date=${start_date }&end_date=${end_date }"><span style="color:#333">[${vo }]</span></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pu.endPageNum!=pu.totalPageCount }">
				<a href="orderList.do?pageNum=${pu.endPageNum+1 }">다음</a>
			</c:if>
		</div>
<br><br><br>
	</div>
</div>
