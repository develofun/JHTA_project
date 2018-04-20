<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/ljh.css">
<script type="text/javascript">
	function fboard_category_change(category){
		switch(category.value){
			case "명소":
				var categorya=document.getElementById("fboard_create_category_info1");
				categorya.style.display="block";
				category_clear(category);
				break;
			case "맛집":
				var categoryb=document.getElementById("fboard_create_category_info2");
				categoryb.style.display="block";
				category_clear(category);
				break;
			case "축제":
				var categoryc=document.getElementById("fboard_create_category_info3");
				categoryc.style.display="block";
				category_clear(category);
				break;
			case "쇼핑":
				var categoryd=document.getElementById("fboard_create_category_info4");
				categoryd.style.display="block";
				category_clear(category);
				break;
			case "카테고리":
				category_clear(category);
		}
	}
	function category_clear(category){
		var category1=document.getElementById("fboard_create_category_info1");
		var category2=document.getElementById("fboard_create_category_info2");
		var category3=document.getElementById("fboard_create_category_info3");
		var category4=document.getElementById("fboard_create_category_info4");
		switch(category.value){
			case "명소":
				category2.style.display="none";
				category3.style.display="none";
				category4.style.display="none";
				break;
			case "맛집":
				category1.style.display="none";
				category3.style.display="none";
				category4.style.display="none";
				break;
			case "축제":
				category1.style.display="none";
				category2.style.display="none";
				category4.style.display="none";
				break;
			case "쇼핑":
				category1.style.display="none";
				category2.style.display="none";
				category3.style.display="none";
				break;
			case "카테고리":
				category1.style.display="none";
				category2.style.display="none";
				category3.style.display="none";
				category4.style.display="none";
				break;
		}
	}
	function select_area(area){
		switch(area.value){
		case "동남아":
			var cities=document.getElementById("fboard_create_city1");
			cities.style.display="block";
			area_clear(area);
			break;
		case "중국":
			var cities=document.getElementById("fboard_create_city2");
			cities.style.display="block";
			area_clear(area);
			break;
		case "일본":
			var cities=document.getElementById("fboard_create_city3");
			cities.style.display="block";
			area_clear(area);
			break;
		case "유럽":
			var cities=document.getElementById("fboard_create_city4");
			cities.style.display="block";
			area_clear(area);
			break;
		case "미주_중남미":
			var cities=document.getElementById("fboard_create_city5");
			cities.style.display="block";
			area_clear(area);
			break;
		case "지역":
			area_clear(area);
			break;
		}	
	}
	function area_clear(area){
		var cities1=document.getElementById("fboard_create_city1");
		var cities2=document.getElementById("fboard_create_city2");
		var cities3=document.getElementById("fboard_create_city3");
		var cities4=document.getElementById("fboard_create_city4");
		var cities5=document.getElementById("fboard_create_city5");
		switch(area.value){
		case "동남아":
			cities2.style.display="none";
			cities3.style.display="none";
			cities4.style.display="none";
			cities5.style.display="none";
			break;
		case "중국":
			cities1.style.display="none";
			cities3.style.display="none";
			cities4.style.display="none";
			cities5.style.display="none";
			break;
		case "일본":
			cities1.style.display="none";
			cities2.style.display="none";
			cities4.style.display="none";
			cities5.style.display="none";
			break;
		case "유럽":
			cities1.style.display="none";
			cities2.style.display="none";
			cities3.style.display="none";
			cities5.style.display="none";
			break;
		case "미주_중남미":
			cities1.style.display="none";
			cities2.style.display="none";
			cities3.style.display="none";
			cities4.style.display="none";
			break;
		case "지역":
			cities1.style.display="none";
			cities2.style.display="none";
			cities3.style.display="none";
			cities4.style.display="none";
			cities5.style.display="none";
			break;
		}	
	}
