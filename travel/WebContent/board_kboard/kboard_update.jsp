<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div>
	<form method="post" action="/kboard.do?cmd=kboard_update"
		enctype="multipart/form-data">
		<input type="hidden" name="kboard_num" value="${dto.kboard_num }">
		<h1 style="width:250px;">국내여행 글수정</h1>
		<table class="kboard_update_table">
			<tr>
				<th>지역</th>
				<td>${dto.kboard_area }</td>
			</tr>
			<tr>
				<th>도시</th>
				<td>${dto.kboard_city }</td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td>${dto.kboard_category }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="kboard_title"
					value="${dto.kboard_title }"></td>
			</tr>
			<tr>
				<th>추가내용</th>
				<td><textarea rows="3" cols="100" name="kboard_plus_content">${dto.kboard_plus_content }</textarea>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="100" name="kboard_content">${dto.kboard_content }</textarea>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td>${dto.kboard_imgname }</td>
			</tr>
			<tr>
				<th>수정이미지</th>
				<td><input type="file" name="kboard_imgname"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><textarea rows="5" cols="100" name="kboard_addr">${dto.kboard_addr }</textarea>
				</td>
			</tr>
			<tr>
				<th>x좌표</th>
				<td><input type="text" name="kboard_x" value="${dto.kboard_x }"></td>
			</tr>
			<tr>
				<th>y좌표</th>
				<td><input type="text" name="kboard_y" value="${dto.kboard_y }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="height: 30px;">
					<input type="submit" value="수정" style="width:70px;">
					<input type="reset" value="취소" style="width:70px;" onclick="cancel()">
				</td>
			</tr>
		</table>
	</form>
</div>
<script>
	function cancel(){
		location.href="/kboard.do?cmd=kboard_detail&kboard_num=${dto.kboard_num}";
	}
</script>



