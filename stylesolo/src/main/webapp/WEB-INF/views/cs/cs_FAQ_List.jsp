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
		if($("#faq_length").text()<=5){
			$("#faq_ltable").css("height","550px");
		}
		$("#faq_answer_content").first().css("white-space","pre-line");
		$(".faq_tr").click(function(){
			if($(this).next().css("display")=="none"){
				$(".faq_answer").css('display','none');
				$(this).next().css('display','table-row');
				$.ajax({
					url:"cs_list?faq_num="+$(this).children().eq(0).text(),
					success:function(){}
				});
			}else{
				$(".faq_answer").css('display','none');
			}
		});
		for (var i= 0; i <= $(".faq_num").length; i++) {
			if($(".faq_num").eq(i).text()==$("#faq_num").text()){
				$(".faq_answer").css('display','none');
				$(".faq_num").eq(i).parents("tr").next().css('display','table-row');
			}
		}
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
				<div id="faq_search">
				<form action="cs_list" method="get">
					<span>FAQ 검색</span><input type="text" id="faq_search_in" name="search" value="${search }">
					<input type="submit" value="검색" id="faq_search_button">
				</form>
				</div>
				<div id="faq_keyword">
					<span id="faq_keyword_title">자주찾는 검색어 </span>
					<span>
					 | <a href="cs_list?search=배송">배송</a> | <a href="cs_list?search=결제">결제</a>
					 | <a href="cs_list?search=교환">교환</a> | <a href="cs_list?search=환불">환불</a> 
					 | <a href="cs_list?search=마일리지">마일리지</a> | <a href="cs_list?search=쿠폰">쿠폰</a>
					</span>
				</div>
			</div>
			<div id="faq_list">
					
					<div id="faq_ltable">
					<span style="color: red;">총 ${faq_count } 건의 </span><span>자주묻는 질문이 있습니다.</span>
					<span style="display: none" id="faq_ltable_menus">${category }</span>
					<span style="display: none" id="faq_num">${faq_num }</span>
					<span style="display: none;" id="faq_length">${faq_list.size() }</span>
					<table id="faq_list_table">
						<c:forEach var="vo" items="${faq_list }">
							<tr class="faq_tr"><th class="faq_num">${vo.cs_faq_num }</th>
							<th class="faq_th">
							<span>${vo.cs_faq_question}</span></th></tr>
							<tr class="faq_answer">
							<th colspan="2">
								<div id="faq_answer_image">
								</div>
								<div id="faq_answer_content">
									<p>${vo.cs_faq_answer }</p>
								</div>
							</th>
							</tr>
						</c:forEach>
					</table>
					</div>
					<div id="cs_faq_paging">
						<a href="cs_list?pagePre10=${pu.pageNum }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
							<input type="button" class="btn btn-default" value="<<">
						</a>
						<a href="cs_list?pagePre=${pu.pageNum-1 }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
							<input type="button" class="btn btn-default" value="이전">
						</a>
						<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
							<c:choose>
								<c:when test="${i==0}"></c:when>
								<c:when test="${i==pu.pageNum}">
									<a href="cs_list?pageNum=${i }&category=${category }&search=${search }">
										<input type="button" class="btn btn-warning" value="${i }">
									</a>
								</c:when>
								<c:otherwise>
									<a href="cs_list?pageNum=${i }&category=${category }&search=${search }">
										<input type="button" class="btn btn-default" value="${i }">
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<a href="cs_list?pageNext=${pu.pageNum+1 }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
							<input type="button" class="btn btn-default" value="다음">
						</a>
						<a href="cs_list?pageNext10=${pu.pageNum }&category=${category }&search=${search }&endPageNum=${pu.endPageNum}">
						<input type="button" class="btn btn-default" value=">>"></a>
					</div>
				</div>
			</div>
		</div>