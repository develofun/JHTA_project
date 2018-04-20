<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StyleSolo ADMIN Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- 테이블 display 관리 css -->
<link href="/resources/css/table.css" rel="stylesheet">
<script src="/webjars/jquery/3.1.1/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"></script>
<link rel="icon" href="/resources/image/favicon-16x16.png" sizes="16x16" type="image/png">
<style type="text/css">
.form-control{padding:6px 8px}
</style>
</head>
<body>
	<div class="wrapper">
		<tiles:insertAttribute name="login_or_join"/>		
	</div>
</body>
</html>