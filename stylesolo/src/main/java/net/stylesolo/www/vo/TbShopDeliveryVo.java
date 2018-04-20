package net.stylesolo.www.vo;

public class TbShopDeliveryVo {
	private String shop_delivery_tracking;
	private String shop_order_history;
	private String shop_delivery_history;
	private String shop_payment_del_name;
	private int shop_payment_del_zipcode;
	private String shop_payment_del_addr;
	private String shop_payment_del_phone;
	private String shop_payment_del_message;
	private int shop_payment_del_price;
	private int shop_payment_ordernum;
	
	public TbShopDeliveryVo(){}

	public TbShopDeliveryVo(String shop_delivery_tracking, String shop_order_history, String shop_delivery_history,
			String shop_payment_del_name, int shop_payment_del_zipcode, String shop_payment_del_addr,
			String shop_payment_del_phone, String shop_payment_del_message, int shop_payment_del_price,
			int shop_payment_ordernum) {
		super();
		this.shop_delivery_tracking = shop_delivery_tracking;
		this.shop_order_history = shop_order_history;
		this.shop_delivery_history = shop_delivery_history;
		this.shop_payment_del_name = shop_payment_del_name;
		this.shop_payment_del_zipcode = shop_payment_del_zipcode;
		this.shop_payment_del_addr = shop_payment_del_addr;
		this.shop_payment_del_phone = shop_payment_del_phone;
		this.shop_payment_del_message = shop_payment_del_message;
		this.shop_payment_del_price = shop_payment_del_price;
		this.shop_payment_ordernum = shop_payment_ordernum;
	}

	public String getShop_delivery_tracking() {
		return shop_delivery_tracking;
	}

	public void setShop_delivery_tracking(String shop_delivery_tracking) {
		this.shop_delivery_tracking = shop_delivery_tracking;
	}

	public String getShop_order_history() {
		return shop_order_history;
	}

	public void setShop_order_history(String shop_order_history) {
		this.shop_order_history = shop_order_history;
	}

	public String getShop_delivery_history() {
		return shop_delivery_history;
	}

	public void setShop_delivery_history(String shop_delivery_history) {
		this.shop_delivery_history = shop_delivery_history;
	}

	public String getShop_payment_del_name() {
		return shop_payment_del_name;
	}

	public void setShop_payment_del_name(String shop_payment_del_name) {
		this.shop_payment_del_name = shop_payment_del_name;
	}

	public int getShop_payment_del_zipcode() {
		return shop_payment_del_zipcode;
	}

	public void setShop_payment_del_zipcode(int shop_payment_del_zipcode) {
		this.shop_payment_del_zipcode = shop_payment_del_zipcode;
	}

	public String getShop_payment_del_addr() {
		return shop_payment_del_addr;
	}

	public void setShop_payment_del_addr(String shop_payment_del_addr) {
		this.shop_payment_del_addr = shop_payment_del_addr;
	}

	public String getShop_payment_del_phone() {
		return shop_payment_del_phone;
	}

	public void setShop_payment_del_phone(String shop_payment_del_phone) {
		this.shop_payment_del_phone = shop_payment_del_phone;
	}

	public String getShop_payment_del_message() {
		return shop_payment_del_message;
	}

	public void setShop_payment_del_message(String shop_payment_del_message) {
		this.shop_payment_del_message = shop_payment_del_message;
	}

	public int getShop_payment_del_price() {
		return shop_payment_del_price;
	}

	public void setShop_payment_del_price(int shop_payment_del_price) {
		this.shop_payment_del_price = shop_payment_del_price;
	}

	public int getShop_payment_ordernum() {
		return shop_payment_ordernum;
	}

	public void setShop_payment_ordernum(int shop_payment_ordernum) {
		this.shop_payment_ordernum = shop_payment_ordernum;
	}
	
}
