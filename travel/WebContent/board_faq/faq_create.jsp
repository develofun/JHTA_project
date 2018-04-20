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
	<div class="board_ldk_changeBoard">
		<ul>
			<li><a href="/faq.do?cmd=faq_read" class="">Q&A</a></li>
			<li><a href="" class="">FAQ</a></li>
		</ul>
	</div>
	<div class="board_ldk_content">
		<form action="/faq.do?cmd=faq_create" method="post">
			<table border="1">
				<tr>
					<th>카테고리</th>
					<td>
					<select name="faq_category">
						<option value="국내여행">국내여행</option>
						<option value="해외여행">해외여행</option>
						<option value="사이트 이용">사이트 이용</option>
						<option value="로그인">로그인</option>
						<option value="회원가입">회원가입</option>
					</select>
					</td>
				</tr>				
				<tr>
					<th>제목</th>
					<td>&nbsp;&nbsp;<input type="text" name="faq_title" value="${faq_title }"></td>
				</tr>				
				<tr>
					<th>내용</th>	
					<td>&nbsp;&nbsp;<textarea rows="5" cols="50" name="faq_content">${faq_content }</textarea></td>
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
			location.href="/faq.do?cmd=faq_read";
		}
	}
</script>