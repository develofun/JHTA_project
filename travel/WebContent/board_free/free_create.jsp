<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div class="board_ksw_subject">
		<div class="board_ksw_subject_title" style="text-align: left;">&nbsp;&nbsp;자유게시판 입니다.</div>
		<div class="board_ksw_subject_content" style="text-align: left;">
		자유롭게 쓰고 싶은 글을 쓰는 게시판입니다..<br>
		매너를 지켜서 이용해주세요.
		</div>	
	</div>	
	<form method="post" action="/free.do?cmd=create"
		enctype="multipart/form-data">
		<div class="free_create_all">
			<div class="free_create_top">
				<div class="free_create_top_title">
					<h3 class="free_create_title">자유게시판 글쓰기</h3>
				</div>
				<div class="free_create_titletext">
					&nbsp;&nbsp;&nbsp;&middot;&nbsp; 제목 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" id="free_title" name="free_title" size="100">
				</div>
			</div>
			<div class="free_create_middle">
				<textarea class="textarea_ksw"id="free_content" name="free_content"></textarea>
			</div>

			<div class="free_create_footer">
				<div class="free_create_footer_file">
					<input type="file" accept=image/* name="free_file1"><br>
					<!--  
			<input type="file" accept=image/* name="free_file2"><br>
			<input type="file" accept=image/* name="free_file3"><br>
			<input type="file" accept=image/* name="free_file4"><br>
			-->
				</div>
				<div class="review_create_footer_buten">
					<input type="submit" class="review_create_btu btn1" value="저장">
					<input type="button" class="review_create_btu btn1" id="btn_cancel" value="목록" onclick="back_to_read()">
				</div>
			</div>
		</div>
	</form>
</div>
<script>
function back_to_read(){
	if(confirm("페이지를 나가시겠습니까?")==true){
		location.href="/free.do?cmd=free_read";
	}
}
</script>

