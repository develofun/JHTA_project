package net.stylesolo.www.vo;

public class TbShopMenuVo {
	private String shop_menu_code;
	private String shop_menu_name;
	
	public TbShopMenuVo() {}

	public TbShopMenuVo(String shop_menu_code, String shop_menu_name) {
		super();
		this.shop_menu_code = shop_menu_code;
		this.shop_menu_name = shop_menu_name;
	}

	public String getShop_menu_code() {
		return shop_menu_code;
	}

	public String getShop_menu_name() {
		return shop_menu_name;
	}

}
