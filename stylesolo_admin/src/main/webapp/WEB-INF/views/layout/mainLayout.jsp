<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>StyleSolo Admin Page</title>
<link rel="icon" href="/resources/image/favicon-16x16.png" sizes="16x16" type="image/png">
<!-- 부트스트랩 css -->
<link href="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- 메인 레이아웃 css -->
<link href="/resources/css/mainLayout.css" rel="stylesheet">
<!-- 테이블 display 관리 css -->
<link href="/resources/css/table.css" rel="stylesheet">
<!-- 회원 관리 css -->
<link href="/resources/css/member.css" rel="stylesheet">
<script src="/webjars/jquery/3.1.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="wrap">
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<nav id="sidebar">
			<tiles:insertAttribute name="sidebar" />
		</nav>
		<article id="content">
			<tiles:insertAttribute name="content" />
		</article>
		<%-- <div id="main-footer">
			<tiles:insertAttribute name="footer"/>
		</div> --%>
	</div>
</body>
</html>
