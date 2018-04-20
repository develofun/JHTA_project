<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
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
			location.href="recMain?method="+$(this).attr("id");
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
<div id="recWrap">
<input type="hidden" value="${requestScope.category }" id="cate"><input type="hidden" value="${requestScope.method }" id="SortMethod">
	<div id="pageMove">
		<span id="mdPageMove" class="catePageMove"><span>md</span><img src="/resources/itemsetImg/md.png"></span>
		<span id="codiPageMove" class="catePageMove"><span>codi</span><img src="/resources/itemsetImg/codi.gif"></span>
		<span id="intePageMove" class="catePageMove"><span>inte</span><img src="/resources/itemsetImg/inte.jpg"></span>
	</div>
	<div id="searchBar">
		<span id="searchBox">
			<span class="SortMethod" id="new">신상품순</span><span class="SortMethod" id="lowPrice">낮은가격순</span><span class="SortMethod" id="highPrice">높은가격순</span>
			<form>
				<input type="text" value="검색창" style="width:200px;height:30px;font-size:23px;"><input type="submit" value="검색">
			</form>
		</span>
		<span class="SortMethod" id="new">신상품순</span><span class="SortMethod" id="lowPrice">낮은가격순</span><span class="SortMethod" id="highPrice">높은가격순</span>
		
	</div>
	<div class="itemset">
		<div class="itemsetSort">MD추천</div>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist1.get(0).getItemsetCodeNum()}"><img src="${clist1.get(0).getItemsetCodeMainimg()}"></a><br><span>${clist1.get(0).getItemsetCodeSetname()}</span><br><span>${clist1.get(0).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist1.get(1).getItemsetCodeNum()}"><img src="${clist1.get(1).getItemsetCodeMainimg()}"></a><br><span>${clist1.get(1).getItemsetCodeSetname()}</span><br><span>${clist1.get(1).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist1.get(2).getItemsetCodeNum()}"><img src="${clist1.get(2).getItemsetCodeMainimg()}"></a><br><span>${clist1.get(2).getItemsetCodeSetname()}</span><br><span>${clist1.get(2).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist1.get(3).getItemsetCodeNum()}"><img src="${clist1.get(3).getItemsetCodeMainimg()}"></a><br><span>${clist1.get(3).getItemsetCodeSetname()}</span><br><span>${clist1.get(3).getItemsetCodePrice()}</span></span>
	</div>
	<div class="itemset">
		<div class="itemsetSort">코디추천</div>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist2.get(0).getItemsetCodeNum()}"><img src="${clist2.get(0).getItemsetCodeMainimg()}"></a><br><span>${clist2.get(0).getItemsetCodeSetname()}</span><br><span>${clist2.get(0).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist2.get(1).getItemsetCodeNum()}"><img src="${clist2.get(1).getItemsetCodeMainimg()}"></a><br><span>${clist2.get(1).getItemsetCodeSetname()}</span><br><span>${clist2.get(1).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist2.get(2).getItemsetCodeNum()}"><img src="${clist2.get(2).getItemsetCodeMainimg()}"></a><br><span>${clist2.get(2).getItemsetCodeSetname()}</span><br><span>${clist2.get(2).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist2.get(3).getItemsetCodeNum()}"><img src="${clist2.get(3).getItemsetCodeMainimg()}"></a><br><span>${clist2.get(3).getItemsetCodeSetname()}</span><br><span>${clist2.get(3).getItemsetCodePrice()}</span></span>
	</div>
	<div class="itemset">
		<div class="itemsetSort">인테리어추천</div>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist3.get(0).getItemsetCodeNum()}"><img src="${clist3.get(0).getItemsetCodeMainimg()}"></a><br><span>${clist3.get(0).getItemsetCodeSetname()}</span><br><span>${clist3.get(0).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist3.get(1).getItemsetCodeNum()}"><img src="${clist3.get(1).getItemsetCodeMainimg()}"></a><br><span>${clist3.get(1).getItemsetCodeSetname()}</span><br><span>${clist3.get(1).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist3.get(2).getItemsetCodeNum()}"><img src="${clist3.get(2).getItemsetCodeMainimg()}"></a><br><span>${clist3.get(2).getItemsetCodeSetname()}</span><br><span>${clist3.get(2).getItemsetCodePrice()}</span></span>
		<span class="itemsets"><a href="itemsetDetail?codeNum=${clist3.get(3).getItemsetCodeNum()}"><img src="${clist3.get(3).getItemsetCodeMainimg()}"></a><br><span>${clist3.get(3).getItemsetCodeSetname()}</span><br><span>${clist3.get(3).getItemsetCodePrice()}</span></span>
	</div>
</div>
