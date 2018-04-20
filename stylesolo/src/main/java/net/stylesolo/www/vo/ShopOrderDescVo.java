package net.stylesolo.www.vo;

import java.sql.Date;

public class ShopOrderDescVo {
	private int shop_payment_item_num;
   private Date SHOP_PAYMENT_W_DATE; // 주문일
   private String SHOP_DELIVERY_HISTORY; //배송상태
   private String SHOP_DELIVERY_TRACKING; //운송장번호
   private String SHOP_PAYMENT_DEL_NAME; //받는사람
   private String SHOP_PAYMENT_DEL_PHONE; //전화번호
   private String SHOP_PAYMENT_DEL_ADDR; //주소
   private int SHOP_PAYMENT_COUPON; //사용 쿠폰금액
   private int SHOP_PAYMENT_POINT; // 사용 포인트금액
   private int SHOP_PAYMENT_TOTAL_PRICE;
   private String PAYMENT_METHOD;
   private int shop_item_code;
   private int ITEM_OPTIONS_NUM;
   private int SHOP_PAYMENT_ITEM_ORDER_QTY;
   private int SHOP_PAYMENT_ITEM_PRICE;
   private String SHOP_ITEM_NAME;
   private int SHOP_ITEM_SALEPRICE;
   private String SHOP_ITEM_MAINIMG_IMGNAME;
   private String item_options_name;
   
   
   public ShopOrderDescVo(){}
   
   

   public ShopOrderDescVo(int shop_payment_item_num, Date sHOP_PAYMENT_W_DATE, String sHOP_DELIVERY_HISTORY,
		String sHOP_DELIVERY_TRACKING, String sHOP_PAYMENT_DEL_NAME, String sHOP_PAYMENT_DEL_PHONE,
		String sHOP_PAYMENT_DEL_ADDR, int sHOP_PAYMENT_COUPON, int sHOP_PAYMENT_POINT, int sHOP_PAYMENT_TOTAL_PRICE,
		String pAYMENT_METHOD, int shop_item_code, int iTEM_OPTIONS_NUM, int sHOP_PAYMENT_ITEM_ORDER_QTY,
		int sHOP_PAYMENT_ITEM_PRICE, String sHOP_ITEM_NAME, int sHOP_ITEM_SALEPRICE, String sHOP_ITEM_MAINIMG_IMGNAME,
		String item_options_name) {
	super();
	this.shop_payment_item_num = shop_payment_item_num;
	SHOP_PAYMENT_W_DATE = sHOP_PAYMENT_W_DATE;
	SHOP_DELIVERY_HISTORY = sHOP_DELIVERY_HISTORY;
	SHOP_DELIVERY_TRACKING = sHOP_DELIVERY_TRACKING;
	SHOP_PAYMENT_DEL_NAME = sHOP_PAYMENT_DEL_NAME;
	SHOP_PAYMENT_DEL_PHONE = sHOP_PAYMENT_DEL_PHONE;
	SHOP_PAYMENT_DEL_ADDR = sHOP_PAYMENT_DEL_ADDR;
	SHOP_PAYMENT_COUPON = sHOP_PAYMENT_COUPON;
	SHOP_PAYMENT_POINT = sHOP_PAYMENT_POINT;
	SHOP_PAYMENT_TOTAL_PRICE = sHOP_PAYMENT_TOTAL_PRICE;
	PAYMENT_METHOD = pAYMENT_METHOD;
	this.shop_item_code = shop_item_code;
	ITEM_OPTIONS_NUM = iTEM_OPTIONS_NUM;
	SHOP_PAYMENT_ITEM_ORDER_QTY = sHOP_PAYMENT_ITEM_ORDER_QTY;
	SHOP_PAYMENT_ITEM_PRICE = sHOP_PAYMENT_ITEM_PRICE;
	SHOP_ITEM_NAME = sHOP_ITEM_NAME;
	SHOP_ITEM_SALEPRICE = sHOP_ITEM_SALEPRICE;
	SHOP_ITEM_MAINIMG_IMGNAME = sHOP_ITEM_MAINIMG_IMGNAME;
	this.item_options_name = item_options_name;
}



public int getSHOP_ITEM_SALEPRICE() {
      return SHOP_ITEM_SALEPRICE;
   }




   public void setSHOP_ITEM_SALEPRICE(int sHOP_ITEM_SALEPRICE) {
      SHOP_ITEM_SALEPRICE = sHOP_ITEM_SALEPRICE;
   }




