<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h1 style="width:250px;">공지사항 글수정</h1>
	<form method="post" action="/notice.do?cmd=notice_update">
	<input type="hidden" name="notice_num" value="${dto.notice_num }">
		<table class="kboard_notice_update" border="1" width="100%">
		<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tr>
				<td>제목</td>
				<td><input type="text" name="notice_title" size="80px" style="height: 30px;"
					value="${dto.notice_title }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="15" cols="110" name="notice_content">${dto.notice_content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height: 30px;"><input type="submit" value="수정" style="width:70px;">
				<input type="reset" value="취소" style="width:70px;" onclick="cancel()"></td>
			</tr>
		</table>
	</form>
</div>
<script>
	function cancel(){
		location.href="/notice.do?cmd=notice_detail&notice_num=${dto.notice_num}";
	}
</script>