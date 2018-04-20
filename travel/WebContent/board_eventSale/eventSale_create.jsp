<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;이벤트/할인
			게시판입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
			이벤트/할인 정보를 공유하는 게시판입니다.<br> 다양한 정보 공유 부탁 드립니다.
		</div>
	</div>
	<div class="board_ldk_content">
		<form action="/eventSale.do?cmd=eventSale_create" method="post">
			<input type="hidden" name="eventSale_writer" value="${sessionScope.member_nickname }">
			<table border="1">				
				<tr>
					<th>분류</th>
					<td>&nbsp;
						<select name="eventSale_sort">
							<option value="이벤트">이벤트</option>
							<option value="할인">할인</option>	
						</select>
					</td>
				</tr>
				<tr>
					<th>항목</th>
					<td>&nbsp;
						<select name="eventSale_category">							
							<option value="의류">의류</option>
							<option value="장비">장비</option>
							<option value="숙박">숙박</option>
							<option value="액세서리">패키지</option>
							<option value="항공권">항공권</option>	
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>&nbsp;&nbsp;<input type="text" name="eventSale_title" value="${eventSale_title }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>&nbsp;&nbsp;<input type="text" name="eventSale_writer" disabled="disabled" value="${sessionScope.member_nickname }"></td>
				</tr>
				<tr>
					<th>진행 기간</th>
					<td>&nbsp;&nbsp;<input type="date" name="eventSale_startDate" value="${eventSale_startDate }"> ~
					<input type="date" name="eventSale_endDate" value="${eventSale_endDate }"> 
					</td>
				</tr>				
				<tr>
					<th>내용</th>					
					<td>&nbsp;&nbsp;<textarea rows="5" cols="50" name="eventSale_content">${eventSale_content }</textarea></td>
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
			location.href="/eventSale.do?cmd=eventSale_read";
		}
	}
	function select_value(){
		var sort=document.getElementsByName("eventSale_sort");
		var category=document.getElementsByName("eventSale_category");
		sort.value="${eventSale_sort }";
		category.value="${eventSale_category }";
	}
	select_value();
</script>