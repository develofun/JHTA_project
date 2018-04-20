<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/member/member_join.css" type="text/css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample6_address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('sample6_address2').focus();
					}
				}).open();
	}
</script>


<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script>
   /* 유효성 체크 */
   $(function(){
	  var check_error=0;
	   
      $("input").focusin(function(){
         $(this).next().next().text("");
      });
      $("input").focusin(function(){
          $(this).next().text("");
      });
      
      $("#member_privacy_id").focusout(function(){
         var join_id=$(this).val();
         var id_valid=/^[a-z0-9_-]{6,14}$/;
         var msg="";
         if(!id_valid.test(join_id)){
            $(this).next().next().html("아이디 형식에 맞지 않습니다.(6~14자 영문(소), 숫자)");
            $(this).next().next().addClass("check_error");
         }else{
            $(this).next().next().html("아이디 형식에 알맞습니다.");
            $(this).next().next().removeClass("check_error").addClass("check_ok");
         }
      });
      $("#member_privacy_pwd").focusout(function(){
         var join_pwd=$(this).val();
         var pwd_valid=/^[a-zA-Z0-9_-]{6,14}$/;
         var msg="";
         if(!pwd_valid.test(join_pwd)){
        	$(this).next().html("비밀번호 형식에 맞지 않습니다. (6~14자 영문(대,소), 숫자)");
        	$(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("비밀번호 형식에 알맞습니다.");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
      });
      $("#member_privacy_checkpwd").focusout(function(){
         var msg="";
         if($(this).val().length>=6){
	         if($(this).val()!=$("#member_privacy_pwd").val()){
	            $(this).next().html("비밀번호가 일치하지 않습니다.");
	            $(this).next().addClass("check_error");
	         }else{
	        	$(this).next().html("비밀번호가 일치합니다.");
	        	$(this).next().removeClass("check_error").addClass("check_ok");
	         }
         }else{
        	 $(this).next().html("");
         }
      });
      $("#member_privacy_name").focusout(function(){
          var msg="";
          if($(this).val().length<2){
             $(this).next().html("이름을 올바르게 입력해 주세요.");
             $(this).next().addClass("check_error");
          }else{
        	 $(this).next().html("OK");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
          }
      });
      $("#member_privacy_birth").focusout(function(){
         var msg="";
         if($(this).val()==""){
            $(this).next().html("생년월일을 입력해 주세요.");
            $(this).next().addClass("check_error");
         }else{
        	$(this).next().html("OK");
        	$(this).next().removeClass("check_error").addClass("check_ok");
         }
      });
      $("#member_privacy_phone").focusout(function(){
         var phone_valid=/[-]/;
         var join_phone=$(this).val();
         var msg="";
         if($(this).val().length<10 || $(this).val().length>11){
         	$(this).next().html("10~11자 이내의 핸드폰번호를 입력해주세요.");
         	$(this).next().addClass("check_error");
         }else if(phone_valid.test(join_phone)){
        	$(this).next().html("-를 빼고 입력해주세요.");
          	$(this).next().addClass("check_error");
         }else{
        	$(this).next().html("OK");
         	$(this).next().removeClass("check_error").addClass("check_ok");
         }
      });
      $("#member_privacy_email").focusout(function(){
         var email_validA=/[@]/;
         var email_validDot=/[.]/;
         var emailAddr=$(this).val();
         if($(this).val().length<13){
        	$(this).next().next().html("이메일의 길이가 짧습니다.");
          	$(this).next().next().addClass("check_error");
         }else if(!email_validA.test(emailAddr)){
        	$(this).next().next().html("@를 함께 입력해주세요");
        	$(this).next().next().addClass("check_error");
         }else if(!email_validDot.test(emailAddr)){
        	$(this).next().next().html(".를 함께 입력해주세요");
        	$(this).next().next().addClass("check_error");
         }else{
        	$(this).next().next().html("OK");
          	$(this).next().next().removeClass("check_error").addClass("check_ok");
         }
      });
      $("#member_privacy_checkemail").focusout(function(){
    	 if($(this).val().length<6){
    		$(this).next().next().html("인증코드의 길이가 짧습니다.");
           	$(this).next().next().addClass("check_error");
    	 }else{
    		$(this).next().next().html("OK");
           	$(this).next().next().removeClass("check_error").addClass("check_ok");
    	 }
      });
            
      $("form").submit(function(event){
          console.log($("#wrap").children().find(".check_error").length);
          if($("#wrap").children().find(".check_error").length>0){
             $("#submitMsg").text("입력 값이 올바르지 않습니다.");
             event.preventDefault();
             return;
          }
       });
   });
</script>
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_idcheck").click(function(){
			$.ajax({
				url:'/idCheck/'+$("#member_privacy_id").val(),
				dataType:'json',
				success:function(data){
					if(data.idcheck==true){
						$("#span_idcheck").css("color","red").html("[사용중인 아이디입니다.]");
					}else{
						$("#span_idcheck").css("color","green").html("[사용가능한 아이디입니다.]");
					}
				}
			});
		});
	});
