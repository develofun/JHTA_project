<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		$()
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
			<div id="cs_notice">
					<div id="notice_title" style="margin-top:30px">
						<span class="page-header">공지사항</span>
					</div>
					<div id="notice_table_div">
						<table id="notice_table" class="table table-bordered">
							<tr style="text-align:center">
								<th width="10%">번호</th>
								<th width="10%">구분</th>
								<th width="50%">제목</th>
								<th width="10%">조회수</th>
								<th width="20%">작성일</th>
							</tr>
							<c:forEach var="vo" items="${CsNoticeList }">
								<tr>
									<td>${vo.cs_notice_num }</td>
									<td>${vo.cs_notice_category }</td>
									<td><a href="notice_detail?num=${vo.cs_notice_num }">${vo.cs_notice_title }</a></td>
									<td>${vo.cs_notice_hit }</td>
									<td>${vo.cs_notice_w_date }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div id="paging" style="margin-bottom:10px">
						<a href="cs_notice?pagePre10=${pu.pageNum-10 }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
							<input type="button" class="btn btn-default" value="<<">
						</a>
						<a href="cs_notice?pagePre=${pu.pageNum-1 }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
							<input type="button" class="btn btn-default" value="이전">
						</a>
						<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
							<c:choose>
								<c:when test="${i==0}"></c:when>
								<c:when test="${i==pu.pageNum}">
									<a href="cs_notice?pageNum=${i }&category=${category }&search=${search }">
										<input type="button" class="btn btn-warning" value="${i }">
									</a>
								</c:when>
								<c:otherwise>
									<a href="cs_notice?pageNum=${i }&category=${category }&search=${search }">
										<input type="button" class="btn btn-default" value="${i }">
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<a href="cs_notice?pageNext=${pu.pageNum+1 }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
							<input type="button" class="btn btn-default" value="다음">
						</a>
						<a href="cs_notice?pageNext10=${pu.pageNum+10 }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
						<input type="button" class="btn btn-default" value=">>"></a>
					</div>
					
				<div class="form-inline" style="margin-bottom:30px">
					<form action="cs_notice" method="get">
					<select class="form-control" name="cate" size="1">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" id="srch" class="form-control" name="search" value="${search }">
					<input type="submit" class="btn btn-primary" value="검색" id="btns">
					</form>
				</div>
				
			</div>
		</div>
	</div>