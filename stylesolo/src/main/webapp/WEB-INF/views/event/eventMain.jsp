<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/event.css" type="text/css">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script src="/resources/js/jssor.slider-22.2.16.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		/*버튼이벤트*/
		//진행중
		$("#event_ing").click(function(){location.href="event_main?event_sort=진행중";});
		//종료
		$("#event_end").click(function(){location.href="event_main?event_sort=종료";});
		//예정
		$("#event_plan").click(function(){location.href="event_main?event_sort=예정";});
		/*이벤트 배너*/
		var jssor_1_SlideoTransitions = [
		                                 [{b:0,d:600,y:-290,e:{y:27}}],
		                                 [{b:0,d:1000,y:185},{b:1000,d:500,o:-1},{b:1500,d:500,o:1},{b:2000,d:1500,r:360},{b:3500,d:1000,rX:30},{b:4500,d:500,rX:-30},{b:5000,d:1000,rY:30},{b:6000,d:500,rY:-30},{b:6500,d:500,sX:1},{b:7000,d:500,sX:-1},{b:7500,d:500,sY:1},{b:8000,d:500,sY:-1},{b:8500,d:500,kX:30},{b:9000,d:500,kX:-30},{b:9500,d:500,kY:30},{b:10000,d:500,kY:-30},{b:10500,d:500,c:{x:87.50,t:-87.50}},{b:11000,d:500,c:{x:-87.50,t:87.50}}],
		                                 [{b:0,d:600,x:410,e:{x:27}}],
		                                 [{b:-1,d:1,o:-1},{b:0,d:600,o:1,e:{o:5}}],
		                                 [{b:-1,d:1,c:{x:175.0,t:-175.0}},{b:0,d:800,c:{x:-175.0,t:175.0},e:{c:{x:7,t:7}}}],
		                                 [{b:-1,d:1,o:-1},{b:0,d:600,x:-570,o:1,e:{x:6}}],
		                                 [{b:-1,d:1,o:-1,r:-180},{b:0,d:800,o:1,r:180,e:{r:7}}],
		                                 [{b:0,d:1000,y:80,e:{y:24}},{b:1000,d:1100,x:570,y:170,o:-1,r:30,sX:9,sY:9,e:{x:2,y:6,r:1,sX:5,sY:5}}],
		                                 [{b:2000,d:600,rY:30}],
		                                 [{b:0,d:500,x:-105},{b:500,d:500,x:230},{b:1000,d:500,y:-120},{b:1500,d:500,x:-70,y:120},{b:2600,d:500,y:-80},{b:3100,d:900,y:160,e:{y:24}}],
		                                 [{b:0,d:1000,o:-0.4,rX:2,rY:1},{b:1000,d:1000,rY:1},{b:2000,d:1000,rX:-1},{b:3000,d:1000,rY:-1},{b:4000,d:1000,o:0.4,rX:-1,rY:-1}]
		                               ];

		                               var jssor_1_options = {
		                                 $AutoPlay: true,
		                                 $Idle: 2000,
		                                 $CaptionSliderOptions: {
		                                   $Class: $JssorCaptionSlideo$,
		                                   $Transitions: jssor_1_SlideoTransitions,
		                                   $Breaks: [
		                                     [{d:2000,b:1000}]
		                                   ]
		                                 },
		                                 $ArrowNavigatorOptions: {
		                                   $Class: $JssorArrowNavigator$
		                                 },
		                                 $BulletNavigatorOptions: {
		                                   $Class: $JssorBulletNavigator$
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
		                                   }
		                                   else {
		                                       window.setTimeout(ScaleSlider, 30);
		                                   }
		                               }
		                               ScaleSlider();
		                               $(window).bind("load", ScaleSlider);
		                               $(window).bind("resize", ScaleSlider);
		                               $(window).bind("orientationchange", ScaleSlider);
		                               /*responsive code end*/

	});