</script>

<div id="wrap">
	
	<h2 style="color: #212121;">회원가입</h2>
	<hr>
	<br>

	<div id="joindiv">
		<form method="post" action="/member/save/join">

			<span style="font-weight: bold; color: #353535;">개인정보입력</span>
			<span style="font-size: 12px; color: red;">※ 아래 입력란을 모두 입력해주세요.</span>
			<table class="member_join">
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">아이디<br>
					<span style="font-size:10px; color: gray;">※ 영문+숫자 조합 6~14자 이내</span>
					</th>
					<td style="font-size: 12px; color: gray;">
						<input type="text" id="member_privacy_id" name="member_privacy_id" class="textboxStyle" style="height:34px;">
						<input type="button" id="btn_idcheck" name="btn_idcheck" value="중복확인">
						<span class="check_error"></span><br>
						<span id="span_idcheck"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">비밀번호<br>
					<span style="font-size:10px; color: gray;">※ 영문+숫자 조합 6~14자 이내</span>
					</th>
					<td style="font-size: 12px;">
						<input type="password" id="member_privacy_pwd" name="member_privacy_pwd" class="textboxStyle" style="font-size: 30px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">비밀번호확인</th>
					<td style="font-size: 12px;">
						<input type="password" id="member_privacy_checkpwd" name="member_privacy_checkpwd" class="textboxStyle" style="font-size: 30px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">이름</th>
					<td>
						<input type="text" id="member_privacy_name" name="member_privacy_name" class="textboxStyle"  style="height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">성별</th>
					<td style="font-size: 12px;">
						<input type="radio" name="member_privacy_gender" value="남자" checked="checked">남자
						<input type="radio" name="member_privacy_gender" value="여자">여자
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">생년월일</th>
					<td>
						<input type="date" id="member_privacy_birth" name="member_privacy_birth" class="textboxStyle" style="width:140px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">휴대폰<br>
					<span style="font-size:10px; color: gray;">※ "-"없이 숫자(10~11자)만 입력</span>
					</th>
					<td>
						<input type="text" id="member_privacy_phone" name="member_privacy_phone" class="textboxStyle" style="height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">이메일<br>
					<span style="font-size:10px; color: gray;">※ 인증코드를 받을 이메일 입력</span>
					</th>
					<td>
						<input type="email" id="member_privacy_email" name="member_privacy_email" class="textboxStyle" style="height:34px;">
						<input type="button" id="btn_sendcode" value="코드전송">	
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">이메일인증코드</th>
					<td>
						<input type="text" id="member_privacy_checkemail" name="member_privacy_checkemail" class="textboxStyle" style="height:34px;">
						<input type="button" id="btn_checkcode" value="코드확인">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">주소</th>
					<td>
						<input type="text" id="sample6_postcode" placeholder="우편번호" size="10px" class="textboxStyle" style="width: 80px;height:34px;" name="member_privacy_addr">
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="btn_addr"><br>
						<input type="text" id="sample6_address" placeholder="주소" name="member_privacy_addr" class="textboxStyle" style="width: 300px;height:34px;">
						<input type="text" id="sample6_address2" placeholder="상세주소" name="member_privacy_addr" class="textboxStyle" style="width: 140px;height:34px;">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="btn1" value="회원가입"><br>
						<span id="submitMsg" style="color:red;"></span>
					</td>
				</tr>

			</table>
			<br>
			<br>

		</form>
	</div>
</div>