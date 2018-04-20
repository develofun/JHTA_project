<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	$.ready = function() {
		$(".catePageMove").each(
				function(n) {
					var cateImg = $(this).find("img").attr("src");
					$(this)
							.mouseover(
									function() {
										$(this).find("img").attr(
												"src",
												"/resources/itemsetImg/s" + n
														+ ".png");
									});
					$(this).mouseout(function() {
						$(this).find("img").attr("src", cateImg);
					});
				});
		$(".catePageMove").click(function() {
			var cate = $(this).find("span").text();
			location.href = "recommendPage?category=" + cate;
		});
		$("#basket").click(function(){
			location.href="/setItemBasket?codeNum="+$("#setItemCode").val()+"&price="+$("#setItemPrice").val()+"&qty="+$("#setQty").val();
		});
		$("#jjim").click(function(){
			location.href="/setItemInterest?codeNum="+$("#setItemCode").val();
		});
		$("#setQty").change(function(){
			$("#setSumPrice").val($("#setItemPrice").val()*$("#setQty").val());
		});
	}
</script>
</head>
<body>
	<div id="detailWrap">
		<input type="hidden" value="${requestScope.category }" id="cate"><input
			type="hidden" value="${requestScope.method }" id="SortMethod">
		<ul id="selectCategory"class="list-group" style="margin:10px 30px;">
			<a href="recommendPage?category=md"><li class="list-group-item" style="display:inline-block;width:300px;text-align:center;font-size:1.3em;">MD추천</li></a>
			<a href="recommendPage?category=codi"><li class="list-group-item" style="display:inline-block;width:300px;text-align:center;font-size:1.3em;">코디추천</li></a>
			<a href="recommendPage?category=inte"><li class="list-group-item" style="display:inline-block;width:300px;text-align:center;font-size:1.3em;">인테리어추천</li></a>
		</ul>
		<div id="image_selectPart">
			<div id="mainImage">
				<img src="/resources/itemset_img/${requestScope.cvo.itemset_code_mainimg}">
			</div>
			<div id="selectPart">
			<form action="/orderPageMove" method="post">
				<div id="itemsetSelect">
					<div id="itemsetInfo">
						<div>상품명 : ${requestScope.cvo.item_code_setname }</div>
						<input type="hidden" value="${requestScope.cvo.itemset_code_price }" id="setItemPrice">
						<div>구매가격 : <input style="width:85px;text-align:center" type="text" readonly="readonly" id="setSumPrice" name="setSumPrice" value="<f:formatNumber pattern='#,###' value='${requestScope.cvo.itemset_code_price }'/>">원</div>
						<div>구매수량 : <input id="setQty" name="setQty" type="number" value="1" max="${requestScope.cvo.itemset_code_quantity }" min="1" style="text-align:center"></div>
						<input type="hidden" value="${requestScope.cvo.item_code_num }" id="setItemCode" name="codeNum">
					</div>
					<div id="buySelect">
						<input type="submit" class="btn btn-primary" value="즉시구매" style="display:inline-block;width:100px;margin:5px;"><input type="button" value="장바구니담기" id="basket" class="btn btn-primary" style="display:inline-block;width:150px;margin:5px;"><input type="button" class="btn btn-primary" value="관심상품추가" id="jjim" style="display:inline-block;width:150px;margin:5px;">
					</div>
				</div>
			</form>
			<div id="itemSelect" style="margin-top:100px">
					<c:forEach items="${requestScope.list}" var="items">
						<a href="/shoplayout?item_code=${items.shop_item_code }">
							<span class="CompositionGoods"><img src="/resources/item_img/${items.shop_item_mainimg_imgname }"></span>
						</a>
					</c:forEach>
				</div>
			</div>
			<div style="float:left">
			<c:choose>
			<c:when test="${requestScope.msg==null }">
				
			</c:when>
			<c:when test="${requestScope.msg=='basketSuccess' }">
				장바구니에 담겼습니다.
			</c:when>
			<c:when test="${requestScope.msg=='jjimSuccess' }">
				관심상품에 추가되었습니다.
			</c:when>
			<c:when test="${requestScope.msg=='already' }">
				이미 추가된 상품입니다.
			</c:when>
			<c:otherwise>
				다시시도해주세요
			</c:otherwise>
			</c:choose>
			</div>
		</div>
		<div id="imagePart" align="center">
			<c:if test="${requestScope.imgList!=null}">
				<c:forEach var="subImg" items="${requestScope.imgList}">
					<img class="itemsetSubImage" src="${subImg.itemset_img_imgaddr }">
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>