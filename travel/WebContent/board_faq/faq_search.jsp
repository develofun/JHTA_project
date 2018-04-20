<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="board_ldk" align="center">
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;FAQ 게시판입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		자주 묻는 질문에 대한 정보 안내 게시판입니다..<br>
		궁금한 점이 있으면 찾아보시고 추가 질문이나 정보 요청은
		Q&A 게시판에 문의해 주세요.
		</div>	
	</div>
	<div class="board_ldk_changeBoard">
		<ul>
			<li><a href="/qna.do?cmd=qna_read">Q&A</a></li>
			<li><a href="/faq.do?cmd=faq_read" class="clicked">FAQ</a></li>
		</ul>
	</div>
	<div class="board_ldk_tab">
		<ul>
			<li><a href="/faq.do?cmd=faq_read">전체</a></li>
			<li><a href="/faq.do?cmd=faq_search
						&faq_search_option=faq_category
						&faq_search_text=국내여행" class="board_tab()">국내여행</a></li>
			<li><a href="/faq.do?cmd=faq_search
						&faq_search_option=faq_category
						&faq_search_text=해외여행" class="board_tab()">해외여행</a></li>
			<li><a href="/faq.do?cmd=faq_search
						&faq_search_option=faq_category
						&faq_search_text=사이트 이용" class="board_tab()">사이트 이용</a></li>
			<li><a href="faq.do?cmd=faq_search
						&faq_search_option=faq_category
						&faq_search_text=로그인" class="board_tab()">로그인</a></li>
			<li><a href="faq.do?cmd=faq_search
						&faq_search_option=faq_category
						&faq_search_text=회원가입" class="board_tab()">회원가입</a></li>			
		</ul>
		<input type="button" id="btn_write" value="글쓰기" onclick="javascript:location.href='/faq.do?cmd=faq_create_page'">
	</div>
	
	<!-- 전체 리스트 출력 -->
	<div class="board_ldk_content">
		<table border="1">
			<thead>
				<tr>
				<th>질문</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }" begin="0" end="${rowCount-1 }">
					<tr>
					<th><a href="#" onclick="content_view(${dto.faq_num })">[Q][${dto.faq_category }]${dto.faq_title }</a></th>
					</tr>
					<tr id="faq_content${dto.faq_num }" class="tr_content" style="display:none">
					<td>
						<div style="float:left">└ [Q]</div>
						<div style="float:left">
							<div>
								${dto.faq_title }
							</div>
							<div>
								${dto.faq_content }
							</div>
							<div id="update_link">
								<a href="/faq.do?cmd=update&faq_num=${dto.faq_num }">[수정하기]</a>&nbsp;&nbsp;
								<a href="#" onclick="delete_confirm()">[삭제하기]</a>
							</div>
						</div>
					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>			
		<!-- 페이징 처리 -->
		<div class="board_ldk_paging">		
			<!-- << 버튼 조건절 : 11페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${startPage>10 }">
				<input type="button" value=" ≪ " onclick="javascripte:location.href='/faq.do?cmd=faq_search&pageNum=${startPage-1 }&faq_search_option=${faq_search_option}&faq_search_text=${faq_search_text}'">			
				</c:when>
				<c:otherwise>
				<input type="button" value=" ≪ ">			
				</c:otherwise>
			</c:choose>
			
			<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
			<c:choose>
				<c:when test="${pageNum>1 }">
				<input type="button" value=" 이전 " onclick="javascripte:location.href='/faq.do?cmd=faq_search&pageNum=${pageNum-1 }&faq_search_option=${faq_search_option}&faq_search_text=${faq_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 이전 ">
				</c:otherwise>
			</c:choose>
			
			<!-- 페이징 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${pageNum==i }"><a href=""><span style="color:red;font-weight:bold">[${i}]</span></a></c:when>
					<c:otherwise><a href="/faq.do?cmd=faq_search&pageNum=${i }
										&faq_search_option=${faq_search_option}
										&faq_search_text=${faq_search_text}">[${i}]</a></c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 버튼 조건절 : 2페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${endPage>1 }">
				<input type="button" value=" 다음 " onclick="javascripte:location.href='/faq.do?cmd=faq_search&pageNum=${pageNum+1 }&faq_search_option=${faq_search_option}&faq_search_text=${faq_search_text}'">
				</c:when>
				<c:otherwise>
				<input type="button" value=" 다음 ">
				</c:otherwise>
			</c:choose>
			
			<!-- >> 버튼 조건절 : 11페이지 이상 페이지 존재할 경우 작동 -->
			<c:choose>
				<c:when test="${pageCount>10 }">			
					<input type="button" value=" ≫ " onclick="javascripte:location.href='/faq.do?cmd=faq_search&pageNum=${endPage+1 }&faq_search_option=${faq_search_option}&faq_search_text=${faq_search_text}'">			
				</c:when>
				<c:otherwise>
					<input type="button" value=" ≫ ">
				</c:otherwise>
			</c:choose>
			<div style="float:right">
				<select id="rowCount_change" onchange="location.href='/faq.do?cmd=faq_search&pageNum=${pageNum }
														&faq_search_option=${faq_search_option}
														&faq_search_text=${faq_search_text}
														&rowCount='+this.value">
					<option value="10">10개</option>
					<option value="15">15개</option>
					<option value="20">20개</option>
					<option value="25">25개</option>
					<option value="30">30개</option>
				</select>	
			</div>
		</div>		
		<!-- 검색 -->
		<div class="board_ldk_search">
			<form action="/faq.do" method="post">
			<input type="hidden" name="cmd" value="faq_search">
			<select name="faq_search_option">
				<option value="faq_writer">작성자</option>
				<option value="faq_title">제목</option>
			</select>
			<input type="text" name="faq_search_text">
			<input type="submit" class="search_button" value="검색">
			</form>
		</div>
	</div>
</div>
<script>
	function tab(){
		var board_tab=document.getElementsByClassName("board_tab");
		for(var i=0;i<board_tab.length;i++){
			if(board_tab[i].innerHTML=="${faq_search_text}"){
				board_tab[i].className="clicked";
				return;
			}
		}
		board_tab[0].className="clicked";		
	}
	tab();
	function select(){
		var select_count=document.getElementById("rowCount_change");
		select_count.value=${rowCount };
	}
	select();
	
	var count=0;
	var temp_faq_num="";
	//게시물 제목 클릭 시 바로 밑 div 영역에 상세 내용 노출
	function content_view(faq_num){
		var tr=document.getElementsByClassName("tr_content");
		
		for(i=0;i<tr.length;i++){
			tr[i].style.display="none";
		}
		
		var tr_click=document.getElementById("faq_content"+faq_num);		
		
		//똑같은 게시물을 클릭하다가 count가 1인 상태에서 다른 게시물을 클릭하면 세부 내용 div가 열리지 않기 때문에 초기화 설정
		if(temp_faq_num!=faq_num){
			count=0;
			temp_faq_num=faq_num;
			} 
		if(count==0){			
			tr_click.style.display="block";
			count=1;
		}else{
			tr_click.style.display="none";
			count=0;
		}
	}
	
	function delete_confirm(){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href="/faq.do?cmd=deletete&faq_num=${dto.faq_num }";
		}
	}
	
	function login_check(){
		var btn_write=document.getElementById("btn_write");
		var update_link=document.getElementById("update_link");
		if("${sessionScope.member_nickname }"=="" || "${sessionScope.member_power}"=="agent"){
			btn_write.style.display="none";
			update_link.style.display="none";
		}
	}	
	login_check();
</script>