   public Date getSHOP_PAYMENT_W_DATE() {
      return SHOP_PAYMENT_W_DATE;
   }
   public void setSHOP_PAYMENT_W_DATE(Date sHOP_PAYMENT_W_DATE) {
      SHOP_PAYMENT_W_DATE = sHOP_PAYMENT_W_DATE;
   }
   public String getSHOP_DELIVERY_HISTORY() {
      return SHOP_DELIVERY_HISTORY;
   }
   public void setSHOP_DELIVERY_HISTORY(String sHOP_DELIVERY_HISTORY) {
      SHOP_DELIVERY_HISTORY = sHOP_DELIVERY_HISTORY;
   }
   public String getSHOP_DELIVERY_TRACKING() {
      return SHOP_DELIVERY_TRACKING;
   }
   public void setSHOP_DELIVERY_TRACKING(String sHOP_DELIVERY_TRACKING) {
      SHOP_DELIVERY_TRACKING = sHOP_DELIVERY_TRACKING;
   }
   public String getSHOP_PAYMENT_DEL_NAME() {
      return SHOP_PAYMENT_DEL_NAME;
   }
   public void setSHOP_PAYMENT_DEL_NAME(String sHOP_PAYMENT_DEL_NAME) {
      SHOP_PAYMENT_DEL_NAME = sHOP_PAYMENT_DEL_NAME;
   }
   public String getSHOP_PAYMENT_DEL_PHONE() {
      return SHOP_PAYMENT_DEL_PHONE;
   }
   public void setSHOP_PAYMENT_DEL_PHONE(String sHOP_PAYMENT_DEL_PHONE) {
      SHOP_PAYMENT_DEL_PHONE = sHOP_PAYMENT_DEL_PHONE;
   }
   public String getSHOP_PAYMENT_DEL_ADDR() {
      return SHOP_PAYMENT_DEL_ADDR;
   }
   public void setSHOP_PAYMENT_DEL_ADDR(String sHOP_PAYMENT_DEL_ADDR) {
      SHOP_PAYMENT_DEL_ADDR = sHOP_PAYMENT_DEL_ADDR;
   }
   public int getSHOP_PAYMENT_COUPON() {
      return SHOP_PAYMENT_COUPON;
   }
   public void setSHOP_PAYMENT_COUPON(int sHOP_PAYMENT_COUPON) {
      SHOP_PAYMENT_COUPON = sHOP_PAYMENT_COUPON;
   }
   public int getSHOP_PAYMENT_POINT() {
      return SHOP_PAYMENT_POINT;
   }
   public void setSHOP_PAYMENT_POINT(int sHOP_PAYMENT_POINT) {
      SHOP_PAYMENT_POINT = sHOP_PAYMENT_POINT;
   }
   public int getSHOP_PAYMENT_TOTAL_PRICE() {
      return SHOP_PAYMENT_TOTAL_PRICE;
   }
   public void setSHOP_PAYMENT_TOTAL_PRICE(int sHOP_PAYMENT_TOTAL_PRICE) {
      SHOP_PAYMENT_TOTAL_PRICE = sHOP_PAYMENT_TOTAL_PRICE;
   }
   public String getPAYMENT_METHOD() {
      return PAYMENT_METHOD;
   }
   public void setPAYMENT_METHOD(String pAYMENT_METHOD) {
      PAYMENT_METHOD = pAYMENT_METHOD;
   }
   public int getShop_item_code() {
      return shop_item_code;
   }
   public void setShop_item_code(int shop_item_code) {
	   shop_item_code = shop_item_code;
   }
   public int getITEM_OPTIONS_NUM() {
      return ITEM_OPTIONS_NUM;
   }
   public void setITEM_OPTIONS_NUM(int iTEM_OPTIONS_NUM) {
      ITEM_OPTIONS_NUM = iTEM_OPTIONS_NUM;
   }
   public int getSHOP_PAYMENT_ITEM_ORDER_QTY() {
      return SHOP_PAYMENT_ITEM_ORDER_QTY;
   }
   public void setSHOP_PAYMENT_ITEM_ORDER_QTY(int sHOP_PAYMENT_ITEM_ORDER_QTY) {
      SHOP_PAYMENT_ITEM_ORDER_QTY = sHOP_PAYMENT_ITEM_ORDER_QTY;
   }
   
   public int getSHOP_PAYMENT_ITEM_PRICE() {
      return SHOP_PAYMENT_ITEM_PRICE;
   }



   public void setSHOP_PAYMENT_ITEM_PRICE(int sHOP_PAYMENT_ITEM_PRICE) {
      SHOP_PAYMENT_ITEM_PRICE = sHOP_PAYMENT_ITEM_PRICE;
   }



   public String getSHOP_ITEM_NAME() {
      return SHOP_ITEM_NAME;
   }
   public void setSHOP_ITEM_NAME(String sHOP_ITEM_NAME) {
      SHOP_ITEM_NAME = sHOP_ITEM_NAME;
   }
   public String getSHOP_ITEM_MAINIMG_IMGNAME() {
      return SHOP_ITEM_MAINIMG_IMGNAME;
   }
   public void setSHOP_ITEM_MAINIMG_IMGNAME(String sHOP_ITEM_MAINIMG_IMGNAME) {
      SHOP_ITEM_MAINIMG_IMGNAME = sHOP_ITEM_MAINIMG_IMGNAME;
   }
   public String getItem_options_name() {
      return item_options_name;
   }
   public void setItem_options_name(String item_options_name) {
      this.item_options_name = item_options_name;
   }



public int getShop_payment_item_num() {
	return shop_payment_item_num;
}



public void setShop_payment_item_num(int shop_payment_item_num) {
	this.shop_payment_item_num = shop_payment_item_num;
}
   
   
}