<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 로고 클릭 시 메인 화면으로 이동 -->
<!-- <a href=".main" class="logo">
	mini logo for sidebar mini 50x50 pixels
	<span class="logo-mini"><b>S.S</b>-AD</span>
	logo for regular state and mobile devices
	<span class="logo-lg"><b>StyleSolo</b>ADMIN</span>
</a>
<nav id="header_find" class="navbar navbar-static-top">
	<form method="post" action="" class="form-horizontal">
		<div class="form-group">
			<div class="checkbox" style="float:right">
				<label><input type="checkbox" name="member_find">회원 검색</label>
				<label><input type="checkbox" name="consult_find">상담 검색</label>
				<select name="find_condition">
					<option value="member_id">아이디</option>
					<option value="member_uni">회원번호</option>
					<option value="member_name">이름</option>
				</select>
				<input type="text" name="find_text">
				<input type="submit" value="검색">
			</div>
		</div>
	</form>	
</nav> -->

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">			
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/admin_login">StyleSolo ADMIN</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/">로그아웃</a></li>
			</ul>
			<form class="navbar-form navbar-right"style="color:gray">
				<label class="checkbox-inline"><input type="checkbox" name="search-member">회원검색</label>
				<label class="checkbox-inline"><input type="checkbox" name="search-consult">상담검색</label>
				<select class="form-control" name="search_condition">
			        <option>아이디</option>
			        <option>이름</option>
			        <option>회원번호</option>
			        <option>전화번호</option>
			        <option>이메일</option>
			    </select>		
				<input type="text" class="form-control" placeholder="검색어 입력...">
				<button class="btn btn-default" type="submit">
					<i class="glyphicon glyphicon-search"></i>
				</button>
				
			</form>
		</div>
	</div>
</nav>