package net.stylesolo.www.vo;

public class ShopSectionVo {
	private int section_num;
	private String section_name;
	private int division_num;
	public ShopSectionVo(){}
	public ShopSectionVo(int section_num, String section_name, int division_num) {
		super();
		this.section_num = section_num;
		this.section_name = section_name;
		this.division_num = division_num;
	}
	public int getSection_num() {
		return section_num;
	}
	public void setSection_num(int section_num) {
		this.section_num = section_num;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public int getdivision_num() {
		return division_num;
	}
	public void setdivision_num(int division_num) {
		this.division_num = division_num;
	}
	
}
