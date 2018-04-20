package net.stylesolo.www.vo;

import java.sql.Date;

public class TbCsConsultVo {
	private int cs_consult_num;//문의 번호
	private String cs_consult_title;//제목
	private String cs_consult_content;//내용
	private Date cs_consult_w_date;//작성일
	private String cs_consult_answercheck;//답변여부
	private String member_privacy_id;//작성아이디
	private int consult_category_num;//상담카테고리 번호
	public TbCsConsultVo(){}
	public TbCsConsultVo(int cs_consult_num, String cs_consult_title, String cs_consult_content, Date cs_consult_w_date,
			String cs_consult_answercheck, String member_privacy_id, int consult_category_num) {
		super();
		this.cs_consult_num = cs_consult_num;
		this.cs_consult_title = cs_consult_title;
		this.cs_consult_content = cs_consult_content;
		this.cs_consult_w_date = cs_consult_w_date;
		this.cs_consult_answercheck = cs_consult_answercheck;
		this.member_privacy_id = member_privacy_id;
		this.consult_category_num = consult_category_num;
	}
	public int getCs_consult_num() {
		return cs_consult_num;
	}
	public void setCs_consult_num(int cs_consult_num) {
		this.cs_consult_num = cs_consult_num;
	}
	public String getCs_consult_title() {
		return cs_consult_title;
	}
	public void setCs_consult_title(String cs_consult_title) {
		this.cs_consult_title = cs_consult_title;
	}
	public String getCs_consult_content() {
		return cs_consult_content;
	}
	public void setCs_consult_content(String cs_consult_content) {
		this.cs_consult_content = cs_consult_content;
	}
	public Date getCs_consult_w_date() {
		return cs_consult_w_date;
	}
	public void setCs_consult_w_date(Date cs_consult_w_date) {
		this.cs_consult_w_date = cs_consult_w_date;
	}
	public String getCs_consult_answercheck() {
		return cs_consult_answercheck;
	}
	public void setCs_consult_answercheck(String cs_consult_answercheck) {
		this.cs_consult_answercheck = cs_consult_answercheck;
	}
	public String getMember_privacy_id() {
		return member_privacy_id;
	}
	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}
	public int getConsult_category_num() {
		return consult_category_num;
	}
	public void setConsult_category_num(int consult_category_num) {
		this.consult_category_num = consult_category_num;
	}
}
