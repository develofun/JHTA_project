<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="join_page" class="container" style="width:800px;margin-top:50px">
	<div class="row" style="margin-bottom:20px">
		<div class="panel panel-heading col-xs-12" style="height:70px;">
			<h3>계정 신청</h3>
		</div>
		<div class="form-inline col-xs-12">
			<label class="has-error"><input type="text" class="form-control has-error" style="width:30px;">은 필수 입력 항목입니다.</label>
		</div>
	</div>
	<form class="form-horizontal" method="post" action="join">
		<!-- 아이디 입력 -->
		<div class="form-group has-error">
			<div class="col-xs-2" align="right">
				<label>아이디</label>
			</div>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="joinId" name="admin_member_id" placeholder="rule : 8 ~ 16자 이하의 영문, 숫자 조합">
			</div>
			<div class="col-xs-6" style="height:34px;vertical-align:middle;">
				안내 내용
			</div>
		</div>
		<!-- 비밀번호 입력 -->
		<div class="form-group has-error">
			<div class="col-xs-2" align="right">
				<label>비밀번호</label>
			</div>
			<div class="col-xs-4">
				<input type="password" class="form-control" id="joinPwd" name="admin_member_pwd" placeholder="rule : 8 ~ 20자 이하의 영문, 숫자, 특수문자 조합">
			</div>
			<div class="col-xs-6">
				안내 내용
			</div>
		</div>
		<!-- 비밀번호 확인 -->
		<div class="form-group has-error">
			<div class="col-xs-2" align="right">
				<label>비밀번호 확인</label>
			</div>
			<div class="col-xs-4">
				<input type="password" class="form-control" id="joinPwdCheck" placeholder="비밀번호를 한 번 더 입력해 주세요.">
			</div>
			<div class="col-xs-6">
				안내 내용
			</div>
		</div>
		<!-- 이름 -->
		<div class="form-group has-error">
			<div class="col-xs-2" align="right">
				<label>이름</label>
			</div>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="joinName" name="admin_member_name" placeholder="이름을 입력하세요.">
			</div>
			<div class="col-xs-6">
				안내 내용
			</div>
		</div>
		<!-- 생년월일 -->
		<div class="form-group has-error">
			<div class="col-xs-2" align="right">
				<label>생년월일</label>
			</div>
			<div class="col-xs-4">
				<input type="date" class="form-control" id="joinBirth" name="admin_member_birth" placeholder="생년월일 입력">
			</div>
			<div class="col-xs-6">
				안내 내용
			</div>
		</div>
		<!-- 휴대폰 번호 -->
		<div class="form-group has-error">
			<div class="col-xs-2" align="right">
				<label>전화 번호</label>
			</div>
			<div class="form-inline col-xs-4">
				<select class="form-control" id="joinPhoneFst" name="admin_member_phone" style="width:30%">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="019">019</option>
				</select>
				<input type="text" class="form-control" id="joinPhoneSec" name="admin_member_phone" maxlength="4" style="width:30%">
				<input type="text" class="form-control" id="joinPhoneTrd" name="admin_member_phone" maxlength="4" style="width:30%">
			</div>
			<div class="col-xs-6">
				안내 내용
			</div>
		</div>
		<!-- 이메일 -->
		<div class="form-group has-error">
			<div class="col-xs-2" align="right">
				<label>이메일</label>
			</div>
			<div class="form-inline col-xs-4">
				<input type="text" class="form-control" id="joinEmailId" name="admin_member_email" placeholder="이메일 입력" style="width:40%">
				@
				<input type="text" class="form-control" id="joinEmailAddr" name="admin_member_email" style="width:40%">
			</div>
			<div></div>
			<div class="col-xs-6">
				<select id="email_selector" class="form-control" style="width:40%">
					<option value="write">직접 입력</option>
					<option value="naver.com">naver.com</option>
					<option value="hanmail.net">hanmail.net</option>
					<option value="gmail.com">gmail.com</option>
					<option value="nate.com">nate.com</option>
				</select>
			</div>
		</div>
		<!-- IP 주소 -->
		<div class="form-group has-success">
			<div class="col-xs-2" align="right">
				<label>접속 IP</label>
			</div>
			<div class="form-inline col-xs-4">
				<input type="text" class="form-control" name="admin_member_ip" style="width:20%">.
				<input type="text" class="form-control" name="admin_member_ip" style="width:20%">.
				<input type="text" class="form-control" name="admin_member_ip" style="width:20%">.
				<input type="text" class="form-control" name="admin_member_ip" style="width:20%">
			</div>
			<div class="col-xs-6">
				접속하는 PC의 IP 주소를 입력해 주세요.
			</div>
		</div>
		<!-- 개인정보 취급 안내 -->
		<div class="form-group">
			<div class="form-inline">
				<div class="panel panel-info">					
					<p style="padding-left:10px;padding-right:10px;">
						<input type="checkbox" class="form-control" id="privacyCheck" name="privacy_check">						
						개인정보 취급 안내문
					</p>
				</div>
			</div>
		</div>
		<span id="submitMsg"></span>
		<!-- 신청/취소 버튼 -->
				<input type="submit" class="btn btn-primary" value="신청">
				<input type="button" class="btn btn-warning" value="취소">
		<div class="form-group" align="center">
			<div class="form-inline">
			</div>
		</div>
	</form>
	<div class="row">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h4 class="panel-title">
					<label>※ 비밀번호 입력 수칙...</label>
				</h4>
			</div>
			<div class="panel-body">
				<p>
					으하하하하하
				</p>
			</div>
		</div>
	</div>
