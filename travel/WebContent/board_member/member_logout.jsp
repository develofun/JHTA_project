<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//세션 무효화하기
	session.invalidate();//세션에 저장된 값이 모두 무효화됨
%>
</body>
<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href = "/move.do?cmd=main";	
</script>
</html>