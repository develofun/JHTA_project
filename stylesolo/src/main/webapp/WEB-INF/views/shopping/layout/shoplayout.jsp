<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/shopmain.css">
<link rel="stylesheet" href="/resources/css/main/header.css" type="text/css">
<link rel="stylesheet" href="/resources/css/main/footer.css" type="text/css">
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
<style type="text/css">
	.fulldrop{width:1000px;}
</style>
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//퀵메뉴의 초기의 top속성값(50) 얻어오기
		var top = parseInt($(".side").css("top"));
		$(window).scroll(function() {
			//스크롤된 top속성값 얻어오기
			var sTop = $(window).scrollTop();
			//이동할 위치 구하기
			var moveTop = sTop + top;
			//퀵메뉴의 top속성을 스크롤된 top속성으로 설정하기
			//$("#quickmenu").css("top",moveTop);
			/*$("#quickmenu").stop(); //현재 실행중인 애니메이션 멈추기. 실행하지 않으면 반응이 빠르게 안됨.
			$("#quickmenu").animate({
				top:moveTop
			},1000);*/
			$(".side").stop().animate({ //stop의 리턴타입이 jQuery객체이기 때문에 바로 이어서 많이 쓴다.
				top : moveTop
			}, 1000);
		});

		var n = 150;
		$("#down").click(function(event) {
			event.preventDefault();
			//이동코드
			//alert($("#slide").css("left"));
			var imgloc = parseInt($("#imgslide").css("top"));
			var loc = imgloc + n;
			if (loc > 0)
				loc = 0;
			$("#imgslide").animate({
				top : loc
			});
		});

		var m = -154;
		$("#up").click(function(event) {
			event.preventDefault();
			var imgloc = parseInt($("#imgslide").css("top"));
			var loc = imgloc + m;
			if (loc < -600)
				loc = -600;
			$("#imgslide").animate({
				top : loc
			});
		});
	});
</script>
</head>
<body>
	<div id="header"><tiles:insertAttribute name="header"/> </div>
	<div class="wrap">
		<div class="main">
			<div id="main"><tiles:insertAttribute name="main"/></div>
			<div id="content"><tiles:insertAttribute name="content"/></div>
			<div id="footer"><tiles:insertAttribute name="footer"/></div>
		</div>
		<div class="side">
			<jsp:include page="../sidebar.jsp" />
		</div>
	</div>

</body>
</html>