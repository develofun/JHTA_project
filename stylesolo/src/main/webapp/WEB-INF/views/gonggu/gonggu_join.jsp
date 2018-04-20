<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/gonggu/gonggu_join.css" type="text/css">

<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script>
   /* 유효성 체크 */
   $(function(){
	  var check_error=0;
	   
      $("input").focusin(function(){
         $(this).next().next().text("");
      });
      $("input").focusin(function(){
          $(this).next().text("");
      });
      
      
      $("#member_privacy_birth").focusout(function(){
          var msg="";
          if($(this).val()==""){
             $(this).next().html("생년월일을 입력해 주세요.");
             $(this).next().addClass("check_error");
          }else{
         	$(this).next().html("OK");
         	$(this).next().removeClass("check_error").addClass("check_ok");
          }
       });
      
      
      
     $("#gonggu_insert_title").focusout(function(){
         var msg="";
         if($(this).val().length>=34){
	         $(this).next().html("공구 제목의 길이가 너무 길어요.");
	         $(this).next().addClass("check_error");
         }else if($(this).val()==""){
        	 $(this).next().html("공구 제목을 입력해주세요.");
	         $(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("OK");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
     });
     $("#gonggu_insert_content").focusout(function(){
         var msg="";
         if($(this).val().length>=100){
	         $(this).next().html("공구 내용의 길이가 너무 길어요.");
	         $(this).next().addClass("check_error");
         }else if($(this).val()==""){
        	 $(this).next().html("공구 내용을 입력해주세요.");
	         $(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("OK");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
      });
     $("#gonggu_insert_price").focusout(function(){
         var gonggu_price=$(this).val();
         var price_valid=/^[0-9]{1,10}$/;
         var msg="";
         if(!price_valid.test(gonggu_price)){
        	 $(this).next().html("가격을 알맞게 입력해주세요.");
         	 $(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("OK");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
     });
     $("#gonggu_insert_minnum").focusout(function(){
         var gonggu_price=$(this).val();
         var price_valid=/^[0-9]{1,10}$/;
         var msg="";
         if(!price_valid.test(gonggu_price)){
        	 $(this).next().html("수량을 알맞게 입력해주세요.");
         	 $(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("OK");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
     });
     $("#gonggu_insert_maxnum").focusout(function(){
         var gonggu_price=$(this).val();
         var price_valid=/^[0-9]{1,10}$/;
         var msg="";
         if(!price_valid.test(gonggu_price)){
        	 $(this).next().html("수량을 알맞게 입력해주세요.");
         	 $(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("OK");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
     });
     $("#gonggu_insert_openingdate").focusout(function(){
         var msg="";
         if($(this).val()==""){
            $(this).next().html("공구 시작일을 입력해 주세요.");
            $(this).next().addClass("check_error");
         }else{
        	$(this).next().html("OK");
        	$(this).next().removeClass("check_error").addClass("check_ok");
         }
     });
     $("#gonggu_insert_closingdate").focusout(function(){
         var msg="";
         if($(this).val()==""){
            $(this).next().html("공구 마감일을 입력해 주세요.");
            $(this).next().addClass("check_error");
         }else{
        	$(this).next().html("OK");
        	$(this).next().removeClass("check_error").addClass("check_ok");
         }
     });
     $("#gonggu_insert_account").focusout(function(){
         var gonggu_account=$(this).val();
         var account_valid=/^[0-9]{10,14}$/;
         var msg="";
         if(!account_valid.test(gonggu_account)){
        	 $(this).next().html("계좌번호를 알맞게 입력해주세요.");
         	 $(this).next().addClass("check_error");
         }else{
        	 $(this).next().html("OK");
        	 $(this).next().removeClass("check_error").addClass("check_ok");
         }
     });
     
     $("form").submit(function(event){
         console.log($("#wrap").children().find(".check_error").length);
         if($("#wrap").children().find(".check_error").length>0){
            $("#submitMsg").text("입력 값이 올바르지 않습니다.");
            event.preventDefault();
            return;
         }
      });
     
   });
   
</script>

<div id="wrap">

	<c:choose>
	<c:when test="${not empty sessionScope.id }">

	<div id="joindiv">
	
	<h2 style="color: #212121;">공동구매 등록</h2>
	<hr>
	<br>
	
		<form method="post" action="/gonggu/insert" enctype="multipart/form-data">
		<input type="hidden" value="${sessionScope.id }" id="member_privacy_id" name="member_privacy_id">

			<span style="font-size:20px;font-weight: bold; color: #353535;margin-left:10px;">공동구매 개요</span><br>
			<span style="font-size: 12px; color: #A6A6A6;margin-left:10px;">ㅡ 등록하고자 하는 공동구매 제품의 간단한 제목과 내용, 카테고리를 입력해 주세요.</span>
			<table class="gonggu_join">
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">제목<br>
					<span style="font-size:10px; color: gray;">33자 입력가능</span>
					</th>
					<td style="font-size: 12px; color: gray;">
						<input type="text" id="gonggu_insert_title" name="gonggu_insert_title" class="form-control" style="width:400px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">내용<br>
					<span style="font-size:10px; color: gray;">100자 입력가능</span>
					</th>
					<td style="font-size: 12px;">
					<textarea rows="8" cols="60" id="gonggu_insert_content" name="gonggu_insert_content" class="form-control" style="width:400px;padding:5px;"></textarea>
					<span class="check_error"></span>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">카테고리</th>
					<td style="font-size: 12px;">
					<select id="gonggu_insert_category" name="gonggu_insert_category" class="form-control" style="width:140px;height:40px;">
						<option value="패션">패션</option>
						<option value="인테리어">인테리어</option>
						<option value="문화/공연">문화/공연</option>
						<option value="기타">기타</option>
					</select>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">대표이미지<br>
					<span style="font-size:10px; color: gray;">300*300px 이미지 등록권장</span>
					</th>
					<td style="font-size: 12px;">
					<input type="file" name="gonggu_img_name" id="gonggu_img_name">
					</td>
				</tr>
			</table>
			
			<span style="font-size:20px;font-weight: bold; color: #353535;margin-left:10px;">목표금액 및 일정</span><br>
			<span style="font-size: 12px; color: #A6A6A6;margin-left:10px;">ㅡ 공동구매제품의 금액과 최소, 최대수량, 공동구매일정을 입력해 주세요.</span>
			<table class="gonggu_join">
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">가격<br>
					<span style="font-size:10px; color: gray;">숫자만 입력가능</span>
					</th>
					<td style="font-size: 12px; color: gray;">
						<input type="number" id="gonggu_insert_price" name="gonggu_insert_price" class="form-control" style="width:200px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">최소수량<br>
					<span style="font-size:10px; color: gray;">숫자만 입력가능</span>
					</th>
					<td style="font-size: 12px;">
						<input type="number" class="form-control" id="gonggu_insert_minnum" name="gonggu_insert_minnum" style="width:200px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">최대수량<br>
					<span style="font-size:10px; color: gray;">숫자만 입력가능</span>
					</th>
					<td style="font-size: 12px;">
						<input type="number" class="form-control" id="gonggu_insert_maxnum" name="gonggu_insert_maxnum" style="width:200px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">공동구매 시작일<br>
					<span style="font-size:10px; color: gray;">달력에서 시작일자 선택</span>
					</th>
					<td style="font-size: 12px;">
						<input type="date" class="form-control" id="gonggu_insert_openingdate" name="gonggu_insert_openingdate" style="width:200px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">공동구매 마감일<br>
					<span style="font-size:10px; color: gray;">달력에서 마감일자 선택</span>
					</th>
					<td style="font-size: 12px;">
						<input type="date" class="form-control" id="gonggu_insert_closingdate" name="gonggu_insert_closingdate" style="width:200px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
			</table>

			<span style="font-size:20px;font-weight: bold; color: #353535;margin-left:10px;">계좌 설정</span><br>
			<span style="font-size: 12px; color: #A6A6A6;margin-left:10px;">ㅡ 판매자 본인의 계좌번호와 은행명을 입력해 주세요.</span>
			<table class="gonggu_join">
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">은행명<br>
					</th>
					<td style="font-size: 12px; color: gray;">
					<select style="width:100px;height:40px;" id="gonggu_insert_bankname" name="gonggu_insert_bankname" class="form-control">
						<option value="국민">국민</option>
						<option value="우리">우리</option>
						<option value="농협">농협</option>
						<option value="신한">신한</option>
						<option value="기업">기업</option>
					</select>
					</td>
				</tr>
				<tr>
					<th scope="row" style="font-weight: bold; font-size: 14px;">계좌번호<br>
					<span style="font-size:10px; color: gray;">- 없이 숫자만 입력</span>
					</th>
					<td style="font-size: 12px;">
						<input type="number" class="form-control" id="gonggu_insert_account" name="gonggu_insert_account" style="width:200px;height:34px;">
						<span class="check_error"></span>
					</td>
				</tr>
			</table>
			
			<div align="center">
				<input type="submit" class="btn btn-primary btn-lg" value="공구등록"><br>
				<br>
				<span id="submitMsg" style="color:red;"></span>
			</div>
			
			<br>
			<br>
			
		</form>
	</div>
	
	</c:when>
	<c:otherwise>
		<div id="nonsession" style="height:300px;margin-top:110px;">
			<h1>로그인 후 등록이 가능합니다.</h1>
		</div>
	</c:otherwise>
	</c:choose>
	
</div>
