<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/cs.css">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#consult").click(function(){
			if($("#s_id").text()==""){
				alert("로그인을 해주세요");
				return false
			}
		});
		$("#consult_list").click(function(){
			if($("#s_id").text()==""){
				alert("로그인을 해주세요");
				return false
			}
		});
	});
</script>
	<div id="cs_wrap">
		<div id="cs_left">
			<div id="cs_menu">
				<div id="cs_title">
					<h4 class="page-header">고객센터</h4>
				</div>
				<ul id="cs_menus_out">
					<li value="1"  class="alert alert-success">
						<a href="cs_main">FAQ</a>
						<ul id="cs_menus_in" style="background-color: white;">
							<c:forEach var="category_vo" items="${get_faq_category }">
								<li id="${category_vo.cs_faq_category_code }">
								<a href="cs_list?category=${category_vo.cs_faq_category_code }" class="cs_menus">${category_vo.cs_faq_category_name }</a>
								</li>
							</c:forEach>
						</ul>
					</li>
					<li class="alert alert-success"><a>1:1문의 상담</a>
						<ul id="cs_menus_in" style="background-color: white">
							<li id="consult"><a href="cs_consult">상담하기</a><span id="s_id" style="display:none">${get_id }</span></li>
							<li id="consult_list"><a href="cs_consult_list">문의내역</a></li>
						</ul>
					</li>
					<li class="alert alert-success"><a href="<c:url value='/cs/cs_notice'/>"> 공지사항</a></li>
					<li class="alert alert-success"><a href="cs_info">이용안내</a></li>
				</ul>
			</div>
		</div>
		<div id="cs_right">
			<div id="cs_notice_detail">
				<div id="notice_detail_title">
				<span>공지사항</span>
				</div>
				<div id="cs_infos">
				<table>	 
					<tr>
						<th width="20%">${vo.cs_notice_category }</th>	
						<th width="60%">${vo.cs_notice_title }</th>		
						<th width="20%">${vo.cs_notice_w_date }</th>
					</tr>
				</table>
				</div>
				<div id="cont">
					${vo.cs_notice_content }					
				</div>
				<br>
				<a href="cs_notice"><input type="button" value="목록" id="listbtn"></a>
			</div>
		</div>
	</div>
				
				
				
				
				
				