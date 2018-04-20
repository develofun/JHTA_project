package net.stylesolo.www.vo;

public class TbCsFAQRnumVo {
	private int rnum;
	private int cs_faq_num;
	
	public TbCsFAQRnumVo(){}
	public TbCsFAQRnumVo(int rnum, int cs_faq_num) {
		super();
		this.rnum = rnum;
		this.cs_faq_num = cs_faq_num;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getCs_faq_num() {
		return cs_faq_num;
	}
	public void setCs_faq_num(int cs_faq_num) {
		this.cs_faq_num = cs_faq_num;
	}
}
