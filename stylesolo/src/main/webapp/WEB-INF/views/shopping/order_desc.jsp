<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/order_desc.css">
<div class="orderdesc_wrap">
   <h3>주문상세</h3>
   주문일자 / 주문상태 / 트래킹번호 <br>
   ${list[0].SHOP_PAYMENT_W_DATE} / ${list[0].SHOP_DELIVERY_HISTORY } / ${list[0].SHOP_DELIVERY_TRACKING }
   <div id="orderdesc_items">
      <h4>상품내역</h4>
      <hr>
      <table>
         <tr>
            <th>상품이미지</th>
            <th>상품명</th>
            <th>옵션</th>
            <th>상품금액</th>
            <th>수량</th>
            <th>주문금액</th>
         </tr>
         <c:forEach var="vo" items="${list }">
         <tr>
            <td><a href="#"><img src="/resources/item_img/${vo.SHOP_ITEM_MAINIMG_IMGNAME }"></a></td>
            <td>${vo.SHOP_ITEM_NAME }</td>
            <c:if test="${vo.item_options_name != null }">
            <td>${vo.item_options_name }</td>
            </c:if>
            <c:if test="${vo.item_options_name eq null }">
            <td></td>
            </c:if>
            <td>${vo.SHOP_ITEM_SALEPRICE }원</td>
            <td>${vo.SHOP_PAYMENT_ITEM_ORDER_QTY }</td>
            <td>${vo.SHOP_ITEM_SALEPRICE * vo.SHOP_PAYMENT_ITEM_ORDER_QTY }원</td>
         </tr>
         </c:forEach>
      </table>
   </div>
   <div id="orderdesc_addr">
      <h4>배송지정보</h4>
      <hr>
      <table>
         <tr>
            <th>받는사람</th><td>${list[0].SHOP_PAYMENT_DEL_NAME }</td>
         </tr>
         <tr>
            <th>연락처</th><td>${list[0].SHOP_PAYMENT_DEL_PHONE }</td>
         </tr>
         <tr>
            <th>주소</th><td>${list[0].SHOP_PAYMENT_DEL_ADDR }</td>
         </tr>
      </table>
      
   </div>
   <div id="orderdesc_pay">
      <h4>결제정보</h4>
      <hr>
      <table>
         <tr>
            <th>주문금액</th><td>${list[0].SHOP_PAYMENT_TOTAL_PRICE} 원</td>
         </tr>
         <tr>
            <th>쿠폰금액</th><td>${list[0].SHOP_PAYMENT_COUPON} 원</td>
         </tr>
         <tr>
            <th>포인트사용</th><td>${list[0].SHOP_PAYMENT_POINT} p</td>
         </tr>
         <tr>
            <th>배송비</th><td>3000 원</td>
         </tr>
         <tr>
            <th>결제방식</th><td>${list[0].PAYMENT_METHOD }</td>
         </tr>
         <tr>
            <td colspan="2" style="border-bottom: 1px solid gray"></td>
         </tr>
         <tr>
            <th>결제금액</th><td>${list[0].SHOP_PAYMENT_TOTAL_PRICE-list[0].SHOP_PAYMENT_COUPON-list[0].SHOP_PAYMENT_POINT+3000} 원</td>
         </tr>
      </table>
      <br><br>
      <a href="orderList.do">주문목록보기</a>
   </div>
</div>