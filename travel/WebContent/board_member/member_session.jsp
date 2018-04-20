<%@page import="java.text.SimpleDateFormat"%> 
<%@page import="java.util.Date"%> 
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
// 로그인 일시
Date time = new Date();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
time.setTime(session.getCreationTime());
// 닉네임, 회원번호얻어오기
String member_nickname=(String)session.getAttribute("member_nickname");
String customer_num=(String)session.getAttribute("customer_num");
String member_power=(String)session.getAttribute("member_power");
%>
<h3>세션정보</h3>
<ul>
	<li><%=member_nickname %> 님 환영합니다.</li>
	<li>회원번호 : <%=customer_num %>
	<li>로그인 일시 : <%= formatter.format(time) %></li>
	<li>로그인 IP : <%= request.getRemoteAddr() %></li>
	<li>회원등급 : <%=member_power %></li>
	<li><a href="/board_member/member_logout.jsp">로그아웃</a></li>
</ul>
</body>
</html>