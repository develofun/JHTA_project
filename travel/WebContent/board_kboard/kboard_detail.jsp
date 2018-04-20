<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=7887d0a0e595f31404f756b11cbc647e"></script>
<div>

	<c:if test="${sessionScope.member_power eq 'admin'}">
		 <div id="kboard_detail_btn">
			<a href="/kboard.do?cmd=kboard_update_form&kboard_num=${dto.kboard_num }" id="kborad_updateBtn">수정</a>
			<a href="/kboard.do?cmd=kboard_delete&kboard_num=${dto.kboard_num }" id="kboard_deleteBtn">삭제</a>
		</div>
	</c:if>

	<div id="viewContent">
		<H2>[${dto.kboard_category }] ${dto.kboard_title }</H2>
		<div id="imgContent"><img src="/kimages/${dto.kboard_imgname }"></div>
		<div id="infoContent">
			<ul>
				<li><h5>주소 </h5>${dto.kboard_addr }</li>
				<li>${dto.kboard_plus_content }</li>
			</ul>
		</div>
		<div style="clear:both"></div>
		<h3>정보</h3>
		<div id="detailContent">${dto.kboard_content }</div>
		<div id="map"></div> 
		<script>
			var container = document.getElementById('map');
			var options = {
				center: new daum.maps.LatLng(${dto.kboard_x}, ${dto.kboard_y}),
				level: 3
			};
	
			var map = new daum.maps.Map(container, options);
			
			// 마커가 표시될 위치입니다 
			var markerPosition  = new daum.maps.LatLng(${dto.kboard_x}, ${dto.kboard_y}); 

			// 마커를 생성합니다
			var marker = new daum.maps.Marker({
			    position: markerPosition
			});

			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);

		</script>
	</div>
</div>