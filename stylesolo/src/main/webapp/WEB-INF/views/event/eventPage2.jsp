<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/event.css" type="text/css">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#event_btn").click(function(){
			if($("#e_id").text()==""){
				alert("로그인을 해 주세요!");
				return false;
			}
			if($("#e_sort").text()=="종료"){alert("종료된 이벤트 입니다.");return false;}
			if($("#e_sort").text()=="예정"){alert("준비중인 이벤트 입니다.");return false;}
			var chk=parseInt($("#chk_coupon").text());
			var coupon_count=parseInt($("event_coupon_count").text());
			if(chk>0){alert("이벤트 쿠폰은 중복해서 받을 수 없습니다.");return false;}
			if(coupon_coupont==0){alert("준비한 쿠폰이 모두 소진되었습니다. 다음 이벤트를 기다려 주세요!");}
		});
	});
</script>
	<!-- 쿠폰상세 -->
	<div id="event_wrap">
		<div id="event_cupon_wrap">
			<div id="event_cupon_info">
				<img src="${path }${detail.event_image_name}" id="info_img">
				<span id="e_id" style="display: none;">${get_id }</span>
				<span id="e_sort" style="display: none;">${detail.event_sort }</span>
				<span id="chk_coupon" style="display: none;">${chk_get_coupon }</span>
				<span id="chk_coupon_count" style="display: none;">${event_coupon_count }</span>
			</div>
			<div id="event_cupon_btn">
				<a href="event_cupon_result?get_num=${get_num }&coupon_num=${coupon_num }" id="event_btn"><img src="${path }event_coupon_button.png" id="event_btn_img"></a>
			</div>
		</div>
	</div>