<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
   // 로그인 일시가지고 오기
   Date time = new Date();
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   time.setTime(session.getCreationTime());
   // 닉네임, 회원번호얻어오기
   String member_nickname = (String) session.getAttribute("member_nickname");
   String customer_num = (String) session.getAttribute("customer_num");
   
   String rid="",checkornot="";
   
   Cookie[] cooks=request.getCookies();
	if(cooks!=null){
		for(Cookie cook:cooks){
			if(cook.getName().equals("input_id")){
				rid=cook.getValue();
			}else if(cook.getName().equals("check")){
				if(cook.getValue().equals("on")){
					checkornot="checked";
				}else{
					checkornot="";
				}
			}
		}
	}

%>
<div id="main_contents_right">
	<div id="main_contents_fboard">
		<div id="main_contents_fboard_title">
			<a>해외여행</a>
			<input type="button" value="< " onclick="fboard_slide(this)" id="fboard_left">
			<span id="fboard_cnt">${fboard_cnt}</span>/<span id="fboard_size">${fboard_size }</span>
			<input type="button" value=" >" onclick="fboard_slide(this)"id="fboard_right">
		</div>
		<div id="main_contents_fboard_content_image">
			<a href="fboard.do?cmd=fboard_detail&fboard_num=${fboard_num }&fboard_area=${fboard_area}&fboard_city=${fboard_city}&fboard_category=${fboard_category}">
				<img src="${fboard_image }" id="fboard_content_image">
			</a>
		</div>
		<div id="main_contents_fboard_content_text">
			<a href="fboard.do?cmd=fboard_detail&fboard_num=${fboard_num }&fboard_area=${fboard_area}&fboard_city=${fboard_city}&fboard_category=${fboard_category}">${fboard_title }</a>
		</div>
	</div>
	<div id="main_contents_kboard">
		<div id="main_contents_kobard_title">
			<a>국내여행</a> <input type="button" value="< "
				onclick="kboard_slide(this)"> <span id="kboard_cnt">${kboard_cnt}</span>/<span
				id="kboard_size">${kboard_size }</span> <input type="button"
				value=" >" onclick="kboard_slide(this)">
		</div>
		<div id="main_contents_kboard_content_image">
			<a href="/kboard.do?cmd=kboard_detail&kboard_num=${kboard_num }"><img src="${kboard_image }" id="kboard_content_image"></a>
		</div>
		<div id="main_contents_kboard_content_text">
		<a href="/kboard.do?cmd=kboard_detail&kboard_num=${kboard_num }">${kboard_title }</a>
		</div>
	</div>
	<div id="main_contents_free">
		<div id="main_contents_free_title">
			<a>자유게시판</a>
		</div>
		<div id="main_contents_free_recent">
			<div id="main_contents_free_recent_title">
				<a>최신글</a> <input type="button" value="< "
					onclick="free_slide(this)"> <span id="free_cnt">${free_cnt}</span>/<span
					id="free_size">${free_size }</span> <input type="button" value=" >"
					onclick="free_slide(this)">
			</div>
			<div id="main_contents_free_recent_content">
				<c:choose>
					<c:when test="${free_empty==true }"></c:when>
					<c:otherwise>
						<table id="main_free_table">
							<c:forEach var="list" items="${main_free }">
								<tr>
									<td>
									<c:choose>
										<c:when test="${fn:length(list.free_title) > 30}">
										<a href="/free.do?cmd=detail&free_num=${list.free_num }">${fn:substring(list.free_title,0,13)}....</a>
										</c:when>
										<c:otherwise>
        								<a href="/free.do?cmd=detail&free_num=${list.free_num }">${list.free_title }</a>
        								</c:otherwise> 
									</c:choose>
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div id="main_contents_free_best">
			<div id="main_contents_free_best_title">
				<a>BEST</a> <input type="button" value="< "
					onclick="top10_slide(this)"> <span id="top10_cnt">${top10_cnt}</span>/<span
					id="top10_size">${top10_size }</span> <input type="button"
					value=" >" onclick="top10_slide(this)">
			</div>
			<div id="main_contents_free_best_content">
				<c:choose>
					<c:when test="${free_empty==true }"></c:when>
					<c:otherwise>
						<table id="main_top10_table">
							<c:forEach var="list" items="${main_top10 }">
								<tr>
									<td>
									<c:choose>
										<c:when test="${fn:length(list.free_title) > 30}">
										<a href="/free.do?cmd=detail&free_num=${list.free_num }">${fn:substring(list.free_title,0,13)}....</a>
										</c:when>
										<c:otherwise>
        								<a href="/free.do?cmd=detail&free_num=${list.free_num }">${list.free_title }</a>
        								</c:otherwise> 
									</c:choose>
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div id="main_contents_event1">
		<!-- 이벤트배너 -->
		
	</div>
	<div id="main_contents_review">
		<div id="main_contents_review_title">
			<a>리뷰/후기</a> <input type="button" value="< "
				onclick="review_slide(this)"> <span id="review_cnt">${review_cnt}</span>/<span
				id="review_size">${review_size}</span> <input type="button"
				value=" >" onclick="review_slide(this)">
		</div>
		<div id="main_contents_review_content">
			<c:choose>
				<c:when test="${review_empty==true }"></c:when>
				<c:otherwise>
					<table id="main_review_table">
						<c:forEach var="list" items="${main_review }">
							<tr>
								<td>
								<c:choose>
				           			<c:when test="${fn:length(list.review_title) > 30}">
					  					<a href="/review.do?cmd=detail&review_num=${list.review_num }">${fn:substring(list.review_title,0,13)}....</a>
					  				</c:when>
					  				<c:otherwise>
				            			<a href="/review.do?cmd=detail&review_num=${list.review_num }">${list.review_title }</a>
				           			</c:otherwise> 
					  			</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
