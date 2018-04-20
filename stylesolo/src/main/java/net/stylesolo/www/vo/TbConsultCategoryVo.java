package net.stylesolo.www.vo;

public class TbConsultCategoryVo {
	private int consult_category_num;
	private String consult_category_name;
	public TbConsultCategoryVo(){}
	public TbConsultCategoryVo(int consult_category_num, String consult_category_name) {
		super();
		this.consult_category_num = consult_category_num;
		this.consult_category_name = consult_category_name;
	}
	public int getConsult_category_num() {
		return consult_category_num;
	}
	public void setConsult_category_num(int consult_category_num) {
		this.consult_category_num = consult_category_num;
	}
	public String getConsult_category_name() {
		return consult_category_name;
	}
	public void setConsult_category_name(String consult_category_name) {
		this.consult_category_name = consult_category_name;
	}
}
