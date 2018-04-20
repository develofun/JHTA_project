<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<link rel="stylesheet" href="/resources/css/order_step1.css">
<style type="text/css">
	#popupDialog{width:400px;height:420px;overflow: auto; position: absolute;top:200px;
		right: 600px;visibility:hidden;border:2px double gray;background-color: white;margin:auto}
	#outer{border:1px dotted gray; width:380px; height:100px;text-align: center;margin:5px;}
	#inner{backgroud-color:#eee; margin:10px}
	#inner ul{list-style: none;}
	#payment_{background-color: gray;border:1px dotted gray}
	#discountArea{margin-top: 10px;margin-bottom: 10px}
</style>

<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
function getCouponList(id){
	$("#popupDialog1").empty();
	$.ajax({
		url:'myCoupon',
		data:'id='+id,
		dataType:'json',
		success:function(data){
			$("#popupDialog").css("visibility","visible");
			var html="";
			if(data.length>0){
				for(var i=0;i<data.length;i++){
					var str_sd = data[i].coupon_startDate.replace(/-/gi,"/");
					var date_sd = Date.parse(str_sd);
					var str_ed = data[i].coupon_endDate.replace(/-/gi,"/");
					var date_ed = Date.parse(str_ed);
				    var tt =data[i].now.replace(/-/gi,"/");
					var today = Date.parse(tt);
				    var minutes=1000*60;
					var using="사용불가";
					if(today>date_sd && today<date_ed){
						using="사용가능";
					}
					var qty=Number(data[i].coupon_mycoupon_qty);
					for(var j=0;j<qty;j++){
						html=
						"<div id='inner'>"+
							"<ul>"+
								"<li id='list_one'><h2>"+data[i].coupon_subject+"</h2></li>"+
								"<li id='list_two'><h3>"+data[i].coupon_discount+ "원</h3></li>"+ 
								"<li id='list_three'><h5>(결제금액 "+data[i].coupon_value+"원 이상 시 사용가능)</h5></li>"+
								"<li id='list_four'><h5>"+data[i].coupon_startDate+"~"+data[i].coupon_endDate+"<span style='color:red'>"+using+"</span></h5></li></ul></div></div>";	
							
						$("<div id='outer'></div>").html(html).appendTo("#popupDialog1");
					}
				}
			}else{
				html="보유중인 쿠폰이 없습니다.";
				$("#popupDialog1").html(html);
			}
			
		}
	});
}

	
	$(document).ready(function(){
		cp_load();	
		$("#backCart").on("click",function(){
			History.go(-1);
		});
		var pay=0;
		var point=0;
		$(".total").each(function(){
			var price=Number($(this).find("span").text());
			console.log("price:"+price);
			pay=pay+price;
		});
		$(".point").each(function(){
			var pp=Number($(this).find("span").text());
			console.log(pp);
			point=point+pp;
		});
		$("#order_price").append("<h3>총 주문금액 : <span name='sum' id='sum' style='color:black'>"+pay+"</span> 원<br>"+
					"<h5>적립포인트 : "+point+"p</h5>"+
									"<h6 id='delcharge'>(배송비 : <span style='color:black'>"+3000+" </span>원)");
		$("#payment_").append("<h3>총 결제금액 : <span id='total_' style='color:black' name='total_'>"+ (pay+3000) +"</span>원</h3>");
		
		$("#deladdr").on("click",function(){
			$.ajax({
				url:'getMember_info',
				dataType:'json',
				success:function(data){
					$("#name").val(data.member_privacy_name);
					$("#tel").val(data.member_privacy_phone);
					$("#addr").val(data.member_privacy_addr);
				}			
			});
		});
		$("#newaddr").on("click",function(){
			$("#name").val("");
			$("#tel").val("");
			$("#addr").val("");
		});
		
		$("#popclose").on("click",function(){
			$("#popupDialog").css("visibility","hidden");
		});
		
		//배송메세지 선택했을 때
		$(".msg").change(function(){
			val
		});
		
		//쿠폰을 선택했을 때
		$("#coupon").change(function(){
			var sum=Number($("#sum").text())+3000; //총 결제금액 가져오고
			var usep=Number($("#usepoint").val()); //사용포인트 가져오고
			
			var value=$(this).val();
			if(value=='0'){
				$("#payment_").empty();
				$("#payment_").append("<h3>총 결제금액 : <span id='total_' style='color:black'>"+ (sum-usep) +"</span>원</h3>");		
			}else{
				$.ajax({
					url:'getCouponInfo',
					data:'value='+value,
					dataType:'json',
					success:function(data){
						
						if(data.coupon_value>sum){
							alert(data.coupon_value+"원 이상 구매시에 적용 가능한 쿠폰입니다.");
						}else{
							total=sum-usep-Number(data.coupon_discount);
							$("#payment_").empty();
							$("#payment_").append("<h3>총 결제금액 : <span id='total_' style='color:black'>"+ total +"</span>원</h3>");
						}
					}
				});			
			}
		});
		
		var own=Number($("#usable").text());
		//포인트 적용을 눌렀을 때
		$("#pbtn").on("click",function(){
			var usepoint=Number($("#usepoint").val());
			if(own<usepoint){
				alert("보유중인 포인트 내에서 사용 가능합니다.");
				$("#usepoint").val("");
			}else{
				var total_p=(Number($("#sum").text())+3000)-usepoint;
				$("#payment_").empty();
				$("#payment_").append("<h3>총 결제금액 : <span id='total_' style='color:black'>"+ total_p +"</span>원</h3>");
				$("#usable").text(own-usepoint);
			}
		});
		
	});
	
