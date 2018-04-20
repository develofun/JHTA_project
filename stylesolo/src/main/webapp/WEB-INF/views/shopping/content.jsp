<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link rel="stylesheet" href="/resources/css/descmain.css">
<style>
   .reviewClass{width:600px;border:1px dotted #eee}
   #qnalistArea thead{border-bottom:3px double #eee; }
   #qnalistArea tbody{border-bottom: 1px dotted #eee;}
   #qna_title{width:500px;}
   label{vertical-align: top}
   #qna_commit{backgroud-color:#eee;border:1px solid gray;width:100px;height:70px;vertical-align: top;border-radius:10px;}
   input{border:none;background-color:#eee;}
   textarea{border:none;background-color:#eee;}
   .inner{border:2px solid white;}
</style>
<script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.js"></script>
<script type="text/javascript">
   function del_select(n) {
      $("." + n).remove();
      total_price();
   }
   
   $(document)
         .ready(
               function() {                  
                  $("#rv").click(function(){
                     $(".review_list").find("tbody").empty();
                     review_load();   
                  });            
                  
                  $("#qna").click(function(){
                     $(".qna_list").find("tbody").empty();
                     qna_load();   
                  });
                  
                  $(".tab_content").hide();
                  $(".tab_content:first").show();

                  $("ul.tabs li").click(
                        function() {
                           $("ul.tabs li").removeClass("active").css(
                                 "color", "#333");
                           //$(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
                           $(this).addClass("active").css("color",
                                 "darkred");
                           $(".tab_content").hide()
                           var activeTab = $(this).attr("rel");
                           $("#" + activeTab).fadeIn()
                        });
                  var origin_src=$("#img1").attr("src");
                  $("#main_simg ul li img")
                        .hover(
                              function() {
                                 $("#img1").prop("src",
                                       $(this).attr("src"));
                              },
                              function() {
                                 $("#img1")
                                       .prop("src",
                                             origin_src);
                              });
                  var n = 1;
                  $("#btn")
                        .on(
                              "click",
                              function() {
                                 var arr=new Array();
                                 var item = $("#item").text(); // 상품명
                                 var code = $("#code").text(); // 상품코드
                                 var price = $("#price").text(); // 상품판매가
                                 arr.push(item); //0
                                 arr.push(code); //1
                                 arr.push(price); //2
                           //      console.log("옵션값:"+$("#main_i li").find("select").length);
                                 if($("#main_i li").find("select").length>0){
                                    var option = $(
                                          "#option1 option:selected")
                                          .val(); //옵션PK번호
                                    var optiontxt = $(
                                    "#option1 option:selected")
                                    .text(); //옵션명
                                    arr.push(option); //3
                                    arr.push(optiontxt); //4
                                    $.ajax({
                                       url:'getQty',
                                       data:"option="+option,
                                       dataType:'json',
                                       success:function(data){
                                    //      alert(data.qty);
                                          if(Number(data.qty)<qty){
                                             alert("주문가능한 수량은 "+data.qty+"개 입니다.");
                                             $("#qty").val("");
                                          }
                                       }            
                                    });
                                 }
                                 var qty = $("#qty").val(); // 수량5
                                 arr.push(qty);                        
                                 
                                 if (qty != "") {
                                    for(var j=0;j<arr.length;j++){
                                       console.log("arr:"+arr[j]);
                                    }
                                    if(arr.length>4){
                                          var pp = arr[2] * arr[5];
                                          var str = "<div><input type='hidden' name='code' class='code' value='"+arr[1]+"'><input type='hidden' name='option' class='option' value='"+arr[3]+"'><input type='hidden' name='qty' class='qty' value='"+arr[5]+"'>"                                           
                                                + arr[0] +" \t" + "["
                                                + arr[4] + "]\t"
                                                + ":\t" + arr[5] + "개"
                                                + "\t" + "금액:<span class='pp'>"
                                                + pp + "</span>원";
                                          $("#main_select")
                                                .append(
                                                      "<span class="+ (n)+ ">"+ str+ "<a href='javascript:del_select("+ (n++)+")'><img src='/resources/images/cross.jpg'></a></span></div><br>");
                                          $("#qty").val("");
                                          total_price();
                                       
                                    }else{
                                       var img1=$("#img1").attr("src");
                               
                                       var pp = arr[2] * arr[3];
                                       var str = "<div><input type='hidden' name='code' class='code' value='"+arr[1]+"'><input type='hidden' name='qty' class='qty' value='"+arr[3]+"'>"+arr[0] +" \t" + 
                                             + arr[3] + "개"
                                             + "\t" + "금액:<span class='pp'>"
                                             + pp + "</span>원";
                                       $("#main_select")
                                             .append(
                                                   "<span class="+ (n)+ ">"+ str+ "<a href='javascript:del_select("+ (n++)+")'><img src='/resources/images/cross.jpg'></a></span></div><br>");
                                       $("#qty").val("");
                                       total_price();
                                    }
                                 }else{
                                    alert("수량을 선택해 주세요!");
                                 }
                              });
                  $("#cart").on("click",function(){
                	 var id="<%=(String)session.getAttribute("id")%>";
                //	 alert(id);
                	 if(id!="null"){
	                     var code=[]; //상품코드
	                     var option=[]; //옵션번호
	                     var qty=[]; //주문수량
	                     $(".code").each(function(){
	                        code.push($(this).val());
	                     });
	                     $(".option").each(function(){
	                        option.push($(this).val());
	                     });
	                     $(".qty").each(function(){
	                        qty.push($(this).val());
	                     });
	                     var price=$("#price").text();
	                     $.ajaxSettings.traditional = true;
	                     $.ajax({
	                        type:'get',
	                        url:'addCart.do',
	                        data:{'code':code,'option':option,'qty':qty,'price':price},
	                        dataType:'json',
	                        success:function(data){
	                           if(data.result=='success'){
	                              var pop=confirm("장바구니에 추가되었습니다. 장바구니로 이동하시겠습니까?");
	                              if(pop==true){
	                                 location.href="cart";
	                              }else{
	                                 return;
	                              }
	                           }else if(data.result=='fail'){
	                              alert("장바구니 담기에 실패했습니다.");
	                           }else{
	                              alert("로그인이 필요한 서비스입니다.");
	                           }
	                        }
	                     });    
                	 }else{
                		 alert("로그인이 필요한 서비스입니다.");
              		  	 location.href="/member/login"; 
                	 }
                  });
                  // 바로주문
               /*   $("#order").on("click",function(){
                     var code=[]; //상품코드
                     var option=[]; //옵션번호
                     var qty=[]; //주문수량
                     $(".code").each(function(){
                        code.push($(this).val());
                     });
                     $(".option").each(function(){
                        option.push($(this).val());
                     });
                     $(".qty").each(function(){
                        qty.push($(this).val());
                     });
                     var price=$("#price").text();
                     $.ajaxSettings.traditional = true;
                     $.ajax({
                        type:'get',
                        url:'order.do',
                        data:{'code':code,'option':option,'qty':qty,'price':price},
                        dataType:'json',
                        success:function(data){
                           
                        }
                     });                                          
                  });               
                  */
                  
                  $("#qna").on("click",function(){
                     review_load();
                  });                  
                  $("#insert_review").submit(function(){
                     event.preventDefault();
                     
                     var file=document.getElementById("file1").value;
                     var content=$("#re_content").val();
                     file=file.slice(file.indexOf(".")+1).toLowerCase();
                     if(file!=null && file!="" && file!="jpg" && file!="png" && file!="gif" && file!="bmp"){
                        alert("이미지파일(.img/.png/.gif/.bmp) 파일만 업로드 가능합니다.");
                        return false;
                     }      
                     if(content.length<10){
                        alert("상품평은 10글자 이상 입력해 주세요.");
                        return false;
                     }
                     if(content==null){
                    	alert("내용을 입력해 주세요.")
                    	return false;
                     }
                    
                     var form = $("#insert_review")[0];
                     //FormData parameter에 담아줌
                     var formData = new FormData(form);
                     var file=$("#file1")[0].files[0];
                     if(file!=null && file.size>1000000){
                        alert("이미지 파일크기는 1MB 이하만 가능합니다.");
                        return false;
                     }
                     $.ajax({
                        url:'review_insert.do',
                        processData: false,
                               contentType: false,
                               data: formData,
                               type: 'POST',
                               dataType:'text',
                               success: function(data){
                                  if(data=='success'){
                                      $(".review_list").find("tbody").empty();
                                      review_load();
                                      $("#re_content").val("");
                                  }else{
                                     alert("등록실패");
                         
                                  }
                               }
                     });
                           
                  });      
                  
                  $(".view_c").on("click",function(){
                     $(this).next().toggle();
                  });
                  
                  //qna 검색
                  $("#search").submit(function(){
                     event.preventDefault();
                     var keyword=$("#keyword").val();
                     qna_load(1,keyword);
                     
                  });
                  
                  $(".qna_ok").submit(function(event){
                     event.preventDefault();
                     var code=$("#item_code").val();
                     var qna_content=$("#qna_content").val();
                     var title=$("#qna_title").val();
                     if(qna_content==null){
                    	 alert("글 내용을 입력해주세요.");
                    	 return false;
                     }
                     if(title==null){
                    	 alert("제목을 입력해 주세요.");
                    	 return false;
                     }
                     $.ajax({
                        url:'insert_qna.do',
                        data:'item_code='+code+"&title="+title+"&qna_content="+qna_content,
                        dataType:'text',
                        success:function(data){
                           if(data=='success'){
                              qna_load();
                              $("#qna_content").val("");
                              $("#qna_title").val("");
                           }else{
                              alert("글 등록에 실패하였습니다.");
                           }
                        }
                     });
                     
                  });
               });
   function jjim(code){ // 찜에 추가
	   var id="<%=(String)session.getAttribute("id")%>";
	   if(id!="null"){
	      $.ajax({
	         url:'addJjim.do',
	         data:'code='+code,
	         dataType:'json',
	         success:function(data){
	            if(data.result=='success'){
	               alert("찜에 추가되었습니다.");
	            }else if(data.result=='fail'){
	               alert("이미 찜목록에 등록된 상품입니다.");
	            }else if(data.result=='error'){
	               alert("찜 등록에 실패하였습니다.")
	            }else{
	               alert("로그인이 필요한 서비스입니다.");
	            }
	         }
	      });
	   }else{
		   alert("로그인이 필요한 서비스입니다.");
		   location.href="/member/login";
	   }
   }
   function total_price() {
      var i = $("#main_select").length;

      for (var j = 0; j < i; j++) {
         /*var price=$("#main_select").find("span").text();
         console.log("price"+price);
         total1= total1+parseInt(price);
         console.log(total1);*/
         var total1 = 0;
         $("#main_select").find(".pp").each(function() {
            var price = $(this).text();
            total1 = total1 + parseInt(price);
         });

         console.log(total1);
      }
      $("#main_price").empty();
      $("#main_price").append("<hr><h3>총 금액 : " + total1 + "원</h3>");
   }
   
   function fileCheck(){
      var file=document.getElementById("file1").value;
      var content=$("#re_content").val();
      file=file.slice(file.indexOf(".")+1).toLowerCase();
      if(file!=null && file!="" && file!="jpg" && file!="png" && file!="gif" && file!="bmp"){
         alert("이미지파일(.img/.png/.gif/.bmp) 파일만 업로드 가능합니다.");
         return false;
      }      
      if(content.length()<10){
         alert("상품평은 10글자 이상 입력해 주세요.");
         return false;
      }
      var star=$("select [id:star]:selected").val();
      console.log(별);
      var content=$("#re_content").val();
      console.log(content);
      var form = $("#insert_review")[0];
      //FormData parameter에 담아줌
      var formData = new FormData(form);
      var file=$("#file1")[0].files[0];
      if(file!=null && file.size>1000000){
         alert("이미지 파일크기는 1MB 이하만 가능합니다.");
         return false;
      }
      $.ajax({
         url:'review_insert.do',
         processData: false,
            contentType: false,
            data: formData,
            type: 'POST',
            dataType:'text',
            success: function(data){
               if(data=='success'){
                    $(".review_list").find("tbody").empty();
                    review_load();
               }else{
                  alert("등록실패");
      
               }
            }
      });
      
   }
   function review_load(pageNum){
      $(".review_list").find("tbody").empty();
   //   alert("게시글로드 진입");
      if(pageNum==null) pageNum=1;
      var item_code=$("#code").text();
   //   alert(item_code);
      $.ajax({
         url:'review_load',
         data:'pageNum='+pageNum+'&item_code='+item_code,
         dataType:'json',
         success:function(data){
   //         alert(data);
            for(var i=0;i<data.length;i++){
               var num=data[i].shop_review_num;
               var star=data[i].shop_review_star;
               var content=data[i].shop_review_content;
               var img=data[i].shop_review_file_filename;
               var writer=data[i].member_privacy_id;
                  var uWriter="";
                  for(var ii=0;ii<writer.length;ii++){
                     if(ii<3){
                        uWriter+=writer.charAt(ii);
                     }else{
                        uWriter+="*";
                     }
                  }
                  console.log("이미지:"+img);
                  var view_content;
                  if(img!=null){
                     content+="<br><img src='/resources/item_img/"+data[i].shop_review_file_filename+"'><br>";
                  }
                  var html="<tr id="+num+"><td>"+star+"</td>"+
                  "<td><a href='javascript:re_desc("+num+")'>"+data[i].shop_review_content+"</a></td>"+
                  "<td>"+uWriter+"</td>"+
                  "<td>"+data[i].shop_review_w_date+"</td></tr>"+
                  "<tr class='desc_"+num+"' style='display: none'><td colspan='4' style='background-color:#eee'>"+content+"<br></td></tr>";                                                               
                  
                  $("#reviewList tbody").append(html);
                  uWriter="";
               }
         //   var str="<li><a href='javascript:paging("+num+",review)'>"+[이전]+"</a></li>";
         //   for(var j=data[0].startPageNum;j<=data[0].endPageNum;j++){
         //      str+="<li><a href='javascript:paging("+j+",review)'>"+[j]+"</a></li>";
         //   }
         }
      });      
   }
   function re_desc(num){
      $(".desc_"+num).toggle();
   }
      
   function qna_load(pageNum,keyword){
      $(".qna_list").find("tbody").empty();
      $("#qnapagingArea").empty();
         if(pageNum==null) pageNum=1;
         if(keyword==null) keyword="";
         var item_code=$("#code").text();
         var pro="답변대기";
         $.ajax({
            url:'qna_load',
            data:'pageNum='+pageNum+'&item_code='+item_code+'&keyword='+keyword,
            dataType:'json',
            success:function(data){
   //          alert(data);
               for(var i=0;i<data.length;i++){
                  var num=data[i].shop_qna_num;
               //   console.log("num:"+num);
                  var title=data[i].shop_qna_title;
                  var content=data[i].shop_qna_content;
                  var date=data[i].shop_qna_w_date;
                  var hit=data[i].shop_qna_hit;
                  var id=data[i].member_privacy_id;
                  var uid="";
                        for(var ii=0;ii<id.length;ii++){
                           if(ii<3){
                              uid+=id.charAt(ii);
                           }else{
                             uid+="*";
                           }
                        }
                  
                  
                  var comm=data[i].shop_qna_comm_content;
               //   console.log("qna:"+num+title+content);
                  if(comm!=null){
                     content+="<tr><td>관리자</td><td colspan='4' style='background-color:#eee'>"+
                     comm+"</td><td>"+data[i].shop_qna_comm_w_date+"</td></tr>";
                     pro="답변완료";
                  }   
                  console.log("content:"+content);
                  var html="<tr id='qna_"+num+"'><td>"+num+"</td>"+
                  "<td><a href='javascript:qna_desc("+num+")'>"+title+"</a></td>"+
                  "<td>"+uid+"</td><td>"+date+"</td><td>"+hit+"</td><td>"+pro+"</td></tr>"+
                  "<tr class='qnadesc_"+num+"' style='display: none'><td colspan='6' style='background-color:#eee'>"+content+"</td></tr>";                                                                        
                  console.log("html:"+html);
                  $(".qna_list").find("tbody").append(html);   
                  uid="";
               }
               var str="";
               for(var j=data[0].startPageNum;j<=data[0].endPageNum;j++){
                  $("#qnapagingArea").append("<a href='javascript:qna_load("+j+")'>["+j+"]</a>");
               }
               $("#qnapagingArea").innerHTML=str;
            }
         });      
   }
   function qna_desc(num){
      var css_val=$(".qnadesc_"+num).css("display");
   //   alert(css_val);
      if(css_val=='none'){
         var item_code=$("#code").text();
         $.ajax({
            url:'qna_hit',
            data:'item_code='+item_code+'&num='+num,
            dataType:'text',
            success:function(data){
               if(data=='success'){
                  $(".qnadesc_"+num).toggle();
               }else{
                  alert("데이터를 불러오는데 실패했습니다.");               
               }
            }
         });
      }else{
         $(".qnadesc_"+num).toggle();
      }      
   }
   function qtyChk(){
	   var txt=$("#main_price").find("h3").text();
	   if(txt==null || txt==''){
		   alert("수량을 선택해 주세요.");
		   return false;
	   }
   }
</script>



<div class="main_wrap">
   <div id="main_img">
      <div id="main_mimg">
         <img id="img1" src="/resources/item_img/${list[0].shop_item_mainimg_imgname}">
      </div>
      <div id="main_simg">
         <ul>
               <c:forEach var='vo1' items="${list }">
               <c:if test="${vo1.shop_item_subimg_imgname != null }">
                  <li><img
                     src="/resources/item_img/${vo1.shop_item_subimg_imgname }"></li>
               </c:if>      
               </c:forEach>
         
         </ul>
      </div>
   </div>
   <div id="main_info">
      <div id="main_i">
         <ul style="line-height: 200%">
            <li>상품명 : <span id="item">${vo.shop_item_name }</span></li>
            <li>상품코드 : <span id="code">${vo.shop_item_code }</span></li>
            <li>판매가 : <span id="price">${vo.shop_item_saleprice }</span>원
            </li>
            <c:if test='${option !=null && option.size()>0}'>
               <li>옵션 : <select name="option_selec" id="option1">
                     <option>---옵션선택</option>
                     <c:forEach var='op' items="${option }">
                        <option value="${op.item_options_num }">${op.item_options_name }</option>
                     </c:forEach>
               </select>
               </li>
            </c:if>
            <li>수량 : <input type="number" name="order_qty" min="1" max="10"
               required="required" id="qty"><input type="button"
               value="적용" id="btn"></li>
         </ul>
      </div>
      <form action="order.do" onsubmit="return qtyChk()">
         <div id="main_select" style="width:100%;height:100px;overflow: auto">
         </div>
      
      <div id="main_price">
         <hr>
      </div>
      <div id="main_b">
         <input type="button" value="장바구니" class="button" id="cart">
         &nbsp;&nbsp; <input type="submit" value="바로구매" class="button" id="order"> &nbsp;&nbsp; <input
            type="button" value="찜하기" class="button" onclick="jjim(${vo.shop_item_code })">
      </div>
      </form>
   </div>
   <div id="main_contents">
      <div id="main_tap">
         <ul class="tabs">
            <li class="active" rel="tab1" id="desc">상품상세</li>
            <li rel="tab2" id="rv">구매평</li>
            <li rel="tab3" id="qna">상품문의</li>
         </ul>
         <div class="tab_container">
            <div id="tab1" class="tab_content"><img src="${vo.shop_item_desc }" width="800px"></div>
            <!-- #tab1 -->
            <!-- //////////////////// 구매평 영역      ///////////////  -->
            <div id="tab2" class="tab_content">
               <h1 style="color:gray">상품평 Review</h1>
               <hr>
               <form enctype="multipart/form-data" id="insert_review">
                  <input type="hidden" name="item_code" id="item_code" value="${vo.shop_item_code }">
                  <select id="star" name="star"> 
                     <option>★★★★★</option>
                     <option>★★★★☆</option>
                     <option>★★★☆☆</option>
                     <option>★★☆☆☆</option>
                     <option>★☆☆☆☆</option>
                  </select>
                  <input type="submit" value="등록하기" id="re_commit"><br>
                  <hr class="inner">
                  <textarea rows="5" cols="60" id="re_content" name="re_content"></textarea><br>
                  <input type="file" value="파일첨부" id="file1" name="file1"> (1MB 이하)
               </form>
               <div id="reviewList">
                  <table width="830px" style="border:1px dotted #eee" class="review_list">
                     <colgroup>
                        <col width="100px">
                        <col width="550px">
                        <col width="150px">
                        <col width="130px">
                     </colgroup>
                     <thead>
                        <th>별점</th>
                        <th>후기내용</th>
                        <th>작성자</th>
                        <th>작성일</th>                     
                     </thead>
                     <tbody>
                     
                     </tbody>
                  </table>
               </div>
               <div id="pagingarea">
                  <c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
                     <a href='javascript:review_load(${ i})'>[${ i}]</a>
                  </c:forEach>
               </div>
            </div>
            <!-- #tab2 -->
            <div id="tab3" class="tab_content">
               <h1 style="color:gray">상품문의 Q&A</h1>
               <hr>
               <div id="qna_insert" width="800px" height="150px">
               <form class="qna_ok">
               <input type="hidden" id="item_code" value="${vo.shop_item_code }">
               <label>글제목</label><input type="text" id="qna_title" size="20"><br>
               <hr class="inner">
               <label>글내용</label><textarea rows="5" cols="70" id="qna_content"></textarea>
               <input type="submit" id="qna_commit" value="문의글 등록하기">
               </form>
               <hr>
               </div>
               <div id="qnalistArea">
                  <table width="1000px" style="border:1px dotted #eee" class="qna_list">
                     <colgroup>
                        <col width="50px">
                        <col width="550px">
                        <col width="120px">
                        <col width="120px">
                        <col width="80px">
                        <col width="80px">
                     </colgroup>
                     <thead>
                     
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                        <th>처리현황</th>
                     
                     </thead>
                     <tbody>
                        
                     </tbody>
                  </table>
               </div>
                           <!-- 페이징처리 -->
               <div id="qnapagingArea">
                  <!-- 페이징 -->
                  
               </div>
               <div>
                  <form method="post" action="list" id="search">
                     글내용
                     <input type="text" name="keyword" value="${keyword }" id="keyword">
                     <input type="submit" id="btn1" value="검색">
                  </form>
               </div>         
            </div>
      </div>
      </div>
      <div id="main_desc"></div>
   </div>
</div>
</div>