<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_upload_request.css" type="text/css">

<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script>
   /* 유효성 체크 */
   $(function(){
	  var check_error=0;
	   
      $("#new_password").focusout(function(){
         var new_pwd=$(this).val();
         var newpwd_valid=/^[a-zA-Z0-9_-]{6,14}$/;
         var msg="";
         if(!newpwd_valid.test(new_pwd)){
        	$(this).next().html("비밀번호 형식에 맞지 않습니다.<br> (6~14자 영문(대,소), 숫자)");
        	$(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("비밀번호 형식에 알맞습니다.");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
      });
      $("#new_password_check").focusout(function(){
         var msg="";
         if($(this).val().length>=6){
	         if($(this).val()!=$("#new_password").val()){
	            $(this).next().html("비밀번호가 일치하지 않습니다.");
	            $(this).next().addClass("check_error");
	         }else{
	        	$(this).next().html("비밀번호가 일치합니다.");
	        	$(this).next().removeClass("check_error").addClass("check_ok");
	         }
         }else{
        	 $(this).next().html("비밀번호 길이가 짧습니다.");
         }
      });
      $("form").submit(function(event){
          console.log($("#wrap").children().find(".check_error").length);
          if($("#wrap").children().find(".check_error").length>0){
        	  $("#submitMsg").text("입력 값이 올바르지 않습니다.");
             event.preventDefault();
             return;
          }else{
        	  alert('비밀번호 변경이 정상적으로 처리되었습니다.');
          }
       });
   });
</script>

<div id="wrap">
	<div id="gonggu_upload_request">
		<h2>비밀번호 변경</h2>
		<hr style="width:100px;float:left;">
		<br>
		<br>
		<br>
		<span style="font-size:12px;font-weight:bold; color: #353535;">본인확인이 완료되었습니다.<br>
			새 비밀번호를 입력해주세요.</span><br>
		<div id="gonggu_upload_request_div" style="margin-left:100px;">
			<form method="post" action="/member/new_change_password">
				<input type="text" id="id" name="id" value="${id}" class="form-control" style="width:200px;" readonly="readonly"><br>
				<input type="password" id="new_password" name="new_password" placeholder="새 비밀번호 입력" class="form-control" style="width:200px;">
				<span class="check_error"></span><br>
				<input type="password" id="new_password_check" name="new_password_check" placeholder="새 비밀번호 입력확인" class="form-control" style="width:200px;">
				<span class="check_error"></span><br>
				<div align="left">
					<input type="submit" class="btn btn-primary" id="btn_submit" value="변경하기" style="width:200px;"><br>
					<span id="submitMsg" style="color:red;"></span>
				</div>
			</form>
			<br>
			<br>
		</div>
	</div>
</div>