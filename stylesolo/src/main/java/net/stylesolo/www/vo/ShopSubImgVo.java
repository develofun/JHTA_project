package net.stylesolo.www.vo;

public class ShopSubImgVo {
	private int shop_item_subimg_num;
	private String shop_item_subimg_imgname;
	private int shop_item_code;
	private String shop_item_mainimg_imgname;
	
	public ShopSubImgVo(){}
	public ShopSubImgVo(int shop_item_subimg_num, String shop_item_subimg_imgname, int shop_item_code,String shop_item_mainimg_imgname) {
		super();
		this.shop_item_subimg_num = shop_item_subimg_num;
		this.shop_item_subimg_imgname = shop_item_subimg_imgname;
		this.shop_item_code = shop_item_code;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
	}
	public int getShop_item_subimg_num() {
		return shop_item_subimg_num;
	}
	public void setShop_item_subimg_num(int shop_item_subimg_num) {
		this.shop_item_subimg_num = shop_item_subimg_num;
	}
	public String getShop_item_subimg_imgname() {
		return shop_item_subimg_imgname;
	}
	public void setShop_item_subimg_imgname(String shop_item_subimg_imgname) {
		this.shop_item_subimg_imgname = shop_item_subimg_imgname;
	}
	public int getShop_item_code() {
		return shop_item_code;
	}
	public void setShop_item_code(int shop_item_code) {
		this.shop_item_code = shop_item_code;
	}
	@Override
	public String toString() {
		return shop_item_subimg_imgname;
	}
	public String getShop_item_mainimg_imgname() {
		return shop_item_mainimg_imgname;
	}
	public void setShop_item_mainimg_imgname(String shop_item_mainimage_imgname) {
		this.shop_item_mainimg_imgname = shop_item_mainimage_imgname;
	}
	
	
	
}
