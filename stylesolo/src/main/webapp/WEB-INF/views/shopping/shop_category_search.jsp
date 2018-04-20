<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<link rel="stylesheet" href="/resources/css/navbar_techandall.css">
<!-- Navigation CSS -->
<link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<script src="/resources/js/jssor.slider-22.2.16.min.js" type="text/javascript"></script>
<script type="text/javascript">
	/*메인 슬라이더 자바스크립트*/
	jssor_1_slider_init = function() {

		var jssor_1_SlideshowTransitions = [ {
			$Duration : 1200,
			x : -0.3,
			$During : {
				$Left : [ 0.3, 0.7 ]
			},
			$Easing : {
				$Left : $Jease$.$InCubic,
				$Opacity : $Jease$.$Linear
			},
			$Opacity : 2
		}, {
			$Duration : 1200,
			x : 0.3,
			$SlideOut : true,
			$Easing : {
				$Left : $Jease$.$InCubic,
				$Opacity : $Jease$.$Linear
			},
			$Opacity : 2
		} ];

		var jssor_1_options = {
			$AutoPlay : true,
			$SlideshowOptions : {
				$Class : $JssorSlideshowRunner$,
				$Transitions : jssor_1_SlideshowTransitions,
				$TransitionsOrder : 1
			},
			$ArrowNavigatorOptions : {
				$Class : $JssorArrowNavigator$
			},
			$BulletNavigatorOptions : {
				$Class : $JssorBulletNavigator$
			},
			$ThumbnailNavigatorOptions : {
				$Class : $JssorThumbnailNavigator$,
				$Cols : 1,
				$Align : 0,
				$NoDrag : true
			}
		};

		var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

		/*responsive code begin*/
		/*remove responsive code if you don't want the slider scales while window resizing*/
		function ScaleSlider() {
			var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
			if (refSize) {
				refSize = Math.min(refSize, 600);
				jssor_1_slider.$ScaleWidth(refSize);
			} else {
				window.setTimeout(ScaleSlider, 30);
			}
		}
		ScaleSlider();
		$Jssor$.$AddEvent(window, "load", ScaleSlider);
		$Jssor$.$AddEvent(window, "resize", ScaleSlider);
		$Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
		/*responsive code end*/
	};
</script>


<style type="text/css">
	#main {width:1000px;height:1200px;margin:auto;}
	#main #submenu {width: 1000px;height: 60px;border: 1px solid gray;margin-top:10px;}
	#main #search_submenu {width: 1000px;height: 300px;border: 1px solid gray;margin-top:10px;margin-bottom:10px;}
	#main #banner {width: 1000px;height: 300px;border: 1px solid gray;margin-top:10px;}
	#main #content_div {width: 1000px;height: 1150px;border: 1px solid gray;margin-top:10px;}
	#main #content_div #content_div1 {width:975px;height:180px;border:1px solid gray;float:left;margin:5px;padding:5px;}
	#main #content_div #content_div1 #div1_1 {width:965px;height:170px;border:1px solid gray;float:left;margin:5px;}
		
	#main #content_div #content_div2 {width:310px;height:720px;border:1px solid gray;float:left;margin:5px;padding:5px;}
	#main #content_div #content_div2 #div2_1 {width:300px;height:380px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div2 #div2_2 {width:300px;height:150px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div2 #div2_3 {width:300px;height:150px;border:1px solid gray;float:left;margin:5px;}
	
	#main #content_div #content_div3 {width:310px;height:720px;border:1px solid gray;float:left;margin:5px;padding:5px;}
	#main #content_div #content_div3 #div3_1 {width:300px;height:150px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div3 #div3_2 {width:300px;height:220px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div3 #div3_3 {width:300px;height:150px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div3 #div3_4 {width:300px;height:150px;border:1px solid gray;float:left;margin:5px;}
	
	#main #content_div #content_div4 {width:310px;height:720px;border:1px solid gray;float:left;margin:5px;padding:5px;}
	#main #content_div #content_div4 #div4_1 {width:300px;height:280px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div4 #div4_2 {width:300px;height:200px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div4 #div4_3 {width:300px;height:200px;border:1px solid gray;float:left;margin:5px;}
	
	#main #content_div #content_div5 {width:975px;height:175px;border:1px solid gray;float:left;margin:5px;padding:5px;}
	#main #content_div #content_div5 #div5_1 {width:475px;height:165px;border:1px solid gray;float:left;margin:5px;}
	#main #content_div #content_div5 #div5_2 {width:475px;height:165px;border:1px solid gray;float:left;margin:5px;}
	
	#divtest1 {width:330px;height:170px;float:right;margin:20px;}
	#divtest1 img {width:330px;height:170px;}
	#divtest3 {width:230px;height:170px;float:right;margin:20px;}
	#divtest3 img {width:230px;height:170px;}
	#divtest4 {width:230px;height:170px;float:right;margin:20px;}
	#divtest4 img {width:230px;height:170px;}
	#divtest5 {width:330px;height:170px;float:right;margin:20px;}
	#divtest5 img {width:330px;height:170px;}
	
	#content_category {width:1000px;height:1100px;border: 1px solid gray;}
	#category1 {width:745px;height:1070px;float:right;position:relative;right:10px;border: 1px solid gray;margin-top:10px;padding:5px;}
	
	#category1_div1_1 {width:705px;height:950px;border: 1px solid gray;margin:10px;padding:10px;}
	#category1_div1_2 {width:715px;height:20px;border: 1px solid gray;margin:10px;padding:5px;}
	
