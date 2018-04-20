
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_member_list.css" type="text/css">

<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">	
		
	$(document).ready(function(){
		
	    // On refresh check if there are values selected
	    if (localStorage.selectVal) {
	            // Select the value stored
	        $("#gonggu_insert_category").val( localStorage.selectVal );
	    }
		
		
	});
	
	// On change store the value
	$("#gonggu_insert_category").on('change', function(){
	    var currentVal = $(this).val();
	    localStorage.setItem('selectVal', currentVal );
	});
	
</script>

<div id="wrap">
	<div id="memberlist">
	
		<div id="best_member_alldiv">
			<h2>회원 공동구매 베스트 3</h2>
			<div class="best_member">
				<div class="member_img">
					<a href="<c:url value='/gonggu/gonggu_detail?num=${best1.gonggu_insert_num }'/>"><img src="/resources/gonggu_uploadImg/${best1.gonggu_img_sname}" style="width:230px;height:120px;border-radius:5px;"></a><br>
				</div>
				<div class="member_content" align="center">
					<a href="<c:url value='/gonggu/gonggu_detail?num=${best1.gonggu_insert_num }'/>">${best1.gonggu_insert_title }</a><br>
					<span>${best1.gonggu_insert_content }</span><br>
					
					<c:choose>
						<c:when test="${best1_day >= 0 }">
							<c:choose>
							<c:when test="${best1.gonggu_insert_maxnum <= 0 }">
								<span style="color:red;font-weight: bold;">재고없음</span><br>
								<span style="color:red;font-weight: bold;">공구마감</span><br>
							</c:when>
							<c:otherwise>
								<span style="color:blue">현재 ${best1.gonggu_insert_maxnum } 개 남았어요.</span><br>
								<span style="color:green;font-weight: bold;">공구진행중</span><br>
							</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<span style="color:red;font-weight: bold;">공구마감</span><br>
						</c:otherwise>
					</c:choose>
					
				</div>
			</div>
			<div class="best_member">
				<div class="member_img">
					<a href="<c:url value='/gonggu/gonggu_detail?num=${best2.gonggu_insert_num }'/>"><img src="/resources/gonggu_uploadImg/${best2.gonggu_img_sname}" style="width:230px;height:120px;border-radius:5px;"></a><br>
				</div>
				<div class="member_content" align="center">
					<a href="<c:url value='/gonggu/gonggu_detail?num=${best2.gonggu_insert_num }'/>">${best2.gonggu_insert_title }</a><br>
					<span>${best2.gonggu_insert_content }</span><br>
					
					<c:choose>
						<c:when test="${best2_day >= 0 }">
							<c:choose>
							<c:when test="${best2.gonggu_insert_maxnum <= 0 }">
								<span style="color:red;font-weight: bold;">재고없음</span><br>
								<span style="color:red;font-weight: bold;">공구마감</span><br>
							</c:when>
							<c:otherwise>
								<span style="color:blue">현재 ${best2.gonggu_insert_maxnum } 개 남았어요.</span><br>
								<span style="color:green;font-weight: bold;">공구진행중</span><br>
							</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<span style="color:red;font-weight: bold;">공구마감</span><br>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<div class="best_member">
				<div class="member_img">
					<a href="<c:url value='/gonggu/gonggu_detail?num=${best3.gonggu_insert_num }'/>"><img src="/resources/gonggu_uploadImg/${best3.gonggu_img_sname}" style="width:230px;height:120px;border-radius:5px;"></a><br>
				</div>
				<div class="member_content" align="center">
					<a href="<c:url value='/gonggu/gonggu_detail?num=${best3.gonggu_insert_num }'/>">${best3.gonggu_insert_title }</a><br>
					<span>${best3.gonggu_insert_content }</span><br>
					
					<c:choose>
						<c:when test="${best3_day >= 0 }">
							<c:choose>
							<c:when test="${best3.gonggu_insert_maxnum <= 0 }">
								<span style="color:red;font-weight: bold;">재고없음</span><br>
								<span style="color:red;font-weight: bold;">공구마감</span><br>
							</c:when>
							<c:otherwise>
								<span style="color:blue">현재 ${best3.gonggu_insert_maxnum } 개 남았어요.</span><br>
								<span style="color:green;font-weight: bold;">공구진행중</span><br>
							</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<span style="color:red;font-weight: bold;">공구마감</span><br>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
		</div>
		<div id="member_list_all">
				
			<h2>전체회원공구리스트</h2>
			<div id="list_all_category">
				<select id="gonggu_insert_category" name="gonggu_insert_category" onchange="location.href=this.value" style="width:100px;height:30px;border-radius:5px;float:right;">
					<option value="" selected="selected">선택</option>
					<option value="<c:url value='/gonggu_list_category?category=패션'/>">패션</option>
					<option value="<c:url value='/gonggu_list_category?category=인테리어'/>">인테리어</option>
					<option value="<c:url value='/gonggu_list_category?category=문화/공연'/>">문화/공연</option>
					<option value="<c:url value='/gonggu_list_category?category=기타'/>">기타</option>
					<option value="<c:url value='/gonggu_list_category'/>">전체</option>
				</select>
				<span style="color:black;float:right;margin-right:10px;font-size: 18px;">카테고리선택</span>
				
				<input type="hidden" id="category_name" value="${category }">
				
			</div>
			
			<div id="result">
				<c:forEach var="vo" items="${memberlist }">
				  
					<div class="list_all_member" align="center">
						<a href="<c:url value='/gonggu/gonggu_detail?num=${vo.gonggu_insert_num }'/>"><img src="/resources/gonggu_uploadImg/${vo.gonggu_img_sname }" style="width:200px;height:250px;border-radius:5px;"></a><br>
						<span id="gonggu_detail_title_span"><a href="<c:url value='/gonggu/gonggu_detail?num=${vo.gonggu_insert_num }'/>">${vo.gonggu_insert_title }</a></span><br>
						<span id="gonggu_detail_content_span" style="color:black;">${vo.gonggu_insert_content }</span><br>
						
						<c:choose>
							<c:when test="${vo.day >= 0 }">
								<c:choose>
								<c:when test="${vo.gonggu_insert_maxnum <= 0 }">
									<span style="color:red;font-weight: bold;">재고없음</span><br>
									<span style="color:red;font-weight: bold;">공구마감</span><br>
								</c:when>
								<c:otherwise>
									<span style="color:blue">현재 ${vo.gonggu_insert_maxnum } 개 남았어요.</span><br>
									<span style="color:green;font-weight: bold;">공구진행중</span><br>
								</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<span style="color:red;font-weight: bold;">공구마감</span><br>
							</c:otherwise>
						</c:choose>
							
						
					</div>
					
				</c:forEach>
			</div>
			
			<div id="gonggu_paging" align="center" style="float:left;width:1000px;">
				<!-- 이전 -->
				<c:choose>
					<c:when test="${pu.startPageNum>5 }">
						<a href="<c:url value='/gonggu/gonggu_member_list?pageNum=${pu.startPageNum-1 }&keyword=${keyword}'/>">이전</a>
						
					</c:when>
					<c:otherwise>
						이전
					</c:otherwise>
				</c:choose>
				
				<!-- 페이징 -->
				<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${i==pu.pageNum }">
							<a href="<c:url value='/gonggu/gonggu_member_list?pageNum=${i }&keyword=${keyword}'/>"><span style="color:red">[${i }]</span></a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value='/gonggu/gonggu_member_list?pageNum=${i }&keyword=${keyword}'/>"><span style="color:#333">[${i }]</span></a>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
				
				<!-- 다음 -->
				<c:choose>
					<c:when test="${pu.endPageNum<pu.totalPageCount }">
						<a href="<c:url value='/gonggu/gonggu_member_list?pageNum=${pu.endPageNum+1 }&keyword=${keyword}'/>">다음</a>
					</c:when>
					<c:otherwise>
						다음
					</c:otherwise>
				</c:choose>
				
			</div>
			
			<div id="gonggu_searching" align="center" class="form-inline" style="float:left;width:1000px;">
				<br>
				<form method="post" action="/gonggu/gonggu_member_list">
					<input type="text" name="keyword" value="${keyword }" class="form-control" style="width:200px;height:30px;">
					<input type="submit" class="btn btn-primary" name="btn_searching" id="btn_searching" value="검색">
				</form>
				<br>
				<br>
			</div>
		</div>
		
	</div>
</div>