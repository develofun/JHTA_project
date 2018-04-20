<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;Q&A 게시판입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		이벤트/할인 정보를 공유하는 게시판입니다.<br>
		다양한 정보 공유 부탁 드립니다.
		</div>	
	</div>
	<div class="board_ldk_changeBoard">
		<ul>
			<li><a href="/qna.do?cmd=qna_read" class="clicked">Q&A</a></li>
			<li><a href="/faq.do?cmd=faq_read">FAQ</a></li>
		</ul>
		<input type="button" id="btn_write" value="글쓰기" onclick="javascript:location.href='/qna.do?cmd=qna_create_page'">
	</div>
	
	<!-- 전체 리스트 출력 -->
	<div class="board_ldk_content">
		<table border="1">
			<thead>
				<tr>
				<th style="width:100px">No</th>
				<th>제목</th>
				<th style="width:200px">작성자</th>
				<th style="width:400px">작성일</th>
				<th style="width:200px">조회수</th>
				<th style="width:200px">상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list }" begin="0" end="${rowCount-1 }">
					<tr>
						<td style="text-align:center;width:100px">${dto.qna_num }</td>
						<td>&nbsp;&nbsp;<a href="javascript:title_click(${dto.qna_num })">${dto.qna_title }</a><br>
						<span id="qna_content${dto.qna_num }"></span>
						<span id="qna_error${dto.qna_num }"></span>
						</td>
						<td style="text-align:center;width:100px">${dto.qna_writer }</td>
						<td style="text-align:center;width:300px">${dto.qna_w_date }</td>
						<td style="text-align:center;width:50px">${dto.qna_hit }</td>					
						<td style="text-align:center;width:60px">${dto.qna_state }</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	<!-- 페이징 처리 -->
	<div class="board_ldk_paging">
	
		<!-- << 버튼 조건절 : 11페이지 이후부터 이전 버튼 작동! -->
		<c:choose>
			<c:when test="${startPage>10 }">
			<input type="button" value=" ≪ " onclick="javascripte:location.href='/qna.do?cmd=qna_read&pageNum=${startPage-1 }&rowCount=${rowCount }'">			
			</c:when>
			<c:otherwise>
			<input type="button" value=" ≪ ">			
			</c:otherwise>
		</c:choose>
		
		<!-- 이전 버튼 조건절 : 2페이지 이후부터 이전 버튼 작동! -->
		<c:choose>
			<c:when test="${pageNum>1 }">
			<input type="button" value=" 이전 " onclick="javascripte:location.href='/qna.do?cmd=qna_read&pageNum=${pageNum-1 }&rowCount=${rowCount }'">
			</c:when>
			<c:otherwise>
			<input type="button" value=" 이전 ">
			</c:otherwise>
		</c:choose>
		
		<!-- 페이징 -->
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:choose>
				<c:when test="${pageNum==i }"><a href=""><span style="color:red;font-weight:bold">[${i}]</span></a></c:when>
				<c:otherwise><a href="/qna.do?cmd=qna_read&pageNum=${i }&rowCount=${rowCount }">[${i}]</a></c:otherwise>
			</c:choose>
		</c:forEach>
		
		<!-- 다음 버튼 조건절 : 2페이지 이상 페이지 존재할 경우 작동 -->
		<c:choose>
			<c:when test="${endPage>1 }">
			<input type="button" value=" 다음 " onclick="javascripte:location.href='/qna.do?cmd=qna_read&pageNum=${pageNum+1 }&rowCount=${rowCount }'">
			</c:when>
			<c:otherwise>
			<input type="button" value=" 다음 ">
			</c:otherwise>
		</c:choose>
		
		<!-- >> 버튼 조건절 : 11페이지 이상 페이지 존재할 경우 작동 -->
		<c:choose>
			<c:when test="${pageCount>10 }">			
			<input type="button" value=" ≫ " onclick="javascripte:location.href='/qna.do?cmd=qna_read&pageNum=${endPage+1 }&rowCount=${rowCount }'">
			</c:when>
			<c:otherwise>			
			<input type="button" value=" ≫ ">
			</c:otherwise>
		</c:choose>
		<div style="float:right">
			<select id="rowCount_change" onchange="location.href='/qna.do?cmd=qna_read&pageNum=${pageNum }&rowCount='+this.value">
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
		<form action="/qna.do" method="post">
		<input type="hidden" name="cmd" value="qna_search">
		<select name="qna_search_option">
			<option value="qna_writer">작성자</option>
			<option value="qna_title">제목</option>
		</select>
		<input type="text" name="qna_search_text">
		<input type="submit" class="search_button" value="검색">
		</form>
	</div>
	</div>
</div>
<script>
	function select(){
		var select_count=document.getElementById("rowCount_change");
		select_count.value=${rowCount};
	}
	select();	
	
	function title_click(qna_num){
		var span=document.getElementById("qna_content"+qna_num);
		span.innerHTML="※ 비밀번호 입력 <input type='text' id='input_password' style='width:100px'><input type='button' value='확인' onclick='compare_password("+qna_num+")'>";
	}
	
	var xhr=null;
	function compare_password(qna_num){
		var input_password=document.getElementById("input_password");
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=result;
		xhr.open("get","/qna.do?cmd=qna_compare&input_password="+input_password.value+"&qna_num="+qna_num,true);
		xhr.send();
	}
	function result(){
		if(xhr.readyState==4 && xhr.status==200){
			xml=xhr.responseXML;
			var result=xml.getElementsByTagName("result")[0].firstChild.nodeValue;
			var qna_num=xml.getElementsByTagName("num")[0].firstChild.nodeValue;
			if(result=="o"){
				location.href="/qna.do?cmd=qna_detail&qna_num="+qna_num;
			}else{
				alert("비밀번호 불일치");
			}
		}
	}
	function login_check(){
		var btn_write=document.getElementById("btn_write");
		if("${sessionScope.member_nickname }"==""){
			btn_write.style.display="none";
		}
	}
	window.onload=login_check();
</script>