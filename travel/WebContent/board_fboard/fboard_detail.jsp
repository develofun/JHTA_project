<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/ljh.css">
<div id="fboard_detail">
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
			<li id="fboard_city_last"><a href="fboard.do?cmd=fboard_read_search&fboard_area=동남아&fboard_city=기타">기타</a></li>
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
			<li id="fboard_city_last"><a href="fboard.do?cmd=fboard_read_search&fboard_area=중국&fboard_city=기타">기타</a></li>
		</ul>
		</div>
	</li>
	<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본">일본</a>
		<div id="fboard_city_list">
		<ul>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=도쿄">도쿄</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=오사카">오사카</a></li>
			<li id="fboard_city_last"><a href="fboard.do?cmd=fboard_read_search&fboard_area=일본&fboard_city=후쿠오카">후쿠오카</a></li>
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
			<li id="fboard_city_last"><a href="fboard.do?cmd=fboard_read_search&fboard_area=유럽&fboard_city=기타">기타</a></li>
		</ul>
		</div>
	</li>
	<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미">미주/중남미</a>
		<div id="fboard_city_list">
		<ul>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=뉴욕">뉴욕</a></li>
			<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=하와이">하와이</a></li>
			<li id="fboard_city_last"><a href="fboard.do?cmd=fboard_read_search&fboard_area=미주_중남미&fboard_city=미서부">미서부</a></li>
		</ul>
		</div>
	</li>
	</ul>
	</div>
	<div id="fboard_main_city">
	<c:choose>
		<c:when test="${fboard_category!=null }">
				<c:if test="${fboard_area!=null }">
					${fboard_area}
				</c:if>
				<c:if test="${fboard_city!=null }">
					${fboard_city}
				</c:if>
			${fboard_category }
		</c:when>
		<c:when test="${fboard_city!=null }">
			<c:if test="${fboard_area!=null }">
					${fboard_area}
			</c:if>
			<c:if test="${fboard_city==''}">
				${fboard_area}
			</c:if>
			${fboard_city}
		</c:when>
		<c:when test="${fboard_area!=null }">
			${fboard_area}
		</c:when>
		<c:otherwise>
			전체
		</c:otherwise>
	</c:choose>
	</div>
	<div id="fboard_detail_titles">
		<div id="fboard_detail_title">
		<c:choose>
			<c:when test="${fboard_category=='명소' }">
				<h2>${detail.fboard_attraction_title }</h2>
			</c:when>
			<c:when test="${fboard_category=='맛집' }">
				<h2>${detail.fboard_restaurant_title }</h2>
			</c:when>
			<c:when test="${fboard_category=='축제' }">
				<h2>${detail.fboard_festival_title }</h2>
			</c:when>
			<c:when test="${fboard_category=='쇼핑' }">
				<h2>${detail.fboard_shopping_title }</h2>
			</c:when>
		</c:choose>
		</div>
		<div id="fboard_detail_sub_title">
			<c:choose>
				<c:when test="${fboard_category=='명소' }">
					<h4>${detail.fboard_attraction_sub_title }</h4>
				</c:when>
				<c:when test="${fboard_category=='맛집' }">
					<h4>${detail.fboard_restaurant_sub_title }</h4>
				</c:when>
				<c:when test="${fboard_category=='축제' }">
					<h4>${detail.fboard_festival_sub_title }</h4>
				</c:when>
				<c:when test="${fboard_category=='쇼핑' }">
					<h4>${detail.fboard_shopping_sub_title }</h4>
				</c:when>
			</c:choose>
		</div>
	</div>
	<div id="fboard_detail_image_info">
		<div id=fboard_detail_image>
			<c:choose>
				<c:when test="${fboard_category=='명소' }">
					<img src="/fimages/${images.fboard_attraction_image_name }">
				</c:when>
				<c:when test="${fboard_category=='맛집' }">
					<img src="/fimages/${images.fboard_restaurant_image}">
				</c:when>
				<c:when test="${fboard_category=='축제' }">
					<img src="/fimages/${images.fboard_festival_image_name }">
				</c:when>
				<c:when test="${fboard_category=='쇼핑' }">
					<img src="/fimages/${images.fboard_shopping_image_name }">
				</c:when>
			</c:choose>
		</div>
			<c:choose>
				<c:when test="${fboard_category=='명소' }">
				<table id="fboard_info_table">
					<tr>
					<td class="info_title"><p>영업시간</p></td>
					<td><p>${detail.fboard_attraction_time }</p></td>
					</tr>
					<tr>
					<td class="info_title"><p>입장료</p></td>
					<td><p>${detail.fboard_attraction_price }</p></td>
					</tr>
					<tr>
					<td class="info_title"><p>홈페이지</p></td>
					<td><p>${detail.fboard_attraction_home_page }</p></td>
					</tr>
					<tr>
					<td class="info_title"><p>찾아가는 길</p></td>
					<td><p>${detail.fboard_attraction_go }</p></td>
					</tr>
				</table>
				</c:when>
				<c:when test="${fboard_category=='맛집' }">
					<table id="fboard_info_table">
					<tr>
					<td class="info_title"><p>영업시간</p></td>
					<td><p>${detail.fboard_restaurant_time }</p></td>
					</tr>
					<tr>
					<td class="info_title"><p>입장료</p></td>
					<td><p>${detail.fboard_restaurant_price }</p></td>
					</tr>
					<tr>
					<td class="info_title"><p>홈페이지</p></td>
					<td><p>${detail.fboard_restaurant_home_page }</p></td>
					</tr>
					<tr>
					<td class="info_title"><p>찾아가는 길</p></td>
					<td><p>${detail.fboard_restaurant_go }</p></td>
					</tr>
				</table>
				</c:when>
				<c:when test="${fboard_category=='축제' }">
				<table id="fboard_info_table">
					<tr>
					<td class="info_title"><p>축제기간</p></td>
					<td><p>${detail.fboard_festival_period }</p></td>
					</tr>
				</table>
				</c:when>
				<c:when test="${fboard_category=='쇼핑' }">
					<table id="fboard_info_table">
					<tr>
					<td class="info_title"><p>영업시간</p></td>
					<td>${detail.tb_fboard_shopping_time }</td>
					</tr>
					<tr>
					<td class="info_title"><p>홈페이지</p></td>
					<td>${detail.fboard_shopping_homepage }</td>
					</tr>
					<tr>
					<td class="info_title"><p>찾아가는 길</p></td>
					<td>${detail.fboard_shopping_go }</td>
					</tr>
					<tr>
				</table>			
				</c:when>
			</c:choose>
		</div>
	<div id="fboard_detail_contents">
		<c:choose>
				<c:when test="${fboard_category=='명소' }">
					<p>${detail.fboard_attraction_content}</p>
				</c:when>
				<c:when test="${fboard_category=='맛집' }">
					<p>${detail.fboard_restaurant_content}<p>
				</c:when>
				<c:when test="${fboard_category=='축제' }">
					<p>${detail.fboard_festival_contents}</p>
				</c:when>
				<c:when test="${fboard_category=='쇼핑' }">
					<p>${detail.fboard_shopping_contents}</p>
				</c:when>
			</c:choose>
	</div>
	<c:if test="${sessionScope.member_power eq 'admin'}">
	<div  id="fboard_update_delete">
	<form action="/fboard.do?cmd=fboard_update_form" method="post">
		<input type="submit" value="수정" id="update_button">
		<input type="text"style="display: none;" name="detail_num" value="${detail_num }" class="detail_text">
		<input type="text"style="display: none;" name="fboard_num" value="${fboard_num}" class="detail_text">
		<input type="text"style="display: none;" name="fboard_area" value="${fboard_area}" class="detail_text">
		<input type="text"style="display: none;" name="fboard_city" value="${fboard_city}" class="detail_text">
		<input type="text"style="display: none;" name="fboard_category" value="${fboard_category}" class="detail_text">
	</form>
	<form action="/fboard.do?cmd=fboard_delete"method="post">
		<input type="submit" value="삭제" id="delete_button"><!-- display: none; -->
		<input type="text"style="display: none;" name="detail_num" value="${detail_num }" class="detail_text">
		<input type="text"style="display: none;" name="fboard_num" value="${fboard_num}" class="detail_text">
		<input type="text"style="display: none;" name="fboard_area" value="${fboard_area}" class="detail_text">
		<input type="text"style="display: none;" name="fboard_city" value="${fboard_city}" class="detail_text">
		<input type="text"style="display: none;" name="fboard_category" value="${fboard_category}" class="detail_text">
	</form>
	</div>
	</c:if>
</div>