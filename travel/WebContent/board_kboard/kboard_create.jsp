<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="//code.jquery.com/jquery.min.js"></script>
	<script>

	function cancel(){
		location.href="/kboard.do?cmd=kboard_read";
	}
	
	var xhr = null;
	function category(value){
		//var kboard_category = $(":input:radio[name='kboard_category']:checked").val();
		var kboard_category=value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = create;
		if(kboard_category=="명소"){
			xhr.open("get", "/board_kboard/kboard_attraction_create.jsp?kboard_category=" + kboard_category, true);
		}else if(kboard_category==("맛집")){
			xhr.open("get", "/board_kboard/kboard_food_create.jsp?kboard_category=" + kboard_category, true);
		}else if(kboard_category==("숙박")){
			xhr.open("get", "/board_kboard/kboard_hotel_create.jsp?kboard_category=" + kboard_category, true);
		}else if(kboard_category==("축제")){
			xhr.open("get", "/board_kboard/kboard_festival_create.jsp?kboard_category=" + kboard_category, true);
		}else{
			xhr.open("get", "/board_kboard/kboard_attraction_create.jsp?kboard_category=" + kboard_category, true);
		}
		xhr.send();
	}
	function create() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			var result = document.getElementById("result");
			result.innerHTML = data;
			showcity();
		}
	}
	//window.onload=category;
	$(document).ready(function(){
		category();
	})
	function showcity(obj) {
		if(obj==null) obj="서울";

		var seoul = new Array('서울');
		var gyeonggi = new Array('인천','파주','포천','이천','기타');
		var gangwon = new Array('강릉','평창','춘천','기타');
		var chungcheong = new Array('대전','보령','천안','기타');
		var gyeongsang = new Array('부산','울산','대구','경주','기타');
		var jeonlado = new Array('광주','여수','목포','전주','기타');
		var jeju = new Array('제주','서귀포');
		
		var inner = "";
		switch(obj) {
			case "서울" :
				for(var i=0; i<seoul.length; i++) {
					inner += "<option value='"+seoul[i]+"'>"+seoul[i]+"</option>";
				}
				break;
			
			case "경기도" :
				for(var i=0; i<gyeonggi.length; i++) {
					inner += "<option value='"+gyeonggi[i]+"'>"+gyeonggi[i]+"</option>";
				}
				break;
			
			case "강원도" : 
				for(var i=0; i<gangwon.length; i++){
					inner += "<option value='"+gangwon[i]+"'>"+gangwon[i]+"</option>";
				}
				break;
			
			case "충청도" : 
				for(var i=0; i<chungcheong.length; i++){
					inner += "<option value='"+chungcheong[i]+"'>"+chungcheong[i]+"</option>";
				}
				break;
			
			case "경상도" : 
				for(var i=0; i<gyeongsang.length; i++){
					inner += "<option value='"+gyeongsang[i]+"'>"+gyeongsang[i]+"</option>";
				}
				break;
			
			case "전라도" : 
				for(var i=0; i<jeonlado.length; i++){
					inner += "<option value='"+jeonlado[i]+"'>"+jeonlado[i]+"</option>";
				}
				break;
			
			case "제주도" :
				for(var i=0; i<jeju.length; i++){
					inner += "<option value='"+jeju[i]+"'>"+jeju[i]+"</option>";
				}
				break;
			}
			$("#kboard_city").html(inner);
		}
</script>
<h1 style="width:250px;">국내여행 글쓰기</h1>
<div>
	<form method="post" name="select_area" action="/kboard.do?cmd=kboard_create" enctype="multipart/form-data">
		<p>
			<input type="radio" name="kboard_category" value="명소" checked="checked" onclick="category(this.value)">명소
			<input type="radio" name="kboard_category" value="맛집" onclick="category(this.value)">맛집 
			<input type="radio" name="kboard_category" value="숙박" onclick="category(this.value)">숙박 
			<input type="radio" name="kboard_category" value="축제" onclick="category(this.value)">축제
		</p>
		<div id="result">
		</div>
	</form>
</div>