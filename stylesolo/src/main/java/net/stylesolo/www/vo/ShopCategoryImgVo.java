package net.stylesolo.www.vo;

public class ShopCategoryImgVo {
	private int category_num;
	private String category_name;
	private String category_imgname;
	public ShopCategoryImgVo(){}
	public ShopCategoryImgVo(int category_num, String category_name, String category_imgname) {
		super();
		this.category_num = category_num;
		this.category_name = category_name;
		this.category_imgname = category_imgname;
	}
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_imgname() {
		return category_imgname;
	}
	public void setCategory_imgname(String category_imgname) {
		this.category_imgname = category_imgname;
	}
}
