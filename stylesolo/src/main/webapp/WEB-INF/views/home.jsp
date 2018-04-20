<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<ul>
	<li><a href="/list">리스트 보기</a></li>
	<li><a href="/insert">등록</a></li>
	<li><a href="/index">인덱스</a></li>
</ul>
</body>
</html>
