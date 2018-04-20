<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3 class="page-header">템플릿 관리</h3>
<div style="border-left:3px solid #d2d6de;box-shadow:1px 1px 1px rgba(0, 0, 0, 0.1);
			margin-bottom:10px;padding-bottom:1px">
	<div class="form-group">
		<div class="form-inline">
			<label style="width:100px;text-align:center">카테고리</label>
			<select class="form-control">
				<option value="#">전체 카테고리</option>
				<option value="#">문의</option>
				<option value="#">개선</option>
				<option value="#">건의</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="form-inline">
			<label style="width:100px;text-align:center">구분</label>
			<select class="form-control">
				<option value="#">제목</option>
				<option value="#">등록자</option>
			</select>
			<input type="text" class="form-control" placeholder="텍스트를 입력해 주세요.">
			<input type="button" class="btn btn-primary" value="검색">
		</div>
	</div>
</div>
<div class="form-group">
	<div style="float:left">
			<label>총 ${template_total_count }건 | 쪽번호 ${template_pageNum }/${template_total_pageNum }</label>	
		</div>
		<div style="float:left">
		</div>
		<div style="float:right">
			<input type="button" class="btn btn-primary" value="등록">
			<input type="button" class="btn btn-primary" value="선택 삭제">		
		</div>
</div>
<div id="template_table">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><span class="glyphicon glyphicon-ok"></span></th>
				<th>NO</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>등록자</th>
				<th>등록 일시</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="checkbox"></td>
				<td>1</td>
				<td>문의</td>
				<td>결제 관련 템플릿1</td>
				<td>admin111</td>
				<td>2017-01-03 16:15:54</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>1</td>
				<td>문의</td>
				<td>결제 관련 템플릿1</td>
				<td>admin111</td>
				<td>2017-01-03 16:15:54</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>1</td>
				<td>문의</td>
				<td>결제 관련 템플릿1</td>
				<td>admin111</td>
				<td>2017-01-03 16:15:54</td>
			</tr>
		</tbody>
	</table>
</div>