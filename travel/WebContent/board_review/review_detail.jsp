<%@page import="travel.dto.Review_ImageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css"> 
.review_detail_all{width: 900px; background-color: white;}

.review_detail_top_title{
	width: 100%;
	height: 37px;
	background-color: #F7F7F7;
	border-top: 2px solid #B2B2B2;
	border-bottom: 1px solid #E1E1E1;
}
.review_detail_title{
	display:table-cell; text-align:center; vertical-align:middle;
	padding-top: 4px;
}

.review_detail_top_data{padding: 5px 5px;}

.review_detail_top_data_ul{
	width: 100%;
	list-style:none;
    margin:0;
    padding:0;
}
.review_detail_top_data_li{
    margin: 0 0 0 0;
    padding: 0 20px;
    border : 0;
    float: left;
}
    
.review_detail_top_data_li1{
    margin: 0 0 0 0;
    padding: 0 20px;
    border : 0;
    border-left:1px solid #E1E1E1;
    border-right:1px solid #E1E1E1;
    float: left;
}

#review_detail_content_text{width: 100%; 
	height: 150px; 
	padding: 12px 20px;
	margin-top: 5px;
    box-sizing: border-box;
    border: 2px solid #B2B2B2;
    background-color: #F7F7F7;
    font-size: 16px;
    resize: none;
}
.review_detail_buten{text-align:right;}

.review_detail_btu {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 3px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.btn1 {
    background-color: white;
    color: black;
    border: 2px solid #B2B2B2;
}

.btn1:hover {background-color: #B2B2B2;}

.review_detail_comment{width: 100%; height: 120px;background-color: #B2B2B2;}

.review_detail_comment_1{float:left; background-color: blue; width: 70%;}

#review_comment_text{width: 100%; 
	height: 100px; 
	padding: 12px 20px;
	margin-top: 5px;
    box-sizing: border-box;
    border: 2px solid #B2B2B2;
    background-color: #F7F7F7;
    font-size: 16px;
    resize: none;
    
}
.review_detail_comment_buten{
	width:30%;
	background-color: red;
	float:left;
}

.btn2 {
    background-color: white;
    color: black;
    border: 2px solid #B2B2B2;

}
.btn2:hover {background-color: #B2B2B2;}

</style>

<div class="review_detail_all">
<div class="board_ksw_subject">
		<div class="board_ksw_subject_title" style="text-align: left;">&nbsp;&nbsp;리뷰 게시판입니다.</div>
		<div class="board_ksw_subject_content" style="text-align: left;">
		다녀왔던 여행지를 소개할 수 있는 게시판입니다.<br>
		모든 회원은 자유롭게 작성할 수 있으니 즐거운 후기 부탁드립니다.
		</div>	
</div>
	<div class="review_detail_top">
		<div class="review_detail_top_title">
			<h3 class="review_detail_title">[${dto.review_category}] ${dto.review_title }</h3>
		</div>
		<div class="review_detail_top_data">
			<ul class="review_detail_top_data_ul">
				<li class="review_detail_top_data_li">글쓴이 : ${dto.review_writer}</li>
				<li class="review_detail_top_data_li1">날짜 : ${fn:substring(dto.review_w_date,0,16)}</li>
				<li class="review_detail_top_data_li">조회 : ${dto.review_hit }</li>
			</ul>
		</div>
	</div>
	<br>
	<div class="review_detail_middle"  style="width: 900px;">
		<div style="width: 90%; margin:auto; padding-left: 130px;">
			<c:if test="${!empty dto1.review_image_name }">
 	 		  <img src="/review_image/${dto1.review_image_name }" style="max-width: 80%; height: auto; ">
			</c:if>		
		</div>
		<div class="review_detail_content">
			<textarea id="review_detail_content_text" disabled="disabled">${dto.review_content }</textarea>
		</div>
	</div>
	<div class="review_detail_footer">
		<div class="review_detail_button">
			<input type="button" class="review_create_btu btn1" id="btn_delete" value="    삭제    "
				style="float: left"
				onclick="javascript:location.href='/review.do?cmd=review_delete&review_num=${dto.review_num}'">
			<div class="board_ldk_button" style="float: right">
				<input type="button" class="review_create_btu btn1" id="btn_modify" value="    수정    "
					onclick="javascript:location.href='/review.do?cmd=review_detail_to_update&review_num=${dto.review_num}'">
				<input type="button" class="review_create_btu btn1" id="btn_cancel" value="    목록    "
					onclick="back_to_read()">
			</div>
		</div>
		<!-- 댓글view -->
		<div class="review_comment_view" style="clear:left;"><br>
			<div class="comment_subject">- comment</div>
			<div id="comment_list" class="comment_list"></div>
			<input type="button" id="comment_plus_btn" value="▽더 보기▽" style="width:100%" onclick="comment_plus()">
			<div id="comment_input_div">
				<table>
					<tr>
						<th style="width: 170px">&nbsp;&nbsp;${sessionScope.member_nickname}</th>
						<td>
							<input type="text" id="comment_content"style="margin-left: 5px; width: 570px; margin-top:6px; "> 
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
	}else if("${sessionScope.member_nickname}"!="${dto.review_writer}"){
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
		location.href="/review.do?cmd=review_read";
}
var xhr=null;
var xhr1=null;

function comment_create(){
	var review_comment_content=document.getElementById("comment_content").value;
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=comment_insert;
	xhr.open("post","/review.do?cmd=review_comment_create",true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	var params="review_comment_content="+review_comment_content+"&review_num="+"${dto.review_num}"+"&customer_num="+"${dto.customer_num}";
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

function showList(){
	xhr1=new XMLHttpRequest();
	xhr1.onreadystatechange=comment_list;
	xhr1.open("post","/review.do?cmd=review_comment_read",true);
	xhr1.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	//게시물 번호
	var param="review_num="+"${dto.review_num}";
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
			var review_comment_writer=xml.getElementsByTagName("review_comment_writer")[i].firstChild.nodeValue;
			var review_comment_content=xml.getElementsByTagName("review_comment_content")[i].firstChild.nodeValue;
			var review_comment_w_date=xml.getElementsByTagName("review_comment_w_date")[i].firstChild.nodeValue;
			var tr=document.createElement("tr");
			var html="<th style='width:180px'>"+review_comment_writer+"</th><td>&nbsp;&nbsp;"+review_comment_content+"</td><td style='width:300px;text-align:center'>"+review_comment_w_date+"</td>";
			tr.innerHTML=html;
			//댓글 리스트 영역에 댓글 추가하기
			table.appendChild(tr);

		}
		comment_list.appendChild(table);
		//console.log(comment_list.innerHTML);
	}
}
function comment_plus(){
	count=count+1;
	showList();
}
addLoadEvent(showList);
addLoadEvent(btn_display);
</script>