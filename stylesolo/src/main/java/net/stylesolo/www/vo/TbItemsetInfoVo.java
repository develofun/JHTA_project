package net.stylesolo.www.vo;

public class TbItemsetInfoVo{
	/** 세트 상품 번호. */
	private int itemset_info_num;

	/** 추천 코드 테이블. */
	private int itemset_code_num;

	/** 제품코드. */
	private int shop_fashion_item_code;

	/**
	 * 생성자.
	 */
	public TbItemsetInfoVo() {
	}

	public TbItemsetInfoVo(int itemset_info_num, int itemset_code_num, int shop_fashion_item_code) {
		super();
		this.itemset_info_num = itemset_info_num;
		this.itemset_code_num = itemset_code_num;
		this.shop_fashion_item_code = shop_fashion_item_code;
	}

	public int getItemset_info_num() {
		return itemset_info_num;
	}

	public void setItemset_info_num(int itemset_info_num) {
		this.itemset_info_num = itemset_info_num;
	}

	public int getItemset_code_num() {
		return itemset_code_num;
	}

	public void setItemset_code_num(int itemset_code_num) {
		this.itemset_code_num = itemset_code_num;
	}

	public int getShop_fashion_item_code() {
		return shop_fashion_item_code;
	}

	public void setShop_fashion_item_code(int shop_fashion_item_code) {
		this.shop_fashion_item_code = shop_fashion_item_code;
	}
	
	
}
