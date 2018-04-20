<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;Q&A 게시판입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		이벤트/할인 정보를 공유하는 게시판입니다.<br>
		다양한 정보 공유 부탁 드립니다.
		</div>	
	</div>
	<div class="board_ldk_content">
		<form action="/qna.do?cmd=qna_update" method="post">
			<input type="hidden" name="qna_num" value="${dto.qna_num }">
			<input type="hidden" name="customer_num" value="${dto.customer_num }">
			<table border="1">				
				<tr>
					<th>제목</th>
					<td>&nbsp;&nbsp;<input type="text" name="qna_title" value="${dto.qna_title }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>&nbsp;&nbsp;<input type="text" name="qna_writer" value="${dto.qna_writer }"></td>
				</tr>
				<tr>
					<th>내용</th>	
					<td>&nbsp;&nbsp;<textarea rows="5" cols="50" name="qna_content">${dto.qna_content }</textarea></td>
				</tr>
			</table>
			<div class="board_ldk_button" align="right">
				<input type="submit" value="    확인    ">
				<input type="button" value="    취소    " onclick="back_to_read()">
			</div>
		</form>
	</div>
</div>
<script>
	function back_to_read(){
		if(confirm("수정하지 않고 페이지를 나가시겠습니까?")==true){
			history.go(-1);
			//location.href="/qna.do?cmd=qna_detail&qna_num=&{dto.qna_num}";
		}
	}	
</script>