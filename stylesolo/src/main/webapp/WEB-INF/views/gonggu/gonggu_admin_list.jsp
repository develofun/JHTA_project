<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_member_list.css" type="text/css">

<div id="wrap">
	<div id="memberlist">
	
		<div id="best_member_alldiv">
			<h2>운영자 추천 공구 베스트 3</h2>
			<div class="best_member">
				<div class="member_img">
					<a href="<c:url value='/gonggu/gonggu_detail?num=65'/>"><img src="/resources/img/testimg.jpg"></a>
				</div>
				<div class="member_content">
					<a href="">공구구매테스트1</a><br>
					<span>내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트</span>
				</div>
			</div>
			<div class="best_member">
				<div class="member_img">
					<a href=""><img src="/resources/img/testimg.jpg"></a>
				</div>
				<div class="member_content">
					<a href="">공구베스트타이틀</a><br>
					<span>내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트</span>
				</div>
			</div>
			<div class="best_member">
				<div class="member_img">
					<a href=""><img src="/resources/img/testimg.jpg"></a>
				</div>
				<div class="member_content">
					<a href="">공구베스트타이틀</a><br>
					<span>내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트내용테스트</span>
				</div>
			</div>
		</div>
		<div id="member_list_all">
		
			<h2>전체 운영자추천공구 리스트</h2>
			
			<c:forEach var="vo" items="${memberlist }">
				<div class="list_all_member" align="center">
				
					<img src="/resources/upload/${vo.gonggu_img_sname }" style="width:200px;height:250px;border:1px solid black;"><br>
					<span id="gonggu_detail_title_span"><a href="<c:url value='/gonggu/gonggu_detail?num=${vo.gonggu_insert_num }'/>">${vo.gonggu_insert_title }</a></span><br>
					<span id="gonggu_detail_content_span" style="color:black;">${vo.gonggu_insert_content }</span>
					
				</div>
			</c:forEach>
		
		</div>
		
	</div>
</div>