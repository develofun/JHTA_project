/**
 * 
 * login_check : 濡쒓렇�씤 �뿬遺� �삉�뒗 沅뚰븳�뿉 �뵲瑜� 踰꾪듉 display 泥섎━ function
 * 
 * back_to_read : 痍⑥냼 踰꾪듉 �겢由� �떆 �븳 踰� �뜑 �솗�씤�븯�뒗 李� �뙘�뾽
 * 
 */

function login_check(){
	var btn_write=document.getElementById("btn_write");
	if("${sessionScope.member_nickname }"==""){
		btn_write.style.display="none";
	}
}

function back_to_read(){
	if(confirm("�벑濡앺븯吏� �븡怨� �럹�씠吏�瑜� �굹媛��떆寃좎뒿�땲源�?")==true){
		location.href="/market.do?cmd=market_read";
	}
}
window.onload=login_check();