package net.stylesolo.www.vo;

public class ShopReviewFileVo {
	private int shop_review_file_num;
	private String shop_review_file_filename;
	private int shop_review_num;
	
	public ShopReviewFileVo(){}

	public ShopReviewFileVo(int shop_review_file_num, String shop_review_file_filename, int shop_review_num) {
		super();
		this.shop_review_file_num = shop_review_file_num;
		this.shop_review_file_filename = shop_review_file_filename;
		this.shop_review_num = shop_review_num;
	}

	public int getShop_review_file_num() {
		return shop_review_file_num;
	}

	public void setShop_review_file_num(int shop_review_file_num) {
		this.shop_review_file_num = shop_review_file_num;
	}

	public String getShop_review_file_filename() {
		return shop_review_file_filename;
	}

	public void setShop_review_file_filename(String shop_review_file_filename) {
		this.shop_review_file_filename = shop_review_file_filename;
	}

	public int getShop_review_num() {
		return shop_review_num;
	}

	public void setShop_review_num(int shop_review_num) {
		this.shop_review_num = shop_review_num;
	}
	
	
}
