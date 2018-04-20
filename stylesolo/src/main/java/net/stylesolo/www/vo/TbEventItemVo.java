package net.stylesolo.www.vo;

import java.sql.Date;

public class TbEventItemVo {
	private int shop_item_code;
	private String shop_item_name;
	private int shop_itemprice;
	private long shop_item_pointrate;
	private int shop_item_discountrate;
	private int shop_item_saleprice;
	private int shop_item_stock;
	private String shop_item_desc;
	private int section_num;
	private Date shop_item_regdate;
	private int shop_item_subming_num;
	private String shop_item_mainimg_imgname;
	private int rnum;
	public TbEventItemVo(){}
	public TbEventItemVo(int shop_item_code, String shop_item_name, int shop_itemprice, long shop_item_pointrate,
			int shop_item_discountrate, int shop_item_saleprice, int shop_item_stock, String shop_item_desc,
			int section_num, Date shop_item_regdate, int shop_item_subming_num, String shop_item_mainimg_imgname,
			int rnum) {
		super();
		this.shop_item_code = shop_item_code;
		this.shop_item_name = shop_item_name;
		this.shop_itemprice = shop_itemprice;
		this.shop_item_pointrate = shop_item_pointrate;
		this.shop_item_discountrate = shop_item_discountrate;
		this.shop_item_saleprice = shop_item_saleprice;
		this.shop_item_stock = shop_item_stock;
		this.shop_item_desc = shop_item_desc;
		this.section_num = section_num;
		this.shop_item_regdate = shop_item_regdate;
		this.shop_item_subming_num = shop_item_subming_num;
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
		this.rnum = rnum;
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
	public int getShop_itemprice() {
		return shop_itemprice;
	}
	public void setShop_itemprice(int shop_itemprice) {
		this.shop_itemprice = shop_itemprice;
	}
	public long getShop_item_pointrate() {
		return shop_item_pointrate;
	}
	public void setShop_item_pointrate(long shop_item_pointrate) {
		this.shop_item_pointrate = shop_item_pointrate;
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
	public int getShop_item_stock() {
		return shop_item_stock;
	}
	public void setShop_item_stock(int shop_item_stock) {
		this.shop_item_stock = shop_item_stock;
	}
	public String getShop_item_desc() {
		return shop_item_desc;
	}
	public void setShop_item_desc(String shop_item_desc) {
		this.shop_item_desc = shop_item_desc;
	}
	public int getSection_num() {
		return section_num;
	}
	public void setSection_num(int section_num) {
		this.section_num = section_num;
	}
	public Date getShop_item_regdate() {
		return shop_item_regdate;
	}
	public void setShop_item_regdate(Date shop_item_regdate) {
		this.shop_item_regdate = shop_item_regdate;
	}
	public int getShop_item_subming_num() {
		return shop_item_subming_num;
	}
	public void setShop_item_subming_num(int shop_item_subming_num) {
		this.shop_item_subming_num = shop_item_subming_num;
	}
	public String getShop_item_mainimg_imgname() {
		return shop_item_mainimg_imgname;
	}
	public void setShop_item_mainimg_imgname(String shop_item_mainimg_imgname) {
		this.shop_item_mainimg_imgname = shop_item_mainimg_imgname;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
}
