package net.stylesolo.www.vo;

public class TbCsConsultImageVo {
	private int cs_consult_image_num;//���� �̹�����ȣ
	private int cs_consult_num;//���ǹ�ȣ
	private String cs_consult_image_name;//���� �̹�����
	public TbCsConsultImageVo(){}
	public TbCsConsultImageVo(int cs_consult_image_num, int cs_consult_num, String cs_consult_image_name) {
		super();
		this.cs_consult_image_num = cs_consult_image_num;
		this.cs_consult_num = cs_consult_num;
		this.cs_consult_image_name = cs_consult_image_name;
	}
	public int getCs_consult_image_num() {
		return cs_consult_image_num;
	}
	public void setCs_consult_image_num(int cs_consult_image_num) {
		this.cs_consult_image_num = cs_consult_image_num;
	}
	public int getCs_consult_num() {
		return cs_consult_num;
	}
	public void setCs_consult_num(int cs_consult_num) {
		this.cs_consult_num = cs_consult_num;
	}
	public String getCs_consult_image_name() {
		return cs_consult_image_name;
	}
	public void setCs_consult_image_name(String cs_consult_image_name) {
		this.cs_consult_image_name = cs_consult_image_name;
	}
}
