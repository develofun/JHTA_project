<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="checkpwd" style="width:780px;height:300px;padding:20px;float:left;">
	<span style="font-size: 20px;font-weight: bold;">회원정보 수정</span><br>
	<hr style="width:200px;float:left;"><br>
	<br>
	<br>
	<span style="font-size: 12px;color:gray;">회원님의 개인정보를 위해 비밀번호를 입력해 주세요.</span><br><br>
	
	<form method="post" action="/checkMember">
	<table style="width:760px;height:160px;border:1px solid #A6A6A6;">
		<tr>
			<th style="width:100px;font-weight: normal;border-bottom:1px solid #A6A6A6;color:#747474;text-align: center;">아이디</th>
			<td style="border-bottom:1px solid #A6A6A6;">
				<input type="text" class="form-control" style="width:300px;height:34px;border-radius: 5px;padding:5px;"
					value="${sessionScope.id}" readonly="readonly">
				<input type="hidden" value="${sessionScope.id }" id="id" name="id">
			</td>
		</tr>
		<tr>
			<th style="width:100px;font-weight: normal;color:#747474;text-align: center;">비밀번호</th>
			<td>
				<input type="password" class="form-control" style="width:300px;height:34px;border-radius: 5px;padding:5px;" id="pwd" name="pwd">
			</td>
		</tr>
	</table>
	<br>
	<div align="center">
		<input type="submit" class="btn btn-primary" id="btn_checkpwd" style="width:100px;" value="확인">
	</div>
	</form>
</div>
