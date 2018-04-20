package travel.dto;

public class EventSaleDTO {
	private int eventSale_num;
	private String customer_num;
	private String eventSale_sort;
	private String eventSale_category;
	private String eventSale_title;
	private String eventSale_writer;
	private String eventSale_content;
	private int eventSale_hit;
	private String eventSale_w_date;
	private String eventSale_startDate;
	private String eventSale_endDate;	
	public EventSaleDTO(){}
	public EventSaleDTO(int eventSale_num, String customer_num, String eventSale_sort, String eventSale_category,
			String eventSale_title, String eventSale_writer, String eventSale_content, int eventSale_hit,
			String eventSale_w_date, String eventSale_startDate, String eventSale_endDate) {
		super();
		this.eventSale_num = eventSale_num;
		this.customer_num = customer_num;
		this.eventSale_sort = eventSale_sort;
		this.eventSale_category = eventSale_category;
		this.eventSale_title = eventSale_title;
		this.eventSale_writer = eventSale_writer;
		this.eventSale_content = eventSale_content;
		this.eventSale_hit = eventSale_hit;
		this.eventSale_w_date = eventSale_w_date;
		this.eventSale_startDate = eventSale_startDate;
		this.eventSale_endDate = eventSale_endDate;
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
	public String getEventSale_sort() {
		return eventSale_sort;
	}
	public void setEventSale_sort(String eventSale_sort) {
		this.eventSale_sort = eventSale_sort;
	}
	public String getEventSale_category() {
		return eventSale_category;
	}
	public void setEventSale_category(String eventSale_category) {
		this.eventSale_category = eventSale_category;
	}
	public String getEventSale_title() {
		return eventSale_title;
	}
	public void setEventSale_title(String eventSale_title) {
		this.eventSale_title = eventSale_title;
	}
	public String getEventSale_writer() {
		return eventSale_writer;
	}
	public void setEventSale_writer(String eventSale_writer) {
		this.eventSale_writer = eventSale_writer;
	}
	public String getEventSale_content() {
		return eventSale_content;
	}
	public void setEventSale_content(String eventSale_content) {
		this.eventSale_content = eventSale_content;
	}
	public int getEventSale_hit() {
		return eventSale_hit;
	}
	public void setEventSale_hit(int eventSale_hit) {
		this.eventSale_hit = eventSale_hit;
	}
	public String getEventSale_w_date() {
		return eventSale_w_date;
	}
	public void setEventSale_w_date(String eventSale_w_date) {
		this.eventSale_w_date = eventSale_w_date;
	}
	public String getEventSale_startDate() {
		return eventSale_startDate;
	}
	public void setEventSale_startDate(String eventSale_startDate) {
		this.eventSale_startDate = eventSale_startDate;
	}
	public String getEventSale_endDate() {
		return eventSale_endDate;
	}
	public void setEventSale_endDate(String eventSale_endDate) {
		this.eventSale_endDate = eventSale_endDate;
	}	
}
