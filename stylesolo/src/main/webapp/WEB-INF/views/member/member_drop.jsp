<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/resources/css/member/member_out.css" type="text/css">

<script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#chk_comment").click(function(){
	        if($("#chk_comment").prop("checked")){
	           $("#member_out_reason").each(function(){
	              $(this).removeAttr("disabled");
	           });
	        }else{
	           $("#member_out_reason").each(function(){
	              $(this).attr("disabled","disabled");
	           });
	        }
	     });
		
	});
	
</script>

<div id="member_out" style="width:740px;height:1000px;float:left;margin-left:20px;">
	<br>
	<span style="font-size: 20px;font-weight: bold;">회원탈퇴</span><br>
	<br>
	
	<table style="width:700px;border:1px solid #D5D5D5;">
		<tr>
			<th style="width:180px;height:130px;font-weight: normal;border-bottom:1px solid #D5D5D5;color:#353535;text-align: center;">회원혜택 상실 안내</th>
			<td style="border-bottom:1px solid #D5D5D5;font-size: 13px;color:#353535;">보유하고 있는 Style Solo의 쿠폰과 회원 포인트는 자동 소멸됩니다.<br>
				Style Solo의 회원 서비스는 더 이상 이용할 수 없으며, 회원 혜택 또한 받을 수 없습니다.<br>
				[현재 고객님이 보유하고 있는 쿠폰은 2장 입니다.]</td>
		</tr>
		<tr>
			<th style="width:180px;height:220px;font-weight: normal;color:#353535;text-align: center;">개인 정보삭제 안내</th>
			<td style="font-size: 13px;color:#353535;">회원님의 개인 정보는 절대 복구할 수 없는 방법으로 삭제됩니다.
				 단 전자상거래 등에서의 소비자보호에 관한 법률 및 동법 시행령에 의하여 보존할 필요가 있는 경우에 한하여 개인정보취급방침에 명시된 기간 동안 해당 정보가 보존됨을 알려드립니다.<br>
				회원님의 개인 정보는 삭제되나, 회원으로 활동하셨을 때 작성하셨던 게시물과 덧글은 삭제되지 않습니다.<br>
				재가입을 원하실 때는 현재의 아이디로는 가입이 불가능하며, 사용하시던 아이디는 삭제됨과 동시에 다른 사람에
				의해서도 사용되지 못하게 됩니다.
				거래내역이 진행 중인 경우 즉시 탈퇴할 수 없습니다.</td>
		</tr>
	</table>
	<br>
	<br>
	
	<span style="font-size:16px;font-weight: bold; color: #353535;margin-left:10px;">회원탈퇴신청</span><br><br>
	<span style="font-size: 12px;color:gray;">&nbsp;&nbsp; * 본인의 비밀번호와 탈퇴사유를 입력해 주세요.</span><br>
	<form method="post" action="/member/drop">
	<table class="member_out">
		<tr>
			<th scope="row" style="font-weight: bold; font-size: 14px;">아이디<br>
			</th>
			<td style="font-size: 18px; color: gray;">
				<input type="hidden" name="member_privacy_id" value="${sessionScope.id }">
				${sessionScope.id }
			</td>
		</tr>
		<tr>
			<th scope="row" style="font-weight: bold; font-size: 14px;">비밀번호<br>
			</th>
			<td style="font-size: 12px;">
				<input type="password" class="form-control" name="member_privacy_pwd" style="width:240px;height:34px;">
			</td>
		</tr>
		<tr>
			<th scope="row" style="font-weight: bold; font-size: 14px;">탈퇴사유<br>
			</th>
			<td style="font-size: 12px; color: gray;">
			Style Solo 사이트 이용 중 불편사항을 입력해주세요.(복수선택 가능)<br><br>
			<input type="checkbox" name="member_out_cause" value="다양성/가격품질불만">상품 다양성/가격품질 불만<br>
			<input type="checkbox" name="member_out_cause" value="배송지연">배송지연<br>
			<input type="checkbox" name="member_out_cause" value="개인정보유출">개인정보 유출<br>
			<input type="checkbox" name="member_out_cause" value="특혜부족">회원특혜/쇼핑혜택부족<br>
			<input type="checkbox" name="member_out_cause" value="A/S불만">A/S 불만<br>
			<input type="checkbox" name="member_out_cause" value="사이트속도불만">쇼핑몰 속도 불만<br>
			<input type="checkbox" id="chk_comment" value="dd">기타<br><br>
			<input type="text" name="member_out_cause" id="member_out_reason" class="form-control" style="width:320px;height:34px;" disabled="disabled">
			</td>
		</tr>
	</table>
	<!-- test -->
	<div align="center">
	<input type="submit" class="btn btn-primary" style="width:100px;" value="탈퇴하기">
	</div>
	</form>
</div>
