<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/resources/css/navbar_techandall.css">
<!-- Navigation CSS -->
<link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<style type="text/css">
	#main {width:1000px;height:1180px;margin-left:350px;margin-top:110px;}
	#main #submenu {width: 1000px;height: 60px;border: 1px solid gray;margin-top:100px;}
	#main #category {width:215px;height:400px;float:left;position:relative;left:10px;margin-top:30px;}
	#main #category img {width:100%;}
	#main #category #small_category ul li {list-style:none;margin-left:20px;display:none;}
	#main #category #small_category ul li a{color:black;text-decoration:none;font-size:12px;}

	#divtest1 {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}
	#divtest1 img {width:130px;height:170px;}
	#divtest2 {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}
	#divtest2 img {width:130px;height:170px;}
	#divtest3 {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}
	#divtest3 img {width:130px;height:170px;}
	#divtest4 {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}
	#divtest4 img {width:130px;height:170px;}
	#divtest5 {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}
	#divtest5 img {width:130px;height:170px;}
	#divtest6 {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}
	#divtest6 img {width:130px;height:170px;}
	#divtest7 {width:130px;height:170px;border:1px solid white;float:right;margin:20px;}
	#divtest7 img {width:130px;height:170px;}
	
	#content_category {width:1000px;height:1000px;}
	#category1 {width:745px;height:750px;float:right;position:relative;right:10px;margin-top:10px;padding:5px;}
	
	#category1_div1_1 {width:715px;height:1000px;border: 1px solid gray;margin:5px;padding:10px;}
	#category1_div1_1 .bestItems {width:100%;height:180px;border: 1px solid gray;margin:7px;padding:10px;font-size:20px;}
	#category1_div1_1 .bestItems img {width:170px;height:170px;position:relative;left:5px;}
	#paging{width:350px;height:25px;border:1px solid black;margin-top:450px;float:left;position:relative;left:190px;padding:5px;}
	#paging a{margin:5px;text-decoration:none;}
</style>
<script>
	$(function(){
		$(".cate_division").mouseover(function(){
			$(".cate_division").next().find("li").css("display","none");
			$(this).next().find("li").each(function(){
				$(this).css("display","list-item");
			});
		});
	});
</script>
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
					<li class="dropdown"><a href="category?code=1">홈데코</a>
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
								<img src="/resources/img/01.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="category?code=2">가전/디지털</a>
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
							<div id="divtest2">
								<img src="/resources/img/02.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="category?code=3">여성</a>
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
								<img src="/resources/img/03.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="category?code=4">남성</a>
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
								<img src="/resources/img/04.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="category?code=5">레저/스포츠</a>
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
								<img src="/resources/img/01.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="category?code=6">취미/애견/반려용품</a>
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
							<div id="divtest6">
								<img src="/resources/img/02.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="category?code=7">식료품</a>
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
							<div id="divtest7">
								<img src="/resources/img/03.jpg">
							</div>
						</div>
					</li>
					<li class="search">
						<form action="category">
							<input type="hidden" name="code" value="${categoryCode }">
							<input type="text" name="search"><i class="icon-search icon-large"></i>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div id="category">
			<div id="small_category">
				<c:forEach var="cList" items="${requestScope.cList }" varStatus="i">
					<a class="cate_division" href="category?code=${cList.division_num}">${cList.division_name }</a>
					<ul>
						<c:forEach var="sList" items="${cList.list}">
							<li><a href="category?code=${sList.section_num }">>${sList.section_name }</a></li>
						</c:forEach>
					</ul>
				</c:forEach>
			</div>
		</div>

	<div id="content_category">
		<div  id="category1">
			<div id="category1_div1_1" class="form-inline">
				<c:forEach var="bList" items="${iList }">
					<div class="bestItems" style="display:inline-block">
						<a href="shoplayout?item_code=${bList.code }">
						<img src="/resources/item_img/${bList.mainimg }">
					<div class="category1_div1_1_1" style="display:inline-block;margin-left:50px;">
						${bList.name }
					</div>
					<div class="category1_div1_1_2" style="display:inline-block;margin-left:20px;">
						${ bList.saleprice}원
					</div>
						</a>
					</div>			
				</c:forEach>
			</div>
			<div id="paging">
			<c:if test="${requestScope.pu.startPageNum!=1 }">
				<a href="mainSearch?method=${requestScope.map.method }&search=${requestScope.map.search}&pageNum=${requestScope.pu.startPageNum-1}">이전</a>
			</c:if>
			<c:forEach var="paging" begin="${requestScope.pu.startPageNum }"
				end="${requestScope.pu.endPageNum }">
				<a href="mainSearch?method=${requestScope.map.method }&search=${requestScope.map.search}&pageNum=${paging }">[${paging }]</a>
			</c:forEach>
			<c:if test="${requestScope.pu.endPageNum!=requestScope.pu.totalPageCount }">
				<a href="mainSearch?method=${requestScope.map.method }&search=${requestScope.map.search}&pageNum=${requestScope.pu.endPageNum+1}">다음
				</a>
			</c:if>
		</div>
		</div>
	</div>
</div>
</body>