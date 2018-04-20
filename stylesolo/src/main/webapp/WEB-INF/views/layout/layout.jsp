<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Style Solo</title>

<link rel="stylesheet" href="/resources/css/main/header.css" type="text/css">
<link rel="stylesheet" href="/resources/css/main/footer.css" type="text/css">
<link rel="stylesheet" href="/resources/css/main/table.css" type="text/css">
<link rel="stylesheet" href="/resources/css/main/main.css" type="text/css">
<link rel="stylesheet" href="/resources/css/member/member_join.css" type="text/css">
<link rel="stylesheet" href="/resources/css/recommend.css" type="text/css">
<link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/resources/css/navbar_techandall.css" type="text/css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="http://malsup.github.com/jquery.cycle2.js"></script>
<script src="/resources/js/jssor.slider-22.2.16.min.js" type="text/javascript"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
		  <!-- tiles-def.xml에 정의된 attribute name을 이용해 페이지를 포함함 -->
			<tiles:insertAttribute name="header"/>
		</div>
		<div id="contents">
			<tiles:insertAttribute name="content"/>
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
</body>
</html>