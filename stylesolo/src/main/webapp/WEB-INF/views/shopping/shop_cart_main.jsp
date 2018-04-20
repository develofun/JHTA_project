<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
   *{margin:auto}
   #shop_cart_main{width:1000px;height:1500px;}
   #shop_cart_top1{width:650px;height:120px;float:left;}
   #shop_cart_top1 img{width:100%;height:100%}
   #shop_cart_top2{width:345px;height:120px;float:right;}
   #shop_cart_top2 ul {list-style:none;}
   #shop_cart_sub{width:1000px;height:700px;margin-top: 10px;text-align: center;overflow: scroll}
   .tableWrap{width:990px;height:700px;display: table;}
   #tablerow{width:100%;height:20px;display: table-row;border: 1px dotted gray;border: 1px dotted gray;}   
   #tablerow div{display: table-cell;padding: 0px;height: 50pxlborder: 1px dotted gray;border-bottom: 1px dashed gray;border-right: 1px solid #eee}   
   #tablerow div img{width:130px;height:130px;}
   .item_list1{width:100%;height:20px;display: table-row;border: 1px dotted gray;border: 1px dotted gray;}
   .item_list1 div{display: table-cell;padding: 0px;height: 50pxlborder: 1px dotted gray;border-bottom: 1px dashed gray;border-right: 1px solid #eee;vertical-align: middle;}
   .titem_info img{width:130px;height:130px;}
   #tcheck_all{width:20px;}
   .titem_info{width:150px;}
   .titem_name{widht:300px;}
   .tpoint{width:80px;}
   .tprice{width:80px;}
   .tqty{width:50px;}
   .ttotal{width:100px;}
   #set_shop_cart_sub{width:1000px;height:670px;margin-top: 10px;text-align: center;overflow: scroll}
   #setTablerow{width:100%;height:20px;display: table-row;border: 1px dotted gray;border: 1px dotted gray;}
  #setTablerow div{display: table-cell;padding: 0px;height: 50pxlborder: 1px dotted gray;border-bottom: 1px dashed gray;border-right: 1px solid #eee}
   #set_tcheck_all{width:20px;}
</style>
<script src="/resources/js/jssor.slider-22.2.16.min.js"
   type="text/javascript"></script>
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
      var total = 0;
      var chkAll=true;
      $("#check_all").change(function(){
         chkAll=$(this).prop("checked");
         $(".cartItemCheck").each(function(){
            $(this).find("input:checkbox").prop("checked",chkAll);
         });
      });
      $("#normalPayment").click(function(){
         $("#normalItem").attr("action","/cartPayment").submit();
      });
      $("#normalDelete").click(function(){
         $("#normalItem").attr("action","/cartDelete").submit();
      });
      var setChkAll=true;
      $("#set_check_all").change(function(){
    	  setChkAll=$(this).prop("checked");
         $(".cartSetCheck").each(function(){
            $(this).find("input:checkbox").prop("checked",setChkAll);
         });
      });
      $("#setPayment").click(function(){
         $("#setItem").attr("action","/setCartPayment").submit();
      });
      $("#setDelete").click(function(){
         $("#setItem").attr("action","/setCartDelete").submit();
      });
      
      
   /*function sumPrice() {
      var tf = $("input:checkbox[name:chkList]").is(":checked");
      if (tf == true) {
         var selectTotal = 0;
         $("input:checkbox[name:chkList]:checked").each(function() {
            var selectPrice = $(this).parent().children().eq(7).text();
            selectTotal += selectPrice;
         });
         $("#totalprice").text(total + "원");
      } else {
         $("#totalprice").text("0원");
      }
   }

   function ddd(num) {
      $.ajax({
         url : 'delCart',
         data : 'shop_cart_num=' + num,
         dataType : 'json',
         success : function(data) {
            if (data.result == 'success') {
               $(".itemList").find("#num").empty();
            } else {
               alert("삭제에 실패하였습니다");
            }
         }
      });
   }*/
      
   });
   //장바구니 목록 불러오기   
   
</script>


