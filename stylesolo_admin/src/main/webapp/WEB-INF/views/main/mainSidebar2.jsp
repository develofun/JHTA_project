<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="well col-md-12">
			<p>
				<label>#아이디# 님 환영합니다.</label>
			</p>
			<p>
				<label>접속 시간: </label>
			</p>
			<p>
				<label>접속 IP: </label>
			</p>
			<p class="container col-md-12">
				<input type="button" class="btn btn-default" value="My Info">
				<input type="button" class="btn btn-default" value="접속 기록">
			</p>
		</div>
	</div>
	<div class="row">
		<div class="panel-group" id="accordion">
			<div class="panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapse1">고객센터 관리</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<ul class="list-group">
						<li class="list-group-item"><a href="/consult_list">상담 게시판</a></li>
						<li class="list-group-item"><a href="#">템플릿 관리</a></li>
						<li class="list-group-item"><a href="#">상담 카테고리 관리</a></li>
					</ul>
				</div>
			</div>
			<div class="panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapse2">회원 관리</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse">
					<ul class="list-group">
						<li class="list-group-item">회원 전체 보기</li>
						<li class="list-group-item">회원 상세 정보</li>
						<li class="list-group-item">포인트 관리</li>
						<li class="list-group-item">탈퇴 회원 관리</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
