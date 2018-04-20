package net.stylesolo.www.vo;

import java.util.List;

public class ShopDivisionVo {
	private int division_num;
	private String division_name;
	private int category_num;
	private List<ShopSectionVo> list;
	public ShopDivisionVo(){}
	public ShopDivisionVo(int division_num, String division_name, int category_num, List<ShopSectionVo> list) {
		super();
		this.division_num = division_num;
		this.division_name = division_name;
		this.category_num = category_num;
		this.list = list;
	}
	public int getDivision_num() {
		return division_num;
	}
	public void setDivision_num(int division_num) {
		this.division_num = division_num;
	}
	public String getDivision_name() {
		return division_name;
	}
	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	public List<ShopSectionVo> getList() {
		return list;
	}
	public void setList(List<ShopSectionVo> list) {
		this.list = list;
	}
}
