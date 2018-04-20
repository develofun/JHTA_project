<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<link rel="stylesheet" href="/resources/css/gonggu/gonggu_main.css" type="text/css">
<link rel="stylesheet" href="/resources/css/navbar_techandall.css" type="text/css">
<link rel="stylesheet" href="/resources/css/font-awesome/css/font-awesome.min.css" type="text/css">


<div id="main">
	<div id="main_menu">
		<div id="topMenu" style="width:1000px;height:60px;text-align: center;"> 
			<ul style="list-style: none;text-align: center;"> 
				<li style="float:left;margin-left:20px;">
					<a class="menuLink" href="<c:url value='/gonggu/gonggu_member_list'/>"><input type="button" class="btn btn-info" value="회원공구" style="width:180px;"></a>
				</li>
				<li style="float:left;margin-left:20px;">
					<a class="menuLink" href="<c:url value='/gonggu/gonggu_join'/>"><input type="button" class="btn btn-info" value="공구등록하기" style="width:180px;"></a>
				</li>
				<li style="float:left;margin-left:20px;">
					<a class="menuLink" href="<c:url value='/gonggu/gonggu_joinlist?id=${sessionScope.id }'/>"><input type="button" class="btn btn-info" value="나의 공동구매내역" style="width:180px;"></a>
				</li>
				<li style="float:left;margin-left:20px;">
					<a href="<c:url value='/gonggu/gonggu_upload_request'/>" style="margin-left: 10px;"><input type="button" class="btn btn-info" value="공구권한신청" style="width:180px;"></a>
				</li>
			</ul>
		</div>
	</div>
	<div id="content_div">
		<div id="best_member">
			<div id="best_member_title">
				<span style="color:black;font-size:24px;font-weight: bold;">회원공구 베스트</span>
			</div>
			<div id="best_member1" style="border-radius:5px;background-color: white;">
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
			<div id="best_member2" style="border-radius:5px;background-color: white;">
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
			<div id="best_member3" style="border-radius:5px;background-color: white;">
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
		<div id="best_admin">
			<div id="best_admin_title">
				<span style="color:black;font-size:24px;font-weight: bold;">이번주 운영자추천 공구베스트</span>
			</div>
			<div id="best_admin1" style="background-color: white;">
				<div class="member_img">
					<a href="<c:url value='/gonggu/gonggu_detail?num=142'/>"><img src="/resources/gonggu_uploadImg/iphone.jpg" style="width:230px;height:120px;border-radius:5px;"></a>
				</div>
				<div class="member_content">
					<br>
					<a href=""><span style="color:blue;font-weight: bold;font-size: 18px;">아이폰7 공동구매</span></a><br>
					<span>저렴한 가격으로 최신폰을 구입하세요!</span>
				</div>
			</div>
			<div id="best_admin2" style="background-color: white;">
				<div class="member_img">
					<a href="<c:url value='/gonggu/gonggu_detail?num=61'/>"><img src="/resources/gonggu_uploadImg/chair.jpg" style="width:230px;height:120px;border-radius:5px;"></a>
				</div>
				<div class="member_content">
					<br>
					<a href=""><span style="color:blue;font-weight: bold;font-size: 18px;">편안한의자 공동구매</span></a><br>
					<span>스타일리쉬한 의자!</span>
				</div>
			</div>
			<div id="best_admin3" style="background-color: white;">
				<div class="member_img">
					<a href="<c:url value='/gonggu/gonggu_detail?num=63'/>"><img src="/resources/gonggu_uploadImg/shoes.jpg" style="width:230px;height:120px;border-radius:5px;"></a>
				</div>
				<div class="member_content">
					<br>
					<a href=""><span style="color:blue;font-weight: bold;font-size: 18px;">닥터마틴 입고!</span></a><br>
					<span>어느 옷에도 잘 어울리는 신발!</span>
				</div>
			</div>
		</div>
	</div>
</div>
