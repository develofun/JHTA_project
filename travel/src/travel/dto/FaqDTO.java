package travel.dto;

public class FaqDTO {
	private int faq_num;
	private String faq_category;
	private String faq_title;
	private String faq_content;
	public FaqDTO(){}
	public FaqDTO(int faq_num, String faq_category, String faq_title, String faq_content) {
		super();
		this.faq_num = faq_num;
		this.faq_category = faq_category;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
	}
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
	}
	public String getFaq_category() {
		return faq_category;
	}
	public void setFaq_category(String faq_category) {
		this.faq_category = faq_category;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}		
}