/*-------------- 검색관련css ------------------*/

#search_nav {
	width:360px;
	height:30px;
	border: 1px solid gray;
    float: left;
    padding: 10px;
    position: relative;
    left:95px;
    margin-top: 30px;
}

#search_radio {
	width:220px;
	height:30px;
	border: 1px solid gray;
    float: left;
    padding: 10px;
    position: relative;
    left:70px;
    margin-top: 35px;
}

#search_category {
	width:915px;
	height:150px;
	border: 1px solid gray;
	padding: 10px;
	float: left;
	position: relative;
	left:30px;
	margin-top: 20px;
}

#search_nav:hover {
	background-color: transparent;
}

#search_nav input {
	width:300px;
	padding: 7px 6px 6px 38px;
	color:#000000;
	border:none;
	background-color: #FFFFFF; /* 검색영역 백그라운드 컬러 */
	font-size: 14px;
	border: 2px solid gray; /* 검색영역 div 보더 색상 */
}

#search_nav input:focus {
	outline: none;
	border-color: black;
}

#search_nav i {
	position: absolute;
	left: 18px;
	top:14px;
	color: #000;
	font-size: 18px;
}
	
/*-------------- 메인슬라이드관련css ------------------*/
/* jssor slider bullet navigator skin 01 css */
/*
        .jssorb01 div           (normal)
        .jssorb01 div:hover     (normal mouseover)
        .jssorb01 .av           (active)
        .jssorb01 .av:hover     (active mouseover)
        .jssorb01 .dn           (mousedown)
        */
.jssorb01 {
	position: absolute;
}

.jssorb01 div, .jssorb01 div:hover, .jssorb01 .av {
	position: absolute;
	/* size of bullet elment */
	width: 12px;
	height: 12px;
	filter: alpha(opacity = 70);
	opacity: .7;
	overflow: hidden;
	cursor: pointer;
	border: #000 1px solid;
}

.jssorb01 div {
	background-color: gray;
}

.jssorb01 div:hover, .jssorb01 .av:hover {
	background-color: #d3d3d3;
}

.jssorb01 .av {
	background-color: #fff;
}

.jssorb01 .dn, .jssorb01 .dn:hover {
	background-color: #555555;
}

/* jssor slider arrow navigator skin 05 css */
/*
        .jssora05l                  (normal)
        .jssora05r                  (normal)
        .jssora05l:hover            (normal mouseover)
        .jssora05r:hover            (normal mouseover)
        .jssora05l.jssora05ldn      (mousedown)
        .jssora05r.jssora05rdn      (mousedown)
        .jssora05l.jssora05lds      (disabled)
        .jssora05r.jssora05rds      (disabled)
        */
.jssora05l, .jssora05r {
	display: block;
	position: absolute;
	/* size of arrow element */
	width: 40px;
	height: 40px;
	cursor: pointer;
	background: url('/resources/img/a17.png') no-repeat;
	overflow: hidden;
}

.jssora05l {
	background-position: -10px -40px;
}

.jssora05r {
	background-position: -70px -40px;
}

