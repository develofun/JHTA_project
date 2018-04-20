<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_upload_request.css" type="text/css">

<div id="wrap">
	<div id="gonggu_upload_request">
		<h2>공동구매 업로드권한 신청</h2>
		<hr style="width:100px;float:left;">
		<br>
		<br>
		<br>
		<span style="font-size:12px;font-weight:bold; color: #353535;">공동구매게시판에 게시글을 등록할 수 있는 권한을 신청하는 곳입니다.<br>
			신청사유를 간단히 입력해주세요.</span><br>
		<div id="gonggu_upload_request_div">
			<form method="post" action="/gonggu/gonggu_upload_request">
				<input type="hidden" id="member_privacy_id" name="member_privacy_id" value="${sessionScope.id }">
				<input type="text" id="member_privacy_id_readonly" value="${sessionScope.id }" readonly="readonly" style="width:120px;height:30px;font-size:18px;border-radius:6px;padding:10px;border:1px solid gray;"><br><br>
				<textarea rows="5" cols="50" id="gonggu_upload_request_reason" class="form-control" name="gonggu_upload_request_reason" style="width:400px;"></textarea><br><br>
				<div align="center">
					<input type="submit" class="btn btn-primary" id="btn_submit" value="신청하기"><br>
				</div>
			</form>
			<br>
			<br>
		</div>
	</div>
</div>