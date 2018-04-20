package net.stylesolo.www.vo;

public class TbCsFAQImageVo {
	private int cs_faq_image_num;//FAQ이미지번호
	private int cs_faq_num;//FAQ번호
	private String cs_faq_image_name;//FAQ이미지명
	public TbCsFAQImageVo(){}
	public TbCsFAQImageVo(int cs_faq_image_num, int cs_faq_num, String cs_faq_image_name) {
		super();
		this.cs_faq_image_num = cs_faq_image_num;
		this.cs_faq_num = cs_faq_num;
		this.cs_faq_image_name = cs_faq_image_name;
	}
	public int getCs_faq_image_num() {
		return cs_faq_image_num;
	}
	public void setCs_faq_image_num(int cs_faq_image_num) {
		this.cs_faq_image_num = cs_faq_image_num;
	}
	public int getCs_faq_num() {
		return cs_faq_num;
	}
	public void setCs_faq_num(int cs_faq_num) {
		this.cs_faq_num = cs_faq_num;
	}
	public String getCs_faq_image_name() {
		return cs_faq_image_name;
	}
	public void setCs_faq_image_name(String cs_faq_image_name) {
		this.cs_faq_image_name = cs_faq_image_name;
	}
}
