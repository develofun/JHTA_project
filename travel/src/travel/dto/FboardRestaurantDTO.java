package travel.dto;

public class FboardRestaurantDTO {
	private int fboard_restaurant_num;
	private int fboard_num;
	private String fboard_restaurant_title;
	private String fboard_restaurant_sub_title;
	private String fboard_restaurant_time;
	private String fboard_restaurant_price;
	private String fboard_restaurant_home_page;
	private String fboard_restaurant_go;
	private String fboard_restaurant_content;
	private String fboard_restaurant_w_date;
	//디폴트 생성자
	public FboardRestaurantDTO(){}
	public FboardRestaurantDTO(int fboard_restaurant_num, int fboard_num, String fboard_restaurant_title,
			String fboard_restaurant_sub_title, String fboard_restaurant_time, String fboard_restaurant_price,
			String fboard_restaurant_home_page, String fboard_restaurant_go, String fboard_restaurant_content,
			String fboard_restaurant_w_date) {
		super();
		this.fboard_restaurant_num = fboard_restaurant_num;
		this.fboard_num = fboard_num;
		this.fboard_restaurant_title = fboard_restaurant_title;
		this.fboard_restaurant_sub_title = fboard_restaurant_sub_title;
		this.fboard_restaurant_time = fboard_restaurant_time;
		this.fboard_restaurant_price = fboard_restaurant_price;
		this.fboard_restaurant_home_page = fboard_restaurant_home_page;
		this.fboard_restaurant_go = fboard_restaurant_go;
		this.fboard_restaurant_content = fboard_restaurant_content;
		this.fboard_restaurant_w_date = fboard_restaurant_w_date;
	}
	//Getter/Setter
	public int getFboard_restaurant_num() {
		return fboard_restaurant_num;
	}
	public void setFboard_restaurant_num(int fboard_restaurant_num) {
		this.fboard_restaurant_num = fboard_restaurant_num;
	}
	public int getFboard_num() {
		return fboard_num;
	}
	public void setFboard_num(int fboard_num) {
		this.fboard_num = fboard_num;
	}
	public String getFboard_restaurant_title() {
		return fboard_restaurant_title;
	}
	public void setFboard_restaurant_title(String fboard_restaurant_title) {
		this.fboard_restaurant_title = fboard_restaurant_title;
	}
	public String getFboard_restaurant_sub_title() {
		return fboard_restaurant_sub_title;
	}
	public void setFboard_restaurant_sub_title(String fboard_restaurant_sub_title) {
		this.fboard_restaurant_sub_title = fboard_restaurant_sub_title;
	}
	public String getFboard_restaurant_time() {
		return fboard_restaurant_time;
	}
	public void setFboard_restaurant_time(String fboard_restaurant_time) {
		this.fboard_restaurant_time = fboard_restaurant_time;
	}
	public String getFboard_restaurant_price() {
		return fboard_restaurant_price;
	}
	public void setFboard_restaurant_price(String fboard_restaurant_price) {
		this.fboard_restaurant_price = fboard_restaurant_price;
	}
	public String getFboard_restaurant_home_page() {
		return fboard_restaurant_home_page;
	}
	public void setFboard_restaurant_home_page(String fboard_restaurant_home_page) {
		this.fboard_restaurant_home_page = fboard_restaurant_home_page;
	}
	public String getFboard_restaurant_go() {
		return fboard_restaurant_go;
	}
	public void setFboard_restaurant_go(String fboard_restaurant_go) {
		this.fboard_restaurant_go = fboard_restaurant_go;
	}
	public String getFboard_restaurant_content() {
		return fboard_restaurant_content;
	}
	public void setFboard_restaurant_content(String fboard_restaurant_content) {
		this.fboard_restaurant_content = fboard_restaurant_content;
	}
	public String getFboard_restaurant_w_date() {
		return fboard_restaurant_w_date;
	}
	public void setFboard_restaurant_w_date(String fboard_restaurant_w_date) {
		this.fboard_restaurant_w_date = fboard_restaurant_w_date;
	}
}
