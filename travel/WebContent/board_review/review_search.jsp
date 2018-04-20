<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="board_ksw_subject">
		<div class="board_ksw_subject_title" style="text-align: left;">&nbsp;&nbsp;리뷰 게시판입니다.</div>
		<div class="board_ksw_subject_content" style="text-align: left;">
		다녀왔던 여행지를 소개할 수 있는 게시판입니다.<br>
		모든 회원은 자유롭게 작성할 수 있으니 즐거운 후기 부탁드립니다.
		</div>	
</div>
<div class="list_all">
	<div class="top_tep_background">
		<div class="top_tep">
			<ul class="top_col">
			  <li class="top_li"><a class="top_a" onmouseover="hit10()">조회</a></li>
			  <li class="top_li"><a class="top_a" onmouseover="comment10()">댓글</a></li>
			</ul>
		</div>
		<div class="best_list">
			<div id="titlelist_hit1" style="float: left; width: 50%"></div>	
			<div id="titlelist_hit2" style="float: left; width: 50%"></div>	
		</div>
		<div class="review_create_link">
			<input type="button" id="btn_write" value="글쓰기" onclick="javascript:location.href='/review.do?cmd=review_create_page'">
		</div>
	</div>
		<div class="board_ksw_tab">
		<ul>
			<li><a href="/review.do?cmd=review_read" class="board_tab">전체</a></li>
			<li><a href="/review.do?cmd=review_search&review_search_option=review_category&review_search_text=국내" class="board_tab">국내</a></li>
			<li><a href="/review.do?cmd=review_search&review_search_option=review_category&review_search_text=해외" class="board_tab">해외</a></li>
		</ul>
	</div>
	<div class="review_list_view">
		<table class="table_ksw">
			<tr class="tr_ksw">
			    <th class="th_ksw" style="width:50px">No</th>
			    <th class="th_ksw" style="width:300px">분류</th>
			    <th class="th_ksw" style="width:2000px">제목</th>
			    <th class="th_ksw" style="width:600px">글쓴이</th>
			    <th class="th_ksw" style="width:300px">작성일</th>
			    <th class="th_ksw" style="width:300px">조회수</th>
		  	</tr>
		  <c:forEach var="dto" items="${list }">
		  	<tr class="tr_ksw">
		  		<td class="td_ksw">${dto.review_num }</td>
		  		<td td class="td_ksw">${dto.review_category }</td>
		  		<!-- 제목'...'처리 -->
		  		<td class="td_ksw">
		  		<c:choose>
           			<c:when test="${fn:length(dto.review_title) > 30}">
	  					<a href="/review.do?cmd=detail&num=${dto.review_num }">${fn:substring(dto.review_title,0,13)}....</a>
	  				</c:when>
	  				<c:otherwise>
            			<a href="/review.do?cmd=detail&num=${dto.review_num }">${dto.review_title }</a>
           			</c:otherwise> 
	  			</c:choose>
	  			</td>
	  			
		  		<td class="td_ksw">${dto.review_writer }</td>
		  		<td class="td_ksw">${fn:substring(dto.review_w_date,0,16)}</td>
		  		<td class="td_ksw">${dto.review_hit }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	<div class="list_footer">	
	<div><!-- 페이징 처리 -->
<div class="board_ksw_paging">	
	<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${startPage>10 }">
				<input type="button" value=" ≪ " onclick="javascripte:location.href='/review.do?cmd=review_search&pageNum=${startPage-1 }&review_search_option=${review_search_option}&review_search_text=${review_search_text}'">			
				</c:when>
				<c:otherwise>
				<input type="button" value=" ≪ ">			
				</c:otherwise>
			</c:choose>
			
			<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${pageNum>1 }">
				<input type="button" value=" 이전 " onclick="javascripte:location.href='/review.do?cmd=review_search&pageNum=${pageNum-1 }&review_search_option=${review_search_option}&review_search_text=${review_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 이전 ">
				</c:otherwise>
			</c:choose>
			
			<!-- 페이징 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }"><a href=""><span style="color:red;font-weight:bold">[${i}]</span></a></c:when>
					<c:otherwise><a href="/review.do?cmd=review_search&pageNum=${i }
										&review_search_option=${review_search_option}
										&review_search_text=${review_search_text}">[${i}]</a></c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 버튼 조건절 : 2페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${endPage>1 }">
				<input type="button" value=" 다음 " onclick="javascripte:location.href='/review.do?cmd=review_search&pageNum=${pageNum+1 }&review_search_option=${review_search_option}&review_search_text=${review_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 다음 ">
				</c:otherwise>
			</c:choose>
			
			<!-- >> 버튼 조건절 : 11페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${pageCount>10 }">			
					<input type="button" value=" ≫ " onclick="javascripte:location.href='/review.do?cmd=review_search&pageNum=${endPage+1 }&review_search_option=${review_search_option}&review_search_text=${review_search_text}'">			
				</c:when>
				<c:otherwise>
					<input type="button" value=" ≫ ">
				</c:otherwise>
			</c:choose>
			<div style="float:right">
				<select id="rowCount_change" onchange="location.href='/review.do?cmd=review_search&pageNum=${pageNum }&review_search_option=${review_search_option}&review_search_text=${review_search_text}&rowCount='+this.value">
					<option value="10">10개</option>
					<option value="15">15개</option>
					<option value="20">20개</option>
					<option value="25">25개</option>
					<option value="30">30개</option>
				</select>	
			</div>
		</div>	
		<div class="review_list_serch"><!-- 리스트 하단 검색 -->
			<div class="search_wrapper">
				<form name="board_search" method="post" action="/review.do">
					<input type="hidden" name="cmd" value="review_search">
					<select class="search_select col" name="review_search_option">
						<option value="review_writer">작성자</option>
						<option value="review_title">제목</option>
					</select>
					<input type="text" class="search_input col" name="review_search_text">
					<input type="submit" class="search_btn col" value="검색">
				</form>
			</div>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
