<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/resources/css/navbar_techandall.css">
<!-- Navigation CSS -->
<link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet"	type="text/css">

<script src="/resources/js/jssor.slider-22.2.16.min.js" type="text/javascript"></script>
<style type="text/css">
	#main {width:1000px;height:1850px;border: 1px solid gray;margin:auto;}
	#main #submenu {width: 1000px;height: 60px;margin-top:-5px;}
	
	#divtest1 {width:330px;height:170px;float:right;margin:20px;}
	#divtest1 img {width:330px;height:170px;}
	#divtest3 {width:230px;height:170px;float:right;margin:20px;}
	#divtest3 img {width:230px;height:170px;}
	#divtest4 {width:230px;height:170px;float:right;margin:20px;}
	#divtest4 img {width:230px;height:170px;}
	#divtest5 {width:330px;height:170px;float:right;margin:20px;}
	#divtest5 img {width:330px;height:170px;}
	
	#main #title {width: 1000px;height:85px;margin-top:10px;}
	#main #title #title_div {width: 950px;height:80px;margin-left:25px;}
	#main #title p{font-size:12px;margin-top:10px;}
	
	#main #jjim {width: 1000px;height:1530px;margin-top:10px;}
	#main #jjim #paging1 input {width:150px;height:30px;float:right;}
	#main #jjim_table {width: 1000px;height:730px;padding:10px;}
	#main #jjim_table img {width:180px;height:180px;margin:15px;}
	#main #jjim_table .jjim_div {width: 230px;height:290px;float:left;text-align:center;margin-left:10px;margin-top:45px;border-radius:20px;}
	#main #jjim_table .jjim_div a {text-decoration:none;color:black;font-size:15px;}
	#main #jjim_table .jjim_div input {position:relative;float:left;left:10px;top:10px;}
	#main #jjim_table .jjim_div .jjim_div_1 {text-align:center;}
	#main #jjim_table .jjim_div .jjim_div_2 {width:230px;height:24px;text-align:center;overflow:hidden;}
	#main #jjim_table .jjim_div .jjim_div_3 {text-align:center;margin-top:0px;}
	#main #jjim #paging1 {width:200px;height:40px;left:390px;text-align:center;position:relative;margin-top:3px;padding:10px;}
	#main #jjim #paging2 {width:200px;height:40px;left:390px;text-align:center;position:relative;margin-top:5px;padding:10px;}
	#main #set_jjim_table {width: 1000px;height:750px;margin-top:10px;padding:10px;}
	#main #set_jjim_table img {width:180px;height:180px;margin:15px;}
	#main #set_jjim_table .set_jjim_div {width: 230px;height:290px;float:left;text-align:center;margin-left:10px;margin-top:45px;border-radius:20px;}
	#main #set_jjim_table .set_jjim_div a {text-decoration:none;color:black;font-size:15px;}
	#main #set_jjim_table .set_jjim_div input {position:relative;float:left;left:10px;top:10px;}
	#main #set_jjim_table .set_jjim_div .set_jjim_div_1 {text-align:center;}
	#main #set_jjim_table .set_jjim_div .set_jjim_div_2 {width:230px;height:24px;text-align:center;overflow:hidden;}
	#main #set_jjim_table .set_jjim_div .set_jjim_div_3 {text-align:center;margin-top:0px;}
	
	#main #recommend_title {width: 1000px;height:60px;margin-top:50px;}
	#main #recommend_title #recommend_title_div {width: 100px;height:55px;margin-left:25px;}
	
	#main #recommend {width: 1000px;height:490px;margin-top:10px;}
	#main #recommend_table {width: 1000px;height:460px;padding:10px;}
	#main #recommend_table img {width:100px;height:100px;margin:10px;}
	#main #recommend_table #recommend_content_div {position:relative;float:right;margin-right:75px;padding:15px;}
	
	#paging1 a {text-decoration:none;}
	#paging2 a {text-decoration:none;}
