<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://java.sun.com/jstl/core_rt"%>
<link rel="stylesheet" type="text/css" href="/resources/css/cs.css">
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
		$("#w_consult").click(function(){
			if($("#s_id").text()==""){
				alert("로그인을 해주세요");
				return false
			}else{location.href="cs_consult";}
		});
		$("#go_notice").click(function(){location.href="cs_notice";});
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
			<div id="faq_search_wrap">
				<div class="form-inline">
					<form action="cs_list" method="get">
						<label class="label-control">FAQ 검색</label><input type="text" id="faq_search_in" class="form-control" name="search">
						<input type="submit" value="검색" id="faq_search_button" class="btn btn-primary">
					</form>
				</div>
				<div id="faq_keyword">
					<label id="faq_keyword_title">자주찾는 검색어 </label>
					<span class="glyphicon glyphicon-play"></span>
					<span>
					 <a href="cs_list?search=배송">배송</a> | <a href="cs_list?search=결제">결제</a>
					 | <a href="cs_list?search=교환">교환</a> | <a href="cs_list?search=환불">환불</a> 
					 | <a href="cs_list?search=마일리지">마일리지</a> | <a href="cs_list?search=쿠폰">쿠폰</a>
					</span>
				</div>
			</div>
			<div class="display-table-row">
				<div class="display-table-cell" style="width:390px">
					<div class="alert alert-danger" style="font-size:1.5em">FAQ Best</div>
					<table class="table">
						<c:forEach var="vo" items="${faq_hits }">
							<tr>
							<td style="text-align:center"><a href="cs_list?faq_num=${vo.cs_faq_num }&category=${vo.cs_faq_category }">${vo.cs_faq_question }</a></td></tr>
						</c:forEach>
					</table>
				</div>
				<div class="display-table-cell" style="width:390px">
					<div class="alert alert-danger" style="font-size:1.5em">FAQ New</div>
					<table class="table">
						<c:forEach var="vo" items="${faq_new }">
							<tr>
							<td style="text-align:center"><a href="cs_list?faq_num=${vo.cs_faq_num }&category=${vo.cs_faq_category }">${vo.cs_faq_question }</a></td></tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="form-group">
				<table class="table table-responsive">
					<tr>
						<td align="left">
							<h3>1:1 문의 상담</h3>
							<p>
							StyleSolo는 회원님과 원활하게 소통하기 위해 1:1 문의 게시판을 운영하고 있습니다.<br>
							FAQ를 통해 안내받으신 내용 외에 더 궁금하신 사항이 있으실 경우 1:1 문의에 글을 남겨주세요
							</p>
						</td>
						<td style="vertical-align:inherit;">
							<input type="button" class="btn btn-primary btn-lg" value="1:1 문의 작성" id="w_consult">
						</td>
					</tr>
					<tr><td colspan="2"></td></tr>
				</table>
				<table class="table table-responsive">
					<tr>
						<td  style="vertical-align:inherit;" align="left">
							<h3>공지 사항</h3>
						</td>
						<td></td>
						<td style="vertical-align:inherit;">
							<input type="button" class="btn btn-default btn_sm" value="더보기" id="go_notice">
						</td>
					</tr>
					<tr>
						<td>2017 / 01 / 01</td>
						<td colspan="2">공지사항 1</td>
					</tr>
					<tr>
						<td>2017 / 01 / 01</td>
						<td colspan="2">공지사항 1</td>
					</tr>
					<tr>
						<td>2017 / 01 / 01</td>
						<td colspan="2">공지사항 1</td>
					</tr>
				</table>
			</div>
		</div>
	</div>