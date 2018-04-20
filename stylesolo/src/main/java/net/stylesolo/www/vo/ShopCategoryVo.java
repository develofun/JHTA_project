package net.stylesolo.www.vo;

public class ShopCategoryVo {
	private int code;
	private String name;
	private int saleprice;
	private String mainimg;
	public ShopCategoryVo(){}
	public ShopCategoryVo(int code, String name, int saleprice, String mainimg) {
		super();
		this.code = code;
		this.name = name;
		this.saleprice = saleprice;
		this.mainimg = mainimg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public String getMainimg() {
		return mainimg;
	}
	public void setMainimg(String mainimg) {
		this.mainimg = mainimg;
	}
	
}
