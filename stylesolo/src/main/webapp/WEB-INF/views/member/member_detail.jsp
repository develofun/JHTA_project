<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="/resources/css/member/member_detail.css" type="text/css">

<div id="wrap" style="margin:auto;">
	<div id="member_info">
		<div id="member_grade">
			<div id="member_gradeinfo">
				<span style="font-weight: bold;font-size: 18px;">나의 등급정보</span><br>
				<br>
				<span style="font-size: 14px;"><span style="font-weight: bold;">${sessionScope.id }</span>님의 통합 멤버쉽 등급은 <span style="color:gold;font-size:24px;font-weight: bold;">GOLD</span>입니다.</span><br>
				<span style="color:gray;font-size:12px;">(등급적용기간 : 2017-03-01 ~ 2017-03-31)</span><br><br>
				
				<span style="color:gray;font-size:12px;">구매금액</span> ${order_totalprice }원<br>
				<span style="color:gray;font-size:12px;">구매건수</span> ${order_totalcount } 회<br>
				<span style="color:gray;font-size:12px;">구매후기</span> ${review_count } 회
			</div>
			<div id="member_gradenext">
				<br>
				<span style="font-weight: bold;"><span style="font-size: 24px;font-weight: bold;color:skyblue">Platinum</span> 혜택 !</span><br><br>
				<span style="color:gray;font-size:12px;">1. 2,000원 할인쿠폰 1장</span><br>
				<span style="color:gray;font-size:12px;">2. 무료배송 쿠폰 2장</span><br>
				<span style="color:gray;font-size:12px;">3. 마일리지 1% 적립</span>
			</div>
			
		</div>
		<div id="member_order">
			<span style="font-weight: bold;font-size: 18px;">진행중인 주문</span><br>
			<br>
			<div id="statement">
				<div id="state1" align="center">
				<br>
				<span style="font-weight: bold;">주문접수</span><br>
				<span style="font-weight: bold;font-size: 40px;">0</span>건
				</div>
				<div id="state2" align="center">
				<br>
				<span style="font-weight: bold;">결제완료</span><br>
				<span style="font-weight: bold;font-size: 40px;">1</span>건
				</div>
				<div id="state3" align="center">
				<br>
				<span style="font-weight: bold;">상품준비</span><br>
				<span style="font-weight: bold;font-size: 40px;">1</span>건
				</div>
				<div id="state4" align="center">
				<br>
				<span style="font-weight: bold;">출고완료</span><br>
				<span style="font-weight: bold;font-size: 40px;">0</span>건
				</div>
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<span style="font-size: 12px;">취소내역</span>
			<span style="font-size: 24px;font-weight: bold;">0</span><span style="font-size: 12px;">건</span> /
			<span style="font-size: 12px;">교환내역</span>
			<span style="font-size: 24px;font-weight: bold;">0</span><span style="font-size: 12px;">건</span> /
			<span style="font-size: 12px;">반품내역</span>
			<span style="font-size: 24px;font-weight: bold;">0</span><span style="font-size: 12px;">건</span>
			<br>
			<span style="font-size: 12px;color:gray;">* 구매확정이 완료된 주문은 진행중인 주문에 포함되지 않으며 
			진행상태에 따라 배송지 변경, 취소, 반품 신청이 가능합니다.</span>
		</div>
		<div id="member_orderlist">
			<span style="font-weight: bold;font-size: 18px;">최근주문/배송조회</span><br>
			<br>
			
			<table style="width:680px;border:1px solid">	
				<tr align="center" style="font-size: 12px;font-weight: normal;background-color: #EAEAEA">
					<th>주문일자 (주문번호)</th>
					<th>상품명 (옵션)</th>
					<th>주문금액 (판매가×수량)</th>
					<th>주문/배송상태</th>
				</tr>
				
					<c:if test="${list != null }">
						<c:forEach var="vo" items="${list }">
							<tr align="center" style="font-size: 12px;font-weight: normal;">
							<td>${vo.shop_payment_w_date } / <a href="<c:url value='/order_desc?order_num=${vo.shop_payment_ordernum }'/>"> ${vo.shop_payment_ordernum }</a></td>
							<td>${vo.shop_item_name }</td>
							<td>${vo.shop_payment_total_payment } 원</td>
							<td>${vo.shop_order_history } / ${vo.shop_delivery_history }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${list == null or list == ''}">
					<tr>
						<td colspan="4">최근 주문 내역이 없습니다.</td>
					</tr>
					</c:if>
				
			</table>
			
		</div>
		<div id="member_comment">
			<span style="font-weight: bold;font-size: 18px;">상품 구매후기</span><br>
			<br>
			<div id="comments">
				<div id="comments1" align="center">
					<br>
					<span style="font-weight: bold;">구매후기 작성 가능한 상품</span><br>
					<span style="font-weight: bold;font-size: 40px;">2</span>건
				</div>
				<div id="comments2" align="center">
					<br>
					<span style="font-weight: bold;">지금, 구매후기 쓰고 포인트 받아가세요~</span><br>
					<br>
					<a href="" style="color:black;font-weight: bold;font-size: 20px;">구매후기 쓰러가기</a>
				</div>
			</div>
		</div>
		<div id="member_wishlist">
			<span style="font-weight: bold;font-size: 18px;">관심 상품 정보</span><br>
			<br>
			<div class="wish" align="center">
				<img src="/resources/gonggu_uploadImg/item11.jpg" style="width:180px;height:180px;"><br>
				<span style="font-size: 12px;">USB 공기청정기</span><br>
				<span style="font-size: 12px;">39,000 원</span><br>
			</div>
			<div class="wish" align="center">
				<img src="/resources/gonggu_uploadImg/item22.jpg" style="width:180px;height:180px;"><br>
				<span style="font-size: 12px;">머그컵 세트</span><br>
				<span style="font-size: 12px;">36,000 원</span><br>
			</div>
			<div class="wish" align="center">
				<img src="/resources/gonggu_uploadImg/item33.jpg" style="width:180px;height:180px;"><br>
				<span style="font-size: 12px;">검정 선글라스</span><br>
				<span style="font-size: 12px;">58,000 원</span><br>
			</div>
			<div class="wish" align="center">
				<img src="/resources/gonggu_uploadImg/item44.jpg" style="width:180px;height:180px;"><br>
				<span style="font-size: 12px;">검정 모자</span><br>
				<span style="font-size: 12px;">23,000 원</span><br>
			</div>
			
			<div id="wishpage" align="center">
				<a href="">[1]</a>
				<a href="">[2]</a>
				<a href="">[3]</a>
			</div>
		</div>
	</div>
</div>







