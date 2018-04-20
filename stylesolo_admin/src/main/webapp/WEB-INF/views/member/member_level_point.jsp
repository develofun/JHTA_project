<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<div class="form-inline">
		<h3>
			등급 / 포인트 관리
			<small>회원 관리</small>
		</h3>
	</div>
</div>

<div class="display-table">
	<div class="display-table-row">
		<div class="display-table-cell">
			<label>회원 검색</label>
		</div>
		<div class="display-table-cell">
			<select class="form-control">
				<option value="아이디">아이디</option>
				<option value="회원코드">회원코드</option>
				<option value="이름">이름</option>
				<option value="전화번호">전화번호</option>
			</select>			
		</div>
		<div class="display-table-cell">
			<input type="text" class="form-control"	 placeholder="회원 아이디 입력">
		</div>
		<div class="display-table-cell">
			<input type="button" class="btn btn-primary" value="검색">
		</div>
	</div>
</div>

<div class="box box-side">
	<div class="box-header with-borer">
		<h4 class="box-title">등급 관리 관리</h4>
	</div>
</div>

<div class="box box-side">
	<div class="box-header with-borer">
		<h4 class="box-title">포인트 관리</h4>
	</div>
</div>

<div class="box">
	<div class="box-header with-borer">
		<h4 class="box-title">포인트 정보</h4>
	</div>
	<div class="box-body">
		<table class="table table-bordered">
			<tr><th>회원코드</th><td></td><th>아이디</th><td></td></tr>
			<tr><th>보유 포인트</th><td></td><th>누적 사용 포인트</th><td></td></tr>
		</table>
		<table class="table table-bordered">
			<tr><td colspan="5">포인트 로그</td></tr>
			<tr><th>구분</th><th>사용처</th><th>사용 일시</th><th>증감 포인트</th><th>보유 포인트</th></tr>
			<tr><td>사용</td><td>소액결제</td><td>2017-01-01 11:11:11</td><td>-10,000</td><td>210,000</td></tr>
			<tr><td>사용</td><td>소액결제</td><td>2017-01-01 11:11:11</td><td>-10,000</td><td>210,000</td></tr>
			<tr><td>사용</td><td>소액결제</td><td>2017-01-01 11:11:11</td><td>-10,000</td><td>210,000</td></tr>
		</table>
	</div>
</div>
