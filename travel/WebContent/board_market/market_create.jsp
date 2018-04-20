<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;중고장터입니다.</div>
		<div>
		</div>
	</div>
	<div class="board_ldk_content">
		<form action="/market.do?cmd=market_create" enctype="multipart/form-data" method="post">
			<input type="hidden" name="market_writer" value="${sessionScope.member_nickname }">
			<table border="1">
				<tr>
					<th>분류</th>
					<td>&nbsp;
						<select name="market_sort">
							<option value="판매">판매</option>
							<option value="구매">구매</option>	
						</select>
					</td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td>&nbsp;
						<select name="market_category">
							<option value="가방">가방</option>
							<option value="의류">의류</option>
							<option value="장비">장비</option>
							<option value="액세서리">액세서리</option>
							<option value="항공권">항공권</option>
							<option value="숙박권">숙박권</option>
							<option value="이용권">이용권</option>	
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>&nbsp;&nbsp;<input type="text" name="market_title" value="${market_title }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>&nbsp;&nbsp;<input type="text" name="market_writer" disabled="disabled" value="${sessionScope.member_nickname }"></td>
				</tr>
				<tr>
					<th>거래 희망 가격</th>
					<td>&nbsp;&nbsp;<input type="text" name="market_price" value="${market_price }"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>&nbsp;&nbsp;<input type="text" name="market_phone" value="${market_phone }"></td>
				</tr>
				<tr>
					<th>내용</th>					
					<td>&nbsp;&nbsp;<textarea rows="5" cols="50" name="market_content">${market_content }</textarea></td>
				</tr>
				<tr>
					<th>이미지 첨부</th>
					<td>
						&nbsp;&nbsp;<input type="file" name="market_image">		
					</td>
				</tr>
			</table>	
			<div class="board_ldk_button" align="right">
				<input type="submit" value="    등록    ">
				<input type="button" value="    취소    " onclick="back_to_read()">
			</div>
		</form>
	</div>
</div>
<script>
	function back_to_read(){
		if(confirm("등록하지 않고 페이지를 나가시겠습니까?")==true){
			location.href="/market.do?cmd=market_read";
		}
	}
	function select_value(){
		var sort=document.getElementsByName("market_sort");
		var category=document.getElementsByName("market_category");
		sort.value="${market_sort }";
		category.value="${market_category }";
	}
	select_value();
</script>