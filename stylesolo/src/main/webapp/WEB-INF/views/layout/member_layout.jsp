<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Style Solo-MYPAGE</title>

<link rel="stylesheet" href="/resources/css/main/header.css" type="text/css">
<link rel="stylesheet" href="/resources/css/member/member_detail_menu.css" type="text/css">
<link rel="stylesheet" href="/resources/css/member/member_detail.css" type="text/css">
<link rel="stylesheet" href="/resources/css/main/footer.css" type="text/css">

<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">


</head>
<body onload="init()">


	<div id="header" style="border-bottom:4px solid black;">
		<tiles:insertAttribute name="header"/>
	</div>
	
	<div id="contents" style="width:1000px;margin:auto;">
		<div id="leftmenu">
			<tiles:insertAttribute name="menu"/>
		</div>
		<div id="maincontents">
			<tiles:insertAttribute name="content"/>
		</div>
	</div>
	
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>


</body>
</html>