//window.onload 다중실행
function addLoadEvent(func) {
    var oldonload = window.onload;
        if(typeof window.onload != 'function') {
            window.onload = func;
        } else {
            window.onload = function() {
                oldonload();
                func();
        }
    }
}

function hit10(){
	showList();

}
function comment10(){
	showList1();
}

//조회수 높은 게시물 list 10개 가져오기
var xhr1=null;
function showList(){
	xhr1=new XMLHttpRequest();
	xhr1.onreadystatechange=list;
	xhr1.open("get","/review.do?cmd=hit_top10",true);
	xhr1.send();
}
function list(){
	if(xhr1.readyState==4 && xhr1.status==200){
		var xml=xhr1.responseXML;
		//list갯수 얻어오기(sql에서 10개만 뽑아옴)
		var data_length=xml.getElementsByTagName("data").length;
		var titlelist_hit1=document.getElementById("titlelist_hit1");
		var titlelist_hit2=document.getElementById("titlelist_hit2");
		titlelist_hit1.innerHTML=""; 
		titlelist_hit2.innerHTML=""; 
		for(var i=0;i<5;i++){
			var review_num=xml.getElementsByTagName("review_num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/review.do?cmd=detail&review_num="+review_num+"'style=text-decoration:none>"+title+"</a>"; 
			div.innerHTML=html;		 
			div.className="titlelist_hit1";
			titlelist_hit1.appendChild(div); 	
		}
		for(var i=5;i<10;i++){
			var review_num=xml.getElementsByTagName("review_num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/review.do?cmd=detail&review_num="+review_num+"'style=text-decoration:none>"+title+"</a>";
			div.innerHTML=html;		 
			div.className="titlelist_hit2";
			titlelist_hit2.appendChild(div); 	
		}
	}
}
//댓글 높은 게시물 list 10개 가져오기
function showList1(){
	xhr1=new XMLHttpRequest();
	xhr1.onreadystatechange=list1;
	xhr1.open("get","/review.do?cmd=comment_top10",true);
	xhr1.send();
}
function list1(){
	if(xhr1.readyState==4 && xhr1.status==200){
		var xml=xhr1.responseXML;
		//list갯수 얻어오기(sql에서 10개만 뽑아옴)
		var data_length=xml.getElementsByTagName("data").length;
		var titlelist_hit1=document.getElementById("titlelist_hit1");
		var titlelist_hit2=document.getElementById("titlelist_hit2");
		titlelist_hit1.innerHTML=""; 
		titlelist_hit2.innerHTML=""; 
		for(var i=0;i<5;i++){
			var review_num=xml.getElementsByTagName("review_num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/review.do?cmd=detail&review_num="+review_num+"'style=text-decoration:none>"+title+"</a>"; 
			div.innerHTML=html;		 
			div.className="titlelist_hit1";
			titlelist_hit1.appendChild(div); 	
		}
		for(var i=5;i<10;i++){
			var review_num=xml.getElementsByTagName("review_num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/review.do?cmd=detail&review_num="+review_num+"'style=text-decoration:none>"+title+"</a>";
			div.innerHTML=html;		 
			div.className="titlelist_hit2";
			titlelist_hit2.appendChild(div); 	
		}
	}
}
function tab(){
	var board_tab=document.getElementsByClassName("board_tab");
	for(var i=0;i<board_tab.length;i++){
		if(board_tab[i].innerHTML=="${review_search_text}"){
			board_tab[i].className="clicked";
			return;
		}
	}
	board_tab[0].className="clicked";
	var select_count=document.getElementById("rowCount_change");
	select_count.value="${rowCount}";
}
tab();

function login_check(){
	var btn_write=document.getElementById("btn_write");
	if("${sessionScope.member_nickname }"==""){
		btn_write.style.display="none";
	}
}

addLoadEvent(showList);
addLoadEvent(login_check);

</script>