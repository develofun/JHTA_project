<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/cs.css">
<script type="text/javascript">
	$(document).ready(function(){
		var imgsize=0;
		$(".consult_image").change(function(){
			var img_size=parseInt(this.files[0].size);
			var img_name=$(this).val();
			var imgchk1=img_name.indexOf(".jpg");
			var imgchk2=img_name.indexOf(".jpeg");
			var imgchk3=img_name.indexOf(".png");
			if(img_size>1048576){
				alert("사진크기가 너무 큽니다.");
				$(this).val(null);
			}else if(imgchk1<=0&&imgchk2<=0&&imgchk3<=0){
				alert("이미지(jpg,jpeg,png)를 입력해 주세요.");
				$(this).val(null);
			}
		});
		$("#submit").click(function(event){
			var title=$("#title").val();
			var content=$("#content").val();
			if(title==""){
				alert("제목을 입력해 주세요");
				event.preventDefault();
			}else if(content==""){
				alert("내용을 입력해 주세요");
				event.preventDefault();
			}
		});
	});
</script>
	<div id="cs_wrap">
		<div id="cs_left">
			<div id="cs_menu">
				<div id="cs_title">
					<h4 class="page-header">고객센터</h4>
				</div>
				<ul id="cs_menus_out">
					<li value="1"  class="alert alert-success">
						<a href="cs_main">FAQ</a>
						<ul id="cs_menus_in" style="background-color: white;">
							<c:forEach var="category_vo" items="${get_faq_category }">
								<li id="${category_vo.cs_faq_category_code }">
								<a href="cs_list?category=${category_vo.cs_faq_category_code }" class="cs_menus">${category_vo.cs_faq_category_name }</a>
								</li>
							</c:forEach>
						</ul>
					</li>
					<li class="alert alert-success"><a>1:1문의 상담</a>
						<ul id="cs_menus_in" style="background-color: white">
							<li id="consult"><a href="cs_consult">상담하기</a><span id="s_id" style="display:none">${get_id }</span></li>
							<li id="consult_list"><a href="cs_consult_list">문의내역</a></li>
						</ul>
					</li>
					<li class="alert alert-success"><a href="<c:url value='/cs/cs_notice'/>"> 공지사항</a></li>
					<li class="alert alert-success"><a href="cs_info">이용안내</a></li>
				</ul>
			</div>
		</div>
		<div id="cs_right">
			<div id="consult_main">
				<div id="consult_title"><span>1 : 1 상담/문의</span></div>
				<form action="cs_consult" method="post" enctype="multipart/form-data">
				<div id="consult_category">
					<div id="consult_select">
					<span>상담유형</span>
					<select id="consult_btnselect" name="consult_sort">
						<c:forEach var="consult_vo" items="${consult_category }">
							<option>${consult_vo.consult_category_name }</option>
						</c:forEach>
					</select>
					</div>
				</div>
				<div id="consult_member_info">
				<div id="insert_info">
					<span class="insert_title">아이디</span>
					<input type="text" disabled="disabled" class="insert_info_inputs" value="${consult_id }">
					<input type="text" name="consult_id" style="display: none;" value="${consult_id }">
					</div>
				<div id="insert_info">
					<span class="insert_title">전화번호</span><input type="text" id="phone_front" disabled="disabled" value="${phone1 }">
					<span>-</span>
					<input type="text" disabled="disabled" class="insert_info_inputs" value="${phone2 }">
					<span>-</span>
					<input type="text" disabled="disabled" class="insert_info_inputs" value="${phone3 }">
					<input type="text" name="consult_phone_num" style="display: none;" value="${phone }">
					</div>
				<div id="insert_info">
				<span class="insert_title">이메일</span>
				<input type="text" disabled="disabled" class="insert_info_inputs" value="${email1 }">
					<span>@</span>
				<input type="text" disabled="disabled" class="insert_info_inputs" value="${email2 }">
				<input type="text" name="consult_email" style="display: none;" value="${email }">
				</div>
			</div>
			<div id="consult_question">
			<span>문의내용</span>
			<div id="question">
			<span>제목</span>
			<input type="text" id="title" name="consult_title">
			</div>
			<div id="question">
			<span>내용</span><br>
			<textarea rows="5" cols="50" id="content" name="consult_content"></textarea>
			</div>
			<div id="question">
			<span>첨부사진</span>
			<input type="file" class="consult_image" name="consult_img1">
			<input type="file" class="consult_image" name="consult_img2">
			<input type="file" class="consult_image" name="consult_img3">
			<p id="image_info">첨부 사진의 최대 용량은 각 1M byte 입니다.</p>
			</div>
			<input type="submit" value="문의 신청" id="submit">
			</div>
			</form>
		</div>
	</div>
</div>