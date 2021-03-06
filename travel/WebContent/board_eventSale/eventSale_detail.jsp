<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="board_ldk" align="center">	
	<div class="board_ldk_subject">
		<div class="board_ldk_subject_title" style="text-align: left;">&nbsp;&nbsp;이벤트/할인 게시판입니다.</div>
		<div class="board_ldk_subject_content" style="text-align: left;">
		이벤트/할인 정보를 공유하는 게시판입니다.<br>
		다양한 정보 공유 부탁 드립니다.
		</div>
	</div>
	<div class="board_ldk_content">
		<table border="1">
			<tr>
				<th>구분</th>
				<td>&nbsp;&nbsp;${dto.eventSale_sort }</td>
			</tr>
			<tr>
				<th>항목</th>
				<td>&nbsp;&nbsp;${dto.eventSale_category }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>&nbsp;&nbsp;${dto.eventSale_title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td id="writer">${dto.eventSale_writer }</td>
			</tr>
			<tr>
				<th>시작일</th>
				<td>&nbsp;&nbsp;${dto.eventSale_startDate }</td>
			</tr>
			<tr>
				<th>종료일</th>
				<td>&nbsp;&nbsp;${dto.eventSale_endDate }</td>
			</tr>
			<tr>
				<th>내용</th>		
				<td>			
				&nbsp;&nbsp;${dto.eventSale_content }
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>&nbsp;&nbsp;${dto.eventSale_hit }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>&nbsp;&nbsp;${dto.eventSale_w_date }</td>
			</tr>
		</table>
		<input type="button" id="btn_delete" value="    삭제    " style="float:left" onclick="javascript:location.href='/eventSale.do?cmd=eventSale_delete&eventSale_num=${dto.eventSale_num}'">
		<div class="board_ldk_button" style="float:right">
			<input type="button" id="btn_modify" value="    수정    " onclick="javascript:location.href='/eventSale.do?cmd=eventSale_detail_to_update&eventSale_num=${dto.eventSale_num}'">
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
					<th style="width:170px">&nbsp;&nbsp;${dto.eventSale_writer }</th>
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
	function back_to_read(){
		if(confirm("페이지를 나가시겠습니까?")==true){
			location.href="/eventSale.do?cmd=eventSale_read";
		}
	}
	var xhr=null;	
	function comment_create(){
		var eventSale_comment_content=document.getElementById("comment_content").value;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=comment_insert;
		xhr.open("post","/eventSale.do?cmd=eventSale_comment_create",true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		var params="eventSale_comment_writer="+"${dto.eventSale_writer }"+"&eventSale_comment_content="+eventSale_comment_content+"&eventSale_num="+"${dto.eventSale_num}"+"&customer_num="+"${dto.customer_num}";
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
	var xhr1=null;
	var count=1;
	function showList(){
		xhr1=new XMLHttpRequest();
		xhr1.onreadystatechange=comment_list;
		xhr1.open("post","/eventSale.do?cmd=eventSale_comment_read",true)
		xhr1.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		var param="eventSale_num="+"${dto.eventSale_num}";
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
				var html="<th>"+comment_writer+"</th><td>&nbsp;&nbsp;"+comment_content+"</td><td style='width:300px;text-align:center'>"+comment_w_date+"</td>";
				tr.innerHTML=html;
				//댓글 리스트 영역에 댓글 추가하기
				table.appendChild(tr);	
			}
			comment_list.appendChild(table);
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
		}else if("${sessionScope.member_nickname}"!="${dto.eventSale_writer}"){
			btn_delete.style.display="none";
			btn_modify.style.display="none";
		}
	}
	window.onload=btn_display;
	
</script>