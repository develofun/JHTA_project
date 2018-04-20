<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_joinlist.css" type="text/css">

<div id="wrap">
	<div id="joinlist">
		<h1>내가구입한 공구history</h1>
		
		<c:forEach var="vo" items="${list }">
			<div id="${vo.gonggu_insert_num }" style="width:250px;height:350px;float:left;margin:40px;white-space:nowrap;
					overflow: hidden;text-overflow:ellipsis;border:1px solid gray;" align="center">
			
				<img src="/resources/upload/${vo.gonggu_img_sname }" style="width:200px;height:250px;border:1px solid black;"><br>
				<span id="gonggu_detail_title_span"><a href="<c:url value='/gonggu/gonggu_detail?num=${vo.gonggu_insert_num }'/>">${vo.gonggu_insert_title }</a></span><br>
				<span id="gonggu_detail_content_span" style="color:black;">${vo.gonggu_insert_content }</span>
				
			</div>
		</c:forEach>
		
		<br>
		<br>
	
	</div>
</div>