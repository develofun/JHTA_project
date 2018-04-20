<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="board_ldk" align="center">
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;중고장터입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		중고 물품을 거래하는 게시판입니다.<br>
		깨끗하고 양심적인 거래 부탁 드립니다.
		</div>	
	</div>
	<div class="board_ldk_tab">
		<ul>
			<li><a href="/market.do?cmd=market_read" class="board_tab">전체</a></li>
			<li><a href="/market.do?cmd=market_search
						&market_search_option=market_sort
						&market_search_text=판매" class="board_tab">판매</a></li>
			<li><a href="/market.do?cmd=market_search
						&market_search_option=market_sort
						&market_search_text=구매" class="board_tab">구매</a></li>
			<li><a href="/market.do?cmd=market_search
						&market_search_option=market_category
						&market_search_text=가방" class="board_tab">가방</a></li>
			<li><a href="market.do?cmd=market_search
						&market_search_option=market_category
						&market_search_text=의류" class="board_tab">의류</a></li>
			<li><a href="market.do?cmd=market_search
						&market_search_option=market_category
						&market_search_text=장비" class="board_tab">장비</a></li>
			<li><a href="market.do?cmd=market_search
						&market_search_option=market_category
						&market_search_text=액세서리" class="board_tab">액세서리</a></li>
			<li><a href="market.do?cmd=market_search
						&market_search_option=market_category
						&market_search_text=숙박권" class="board_tab">숙박권</a></li>
			<li><a href="market.do?cmd=market_search
						&market_search_option=market_category
						&market_search_text=이용권" class="board_tab">이용권</a></li>
		</ul>
		<input type="button" id="btn_write" value="글쓰기" onclick="javascript:location.href='/market.do?cmd=market_create_page'">
	</div>	
	<!-- 전체 리스트 출력 -->
	<div class="board_ldk_content">
		<table border="1" width="800">
			<thead>
				<tr>
				<th style="width:100px">No</th>
				<th style="width:300px">구분</th>
				<th style="width:600px">카테고리</th>
				<th style="width:600px">작성자</th>
				<th style="width:2000px">제목</th>
				<th style="width:300px">가격</th>
				<th style="width:300px">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }" begin="0" end="${rowCount-1 }">
					<tr>
					<td style="text-align:center;width:100px">${dto.market_num }</td>
					<td style="text-align:center;width:300px">${dto.market_sort }</td>
					<td style="text-align:center;width:600px">${dto.market_category }</td>
					<td style="text-align:center;width:600px">${dto.market_writer }</td>
					<td style="width:2000px">&nbsp;&nbsp;<a href="/market.do?cmd=market_detail&market_num=${dto.market_num }">${dto.market_title }</a></td>
					<td style="text-align:right;width:300px"><fmt:formatNumber value="${dto.market_price }" pattern="#,###"/>&nbsp;&nbsp;</td>
					<td style="text-align:center;width:300px">${dto.market_hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
		<!-- 페이징 처리 -->
		<div class="board_ldk_paging">		
			<!-- << 버튼 조건절 : 11페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${startPage>10 }">
				<input type="button" value=" ≪ " onclick="javascripte:location.href='/market.do?cmd=market_search&pageNum=${startPage-1 }&market_search_option=${market_search_option}&market_search_text=${market_search_text}'">			
				</c:when>
				<c:otherwise>
				<input type="button" value=" ≪ ">			
				</c:otherwise>
			</c:choose>
			
			<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${pageNum>1 }">
				<input type="button" value=" 이전 " onclick="javascripte:location.href='/market.do?cmd=market_search&pageNum=${pageNum-1 }&market_search_option=${market_search_option}&market_search_text=${market_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 이전 ">
				</c:otherwise>
			</c:choose>
			
			<!-- 페이징 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }"><a href=""><span style="color:red;font-weight:bold">[${i}]</span></a></c:when>
					<c:otherwise><a href="/market.do?cmd=market_search&pageNum=${i }
										&market_search_option=${market_search_option}
										&market_search_text=${market_search_text}">[${i}]</a></c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 버튼 조건절 : 2페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${endPage>1 }">
				<input type="button" value=" 다음 " onclick="javascripte:location.href='/market.do?cmd=market_search&pageNum=${pageNum+1 }&market_search_option=${market_search_option}&market_search_text=${market_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 다음 ">
				</c:otherwise>
			</c:choose>
			
			<!-- >> 버튼 조건절 : 11페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${pageCount>10 }">			
					<input type="button" value=" ≫ " onclick="javascripte:location.href='/market.do?cmd=market_search&pageNum=${endPage+1 }&market_search_option=${market_search_option}&market_search_text=${market_search_text}'">			
				</c:when>
				<c:otherwise>
					<input type="button" value=" ≫ ">
				</c:otherwise>
			</c:choose>
			<div style="float:right">
				<select id="rowCount_change" onchange="location.href='/market.do?cmd=market_search&pageNum=${pageNum }
														&market_search_option=${market_search_option}
														&market_search_text=${market_search_text}
														&rowCount='+this.value">
					<option value="10">10개</option>
					<option value="15">15개</option>
					<option value="20">20개</option>
					<option value="25">25개</option>
					<option value="30">30개</option>
				</select>	
			</div>
		</div>		
		<!-- 검색 -->
		<div class="board_ldk_search">
			<form action="/market.do" method="post">
			<input type="hidden" name="cmd" value="market_search">
			<select name="market_search_option">
				<option value="market_writer">작성자</option>
				<option value="market_title">제목</option>
				<option value="market_price">가격</option>
			</select>
			<input type="text" name="market_search_text">
			<input type="submit" class="search_button" value="검색">
			</form>
		</div>
	</div>
</div>
<script>
	function tab(){
		var board_tab=document.getElementsByClassName("board_tab");
		for(var i=0;i<board_tab.length;i++){
			if(board_tab[i].innerHTML=="${market_search_text}"){
				board_tab[i].className="clicked";
				return;
			}
		}
		board_tab[0].className="clicked";
		var select_count=document.getElementById("rowCount_change");
		select_count.value="${rowCount}";
	}
	tab();
	function login_check(){
		var btn_write=document.getElementById("btn_write");
		if("${sessionScope.member_nickname }"==""){
			btn_write.style.display="none";
		}
	}
	window.onload=login_check();
</script>