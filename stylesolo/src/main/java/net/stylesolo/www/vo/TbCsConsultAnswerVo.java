package net.stylesolo.www.vo;

import java.sql.Date;

public class TbCsConsultAnswerVo {
	private int cs_consult_answer_num;//답변번호
	private int cs_consult_num;//문의번호
	private String cs_consult_answer;//답변
	private Date cs_consult_answer_date;//답변일
	public TbCsConsultAnswerVo(){}
	public TbCsConsultAnswerVo(int cs_consult_answer_num, int cs_consult_num, String cs_consult_answer,
			Date cs_consult_answer_date) {
		super();
		this.cs_consult_answer_num = cs_consult_answer_num;
		this.cs_consult_num = cs_consult_num;
		this.cs_consult_answer = cs_consult_answer;
		this.cs_consult_answer_date = cs_consult_answer_date;
	}
	public int getCs_consult_answer_num() {
		return cs_consult_answer_num;
	}
	public void setCs_consult_answer_num(int cs_consult_answer_num) {
		this.cs_consult_answer_num = cs_consult_answer_num;
	}
	public int getCs_consult_num() {
		return cs_consult_num;
	}
	public void setCs_consult_num(int cs_consult_num) {
		this.cs_consult_num = cs_consult_num;
	}
	public String getCs_consult_answer() {
		return cs_consult_answer;
	}
	public void setCs_consult_answer(String cs_consult_answer) {
		this.cs_consult_answer = cs_consult_answer;
	}
	public Date getCs_consult_answer_date() {
		return cs_consult_answer_date;
	}
	public void setCs_consult_answer_date(Date cs_consult_answer_date) {
		this.cs_consult_answer_date = cs_consult_answer_date;
	}
}
