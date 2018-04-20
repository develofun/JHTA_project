package travel.dto;

public class MarketDTO {
	private int market_num;
	private String customer_num;
	private String market_sort;
	private String market_category;	
	private String market_title;
	private String market_content;
	private int market_price;
	private String market_phone;
	private int market_hit;
	private String market_w_date;
	private String market_writer;
	public MarketDTO(){}
	public MarketDTO(int market_num, String customer_num, String market_sort, String market_category, String market_title, String market_content, int market_price, String market_phone,
			int market_hit, String market_w_date,String market_writer) {
		super();
		this.market_num = market_num;
		this.customer_num = customer_num;
		this.market_sort = market_sort;
		this.market_category = market_category;		
		this.market_title = market_title;
		this.market_content = market_content;
		this.market_price = market_price;
		this.market_phone = market_phone;
		this.market_hit = market_hit;
		this.market_w_date = market_w_date;
		this.market_writer = market_writer;
	}
	public int getMarket_num() {
		return market_num;
	}
	public void setMarket_num(int market_num) {
		this.market_num = market_num;
	}
	public String getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(String customer_num) {
		this.customer_num = customer_num;
	}
	public String getMarket_sort() {
		return market_sort;
	}
	public void setMarket_sort(String market_sort) {
		this.market_sort = market_sort;
	}
	public String getMarket_category() {
		return market_category;
	}
	public void setMarket_category(String market_category) {
		this.market_category = market_category;
	}	
	public String getMarket_title() {
		return market_title;
	}
	public void setMarket_title(String market_title) {
		this.market_title = market_title;
	}
	public String getMarket_content() {
		return market_content;
	}
	public void setMarket_content(String market_content) {
		this.market_content = market_content;
	}
	public int getMarket_price() {
		return market_price;
	}
	public void setMarket_price(int market_price) {
		this.market_price = market_price;
	}
	public String getMarket_phone() {
		return market_phone;
	}
	public void setMarket_phone(String market_phone) {
		this.market_phone = market_phone;
	}
	public int getMarket_hit() {
		return market_hit;
	}
	public void setMarket_hit(int market_hit) {
		this.market_hit = market_hit;
	}
	public String getMarket_w_date() {
		return market_w_date;
	}
	public void setMarket_w_date(String market_w_date) {
		this.market_w_date = market_w_date;
	}	
	public String getMarket_writer() {
		return market_writer;
	}
	public void setMarket_writer(String market_writer) {
		this.market_writer = market_writer;
	}
}
