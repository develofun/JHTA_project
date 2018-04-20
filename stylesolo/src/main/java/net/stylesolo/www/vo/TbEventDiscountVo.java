package net.stylesolo.www.vo;

public class TbEventDiscountVo {
	private int shop_item_code;
	private int shop_item_price;
	private int shop_item_discountrate;
	private int shop_item_saleprice;
	public TbEventDiscountVo() {}
	public TbEventDiscountVo(int shop_item_code, int shop_item_price, int shop_item_discountrate,
			int shop_item_saleprice) {
		super();
		this.shop_item_code = shop_item_code;
		this.shop_item_price = shop_item_price;
		this.shop_item_discountrate = shop_item_discountrate;
		this.shop_item_saleprice = shop_item_saleprice;
	}
	public int getShop_item_code() {
		return shop_item_code;
	}
	public void setShop_item_code(int shop_item_code) {
		this.shop_item_code = shop_item_code;
	}
	public int getShop_item_price() {
		return shop_item_price;
	}
	public void setShop_item_price(int shop_item_price) {
		this.shop_item_price = shop_item_price;
	}
	public int getShop_item_discountrate() {
		return shop_item_discountrate;
	}
	public void setShop_item_discountrate(int shop_item_discountrate) {
		this.shop_item_discountrate = shop_item_discountrate;
	}
	public int getShop_item_saleprice() {
		return shop_item_saleprice;
	}
	public void setShop_item_saleprice(int shop_item_saleprice) {
		this.shop_item_saleprice = shop_item_saleprice;
	}
}
