<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="jumbotron">
	<div class="form-group" align="center">
		<img src="/resources/image/logo1.png" class="img-responsive"> <label>ADMIN SITE</label>
	</div>
</div>
<div class="container" style="width:500px;margin:auto;">
		<form class="form-horizontal" method="post" action="loginCheck">
			<div class="form-group">
				<label class="control-label col-sm-3" for="loginId">아이디</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="loginId" name="login_id" placeholder="아이디를 입력하세요.">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="loginPwd">비밀번호</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="loginPwd" name="loginPwd" placeholder="비밀번호를 입력하세요.">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-8">
					<label class="checkbox-inline"><input type="checkbox">Remember me</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-8">
					<input type="button" class="btn btn-default" style="width:90px;margin:3px" value="로그인" onClick="javascript:location.href='admin_login'">
					<input type="button" class="btn btn-default" style="width:90px;margin:3px" value="계정 신청" id="btn_join" onClick="javascript:location.href='/join'">
					<input type="button" class="btn btn-default" style="width:90px;margin:3px" value="계정 찾기" id="btn_find_account" onClick="javascript:location.href='/admin_find_account'">
				</div>
			</div>
		</form>
</div>