package net.stylesolo.www.vo;

public class TbShopJjimVo { //찜테이블
	private int shop_jjim_num; //글번호
	private String member_privacy_id; //회원아이디
	private int shop_item_code; //제품코드
	private String shop_item_name;
	private int shop_item_saleprice;
	private String shop_item_mainimg_imgname;
	
	public TbShopJjimVo(){}

	public TbShopJjimVo(int shop_jjim_num, String member_privacy_id, int shop_item_code, String shop_item_name,
			int shop_item_saleprice, String shop_item_mainimg_imgname) {
		super();
		this.shop_jjim_num = shop_jjim_num;
		this.member_privacy_id = member_privacy_id;
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.shop_item_saleprice = shop_item_saleprice;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
	}

	public int getShop_jjim_num() {
		return shop_jjim_num;
	}

	public void setShop_jjim_num(int shop_jjim_num) {
		this.shop_jjim_num = shop_jjim_num;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
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

	public int getShop_item_saleprice() {
		return shop_item_saleprice;
	}

	public void setShop_item_saleprice(int shop_item_saleprice) {
		this.shop_item_saleprice = shop_item_saleprice;
	}

	public String getShop_item_mainimg_imgname() {
		return shop_item_mainimg_imgname;
	}

	public void setShop_item_mainimg_imgname(String shop_item_mainimg_imgname) {
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
	}
	
}
