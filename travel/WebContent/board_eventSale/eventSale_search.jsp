<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="board_ldk" align="center">
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;이벤트/할인 게시판입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		이벤트/할인 정보를 공유하는 게시판입니다.<br>
		다양한 정보 공유 부탁 드립니다.
		</div>	
	</div>
	<div class="board_ldk_tab">
		<ul>
			<li><a href="/eventSale.do?cmd=eventSale_read">전체</a></li>
			<li><a href="/eventSale.do?cmd=eventSale_search
						&eventSale_search_option=eventSale_sort
						&eventSale_search_text=이벤트" class="board_tab">이벤트</a></li>
			<li><a href="/eventSale.do?cmd=eventSale_search
						&eventSale_search_option=eventSale_sort
						&eventSale_search_text=할인" class="board_tab">할인</a></li>
			<li><a href="eventSale.do?cmd=eventSale_search
						&eventSale_search_option=eventSale_category
						&eventSale_search_text=의류" class="board_tab">의류</a></li>
			<li><a href="eventSale.do?cmd=eventSale_search
						&eventSale_search_option=eventSale_category
						&eventSale_search_text=장비" class="board_tab">장비</a></li>
			<li><a href="eventSale.do?cmd=eventSale_search
						&eventSale_search_option=eventSale_category
						&eventSale_search_text=숙박" class="board_tab">숙박</a></li>
			<li><a href="eventSale.do?cmd=eventSale_search
						&eventSale_search_option=eventSale_category
						&eventSale_search_text=항공권" class="board_tab">항공권</a></li>
			<li><a href="eventSale.do?cmd=eventSale_search
						&eventSale_search_option=eventSale_category
						&eventSale_search_text=패키지" class="board_tab">패키지</a></li>
		</ul>
		<input type="button" id="btn_write" value="글쓰기" style="display:none" onclick="javascript:location.href='/eventSale.do?cmd=eventSale_create_page'">
	</div>
	<!-- 전체 리스트 출력 -->
	<div class="board_ldk_content">
		<table border="1">
			<thead>
				<tr>
				<th width="45">No</th>
				<th width="60">구분</th>
				<th width="85">항목</th>				
				<th>제목</th>
				<th width="110">작성자</th>
				<th width="80">시작일</th>
				<th width="50">종료일</th>
				<th width="50">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }" begin="0" end="${rowCount-1 }">
					<c:choose>
						<c:when test="Integer.parseInt(${dto.eventSale_endDate })<=Integer.parseInt(today)">
							<tr>
								<td style="text-align: center;color:#dcdcdc;">${dto.eventSale_num }</td>
								<td style="text-align: center;color:#dcdcdc;">${dto.eventSale_sort }</td>
								<td style="text-align: center;color:#dcdcdc;">${dto.eventSale_category }</td>
								<td >&nbsp;&nbsp;<a
									href="/eventSale.do?cmd=eventSale_detail&eventSale_num=${dto.eventSale_num }" style="color:#dcdcdc;text-decoration:none;">${dto.eventSale_title }</a></td>
								<td style="text-align: center;color:#dcdcdc;">${dto.eventSale_writer }</td>
								<td style="text-align: center;color:#dcdcdc;">${dto.eventSale_startDate }</td>
								<td style="text-align: center;color:#dcdcdc;">${dto.eventSale_endDate }</td>
								<td style="text-align: center;color:#dcdcdc;">${dto.eventSale_hit }</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td style="text-align: center">${dto.eventSale_num }</td>
								<td style="text-align: center">${dto.eventSale_sort }</td>
								<td style="text-align: center">${dto.eventSale_category }</td>
								<td>&nbsp;&nbsp;<a
									href="/eventSale.do?cmd=eventSale_detail&eventSale_num=${dto.eventSale_num }">${dto.eventSale_title }</a></td>
								<td style="text-align: center">${dto.eventSale_writer }</td>
								<td style="text-align: center">${dto.eventSale_startDate }</td>
								<td style="text-align: center">${dto.eventSale_endDate }</td>
								<td style="text-align: center">${dto.eventSale_hit }</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tbody>
		</table>		
		<!-- 페이징 처리 -->
		<div class="board_ldk_paging">		
			<!-- << 버튼 조건절 : 11페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${startPage>10 }">
				<input type="button" value=" ≪ " onclick="javascripte:location.href='/eventSale.do?cmd=eventSale_search&pageNum=${startPage-1 }&eventSale_search_option=${eventSale_search_option}&eventSale_search_text=${eventSale_search_text}'">			
				</c:when>
				<c:otherwise>
				<input type="button" value=" ≪ ">			
				</c:otherwise>
			</c:choose>
			
			<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${pageNum>1 }">
				<input type="button" value=" 이전 " onclick="javascripte:location.href='/eventSale.do?cmd=eventSale_search&pageNum=${pageNum-1 }&eventSale_search_option=${eventSale_search_option}&eventSale_search_text=${eventSale_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 이전 ">
				</c:otherwise>
			</c:choose>
			
			<!-- 페이징 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }"><a href=""><span style="color:red;font-weight:bold">[${i}]</span></a></c:when>
					<c:otherwise><a href="/eventSale.do?cmd=eventSale_search&pageNum=${i }
										&eventSale_search_option=${eventSale_search_option}
										&eventSale_search_text=${eventSale_search_text}">[${i}]</a></c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 버튼 조건절 : 2페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${endPage>1 }">
				<input type="button" value=" 다음 " onclick="javascripte:location.href='/eventSale.do?cmd=eventSale_search&pageNum=${pageNum+1 }&eventSale_search_option=${eventSale_search_option}&eventSale_search_text=${eventSale_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 다음 ">
				</c:otherwise>
			</c:choose>
			
			<!-- >> 버튼 조건절 : 11페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${pageCount>10 }">			
					<input type="button" value=" ≫ " onclick="javascripte:location.href='/eventSale.do?cmd=eventSale_search&pageNum=${endPage+1 }&eventSale_search_option=${eventSale_search_option}&eventSale_search_text=${eventSale_search_text}'">			
				</c:when>
				<c:otherwise>
					<input type="button" value=" ≫ ">
				</c:otherwise>
			</c:choose>
			<div style="float:right">
				<select id="rowCount_change" onchange="location.href='/eventSale.do?cmd=eventSale_search&pageNum=${pageNum }
														&eventSale_search_option=${eventSale_search_option}
														&eventSale_search_text=${eventSale_search_text}
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
			<form action="/eventSale.do" method="post">
			<input type="hidden" name="cmd" value="eventSale_search">
			<select name="eventSale_search_option">
				<option value="eventSale_writer">작성자</option>
				<option value="eventSale_title">제목</option>
				<option value="eventSale_content">내용</option>
			</select>
			<input type="text" name="eventSale_search_text">
			<input type="submit" class="search_button" value="검색">
			</form>
		</div>
	</div>
</div>
<script>
	function tab(){
		var board_tab=document.getElementsByClassName("board_tab");
		for(var i=0;i<board_tab.length;i++){
			if(board_tab[i].innerHTML=="${eventSale_search_text}"){
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
		if("${sessionScope.member_nickname }"!=""){
			btn_write.style.display="block";
		}
	}
	window.onload=login_check();
</script>