<div id="shop_cart_main">
   <div id="shop_cart_top1">
      <img src="/resources/img/cart_img1.png">
   </div>
   <div id="shop_cart_top2">
      <ul>
         <li>회원등급 : 실버<br>
         <li>보유 쿠폰 0 개
      </ul>
   </div>
   <div id="shop_cart_sub">
      <form method="post" id="normalItem">
      <div class="tableWrap">
         <div id="tablerow">
            <div id="tcheck_all">
               <input type="checkbox" id="check_all">
            </div>
            <div class="titem_info">상품(상품코드)</div>
            <div class="titem_name">상품명(옵션)</div>
            <div class="tpoint">적립금</div>
            <div class="tprice">판매가</div>
            <div class="tqty">수량</div>
            <div class="ttotal">주문금액</div>
         </div>
            <!-- 일반상품리스트 -->
            <c:choose>
               <c:when test="${requestScope.list!=null }">
                  
                  <c:forEach items="${requestScope.list }" var="list">
                     <div class="item_list1">
                        <div class="cartItemCheck">
                           <input type="checkbox" value="${list.shop_cart_num }" name="checkItem">
                        </div>
                        <div class="titem_info"><a href="shoplayout?item_code=${list.shop_item_code }"><img src="/resources/item_img/${list.shop_item_mainimg_imgname }"></a></div>
                        <div class="titem_name"><p>${list.shop_item_name }</p><p><c:if test="${not empty list.item_options_name }">${list.item_options_name }</c:if></p></div>
                        <div class="tpoint">${Math.floor(list.shop_cart_price*list.shop_cart_order_qty*0.002) }P</div>
                        <div class="tprice">${list.shop_cart_price }</div>
                        <div class="tqty">${list.shop_cart_order_qty }</div>
                        <div class="ttotal">${list.shop_cart_price*list.shop_cart_order_qty}</div>
                     </div>
                  </c:forEach>
                  
               </c:when>
                  <c:otherwise>
                     <div class="item_list1">
                        장바구니에 상품이 없습니다.
                     </div>
               </c:otherwise>
            </c:choose>
         
         </div>
      <input type="button" value="선택구매" id="normalPayment">
                  <input type="button" value="선택삭제" id="normalDelete">
               </form>
   </div>
   <div id="set_shop_cart_sub">
      <form method="post" id="setItem">
      <div class="tableWrap">
         <div id="setTablerow">
            <div id="set_tcheck_all">
               <input type="checkbox" id="set_check_all">
            </div>
            <div class="titem_info">상품(상품코드)</div>
            <div class="titem_name">상품명(옵션)</div>
            <div class="tpoint">적립금</div>
            <div class="tprice">판매가</div>
            <div class="tqty">수량</div>
            <div class="ttotal">주문금액</div>
         </div>
            <!-- 세트상품리스트 -->
            <c:choose>
               <c:when test="${requestScope.list!=null }">
                  
                  <c:forEach items="${requestScope.listSet }" var="listSet">
                     <div class="item_list1">
                        <div class="cartSetCheck">
                           <input type="checkbox" value="${listSet.itemset_cart_num }" name="checkset">
                        </div>
                        <div class="titem_info"><img src="/resources/itemset_img/${listSet.itemset_code_mainimg }"></div>
                        <div class="titem_name">${listSet.item_code_setname }</div>
                        <div class="tpoint">${Math.floor(listSet.itemset_cart_price*listSet.itemset_cart_order_qty*0.002) }P</div>
                        <div class="tprice">${listSet.itemset_cart_price }</div>
                        <div class="tqty">${listSet.itemset_cart_order_qty }</div>
                        <div class="ttotal">${listSet.itemset_cart_price*listSet.itemset_cart_order_qty}</div>
                     </div>
                  </c:forEach>
                  
               </c:when>
                  <c:otherwise>
                     <div class="item_list1">
                        장바구니에 상품이 없습니다.
                     </div>
               </c:otherwise>
            </c:choose>
         
         </div>
      <input type="button" value="선택구매" id="setPayment">
                  <input type="button" value="선택삭제" id="setDelete">
               </form>
   </div>
</div>