.jssora05l:hover {
	background-position: -130px -40px;
}

.jssora05r:hover {
	background-position: -190px -40px;
}

.jssora05l.jssora05ldn {
	background-position: -250px -40px;
}

.jssora05r.jssora05rdn {
	background-position: -310px -40px;
}

.jssora05l.jssora05lds {
	background-position: -10px -40px;
	opacity: .3;
	pointer-events: none;
}

.jssora05r.jssora05rds {
	background-position: -70px -40px;
	opacity: .3;
	pointer-events: none;
}
/* jssor slider thumbnail navigator skin 09 css */
.jssort09-600-45 .p {
	position: absolute;
	top: 0;
	left: 0;
	width: 600px;
	height: 45px;
}

.jssort09-600-45 .t {
	font-family: verdana;
	font-weight: normal;
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	color: #fff;
	line-height: 45px;
	font-size: 20px;
	padding-left: 10px;
}
</style>

<body>
<div id="main">
	<div id="submenu">
		<div id="container">
			<div style="margin-top:24px;"> <!-- 메뉴바 이동 -->
				<label class="mobile_menu" for="mobile_menu">
				<span>Menu</span>
				</label>
				<input id="mobile_menu" type="checkbox">
				<ul class="nav">
					<li class="dropdown"><a href="goDeco">홈데코</a>
						<div class="fulldrop">
							<div class="column">
								<h3>가구/침구</h3>
								<ul>
									<li><a href="<c:url value='/category?code=100'/>">거실/침실</a></li>
									<li><a href="<c:url value='/category?code=101'/>">주방/수납</a></li>
									<li><a href="<c:url value='/category?code=102'/>">학생/사무</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>주방/생활</h3>
								<ul>
									<li><a href="<c:url value='/category?code=110'/>">식기</a></li>
									<li><a href="<c:url value='/category?code=111'/>">수납</a></li>
									<li><a href="<c:url value='/category?code=112'/>">청소</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>인테리어</h3>
								<ul>
									<li><a href="<c:url value='/category?code=120'/>">인테리어 소품</a></li>
									<li><a href="<c:url value='/category?code=121'/>">DIY 소품</a></li>
									<li><a href="<c:url value='/category?code=122'/>">팬시</a></li>
								</ul>
							</div>
							<div id="divtest1">
								<img src="/resources/img/menubar1.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="digital">가전/디지털</a>
						<div class="fulldrop">
							<div class="column">
								<h3>대형가전</h3>
								<ul>
									<li><a href="<c:url value='/category?code=200'/>">냉장고</a></li>
									<li><a href="<c:url value='/category?code=201'/>">TV</a></li>
									<li><a href="<c:url value='/category?code=202'/>">세탁기</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>주방가전</h3>
								<ul>
									<li><a href="<c:url value='/category?code=210'/>">소형가전</a></li>
									<li><a href="<c:url value='/category?code=211'/>">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>생활/이미용기</h3>
								<ul>
									<li><a href="<c:url value='/category?code=220'/>">헤어</a></li>
									<li><a href="<c:url value='/category?code=221'/>">피부관리</a></li>
									<li><a href="<c:url value='/category?code=222'/>">공기청정기</a></li>
									<li><a href="<c:url value='/category?code=223'/>">가습기</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>노트북/PC</h3>
								<ul>
									<li><a href="<c:url value='/category?code=230'/>">노트북</a></li>
									<li><a href="<c:url value='/category?code=231'/>">데스크톱</a></li>
									<li><a href="<c:url value='/category?code=232'/>">악세사리</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>휴대폰/음향기기</h3>
								<ul>
									<li><a href="<c:url value='/category?code=240'/>">휴대폰</a></li>
									<li><a href="<c:url value='/category?code=241'/>">이어폰/헤드폰</a></li>
									<li><a href="<c:url value='/category?code=242'/>">마이크</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="women">여성</a>
						<div class="fulldrop">
							<div class="column">
								<h3>아우터</h3>
								<ul>
									<li><a href="<c:url value='/category?code=300'/>">코트</a></li>
									<li><a href="<c:url value='/category?code=301'/>">자켓</a></li>
									<li><a href="<c:url value='/category?code=302'/>">점퍼</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>상의</h3>
								<ul>
									<li><a href="<c:url value='/category?code=310'/>">티셔츠</a></li>
									<li><a href="<c:url value='/category?code=311'/>">블라우스</a></li>
									<li><a href="<c:url value='/category?code=312'/>">니트</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>하의</h3>
								<ul>
									<li><a href="<c:url value='/category?code=320'/>">스커트</a></li>
									<li><a href="<c:url value='/category?code=321'/>">팬츠</a></li>
									<li><a href="<c:url value='/category?code=322'/>">데님</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>잡화</h3>
								<ul>
									<li><a href="<c:url value='/category?code=330'/>">구두/운동화</a></li>
									<li><a href="<c:url value='/category?code=331'/>">가방</a></li>
									<li><a href="<c:url value='/category?code=332'/>">악세사리</a></li>
								</ul>
							</div>
							<div id="divtest3">
								<img src="/resources/img/menubar2.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="man">남성</a>
						<div class="fulldrop">
							<div class="column">
								<h3>아우터</h3>
								<ul>
									<li><a href="<c:url value='/category?code=400'/>">코트</a></li>
									<li><a href="<c:url value='/category?code=401'/>">자켓</a></li>
									<li><a href="<c:url value='/category?code=402'/>">점퍼</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>상의</h3>
								<ul>
									<li><a href="<c:url value='/category?code=410'/>">티셔츠</a></li>
									<li><a href="<c:url value='/category?code=411'/>">셔츠</a></li>
									<li><a href="<c:url value='/category?code=412'/>">니트</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>하의</h3>
								<ul>
									<li><a href="<c:url value='/category?code=420'/>">슬랙스</a></li>
									<li><a href="<c:url value='/category?code=421'/>">데님</a></li>
									<li><a href="<c:url value='/category?code=422'/>">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>잡화</h3>
								<ul>
									<li><a href="<c:url value='/category?code=430'/>">구두/운동화</a></li>
									<li><a href="<c:url value='/category?code=431'/>">가방</a></li>
									<li><a href="<c:url value='/category?code=432'/>">벨트</a></li>
								</ul>
							</div>
							<div id="divtest4">
								<img src="/resources/img/menubar3.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="sports">레저/스포츠</a>
						<div class="fulldrop">
							<div class="column">
								<h3>골프의류/잡화</h3>
								<ul>
									<li><a href="<c:url value='/category?code=500'/>">남성골프의류</a></li>
									<li><a href="<c:url value='/category?code=501'/>">여성골프의류</a></li>
									<li><a href="<c:url value='/category?code=502'/>">악세사리</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>등산/캠핑/낚시</h3>
								<ul>
									<li><a href="<c:url value='/category?code=510'/>">등산용품</a></li>
									<li><a href="<c:url value='/category?code=511'/>">등산의류</a></li>
									<li><a href="<c:url value='/category?code=512'/>">캠핑용품</a></li>
									<li><a href="<c:url value='/category?code=513'/>">낚시용품</a></li>
								</ul>
							</div>
							<div id="divtest5">
								<img src="/resources/img/menubar4.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="hobby">취미/애견/반려용품</a>
						<div class="fulldrop">
							<div class="column">
								<h3>토이</h3>
								<ul>
									<li><a href="<c:url value='/category?code=600'/>">블럭</a></li>
									<li><a href="<c:url value='/category?code=601'/>">피규어</a></li>
									<li><a href="<c:url value='/category?code=602'/>">인형</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>DIY</h3>
								<ul>
									<li><a href="<c:url value='/category?code=610'/>">퀼트</a></li>
									<li><a href="<c:url value='/category?code=611'/>">뜨개질</a></li>
									<li><a href="<c:url value='/category?code=612'/>">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>강아지용품</h3>
								<ul>
									<li><a href="<c:url value='/category?code=620'/>">사료</a></li>
									<li><a href="<c:url value='/category?code=621'/>">의류</a></li>
									<li><a href="<c:url value='/category?code=622'/>">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>고양이용품</h3>
								<ul>
									<li><a href="<c:url value='/category?code=630'/>">사료</a></li>
									<li><a href="<c:url value='/category?code=631'/>">의류</a></li>
									<li><a href="<c:url value='/category?code=632'/>">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>기타용품</h3>
								<ul>
									<li><a href="<c:url value='/category?code=640'/>">기타</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="food">식료품</a>
						<div class="fulldrop">
							<div class="column">
								<h3>신선식품</h3>
								<ul>
									<li><a href="<c:url value='/category?code=700'/>">채소</a></li>
									<li><a href="<c:url value='/category?code=701'/>">육류</a></li>
									<li><a href="<c:url value='/category?code=702'/>">곡류</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>가공식품</h3>
								<ul>
									<li><a href="<c:url value='/category?code=710'/>">라면/컵라면</a></li>
									<li><a href="<c:url value='/category?code=711'/>">통조림</a></li>
									<li><a href="<c:url value='/category?code=712'/>">소시지/햄</a></li>
									<li><a href="<c:url value='/category?code=713'/>">유가공품</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>간식</h3>
								<ul>
									<li><a href="<c:url value='/category?code=720'/>">초콜릿</a></li>
									<li><a href="<c:url value='/category?code=721'/>">사탕/젤리</a></li>
									<li><a href="<c:url value='/category?code=722'/>">과자</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>기타</h3>
								<ul>
									<li><a href="<c:url value='/category?code=730'/>">기타</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li class="search">
						<form action="Search.php">
							<input type="text"><i class="icon-search icon-large"></i>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div id="banner">
		<!------------------- 메인 슬라이드 div ----------------------->
		<div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:120px;width:600px;height:300px;overflow:hidden;visibility:hidden;">
	        <!-- Loading Screen -->
	        <div data-u="loading" style="position:absolute;top:0px;left:0px;background-color:rgba(0,0,0,0.7);">
	            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
	            <div style="position:absolute;display:block;background:url('/resources/img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
	        </div>
	        <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:600px;height:300px;overflow:hidden;">
	            <div>
	                <img data-u="image" src="/resources/img/01.jpg" />
	                <div data-u="thumb"></div>
	            </div>
	            <div>
	                <img data-u="image" src="/resources/img/02.jpg" />
	                <div data-u="thumb"></div>
	            </div>
	            <div>
	                <img data-u="image" src="/resources/img/03.jpg" />
	                <div data-u="thumb"></div>
	            </div>
	            <a data-u="any" href="http://www.jssor.com" style="display:none">Banner Slider</a>
	            <div>
	                <img data-u="image" src="/resources/img/04.jpg" />
	                <div data-u="thumb"></div>
	            </div>
	        </div>
	        <!-- Thumbnail Navigator -->
	        <div data-u="thumbnavigator" class="jssort09-600-45" style="position:absolute;bottom:0px;left:0px;width:600px;height:45px;">
	            <!-- Thumbnail Item Skin Begin -->
	            <div data-u="slides" style="cursor: default;">
	                <div data-u="prototype" class="p">
	                    <div data-u="thumbnailtemplate" class="t"></div>
	                </div>
	            </div>
	            <!-- Thumbnail Item Skin End -->
	        </div>
	        <!-- Bullet Navigator -->
	        <div data-u="navigator" class="jssorb01" style="bottom:16px;right:16px;">
	            <div data-u="prototype" style="width:12px;height:12px;"></div>
	        </div>
	        <!-- Arrow Navigator -->
	        <span data-u="arrowleft" class="jssora05l" style="top:0px;left:8px;width:40px;height:40px;" data-autocenter="2"></span>
	        <span data-u="arrowright" class="jssora05r" style="top:0px;right:8px;width:40px;height:40px;" data-autocenter="2"></span>
	    </div>
	    <script type="text/javascript">jssor_1_slider_init();</script>
	    <!----------------- 여기까지 메인슬라이드 div부분 ------------------------->
	</div>
	
	<div id="search_submenu">
		<div id="search_radio">
			<input type="radio" name="search_click" value="search_all" checked="checked">전체검색&nbsp;&nbsp;
			<input type="radio" name="search_click" value="search_category">결과 내 검색
		</div>
		<div id="search_nav">
			<form action="Search.php">
				<input type="text"><i class="icon-search icon-large"></i>
			</form>
		</div>
		<div id="search_category">
			카테고리
		</div>
	</div>
	
	<div id="content_category">
		<div  id="category1">
			<div id="category1_div1_1">
				검색상품
			</div>
			<div id="category1_div1_2">
				페이지처리
			</div>
		</div>
	</div>
</div>
</body>