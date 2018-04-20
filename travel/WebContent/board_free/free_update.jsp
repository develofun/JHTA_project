<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;자유게시판 입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		자유롭게 쓰고 싶은 글을 쓰는 게시판입니다..<br>
		
		</div>	
	</div>	
<form method="post" action="/free.do?cmd=free_update" enctype="multipart/form-data">
<div class="free_create_all">
	<div class="free_create_top">
		<div class="free_create_top_title">
			<h3 class="free_create_title">자유게시판 글수정</h3>
			<input type="hidden" name="free_num" value="${dto.free_num }">
			<input type="hidden" name="Free_image_num" value="${dto_image.Free_image_num }">
		</div>	
		<div class="free_create_titletext">
			&nbsp;&nbsp;&nbsp;&middot;&nbsp;
			제목
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" id="free_title" name="free_title" size="100" value="${dto.free_title }" >
		</div>	
	</div>
	<div class="free_create_middle">
		<textarea class="textarea_ksw"id="free_content" name="free_content">${dto.free_content }</textarea>
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
		<div class="free_create_footer_buten">
			<input type="submit" class="free_create_btu btn1" value="수정">
			<a class="free_create_btu btn1" href="/free.do?cmd=free_read" >목록</a>
		</div>
	</div>
</div>
</form>
</div>