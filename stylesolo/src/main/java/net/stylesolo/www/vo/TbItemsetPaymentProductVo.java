package net.stylesolo.www.vo;


public class TbItemsetPaymentProductVo{
	private int itemset_payment_product_num;
	private int shop_payment_ordernum;
	private int itemset_payment_product_qty;
	private int itemset_payment_product_price;
	private int itemset_code_num;

	public TbItemsetPaymentProductVo() {
	}

	public TbItemsetPaymentProductVo(int itemset_payment_product_num, int shop_payment_ordernum,
			int itemset_payment_product_qty, int itemset_payment_product_price, int itemset_code_num) {
		super();
		this.itemset_payment_product_num = itemset_payment_product_num;
		this.shop_payment_ordernum = shop_payment_ordernum;
		this.itemset_payment_product_qty = itemset_payment_product_qty;
		this.itemset_payment_product_price = itemset_payment_product_price;
		this.itemset_code_num = itemset_code_num;
	}

	public int getItemset_payment_product_num() {
		return itemset_payment_product_num;
	}

	public void setItemset_payment_product_num(int itemset_payment_product_num) {
		this.itemset_payment_product_num = itemset_payment_product_num;
	}

	public int getShop_payment_ordernum() {
		return shop_payment_ordernum;
	}

	public void setShop_payment_ordernum(int shop_payment_ordernum) {
		this.shop_payment_ordernum = shop_payment_ordernum;
	}

	public int getItemset_payment_product_qty() {
		return itemset_payment_product_qty;
	}

	public void setItemset_payment_product_qty(int itemset_payment_product_qty) {
		this.itemset_payment_product_qty = itemset_payment_product_qty;
	}

	public int getItemset_payment_product_price() {
		return itemset_payment_product_price;
	}

	public void setItemset_payment_product_price(int itemset_payment_product_price) {
		this.itemset_payment_product_price = itemset_payment_product_price;
	}

	public int getItemset_code_num() {
		return itemset_code_num;
	}

	public void setItemset_code_num(int itemset_code_num) {
		this.itemset_code_num = itemset_code_num;
	}
	
}
