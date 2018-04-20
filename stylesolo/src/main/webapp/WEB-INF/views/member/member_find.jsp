<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/member/member_find.css" type="text/css">

<script src="/resources/js/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		var temporaryPassword="";
		$("#btn_idok").click(function(){
			var params="member_privacy_name="+$("#fi_member_name").val()+"&member_privacy_phone="+$("#fi_member_phone").val()+"&member_privacy_birth="+$("#fi_member_birth").val();
			$.ajax({
				type: 'POST',
				url: '/member/lookForAnAccount',
				data: params,
				success: function(data) {
					if(data == null) {
						$("#span_findId_result").css("color","red").html("해당 정보를 조회할 수 없습니다.");
					}else{
						$("#span_findId_result").css("color","green").html("회원님의 아이디는 "+data.substr(0,(length-3))+"*** 입니다.");
					}
				}
			});
		});
		$("#btn_pwdok").click(function(){
			var params="member_privacy_id"+$("#fp_member_id").val()+"&member_privacy_email"+$("#fp_member_email").val()+"&member_privacy_phone"+$("#fp_member_phone").val();
			$.ajax({
				type:'POST',
				url:'/member/lookForAnAccount',
				data:params,
				success:function(data){
					if(data == null){
						$("#span_findPwd_result").css("color","red").html("해당 정보를 조회할 수 없습니다.");
					}else{
						$("#span_findPwd_result").css("color","green").html("해당 정보가 정상적으로 조회되었습니다.<br>");
						$("#span_findPwd_result").append("<a href='/member/changepwd_new?id="+$("#fp_member_id").val()+"' style='font-size:18px;font-weight:bold;'>새 비밀번호 등록하러 가기</a>");
					}
				}
			})
		});
	});
</script>

<div id="wrap">
	<div id="findid">
		<h2>아이디 찾기</h2>
		<hr style="width:100px;float:left;">
		<br>
		<br>
		<br>
		<span style="font-size:12px;font-weight:bold; color: #353535;">회원정보에 입력한 이름과 생년월일, 전화번호로 아이디를 찾을 수 있습니다.<br>
			개인 정보 보호를 위해 아이디 뒷자리 3개는 *로 표시됩니다.</span><br>
		<div id="findid_insert" style="margin-left:100px;">
			<input type="text" id="fi_member_name" class="form-control" placeholder="이름을 입력해주세요." style="height:34px;width:200px;"><br>
			<input type="text" id="fi_member_phone" class="form-control" placeholder="전화번호를 입력해주세요." style="height:34px;width:200px;"><br>
			<input type="date" id="fi_member_birth" class="form-control" style="height:34px;width:200px;"><br>
			<input type="button" id="btn_idok" class="btn btn-primary" value="확인" style="width:200px;"><br>
			<br>
			<br>
		</div>
		<div id="findid_result" align="center">
			<span id="span_findId_result"></span>
		</div>
	</div>
	<div id="findpwd">
		<h2>비밀번호 찾기</h2>
		<hr style="width:100px;float:left;">
		<br>
		<br>
		<br>
		<span style="font-size:12px;font-weight:bold; color: #353535;">회원정보에 입력한 이메일 주소로 인증이 가능합니다.<br>
			본인인증 후, 새로운 비밀번호를 입력해 주세요.</span><br>
		<div id="findpwd_insert" style="margin-left:100px;">
			<input type="text" id="fp_member_id" class="form-control" placeholder="아이디를 입력해주세요." style="height:34px;width:200px;"><br>
			<input type="text" id="fp_member_email" class="form-control" placeholder="이메일을 입력해주세요." style="height:34px;width:200px;"><br>
			<input type="text" id="fp_member_phone" class="form-control" placeholder="전화번호를 입력해주세요." style="height:34px;width:200px;"><br>
			<input type="button" id="btn_pwdok" class="btn btn-primary" value="확인" style="width:200px;"><br>
			<br>
		</div>
		<div id="findpwd_result" align="center">
			<span id="span_findPwd_result"></span>
		</div>
	</div>
</div>
