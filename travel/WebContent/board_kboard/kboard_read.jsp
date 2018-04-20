<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<div id="kboard_menu">
		<ul>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read">전체</a></li>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read&kboard_area=서울">서울</a>
				<ul>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=서울&kboard_city=서울">서울</a></li>
				</ul></li>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read&kboard_area=경기도">경기도</a>
				<ul>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경기도&kboard_city=인천">인천</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경기도&kboard_city=파주">파주</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경기도&kboard_city=포천">포천</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경기도&kboard_city=이천">이천</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경기도&kboard_city=기타">기타</a></li>
				</ul></li>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read&kboard_area=강원도">강원도</a>
				<ul>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=강원도&kboard_city=강릉">강릉</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=강원도&kboard_city=평창">평창</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=강원도&kboard_city=춘천">춘천</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=강원도&kboard_city=기타">기타</a></li>
				</ul></li>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read&kboard_area=충청도">충청도</a>
				<ul>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=충청도&kboard_city=대전">대전</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=충청도&kboard_city=보령">보령</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=충청도&kboard_city=천안">천안</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=충청도&kboard_city=기타">기타</a></li>
				</ul></li>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read&kboard_area=경상도">경상도</a>
				<ul>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경상도&kboard_city=부산">부산</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경상도&kboard_city=울산">울산</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경상도&kboard_city=대구">대구</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경상도&kboard_city=경주">경주</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=경상도&kboard_city=기타">기타</a></li>
				</ul></li>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read&kboard_area=전라도">전라도</a>
				<ul>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=전라도&kboard_city=광주">광주</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=전라도&kboard_city=여수">여수</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=전라도&kboard_city=목포">목포</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=전라도&kboard_city=전주">전주</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=전라도&kboard_city=기타">기타</a></li>
				</ul></li>
			<li class="topMenu"><a href="/kboard.do?cmd=kboard_read&kboard_area=제주도">제주도</a>
				<ul>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=제주도&kboard_city=제주">제주</a></li>
					<li><a
						href="/kboard.do?cmd=kboard_read&kboard_area=제주도&kboard_city=서귀포">서귀포</a></li>
				</ul></li>
		</ul>
	</div>
	<br>

	<div id="kboard">
		<div id="kboard_category">
			<ul>
				<li><a
					href="/kboard.do?cmd=kboard_read&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=명소">명소</a></li>
				<li><a
					href="/kboard.do?cmd=kboard_read&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=맛집">맛집</a></li>
				<li><a
					href="/kboard.do?cmd=kboard_read&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=숙박">숙박</a></li>
				<li><a
					href="/kboard.do?cmd=kboard_read&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=축제">축제</a></li>
			</ul>
		</div>
		<div id="kboard_read">
			<ul>
				<c:forEach var="dto" items="${list }">
					<a href="/kboard.do?cmd=kboard_detail&kboard_num=${dto.kboard_num }">
						<li>
							<img src="/kimages/${dto.kboard_imgname }" class="kboard_read_table_images">
				            ${dto.kboard_title }
						</li>
					</a>
				</c:forEach>
			</ul>

		</div>

		<div id="kboard_page">
			<c:choose>
				<c:when test="${startPage>10 }">
					<a
						href="/kboard.do?cmd=kboard_read&pageNum=${startPage-1 }&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=${kboard_category }">[<<]</a>
				</c:when>
				<c:otherwise>
				[<<]
			</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${pageNum>1 }">
					<a
						href="/kboard.do?cmd=kboard_read&pageNum=${pageNum-1 }&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=${kboard_category }">[<]</a>
				</c:when>
				<c:otherwise>
				[<]
			</c:otherwise>
			</c:choose>

			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }">
						<a
							href="/kboard.do?cmd=kboard_read&pageNum=${i }&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=${kboard_category }"><span
							style="color: red">[${i }]</span></a>
					</c:when>
					<c:otherwise>
						<a
							href="/kboard.do?cmd=kboard_read&pageNum=${i }&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=${kboard_category }"><span
							style="color: #555">[${i }]</span></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${pageNum<endPage || endPage<pageCount }">
					<a
						href="/kboard.do?cmd=kboard_read&pageNum=${pageNum+1 }&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=${kboard_category }">[>]</a>
				</c:when>
				<c:otherwise>
				[>]
			</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${endPage<pageCount }">
					<a
						href="/kboard.do?cmd=kboard_read&pageNum=${endPage+1 }&kboard_area=${kboard_area }&kboard_city=${kboard_city }&kboard_category=${kboard_category }">[>>]</a>
				</c:when>
				<c:otherwise>
				[>>]
			</c:otherwise>
			</c:choose>
		 		<div id="notice_detail_btn">
					<a href="/kboard.do?cmd=kboard_create_form" id="kboard_create">글쓰기</a>
				</div>
			
		</div>
	</div>
</div>