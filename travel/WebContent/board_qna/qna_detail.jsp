<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;이벤트/할인 게시판입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		이벤트/할인 정보를 공유하는 게시판입니다.<br>
		다양한 정보 공유 부탁 드립니다.
		</div>
	</div>
	<div class="board_ldk_content">
		<table border="1">
			<tr>
					<th>제목</th>
					<td>&nbsp;&nbsp;${dto.qna_title }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>&nbsp;&nbsp;${dto.qna_writer }</td>
				</tr>								
				<tr>
					<th>내용</th>	
					<td>&nbsp;&nbsp;${dto.qna_content }</td>
				</tr>
				<tr>
					<th>
					답변
					<input type="button" name="btn_reply" onclick="">
					</th>	
					<td>&nbsp;&nbsp;${dto.qna_reply }</td>
				</tr>
			<tr>
				<th>작성일</th>
				<td>&nbsp;&nbsp;${dto.qna_w_date }</td>
			</tr>
		</table>
		<input type="button" id="btn_delete" value="    삭제    " style="float:left" onclick="javascript:location.href='/qna.do?cmd=qna_delete&qna_num=${dto.qna_num}'">
		<div class="board_ldk_button" style="float:right">
			<input type="button" id="btn_modify" value="    수정    " onclick="javascript:location.href='/qna.do?cmd=qna_detail_to_update&qna_num=${dto.qna_num}'">
			<input type="button" id="btn_cancel" value="    취소    " onclick="back_to_read()">
		</div>
		<div style="clear:right"></div>
	</div>
</div>
<script>
	function back_to_read(){
		if(confirm("페이지를 나가시겠습니까?")==true){
			location.href="/qna.do?cmd=qna_read";
		}
	}
	function btn_display(){
		var btn_delete=document.getElementById("btn_delete");
		var btn_modify=document.getElementById("btn_modify");
		var btn_cancel=document.getElementById("btn_cancel");
		var comment_input_div=document.getElementById("comment_input_div");
		if("${sessionScope.member_nickname}"==""){			
			btn_delete.style.diplay="none";
			btn_modify.style.diplay="none";
			comment_input_div.style.diplay="none";
		}else if("${sessionScope.member_nickname}"!="${dto.qna_writer}"){
			btn_delete.style.diplay="none";
			btn_modify.style.diplay="none";
		}
	}
	window.onload=btn_display;
</script>