function final_chk(){

	//	alert($(":radio[name='pay_method']:checked").val());
		
		if($("#name").val()==null || $("#name").val()==""){
			alert("받는분을 입력해 주세요!");
			return false;
		}
		if($("#addr").val()==null || $("#addr").val()==""){
			alert("주소를 입력해 주세요!");
			return false;
		}
		if($("#tel").val()==null || $("#tel").val()==""){
			alert("전화번호를 입력해 주세요!");
			return false;
		}
		if($(":radio[name='pay_method']:checked").val()==null || $(":radio[name='pay_method']:checked").val()==""){
			alert("결제수단을 선택해 주세요!");
			return false;
		}	
		return true;
}	
function cp_load(){
	$.ajax({
		url:'usable_cp',
		dataType:'json',
		success:function(data){
			$("#coupon").empty();
			if(data.length<0){
				$("#coupon").append("<option value='0'>적용 가능한 쿠폰이 없습니다.</option>");
			}
			else{
				$("#coupon").append("<option value='0'>----------선택안함---------</option>");
				for(var i=0;i<data.length;i++){
					for(var j=0;j<data[i].coupon_mycoupon_qty;j++){
						$("#coupon").append("<option value='"+data[i].coupon_mycoupon_num+"'>"+
								data[i].coupon_subject+"("+data[i].coupon_value+"원 이상 구매시"+
								data[i].coupon_discount+"원 할인)</option>");
					}
				}
			}						
		}
	});				
}	
	
</script>
<div class="order_wrap">
	<form action="setPayment.do" id="goPayment" onsubmit="return final_chk()">
		<div id="cart1">
			<div id="cart_top1">
				<img src="/resources/img/cart_img2.png">
			</div>
			<!-- 보유쿠폰 div 영역 -->
			<div id="popupDialog">
				<div id="popupDialog1">
				</div>
				<div>
					<input type="button" value="닫기" id="popclose">
				</div>
			</div>
			<div id="cart_top2">
				<div id="cart_top2_1">
				
					보유포인트 : ${minfo.member_privacy_point } p<br>
					보유쿠폰 : <a href="javascript:getCouponList('${minfo.member_privacy_id }');">${couponQty }</a>개
			
				</div>
			</div>
		</div>
		<div id="order_item">
			<table style="border: 2px dotted #eee" id="items">
				<tr>
					<th>상품번호</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>포인트</th>
					<th>가격</th>
					<th>수량</th>
					<th>금액</th>
				</tr>
				<c:forEach var="vo" items="${list }">
				<tr>
					<td><input type="hidden" name="item_code" value="${vo.item_code_num }">${vo.item_code_num}</td>
					<td><img src="/resources/itemset_img/${vo.itemset_code_mainimg}"></td>
					<td>${vo.item_code_setname}</td>
					<td class="point"><input type="hidden" name="point" value="<fmt:formatNumber pattern="#">${Math.floor(0.002 * vo.itemset_cart_price * vo.itemset_cart_order_qty)}</fmt:formatNumber>"><span style="color:black"><fmt:formatNumber pattern="#">${Math.floor(0.002 * vo.itemset_cart_price * vo.itemset_cart_order_qty)}</fmt:formatNumber></span> p</td>
					<td><input type="hidden" name="saleprice" value="${vo.itemset_cart_price }">${vo.itemset_cart_price} 원</td>
					<td><input type="hidden" name="order_qty" value="${vo.itemset_cart_order_qty}">${vo.itemset_cart_order_qty}</td>
					<td class="total"><input type="hidden" name="total" value="${vo.itemset_cart_price * vo.itemset_cart_order_qty}"><span style="color:black">${vo.itemset_cart_price * vo.itemset_cart_order_qty}</span> 원</td>
				</tr>
				</c:forEach>
			</table>
		
		</div>
		<div id="order_price" border="1">
		
		</div>
		<div id="discountArea" border="1px dotted gray">
			<label>보유포인트 : </label><span id="usable" style="color:black">${minfo.member_privacy_point } </span> 포인트  &nbsp;&nbsp;
			<input type="text" id="usepoint" name="usepoint" size="10"> <input type="button" value="적용하기" id="pbtn"><br>
			<label>사용가능쿠폰 : </label>
			<select id="coupon" name="coupon">
				
			</select>
		</div> 
		<!-- 총 결제금액이 보여지는 div -->
		<div id="payment_">
			
		</div>
		<div class="order_del">
			<h3>배송지정보</h3>
			<input type="radio" name="chk" id="deladdr">주문자 정보와 일치 &nbsp;
			<input type="radio" name="chk" id="newaddr">다른 배송지로 요청<br>
			<div id="deli_desc">
				<table method="post" id="deli_infotb">
					<tr>
						<th><label for="name">받는분 성함 </label></th>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<th><label for="tel">전화번호 </label></th>
						<td><input type="tel" name="tel" id="tel"></td>
					</tr>
					<tr>
						<th><label for="addr">주소</label></th>
						<td><input type="text" name="addr" id="addr" size="70"></td>
					</tr>
		
					<tr>
						<th><label for="msg">배송메세지&nbsp;</label></th>
						<td><select name="msg" class="msg">
								<option>부재시 문 앞에 놓아주세요</option>
								<option>방문 전 전화주세요</option>
								<option>관리실에 맡겨주세요</option>
								<option>기타----직접입력하기</option>
						</select></td>
					<tr>
				</table>
			</div>
		</div>
		<div id="payment">
			<h3>결제수단선택</h3>
			<input type="radio" class="pay_method" name="pay_method" value="1">신용카드<input
				type="radio" class="pay_method" name="pay_method" value="2">무통장입금 <input
				type="radio" class="pay_method" name="pay_method" value="3">핸드폰결제
		</div>
		
		<div id="btngroup">
			<input type="button" value="장바구니로" id="backCart"> 
			<input type="submit" value="결제하기" id="done">
		</div>
	</form>
	
</div>
