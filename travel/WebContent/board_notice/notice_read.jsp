<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;공지사항게시판 입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		공지사항 게시판입니다..<br>
		공지 확인 부탁드립니다...
		</div>	
	</div>
	<table class="notice_read">
		<colgroup>
			<col width="20%">
			<col width="*">
			<col width="20%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.notice_num }</td>
					<td><a
						href="/notice.do?cmd=notice_detail&notice_num=${dto.notice_num}" style="text-decoration:none" class="notice_read_title">${dto.notice_title }</a></td>
					<td>${dto.notice_hit }</td>
					<td>${dto.notice_w_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
			<div id="notice_create_btn">
				<a href="/notice.do?cmd=notice_create_form" id="notice_create" >글쓰기</a>
			</div>
	
	 <c:if test="${sessionScope.member_power eq 'admin'}">
 		<div id="notice_create_btn">
			<a href="/notice.do?cmd=notice_create_form" id="notice_create" >글쓰기</a>
		</div>
	 </c:if>
	
	<div id="notice_read_page">
		<div id="notice_page">
			<c:choose>
				<c:when test="${startPage>10 }">
					<a
						href="/notice.do?cmd=notice_read&pageNum=${startPage-1 }&notice_search_box=${notice_search_box}&notice_search=${notice_search}">[<<]</a>
				</c:when>
				<c:otherwise>
				[<<]
			</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${pageNum>1 }">
					<a
						href="/notice.do?cmd=notice_read&pageNum=${pageNum-1 }&notice_search_box=${notice_search_box}&notice_search=${notice_search}">[<]</a>
				</c:when>
				<c:otherwise>
				[<]
			</c:otherwise>
			</c:choose>


			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }">
						<a
							href="/notice.do?cmd=notice_read&pageNum=${i }&notice_search_box=${notice_search_box}&notice_search=${notice_search}"><span
							style="color: red">[${i }]</span></a>
					</c:when>
					<c:otherwise>
						<a
							href="/notice.do?cmd=notice_read&pageNum=${i }&notice_search_box=${notice_search_box}&notice_search=${notice_search}"><span
							style="color: #555">[${i }]</span></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>


			<c:choose>
				<c:when test="${pageNum<endPage || endPage<pageCount }">
					<a
						href="/notice.do?cmd=notice_read&pageNum=${pageNum+1 }&notice_search_box=${notice_search_box}&notice_search=${notice_search}">[>]</a>
				</c:when>
				<c:otherwise>
				[>]
			</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${endPage<pageCount }">
					<a
						href="/notice.do?cmd=notice_read&pageNum=${endPage+1 }&notice_search_box=${notice_search_box}&notice_search=${notice_search}">[>>]</a>
				</c:when>
				<c:otherwise>
				[>>]
			</c:otherwise>
			</c:choose>
		</div>
		<%
			request.setCharacterEncoding("utf-8");
			String notice_search_box = request.getParameter("notice_search_box") != null
					? request.getParameter("notice_search_box") : "";
			String notice_search = request.getParameter("notice_search");
			if (notice_search == null) {
				notice_search = "";
			}
		%>
		<div id="notice_search">
			<form method="get">
				<input type="hidden" name="cmd" value="${cmd}"> <select
					name="notice_search_box">
					<option value="제목" <%if (notice_search_box.equals("제목")) {%>
						selected <%}%>>제목</option>
					<option value="내용" <%if (notice_search_box.equals("내용")) {%>
						selected <%}%>>내용</option>
				</select> <input type="text" name="notice_search" value="<%=notice_search%>">
				<input type="submit" value="검색">
			</form>
		</div>
	</div>
</div>