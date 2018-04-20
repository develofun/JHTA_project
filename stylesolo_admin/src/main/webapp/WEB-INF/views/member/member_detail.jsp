<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<div class="form-inline">
		<h3>
			회원 상세 보기
			<small>회원 관리</small>
		</h3>
		
	</div>
</div>

<div class="display-table">
	<div class="display-table-row">
		<div class="display-table-cell" style="width:600px">
			<div class="box">
				<div class="box-header with-borer">
					<h4 class="box-title">
						회원 정보
						<input type="button" class="btn btn-primary btn-sm" value="회원 상세 정보">
						<input type="button" class="btn btn-primary btn-sm" value="계정 상태 변경">	
					</h4>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr><th>회원코드</th><td colspan="3"></td></tr>
						<tr><th>회원ID</th><td></td><th>닉네임</th><td></td></tr>
						<tr><th>생년월일</th><td></td><th>회원등급</th><td></td></tr>
						<tr><th>보유 포인트</th><td></td><th>결제 건수</th><td></td></tr>
						<tr><th>가입일</th><td></td><th>계정 상태</th><td></td></tr>
					</table>
				</div>
			</div>
		</div>
		<div class="display-table-cell" style="width:600px">
			<div class="box">
				<div class="box-header with-borer">
					<h4 class="box-title">
						포인트 정보
						<input type="button" class="btn btn-primary btn-sm" value="포인트 관리">
					</h4>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr><th>보유 포인트</th><td>30,000 point</td><td>누적 사용 포인트</td><td>80,000 point</td></tr>
					</table>
					<table class="table table-bordered">
						<tr class="info"><th colspan="3">최근 포인트 사용 내역</th></tr>
						<tr><th>사용처</th><th>사용 일시</th><th>사용 포인트</th></tr>
						<tr><td>상품 결제</td><td>2017-01-01 12:36:54</td><td>3,000</td></tr>
						<tr><td>상품 결제</td><td>2017-01-01 12:36:54</td><td>3,000</td></tr>
						<tr><td>상품 결제</td><td>2017-01-01 12:36:54</td><td>3,000</td></tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="display-table-row">
		<div class="display-table-cell" style="width:600px">
			<div class="box">
				<div class="box-header with-borer">
					<h4 class="box-title">
						결제 정보
					</h4>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr class="info"><th>NO</th><th>구분</th><th>progress</th><th>건 수</th></tr>
						<tr>
							<td>1</td><td>총 결제 건</td>
							<td>
								<div class="progress" style="margin:0px;">
									<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40"
									 aria-valuemin="0" aria-valuemax="100" style="width:40%;"></div>
								</div>
							</td>
							<td>
								<span class="label label-success">  40건  </span>
							</td>
						</tr>
						<tr>
							<td>1</td><td>당월 결제</td>
							<td>
								<div class="progress" style="margin:0px;">
									<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="40"
									 aria-valuemin="0" aria-valuemax="100" style="width:40%;"></div>
								</div>
							</td>
							<td>
								<span class="label label-success">  40건  </span>
							</td>
						</tr>
						<tr>
							<td>1</td><td>월 평균 결제</td>
							<td>
								<div class="progress" style="margin:0px;">
									<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="40"
									 aria-valuemin="0" aria-valuemax="100" style="width:40%;"></div>
								</div>
							</td>
							<td>
								<span class="label label-success">  40건  </span>
							</td>
						</tr>
						<tr>
							<td>1</td><td>평균 구매액</td>
							<td>
								<div class="progress" style="margin:0px;">
									<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50000"
									 aria-valuemin="0" aria-valuemax="1000000" style="width:5%;"></div>
								</div>
							</td>
							<td>
								<span class="label label-success">  50,000원  </span>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="display-table-cell" style="width:600px">
			<div class="box">
				<div class="box-header with-borer">
					<h4 class="box-title">
						최근 거래 내역
					</h4>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr><th colspan="2">문의 내역</th><td colspan="2">00건</td></tr>
						<tr><th>문의</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 중</td></tr>
						<tr><th>불만</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 완료</td></tr>
						<tr><th>기타</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 완료</td></tr>
						<tr><th>서비스</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 중</td></tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="box">
	<div class="box-header with-borer">
		<h4 class="box-title">
			상담 정보
		</h4>
	</div>
	<div class="box-body">
		<table class="table table-bordered">
			<tr><th>NO</th><th>구분</th><th>progress</th><th>건 수</th></tr>
			<tr>
				<td>1</td><td>총 문의 건</td>
				<td>
					<div class="progress" style="margin:0px;">
						<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40"
						 aria-valuemin="0" aria-valuemax="100" style="width:40%;"></div>
					</div>
				</td>
				<td>
					<span class="label label-success">  40건  </span>
				</td>
			</tr>
			<tr>
				<td>1</td><td>당월 문의</td>
				<td>
					<div class="progress" style="margin:0px;">
						<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="40"
						 aria-valuemin="0" aria-valuemax="100" style="width:40%;"></div>
					</div>
				</td>
				<td>
					<span class="label label-success">  40건  </span>
				</td>
			</tr>
			<tr>
				<td>1</td><td>월 평균 문의</td>
				<td>
					<div class="progress" style="margin:0px;">
						<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="40"
						 aria-valuemin="0" aria-valuemax="100" style="width:40%;"></div>
					</div>
				</td>
				<td>
					<span class="label label-success">  40건  </span>
				</td>
			</tr>
			<tr>
				<td>1</td><td>문의 비율</td>
				<td>
					<div class="progress" style="margin:0px;">
						<div class="progress-bar progress-bar-success" role="progressbar" style="width: 40%">문의</div>
						<div class="progress-bar progress-bar-warning" role="progressbar" style="width: 10%">불만</div>
						<div class="progress-bar progress-bar-danger" role="progressbar" style="width: 20%">서비스</div>
					</div>
				</td>
				<td>
					<span class="label label-success">  50,000원  </span>
				</td>
			</tr>
		</table>
	</div>
</div>
<div class="box">
	<div class="box-header with-borer">
		<h4 class="box-title">
			최근 상담 내역
		</h4>
	</div>
	<div class="box-body">
		<table class="table table-striped">
			<tr class="info"><th colspan="2">문의 내역</th><td colspan="2">00건</td></tr>
			<tr><th>문의</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 중</td></tr>
			<tr><th>불만</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 완료</td></tr>
			<tr><th>기타</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 완료</td></tr>
			<tr><th>서비스</th><td>테스트 문의입니다 111</td><td>2017-01-01 12:25:36</td><td>처리 중</td></tr>
		</table>
	</div>
</div>