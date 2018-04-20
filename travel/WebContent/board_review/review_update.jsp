<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
.review_create_all{width: 900px; background-color: white;}

.review_create_top_title{
	width: 100%;
	height: 37px;
	background-color: #F7F7F7;
	border-top: 2px solid #B2B2B2;
	border-bottom: 1px solid #E1E1E1;
}

.review_create_title{
	display:table-cell; text-align:center; vertical-align:middle;
	padding-top: 4px;
}
.review_create_titletext{padding: 5px 5px;}

textarea {width: 100%; 
	height: 500px; 
	padding: 12px 20px;
	margin-top: 5px;
    box-sizing: border-box;
    border: 2px solid #B2B2B2;
    background-color: #F7F7F7;
    font-size: 16px;
    resize: none;
}
.review_create_footer_buten{text-align:center;}

.review_create_btu {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 3px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    
}
.btn1 {
    background-color: white;
    color: black;
    border: 2px solid #B2B2B2;
}

.btn1:hover {background-color: #B2B2B2;}
</style>

<form method="post" action="/review.do?cmd=review_update" enctype="multipart/form-data">
<div class="review_create_all">
	<div class="review_create_top">
		<div class="review_create_top_title">
			<h3 class="review_create_title">리뷰게시판 글수정</h3>
			<input type="hidden" name="review_num" value="${dto.review_num }">
			<input type="hidden" name="Review_image_num" value="${dto_image.Review_image_num }">
		</div>	
		<div class="review_create_titletext">
			&nbsp;&nbsp;&nbsp;&middot;&nbsp;
			제목
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" id="review_title" name="review_title" size="100" value="${dto.review_title }" >
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
		<textarea class="textarea_ksw" id="review_content" name="review_content">${dto.review_content }</textarea>
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
			<input type="submit" class="review_create_btu btn1" value="수정">
			<a class="review_create_btu btn1" href="/review.do?cmd=review_read" >목록</a>
		</div>
	</div>
</div>
</form>