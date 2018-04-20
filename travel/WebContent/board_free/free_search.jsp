<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

var xhr1=null;
function showList(){
	xhr1=new XMLHttpRequest();
	xhr1.onreadystatechange=list;
	xhr1.open("get","/free.do?cmd=hit_top10",true);
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
			var num=xml.getElementsByTagName("num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/free.do?cmd=detail&num="+num+"'>"+title+"</a>"; 
			div.innerHTML=html;		 
			div.className="titlelist_hit1";
			titlelist_hit1.appendChild(div); 	
		}
		for(var i=5;i<10;i++){
			var num=xml.getElementsByTagName("num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/free.do?cmd=detail&num="+num+"'>"+title+"</a>";
			div.innerHTML=html;		 
			div.className="titlelist_hit2";
			titlelist_hit2.appendChild(div); 	
		}
	}
}
function showList1(){
	xhr1=new XMLHttpRequest();
	xhr1.onreadystatechange=list1;
	xhr1.open("get","/free.do?cmd=comment_top10",true);
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
			var num=xml.getElementsByTagName("num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/free.do?cmd=detail&num="+num+"'>"+title+"</a>"; 
			div.innerHTML=html;		 
			div.className="titlelist_hit1";
			titlelist_hit1.appendChild(div); 	
		}
		for(var i=5;i<10;i++){
			var num=xml.getElementsByTagName("num")[i].firstChild.nodeValue;
			var title=xml.getElementsByTagName("title")[i].firstChild.nodeValue;
			var div=document.createElement("div");
			var html="<a href='/free.do?cmd=detail&num="+num+"'>"+title+"</a>";
			div.innerHTML=html;		 
			div.className="titlelist_hit2";
			titlelist_hit2.appendChild(div); 	
		}
	}
}

function select(){
	var select_count=document.getElementById("rowCount_change");
	select_count.value="${rowCount}";
}

function login_check(){
	var btn_write=document.getElementById("btn_write");
	if("${sessionScope.member_nickname }"==""){
		btn_write.style.display="none";
	}
}

addLoadEvent(showList);
addLoadEvent(login_check);

</script>

<div class="free_list_all">
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;자유게시판 입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		자유롭게 쓰고 싶은 글을 쓰는 게시판입니다..<br>
		
		</div>	
	</div>
	<div class="top_tep_background">
		<div class="top_tep">
			<ul class="top_col">
			  <li class="top_li"><a class="top_a"  onmouseover="hit10()">조회</a></li>
			  <li class="top_li"><a class="top_a" onmouseover="comment10()">댓글</a></li>
			</ul>
		</div>
		<div class="free_best_list">
		<div id="titlelist_hit1" style="float: left; width: 50%"></div>	
		<div id="titlelist_hit2" style="float: left; width: 50%"></div>	
		</div>
	</div>
	<div class="free_list_view">
		<table class="free_list_table">
			<tr class="free_list_table_tr">
			    <th class="free_list_table_th">No</th>
			    <th>제목</th>
			    <th>글쓴이</th>
			    <th>작성일</th>
			    <th>조회수</th>
		  	</tr>
		  <c:forEach var="dto" items="${list }">
		  	<tr>
		  		<td>${dto.free_num }</td>
		  		<!-- 제목'...'처리 -->
		  		<td>
		  		<c:choose>
           			<c:when test="${fn:length(dto.free_title) > 30}">
	  					<a href="/free.do?cmd=detail&num=${dto.free_num }">${fn:substring(dto.free_title,0,13)}....</a>
	  				</c:when>
	  				<c:otherwise>
            			<a href="/free.do?cmd=detail&num=${dto.free_num }">${dto.free_title }</a>
           			</c:otherwise> 
	  			</c:choose>
	  			</td>
		  		<td>${dto.free_writer }</td>
		  		<td>${fn:substring(dto.free_w_date,0,16)}</td>
		  		<td>${dto.free_hit }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	<div class="free_list_footer">	
		<div class="free_create_link">
		<input type="button" id="btn_write" value="글쓰기" onclick="javascript:location.href='/free.do?cmd=free_create_page'">
		</div>
		</div><!-- 페이징 처리 -->
<div class="board_ldk_paging">	
	<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${startPage>10 }">
				<input type="button" value=" ≪ " onclick="javascripte:location.href='/free.do?cmd=free_search&pageNum=${startPage-1 }&free_search_option=${free_search_option}&free_search_text=${free_search_text}'">			
				</c:when>
				<c:otherwise>
				<input type="button" value=" ≪ ">			
				</c:otherwise>
			</c:choose>
			
			<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${pageNum>1 }">
				<input type="button" value=" 이전 " onclick="javascripte:location.href='/free.do?cmd=free_search&pageNum=${pageNum-1 }&free_search_option=${free_search_option}&free_search_text=${free_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 이전 ">
				</c:otherwise>
			</c:choose>
			
			<!-- 페이징 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }"><a href=""><span style="color:red;font-weight:bold">[${i}]</span></a></c:when>
					<c:otherwise><a href="/free.do?cmd=free_search&pageNum=${i }
										&free_search_option=${free_search_option}
										&free_search_text=${free_search_text}">[${i}]</a></c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 버튼 조건절 : 2페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${endPage>1 }">
				<input type="button" value=" 다음 " onclick="javascripte:location.href='/free.do?cmd=free_search&pageNum=${pageNum+1 }&free_search_option=${free_search_option}&free_search_text=${free_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 다음 ">
				</c:otherwise>
			</c:choose>
			
			<!-- >> 버튼 조건절 : 11페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${pageCount>10 }">			
					<input type="button" value=" ≫ " onclick="javascripte:location.href='/free.do?cmd=free_search&pageNum=${endPage+1 }&free_search_option=${free_search_option}&free_search_text=${free_search_text}'">			
				</c:when>
				<c:otherwise>
					<input type="button" value=" ≫ ">
				</c:otherwise>
			</c:choose>
			<div style="float:right">
				<select id="rowCount_change" onchange="location.href='/free.do?cmd=free_search&pageNum=${pageNum }&free_search_option=${free_search_option}&free_search_text=${free_search_text}&rowCount='+this.value">
					<option value="10">10개</option>
					<option value="15">15개</option>
					<option value="20">20개</option>
					<option value="25">25개</option>
					<option value="30">30개</option>
				</select>	
			</div>
		</div>	
		<div class="free_list_serch"><!-- 리스트 하단 검색 -->
			<div class="search_wrapper">
				<form name="board_search" method="post" action="/free.do">
					<input type="hidden" name="cmd" value="free_search">
					<select class="search_select col" name="free_search_option">
						<option value="free_writer">작성자</option>
						<option value="free_title">제목</option>
					</select>
					<input type="text" class="search_input col" name="free_search_text">
					<input type="submit" class="search_btn col" value="검색">
				</form>
			</div>
		</div>
	</div>
</div>