</script>
<style>
		/*이벤트 배너 css*/
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
            filter: alpha(opacity=70);
            opacity: .7;
            overflow: hidden;
            cursor: pointer;
            border: #000 1px solid;
        }
        .jssorb01 div { background-color: gray; }
        .jssorb01 div:hover, .jssorb01 .av:hover { background-color: #d3d3d3; }
        .jssorb01 .av { background-color: #fff; }
        .jssorb01 .dn, .jssorb01 .dn:hover { background-color: #555555; }

        /* jssor slider arrow navigator skin 02 css */
        /*
        .jssora02l                  (normal)
        .jssora02r                  (normal)
        .jssora02l:hover            (normal mouseover)
        .jssora02r:hover            (normal mouseover)
        .jssora02l.jssora02ldn      (mousedown)
        .jssora02r.jssora02rdn      (mousedown)
        .jssora02l.jssora02lds      (disabled)
        .jssora02r.jssora02rds      (disabled)
        */
        .jssora02l, .jssora02r {
            display: block;
            position: absolute;
            /* size of arrow element */
            width: 55px;
            height: 55px;
            cursor: pointer;
            background: url('/resources/event_image/a02.png') no-repeat;
            overflow: hidden;
        }
        .jssora02l { background-position: -3px -33px; }
        .jssora02r { background-position: -63px -33px; }
        .jssora02l:hover { background-position: -123px -33px; }
        .jssora02r:hover { background-position: -183px -33px; }
        .jssora02l.jssora02ldn { background-position: -3px -33px; }
        .jssora02r.jssora02rdn { background-position: -63px -33px; }
        .jssora02l.jssora02lds { background-position: -3px -33px; opacity: .3; pointer-events: none; }
        .jssora02r.jssora02rds { background-position: -63px -33px; opacity: .3; pointer-events: none; }
		

</style>
	<div id="event_wrap_main">
		<h1 class="page-header">이벤트 페이지</h1>
		<div id="event_content">
			<div id="event_banner">
				<div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:600px;height:207px;overflow:hidden;visibility:hidden;">
			        <!-- Loading Screen -->
			        <div data-u="loading" style="position:absolute;top:0px;left:0px;background-color:rgba(0,0,0,0.7);">
			            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
			            <div style="position:absolute;display:block;background:url('/resources/event_image/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
			        </div>
			        <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:600px;height:207px;overflow:hidden;">
			            <c:forEach var="vo" items="${banner_list }">
			            	<div>
			                	<a href="event_detail?get_event_num=${vo.event_num }" ><img data-u="image" src="${event_path }${vo.event_image_name}" style="heigth:"></a>
			                	<span>${vo.event_num }</span>
			            	</div>
			            </c:forEach>
			        </div>
			        <!-- Bullet Navigator -->
			        <div data-u="navigator" class="jssorb01" style="bottom:16px;right:16px;">
			            <div data-u="prototype" style="width:12px;height:12px;"></div>
			        </div>
			        <!-- Arrow Navigator -->
			        <span data-u="arrowleft" class="jssora02l" style="top:0px;left:8px;width:55px;height:55px;" data-autocenter="2"></span>
			        <span data-u="arrowright" class="jssora02r" style="top:0px;right:8px;width:55px;height:55px;" data-autocenter="2"></span>
			    </div>
    		<!-- #endregion Jssor Slider End -->
			</div>
			<div id="event_headevent_one">
				<a href="event_detail?get_event_num=${head_num1 }"><img id="event_head_image" src="${event_path }${headevent1 }" /></a>
			</div>
			<div id="event_headevent_two">
				<a href="event_detail?get_event_num=${head_num2 }"><img id="event_head_image" src="${event_path }${headevent2}" /></a>
			</div>
			<div id="event_menu">
				<div id="event_buttons">
					<input type="button" class="btn btn-default" value="진행중" id="event_ing">
					<input type="button" class="btn btn-default" value="진행종료" id="event_end">
					<input type="button" class="btn btn-default" value="진행예정" id="event_plan">
				</div>
				<div id="event_menus">
					<div id="event_menus_list">
						<c:forEach var="vo" items="${content_list }">
							<div class="event_menu_div">
							<a href="event_detail?get_event_num=${vo.event_num }"><img id="event_menu_image" src="${event_path }${vo.event_image_name }" /></a>
							</div>
            			</c:forEach>
					</div>
					<div id="event_paging">
						<a href="event_main?pagePre5=${pageNum }&event_sort=${event_sort }"><span style="color: #333;">[<<]</span></a>
						<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
							<c:choose>
								<c:when test="${i==0}"></c:when>
								<c:when test="${i==pu.pageNum}">
									<a href="event_main?pageNum=${i }&event_sort=${event_sort }"><span style="color: red;">[${i }]</span></a>
								</c:when>
								<c:otherwise>
									<a href="event_main?pageNum=${i }&event_sort=${event_sort }"><span style="color: #333;">[${i }]</span></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<a href="event_main?pageNext5=${pageNum }&event_sort=${event_sort }"><span style="color: #333;">[>>]</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>