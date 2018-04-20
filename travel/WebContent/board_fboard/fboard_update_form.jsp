<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function select_area(area) {
		switch (area.value) {
		case "동남아":
			var cities = document.getElementById("fboard_create_city1");
			cities.style.display = "block";
			area_clear(area);
			break;
		case "중국":
			var cities = document.getElementById("fboard_create_city2");
			cities.style.display = "block";
			area_clear(area);
			break;
		case "일본":
			var cities = document.getElementById("fboard_create_city3");
			cities.style.display = "block";
			area_clear(area);
			break;
		case "유럽":
			var cities = document.getElementById("fboard_create_city4");
			area_clear(area);
			cities.style.display = "block";
			break;
		case "미주_중남미":
			var cities = document.getElementById("fboard_create_city5");
			area_clear(area);
			cities.style.display = "block";
			break;
		case "지역":
			area_clear(area);
			break;
		}
	}
	function area_clear(area) {
		var cities1 = document.getElementById("fboard_create_city1");
		var cities2 = document.getElementById("fboard_create_city2");
		var cities3 = document.getElementById("fboard_create_city3");
		var cities4 = document.getElementById("fboard_create_city4");
		var cities5 = document.getElementById("fboard_create_city5");
		switch (area.value) {
		case "동남아":
			cities2.style.display = "none";
			cities3.style.display = "none";
			cities4.style.display = "none";
			cities5.style.display = "none";
			break;
		case "중국":
			cities1.style.display = "none";
			cities3.style.display = "none";
			cities4.style.display = "none";
			cities5.style.display = "none";
			break;
		case "일본":
			cities1.style.display = "none";
			cities2.style.display = "none";
			cities4.style.display = "none";
			cities5.style.display = "none";
			break;
		case "유럽":
			cities1.style.display = "none";
			cities2.style.display = "none";
			cities3.style.display = "none";
			cities5.style.display = "none";
			break;
		case "미주_중남미":
			cities1.style.display = "none";
			cities2.style.display = "none";
			cities3.style.display = "none";
			cities4.style.display = "none";
			break;
		case "지역":
			cities1.style.display = "none";
			cities2.style.display = "none";
			cities3.style.display = "none";
			cities4.style.display = "none";
			cities5.style.display = "none";
			break;
		}
	}
