package net.stylesolo.www.vo;

public class TbCsFAQCategoryVo {
	private int cs_faq_category_code;
	private String cs_faq_category_name;
	
	public TbCsFAQCategoryVo(){}

	public TbCsFAQCategoryVo(int cs_faq_category_code, String cs_faq_category_name) {
		super();
		this.cs_faq_category_code = cs_faq_category_code;
		this.cs_faq_category_name = cs_faq_category_name;
	}

	public int getCs_faq_category_code() {
		return cs_faq_category_code;
	}

	public void setCs_faq_category_code(int cs_faq_category_code) {
		this.cs_faq_category_code = cs_faq_category_code;
	}

	public String getCs_faq_category_name() {
		return cs_faq_category_name;
	}

	public void setCs_faq_category_name(String cs_faq_category_name) {
		this.cs_faq_category_name = cs_faq_category_name;
	}
}
