<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form method="post" action="/review.do?cmd=create" enctype="multipart/form-data">
<div class="review_create_all">
	<div class="review_create_top">
		<div class="review_create_top_title">
			<h3 class="review_create_title">리뷰게시판 글쓰기</h3>
		</div>	
		<div class="review_create_titletext">
			&nbsp;&nbsp;&nbsp;&middot;&nbsp;
			제목
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" id="review_title" name="review_title" size="100" >
		</div>	
		<div class="review_create_category">
			&nbsp;&nbsp;&nbsp;&middot;&nbsp;
			분류
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="review_category" value="국내" checked="checked">국내
			<input type="radio" name="review_category" value="해외">해외
		</div>
	</div>
	<div class="review_create_middle">
		<textarea class="textarea_ksw" id="review_content" name="review_content"></textarea>
	</div>
	
	<div class="review_create_footer">
		<div class="review_create_footer_file">
			<input type="file" accept=image/* name="review_file1"><br>
			<!--  
			<input type="file" accept=image/* name="review_file2"><br>
			<input type="file" accept=image/* name="review_file3"><br>
			<input type="file" accept=image/* name="review_file4"><br>
			-->
		</div>
		<div class="review_create_footer_buten">
			<input type="submit" class="review_create_btu btn1" value="저장">
			<input type="button" class="review_create_btu btn1"id="btn_cancel" value="목록" onclick="back_to_read()">
		</div>
	</div>
</div>
</form>
<script>
function select_value(){
	var category=document.getElementsByName("review_category");
	category.value="${review_category }";
}
select_value();

function back_to_read(){
	if(confirm("페이지를 나가시겠습니까?")==true){
		location.href="/review.do?cmd=review_read";
	}
}
</script>