</script>
<div>
	<div id="detail_login"></div>
	<div id="fboard_area">
		<ul>
			<li><a href="/move.do?cmd=fboard">전체</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아">동남아</a>
				<div id="fboard_city_list">
					<ul>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=싱가포르">싱가포르</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=방콕">방콕</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=푸켓">푸켓</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=세부">세부</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=기타">기타</a></li>
					</ul>
				</div></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국">중국</a>
				<div id="fboard_city_list">
					<ul>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=마카오">마카오</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=홍콩">홍콩</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=상해">상해</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=북경">북경</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=기타">기타</a></li>
					</ul>
				</div></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본">일본</a>
				<div id="fboard_city_list">
					<ul>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=도쿄">도쿄</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=오사카">오사카</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=후쿠오카">후쿠오카</a></li>
					</ul>
				</div></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽">유럽</a>
				<div id="fboard_city_list">
					<ul>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=로마">로마</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=파리">파리</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=런던">런던</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=이스탄불">이스탄불</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=기타">기타</a></li>
					</ul>
				</div></li>
			<li><a
				href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미">미주/중남미</a>
				<div id="fboard_city_list">
					<ul>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=뉴욕">뉴욕</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=하와이">하와이</a></li>
						<li><a
							href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=미서부">미서부</a></li>
					</ul>
				</div></li>
		</ul>
	</div>
	<div id="fboard_cteate_update_title">
		<h2>글 수정</h2>
	</div>
	<form action="fboard.do?cmd=fboard_update" method="post"
		enctype="multipart/form-data">
		<div id="fboard_create_form">
			<div id="fboard_create_title">
				<p>제목</p>
				<c:choose>
					<c:when test="${fboard_category=='명소' }">
						<input type="text" name="fboard_title"
							value="${detail.fboard_attraction_title }">
					</c:when>
					<c:when test="${fboard_category=='맛집' }">
						<input type="text" name="fboard_title"
							value="${detail.fboard_restaurant_title }">
					</c:when>
					<c:when test="${fboard_category=='축제' }">
						<input type="text" name="fboard_title"
							value="${detail.fboard_festival_title }">
					</c:when>
					<c:when test="${fboard_category=='쇼핑' }">
						<input type="text" name="fboard_title"
							value="${detail.fboard_shopping_title }">
					</c:when>
				</c:choose>
			</div>
			<div id="fboard_create_sub_title">
				<p>부제목</p>
				<c:choose>
					<c:when test="${fboard_category=='명소' }">
						<input type="text" name="fboard_sub_title"
							value="${detail.fboard_attraction_sub_title }">
					</c:when>
					<c:when test="${fboard_category=='맛집' }">
						<input type="text" name="fboard_sub_title"
							value="${detail.fboard_restaurant_sub_title }">
					</c:when>
					<c:when test="${fboard_category=='축제' }">
						<input type="text" name="fboard_sub_title"
							value="${detail.fboard_festival_sub_title }">
					</c:when>
					<c:when test="${fboard_category=='쇼핑' }">
						<input type="text" name="fboard_sub_title"
							value="${detail.fboard_shopping_sub_title }">
					</c:when>
				</c:choose>
			</div>
			<div id="fboard_create_category">
				<input type="hidden" name="fboard_category"
					value="${fboard_category}">
				<p>${fboard_category}추가정보</p>
			</div>
			<div id="fboard_create_category_info">
				<c:choose>
					<c:when test="${fboard_category=='명소' }">
						<div id="fboard_create_category_info1" style="display: block">
							<table>
								<tr>
									<td class="fboard_category_title">영업시간</td>
									<td><input type="text" name="fboard_attraction_time"
										value="${detail.fboard_attraction_time }"
										class="fboard_categories"></td>
								</tr>
								<tr>
									<td class="fboard_category_title">입장료</td>
									<td><input type="text" name="fboard_attraction_price"
										value="${detail.fboard_attraction_price }"
										class="fboard_categories"></td>
								</tr>
								<tr>
									<td class="fboard_category_title">홈페이지</td>
									<td><input type="text" name="fboard_attraction_home_page"
										value="${detail.fboard_attraction_home_page }"
										class="fboard_categories"></td>
								</tr>
								<tr>
									<td class="fboard_category_title">찾아가는길</td>
									<td><input type="text" name="fboard_attraction_go"
										value="${detail.fboard_attraction_go }"
										class="fboard_categories"></td>
								</tr>
							</table>
						</div>
					</c:when>
					<c:when test="${fboard_category=='맛집' }">
						<div id="fboard_create_category_info2" style="display: block">
							<table>
								<tr>
									<td class="fboard_category_title">영업시간</td>
									<td><input type="text" name="fboard_restaurant_time"
										value="${detail.fboard_restaurant_time }"
										class="fboard_categories"></td>
								</tr>
								<tr>
									<td class="fboard_category_title">가격</td>
									<td><input type="text" name="fboard_restaurant_price"
										value="${detail.fboard_restaurant_price }"
										class="fboard_categories"></td>
								</tr>
								<tr>
									<td class="fboard_category_title">홈페이지</td>
									<td><input type="text" name="fboard_restaurant_home_page"
										value="${detail.fboard_restaurant_home_page }"
										class="fboard_categories"></td>
								</tr>
								<tr>
									<td class="fboard_category_title">찾아가는길</td>
									<td><input type="text" name="fboard_restaurant_go"
										value="${detail.fboard_restaurant_go }"
										class="fboard_categories"></td>
								</tr>
							</table>
						</div>
					</c:when>
					<c:when test="${fboard_category=='축제' }">
						<div id="fboard_create_category_info3" style="display: block">
							<table>
								<tr>
									<td class="fboard_category_title">축제기간</td>
									<td>이전 정보: ${detail.fboard_festival_period }
										<div>
											수정할 정보 : <input type="date" name="fboard_festival_startDate"
												value="${eventSale_startDate }"> ~ <input
												type="date" name="fboard_festival_endDate"
												value="${eventSale_endDate }">
										</div>
									</td>
								</tr>
							</table>
						</div>
					</c:when>
					<c:when test="${fboard_category=='쇼핑' }">
						<div id="fboard_create_category_info4" style="display: block">
							<table>
								<tr>
									<td class="fboard_category_title">영업시간</td>
									<td><input type="text" name="fboard_shopping_time"
										value="${detail.tb_fboard_shopping_time }"
										class="fboard_categories"></td>
								</tr>
								<tr>
								<tr>
									<td class="fboard_category_title">홈페이지</td>
									<td><input type="text" name="fboard_shopping_home_page"
										value="${detail.fboard_shopping_homepage }"
										class="fboard_categories"></td>
								</tr>
								<tr>
									<td class="fboard_category_title">찾아가는길</td>
									<td><input type="text" name="fboard_shopping_go"
										value="${detail.fboard_shopping_go }"
										class="fboard_categories"></td>
								</tr>
							</table>
						</div>
					</c:when>
				</c:choose>
			</div>
			<div id="fboard_create_area_city">
				<c:choose>
					<c:when test="${fboard_area=='동남아' }">
						<p>지역</p>
						<select id="fboard_create_area" onchange="select_area(this)"
							name="fboard_area">
							<option value="지역">지역</option>
							<option value="동남아" selected="selected">동남아</option>
							<option value="중국">중국</option>
							<option value="일본">일본</option>
							<option value="유럽">유럽</option>
							<option value="미주_중남미">미주/중남미</option>
						</select>
						<c:if test="${fboard_city=='싱가포르' }">
							<div id="fboard_create_city1" style="display: block;">
								<p>도시</p>
								<select name="fboard_city1">
									<option value="싱가포르" selected="selected">싱가포르</option>
									<option value="방콕">방콕</option>
									<option value="푸켓">푸켓</option>
									<option value="세부">세부</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='방콕' }">
							<div id="fboard_create_city1" style="display: block;">
								<p>도시</p>
								<select name="fboard_city1">
									<option value="싱가포르">싱가포르</option>
									<option value="방콕" selected="selected">방콕</option>
									<option value="푸켓">푸켓</option>
									<option value="세부">세부</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='푸켓' }">
							<div id="fboard_create_city1" style="display: block;">
								<p>도시</p>
								<select name="fboard_city1">
									<option value="싱가포르">싱가포르</option>
									<option value="방콕">방콕</option>
									<option value="푸켓" selected="selected">푸켓</option>
									<option value="세부">세부</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='세부' }">
							<div id="fboard_create_city1" style="display: block;">
								<p>도시</p>
								<select name="fboard_city1">
									<option value="싱가포르">싱가포르</option>
									<option value="방콕">방콕</option>
									<option value="푸켓">푸켓</option>
									<option value="세부" selected="selected">세부</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='기타' }">
							<div id="fboard_create_city1" style="display: block;">
								<p>도시</p>
								<select name="fboard_city1">
									<option value="싱가포르">싱가포르</option>
									<option value="방콕">방콕</option>
									<option value="푸켓">푸켓</option>
									<option value="세부">세부</option>
									<option value="기타" selected="selected">기타</option>
								</select>
							</div>
						</c:if>
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
					</c:when>
					<c:when test="${fboard_area=='중국' }">
						<p>지역</p>
						<select id="fboard_create_area" onchange="select_area(this)"
							name="fboard_area">
							<option value="지역">지역</option>
							<option value="동남아">동남아</option>
							<option value="중국" selected="selected">중국</option>
							<option value="일본">일본</option>
							<option value="유럽">유럽</option>
							<option value="미주_중남미">미주/중남미</option>
						</select>
						<c:if test="${fboard_city=='마카오' }">
							<div id="fboard_create_city2" style="display: block;">
								<p>도시</p>
								<select name="fboard_city2">
									<option value="마카오" selected="selected">마카오</option>
									<option value="홍콩">홍콩</option>
									<option value="상해">상해</option>
									<option value="북경">북경</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='홍콩' }">
							<div id="fboard_create_city2" style="display: block;">
								<p>도시</p>
								<select name="fboard_city2">
									<option value="마카오">마카오</option>
									<option value="홍콩" selected="selected">홍콩</option>
									<option value="상해">상해</option>
									<option value="북경">북경</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='상해' }">
							<div id="fboard_create_city2" style="display: block;">
								<p>도시</p>
								<select name="fboard_city2">
									<option value="마카오">마카오</option>
									<option value="홍콩">홍콩</option>
									<option value="상해" selected="selected">상해</option>
									<option value="북경">북경</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='북경' }">
							<div id="fboard_create_city2" style="display: block;">
								<p>도시</p>
								<select name="fboard_city2">
									<option value="마카오">마카오</option>
									<option value="홍콩">홍콩</option>
									<option value="상해">상해</option>
									<option value="북경" selected="selected">북경</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='기타' }">
							<div id="fboard_create_city2" style="display: block;">
								<p>도시</p>
								<select name="fboard_city2">
									<option value="마카오">마카오</option>
									<option value="홍콩">홍콩</option>
									<option value="상해">상해</option>
									<option value="북경">북경</option>
									<option value="기타" selected="selected">기타</option>
								</select>
							</div>
						</c:if>
						<div id="fboard_create_city1">
							<p>도시</p>
							<select name="fboard_city1">
								<option value="싱가포르">싱가포르</option>
								<option value="방콕" selected="selected">방콕</option>
								<option value="푸켓">푸켓</option>
								<option value="세부">세부</option>
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
					</c:when>
					<c:when test="${fboard_area=='일본' }">
						<p>지역</p>
						<select id="fboard_create_area" onchange="select_area(this)"
							name="fboard_area">
							<option value="지역">지역</option>
							<option value="동남아">동남아</option>
							<option value="중국">중국</option>
							<option value="일본" selected="selected">일본</option>
							<option value="유럽">유럽</option>
							<option value="미주_중남미">미주/중남미</option>
						</select>
						<c:if test="${fboard_city=='도쿄'}">
							<div id="fboard_create_city3" style="display: block;">
								<p>도시</p>
								<select name="fboard_city3">
									<option value="도쿄" selected="selected">도쿄</option>
									<option value="오사카">오사카</option>
									<option value="후쿠오카">후쿠오카</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='오사카'}">
							<div id="fboard_create_city3" style="display: block;">
								<p>도시</p>
								<select name="fboard_city3">
									<option value="도쿄">도쿄</option>
									<option value="오사카" selected="selected">오사카</option>
									<option value="후쿠오카">후쿠오카</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='후쿠오카'}">
							<div id="fboard_create_city3" style="display: block;">
								<p>도시</p>
								<select name="fboard_city3">
									<option value="도쿄">도쿄</option>
									<option value="오사카">오사카</option>
									<option value="후쿠오카" selected="selected">후쿠오카</option>
								</select>
							</div>
						</c:if>
						<div id="fboard_create_city1">
							<p>도시</p>
							<select name="fboard_city1">
								<option value="싱가포르">싱가포르</option>
								<option value="방콕" selected="selected">방콕</option>
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
					</c:when>
					<c:when test="${fboard_area=='유럽' }">
						<p>지역</p>
						<select id="fboard_create_area" onchange="select_area(this)"
							name="fboard_area">
							<option value="지역">지역</option>
							<option value="동남아">동남아</option>
							<option value="중국">중국</option>
							<option value="일본">일본</option>
							<option value="유럽" selected="selected">유럽</option>
							<option value="미주_중남미">미주/중남미</option>
						</select>
						<c:if test="${fboard_city=='로마'}">
							<div id="fboard_create_city4" style="display: block;">
								<p>도시</p>
								<select name="fboard_city4">
									<option value="로마" selected="selected">로마</option>
									<option value="파리">파리</option>
									<option value="런던">런던</option>
									<option value="이스탄불">이스탄불</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='파리'}">
							<div id="fboard_create_city4" style="display: block;">
								<p>도시</p>
								<select name="fboard_city4">
									<option value="로마">로마</option>
									<option value="파리" selected="selected">파리</option>
									<option value="런던">런던</option>
									<option value="이스탄불">이스탄불</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='런던'}">
							<div id="fboard_create_city4" style="display: block;">
								<p>도시</p>
								<select name="fboard_city4">
									<option value="로마">로마</option>
									<option value="파리">파리</option>
									<option value="런던" selected="selected">런던</option>
									<option value="이스탄불">이스탄불</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='이스탄불' }">
							<div id="fboard_create_city4" style="display: block;">
								<p>도시</p>
								<select name="fboard_city4">
									<option value="로마">로마</option>
									<option value="파리">파리</option>
									<option value="런던">런던</option>
									<option value="이스탄불" selected="selected">이스탄불</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='기타'}">
							<div id="fboard_create_city4" style="display: block;">
								<p>도시</p>
								<select name="fboard_city4">
									<option value="로마">로마</option>
									<option value="파리">파리</option>
									<option value="런던">런던</option>
									<option value="이스탄불">이스탄불</option>
									<option value="기타" selected="selected">기타</option>
								</select>
							</div>
						</c:if>
						<div id="fboard_create_city1">
							<p>도시</p>
							<select name="fboard_city1">
								<option value="싱가포르">싱가포르</option>
								<option value="방콕" selected="selected">방콕</option>
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
						<div id="fboard_create_city5">
							<p>도시</p>
							<select name="fboard_city5">
								<option value="뉴욕">뉴욕</option>
								<option value="하와이">하와이</option>
								<option value="미서부">미서부</option>
							</select>
						</div>
					</c:when>
					<c:when test="${fboard_area=='미주_중남미' }">
						<p>지역</p>
						<select id="fboard_create_area" onchange="select_area(this)"
							name="fboard_area">
							<option value="지역">지역</option>
							<option value="동남아">동남아</option>
							<option value="중국">중국</option>
							<option value="일본">일본</option>
							<option value="유럽">유럽</option>
							<option value="미주_중남미" selected="selected">미주/중남미</option>
						</select>
						<c:if test="${fboard_city=='뉴욕'}">
							<div id="fboard_create_city5" style="display: block;">
								<p>도시</p>
								<select name="fboard_city5">
									<option value="뉴욕" selected="selected">뉴욕</option>
									<option value="하와이">하와이</option>
									<option value="미서부">미서부</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='하와이'}">
							<div id="fboard_create_city5" style="display: block;">
								<p>도시</p>
								<select name="fboard_city5">
									<option value="뉴욕">뉴욕</option>
									<option value="하와이" selected="selected">하와이</option>
									<option value="미서부">미서부</option>
								</select>
							</div>
						</c:if>
						<c:if test="${fboard_city=='미서부'}">
							<div id="fboard_create_city5" style="display: block;">
								<p>도시</p>
								<select name="fboard_city5">
									<option value="뉴욕">뉴욕</option>
									<option value="하와이">하와이</option>
									<option value="미서부" selected="selected">미서부</option>
								</select>
							</div>
						</c:if>
						<div id="fboard_create_city1">
							<p>도시</p>
							<select name="fboard_city1">
								<option value="싱가포르">싱가포르</option>
								<option value="방콕" selected="selected">방콕</option>
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
					</c:when>
				</c:choose>
			</div>
			<div id="fboard_create_contents">
				<p>내용</p>
				<c:choose>
					<c:when test="${fboard_category=='명소' }">
						<textarea rows="10" cols="100" name="fboard_contents">${detail.fboard_attraction_content}</textarea>
					</c:when>
					<c:when test="${fboard_category=='맛집' }">
						<textarea rows="10" cols="100" name="fboard_contents">${detail.fboard_restaurant_content}</textarea>
					</c:when>
					<c:when test="${fboard_category=='축제' }">
						<textarea rows="10" cols="100" name="fboard_contents">${detail.fboard_festival_contents}</textarea>
					</c:when>
					<c:when test="${fboard_category=='쇼핑' }">
						<textarea rows="10" cols="100" name="fboard_contents">${detail.fboard_shopping_contents}</textarea>
					</c:when>
				</c:choose>
			</div>

			<div id="fboard_create_image">
				이미지 <input type="file" name="fboard_image" id="fboard_image">
			</div>


			<div id="fboard_create_button">
				<input type="text" value="${fboard_num }" name="fboard_num"
					style="display: none;"> <input type="text"
					value="${detail_num }" name="detail_num" style="display: none;">
				<input type="submit" value="글수정"> <input type="reset"
					value="취소">
			</div>
		</div>
	</form>
</div>