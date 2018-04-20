<%@page import="travel.dto.MarketImageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;중고장터입니다.</div>
		<div>
		</div>
	</div>
	<div class="board_ldk_content">
		<table border="1">
			<tr>
				<th>분류</th>
				<td>&nbsp;&nbsp;${dto_text.market_sort }</td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td>&nbsp;&nbsp;${dto_text.market_category }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td id="writer">${dto_text.market_title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>&nbsp;&nbsp;${dto_text.market_writer }</td>
			</tr>
			<tr>
				<th>거래 희망 가격</th>
				<td>&nbsp;&nbsp;<fmt:formatNumber value="${dto_text.market_price }" pattern="#,###"/>원</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>&nbsp;&nbsp;${dto_text.market_phone }</td>
			</tr>
			<tr>
				<th>내용</th>		
				<td>&nbsp;&nbsp;
				<img src="/market_image/${dto_image.market_image_saveFileName }" style="width:300px;height:200px"><br>
				<p>&nbsp;&nbsp;${dto_text.market_content }</p>
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>&nbsp;&nbsp;${dto_text.market_hit }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>&nbsp;&nbsp;${dto_text.market_w_date }</td>
			</tr>
		</table>
		<input type="button" id="btn_delete" value="    삭제    " style="float:left" onclick="javascript:location.href='/market.do?cmd=market_delete&market_num=${dto_text.market_num}'">
		<div class="board_ldk_button" style="float:right">
			<input type="button" id="btn_modify" value="    수정    " onclick="javascript:location.href='/market.do?cmd=market_detail_to_update&market_num=${dto_text.market_num}'">
			<input type="button" id="btn_cancel" value="    취소    " onclick="back_to_read()">
		</div>
	</div>
	<div class="board_ldk_comment" style="clear:left;"><br>
		<div class="comment_subject">- comment</div>
		<div id="comment_list"></div>
		<input type="button" id="comment_plus_btn" value="▽더 보기▽" style="width:100%" onclick="comment_plus()">
		<div id="comment_input_div">
			<table>
				<tr>
					<th style="width:170px">&nbsp;&nbsp;${sessionScope.member_nickname }</th>
					<td>
						<input type="text" id="comment_content" style="margin-left:5px;width:570px">
						<input type="button" value="    등록    " onclick="comment_create()">
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<script>
	//취소 버튼 클릭 시 확인 메시지창 팝업
	function back_to_read(){
		if(confirm("페이지를 나가시겠습니까?")==true){
			location.href="/market.do?cmd=market_read";
		}
	}
	
	//댓글 등록 ajax 처리
	var xhr=null;	
	function comment_create(){
		var market_comment_content=document.getElementById("comment_content").value;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=comment_insert;
		xhr.open("post","/market.do?cmd=market_comment_create",true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		var params="market_comment_writer="+"${dto_text.market_writer }"+"&market_comment_content="+market_comment_content+"&market_num="+"${dto_text.market_num}"+"&customer_num="+"${dto_text.customer_num}";
		xhr.send(params);
	}
	function comment_insert(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml=xhr.responseXML;
			var result=xml.getElementsByTagName("result")[0].firstChild.nodeValue;
			if(result=="success"){
				document.getElementById("comment_content").value="";
				showList();
			}else{
				alert("fail");
			}
		}
	}
	
	//댓글 리스트 불러오기
	var xhr1=null;
	var count=1;
	function showList(){
		xhr1=new XMLHttpRequest();
		xhr1.onreadystatechange=comment_list;
		xhr1.open("post","/market.do?cmd=market_comment_read",true)
		xhr1.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		var param="market_num="+"${dto_text.market_num}";
		xhr1.send(param);
	}
	function comment_list(){
		if(xhr1.readyState==4 && xhr1.status==200){
			var xml=xhr1.responseXML;
			var list_length=xml.getElementsByTagName("data").length;
			
			//더보기 버튼 element 얻어오기
			var comment_plus_btn=document.getElementById("comment_plus_btn");
			//댓글 수가 5개 이하일 경우 버튼 display none
			var length=5*count;
			if(list_length<=5 || length>list_length){
				comment_plus_btn.style.display="none";
				length=list_length;
			}
			
			var comment_list=document.getElementById("comment_list");
			comment_list.innerHTML="";
			var table=document.createElement("table");			
			for(var i=0;i<length;i++){
				var comment_writer=xml.getElementsByTagName("comment_writer")[i].firstChild.nodeValue;
				var comment_content=xml.getElementsByTagName("comment_content")[i].firstChild.nodeValue;
				var comment_w_date=xml.getElementsByTagName("comment_w_date")[i].firstChild.nodeValue;
				var tr=document.createElement("tr");
				var html="<th>"+comment_writer+"<br><c:choose><c:when test='${sessionScope.member_nickname=="+comment_writer+" }'><a href='#' onclick='comment_delete()'>[삭제하기]</a></c:when><c:otherwise></c:otherwise></c:choose></th><td>&nbsp;&nbsp;"+comment_content+"</td><td style='width:300px;text-align:center'>"+comment_w_date+"</td>";
				tr.innerHTML=html;
				//댓글 리스트 영역에 댓글 추가하기
				table.appendChild(tr);
			}
			comment_list.appendChild(table);
			console.log(comment_list.innerHTML);
		}
	}
	function comment_plus(){
		count=count+1;
		showList();
	}
	showList();
	function btn_display(){
		var btn_delete=document.getElementById("btn_delete");
		var btn_modify=document.getElementById("btn_modify");
		var btn_cancel=document.getElementById("btn_cancel");
		var comment_input_div=document.getElementById("comment_input_div");
		if("${sessionScope.member_nickname}"==""){
			btn_delete.style.display="none";
			btn_modify.style.display="none";
			btn_cancel.style.display="none";
			comment_input_div.style.display="none";
		}else if("${sessionScope.member_nickname}"!="${dto_text.market_writer}"){
			btn_delete.style.display="none";
			btn_modify.style.display="none";
		}
	}
	window.onload=btn_display;
</script>