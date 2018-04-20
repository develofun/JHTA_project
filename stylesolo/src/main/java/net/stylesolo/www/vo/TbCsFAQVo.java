package net.stylesolo.www.vo;


public class TbCsFAQVo {
	private int cs_faq_num;//FAQ번호
	private int cs_faq_category_code;//FAQ카테고리
	private String cs_faq_question;//FAQ질문
	private String cs_faq_answer;//FAQ답변
	private int cs_faq_hit;//FAQ조회수
	private String cs_faq_date;//FAQ작성일
	public TbCsFAQVo(){}
	public TbCsFAQVo(int cs_faq_num, int cs_faq_category_code, String cs_faq_question, String cs_faq_answer,
			int cs_faq_hit, String cs_faq_date) {
		super();
		this.cs_faq_num = cs_faq_num;
		this.cs_faq_category_code = cs_faq_category_code;
		this.cs_faq_question = cs_faq_question;
		this.cs_faq_answer = cs_faq_answer;
		this.cs_faq_hit = cs_faq_hit;
		this.cs_faq_date = cs_faq_date;
	}
	public int getCs_faq_num() {
		return cs_faq_num;
	}
	public void setCs_faq_num(int cs_faq_num) {
		this.cs_faq_num = cs_faq_num;
	}
	public int getCs_faq_category() {
		return cs_faq_category_code;
	}
	public void setCs_faq_category(int cs_faq_category_code) {
		this.cs_faq_category_code = cs_faq_category_code;
	}
	public String getCs_faq_question() {
		return cs_faq_question;
	}
	public void setCs_faq_question(String cs_faq_question) {
		this.cs_faq_question = cs_faq_question;
	}
	public String getCs_faq_answer() {
		return cs_faq_answer;
	}
	public void setCs_faq_answer(String cs_faq_answer) {
		this.cs_faq_answer = cs_faq_answer;
	}
	public int getCs_faq_hit() {
		return cs_faq_hit;
	}
	public void setCs_faq_hit(int cs_faq_hit) {
		this.cs_faq_hit = cs_faq_hit;
	}
	public String getCs_faq_date() {
		return cs_faq_date;
	}
	public void setCs_faq_date(String cs_faq_date) {
		this.cs_faq_date = cs_faq_date;
	}
}
