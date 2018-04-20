<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<c:if test="${sessionScope.member_power eq 'admin'}">
 		<div id="notice_detail_btn">
			<a href="/notice.do?cmd=notice_delete&notice_num=${dto.notice_num }" id="notice_deleteBtn">삭제</a>
			<a href="/notice.do?cmd=notice_update_form&notice_num=${dto.notice_num }" id="notice_updateBtn">수정</a>
		</div>
	 </c:if>
	<div style="clear:both"></div>
	
	<div id="noticeLayer">
		<div id="titleLayer">${dto.notice_title }</div>
		<div id="contentLayer">${dto.notice_content }</div>
		<textarea rows="5" cols="107" class="comment" id="notice_comments_content"></textarea>
		<a href="javascript:;" class="createBtn" onclick="notice_comments_create()">등록</a>
		<div style="clear:both"></div>
		
		<div id="commentLayer">
			<p>댓글</p>
			<ul id="notice_comments_read"></ul>
			<input type="button" id="comment_plus_btn" value="더 보기▽" onclick="comment_plus()">
		</div>
	</div>
</div>
<script>
	var xhr=null;
	function notice_comments_create(){
		
		if('${sessionScope.member_nickname}' == ""){
			alert("로그인 후 이용가능합니다.");
		}else{
			notice_comments_content=document.getElementById("notice_comments_content").value;
			
			xhr=new XMLHttpRequest();
			xhr.onreadystatechange=create;
			xhr.open("post","notice_comments.do?cmd=notice_comments_create&notice_num=${dto.notice_num }",true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			var params="notice_comments_content="+notice_comments_content;
			xhr.send(params);
		}
	}
	function create(){
		if(xhr.readyState==4 && xhr.status==200){
			var xml=xhr.responseXML;
			var code=xml.getElementsByTagName("code")[0].firstChild.nodeValue;
			if(code=='success'){
				document.getElementById("notice_comments_content").value="";
				showread();
			}else{
				alert("등록실패!");
			}
		}
	}
	
	var xhr1=null;
	var count=1;
	function showread(){
		xhr1=new XMLHttpRequest();
		xhr1.onreadystatechange=read;
		xhr1.open("get","notice_comments.do?cmd=notice_comments_read&notice_num=${dto.notice_num }",true);
		xhr1.send();
	}
	function read(){
		if(xhr1.readyState==4 && xhr1.status==200){
			var xml=xhr1.responseXML;
			var commLength=xml.getElementsByTagName("data").length;
			
			var comment_plus_btn=document.getElementById("comment_plus_btn");
			var length=5*count;
			if(commLength<=5 || length>commLength){
				comment_plus_btn.style.display="none";
				length=commLength;
			}
			var notice_comments_content=document.getElementById("notice_comments_content");
			var notice_comments_num=document.getElementById("notice_comments_num");
			notice_comments_read.innerHTML="";
			for(var i=0;i<length;i++){
				var notice_comments_num=xml.getElementsByTagName("notice_comments_num")[i].firstChild.nodeValue;
				var notice_comments_content=xml.getElementsByTagName("notice_comments_content")[i].firstChild.nodeValue;
				var notice_comments_writer=xml.getElementsByTagName("notice_comments_writer")[i].firstChild.nodeValue;
				var notice_comments_w_date=xml.getElementsByTagName("notice_comments_w_date")[i].firstChild.nodeValue;
				var li=document.createElement("li");
				var html="";
				if(notice_comments_writer=='${sessionScope.member_nickname}'){
				    html="<p class='writer'>"+notice_comments_writer+"</p><p class='content'>"+notice_comments_content+"</p><p class='date'>"+notice_comments_w_date+"</p>"+
						 "<a href=\"javascript:showdelete("+notice_comments_num+")\" class='delBtn' >삭제</a><div style='clear:both;'></div>";
				}else{
					html="<p class='writer'>"+notice_comments_writer+"</p><p class='content'>"+notice_comments_content+"</p><p class='date'>"+notice_comments_w_date+"</p>"
				}
				li.innerHTML=html;
				li.className="notice_comments_content";
				notice_comments_read.appendChild(li);
			}
		}
	}
	function comment_plus(){
		count=count+1;
		showread();
	}
	
	var xhr2=null;
	function showdelete(notice_comments_num){
		xhr2=new XMLHttpRequest();
		xhr2.onreadystatechange=del;
		xhr2.open("get","notice_comments.do?cmd=notice_comments_delete&notice_comments_num="+notice_comments_num,true);
		xhr2.send();
	}
	function del(){
		if(xhr2.readyState==4 && xhr2.status==200){
			var xml=xhr2.responseXML;
			var code=xml.getElementsByTagName("code")[0].firstChild.nodeValue;
			if(code=='success'){
				showread();//글목록 다시 가져오기
			}else{
				alert("삭제실패!");
			}
		}
	}
	window.onload=showread;
</script>