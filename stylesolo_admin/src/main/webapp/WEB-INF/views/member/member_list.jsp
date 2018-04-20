<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<div class="form-inline">
		<h3>
			회원 전체 보기
			<small>회원 관리</small>
		</h3>
		
	</div>
</div>

<div class="form-group">
	<input type="checkbox" class="checkbox-inline">전체
	<input type="checkbox" class="checkbox-inline">이름
	<input type="checkbox" class="checkbox-inline">권한		
</div>

<div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>NO</th>
				<th>아이디</th>
				<th>이름</th>
				<th>회원등급</th>
				<th>보유포인트</th>
				<th>총 결제 건</th>
				<th>가입 일시</th>
				<th>계정 상태</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td><a href="/member_detail">test123</a></td>
				<td>홍길동</td>
				<td>골드</td>
				<td>15,000</td>
				<td>30</td>
				<td>2016-01-01 12:25:22</td>
				<td>
					<select class="form-control">
						<option value="정상">정상</option>
						<option value="차단">차단</option>
						<option value="탈퇴">탈퇴</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="/member_detail">test123</a></td>
				<td>홍길동</td>
				<td>골드</td>
				<td>15,000</td>
				<td>30</td>
				<td>2016-01-01 12:25:22</td>
				<td>
					<select class="form-control">
						<option value="정상">정상</option>
						<option value="차단">차단</option>
						<option value="탈퇴">탈퇴</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="/member_detail">test123</a></td>
				<td>홍길동</td>
				<td>골드</td>
				<td>15,000</td>
				<td>30</td>
				<td>2016-01-01 12:25:22</td>
				<td>
					<select class="form-control">
						<option value="정상">정상</option>
						<option value="차단">차단</option>
						<option value="탈퇴">탈퇴</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="/member_detail">test123</a></td>
				<td>홍길동</td>
				<td>골드</td>
				<td>15,000</td>
				<td>30</td>
				<td>2016-01-01 12:25:22</td>
				<td>
					<select class="form-control">
						<option value="정상">정상</option>
						<option value="차단">차단</option>
						<option value="탈퇴">탈퇴</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="/member_detail">test123</a></td>
				<td>홍길동</td>
				<td>골드</td>
				<td>15,000</td>
				<td>30</td>
				<td>2016-01-01 12:25:22</td>
				<td>
					<select class="form-control">
						<option value="정상">정상</option>
						<option value="차단">차단</option>
						<option value="탈퇴">탈퇴</option>
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<div style="float:left">
			<label>총 ${member_total_count }명 | 쪽번호 ${member_pageNum }/${member_total_pageNum }</label>	
		</div>
		<div style="float:left">
		</div>
		<div style="float:right">
			<select class="form-control">
				<option value="20">20</option>
				<option value="25">25</option>
				<option value="30">30</option>
				<option value="35">35</option>
				<option value="40">40</option>
			</select>
		</div>
	</div>
</div>