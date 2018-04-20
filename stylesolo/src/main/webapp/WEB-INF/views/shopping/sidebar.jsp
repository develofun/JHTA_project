<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
   $(function(){
      var n=150;
      
      cookieload();
    
      $("#down").click(function(event){
    	  $("#imgslide").stop();
         //이동코드
         //alert($("#slide").css("left"));
         var imgloc=parseInt($("#imgslide").css("top"));
         var loc=imgloc+n;
         if(loc>0) loc=0;
         $("#imgslide").animate({
            top:loc
         });
      });
      
      var m=-152;
      $("#up").click(function(event){
    	  $("#imgslide").stop();
         event.preventDefault();
         var imgloc=parseInt($("#imgslide").css("top"));
         var loc=imgloc+m;
         if(loc<-parseInt($("#imgslide").css("height"))+300) loc=-parseInt($("#imgslide").css("height"))+300;
         $("#imgslide").animate({
            top:loc
         });
      });
   });
   
   function cookieload(){
	   $.ajax({
	         url:"/itemSlideBar",
	         dataType:"json",
	         success:function(data){
	            for(var i=0;i<data.length;i++){
	            	$("#imgslide").css("height",150*data.length+"px");
	               var code=data[i].code;
	               var imgName=data[i].imgName;
	               if(imgName==null){
	            	   $("#imgslide").find("ul").append("<li><a href='#'><img src='/resources/img/solo.png'></a></li>");
	               }else{
	               	$("#imgslide").find("ul").append("<li><a href='shoplayout?item_code="+code+"'><img src='/resources/item_img/"+imgName+"'></a></li>");
	               }
	            }
	         }
	      });
   }

</script>   
   
   
<link rel="stylesheet" href="/resources/css/imgslide.css">
<div id="outline">
   <div id="title">
      <h6>오늘 본 상품</h6>
   </div>
   <div id="imgs">
      <div id="imgslide">
         <ul> <!-- 클릭한 제품번호 크기 6의 배열로 저장한 다음 for문 돌며 배열에 저장된 상품 이미지 노출  -->
            
         </ul>
      </div>
   </div>
   <div id="rolling">
      <a href="#" id="down">▼</a><a href="#" id="up">▲</a>
   </div>
</div>