 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/ljh.css">
<script type="text/javascript">
<%
	String n=(String)request.getAttribute("n");
%>
</script>
<div>
<div id="fboard">
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
		<c:when test="${fboard_search_category!=null }">
				<c:if test="${fboard_search_area!=null }">
				 ${fboard_search_area}
				</c:if>
				<c:if test="${fboard_search_city!=null }">
				 ${fboard_search_city}
				</c:if>
				 ${fboard_search_category }
		</c:when>
		<c:when test="${fboard_search_city!=null }">
			<c:if test="${fboard_search_area!=null }">
			 ${fboard_search_area}
			</c:if>
			 ${fboard_search_city}
		</c:when>
		<c:when test="${fboard_search_area!=null }">
		${fboard_search_area}
		</c:when>
		<c:otherwise>
		 [전체]
		</c:otherwise>
	</c:choose>
	</div>
	<div id="fboard_list">
			<div id="fboard_list_category">
			<ul><c:choose>
					<c:when test="${fboard_search_area==null}">
						<c:if test="${fboard_search_category!=null}">
						<li><a href="/move.do?cmd=fboard">전체</a></li>
						</c:if>
						<li><a href="/move.do?cmd=fboard">전체</a></li>
					</c:when>
					<c:when test="${fboard_search_area==''}">
						<c:if test="${fboard_search_category!=null}">
						<li><a href="/move.do?cmd=fboard">전체</a></li>
						</c:if>
					</c:when>
					<c:otherwise>
					<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}">전체</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}&fboard_category=명소">명소</a></li>
				<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}&fboard_category=맛집">맛집</a></li>
				<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}&fboard_category=축제">축제</a></li>
				<li><a href="fboard.do?cmd=fboard_read_search&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}&fboard_category=쇼핑">쇼핑</a></li>
			</ul>
			<form method="post" action="fboard.do?cmd=fboard_create_form">
			<input type="submit" value="글쓰기" id="fboard_write_button">
			</form>
			</div>
		<div id="fboard_img_list">
			<c:forEach var="list" items="${list }">
				<div id="fboard_list_table_td" style="margin:8px;margin-left: 30px">
					<a href="fboard.do?cmd=fboard_detail&fboard_num=${list.fboard_num }&fboard_area=${list.fboard_area}&fboard_city=${list.fboard_city}&fboard_category=${list.fboard_category}">
					<c:choose>
						<c:when test="${list.fboard_image==null}">
						<img src="/images/fboard_images/null.jpg" class="fboard_list_table_image">
						</c:when>
						<c:otherwise>
						<img src="<%=request.getContextPath()%>/fimages/${list.fboard_image }" class="fboard_list_table_image">
						</c:otherwise>	
					</c:choose>
					</a>			
					<a href="fboard.do?cmd=fboard_detail&fboard_num=${list.fboard_num }&fboard_area=${list.fboard_area}&fboard_city=${list.fboard_city}&fboard_category=${list.fboard_category}">
					<h3>${list.fboard_title }</h3>
					</a>
				</div>
			</c:forEach>
		</div>
		<div id="fboard_lsit_paging">
			<c:choose>
				<c:when test="${cmd=='read_search' }">
					<c:if test="${preview_page10==true}">
					<a href="fboard.do?cmd=fboard_read&pageNum=${startPage-10 }"><span>[-10]</span></a>
					</c:if>
					<c:if test="${preview_page10==false}">
					<a><span>[-10]</span></a>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${preview_page10==true}">
					<a href="fboard.do?cmd=fboard_read&pageNum=${startPage-10 }"><span>[-10]</span></a>
					</c:if>
					<c:if test="${preview_page10==false}">
					<a><span>[-10]</span></a>
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${cmd=='read_search' }">
					<c:if test="${preview_page==true}">
					<a href="fboard.do?cmd=fboard_read_search&pageNum=${pageNum-1 }&fboard_area=${fboard_search_area}"><span>[이전]</span></a>
					</c:if>
					<c:if test="${preview_page==false}">
					<a><span>[이전]</span></a>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${preview_page==true}">
					<a href="fboard.do?cmd=fboard_read&pageNum=${pageNum-1 }"><span>[이전]</span></a>
					</c:if>
					<c:if test="${preview_page==false}">
					<a><span>[이전]</span></a>
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:choose>
				<c:when test="${cmd=='read_search' }">
					<c:if test="${pageNum==i }">
					<a href="fboard.do?cmd=fboard_read_search&pageNum=${i}&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}&fboard_category=${fboard_search_category}"><span style="color: red;">${i }</span></a>
					</c:if>
					<c:if test="${pageNum!=i }">
					<a href="fboard.do?cmd=fboard_read_search&pageNum=${i}&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}&fboard_category=${fboard_search_category}"><span style="color: blue;">${i }</span></a>
					</c:if>
				</c:when>
				<c:when test="${pageNum==i }">
					<c:if test="${cmd!='read_search' }">
						<a href="fboard.do?cmd=fboard_read&pageNum=${i }"><span style="color: red;">${i }</span></a>
					</c:if>
				</c:when>
				<c:otherwise>
				<a href="fboard.do?cmd=fboard_read&pageNum=${i }"><span style="color: blue">${i }</span></a>
				</c:otherwise>
			</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${cmd=='read_search' }">
					<c:if test="${next_page==true }">
					<a href="fboard.do?cmd=fboard_read_search&pageNum=${pageNum+1 }&fboard_area=${fboard_search_area}&fboard_city=${fboard_search_city}&fboard_category=${fboard_search_category}"><span>[다음]</span></a>
					</c:if>
					<c:if test="${next_page==false}">
					<a><span>[다음]</span></a>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${next_page==true }">
					<a href="fboard.do?cmd=fboard_read&pageNum=${pageNum+1 }"><span>[다음]</span></a>
					</c:if>
					<c:if test="${next_page==false}">
					<a><span>[다음]</span></a>
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${cmd=='read_search' }">
					<c:if test="${next_page10==true}">
					<a href="fboard.do?cmd=fboard_read&pageNum=${startPage+10 }"><span>[+10]</span></a>
					</c:if>
					<c:if test="${next_page10==false}">
					<a><span>[+10]</span></a>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${next_page10==true}">
					<a href="fboard.do?cmd=fboard_read&pageNum=${startPage+10 }"><span>[+10]</span></a>
					</c:if>
					<c:if test="${next_page10==false}">
					<a><span>[+10]</span></a>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</div>