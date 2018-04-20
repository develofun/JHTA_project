<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/cs.css">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".ing_table_title").click(function(){
		if($(this).parents("tr").next().css("display")=="none"){
			$(".consult_content").css('display','none');
			$(this).parents("tr").next().css('display','table-row');
		}else{
			$(".consult_content").css('display','none');
		}
	});
	$(".end_table_title").click(function(){
		if($(this).parents("tr").next().css("display")=="none"){
			$(".consult_content_end").css('display','none');
			$(this).parents("tr").next().css('display','table-row');
			var consult_num=$(this).prev("th").text();
			$.ajax({
			type: "post",
			url:"cs_consult_list",
			data:"consult_num="+consult_num,
			dataType : 'json',
				success:function(data){
					$("#cs_consult_answer").html(data.consult_answer);
				}
			});
		}else{
			$(".consult_content_end").css('display','none');
		}
	});
	$("#consult_del").click(function(){
		var consult_num_del=$(this).parents("tr").prev("tr").children().eq(0).text();
		$.ajax({
			type: "post",
			url:"cs_consult_list",
			data:"consult_num_del="+consult_num_del,
			dataType:'json',
				success:function(data){
					alert("선택하신 문의가 삭제되었습니다.");
					location.reload();
				}
			});
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
			<div id="consult_list_main">
				<h1>문의 내역</h1>
				<div id="consult_list_ing">
					<h2>처리 중인 문의</h2>
					<table id="consult_ing_table">
						<tr>
							<th class="ing_table_num">문의 번호</th>
							<th class="ing_table_title">제목</th>
						</tr>
						<c:forEach var="vo" items="${get_consult_ing }">
							<tr>
							<th class="ing_table_num">${vo.cs_consult_num }</th>
							<th class="ing_table_title">${vo.cs_consult_title }</th>
							</tr>
							<tr class="consult_content" style="display:none">
							<th colspan="2">
								<div id="consult_content">
									<div id="cs_consult_content">
										${vo.cs_consult_content }
									</div>
									<div id="consult_buttons">
									<input type="button" value="삭제" id="consult_del">
									</div>
								</div>
							</th>
							</tr>
						</c:forEach>
					</table>
					<div id=consult_ing_paging>
						<c:if test="${pu_ing_totalPage>=6 }">
						<a href="cs_consult_list?pagePre5_ing=${pu_ing_pageNum }"><span style="color: #333;">[<<]</span></a>
						</c:if>
						<c:forEach var="i" begin="${pu_ing_startPage }" end="${pu_ing_endPage }">
							<c:choose>
								<c:when test="${i==0}"></c:when>
								<c:when test="${i==pu_ing_pageNum}">
									<a href="cs_consult_list?pageNum_ing=${i }"><span style="color: red;">[${i }]</span></a>
								</c:when>
								<c:otherwise>
									<a href="cs_consult_list?pageNum_ing=${i }"><span style="color: #333;">[${i }]</span></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pu_ing_totalPage>=6 }">
						<a href="cs_consult_list?pageNext5_ing=${pu_ing_pageNum }"><span style="color: #333;">[>>]</span></a>
						</c:if>
					</div>
				</div>
				<div id="consult_list_end">
					<h2>처리 완료 문의</h2>
					<table id="consult_end_table">
					<tr>
							<th class="end_table_num">문의 번호</th>
							<th class="end_table_title">제목</th>
							<th class="end_table_chk">확인여부</th>
						</tr>
						<c:forEach var="vo" items="${get_consult_end }">
							<tr>
							<th class="end_table_num">${vo.cs_consult_num }</th>
							<th class="end_table_title">${vo.cs_consult_title }</th>
							<th class="end_table_chk">${vo.cs_consult_answercheck }</th>
							</tr>
							<tr class="consult_content_end" style="display:none">
							<th colspan="3">
								<div id="consult_content">
									<div id="cs_consult_content">
										${vo.cs_consult_content }
									</div>
									<div id="cs_consult_answer">
									</div>
								</div>
							</th>
							</tr>
						</c:forEach>
					</table>
					<div id=consult_end_paging>
						<c:if test="${pu_end_totalPage>=6 }">
						<a href="cs_consult_list?pagePre5_end=${pu_end_pageNum }"><span style="color: #333;">[<<]</span></a>
						</c:if>
						<c:forEach var="i" begin="${pu_end_startPage }" end="${pu_end_endPage }">
							<c:choose>
								<c:when test="${i==0}"></c:when>
								<c:when test="${i==pu_end_pageNum}">
									<a href="cs_consult_list?pageNum_end=${i }"><span style="color: red;">[${i }]</span></a>
								</c:when>
								<c:otherwise>
									<a href="cs_consult_list?pageNum_end=${i }"><span style="color: #333;">[${i }]</span></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pu_end_totalPage>=6 }">
						<a href="cs_consult_list?pageNext5_end=${pu_end_pageNum }"><span style="color: #333;">[>>]</span></a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
</div>