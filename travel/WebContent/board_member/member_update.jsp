<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//code.jquery.com/jquery.min.js"></script>
<div>
<h4>회원 정보 수정</h4>

<br><br>
<form method="post" action="/member.do?cmd=member_update" id="frm">
	<div class="form-group">
			<label for="inputId" class="input_title">아이디 : </label>
			<input type="text" class="@@@@@@" id="login_id1" name="login_id" onkeyup="idcheck()"  maxlength="12" value="${dto.login_id }" disabled/>
			<span id="idresult"></span><br>
	</div>
	<div class="form-group">
		<label for="inputPassword" class="input_title">비밀번호 : </label>
		<input type="password" class="@@@@@@" id="member_password1" name="member_password" placeholder="비밀번호"><br>
	</div>
	<div class="form-group">
		<label for="inputPasswordChec" class="input_title">비밀번호 확인 : </label>
		<input type="password" class="@@@@@@" id="member_password2" name="member_password" onkeyup="pwdcheck()" placeholder="비밀번호 확인">
		<span id="pwdresult"></span><br>
	</div>
	<div class="form-group">
		<label for="inputNickname" class="input_title">닉네임 : </label>
		<input type="text" class="@@@@@@" id="member_nickname" name="member_nickname" onkeyup="nicknamecheck()" value="${dto.member_nickname }">
		<span id="nicknameresult"></span><br>
	</div>
	<div class="form-group">
		<label for="inputName" class="input_title">이름 : </label>
		<input type="text" class="@@@@@@" id="member_name" name="member_name" value=${dto.member_name }>
	</div>
	<div class="form-group">
		<label for="inputName" class="member_birthday">생년월일 : </label>
		<input type="date" name="member_birthday" >
	</div>
	<div class="form-group">
		<label for="inputPhone" class="input_title">전화번호 : </label>
		<input type="text" class="@@@@@@" id="member_phone" name="member_phone"  maxlength="11" value="0${dto.member_phone }">
	</div>
	<div class="form-group">
		<label for="inputName" class="input_title">이메일 : </label>
		<input type="email" class="@@@@@@" id="member_email" name="member_email" onkeyup="emailcheck()" value="${dto.member_email }">
		<span id="emailresult"></span><br>
	</div>
	<input type="button" value="수정" onclick="checkValue()">
	<input type="reset" value="취소">
</form>

</div>
<script>
	var xhr=null;
	function idcheck(){
		var login_id=document.getElementById("login_id1").value;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=idcheckResult;
		xhr.open("get","/board_member/member_idcheck.jsp?login_id=" + login_id, true);
		xhr.send();
	}
	function idcheckResult(){
		if(xhr.readyState==4 && xhr.status==200){//응답이 성공적으로 완료된 경우
			var xml=xhr.responseXML;//응답결과를 xml로 얻어오기
			var using=xml.getElementsByTagName("using")[0].firstChild.nodeValue;
			var idresult=document.getElementById("idresult");//결과를 출력할 span
			if(eval(using)==true){
				idresult.innerHTML="사용중인 아이디 입니다.";
			}else{
				idresult.innerHTML="";
			}
		}
	}
	function pwdcheck(){
		var member_password1=document.getElementById("member_password1").value;
		var member_password2=document.getElementById("member_password2").value;
		var pwdresult=document.getElementById("pwdresult");
		if(member_password1!=member_password2){
			pwdresult.innerHTML="비밀번호 일치하지 않습니다.";
		}else{
			pwdresult.innerHTML="비밀번호 일치합니다.";
		}
	}
	var xhr1=null;
	function nicknamecheck(){
		var member_nickname=document.getElementById("member_nickname").value;
		xhr1=new XMLHttpRequest();
		xhr1.onreadystatechange=nicknamecheckResult;
		xhr1.open("get","/board_member/member_nicknamecheck.jsp?member_nickname=" + member_nickname, true);
		xhr1.send();
	}
	function nicknamecheckResult(){
		if(xhr1.readyState==4 && xhr1.status==200){//응답이 성공적으로 완료된 경우
			var xml=xhr1.responseXML;//응답결과를 xml로 얻어오기
			var using=xml.getElementsByTagName("using")[0].firstChild.nodeValue;
			var nicknameresult=document.getElementById("nicknameresult");//결과를 출력할 span
			if(eval(using)==true){
				nicknameresult.innerHTML="사용중인 닉네임 입니다.";
			}else{
				nicknameresult.innerHTML="";
			}
		}
	}
	var xhr2=null;
	function emailcheck(){
		var member_email=document.getElementById("member_email").value;
		xhr2=new XMLHttpRequest();
		xhr2.onreadystatechange=emailcheckResult;
		xhr2.open("get","/board_member/member_emailcheck.jsp?member_email=" + member_email, true);
		xhr2.send();
	}
	function emailcheckResult(){
		if(xhr2.readyState==4 && xhr2.status==200){//응답이 성공적으로 완료된 경우
			var xml=xhr2.responseXML;//응답결과를 xml로 얻어오기
			var using=xml.getElementsByTagName("using")[0].firstChild.nodeValue;
			var emailresult=document.getElementById("emailresult");//결과를 출력할 span
			if(eval(using)==true){
				emailresult.innerHTML="사용중인 이메일 입니다.";
			}else{
				emailresult.innerHTML="";
			}
		}
	}
	function checkValue(){
		var idresult = document.getElementById("idresult").innerHTML;
		var pwdresult = document.getElementById("pwdresult").innerHTML;
		var nicknameresult = document.getElementById("nicknameresult").innerHTML;
		var emailresult = document.getElementById("emailresult").innerHTML;
		var member_phone = document.getElementById("member_phone").value;
		
		var login_id = document.getElementById("login_id1").value;
		var member_password = document.getElementById("member_password1").value;
		var member_nickname = document.getElementById("member_nickname").value;
		var member_name = document.getElementById("member_name").value;
		var member_email = document.getElementById("member_email").value;
		
		var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		var pattern = /^[A-Za-z0-9]{4,12}$/;

		
		if(login_id == ""){
			alert("아이디 입력하세요!");
			return false;
		}else if(member_password == ""){
			alert("비밀번호 입력하세요!");
			return false;
		}else if(member_nickname == ""){
			alert("닉네임 입력하세요!");
			return false;
		}else if(member_name == ""){
			alert("이름 입력하세요!");
			return false;
		}else if(member_phone == ""){
			alert("전화번호 입력하세요!");
			return false;
		}else if(member_email == ""){
			alert("이메일 입력하세요!");
			return false;
		}else if(regex.test(member_email) == false){
			alert("이메일 형식에 맞지않습니다!");
			return false;
		}else if(pattern.test(login_id) == false){
			alert("영문대,소문자 , 숫자 4 ~12 자리로 입력해 주세요!");
			return false;
		}else if(idresult == ("사용중인 아이디 입니다.")){
			alert("사용중인 아이디 입니다.");
			return false;
		}else if(pwdresult == ("비밀번호 일치하지 않습니다.")){
			alert("비밀번호 일치하지 않습니다.");
			return false;
		}else if(nicknameresult == ("사용중인 닉네임 입니다.")){
			alert("사용중인 닉네임 입니다.");
			return false;
		}else if (!(member_phone >= '0' && member_phone <= '9')) {
			alert("전화번호는 숫자만 입력 하세요");
	        return false;
	    }else if(emailresult == ("사용중인 이메일 입니다.")){
			alert("사용중인 이메일 입니다.");
			return false;
		}else if(login_id == null){
			alert("아이디 입력하세요!");
			return false;
		}
		document.getElementById("frm").submit();
	}

</script>






