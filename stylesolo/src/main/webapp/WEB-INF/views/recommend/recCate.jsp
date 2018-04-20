<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	*{margin:0px;padding:0px;}
	#recWrap{width:1000px;height:1150px}
	#pageMove{width:100%;height:60px;padding-top:15px;}
	.catePageMove{width:200px;height:50px;display:inline-block;border:1px solid gray;margin-left:10px;}
	.catePageMove img{width:195px;height:49px;}
	.catePageMove span{display:none}
	#searchBar{width:100%;height:100px;padding-top:15px;}
	#searchBar *{display:inline-block}
	#searchBar .SortMethod{width:90px;heigth:40px;border:1px solid black;margin:5px;position:relative;}
	#searchBar #searchBox{margin-right:15px;position:absolute;left:400px;}
	#itemset{width:85%;height:800px;border:1px solid red;margin-top:15px;}
	#itemset p{text-decoration: none;color:fuchsia;}
	#paging{width:90%;height:60px;border:1px solid red;margin-top:10px;}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$.ready=function(){
		$(".catePageMove").each(function(n){
			var cateImg=$(this).find("img").attr("src");
			$(this).mouseover(function(){
				$(this).find("img").attr("src","/resources/itemsetImg/s"+n+".png");
			});
			$(this).mouseout(function(){
				$(this).find("img").attr("src",cateImg);
			});
		});
		$(".catePageMove").click(function(){
			var cate=$(this).find("span").text();
			location.href="recommendPage?category="+cate;
		});
		$(".SortMethod").click(function(){
			location.href="recommendPage?method="+$(this).attr("id")+"&category="+$("#cate").val();
		});
		if($("#SortMethod").val()=="lowPrice"){
			$("#lowPrice").css({
				"backgroundColor":"green"
			});
		}else if($("#SortMethod").val()=="highPrice"){
			$("#highPrice").css({
				"backgroundColor":"green"
			});
		}else{
			$("#new").css({
				"backgroundColor":"green"
			});
		}
	}
</script>
</head>
<body>
<div id="recWrap" align="center">
<input type="hidden" value="${requestScope.category }" id="cate"><input type="hidden" value="${requestScope.method }" id="SortMethod">
	<div id="pageMove">
		<span id="mdPageMove" class="catePageMove"><span>md</span><img src="/resources/itemsetImg/md.png"></span>
		<span id="codiPageMove" class="catePageMove"><span>codi</span><img src="/resources/itemsetImg/codi.gif"></span>
		<span id="intePageMove" class="catePageMove"><span>inte</span><img src="/resources/itemsetImg/inte.jpg"></span>
	</div>
	<div id="searchBar">
		<div class="container" style="display:inline;">
			<form>
				<input type="text" value="검색창" style="width:200px;height:40px;border-radius:20px;"><button type="submit" class="glyphicon glyphicon-search" style="width:40px;height:40px;border-radius:20px;">
			</form>
		</div>
		<span class="SortMethod" id="new">신상품순</span><span class="SortMethod" id="lowPrice">낮은가격순</span><span class="SortMethod" id="highPrice">높은가격순</span>
	</div>
	<div id="itemset">
		<a href="/itemsetDetail?codeNum=3"><span class="itemsetView" style="display:block;width:170px;height:200px;border:1px solid black;float:left;margin:15px;"><img style="width:160px;height:150px" src=""><p>aa</p><p>100</p></span></a>
	</div>
	<div id="paging">
		<nav aria-label="Page navigation">
  <ul class="pagination">
	  <c:if test="${requestScope.pageNum>20 }">
	    <li>
	      	<a href="#" aria-label="Previous">
	      		<span aria-hidden="true">&laquo;</span>
			</a>
	      	</li>
	    </c:if>
	    <c:forEach var="paging" begin="${requestScope.startPage }" end="${requestScope.endPage }">
    		<li><a href="recommendPage?method=${requestScope.method }&search=${requestScope.search}&pageNum=${paging }&category=${requestScope.category}"></a></li>
    	</c:forEach>
   		<c:if test="${(reqestScope.pageCount-requestScope.startPage)>=20 }">
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
    </c:if>
  </ul>
</nav>
	</div>
</div>
</body>
</html>