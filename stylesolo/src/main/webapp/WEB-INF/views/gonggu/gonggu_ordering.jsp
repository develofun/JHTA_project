<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_ordering.css" type="text/css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample6_address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('sample6_address2').focus();
					}
				}).open();
	}
</script>
<script type="text/javascript">
	function tab1(){
		var pay_card=document.getElementById("pay_card");
		var pay_phone=document.getElementById("pay_phone");
		var pay_account=document.getElementById("pay_account");
		
		pay_card.style.display="inline";
		pay_phone.style.display="none";
		pay_account.style.display="none";
	}
	function tab2(){
		var pay_card=document.getElementById("pay_card");
		var pay_phone=document.getElementById("pay_phone");
		var pay_account=document.getElementById("pay_account");
		
		pay_card.style.display="none";
		pay_phone.style.display="inline";
		pay_account.style.display="none";
	}
	function tab3(){
		var pay_card=document.getElementById("pay_card");
		var pay_phone=document.getElementById("pay_phone");
		var pay_account=document.getElementById("pay_account");
		
		pay_card.style.display="none";
		pay_phone.style.display="none";
		pay_account.style.display="inline";
	}
</script>

<div id="wrap">

	<h2>공동구매 제품 주문하기</h2>
		
	<div id="ordering_info">
		<span style="font-weight: bold;font-size: 18px;color:black;">주문정보</span><br>
		<hr style="width:140px;float:left;"><br>
		
		<table style="width:920px;border-top:1px solid gray;border-bottom:1px solid gray;">
			<tr align="center" style="font-size: 12px;font-weight: normal;background-color: #EAEAEA;">
				<th style="height:40px;text-align: center;">상품코드</th>
				<th style="text-align:center;">상품명</th>
				<th style="text-align:center;">판매가</th>
				<th style="text-align:center;">수량</th>
				<th style="text-align:center;">주문금액</th>
			</tr>
			
			<tr align="center" style="font-size: 12px;font-weight: normal;">
				<td>${gongguinfo.gonggu_insert_num }</td>
				<td style="text-align: left;">
					<img src="/resources/gonggu_uploadImg/${gongguimg.gonggu_img_sname }" style="width:100px;height:100px;float:left;">
					<div style="float:left;margin-top:40px;margin-left:40px;">${gongguinfo.gonggu_insert_title }</div>
				</td>
				<td><fmt:formatNumber value="${gongguinfo.gonggu_insert_price}" pattern="###,###"/> 원</td>
				<td>${buynum }</td>
				<td><fmt:formatNumber value="${price }" pattern="###,###"/> 원</td>
			</tr>
		</table>
	</div>
	
	<div id="ordering_user_info">
		<span style="font-weight: bold;font-size: 18px;color:black;">주문고객 정보</span><br>
		<hr style="width:140px;float:left;"><br>
		
		<table style="width:920px;height:300px;border-top:1px solid gray;font-size:12px;color:gray;">
			<tr>
				<th style="font-weight:normal;border-bottom:1px solid gray;background-color: #EAEAEA;text-align: center;">주문자명</th>
				<td style="font-weight:normal;border-bottom:1px solid gray;color:black;padding:10px;">${userinfo.member_privacy_name }</td>
			</tr>
			<tr>
				<th style="font-weight:normal;border-bottom:1px solid gray;background-color: #EAEAEA;text-align: center;">이메일</th>
				<td style="font-weight:normal;border-bottom:1px solid gray;padding:10px;">
					<input type="text" class="form-control" style="width:200px;height:30px;" value="${userinfo.member_privacy_email }">
				</td>
			</tr>
			<tr>
				<th style="font-weight:normal;border-bottom:1px solid gray;background-color: #EAEAEA;text-align: center;">휴대폰</th>
				<td style="font-weight:normal;border-bottom:1px solid gray;padding:10px;">
					<input type="text" class="form-control" style="width:200px;height:30px;" value="${userinfo.member_privacy_phone }">
				</td>
			</tr>
			<tr>
				<th style="font-weight:normal;border-bottom:1px solid gray;background-color: #EAEAEA;text-align: center;">주소</th>
				<td style="font-weight:normal;border-bottom:1px solid gray;padding:10px;">
					<input type="text" id="sample6_postcode" placeholder="우편번호" size="10px" class="ordering_text"
					name="member_privacy_addr" style="width: 80px;height:30px;" value="${addrNum }" readonly="readonly">
					<input type="button" class="btn btn-default" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="btn_addr"><br>
					<input type="text" id="sample6_address" placeholder="주소" name="member_privacy_addr" 
					class="ordering_text" style="width: 300px;height:30px;" value="${addr1 }" readonly="readonly">
					<input type="text" id="sample6_address2" placeholder="상세주소" name="member_privacy_addr"
					class="ordering_text" style="width: 140px;height:30px;" value="${addr2 }">
				</td>
			</tr>
		</table>
		
		
	</div>

	<div id="ordering_pay_info">
		<span style="font-weight: bold;font-size: 18px;color:black;">결제 정보</span><br>
		<hr style="width:140px;float:left;"><br>
		
		<table style="width:900px;height:40px;border:1px solid gray;">
			<tr align="center" style="font-size: 12px;font-weight: normal;background-color: #EAEAEA">
				<th style="width:200px;text-align: center;">결제방식</th>
				<td style="width:700px;">			
					<input type="radio" name="ordering_pay" id="ordering1" onclick="javascript:tab1()" checked="checked">신용카드
					<input type="radio" name="ordering_pay" id="ordering2" onclick="javascript:tab2()" style="margin-left:100px;">휴대폰결제
					<input type="radio" name="ordering_pay" id="ordering3" onclick="javascript:tab3()" style="margin-left:100px;">무통장입금
				</td>
			</tr>
		</table>
		<div id="pay_info_detail">
			<div id="pay_card" style="display: inline;">
				<span style="color:gray;font-size:12px;">
				1. 신용카드 결제 시 화면 아래 ‘결제하기’ 버튼을 클릭하시면 신용카드 결제 창이 나타납니다.
				신용카드 결제 창을 통해 입력되는 고객님의 카드 정보는 128bit로 안전하게 암호화되어 전송되며, 승인 처리 후 카드 정보는 승인 성공/실패 여부에 상관없이 자동으로 폐기됩니다.<br><br>
				2. 신용카드 결제 신청 시 승인 진행에 다소 시간이 소요될 수 있으므로 ‘중지’, ‘새로 고침’을 누르지 마시고 결과 화면이 나타날 때까지 기다려 주십시오.<br>
				(결제하기 버튼 클릭 시 결제창이 나타나지 않을 경우나 안전결제 모듈이 설치되지 않을 경우 [여기]를 눌러 수동으로 플러그인을 설치하십시오.)<br><br>
				3. ISP 결제로 30만원 이상 물품 거래 시에는 반드시 공인인증서가 필요합니다.<br><br>
				4. 무통장입금은 입금확인 후 배송이 이루어집니다.<br><br>
				</span>
			</div>
			<div id="pay_phone" style="display: none;">
				<span style="color:gray;font-size:12px;">
				1. StyleSolo에서 휴대폰 소액결제는 월 30만원 까지만 가능합니다. 단, 개인별 한도 금액은 통신사에 따라 다를 수 있습니다.<br>
				이통사별 휴대폰 결제 정책 안내<br><br>
				2.휴대폰 소액결제로 구매하실 경우 세금계산서 및 현금영수증이 발급되지 않습니다.<br><br>
				3. 다음의 경우에는 휴대폰 결제를 이용하실 수 없습니다.<br>
				- 미납/체납 중인 휴대폰 요금이 있을 경우<br>
				- 이동통신사 가입기간(번호 이동 포함) 6개월 이하인 경우<br>
				- 외국인, 미성년자 요금제, 법인 휴대폰, 선불요금제인 경우<br>
				- 휴대폰 명의자가 19세 미만인 경우 <br><br>
				4. 휴대폰 소액결제로 결제하신 상품을 취소할 경우 결제하신 당월 말까지 가능합니다.<br>
				- 결제월에 취소/반품 처리가 완료되는 경우 휴대폰 이용요금에 부과 예정이던 금액이 취소됩니다.<br>
				- 결제월이 지난 후 취소/반품 처리가 완료되는 경우, 환불액을 고객님 계좌로 현금 입금해 드립니다. <br><br>
				5. 휴대폰결제 관련 문의사항은 다날 고객센터 1566-3355 또는 품 고객감동센터 1577-9081으로 연락 주시기 바랍니다.<br><br>
				</span>
			</div>
			<div id="pay_account" style="display: none;">
				<span style="color:gray;font-size:12px;">
				1. 주문일로부터 7영업일 이내 입금확인이 되지 않으면 주문이 자동 취소됩니다. 일부 한정 상품 주문 시 유의하여 주시기 바랍니다.<br><br>
				2. 입금 시 예금주명은 StyleSolo로 확인됩니다.<br><br>
				3. 무통장 입금 확인은 1시간 이내에 확인되며, 입금 확인시 배송이 이루어집니다.<br><br>
				4. StyleSolo에서는 구매안전서비스로 에스크로 서비스에 가입되어 있습니다. 5만원 이상 현금 거래에 대해 에스크로 서비스를 받으시려면 [에스크로(실시간 계좌이체)]결제방식을 선택하시기 바랍니다.<br><br>
				※ 가상 계좌 안내<br>
				1) 무통장 입금 시 사용되는 가상 계좌는 매 주문 시마다 새로운 계좌번호(개인 전용)가 부여되며 해당 주문에만 유효합니다.<br>
				2) 다른 주문 건에 대한 가상 계좌로 입금하시거나 잘못된 계좌로 입금하시면 자동 입금 확인이 되지 않습니다.<br>
				3) 계좌번호는 주문 완료 페이지에서 확인할 수 있으며, SMS도 발송해 드립니다.<br>
				</span>
			</div>
		</div>
	</div>
	
	<div id="div_ordering_form" align="center">
		<form method="post" action="/gonggu/buy">
			<input type="hidden" name="gonggu_buy_price" id="gonggu_buy_price" value="${price }">
			<input type="hidden" name="gonggu_buy_getnum" id="gonggu_buy_getnum" value="${buynum }">
			<input type="hidden" name="gonggu_insert_num" id="gonggu_insert_num" value="${gongguinfo.gonggu_insert_num }">
			<input type="hidden" name="member_privacy_id" id="member_privacy_id" value="${userinfo.member_privacy_id }">
			<input type="submit" class="btn btn-primary" value="구입하기" id="btn_ordering">
			<br>
			<br>
		</form>
	</div>
</div>