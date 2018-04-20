<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table class="kboard_attraction">
	<tr>
		<th>제목</th>
		<td><input type="text" name="kboard_title"></td>
	</tr>
	<tr>
		<th>지역</th>
		<td><select name="kboard_area"
			onChange="showcity(this.options[this.selectedIndex].value);">
				<option value="서울">서울</option>
				<option value="경기도">경기도</option>
				<option value="강원도">강원도</option>
				<option value="충청도">충청도</option>
				<option value="경상도">경상도</option>
				<option value="전라도">전라도</option>
				<option value="제주도">제주도</option>
		</select></td>
	</tr>
	<tr>
		<th>도시</th>
		<td><select name="kboard_city" id="kboard_city"></select></td>
	</tr>
	<tr>
		<th>명소주소</th>
		<td><textarea rows="3" cols="100" name="kboard_addr"></textarea></td>
	</tr>
	<tr>
		<th>이용시간 및 요금</th>
		<td><textarea rows="3" cols="100" name="kboard_plus_content"></textarea></td>
	</tr>
	<tr>
		<th>명소정보</th>
		<td><textarea rows="5" cols="100" name="kboard_content"></textarea></td>
	</tr>
	<tr>
		<th>첨부이미지</th>
		<td><input type="file" name="kboard_imgname"></td>
	</tr>
	<tr>
		<th>X좌표</th>
		<td><input type="text" name="kboard_x"></td>
	</tr>
	<tr>
		<th>Y좌표</th>
		<td><input type="text" name="kboard_y"></td>
	</tr>
	<tr>
		<td colspan="2" align="center" style="height: 30px;">
			<input type="submit" value="확인" style="width:70px;">
			<input type="reset" value="취소" style="width:70px;" onclick="cancel()">
		</td>
	</tr>
</table>
<!-- <script>
	function cancel(){
		location.href="/kboard.do?cmd=kboard_read";
	}
</script> -->
