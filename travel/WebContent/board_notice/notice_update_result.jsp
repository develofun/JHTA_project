<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<c:choose>
		<c:when test="${result=='success' }">
			<h1 style="width:550px;">작업이 성공적으로 이루어졌습니다.</h1>
		</c:when>
		<c:otherwise>
			<h1 style="width:550px;">오류로 인해 작업이 실패하였습니다.</h1>
		</c:otherwise>
	</c:choose>
	<a href="/notice.do?cmd=notice_detail&notice_num=${dto.notice_num }" style="text-decoration:none">상세페이지로...</a>
</div>