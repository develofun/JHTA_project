package travel.dto;

public class EventSaleCommentDTO {
	private int eventSale_comment_num;
	private int eventSale_num;
	private String customer_num;
	private String eventSale_comment_writer;
	private String eventSale_comment_content;
	private String eventSale_comment_w_date;
	public EventSaleCommentDTO(){}
	public EventSaleCommentDTO(int eventSale_comment_num, int eventSale_num, String customer_num,
			String eventSale_comment_writer, String eventSale_comment_content, String eventSale_comment_w_date) {
		super();
		this.eventSale_comment_num = eventSale_comment_num;
		this.eventSale_num = eventSale_num;
		this.customer_num = customer_num;
		this.eventSale_comment_writer = eventSale_comment_writer;
		this.eventSale_comment_content = eventSale_comment_content;
		this.eventSale_comment_w_date = eventSale_comment_w_date;
	}
	public int getEventSale_comment_num() {
		return eventSale_comment_num;
	}
	public void setEventSale_comment_num(int eventSale_comment_num) {
		this.eventSale_comment_num = eventSale_comment_num;
	}
	public int getEventSale_num() {
		return eventSale_num;
	}
	public void setEventSale_num(int eventSale_num) {
		this.eventSale_num = eventSale_num;
	}
	public String getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(String customer_num) {
		this.customer_num = customer_num;
	}
	public String getEventSale_comment_writer() {
		return eventSale_comment_writer;
	}
	public void setEventSale_comment_writer(String eventSale_comment_writer) {
		this.eventSale_comment_writer = eventSale_comment_writer;
	}
	public String getEventSale_comment_content() {
		return eventSale_comment_content;
	}
	public void setEventSale_comment_content(String eventSale_comment_content) {
		this.eventSale_comment_content = eventSale_comment_content;
	}
	public String getEventSale_comment_w_date() {
		return eventSale_comment_w_date;
	}
	public void setEventSale_comment_w_date(String eventSale_comment_w_date) {
		this.eventSale_comment_w_date = eventSale_comment_w_date;
	}	
}
