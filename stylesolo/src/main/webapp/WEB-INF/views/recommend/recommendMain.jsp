<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="recMainWrap">
	<ul id="selectCategory"class="list-group" style="margin:10px 30px;">
		<a href="recommendPage?category=md"><li class="list-group-item" style="display:inline-block;width:300px;text-align:center;font-size:1.3em;">MD추천</li></a>
		<a href="recommendPage?category=codi"><li class="list-group-item" style="display:inline-block;width:300px;text-align:center;font-size:1.3em;">코디추천</li></a>
		<a href="recommendPage?category=inte"><li class="list-group-item" style="display:inline-block;width:300px;text-align:center;font-size:1.3em;">인테리어추천</li></a>
	</ul>
	<div id="mdRec">
		<div id="mdNameWrap">
			<div class="page-header" style="font-size:2.0em;font-weight:bold;">MD추천</div>
		</div>
		<c:forEach items="${requestScope.mdRec}" var="mList">
			<div class="mdItems">
				<div class="mdItemsImg"><a href="itemsetDetail?codeNum=${mList.item_code_num}"><img src="/resources/itemset_img/${mList.itemset_code_mainimg}"></a></div>
				<div class="mdItemsMsg"><a href="itemsetDetail?codeNum=${mList.item_code_num}">${mList.mdrec_ptation}</a></div>
			</div>
		</c:forEach>
	</div> 
	<div id="codiRec">
		<div class="ciName">
			<div class="page-header" style="font-size:2.0em;font-weight:bold;">코디추천</div>
		</div>
		<c:forEach var="codiList" items="${requestScope.clist1}">
			<div class="ciItem">
				<div class="ciItemsImg"><a href="itemsetDetail?codeNum=${codiList.item_code_num}"><img src="/resources/itemset_img/${codiList.itemset_code_mainimg}"></a></div>
				<div class="ciItemsMsg"><a href="itemsetDetail?codeNum=${codiList.item_code_num}">${codiList.item_code_setname}</a></div>
			</div>
		</c:forEach>
	</div>
	<div id="inteRec">
		<div class="ciName">
			<div class="page-header" style="font-size:2.0em;font-weight:bold;">인테리어 추천</div>
		</div>
		<div class="ciItems">
			<c:forEach var="inteList" items="${requestScope.clist2}">
				<div class="ciItem">
					<div class="ciItemsImg"><a href="itemsetDetail?codeNum=${inteList.item_code_num}"><img src="/resources/itemset_img/${inteList.itemset_code_mainimg}"></a></div>
					<div class="ciItemsMsg"><a href="itemsetDetail?codeNum=${inteList.item_code_num}">${inteList.item_code_setname}</a></div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>