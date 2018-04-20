<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="recMainWrap">
	<div id="selectCategory" class="form-inline" style="margin:10px 20px">
		<ul id="selectCategory"class="list-group" style="float:left">
			<a href="recommendPage?category=md"><li class="list-group-item" style="display:inline-block;width:200px;text-align:center;font-size:1.1em;">MD추천</li></a>
			<a href="recommendPage?category=codi"><li class="list-group-item" style="display:inline-block;width:200px;text-align:center;font-size:1.1em;">코디추천</li></a>
			<a href="recommendPage?category=inte"><li class="list-group-item" style="display:inline-block;width:200px;text-align:center;font-size:1.1em;">인테리어추천</li></a>
		</ul>
		<div id="searchBox">
			<form action="recommendPage">
				<input type="hidden" name="category" value="${requestScope.map.category }">
				<input type="hidden" name="method" value="${requestScope.map.method }">
				<input type="text" name="search" class="form-control"><i class="icon-search icon-large"></i>
			</form>
		</div>
	</div>
	<div id="cateNameWrap" style="position:relative;">
		<c:choose>
			<c:when test="${requestScope.map.category=='md' }">
				<div class="page-header" style="font-size:2.0em;font-weight:bold;border-bottom:1px solid gray">MD추천</div>
			</c:when>
			<c:when test="${requestScope.map.category=='codi' }">
				<div class="page-header" style="font-size:2.0em;font-weight:bold;">코디추천</div>
			</c:when>
			<c:otherwise>
				<div class="page-header" style="font-size:2.0em;font-weight:bold;">인테리어추천</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="categoryBest" class="form-inline">
			<c:choose>
				<c:when test="${requestScope.map.category=='md' }">
					<div id="bestLabel" style="font-size:1.5em;font-weight:bold;">MD NewItem</div>
				</c:when>
				<c:when test="${requestScope.map.category=='codi' }">
					<div id="bestLabel" style="font-size:1.5em;font-weight:bold;">코디추천 NewItem</div>
				</c:when>
				<c:otherwise>
					<div id="bestLabel" style="font-size:1.5em;font-weight:bold;">인테리어 추천 NewItem</div>
				</c:otherwise>
			</c:choose>
			<c:forEach var="nItem" items="${requestScope.nList }">
				<div class="bestItem" style="width:300px;display:inline-block;padding:0px 10px;"><a href="itemsetDetail?codeNum=${nItem.item_code_num }" style="text-decoration:none;"><img src="/resources/itemset_img/${nItem.itemset_code_mainimg }" style="width:100%;"><span style="font-size:1.2em;color:black;font-weight:bold;">${nItem.item_code_setname }</span></a></div>
			</c:forEach>
	</div>
	<div id="selectMethod" style="margin:30px 0px 0px 10px">
		<div class="methodChoice" style="display:inline-block"><a href="recommendPage?category=${requestScope.map.category }&method=new" class="form-control">신상품순</a></div>
		<div class="methodChoice" style="display:inline-block"><a href="recommendPage?category=${requestScope.map.category }&method=lowPrice" class="form-control">낮은가격순</a></div>
		<div class="methodChoice" style="display:inline-block"><a href="recommendPage?category=${requestScope.map.category }&method=highPrice" class="form-control">높은가격순</a></div>
	</div>
	<div id="itemList">
		<c:forEach items="${requestScope.setList }" var="setList">
			<div class="setItemList" style="width:300px;display:inline-block;padding:0px 10px;"><a href="itemsetDetail?codeNum=${setList.item_code_num }" style="text-decoration:none;"><img src="/resources/itemset_img/${setList.itemset_code_mainimg }" style="width:100%;"><span style="font-size:1.2em;color:black;font-weight:bold;">${setList.item_code_setname }</span></a></div>
		</c:forEach>
	</div>
	<div id="paging">
			<c:if test="${requestScope.pu.startPageNum!=1 }">
				<a href="category?method=${requestScope.method }&search=${requestScope.search}&pageNum=${requestScope.pu.startPageNum-1}&code=${requestScope.categoryCode}">이전</a>
			</c:if>
			<c:forEach var="paging" begin="${requestScope.pu.startPageNum }"
				end="${requestScope.pu.endPageNum }">
				<a href="category?method=${requestScope.method }&search=${requestScope.search}&pageNum=${paging }&code=${requestScope.categoryCode}">[${paging }]</a>
			</c:forEach>
			<c:if test="${requestScope.pu.endPageNum!=requestScope.pu.totalPageCount }">
				<a href="category?method=${requestScope.method }&search=${requestScope.search}&pageNum=${requestScope.pu.endPageNum+1}&code=${requestScope.categoryCode}">다음
				</a>
			</c:if>
		</div>
</div>
</body>
</html>