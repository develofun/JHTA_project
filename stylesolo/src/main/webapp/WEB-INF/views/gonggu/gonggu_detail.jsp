<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_detail.css" type="text/css">

<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

	function getList(){
		$.ajax({
			url:'/gonggu_detail_replylist/'+$("#gonggu_insert_num").val(),
			dataType:'json',
			success:function(data){
				for(var i=0;i<data.length;i++){
					$("#reply_div").append("<div style='border-bottom:1px solid #D5D5D5;'>"+
											"<span style='font-weight:bold;border-bottom:1px solid red'>"+data[i].id+"</span>"+
											"<span style='font-size:13px;color:gray;'>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+ data[i].date +"<br><br>"+
											"<span style='font-size:13px;color:#4C4C4C;'>"+data[i].comment+"<span><br><br></div>");
				}
			}
		});
	}
	
	$(document).ready(function(){
		getList();
		
		$("#btn_reply").on("click",function(){
			$.ajax({
				url:'/gonggu_detail_replyinsert',
				data: {"num":$("#gonggu_insert_num").val(),"comment":$("#gonggu_reply_comment").val(),"id":$("#member_privacy_id").val()},
				dataType:'json',
				success:function(data){
					if(data.insertOk==true){
						$("#reply_div").empty();
						getList();
						$("#gonggu_reply_comment").val("");
						$("#gonggu_reply_comment").focus();
					}else{
						alert("error");
					}
				}
			});
		});
	});
</script>
<script type="text/javascript">
	function tab1(){
		var tab1=document.getElementById("tab_1");
		var tab2=document.getElementById("tab_2");
		var tab3=document.getElementById("tab_3");
		var tab4=document.getElementById("tab_4");
		
		var a1=document.getElementById("a1");
		var a2=document.getElementById("a2");
		var a3=document.getElementById("a3");
		var a4=document.getElementById("a4");
		
		tab1.style.display="inline";
		tab2.style.display="none";
		tab3.style.display="none";
		tab4.style.display="none";
		
		a1.style.color="GRAY";
		a1.style.borderBottom="3px solid gray";
		a2.style.color="BLACK";
		a2.style.borderBottom="none";
		a3.style.color="BLACK";
		a3.style.borderBottom="none";
		a4.style.color="BLACK";
		a4.style.borderBottom="none";
	}
	function tab2(){
		var tab1=document.getElementById("tab_1");
		var tab2=document.getElementById("tab_2");
		var tab3=document.getElementById("tab_3");
		var tab4=document.getElementById("tab_4");
		
		var a1=document.getElementById("a1");
		var a2=document.getElementById("a2");
		var a3=document.getElementById("a3");
		var a4=document.getElementById("a4");
		
		tab1.style.display="none";
		tab2.style.display="inline";
		tab3.style.display="none";
		tab4.style.display="none";
		
		a1.style.color="BLACK";
		a1.style.borderBottom="none";
		a2.style.color="GRAY";
		a2.style.borderBottom="3px solid gray";
		a3.style.color="BLACK";
		a3.style.borderBottom="none";
		a4.style.color="BLACK";
		a4.style.borderBottom="none";
	}
	function tab3(){
		var tab1=document.getElementById("tab_1");
		var tab2=document.getElementById("tab_2");
		var tab3=document.getElementById("tab_3");
		var tab4=document.getElementById("tab_4");
		
		var a1=document.getElementById("a1");
		var a2=document.getElementById("a2");
		var a3=document.getElementById("a3");
		var a4=document.getElementById("a4");
		
		tab1.style.display="none";
		tab2.style.display="none";
		tab3.style.display="inline";
		tab4.style.display="none";
		
		a1.style.color="BLACK";
		a1.style.borderBottom="none";
		a2.style.color="BLACK";
		a2.style.borderBottom="none";
		a3.style.color="GRAY";
		a3.style.borderBottom="3px solid gray";
		a4.style.color="BLACK";
		a4.style.borderBottom="none";
	}
	function tab4(){
		var tab1=document.getElementById("tab_1");
		var tab2=document.getElementById("tab_2");
		var tab3=document.getElementById("tab_3");
		var tab4=document.getElementById("tab_4");
		
		var a1=document.getElementById("a1");
		var a2=document.getElementById("a2");
		var a3=document.getElementById("a3");
		var a4=document.getElementById("a4");
		
		tab1.style.display="none";
		tab2.style.display="none";
		tab3.style.display="none";
		tab4.style.display="inline";
		
		a1.style.color="BLACK";
		a1.style.borderBottom="none";
		a2.style.color="BLACK";
		a2.style.borderBottom="none";
		a3.style.color="BLACK";
		a3.style.borderBottom="none";
		a4.style.color="GRAY";
		a4.style.borderBottom="3px solid gray";
	}
