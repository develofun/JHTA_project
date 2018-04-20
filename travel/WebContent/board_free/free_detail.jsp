<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="free_detail_all">
	<div class="board_ksw_subject">
		<div class="board_ksw_subject_title" style="text-align: left;">&nbsp;&nbsp;자유게시판 입니다.</div>
		<div class="board_ksw_subject_content" style="text-align: left;">
		자유롭게 쓰고 싶은 글을 쓰는 게시판입니다..<br>
		매너를 지켜서 이용해주세요.
		</div>	
	</div>	
	<div class="free_detail_top">
		<div class="free_detail_top_title">
			<h3 class="free_detail_title">${dto.free_title }</h3>
		</div>
		<div class="free_detail_top_data">
			<ul class="free_detail_top_data_ul">
				<li class="free_detail_top_data_li">글쓴이 : ${dto.free_writer}</li>
				<li class="free_detail_top_data_li1">날짜 :${fn:substring(dto.free_w_date,0,16)}</li>
				<li class="free_detail_top_data_li">조회 : ${dto.free_hit }</li>
			</ul>
		</div>
	</div>
	<br>
	<div class="free_detail_middle" style="width: 900px;">
		<div style="width: 90%; margin:auto; padding-left: 130px;">
			<c:if test="${!empty dto1.free_image_name }">
				<img src="/free_image/${dto1.free_image_name }"style="max-width: 80%; height: auto;">
			</c:if>
		</div>
		<div class="free_detail_content"> 
			<textarea class="textarea_ksw" id="free_detail_content_text" disabled="disabled">${dto.free_content }</textarea>
		</div>
	</div>
	<div class="free_detail_footer">
		<div class="free_detail_button">
			<input type="button" class="review_create_btu btn1" id="btn_delete" value="    삭제    "
				style="float: left"
				onclick="javascript:location.href='/free.do?cmd=free_delete&free_num=${dto.free_num}'">
			<div class="board_ldk_button" style="float: right">
				<input type="button" class="review_create_btu btn1" id="btn_modify" value="    수정    "
					onclick="javascript:location.href='/free.do?cmd=free_detail_to_update&free_num=${dto.free_num}'">
				<input type="button" class="review_create_btu btn1" id="btn_cancel" value="    목록   "
					onclick="back_to_read()">
			</div>
		</div>
		<!-- 댓글view -->
		<div class="free_comment_view" style="clear: left;">
			<br>
			<div class="comment_subject">- comment</div>
			<div id="comment_list" class="comment_list"></div>
			<input type="button" id="comment_plus_btn" value="▽더 보기▽"style="width: 100%" onclick="comment_plus()">
			<div id="comment_input_div">
				<table>
					<tr>
						<th style="width: 170px">&nbsp;&nbsp;${sessionScope.member_nickname}</th>
						<td>
							<input type="text" id="comment_content"style="margin-left: 5px; width: 570px; margin-top:6px;"> 
							<input type="button" value="    등록    " id="btn_write"onclick="comment_create()">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript">

function btn_display(){
	var btn_delete=document.getElementById("btn_delete");
	var btn_modify=document.getElementById("btn_modify");
	var btn_cancel=document.getElementById("btn_cancel");
	var comment_input_div=document.getElementById("comment_input_div");
	if("${sessionScope.member_nickname}"==""){			
		btn_delete.style.display="none";
		btn_modify.style.display="none";
		comment_input_div.style.display="none";
	}else if("${sessionScope.member_power}"=="admin"){	
		//btn_delete.style.display="show";
		//btn_modify.style.display="show";
		//comment_input_div.style.display="show";
	}else if("${sessionScope.member_nickname}"!="${dto.free_writer}"){
		btn_delete.style.display="none";
		btn_modify.style.display="none";	
	}
}

function addLoadEvent(func) {
    var oldonload = window.onload;
        if(typeof window.onload != 'function') {
            window.onload = func;
        } else {
            window.onload = function() {
                oldonload();
                func();
        }
    }
}

function back_to_read(){
		location.href="/free.do?cmd=free_read";
}
var xhr=null;
var xhr1=null;

function comment_create(){
	var free_comment_content=document.getElementById("comment_content").value;
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=comment_insert;
	xhr.open("post","/free.do?cmd=free_comment_create",true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	var params="free_comment_content="+free_comment_content+"&free_num="+"${dto.free_num}"+"&customer_num="+"${dto.customer_num}";
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

var count=1;

function showList(){//댓글목록 보여주기
	xhr1=new XMLHttpRequest();
	xhr1.onreadystatechange=comment_list;
	xhr1.open("post","/free.do?cmd=free_comment_read",true);
	xhr1.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	var param="free_num="+"${dto.free_num}";
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
			var free_comment_writer=xml.getElementsByTagName("free_comment_writer")[i].firstChild.nodeValue;
			var free_comment_content=xml.getElementsByTagName("free_comment_content")[i].firstChild.nodeValue;
			var free_comment_w_date=xml.getElementsByTagName("free_comment_w_date")[i].firstChild.nodeValue;
			var tr=document.createElement("tr");
			var html="<th style='width:180px'>"+free_comment_writer+"</th><td>&nbsp;&nbsp;"+free_comment_content+"</td><td style='width:300px;text-align:center'>"+free_comment_w_date+"</td>";
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

addLoadEvent(showList);
addLoadEvent(btn_display);
</script>


