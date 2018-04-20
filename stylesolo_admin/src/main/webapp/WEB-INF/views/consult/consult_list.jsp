<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3 class="page-header">상담 게시판</h3>

<div class="display-table">
	<div class="display-table-row">
		<div class="main_chart" style="border:1px solid black;height:200px;">
			미처리 건	
		</div>
		<div class="main_chart" style="border:1px solid black;height:200px;">
			오늘 인입 건
		</div>
		<div class="main_chart" style="border:1px solid black;height:200px;">
			오늘 처리건
		</div>
		<div class="main_chart" style="border:1px solid black;height:200px;">
			--
		</div>
	</div>
</div>

<h3 class="page-header">문의 리스트</h3>
<div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>NO</th>
				<th>카테고리</th>
				<th>상태</th>
				<th>제목</th>
				<th>아이디</th>
				<th>처리자</th>
				<th>접수일</th>
				<th>처리일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>문의</td>
				<td>처리중</td>
				<td><a href="/consult_detail">테스트 제목임다</a></td>
				<td>test111</td>
				<td>admin11</td>
				<td>2016-01-01 12:25:22</td>
				<td>2016-01-01 12:25:22</td>
			</tr>
			<tr>
				<td>1</td>
				<td>문의</td>
				<td>처리중</td>
				<td><a href="#">테스트 제목임다</a></td>
				<td>test111</td>
				<td>admin11</td>
				<td>2016-01-01 12:25:22</td>
				<td>2016-01-01 12:25:22</td>
			</tr>
			<tr>
				<td>1</td>
				<td>문의</td>
				<td>처리중</td>
				<td><a href="#">테스트 제목임다</a></td>
				<td>test111</td>
				<td>admin11</td>
				<td>2016-01-01 12:25:22</td>
				<td>2016-01-01 12:25:22</td>
			</tr>
			<tr>
				<td>1</td>
				<td>문의</td>
				<td>처리중</td>
				<td><a href="#">테스트 제목임다</a></td>
				<td>test111</td>
				<td>admin11</td>
				<td>2016-01-01 12:25:22</td>
				<td>2016-01-01 12:25:22</td>
			</tr>
			<tr>
				<td>1</td>
				<td>문의</td>
				<td>처리중</td>
				<td><a href="#">테스트 제목임다</a></td>
				<td>test111</td>
				<td>admin11</td>
				<td>2016-01-01 12:25:22</td>
				<td>2016-01-01 12:25:22</td>
			</tr>
			<tr>
				<td>1</td>
				<td>문의</td>
				<td>처리중</td>
				<td><a href="#">테스트 제목임다</a></td>
				<td>test111</td>
				<td>admin11</td>
				<td>2016-01-01 12:25:22</td>
				<td>2016-01-01 12:25:22</td>
			</tr>
			<%-- 실제 db 연동 시 사용
			<c:forEach var="vo" items="${cs_list }">
				<tr>
					<td></td>
				</tr>
			</c:forEach>
			 --%>
		</tbody>
	</table>
	<div>
		<div style="float:left">
			<label>총 ${cs_total_count }건 | 쪽번호 ${cs_pageNum }/${cs_total_pageNum }</label>	
		</div>
		<div style="float:left">
		</div>
		<div style="float:right">
			<select class="form-control">
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="25">25</option>
				<option value="30">30</option>
			</select>
		</div>
	</div>
</div>