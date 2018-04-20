<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="jumbotron">
	<div class="form-group" align="center">
		<a href="/"><img src="/resources/image/logo1.png" class="img-responsive"></a> <label>ADMIN SITE</label>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-xs-6" style="height:100px;">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<label>아이디 찾기</label>
						</h4>
					</div>
					<div class="panel-body">
						<div class="row" style="padding-left:10px;padding-right:10px">
							<p>
								회원 가입 시 입력한 이메일주소로 아이디를 찾을 수 있습니다.<br>
								개인 정보 보호를 위해 아이디 뒷자리는 *로 표시됩니다.
							</p>
						</div>
						<div class="row">
							<div class="col-xs-8">
								<div>
									<label class="label-control" for="#find_name">이름</label>
									<input type="text" class="form-control" id="find_name">
								</div>
								<div>
									<label class="label-control" for="#find_email">이메일</label>
									<input type="email" class="form-control" id="find_email">
								</div>
							</div>
							<div class="col-xs-4">
								<input type="button" class="btn btn-primary btn-lg" value="확인">
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
		<div class="col-xs-6">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<label>비밀번호 찾기</label>
						</h4>
					</div>
					<div class="panel-body">
						<div class="row" style="padding-left:10px;padding-right:10px">
							<p>
								회원 가입 시 입력한 입력한 정보 일치 여부 확인 후 이메일로 정보를 안내해 드립니다.<br>
								개인 정보 보호를 위해 아이디 뒷자리는 *로 표시됩니다.
							</p>
						</div>
						<div class="row">
							<div class="col-xs-8">
								<div>
									<label class="label-control" for="#find_id">아이디</label>
									<input type="text" class="form-control" id="find_id">
								</div>
								<div>
									<label class="label-control" for="#find_name">이름</label>
									<input type="text" class="form-control" id="find_name">
								</div>
								<div>
									<label class="label-control" for="#find_email">이메일</label>
									<input type="email" class="form-control" id="find_email">
								</div>
							</div>
							<div class="col-xs-4">
								<input type="button" class="btn btn-primary btn-lg" value="확인">
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
	</div>	
</div>