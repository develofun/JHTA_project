<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/travel.css">
<link rel="stylesheet" type="text/css" href="/css/ldk.css">
<link rel="stylesheet" type="text/css" href="/css/ljh.css">
<link rel="stylesheet" type="text/css" href="/css/jsh.css">
<link rel="stylesheet" type="text/css" href="/css/ksw.css">
</head>
<body>
	<%
		String spage = (String) request.getAttribute("spage");
		String menuNum = (String) request.getAttribute("menuNum");
		if (spage == null) {
			spage = "mainpage.jsp";
		}
	%>
	<div id="wrap">
		<div class="header">
			<jsp:include page="header.jsp?menuNum=${menuNum}"></jsp:include>
		</div>
		<div class="contents">
			<jsp:include page="${cpage }"></jsp:include>
			<jsp:include page="${spage }"></jsp:include>
		</div>
		<div class="footer">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>