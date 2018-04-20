<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="board_market">
	<div class="board_market_subject">
		<div class="board_market_subject_title">&nbsp;&nbsp;중고장터입니다.</div>
		<div></div>
	</div>
	<div class="board_market_tab">
		<ul>
			<li><a href="/market.do?cmd=market_read" class="${tab0 }">전체</a></li>
			<li><a href="javascript:tab_effect(1)" class="${tab1 }">팝니다</a></li>
			<li><a href="javascript:tab_effect(2)" class="${tab2 }">삽니다</a></li>
			<li><a href="javascript:tab_effect(3)" class="${tab3 }">가방</a></li>
			<li><a href="javascript:tab_effect(4)" class="${tab4 }">의류</a></li>
			<li><a href="javascript:tab_effect(5)" class="${tab5 }">장비</a></li>
			<li><a href="javascript:tab_effect(6)" class="${tab6 }">액세서리</a></li>
			<li><a href="javascript:tab_effect(7)" class="${tab7 }">숙박권</a></li>
			<li><a href="javascript:tab_effect(8)" class="${tab8 }">이용권</a></li>
		</ul>
	</div>
	<!-- 전체 리스트 출력 -->
	<div class="board_market_content">
		<table border="1" width="800">
			<thead>
				<tr>
					<th>구분</th>
					<th>카테고리</th>
					<th>작성자</th>
					<th>제목</th>
					<th>가격</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }" begin="${startRow }"
					end="${endRow }">
					<tr>
						<td style="text-align: center">${dto.market_sort }</td>
						<td style="text-align: center">${dto.market_category }</td>
						<td style="text-align: center">${dto.market_writer }</td>
						<td><a href="">${dto.market_title }</a></td>
						<td style="text-align: right"><fmt:formatNumber
								value="${dto.market_price }" pattern="#,###" /></td>
						<td style="text-align: center">${dto.market_hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 페이징 처리 -->
		<div class="board_market_paging">
			<c:choose>
				<c:when test="${startPage>10 }">
					<input type="button" value=" ≪ " onclick="prev_page(1)">
					<input type="button" value=" 이전 " onclick="prev_page(2)">
				</c:when>
				<c:otherwise>
					<input type="button" value=" ≪ ">
					<input type="button" value=" 이전 ">
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }">
						<a href=""><span style="color: red; font-weight: bold">[${i}]</span></a>
					</c:when>
					<c:otherwise>
						<a href="">[${i}]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${endPage>10 }">
					<input type="button" value=" 다음 " onclick="next_page(2)">
					<input type="button" value=" ≫ " onclick="next_page(1)">
				</c:when>
				<c:otherwise>
					<input type="button" value=" 다음 ">
					<input type="button" value=" ≫ ">
				</c:otherwise>
			</c:choose>
		</div>
		<!-- 검색 -->
		<div class="board_market_search">
			<form action="/market.do?cmd=market_search" method="post">
				<select name="market_search_option">
					<option value="market_writer">작성자</option>
					<option value="market_title">제목</option>
					<option value="market_price">가격</option>
				</select> <input type="text" name="market_search_text"> <input
					type="submit" value="검색">
			</form>
		</div>
	</div>
</div>
