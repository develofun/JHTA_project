<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="wrap" style="width:1000px;height:1200px;margin:auto;">

	<c:choose>
		<c:when test="${not empty sessionScope.id }">

			<div id="joinlist" style="width:1000px;float:left;">
				<h1>내가 등록한 공구 History</h1>
				
				<c:choose>
					<c:when test="${not empty joinlist }">
						<c:forEach var="vo" items="${joinlist }">
							<div id="${vo.gonggu_insert_num }" style="width:250px;height:350px;float:left;margin:40px;padding:20px;white-space:nowrap;
									overflow: hidden;text-overflow:ellipsis;border-radius:5px;background-color: white;" align="center">
							
								<img src="/resources/gonggu_uploadImg/${vo.gonggu_img_sname }" style="width:200px;height:250px;border-radius:5px;"><br>
								<span id="gonggu_detail_title_span"><a href="<c:url value='/gonggu/gonggu_detail?num=${vo.gonggu_insert_num }'/>">${vo.gonggu_insert_title }</a></span><br>
								<span id="gonggu_detail_content_span" style="color:black;">${vo.gonggu_insert_content }</span>
								
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div id="div_empty_joinlist" align="center">
							<h3>현재 등록하신 공구가 없습니다.</h3>
						</div>
					</c:otherwise>
				</c:choose>
				
				<div id="gonggu_join_list_paging" align="center" style="float:left;width:1000px;">
				<!-- 이전 -->
				<c:choose>
					<c:when test="${pu.startPageNum>5 }">
						<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum=${pu.startPageNum-1 }&id=${sessionScope.id }'/>">이전</a>
						
					</c:when>
					<c:otherwise>
						이전
					</c:otherwise>
				</c:choose>
				
				<!-- 페이징 -->
				<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${i==pu.pageNum }">
							<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum=${i }&id=${sessionScope.id }'/>"><span style="color:red">[${i }]</span></a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum=${i }&id=${sessionScope.id }'/>"><span style="color:#333">[${i }]</span></a>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
				
				<!-- 다음 -->
				<c:choose>
					<c:when test="${pu.endPageNum<pu.totalPageCount }">
						<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum=${pu.endPageNum+1 }&id=${sessionScope.id }'/>">다음</a>
					</c:when>
					<c:otherwise>
						다음
					</c:otherwise>
				</c:choose>
				
			</div>
				
				<br>
				<br>
			</div>
			<br>
			<br>
						
			
			<div id="buylist" style="width:1000px;float:left;">
				
				<h1>내가 구매한 공구 History</h1>
				
				<c:choose>
					<c:when test="${not empty buylist }">
						<c:forEach var="vo" items="${buylist }">
							<div id="${vo.gonggu_insert_num }" style="width:250px;height:350px;float:left;margin:40px;padding:20px;white-space:nowrap;
									overflow: hidden;text-overflow:ellipsis;border-radius:5px;background-color: white;" align="center">
							
								<img src="/resources/gonggu_uploadImg/${vo.gonggu_img_sname }" style="width:200px;height:250px;border-radius:5px;"><br>
								<span id="gonggu_detail_title_span"><a href="<c:url value='/gonggu/gonggu_detail?num=${vo.gonggu_insert_num }'/>">${vo.gonggu_insert_title }</a></span><br>
								<span id="gonggu_detail_content_span" style="color:black;">${vo.gonggu_insert_content }</span>
								
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div id="div_empty_buylist" align="center">
							<h3>현재 구매하신 공구가 없습니다.</h3>
						</div>
					</c:otherwise>
				</c:choose>
				
				<div id="gonggu_buy_list_paging" align="center" style="float:left;width:1000px;">
				<!-- 이전 -->
				<c:choose>
					<c:when test="${pu_buy.startPageNum>5 }">
						<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum_buy=${pu_buy.startPageNum-1 }&id=${sessionScope.id }'/>">이전</a>
						
					</c:when>
					<c:otherwise>
						이전
					</c:otherwise>
				</c:choose>
				
				<!-- 페이징 -->
				<c:forEach var="i" begin="${pu_buy.startPageNum }" end="${pu_buy.endPageNum }">
					<c:choose>
						<c:when test="${i==pu_buy.pageNum }">
							<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum_buy=${i }&id=${sessionScope.id }'/>"><span style="color:red">[${i }]</span></a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum_buy=${i }&id=${sessionScope.id }'/>"><span style="color:#333">[${i }]</span></a>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
				
				<!-- 다음 -->
				<c:choose>
					<c:when test="${pu_buy.endPageNum<pu_buy.totalPageCount }">
						<a href="<c:url value='/gonggu/gonggu_joinlist?pageNum_buy=${pu_buy.endPageNum+1 }&id=${sessionScope.id }'/>">다음</a>
					</c:when>
					<c:otherwise>
						다음
					</c:otherwise>
				</c:choose>
				
				</div>
				<br>
				<br>
				
			</div>
		
		</c:when>
		<c:otherwise>
			<div id="nonsession" style="height:300px;margin-top:110px;">
				<h1>로그인 후 확인이 가능합니다.</h1>
			</div>
		</c:otherwise>
	
	</c:choose>
</div>