</script>
<div>
	<div id="fboard_area">
	<ul>
	<li><a href="/move.do?cmd=fboard">전체</a></li>
	<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아">동남아</a>
		<div id="fboard_city_list">
		<ul>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=싱가포르">싱가포르</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=방콕">방콕</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=푸켓">푸켓</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=세부">세부</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=기타">기타</a></li>
		</ul>
		</div>
	</li>
	<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국">중국</a>
		<div id="fboard_city_list">
		<ul>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=마카오">마카오</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=홍콩">홍콩</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=상해">상해</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=북경">북경</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=기타">기타</a></li>
		</ul>
		</div>
	</li>
	<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본">일본</a>
		<div id="fboard_city_list">
		<ul>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=도쿄">도쿄</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=오사카">오사카</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=후쿠오카">후쿠오카</a></li>
		</ul>
		</div>
	</li>
	<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽">유럽</a>
		<div id="fboard_city_list">
		<ul>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=로마">로마</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=파리">파리</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=런던">런던</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=이스탄불">이스탄불</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=기타">기타</a></li>
		</ul>
		</div>
	</li>
	<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미">미주/중남미</a>
		<div id="fboard_city_list">
		<ul>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=뉴욕">뉴욕</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=하와이">하와이</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=미서부">미서부</a></li>
		</ul>
		</div>
	</li>
	</ul>
	</div>
	<div id="fboard_cteate_update_title"><h2>글쓰기</h2></div>
	<form action="fboard.do?cmd=fboard_create" method="post" enctype="multipart/form-data">
	<div id="fboard_create_form">
		<div id="fboard_create_title">
		<p>제목</p><input type="text" name="fboard_title">
		</div>
		<div id="fboard_create_sub_title">
		<p>부제목</p><input type="text" name="fboard_sub_title">
		</div>
		<div id="fboard_create_category">
		카테고리
		<select name="fboard_category" onchange="javascript:fboard_category_change(this)">
			<option value="카테고리">카테고리</option>
			<option value="명소">명소</option>
			<option value="맛집">맛집</option>
			<option value="축제">축제</option>
			<option value="쇼핑">쇼핑</option>
		</select>
		</div>
		<div id="fboard_create_category_info">
		<div id="fboard_create_category_info1">
		<p>명소 추가정보</p>
		<table>
			<tr>
			<td class="fboard_category_title">영업시간</td>
			<td><input type="text" name="fboard_attraction_time" class="fboard_categories"></td>
			</tr>
			<tr>
			<td class="fboard_category_title">입장료</td>
			<td><input type="text" name="fboard_attraction_price" class="fboard_categories"></td>
			</tr>
			<tr>
			<td class="fboard_category_title">홈페이지</td>
			<td><input type="text" name="fboard_attraction_home_page" class="fboard_categories"></td>
			</tr>
			<tr>
			<td class="fboard_category_title">찾아가는길</td>
			<td><input type="text" name="fboard_attraction_go" class="fboard_categories"></td>
			</tr>
		</table>
		</div>
		<div id="fboard_create_category_info2">
		<p>맛집 추가정보</p>
		<table>
			<tr>
			<td class="fboard_category_title">영업시간</td>
			<td><input type="text" name="fboard_restaurant_time" class="fboard_categories"></td>
			</tr>
			<tr>
			<td class="fboard_category_title">가격</td>
			<td><input type="text" name="fboard_restaurant_price" class="fboard_categories"></td>
			</tr>
			<tr>
			<td class="fboard_category_title">홈페이지</td>
			<td><input type="text" name="fboard_restaurant_home_page" class="fboard_categories"></td>
			</tr>
			<tr>
			<td class="fboard_category_title">찾아가는길</td>
			<td><input type="text" name="fboard_restaurant_go" class="fboard_categories"></td>
			</tr>
		</table>
		</div>
		<div id="fboard_create_category_info3">
		<p>축제 추가정보</p>
		<table>
			<tr>
			<td class="fboard_category_title">축제기간</td>
			<td>
			<input type="date" name="fboard_festival_startDate" value="${eventSale_startDate }"> ~
			<input type="date" name="fboard_festival_endDate" value="${eventSale_endDate }">
			</td>
			</tr>
		</table>
		</div>
		<div id="fboard_create_category_info4">
		<p>쇼핑 추가정보</p>
		<table>
			<tr>
			<td class="fboard_category_title">영업시간</td>
			<td><input type="text" name="fboard_shopping_time" class="fboard_categories"></td>
			</tr>
			<tr>
			<tr>
			<td class="fboard_category_title">홈페이지</td>
			<td><input type="text" name="fboard_shopping_home_page" class="fboard_categories"></td>
			</tr>
			<tr>
			<td class="fboard_category_title">찾아가는길</td>
			<td><input type="text" name="fboard_shopping_go" class="fboard_categories"></td>
			</tr>
		</table>
		</div>
		</div>
		<div id="fboard_create_area_city">
		<p>지역</p>
		<select id="fboard_create_area" onchange="select_area(this)" name="fboard_area">
			<option value="지역">지역</option>
			<option value="동남아">동남아</option>
			<option value="중국">중국</option>
			<option value="일본">일본</option>
			<option value="유럽">유럽</option>
			<option value="미주_중남미">미주/중남미</option>
		</select>
		<div id="fboard_create_city1">
		<p>도시</p>
		<select name="fboard_city1">
			<option value="싱가포르">싱가포르</option>
			<option value="방콕">방콕</option>
			<option value="푸켓">푸켓</option>
			<option value="세부">세부</option>
			<option value="기타">기타</option>
		</select>
		</div>
		<div id="fboard_create_city2">
		<p>도시</p>
		<select name="fboard_city2">
			<option value="마카오">마카오</option>
			<option value="홍콩">홍콩</option>
			<option value="상해">상해</option>
			<option value="북경">북경</option>
			<option value="기타">기타</option>
		</select>
		</div>
		<div id="fboard_create_city3">
		<p>도시</p>
		<select name="fboard_city3">
			<option value="도쿄">도쿄</option>
			<option value="오사카">오사카</option>
			<option value="후쿠오카">후쿠오카</option>
		</select>
		</div>
		<div id="fboard_create_city4">
		<p>도시</p>
		<select name="fboard_city4">
			<option value="로마">로마</option>
			<option value="파리">파리</option>
			<option value="런던">런던</option>
			<option value="이스탄불">이스탄불</option>
			<option value="기타">기타</option>
		</select>
		</div>
		<div id="fboard_create_city5">
		<p>도시</p>
		<select name="fboard_city5">
			<option value="뉴욕">뉴욕</option>
			<option value="하와이">하와이</option>
			<option value="미서부">미서부</option>
		</select>
		</div>
		</div>
		<div id="fboard_create_contents">
		<p>내용</p>
		<textarea rows="10" cols="100" name="fboard_contents"></textarea>
		</div>
		<div id="fboard_create_image">
		이미지 <input type="file" name="fboard_image" id="fboard_image">
		</div>
		<div id="fboard_create_button">
			<input type="submit" value="글등록">
			<input type="reset" value="취소">
		</div>
	</div>
	</form>
</div>