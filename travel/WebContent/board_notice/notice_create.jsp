<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h1 style="width:250px;">공지사항 글쓰기</h1>
	<form method="post" action="/notice.do?cmd=notice_create">
		<table class="kboard_notice_create" border="1" width="100%">
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tr>
				<th>제목</th>
				<td><input type="text" name="notice_title" size="80px" style="height: 30px;"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="110" name="notice_content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height: 30px;"><input type="submit" value="확인" style="width:70px;"> 
			<input type="reset" value="취소" style="width:70px;" onclick="cancel()"></td>
			</tr>
		</table>
	</form>
</div>
<script>
	function cancel(){
		location.href="/notice.do?cmd=notice_read";
	}
</script>