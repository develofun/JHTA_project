package travel.dto;

public class QnaDTO {
	private int qna_num;
	private String customer_num;
	private String qna_state;
	private String qna_title;
	private String qna_writer;
	private String qna_content;
	private String qna_reply;
	private int qna_hit;
	private String qna_password;
	private String qna_w_date;
	public QnaDTO(){}
	public QnaDTO(int qna_num, String customer_num, String qna_state, String qna_title, String qna_writer,
			String qna_content, String qna_reply, int qna_hit, String qna_password, String qna_w_date) {
		super();
		this.qna_num = qna_num;
		this.customer_num = customer_num;
		this.qna_state = qna_state;
		this.qna_title = qna_title;
		this.qna_writer = qna_writer;
		this.qna_content = qna_content;
		this.qna_reply = qna_reply;
		this.qna_hit = qna_hit;
		this.qna_password = qna_password;
		this.qna_w_date = qna_w_date;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(String customer_num) {
		this.customer_num = customer_num;
	}
	public String getQna_state() {
		return qna_state;
	}
	public void setQna_state(String qna_state) {
		this.qna_state = qna_state;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_writer() {
		return qna_writer;
	}
	public void setQna_writer(String qna_writer) {
		this.qna_writer = qna_writer;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_reply() {
		return qna_reply;
	}
	public void setQna_reply(String qna_reply) {
		this.qna_reply = qna_reply;
	}
	public int getQna_hit() {
		return qna_hit;
	}
	public void setQna_hit(int qna_hit) {
		this.qna_hit = qna_hit;
	}
	public String getQna_password() {
		return qna_password;
	}
	public void setQna_password(String qna_password) {
		this.qna_password = qna_password;
	}
	public String getQna_w_date() {
		return qna_w_date;
	}
	public void setQna_w_date(String qna_w_date) {
		this.qna_w_date = qna_w_date;
	}	
}
