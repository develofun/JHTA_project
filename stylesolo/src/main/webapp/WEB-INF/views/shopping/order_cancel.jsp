<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/resources/css/order_cancle.css">
<style type="text/css">
	#reason_form {display:none;}
</style>
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("input[name=cancel_chk]").click(function(){
			$(this).parent().parent().next().toggle();
		});
	});
	
	function datechk(){
	//	alert("ooooooooo");
		var w_date=$("#w_date").val().replace(/-/gi,"/");
	//	alert("w_date" + w_date);
		var today=new Date();
		today.setDate(today.getDate()-10);
		var dd=today.getDate();
		var mm=today.getMonth()+1;
		var yyyy=today.getFullYear();
		
		if(dd<10){
			dd='0' + dd;
		}
		if(mm<10){
			mm='0' + mm;
		}
	//	alert("today" + today);
		today=yyyy + "/" + mm + "/" + dd;
		console.log("today:" + today);
		if(w_date<today){
			alert("환불 및 교환취소는 주문일로부터 10일 이내에 가능합니다.");
			return false;
		}else{
			return true;
		}
	}
</script>
<div class="orderdesc_wrap">
	<h3>주문번호 : ${order_num }</h3>

	<div id="orderdesc_items">
		<h4>상품내역</h4>
		<hr>
		<form method="post" action="cancel_apply" onsubmit="return datechk()">
			<input type="hidden" name="order_num" value="${order_num }">
			<input type="hidden" name="w_date" id="w_date" value="${list[0].SHOP_PAYMENT_W_DATE }">
			<table>
				<tr>
					<th>선택</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>옵션</th>
					<th>상품금액</th>
					<th>수량</th>
					<th>주문금액</th>
				</tr>
				<c:forEach var="vo" items="${list }">
		         <tr>
		         	<td><input type="checkbox" id="cancel_chk" name="cancel_chk" value="${vo.shop_payment_item_num }"></td>
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
		        
		         <tr id="reason_form">
					<td colspan="2">취소사유</td>
					<td>
						<select name="reason">
							<option value='0'>------------사유선택------------</option>
							<option>단순변심</option>
							<option>제품하자</option>
							<option>색상/사이즈 변경</option>
							<option>오배송</option>
							<option>오주문</option>
						</select>
					</td>
					<td colspan="4"></td>
				</tr>
				 
		         </c:forEach>
			</table>
			<br>
			<br>
			<div id="btn">
				<input type="submit" value="신청하기">
			</div>
		</form>
	</div>

</div>
