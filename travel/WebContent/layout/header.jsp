<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String menuNum = request.getParameter("menuNum");
%>
<div id="header_content">
	<div id="main_images">
		<a href="/move.do?cmd=main"><img src="https://aviation.blogactiv.eu/files/2015/07/blog-cover-boeing-03.png"></a>
	</div>
	<div id="menu">
		<ul>
			<li><a href="/move.do?cmd=kboard" <%if (menuNum.equals("10")) {%>class="on" <%}%>>국내여행</a></li>
			<li><a href="/move.do?cmd=fboard" <%if (menuNum.equals("20")) {%>class="on" <%}%>>해외여행</a></li>
			<li><a href="/move.do?cmd=free" <%if (menuNum.equals("30")) {%>class="on" <%}%>>자유게시판</a></li>
			<li><a href="/move.do?cmd=review" <%if (menuNum.equals("40")) {%>class="on" <%}%>>리뷰/후기</a></li>
			<li><a href="/move.do?cmd=market" <%if (menuNum.equals("50")) {%>class="on" <%}%>>중고장터</a></li>
			<li><a href="/move.do?cmd=eventSale" <%if (menuNum.equals("60")) {%> class="on" <%}%>>이벤트/할인</a></li>
			<li><a href="/move.do?cmd=qna" <%if (menuNum.equals("70")) {%>class="on" <%}%>>QnA</a></li>
			<li><a href="/move.do?cmd=notice" <%if (menuNum.equals("80")) {%> class="on" <%} %>>공지사항</a></li>
		</ul>
	</div>
</div>