</script>

<div id="wrap">
	<div id="title" align="center">
		<!-- 공구등록번호불러올때사용(gonggu_insert_num) -->
		<input type="hidden" id="gonggu_insert_num" name="gonggu_insert_num" value="${vo.gonggu_insert_num }">
		<input type="hidden" id="member_privacy_id" value="${sessionScope.id }">
		
		<h1>${vo.gonggu_insert_title }</h1>
		
	</div>
	<div id="content_left">
		<div id="content_img">
			<img src="/resources/gonggu_uploadImg/${vo.gonggu_img_sname }" style="width:580px;height:340px;border-radius:10px;">
		</div>
		<div id="content_simplecon">
			<h4>간단내용테스트!</h4>
			<span>간단내용은 이곳에!</span><br>
			<span>${vo.gonggu_insert_content }</span>
		</div>
	</div>
	<div id="content_right">
		<div id="content_price">
			<form method="post" action="/gonggu/ordering">
				<input type="hidden" id="gonggu_buy_price" name="gonggu_buy_price" value="${vo.gonggu_insert_price }">
				<input type="hidden" id="member_privacy_id" name="member_privacy_id" value="${sessionScope.id}">
				<input type="hidden" id="gonggu_insert_num" name="gonggu_insert_num" value="${vo.gonggu_insert_num }">
				
				<span style="font-weight: bold;color:black;">가격</span><br>
				<span style="font-size: 24px;"><fmt:formatNumber value="${vo.gonggu_insert_price}" pattern="###,###"/> 원</span><br><br>
				<span style="font-weight: bold;">종료일자</span><br>
				<span style="font-size: 24px;">${vo.gonggu_insert_closingdate }</span><br><br>
				<span style="font-weight: bold;">공구등록자(ID)</span><br>
				<span style="font-size: 24px;">${vo.member_privacy_id }</span><br><br>
				
				<c:choose>
					<c:when test="${d_day >=0 }">
						<c:choose>
							<c:when test="${vo.gonggu_insert_maxnum > 0}">
								<span style="font-weight: bold;">남은수량</span><br>
								<span style="font-size: 24px;">${vo.gonggu_insert_maxnum }</span><br><br>
								<span style="font-weight: bold;">구입수량</span><br>
								<input type="number" id="gonggu_buy_getnum" name="gonggu_buy_getnum" class="form-control" min="1" max="999" style="width:120px;height:30px;"><br>
								<input type="submit" value="구매하기" class="btn btn-primary btn-lg" style="margin-top:20px;" id="btn_buy">
							</c:when>
							<c:otherwise>
								<span style="font-size:24px;font-weight: bold;color:red;">재고없음</span>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<span style="font-size: 24px;font-weight:bold;color:red">공구종료</span><br><br>
					</c:otherwise>
				</c:choose>
				
			</form>
		</div>
	</div>
	
	<div id="detail_menu" align="center">
		<a href="javascript:tab1()" id="a1" style="color:gray;border-bottom:3px solid gray">상세보기</a>                                           
		<a href="javascript:tab2()" id="a2" style="margin-left:120px;">댓글 ( ${reply_cnt} )</a>
		<a href="javascript:tab3()" id="a3" style="margin-left:120px;">구매자 ( ${buyer_cnt} )</a>
		<a href="javascript:tab4()" id="a4" style="margin-left:120px;">배송/반품/환불안내</a>
	</div>
	
	<div id="detail_content">
	
		<div id="tabs">
			<div id="tab_1" style="display: inline;">
				${vo.gonggu_insert_content }
			</div>
			
			<div id="tab_2" style="display: none;">
			
				<c:choose>
					<c:when test="${not empty sessionScope.id }">
				
						<h3>댓글 등록</h3>
						<textarea id="gonggu_reply_comment" class="form-control" rows="2" cols="80" style="width:600px;float:left;"></textarea>
						<input type="button" id="btn_reply" class="btn btn-primary btn-lg" value="등록" style="height:50px;float:left;margin-left:10px;"><br>
						<br>
						<br>
						
					</c:when>
					<c:otherwise>
					
						<h3>댓글 등록은 회원만 가능합니다.</h3><br>
						<br>
						<br>
					
					</c:otherwise>
				</c:choose>
				
				<h3>댓글 리스트</h3>
				<div id="reply_div">
				</div>
			</div>
			
			<div id="tab_3" style="display: none;">
				<h2>구매자 리스트</h2>
				<c:forEach var="vo" items="${buyerlist }">
					<div id="${vo.gonggu_buy_num }" style="width:600px;height:40px;float:left;white-space:nowrap;
							overflow: hidden;text-overflow:ellipsis;border-radius:8px;margin:20px;padding:10px;border:1px solid gray;">
						<span id="span_buyerlist_id" style="font-size:15px;font-weight: bold;border-bottom:1px solid red;">${vo.member_privacy_id }</span>
						님께서 해당 공구제품을 ${vo.gonggu_buy_getnum } 개 구매하셨습니다. 
						<span id="span_buyerlist_date" style="color:gray;">[${vo.gonggu_buy_date }]</span>
					</div>
				</c:forEach>
			</div>
			
			<div id="tab_4" style="display: none;">
				<table class="gonggu_detail">
					<tr>
						<th>배송정보</th>
						<td style="font-size:13px;">
							▶ 배송기간은 주문일(또는 결제완료일)로부터 1일(24시간)~5일 정도 걸립니다. (지방일 경우 최장 7일)<br>
							▶ 기본 배송료는 2,500원입니다. (품 배송상품은, 주문금액이 30,000원 이상일 경우 무료배송)<br>
							▶ 업체조건배송 상품은 해당 브랜드 배송기준으로 배송비가 부여됩니다. <br>
							▶ 업체착불배송 상품은 해당 브랜드 배송기준 및 고객님의 배송지에 따라 개별적으로 부과됩니다. (가구 등의 상품은 지역에 따라 추가 배송비용이 발생할 수 있습니다.)<br>
							▶ 해외배송 표시가 있는 상품은 해외 주소로 바로 배송이 가능합니다.<br>
							▶ 지정일 배송은 택배회사에 관련된 사항이므로 택일이 불가합니다.<br>
							▶ 주문제작 상품의 경우 제작기간이 별도로 소요되오니 상품설명에 있는 제작기간 및 배송시기를 확인해 주세요. (DIY상품, 주문제작상품 등)</td>
					</tr>
					<tr>
						<th>교환/반품/환불 정보</th>
						<td style="font-size:13px;">
							배송완료 후 7일 이내에 신청할 수 있으며, 다음의 경우는 교환/반품 신청이 불가할 수 있습니다.<br>
							<br>
							‐ 반품/교환 가능 기간이 경과된 경우<br>
							‐ 포장을 개봉하였거나 포장이 훼손되어 상품가치가 현저히 감소한 경우<br>
							‐ 고객의 주문을 확인한 후 상품제작에 들어가는 주문제작상품인 경우<br>
							‐ 소비자가 책임 있는 사유로 상품 등이 멸실 또는 훼손된 경우<br>
							‐ 시간의 경과에 의해 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우<br>
							‐ 복제가 가능한 재화 등의 포장을 훼손한 경우<br>
							<br>
							단순변심에 의한 반품/교환 택배비는 고객님이 부담하셔야 하며, 반품 접수 없이 임의로 반송하거나 우편으로 보낼 경우 상품 확인이 어려워 환불이 불가능 할 수 있습니다.</td>
					</tr>
				</table>
			</div>
			
		</div>
	
	</div>
</div>