</style>
<script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		jjim_paging(1);
		itemset_paging(1);
		
		$("#jjim_del").on("click",function(){
			var j_c=[];
			$("input[name='jjim_chk']:checked").each(function(){
				j_c.push($(this).val());
			});
			$.ajax({
				url:'jjim_del',
				data:'shop_item_code='+j_c,
				dataType:'text',
				success:function(data){
					if(data=='success'){
						jjim_paging(1);
					}else if(data=="fail"){
						alert("삭제 실패!");
					}
				}
			});
		});
		
		$("#itemset_del").on("click",function(){
			var j_c=[];
			$("input[name='itemset_jjim_chk']:checked").each(function(){
				j_c.push($(this).val());
			});
			$.ajax({
				url:'itemset_jjim_del',
				data:'item_code_num='+j_c,
				dataType:'text',
				success:function(data){
					if(data=='success'){
						itemset_paging(1);
					}else if(data=="fail"){
						alert("삭제 실패!");
					}
				}
			});
		});
	});

	
		function jjim_paging(pageNum){
			$("#jjim_table").empty();
			$.ajax({
				url:'jjim_list',
				data:'pageNum='+pageNum,
				dataType:'json',
				success:function(result){
					var data=result.list;
					for(var i=0;i<data.length;i++){
						var shop_jjim_num=data[i].shop_jjim_num;
						var member_privacy_id=data[i].member_privacy_id;
						var shop_item_code=data[i].shop_item_code;
						var shop_item_name=data[i].shop_item_name;
						var shop_item_saleprice=data[i].shop_item_saleprice;
						var shop_item_mainimg_imgname=data[i].shop_item_mainimg_imgname;
						
						var html="<div class='jjim_div'>" + 
						"<a href='shoplayout?item_code=" + shop_item_code + "'>" + 
							"<input type='checkbox' name='jjim_chk' value='" + shop_item_code + "' style='width:20px;height:20px;'>" + 
								"<div class='jjim_div_1'>" + 
									"<img src='/resources/item_img/" + shop_item_mainimg_imgname + "'>" + 
								"</div>" + 
								"<div class='jjim_div_2'>" + 
									shop_item_name +
								"</div>" + 
								"<div class='jjim_div_3'>" + 
									shop_item_saleprice + "원" + 
								"</div>" +
							"</a>" + 
						"</div>";
			          $("#jjim_table").append(html);
					}
					
					var startPageNum=result.startPageNum;
					var endPageNum=result.endPageNum;
					var pp="";
					for(var i=startPageNum;i<=endPageNum;i++){
						var ss="<a href='javascript:jjim_paging(" + i + ")'>["+ i +"]</a> ";
						pp += ss;
					}
					$("#paging1").html(pp);
				}
			});
		}
		
		function itemset_paging(pageNum){
			$("#set_jjim_table").empty();
			$.ajax({
				url:'itemset_list',
				data:'pageNum='+pageNum,
				dataType:'json',
				success:function(result){
					var data=result.list;
					for(var i=0;i<data.length;i++){
						var item_code_num=data[i].item_code_num;
						var item_code_setname=data[i].item_code_setname;
						var itemset_code_price=data[i].itemset_code_price;
						var itemset_code_mainimg=data[i].itemset_code_mainimg;
						
						var html="<div class='set_jjim_div'>" + 
						"<a href='itemsetDetail?item_code_num=" + item_code_num + "'>" + 
							"<input type='checkbox' name='itemset_jjim_chk' value='" + item_code_num + "' style='width:20px;height:20px;'>" + 
								"<div class='set_jjim_div_1'>" + 
									"<img src='/resources/itemset_img/" + itemset_code_mainimg + "'>" + 
								"</div>" + 
								"<div class='set_jjim_div_2'>" + 
									item_code_setname +
								"</div>" + 
								"<div class='set_jjim_div_3'>" + 
									itemset_code_price + "원" + 
								"</div>" +
							"</a>" + 
						"</div>";
						
						$("#set_jjim_table").append(html);
					}
					
					var startPageNum=result.startPageNum;
					var endPageNum=result.endPageNum;
					var pp="";
					for(var i=startPageNum;i<=endPageNum;i++){
						var ss="<a href='javascript:itemset_paging(" + i + ")'>["+ i +"]</a> ";
						pp += ss;
					}
					$("#paging2").html(pp);
				}
			});
		}
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
								<img src="/resources/img/menubar1.jpg">
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
								<img src="/resources/img/menubar2.jpg">
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
								<img src="/resources/img/menubar3.jpg">
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
								<img src="/resources/img/menubar4.jpg">
							</div>
						</div>
					</li>
					<li class="dropdown"><a href="category?code=7">취미/애견/반려용품</a>
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
					<li class="dropdown"><a href="category?code=8">식료품</a>
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
						<form action="category">
							<input type="hidden" name="code" value="${categoryCode }">
							<input type="text" name="search"><i class="icon-search icon-large"></i>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div id="title">
		<div id="title_div">
			<h3>위시리스트</h3>
			<p>- 리스트에 담은 시점과 구매 시점에서 상품 가격 및 이벤트가 변경되거나 조기 품절 될 수 있습니다.</p>
		</div>
	<div id="jjim">
		<div id="jjim_table">
			
		</div>
		<div id="paging1"></div>
		<div style="text-align:center;">
			<input type="button" value="삭제하기" id="jjim_del">
		</div>
		<div id="set_jjim_table">
			
		</div>
		<div id="paging2"></div>
		<div style="text-align:center;">
			<input type="button" value="삭제하기" id="itemset_del">
		</div>
	</div>
</div>
</body>