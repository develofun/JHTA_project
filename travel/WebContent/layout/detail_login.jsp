<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	// 로그인 일시가지고 오기
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	time.setTime(session.getCreationTime());
%>
<div id="detail_login">
	<div id="logout">
		<c:if test="${empty sessionScope.member_nickname }">
			<!-- 항상실행됨 -->
			<div class="form-login" style="float: left;">
				<label for="inputId" class="input_title">아이디 : </label> <input
					type="text" class="@@@@@@" id="login_id" name="login_id"
					placeholder="아이디" required>
			</div>
			<div class="form-login" style="float: left;">
				<label for="inputPassword" class="input_title">비밀번호 : </label> <input
					type="password" class="@@@@@@" id="member_password"
					name="member_password" placeholder="비밀번호" required><br>
			</div>
			<div  class="form-login" style="float: left;">
				<input type="button" value="로그인" onclick="tab_login()">
				<input type="button" value="회원가입" onclick="javascript:location.href='/member.do?cmd=member_insert_page'">
			</div>
		</c:if>
	</div>
	<div>
		<c:if test="${not empty sessionScope.member_nickname }">
			<div class="form-login">
				<p>${sessionScope.member_nickname }
					님 환영합니다.
				</p>
			</div>
			<div class="form-login">
				<p>
					로그인 일시 :
					<%=formatter.format(time)%></p>
			</div>
			<div class="form-login">
				<p>
					로그인 IP :
					<%=request.getRemoteAddr()%></p>
			</div>
			<div class="form-login">
				<a href="/board_member/member_logout.jsp">로그아웃</a>
			</div>
		</c:if>
	</div>
</div>
<script>
	var xhr=null;
	function tab_login(){
		var id=document.getElementById("login_id").value;
		var password=document.getElementById("member_password").value;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=result;
		xhr.open("post","/member.do?cmd=member_tab_login",true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
		var param="login_id="+id+"&member_password="+password;
		xhr.send(param);
	}
	function result(){
		if(xhr.readyState==4 && xhr.status==200){
			xml=xhr.responseXML;
			var login_result=xml.getElementsByTagName("result")[0].firstChild.nodeValue;
			var nickname=xml.getElementsByTagName("nickname")[0].firstChild.nodeValue;
			var detail_login=document.getElementById("detail_login");
			if(login_result=="success"){
				var html=nickname+"님 환영합니다. 로그인 일시 : <%=formatter.format(time)%>&nbsp;&nbsp;<a href='/board_member/member_logout.jsp'>로그아웃</a>";
				detail_login.innerHTML=html;
				var btn_write=document.getElementById("btn_write");
				var btn_delete=document.getElementById("btn_delete");
				var btn_modify=document.getElementById("btn_modify");
				var btn_cancel=document.getElementById("btn_cancel");
				var update_link=document.getElementById("update_link");
				var writer_div=document.getElementById("writer");
				var comment_input_div=document.getElementById("comment_input_div");
				if(btn_write!=null){
					btn_write.style.display="block";
				}
				if(update_link!=null && "${sessionScope.member_power}"=="admin"){
					update_link.style.display="block";
				}
				if(writer_div.innerHTML=="${sessionScope.nickname}"){
					btn_modify.style.display="block";
				}
				btn_delete.style.display="block";				
				btn_cancel.style.display="block";
				comment_input_div.style.display="block";
			}else{
				var input_password=xml.getElementsByTagName("password")[0].firstChild.nodeValue;
				var id=document.getElementById("login_id");
				var password=document.getElementById("member_password");
				id.value=input_id;
				password.value=input_password;
			}
		}
	}
</script>