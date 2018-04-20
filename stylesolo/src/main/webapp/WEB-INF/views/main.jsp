<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	#divtest1 {width:330px;height:170px;float:right;margin:20px;}
	#divtest1 img {width:330px;height:170px;}
	#divtest3 {width:230px;height:170px;float:right;margin:20px;}
	#divtest3 img {width:230px;height:170px;}
	#divtest4 {width:230px;height:170px;float:right;margin:20px;}
	#divtest4 img {width:230px;height:170px;}
	#divtest5 {width:330px;height:170px;float:right;margin:20px;}
	#divtest5 img {width:330px;height:170px;}
</style>

<div id="main">
	<div id="banner">
		<!------------------- 메인 슬라이드 div ----------------------->
		<div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:600px;height:300px;overflow:hidden;visibility:hidden;">
	        <!-- Loading Screen -->
	        <div data-u="loading" style="position:absolute;top:0px;left:0px;background-color:rgba(0,0,0,0.7);">
	            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
	            <div style="position:absolute;display:block;background:url('/resources/img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
	        </div>
	        <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:600px;height:300px;overflow:hidden;">
	            <!-- 
	            <div>
	                <img data-u="image" src="/resources/img/mainbanner1.jpg"/>
	                <div data-u="thumb">STYLE SOLO OPEN !</div>
	            </div>
	            <div>
	                <img data-u="image" src="/resources/img/mainbanner2.jpg"/>
	                <div data-u="thumb">혼족만의, 혼족들을 위한 Style Solo</div>
	            </div>
	            <div>
	                <img data-u="image" src="/resources/img/mainbanner3.jpg"/>
	                <div data-u="thumb">혼족들의 소비패턴을 알고있는 Style Solo</div>
	            </div>
	             -->
	            <c:forEach var="bannerData" items="${mainBanner}">
		            <div>
		            	<img data-u="image" src="/resources/img/${bannerData.banner_img}"/>
		                <div data-u="thumb">${bannerData.banner_title}</div>
		            </div>
	            </c:forEach>
	        </div>
	        <!-- Thumbnail Navigator -->
	        <div data-u="thumbnavigator" class="jssort09-600-45" style="position:absolute;bottom:0px;left:0px;width:600px;height:45px;">
	            <div style="position:absolute;top:0;left:0;width:100%;height:100%;background-color:#000;filter:alpha(opacity=40.0);opacity:0.4;"></div>
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
					<li class="dropdown"><a href="/category?code=2">가전/디지털</a>
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
					<li class="dropdown"><a href="/category?code=3">여성</a>
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
					<li class="dropdown"><a href="/category?code=4">남성</a>
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
					<li class="dropdown"><a href="/category?code=5">레저/스포츠</a>
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
					<li class="dropdown"><a href="/category?code=6">취미/애견/반려용품</a>
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
					<li class="dropdown"><a href="/category?code=7">식료품</a>
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
						<form action="/mainSearch">
							<input type="text" name="search"><i class="icon-search icon-large"></i>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div id="content_div">
		<div id="content_div1">
			<div id="div1_1" style="height:340px;">
				<span style="color:black;font-size:24px;font-weight: bold;">오늘의 쇼핑베스트</span>
				<div class="cycle-slideshow" data-cycle-fx="scrollHorz" data-cycle-timeout=2000>
					<div class="cycle-pager"></div>
					<%-- 
					<img src="/resources/item_img/${requestScope.bList.get(0).getMainimg()}" style="width:270px;height:270px;border-radius:20px;">
					<img src="/resources/item_img/${requestScope.bList.get(1).getMainimg()}" style="width:270px;height:270px;border-radius:20px;">
					<img src="/resources/item_img/${requestScope.bList.get(2).getMainimg()}" style="width:270px;height:270px;border-radius:20px;">
					 --%>
				</div>
			</div>
			<div id="div1_2">
				<span style="color:black;font-size:24px;font-weight: bold;">오늘의 공구베스트</span>
				<div class="cycle-slideshow" data-cycle-fx="scrollHorz" data-cycle-timeout=3000>
					
					<div class="cycle-pager"></div>
					
					<c:forEach var="gongguData" items="${majorGongguData}">
						<img src="/resources/gonggu_uploadImg/${gongguData.gonggu_img_sname}" style="width:270px;height:270px;border-radius:20px;">						
					</c:forEach>
					<%-- 
					<img src="/resources/gonggu_uploadImg/${best1.gonggu_img_sname}" style="width:270px;height:270px;border-radius:20px;">
					<img src="/resources/gonggu_uploadImg/${best2.gonggu_img_sname}" style="width:270px;height:270px;border-radius:20px;">
					<img src="/resources/gonggu_uploadImg/${best3.gonggu_img_sname}" style="width:270px;height:270px;border-radius:20px;">
					 --%>
				</div>
			</div>
		</div>
		<div id="content_div2">
			<c:forEach var="shopData" items="${shopLatestProducts}">
			  <div id="div2_3">
				<a href="/shoplayout?item_code=${shopData.shop_item_code }">
				<img src="/resources/item_img/${shopData.shop_item_mainimg_imgname }"></a>
			  </div>
			</c:forEach>
		</div>
		<%-- 
		<div id="content_div2">
				<a href="/itemsetDetail?codeNum=${requestScope.setList.get(0).getItem_code_num() }"><img src="/resources/itemset_img/${requestScope.setList.get(0).getItemset_code_mainimg() }"></a>
		
			<div id="div2_1">
				<a href="/itemsetDetail?codeNum=${requestScope.setList.get(0).getItem_code_num() }"><img src="/resources/itemset_img/${requestScope.setList.get(0).getItemset_code_mainimg() }"></a>
			</div>
			<div id="div2_2">
				<a href="/itemsetDetail?codeNum=${requestScope.setList.get(1).getItem_code_num() }"><img src="/resources/itemset_img/${requestScope.setList.get(1).getItemset_code_mainimg() }"></a>
			</div>
			<div id="div2_3">
				<a href="/itemsetDetail?codeNum=${requestScope.setList.get(2).getItem_code_num() }"><img src="/resources/itemset_img/${requestScope.setList.get(2).getItemset_code_mainimg() }"></a>
			</div>
		</div>
		<div id="content_div3">
			<div id="div3_1">
				<a href="/shoplayout?item_code=${requestScope.nList.get(0).getCode() }"><img src="/resources/item_img/${requestScope.nList.get(0).getMainimg()}"></a>
			</div>
			<div id="div3_2">
				<a href="/shoplayout?item_code=${requestScope.nList.get(1).getCode() }"><img src="/resources/item_img/${requestScope.nList.get(1).getMainimg()}"></a>
			</div>
			<div id="div3_3">
				<a href="/shoplayout?item_code=${requestScope.nList.get(2).getCode() }"><img src="/resources/item_img/${requestScope.nList.get(2).getMainimg()}"></a>
			</div>
			<div id="div3_4">
				<a href="/shoplayout?item_code=${requestScope.nList.get(3).getCode() }"><img src="/resources/item_img/${requestScope.nList.get(3).getMainimg()}"></a>
			</div>
		</div>
		<div id="content_div4">
			<div id="div4_1">
				<a href="/shoplayout?item_code=${requestScope.dList.get(0).getCode() }"><img src="/resources/item_img/${requestScope.dList.get(0).getMainimg()}"></a>
			</div>
			<div id="div4_2">
				<a href="/shoplayout?item_code=${requestScope.dList.get(1).getCode() }"><img src="/resources/item_img/${requestScope.dList.get(1).getMainimg()}"></a>
			</div>
			<div id="div4_3">
				<a href="/shoplayout?item_code=${requestScope.dList.get(2).getCode() }"><img src="/resources/item_img/${requestScope.dList.get(2).getMainimg()}"></a>
			</div>
		</div>
		 --%>
	</div>
</div>
