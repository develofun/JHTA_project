<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link rel="stylesheet" href="/resources/css/navbar_techandall.css">
<!-- Navigation CSS -->
<link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

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
	#main #submenu {width: 1000px;height: 60px;margin-top:10px;}	
	#divtest {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}


</style>

</head>
<body>
<div id="submenu">
		<div id="container">
			<div style="margin-top:24px;"> <!-- 메뉴바 이동 -->
				<label class="mobile_menu" for="mobile_menu">
				<span>Menu</span>
				</label>
				<input id="mobile_menu" type="checkbox">
				<ul class="nav" style="border-radius:10px;margin-left:5px;width:988px">
					<li class="dropdown"><a href="/category?code=1">홈데코</a>
						<div class="fulldrop">
							<div class="column">
								<h3>가구/침구</h3>
								<ul>
									<li><a href="/category?code=100">거실/침실</a></li>
									<li><a href="/category?code=101">주방/수납</a></li>
									<li><a href="/category?code=102">학생/사무</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>주방/생활</h3>
								<ul>
									<li><a href="/category?code=110">식기</a></li>
									<li><a href="/category?code=111">수납</a></li>
									<li><a href="/category?code=112">청소</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>인테리어</h3>
								<ul>
									<li><a href="/category?code=120">인테리어 소품</a></li>
									<li><a href="/category?code=121">DIY 소품</a></li>
									<li><a href="/category?code=122">팬시</a></li>
								</ul>
							</div>
							<div id="divtest1">
								<img src="/resources/img/menubar1.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="/category?code=2">가전/디지털</a>
						<div class="fulldrop">
							<div class="column">
								<h3>대형가전</h3>
								<ul>
									<li><a href="/category?code=200">냉장고</a></li>
									<li><a href="/category?code=201">TV</a></li>
									<li><a href="/category?code=202">세탁기</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>주방가전</h3>
								<ul>
									<li><a href="/category?code=210">소형가전</a></li>
									<li><a href="/category?code=211">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>생활/이미용기</h3>
								<ul>
									<li><a href="/category?code=220">헤어</a></li>
									<li><a href="/category?code=221">피부관리</a></li>
									<li><a href="/category?code=222">공기청정기</a></li>
									<li><a href="/category?code=223">가습기</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>노트북/PC</h3>
								<ul>
									<li><a href="/category?code=230">노트북</a></li>
									<li><a href="/category?code=231">데스크톱</a></li>
									<li><a href="/category?code=232">악세사리</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>휴대폰/음향기기</h3>
								<ul>
									<li><a href="/category?code=240">휴대폰</a></li>
									<li><a href="/category?code=241">이어폰/헤드폰</a></li>
									<li><a href="/category?code=242">마이크</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="/category?code=3">여성</a>
						<div class="fulldrop">
							<div class="column">
								<h3>아우터</h3>
								<ul>
									<li><a href="/category?code=300">코트</a></li>
									<li><a href="/category?code=301">자켓</a></li>
									<li><a href="/category?code=302">점퍼</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>상의</h3>
								<ul>
									<li><a href="/category?code=310">티셔츠</a></li>
									<li><a href="/category?code=311">블라우스</a></li>
									<li><a href="/category?code=312">니트</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>하의</h3>
								<ul>
									<li><a href="/category?code=320">스커트</a></li>
									<li><a href="/category?code=321">팬츠</a></li>
									<li><a href="/category?code=322">데님</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>잡화</h3>
								<ul>
									<li><a href="/category?code=330">구두/운동화</a></li>
									<li><a href="/category?code=331">가방</a></li>
									<li><a href="/category?code=332">악세사리</a></li>
								</ul>
							</div>
							<div id="divtest3">
								<img src="/resources/img/menubar2.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="/category?code=4">남성</a>
						<div class="fulldrop">
							<div class="column">
								<h3>아우터</h3>
								<ul>
									<li><a href="/category?code=400">코트</a></li>
									<li><a href="/category?code=401">자켓</a></li>
									<li><a href="/category?code=402">점퍼</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>상의</h3>
								<ul>
									<li><a href="/category?code=410">티셔츠</a></li>
									<li><a href="/category?code=411">셔츠</a></li>
									<li><a href="/category?code=412">니트</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>하의</h3>
								<ul>
									<li><a href="/category?code=420">슬랙스</a></li>
									<li><a href="/category?code=421">데님</a></li>
									<li><a href="/category?code=422">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>잡화</h3>
								<ul>
									<li><a href="/category?code=430">구두/운동화</a></li>
									<li><a href="/category?code=431">가방</a></li>
									<li><a href="/category?code=432">벨트</a></li>
								</ul>
							</div>
							<div id="divtest4">
								<img src="/resources/img/menubar3.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="/category?code=5">레저/스포츠</a>
						<div class="fulldrop">
							<div class="column">
								<h3>골프의류/잡화</h3>
								<ul>
									<li><a href="/category?code=500">남성골프의류</a></li>
									<li><a href="/category?code=501">여성골프의류</a></li>
									<li><a href="/category?code=502">악세사리</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>등산/캠핑/낚시</h3>
								<ul>
									<li><a href="/category?code=510">등산용품</a></li>
									<li><a href="/category?code=511">등산의류</a></li>
									<li><a href="/category?code=512">캠핑용품</a></li>
									<li><a href="/category?code=513">낚시용품</a></li>
								</ul>
							</div>
							<div id="divtest5">
								<img src="/resources/img/menubar4.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="/category?code=6">취미/애견/반려용품</a>
						<div class="fulldrop">
							<div class="column">
								<h3>토이</h3>
								<ul>
									<li><a href="/category?code=600">블럭</a></li>
									<li><a href="/category?code=601">피규어</a></li>
									<li><a href="/category?code=602">인형</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>DIY</h3>
								<ul>
									<li><a href="/category?code=610">퀼트</a></li>
									<li><a href="/category?code=611">뜨개질</a></li>
									<li><a href="/category?code=612">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>강아지용품</h3>
								<ul>
									<li><a href="/category?code=620">사료</a></li>
									<li><a href="/category?code=621">의류</a></li>
									<li><a href="/category?code=622">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>고양이용품</h3>
								<ul>
									<li><a href="/category?code=630">사료</a></li>
									<li><a href="/category?code=631">의류</a></li>
									<li><a href="/category?code=632">기타</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>기타용품</h3>
								<ul>
									<li><a href="/category?code=640">기타</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="/category?code=7">식료품</a>
						<div class="fulldrop">
							<div class="column">
								<h3>신선식품</h3>
								<ul>
									<li><a href="/category?code=700">채소</a></li>
									<li><a href="/category?code=701">육류</a></li>
									<li><a href="/category?code=702">곡류</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>가공식품</h3>
								<ul>
									<li><a href="/category?code=710">라면/컵라면</a></li>
									<li><a href="/category?code=711">통조림</a></li>
									<li><a href="/category?code=712">소시지/햄</a></li>
									<li><a href="/category?code=713">유가공품</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>간식</h3>
								<ul>
									<li><a href="/category?code=720">초콜릿</a></li>
									<li><a href="/category?code=721">사탕/젤리</a></li>
									<li><a href="/category?code=722">과자</a></li>
								</ul>
							</div>
							<div class="column">
								<h3>기타</h3>
								<ul>
									<li><a href="/category?code=730">기타</a></li>
								</ul>
							</div>
						</div>
					</li>
					<li class="search">
						<form action="/mainSearch">
							<input type="text" name="search"><i class="icon-search icon-large"></i>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>