</div>
<script>
	/* 유효성 체크 */
	$(function(){
		$("input").focusin(function(){
			$(this).parent().next().text("");
		});
		$("#joinId").focusout(function(){
			var join_id=$(this).val();
			var id_valid=/^[a-z0-9_-]{8,16}$/;
			var msg="";
			if(!id_valid.test(join_id)){
				msg="아이디 형식에 맞지 않습니다.(8~16자 영문(소), 숫자)";
				$(this).parent().parent().addClass("has-error");
			}else{
				$(this).parent().parent().removeClass("has-error").addClass("has-success");
			}
			$(this).parent().next().text(msg).css("color","red");
		});
		$("#joinPwd").focusout(function(){
			var join_pwd=$(this).val();
			var pwd_valid=/^[a-z0-9_-]{8,20}$/;
			var msg="";
			if(pwd_valid.test(join_pwd)){
				$(this).parent().parent().removeClass("has-error").addClass("has-success");
			}else{
				msg="비밀번호 형식에 맞지 않습니다.";
				$(this).parent().parent().addClass("has-error");
			}
			$(this).parent().next().text(msg).css("color","red");
		});
		$("#joinPwdCheck").focusout(function(){
			var msg="";
			if($(this).val()!=$("#joinPwd").val()){
				msg="비밀번호가 일치하지 않습니다.";
				$(this).parent().parent().addClass("has-error");
			}else{
				$(this).parent().parent().removeClass("has-error").addClass("has-success");
			}
			$(this).parent().next().text(msg).css("color","red");
		});
		$("#joinBirth").focusout(function(){
			var msg="";
			if($(this).val()==""){
				msg="생년월일을 입력해 주세요.";
				$(this).parent().parent().addClass("has-error");
			}else{
				$(this).parent().parent().removeClass("has-error").addClass("has-success");
			}
			$(this).parent().next().text(msg).css("color","red");
		});
		$("#joinPhoneTrd").focusout(function(){
			var msg="";
			console.log($(this).val().length);
			if($("#joinPhoneSec").val().length>2 && $(this).val().length>3){
				$(this).parent().parent().removeClass("has-error").addClass("has-success");
			}else{
				msg="연락처를 올바르게 입력해 주세요.";
				$(this).parent().parent().addClass("has-error");
			}
			$(this).parent().next().text(msg).css("color","red");
		});
		$("#joinEmailAddr").focusout(function(){
			var email_valid=/[.]/;			
			var emailAddr=$(this).val();
			if(email_valid.test(emailAddr)){
				$(this).parent().parent().removeClass("has-error").addClass("has-success");
			}else{
				$(this).parent().parent().addClass("has-error");
			}
		});
		$("#joinName").focusout(function(){
			var msg="";
			if($(this).val().length<2){
				msg="이름을 올바르게 입력해 주세요.";
				$(this).parent().parent().addClass("has-error");
			}else{
				$(this).parent().parent().removeClass("has-error").addClass("has-success");
			}
		});
		$("#email_selector").change(function(){
			var select=$("#email_selector option:selected").val();
			console.log(select);
			$("#joinEmailAddr").attr("value",select);
			$(this).parent().parent().removeClass("has-error").addClass("has-success");
		});
		$("form").submit(function(event){
			console.log($("#join_page").children().find(".form-group.has-error").length);
			if($("#join_page").children().find(".form-group.has-error").length>0){
				$("#submitMsg").text("입력 값이 올바르지 않습니다.");
				event.preventDefault();
				return;
			}else if(!$("#privacyCheck").prop("checked")){
				$("#submitMsg").text("개인정보 수집 동의에 체크해 주세요.");
				event.preventDefault();
			}
		});
	});
</script>