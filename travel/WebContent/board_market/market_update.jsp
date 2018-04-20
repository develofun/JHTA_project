<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;중고장터입니다.</div>
		<div>
		</div>
	</div>
	<div class="board_ldk_content">
		<form action="/market.do?cmd=market_update" enctype="multipart/form-data" method="post">
			<input type="hidden" name="market_num" value="${dto_text.market_num }">
			<input type="hidden" name="customer_num" value="${dto_text.customer_num }">
			<input type="hidden" name="market_image_num" value="${dto_image.market_image_num }">
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
					<td>&nbsp;&nbsp;<input type="text" name="market_title" value="${dto_text.market_title }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>&nbsp;&nbsp;<input type="text" name="market_writer" disabled="disabled" value="${dto_text.market_writer }"></td>
				</tr>
				<tr>
					<th>거래 희망 가격</th>
					<td>&nbsp;&nbsp;<input type="text" name="market_price" value="${dto_text.market_price }"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>&nbsp;&nbsp;<input type="text" name="market_phone" value="${dto_text.market_phone }"></td>
				</tr>
				<tr>
					<th>내용</th>					
					<td>&nbsp;&nbsp;<textarea rows="5" cols="50" name="market_content">${dto_text.market_content }</textarea></td>
				</tr>
				<tr>
					<th>이미지 첨부</th>
					<td>
						&nbsp;&nbsp;<input type="file" name="market_image"><br><span style="color:red">&nbsp;&nbsp;※ 파일 수정이 필요한 경우에만 첨부해 주세요.</span>
						<input type="hidden" name="market_hit" value="${dto_text.market_hit }">
						<input type="hidden" name="market_w_date" value="${dto_text.market_w_date }">		
					</td>					
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
			//location.href="/market.do?cmd=market_detail&market_num=&{dto_text.market_num}";
		}
	}
	function select_value(){
		var sort=document.getElementsByName("market_sort")[0];
		var category=document.getElementsByName("market_category")[0];
		sort.value="${dto_text.market_sort }";
		category.value="${dto_text.market_category }";
	}
	select_value();
</script>