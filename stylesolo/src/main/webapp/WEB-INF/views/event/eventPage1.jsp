<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/event.css">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".event_items_imgs").click(function(){
			if($("#e_id").text()==""){
				alert("로그인을 해 주세요!");
				return false;
			}
			if($("#e_sort").text()=="종료"){alert("종료된 이벤트 입니다.");return false;}
			if($("#e_sort").text()=="예정"){alert("준비중인 이벤트 입니다.");return false;}
		});
		$(".event_items").click(function(){
			if($("#e_id").text()==""){
				alert("로그인을 해 주세요!");
				return false;
			}
			if($("#e_sort").text()=="종료"){alert("종료된 이벤트 입니다.");return false;}
			if($("#e_sort").text()=="예정"){alert("준비중인 이벤트 입니다.");return false;}
		});
	});
</script>
	<!-- 할인+할인목록 -->
	<div id="event_wrap">
		<div id="event_head">
			<img src="${path }${detail.event_image_name }" id="event_detail_head_img">
			<span style="display: none;">${event_rate }</span>
			<span id="e_id" style="display: none;">${get_id }</span>
			<span id="e_sort" style="display: none;">${detail.event_sort }</span>
		</div>
		<div id="event_item_list">
			<c:forEach var="vo" items="${event_item }">
				<div id="event_item">
					<div id="event_item_img"><a href="/shoplayout?item_code=${vo.shop_item_code }" class="event_items_imgs"><img src="${itempath }${vo.shop_item_mainimg_imgname }"/></a></div>
					<div id="event_item_name"><a href="/shoplayout?item_code=${vo.shop_item_code }" class="event_items">${vo.shop_item_name }</a></div>
				</div>
			</c:forEach>
		</div>
		<div id="event_item_paging">
			<c:forEach var="i" begin="${item_pu.startPageNum }" end="${item_pu.endPageNum }">
				<c:choose>
					<c:when test="${i==0}"></c:when>
						<c:when test="${i==item_pu.pageNum}">
							<a href="event_detail?get_event_num${get_event_num }&pageNum=${i }"><span style="color: red;">[${i }]</span></a>
						</c:when>
					<c:otherwise>
							<a href="event_detail?get_event_num=${get_event_num }&pageNum=${i }"><span style="color: #333;">[${i }]</span></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>