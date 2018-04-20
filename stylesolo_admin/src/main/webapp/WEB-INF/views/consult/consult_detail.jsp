<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3 class="page-header">상담 상세 내용</h3>

<div>
	<label>카테고리</label>
	<select class="form-control">
		<option value="#">문의</option>
		<option value="#">개선</option>
		<option value="#">건의</option>
	</select>
</div>
<div>
	<label>템플릿 선택</label>
	<select class="form-control">
		<option value="#">템플릿 선택</option>
		<option value="#">테스트트트</option>
		<option value="#">오오오</option>
	</select>
</div>

<h3 class="page-header">문의 리스트</h3>
<div id="detail_table">
	<table class="table table-hover">
		<tr><th>아이디</th><td></td></tr>
		<tr><th>제목</th><td></td></tr>
		<tr><th>내용</th><td></td></tr>
		<tr><th>이메일</th><td></td></tr>
		<tr><th>작성일</th><td></td></tr>
		<tr><th>첨부파일</th><td></td></tr>
	</table>
	<form method="post" action="">
		<table class="table table-hover">
			<tr><th>처리자</th><td>${session.login_id }</td></tr>
			<tr><th>내용</th><td></td></tr>
			<tr><th>첨부파일</th><td></td></tr>
			<tr>
				<td>
					<input type="submit" class="btn btn-primary" value="답변 완료">
					<input type="button" class="btn btn-primary" value="답변 취소" onClick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
		
	</form>
</div>