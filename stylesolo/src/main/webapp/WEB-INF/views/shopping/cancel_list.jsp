<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/orderlist.css">

<div class="orderlist_wrap">
<h2>주문취소목록</h2>
<!--  
	<div id="search">
		<form method="post" action="orderList.do">
			주문조회&nbsp;<input type="date" name="start_date" id="start_date">&nbsp;
			~ &nbsp; <input type="date" name="end_date" id="end_date">&nbsp;
			<input type="submit" value="검색하기" id="search_order">
		</form>
	</div>
-->	
	<div id="order_list">
		<table>
				<tr>
					<th>주문번호</th>
					<th>주문날짜</th>
					<th>취소요청일</th>
					<th>상품명</th>
					<th>취소수량</th>
					<th>취소금액</th>
					<th>처리현황</th>
				</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.SHOP_PAYMENT_ORDERNUM }</a></td>
					<td>${vo.SHOP_PAYMENT_W_DATE }</td>
					<td>${vo.CANCEL_APPLYDATE }</td>
					<td>${vo.SHOP_ITEM_NAME }
						<c:if test="${vo.ITEM_OPTIONS_NAME !=null }">
							${vo.ITEM_OPTIONS_NAME}
						</c:if>
					</td>
					<td>${vo.SHOP_PAYMENT_ITEM_ORDER_QTY }</td>
					<td>${vo.SHOP_PAYMENT_ITEM_PRICE }</td>
					<td>${vo.CANCEL_HISTORY}</td>
				</tr>
			</c:forEach>
		</table>
		<div id="paging">
			<c:if test="${pu.startPageNum!=1 }">
				<a href="cancelList.do?pageNum=${pu.startPageNum-1 }">이전</a>
			</c:if>
			<c:forEach var="vo" begin="${pu.startPageNum }" end="${pu.endPageNum }">
				<c:choose>
					<c:when test="${vo==pageNum }">
						<a href="cancelList.do?pageNum=${vo }"></a>	</c:when>
					<c:otherwise>
						<a href="cancelList.do?pageNum=${vo }"><span style="color:#333">[${vo }]</span></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pu.endPageNum!=pu.totalPageCount }">
				<a href="cancelList.do?pageNum=${pu.endPageNum+1 }">다음</a>
			</c:if>
		</div>
<br><br><br>
	</div>
</div>
