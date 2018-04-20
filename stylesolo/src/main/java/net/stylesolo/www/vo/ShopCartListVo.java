package net.stylesolo.www.vo;
 //장바구니 리스트에 보여질 데이터
public class ShopCartListVo {
	private int shop_item_code; 
	private String shop_item_name;	
	private int item_options_num; 
	private String item_options_name; 
	private String shop_item_mainimg_imgname;
	private double shop_item_pointrate;
	private int shop_cart_order_qty;
	private int shop_item_saleprice;
	
	public ShopCartListVo(){}
	

	public ShopCartListVo(int shop_item_code, int item_options_num) {
		super();
		this.shop_item_code = shop_item_code;
		this.item_options_num = item_options_num;
	}



	public ShopCartListVo(int shop_item_code, String shop_item_name, String shop_item_mainimg_imgname, double shop_item_pointrate,
			int shop_item_saleprice) {
		super();
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
		this.shop_item_pointrate = shop_item_pointrate;
		this.shop_item_saleprice = shop_item_saleprice;
	}


	public ShopCartListVo(int shop_item_code, String shop_item_name, String shop_item_mainimg_imgname, double shop_item_pointrate,
			int shop_cart_order_qty, int shop_item_saleprice) {
		super();
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
		this.shop_item_pointrate = shop_item_pointrate;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_item_saleprice = shop_item_saleprice;
	}


	public ShopCartListVo(int shop_item_code, String shop_item_name, int item_options_num, String shop_item_mainimg_imgname,
			double shop_item_pointrate, int shop_cart_order_qty, int shop_item_saleprice) {
		super();
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.item_options_num = item_options_num;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;   
		this.shop_item_pointrate = shop_item_pointrate;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_item_saleprice = shop_item_saleprice;
	}



	public ShopCartListVo(int shop_item_code, String shop_item_name, int item_options_num, String item_options_name,
			String shop_item_mainimg_imgname, double shop_item_pointrate, int shop_cart_order_qty, int shop_item_saleprice) {
		super();
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.item_options_num = item_options_num;
		this.item_options_name = item_options_name;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
		this.shop_item_pointrate = shop_item_pointrate;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_item_saleprice = shop_item_saleprice;
	}


	public ShopCartListVo(int shop_item_code, String shop_item_name, String item_options_name, String shop_item_mainimg_imgname,
			double shop_item_pointrate, int shop_cart_order_qty, int shop_item_saleprice) {
		super();
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.item_options_name = item_options_name;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
		this.shop_item_pointrate = shop_item_pointrate;
		this.shop_cart_order_qty = shop_cart_order_qty;
		this.shop_item_saleprice = shop_item_saleprice;
	}



	public String getItem_options_name() {
		return item_options_name;
	}



	public void setItem_options_name(String item_options_name) {
		this.item_options_name = item_options_name;
	}



	public int getItem_options_num() {
		return item_options_num;
	}


	public void setItem_options_num(int item_options_num) {
		this.item_options_num = item_options_num;
	}


	public int getShop_item_code() {
		return shop_item_code;
	}
	public void setShop_item_code(int shop_item_code) {
		this.shop_item_code = shop_item_code;
	}
	public String getShop_item_name() {
		return shop_item_name;
	}
	public void setShop_item_name(String shop_item_name) {
		this.shop_item_name = shop_item_name;
	}
	public String getshop_item_mainimg_imgname() {
		return shop_item_mainimg_imgname;
	}
	public void setshop_item_mainimg_imgname(String shop_item_mainimg_imgname) {
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
	}
	public double getShop_item_pointrate() {
		return shop_item_pointrate;
	}
	public void setShop_item_pointrate(double shop_item_pointrate) {
		this.shop_item_pointrate = shop_item_pointrate;
	}
	public int getShop_cart_order_qty() {
		return shop_cart_order_qty;
	}
	public void setShop_cart_order_qty(int shop_cart_order_qty) {
		this.shop_cart_order_qty = shop_cart_order_qty;
	}
	public int getShop_item_saleprice() {
		return shop_item_saleprice;
	}
	public void setShop_item_saleprice(int shop_item_saleprice) {
		this.shop_item_saleprice = shop_item_saleprice;
	}


	@Override
	public String toString() {
		return "ShopCartListVo [shop_item_code=" + shop_item_code + ", shop_item_name=" + shop_item_name
				+ ", item_options_num=" + item_options_num + ", item_options_name=" + item_options_name
				+ ", shop_item_mainimg_imgname=" + shop_item_mainimg_imgname + ", shop_item_pointrate=" + shop_item_pointrate
				+ ", shop_cart_order_qty=" + shop_cart_order_qty + ", shop_item_saleprice=" + shop_item_saleprice + "]";
	}
	
	
}