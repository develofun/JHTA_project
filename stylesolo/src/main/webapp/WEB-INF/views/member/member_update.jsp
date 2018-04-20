<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/member/member_update.css" type="text/css">

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
        	$(this).next().html("이메일의 길이가 짧습니다.");
          	$(this).next().addClass("check_error");
         }else if(!email_validA.test(emailAddr)){
        	$(this).next().html("@를 함께 입력해주세요");
        	$(this).next().addClass("check_error");
         }else if(!email_validDot.test(emailAddr)){
        	$(this).next().html(".를 함께 입력해주세요");
        	$(this).next().addClass("check_error");
         }else{
        	$(this).next().html("OK");
          	$(this).next().removeClass("check_error").addClass("check_ok");
         }
      });
      $("#sample6_address2").focusout(function(){
    	  if($(this).val()==""){
    		  $(this).next().html("상세주소를 입력해주세요.");
    		  $(this).next().addClass("check_error");
    	  }else{
    		  $(this).next().html("OK");
    		  $(this).next().removeClass("check_error").addClass("check_ok");
    	  }
      });
      $("form").submit(function(event){
          if($("#updatediv").children().find(".check_error").length>0){
             $("#submitMsg").text("입력 값이 올바르지 않습니다.");
             event.preventDefault();
             return;
          }
       });
   });
</script>

<script type="text/javascript">
function init() {
	var gender=document.getElementsByName("member_privacy_gender");
	for(var i=0;i<gender.length;i++){
		if(gender[i].value=="${vo.member_privacy_gender}"){
			gender[i].checked=true;
		}
	}
}
</script>

<div id="wrap_update" style="margin-left:40px;">
	
	<h2 style="color: #212121;">회원정보수정</h2>

	<div id="updatediv">
		<form method="post" action="/member/update">
			<span style="font-size: 12px; color: red;">※ 아래 입력란을 모두 입력해주세요.</span><br>
			<br>
			<table class="member_update">
				<tr>
					<th scope="row" style="width:180px;font-weight: bold; font-size: 14px;">아이디<br>
					</th>
					<td style="width:700px;font-size: 13px; color: #4C4C4C;">
					<input type="hidden" id="member_privacy_id" name="member_privacy_id" value="${vo.member_privacy_id }">
						${vo.member_privacy_id}
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">비밀번호<br>
					</th>
					<td style="font-size: 12px;">
						<a href="<c:url value='/member/member_changepwd'/>">
							<input type="button" class="btn btn-default" value="비밀번호변경">
						</a>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">이름</th>
					<td style="font-size: 13px; color: #4C4C4C;">
					<input type="hidden" id="member_privacy_name" name="member_privacy_name" value="${vo.member_privacy_name }">
						${vo.member_privacy_name }
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">성별</th>
					<td style="font-size: 12px;">
						<input type="radio" name="member_privacy_gender" value="남자">남자
						<input type="radio"	name="member_privacy_gender" value="여자">여자
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">생년월일</th>
					<td>
						<input type="date" id="member_privacy_birth" name="member_privacy_birth"
						 class="form-control" style="width:160px;height:34px;" value="${vo.member_privacy_birth }">
						 <span></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">휴대폰</th>
					<td>
						<input type="text" id="member_privacy_phone" name="member_privacy_phone"
						 class="form-control" style="width:160px;height:34px;" value="${vo.member_privacy_phone }">
						 <span></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">이메일<br>
					</th>
					<td>
						<input type="email" id="member_privacy_email" name="member_privacy_email"
						 class="form-control" style="width:160px;height:34px;" value="${vo.member_privacy_email }">
						 <span></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">주소</th>
					<td><input type="text" id="sample6_postcode" placeholder="우편번호" size="10px" class="update_textboxStyle"
						name="member_privacy_addr" style="width: 80px;height:34px;" value="${addrNum }" readonly="readonly">
						<input type="button" onclick="sample6_execDaumPostcode()" class="btn btn-default" value="우편번호 찾기"><br>
						<input type="text" id="sample6_address" placeholder="주소" name="member_privacy_addr" 
						class="update_textboxStyle" style="width: 280px;height:34px;" value="${addr1 }" readonly="readonly">
						<input type="text" id="sample6_address2" placeholder="상세주소" name="member_privacy_addr"
						class="update_textboxStyle" style="width: 140px;height:34px;" value="${addr2 }">
						<span></span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" class="btn btn-primary" style="width:100px;" value="정보변경"><br>
							<span id="submitMsg"></span>
						</div>
					</td>
				</tr>

			</table>

		</form>
	</div>
	
</div>