</div>
<div id="main_contents_left">
	<div id="main_contents_login">
		<div>
			<c:if test="${empty sessionScope.member_nickname }">

				<!-- 세션에 닉네임이 없을때 -->
				<div style="margin-top: 10px">
					<div style="float: left; margin-bottom: 10px">
						<div>
							<label>&nbsp;아이디&nbsp;&nbsp;</label> <input type="text"
								id="login_id" value="<%=rid %>" placeholder="아이디" required style="width: 160px;">
						</div>
						<div style="margin-top: 10px">
							<label>비밀번호</label> <input type="password" id="member_password"
								placeholder="비밀번호" required style="width: 160px;"><br>
						</div>
					</div>
					<div style="float: left; margin-left: 10px">
						<input type="button" value="로그인" onclick="login_info()"
							style="width: 60px; height: 50px">
					</div>
					<div style="clear: left; border-bottom: 1px solid gray">
						<div>
							<div id="error"></div>
							<div style="margin-top: 5px;">
								<ul style="list-style: none;line-height:40px;text-decoration: none;">
									<li style="float: left; margin-left: 10px">
										<input type="checkbox" id="id_save" value="아이디 저장" <%=checkornot %>>아이디 저장</li>
									<li style="float: left; margin-left: 15px">
										<a href="/member.do?cmd=member_insert_page">회원가입</a></li>
									<li style="float: left; margin-left: 15px">
										<a href="/member.do?cmd=member_find_page">아아디/비밀번호 찾기</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		<div>
			<c:if test="${not empty sessionScope.member_nickname }">
				<div style="padding:10px;">
					<!-- 세션에 닉네임이 있을때 -->
					<div style="margin-bottom: 10px;font-size:14px">
						<p><span style="font-weight:bold">[&nbsp;<%=member_nickname%>&nbsp;]</span>
							님 환영합니다.
						</p>
					</div>
					<div>
						<ul style="list-style:none;font-size:14px">
							<li style="float:left;margin-right:10px"><a href="/member.do?cmd=member_detail_to_update">프로필수정</a></li>
							<li style="float:left"><a href="/board_member/member_logout.jsp">로그아웃</a></li>
						</ul>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<div id="main_contents_notice">
		<div id="main_contents_notice_title">
			<a>공지사항</a>
		</div>
		<div id="main_contents_notice_content">
			<c:choose>
				<c:when test="${notice_empty==true }"></c:when>
				<c:otherwise>
					<table>
						<c:forEach var="list" items="${main_notice }">
							<tr>
								<td><a href="/notice.do?cmd=notice_detail&notice_num=${list.notice_num}">${list.notice_title }</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div id="main_contents_market">
		<div id="main_contents_market_title">
			<a>중고장터</a> <input type="button" value="< "
				onclick="market_slide(this)"> <span id="market_cnt">${market_cnt}</span>/<span
				id="market_size">${market_size}</span> <input type="button"
				value=" >" onclick="market_slide(this)">
		</div>
		<div id="main_contents_market_content">
			<c:choose>
				<c:when test="${market_empty==true }"></c:when>
				<c:otherwise>
					<table id="main_market_table">
						<c:forEach var="list" items="${main_market }">
							<tr>
								<td><a href="/market.do?cmd=market_detail&market_num=${list.market_num }">${list.market_title }</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<script>
   //로그인
   var xhr=null;
   function login_info(){
	      var login_id=document.getElementById("login_id").value;
	      var member_password=document.getElementById("member_password").value;
	      var id_save=document.getElementById("id_save").checked;
	      if(login_id=="" || member_password==""){
	    	  error.innerHTML="<span style='color:red'>아이디, 비밀번호를 입력해 주세요.</span>";
	    	  return;
	      }
	      xhr=new XMLHttpRequest();
	      xhr.onreadystatechange=loginX;
	      xhr.open("post","/member.do?cmd=member_login",true);
	      xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	      var params="login_id="+login_id+"&member_password="+member_password+"&id_save="+id_save;
	      xhr.send(params);
	   }   
   function loginX(){
      if(xhr.readyState==4 && xhr.status==200){
         xml=xhr.responseXML;         
         var result=xml.getElementsByTagName("result")[0].firstChild.nodeValue;
         if(result=="success"){
            location.href="/move.do?cmd=main";
         }
         if(result=="failed"){
            var input_id=xml.getElementsByTagName("id")[0].firstChild.nodeValue;
            var input_password=xml.getElementsByTagName("password")[0].firstChild.nodeValue;
            var error=document.getElementById("error");
            var login_id=document.getElementById("login_id");
            var member_password=document.getElementById("member_password");
            login_id.value=input_id;
            member_password.value=input_password;
            error.innerHTML="<span style='color:red'>아이디, 비밀번호가 맞지 않습니다.</span>"
         }
      }
   }
   //해외여행 버튼
   var xhr1=null;
   function fboard_slide(slide){
      var fboard_cnt=document.getElementById("fboard_cnt").innerHTML;
      var fboard_size=document.getElementById("fboard_size").innerHTML;
      fboard_cnt=Number(fboard_cnt);
      fboard_size=Number(fboard_size);
      if(slide.value=="< "){
         if(fboard_cnt==1){
            fboard_cnt=fboard_size;
         }else{
            fboard_cnt=fboard_cnt-1;
         }
      }else if(slide.value==" >"){
         if(fboard_cnt==fboard_size){
            fboard_cnt=1;
         }else{
            fboard_cnt=fboard_cnt+1;
         }
      }
      xhr1=new XMLHttpRequest();
      xhr1.onreadystatechange=getFboard;
      xhr1.open("post", "main.do?cmd=fboard_move", true);
      xhr1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      var param="fboard_cnt="+fboard_cnt;
      xhr1.send(param);
   }
   function getFboard(){
      if(xhr1.readyState==4 && xhr1.status==200){
         var xml1=xhr1.responseXML;
         var fboard_cnt=xml1.getElementsByTagName("fboard_cnt")[0].firstChild.nodeValue;
         var fboard_num=xml1.getElementsByTagName("fboard_num")[0].firstChild.nodeValue;
         var fboard_image=xml1.getElementsByTagName("fboard_image")[0].firstChild.nodeValue;
         var fboard_title=xml1.getElementsByTagName("fboard_title")[0].firstChild.nodeValue;
         var fboard_area=xml1.getElementsByTagName("fboard_area")[0].firstChild.nodeValue;
         var fboard_city=xml1.getElementsByTagName("fboard_city")[0].firstChild.nodeValue;
         var fboard_category=xml1.getElementsByTagName("fboard_category")[0].firstChild.nodeValue;
         var div_fboard_cnt=document.getElementById("fboard_cnt");
         var fboard_content_image=document.getElementById("main_contents_fboard_content_image");
         var main_contents_fboard_content_text=document.getElementById("main_contents_fboard_content_text");
         div_fboard_cnt.innerHTML=fboard_cnt;
         fboard_content_image.innerHTML="<a href=\"fboard.do?cmd=fboard_detail&fboard_num="+fboard_num+"&fboard_area="+fboard_area+"&fboard_city="+fboard_city+"&fboard_category="+fboard_category+"\"><img src=\""+fboard_image+"\"></a>";
         main_contents_fboard_content_text.innerHTML="<a href=\"fboard.do?cmd=fboard_detail&fboard_num="+fboard_num+"&fboard_area="+fboard_area+"&fboard_city="+fboard_city+"&fboard_category="+fboard_category+"\">"+fboard_title+"</a>";
      }
   }
   //국내여행 버튼
   var xhr2=null;
   function kboard_slide(slide){
      var kboard_cnt=document.getElementById("kboard_cnt").innerHTML;
      var kboard_size=document.getElementById("kboard_size").innerHTML;
      kboard_cnt=Number(kboard_cnt);
      kboard_size=Number(kboard_size);
      if(slide.value=="< "){
         if(kboard_cnt==1){
            kboard_cnt=kboard_size;
         }else{
            kboard_cnt=kboard_cnt-1;
         }
      }else if(slide.value==" >"){
         if(kboard_cnt==kboard_size){
            kboard_cnt=1;
         }else{
            kboard_cnt=kboard_cnt+1;
         }
      }
      xhr2=new XMLHttpRequest();
      xhr2.onreadystatechange=getKboard;
      xhr2.open("post", "main.do?cmd=kboard_move", true);
      xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      var param="kboard_cnt="+kboard_cnt;
      xhr2.send(param);
   }
   function getKboard(){
      if(xhr2.readyState==4 && xhr2.status==200){
         var xml2=xhr2.responseXML;
         var kboard_cnt=xml2.getElementsByTagName("kboard_cnt")[0].firstChild.nodeValue;
         var kboard_num=xml2.getElementsByTagName("kboard_num")[0].firstChild.nodeValue;
         var kboard_image=xml2.getElementsByTagName("kboard_image")[0].firstChild.nodeValue;
         var kboard_title=xml2.getElementsByTagName("kboard_title")[0].firstChild.nodeValue;
         var div_kboard_cnt=document.getElementById("kboard_cnt");
         var main_contents_kboard_content_image=document.getElementById("main_contents_kboard_content_image");
         var main_contents_fboard_content_text=document.getElementById("main_contents_kboard_content_text");
         div_kboard_cnt.innerHTML=kboard_cnt;
         main_contents_kboard_content_image.innerHTML="<a href=\"/kboard.do?cmd=kboard_detail&kboard_num="+kboard_num+"\"><img src=\""+kboard_image+"\"></a>";
         main_contents_kboard_content_text.innerHTML="<a href=\"/kboard.do?cmd=kboard_detail&kboard_num="+kboard_num+"\">"+kboard_title+"</a>";
      }
   }
   //자유게시판 버튼
   //최신순
   var xhr3=null;
   function free_slide(slide){
	   var free_cnt=document.getElementById("free_cnt").innerHTML;
	      var free_size=document.getElementById("free_size").innerHTML;
	      free_cnt=Number(free_cnt);
	      free_size=Number(free_size);
	      if(slide.value=="< "){
	         if(free_cnt==1){
	        	 free_cnt=2;
	        	 if(free_size<2){free_cnt=1;}
	         }else{
	            free_cnt=free_cnt-1;
	            if(free_size==0){free_cnt=0;}
	         }
	      }else if(slide.value==" >"){
	         if(free_cnt==free_size){
	            free_cnt=1;
	            if(free_size==0){free_cnt=0;}
	         }else{
	            free_cnt=free_cnt+1;
	         }
	     }
	    xhr3=new XMLHttpRequest();
	    xhr3.onreadystatechange=getFree;
	    xhr3.open("post", "main.do?cmd=free_move", true);
	    xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    var param="free_cnt="+free_cnt;
	    xhr3.send(param);	    
   }
   function getFree(){
	   if(xhr3.readyState==4 && xhr3.status==200){
	         var xml3=xhr3.responseText;
	         var json=eval("("+xml3+")");
	         var free_cnt=json.free_cnt;
	         var main_free=json.main_free;
	         var main_free_num=json.main_free_num;
	         var main_free_table=document.getElementById("main_free_table");
	         var div_free_cnt=document.getElementById("free_cnt");
	         div_free_cnt.innerHTML=free_cnt;
	         var main_free_title="";
	         for(var i=0;i<main_free.length;i++){
	        	 main_free_title=main_free_title+"<tr><td><a href=\"/free.do?cmd=detail&free_num="+main_free_num[i]+"\">"+main_free[i]+"</a></td></tr>"; 
	         }
	         main_free_table.innerHTML=main_free_title;
	     }
   }
   //조회수순
   var xhr4=null;
   function top10_slide(slide){
		var top10_cnt=document.getElementById("top10_cnt").innerHTML;
	  	var top10_size=document.getElementById("top10_size").innerHTML;
	    top10_cnt=Number(top10_cnt);
	    top10_size=Number(top10_size);
	    	if(slide.value=="< "){
	         	if(top10_cnt==1){
	        	 	top10_cnt=2;
	        	 	if(top10_size<2){top10_cnt=1;}
	        	}else{
	            	top10_cnt=top10_cnt-1;
	            	if(top10_size==0){top10_cnt=0;}
	            	if(top10_size<=5){top10_cnt=1;}
	         	}
	      	}else if(slide.value==" >"){
	        	 if(top10_cnt==top10_size){
	            	top10_cnt=1;
	            	if(top10_size==0){top10_cnt=0;}
	         	}else{
	           		top10_cnt=top10_cnt+1;
	         	}
	     	}
	    xhr4=new XMLHttpRequest();
	    xhr4.onreadystatechange=getTop10;
	    xhr4.open("post", "main.do?cmd=top10_move", true);
	    xhr4.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    var param="top10_cnt="+top10_cnt;
	    xhr4.send(param);	    
   }
   function getTop10(){
	   if(xhr4.readyState==4 && xhr4.status==200){
	         var xml4=xhr4.responseText;
	         var json=eval("("+xml4+")");
	         var top10_cnt=json.top10_cnt;
	         var main_top10=json.main_top10;
	         var main_top10_num=json.main_top10_num;
	         var main_top10_table=document.getElementById("main_top10_table");
	         var div_top10_cnt=document.getElementById("top10_cnt");
	         div_top10_cnt.innerHTML=top10_cnt;
	         var main_top10_title="";
	         for(var i=0;i<main_top10.length;i++){
	        	 main_top10_title=main_top10_title+"<tr><td><a href=\"/free.do?cmd=detail&free_num="+main_top10_num[i]+"\">"+main_top10[i]+"</a></td></tr>";
	         }
	         main_top10_table.innerHTML="<table>"+main_top10_title+"</table>";
	      }
   }
   //리뷰/후기 버튼
   var xhr5=null;
   function review_slide(slide){
		var review_cnt=document.getElementById("review_cnt").innerHTML;
	  	var review_size=document.getElementById("review_size").innerHTML;
	    review_cnt=Number(review_cnt);
	    review_size=Number(review_size);
	    	if(slide.value=="< "){
	         	if(review_cnt==1){
	        	 	review_cnt=2;
	        	 	if(review_size==0){review_cnt=1;}
	        	 	if(review_size<=5){review_cnt=1;}
	        	}else{
	            	review_cnt=review_cnt-1;
	            	if(review_size==0){review_cnt=0;}
	         	}
	      	}else if(slide.value==" >"){
	        	 if(review_cnt==review_size){
	            	review_cnt=1;
	            	if(review_size==0){review_cnt=0;}
	         	}else{
	           		review_cnt=review_cnt+1;
	         	}
	     	}
	    xhr5=new XMLHttpRequest();
	    xhr5.onreadystatechange=getReview;
	    xhr5.open("post", "main.do?cmd=review_move", true);
	    xhr5.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    var param="review_cnt="+review_cnt;
	    xhr5.send(param);
   }
   function getReview(){
	   if(xhr5.readyState==4 && xhr5.status==200){
	         var xml5=xhr5.responseText;
	         var json=eval("("+xml5+")");
	         var review_cnt=json.review_cnt;
	         var main_review=json.main_review;
	         var main_review_num=json.main_review_num;
	         var main_review_table=document.getElementById("main_review_table");
	         var div_review_cnt=document.getElementById("review_cnt");
	         div_review_cnt.innerHTML=review_cnt;
	         var main_review_title="";
	         for(var i=0;i<main_review.length;i++){
	        	 main_review_title=main_review_title+"<tr><td><a href=\"/free.do?cmd=detail&free_num="+main_review_num[i]+"\">"+main_review[i]+"</a></td></tr>";
	         }
	         main_review_table.innerHTML="<table>"+main_review_title+"</table>";
	      }
   }
   //중고장터 버튼
   var xhr6=null;
   function market_slide(slide){
		var market_cnt=document.getElementById("market_cnt").innerHTML;
	  	var market_size=document.getElementById("market_size").innerHTML;
	    market_cnt=Number(market_cnt);
	    market_size=Number(market_size);
	    	if(slide.value=="< "){
	         	if(market_cnt==1){
	        	 	market_cnt=2;
	        	 	if(market_size==0){market_cnt=1;}
	        	 	if(review_size<=5){review_cnt=1;}
	        	}else{
	            	market_cnt=market_cnt-1;
	            	if(market_size==0){market_cnt=0;}
	         	}
	      	}else if(slide.value==" >"){
	        	 if(market_cnt==market_size){
	            	market_cnt=1;
	            	if(market_size==0){market_cnt=0;}
	         	}else{
	           		market_cnt=market_cnt+1;
	         	}
	     	}
	    xhr6=new XMLHttpRequest();
	    xhr6.onreadystatechange=getMarket;
	    xhr6.open("post", "main.do?cmd=market_move", true);
	    xhr6.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    var param="market_cnt="+market_cnt;
	    xhr6.send(param);	    
   }
   function getMarket(){
	   if(xhr6.readyState==4 && xhr6.status==200){
	         var xml6=xhr6.responseText;
	         var json=eval("("+xml6+")");
	         var market_cnt=json.market_cnt;
	         var main_market=json.main_market;
	         var main_market_num=json.main_market_num;
	         var main_market_table=document.getElementById("main_market_table");
	         var div_market_cnt=document.getElementById("market_cnt");
	         div_market_cnt.innerHTML=market_cnt;
	         var main_market_title="";
	         for(var i=0;i<main_market.length;i++){
	        	 main_market_title=main_market_title+"<tr><td><a href=\"/free.do?cmd=detail&free_num="+main_market_num[i]+"\">"+main_market[i]+"</a></td></tr>";
	         }
	         main_market_table.innerHTML="<table>"+main_market_title+"</table>";
	      }
   } 
   //이벤트 배너
   var xhr8=null;
   (function eventSale_banner(){
	    xhr8=new XMLHttpRequest();
	    xhr8.onreadystatechange=getEventSail;
	    xhr8.open("post", "main.do?cmd=eventSale_move", true);
	    xhr8.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhr8.send();
   })();
   function getEventSail(){
	   if(xhr8.readyState==4 && xhr8.status==200){
		  var xml8=xhr8.responseText;
	      var json=eval("("+xml8+")");
	      var eventSale_num=json.eventSale_num;
	      var main_eventSale=json.main_eventSale;
	      var main_contents_event1=document.getElementById("main_contents_event1");	
	      var main_event="<div id=\"main_contents_eventSale\">[이벤트/할인]&nbsp&nbsp<a href=\"/eventSale.do?cmd=eventSale_detail&eventSale_num="+eventSale_num[0]+"\">"+main_eventSale[0]+"</a></div>";
  		  main_contents_event1.innerHTML=main_event;
	      (function looper (i) {
	    		setTimeout(function() {
	    		var main_event="<div id=\"main_contents_eventSale\">[이벤트/할인]&nbsp&nbsp<a href=\"/eventSale.do?cmd=eventSale_detail&eventSale_num="+eventSale_num[i]+"\">"+main_eventSale[i]+"</a></div>";
	    		main_contents_event1.innerHTML=main_event;
	    		if (main_eventSale.length>++i ){looper (i);}
	    		else{i=0;looper(i);}
	    		}, 2000)
	    	})(1);
	   }
   }
</script>