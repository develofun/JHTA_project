package travel.dto;

public class FboardAttractionDTO {
	private int fboard_attraction_num;
	private int fboard_num;
	private String fboard_attraction_title;
	private String fboard_attraction_sub_title;
	private String fboard_attraction_time;
	private String fboard_attraction_price;
	private String fboard_attraction_home_page;
	private String fboard_attraction_go;
	private String fboard_attraction_content;
	private String fboard_attraction_w_date;
	//디폴트생성자
	public FboardAttractionDTO(){}
	public FboardAttractionDTO(int fboard_attraction_num, int fboard_num, String fboard_attraction_title,
			String fboard_attraction_sub_title, String fboard_attraction_time, String fboard_attraction_price,
			String fboard_attraction_home_page, String fboard_attraction_go, String fboard_attraction_content,
			String fboard_attraction_w_date) {
		super();
		this.fboard_attraction_num = fboard_attraction_num;
		this.fboard_num = fboard_num;
		this.fboard_attraction_title = fboard_attraction_title;
		this.fboard_attraction_sub_title = fboard_attraction_sub_title;
		this.fboard_attraction_time = fboard_attraction_time;
		this.fboard_attraction_price = fboard_attraction_price;
		this.fboard_attraction_home_page = fboard_attraction_home_page;
		this.fboard_attraction_go = fboard_attraction_go;
		this.fboard_attraction_content = fboard_attraction_content;
		this.fboard_attraction_w_date = fboard_attraction_w_date;
	}
	//Getter/Setter
	public int getFboard_attraction_num() {
		return fboard_attraction_num;
	}
	public void setFboard_attraction_num(int fboard_attraction_num) {
		this.fboard_attraction_num = fboard_attraction_num;
	}
	public int getFboard_num() {
		return fboard_num;
	}
	public void setFboard_num(int fboard_num) {
		this.fboard_num = fboard_num;
	}
	public String getFboard_attraction_title() {
		return fboard_attraction_title;
	}
	public void setFboard_attraction_title(String fboard_attraction_title) {
		this.fboard_attraction_title = fboard_attraction_title;
	}
	public String getFboard_attraction_sub_title() {
		return fboard_attraction_sub_title;
	}
	public void setFboard_attraction_sub_title(String fboard_attraction_sub_title) {
		this.fboard_attraction_sub_title = fboard_attraction_sub_title;
	}
	public String getFboard_attraction_time() {
		return fboard_attraction_time;
	}
	public void setFboard_attraction_time(String fboard_attraction_time) {
		this.fboard_attraction_time = fboard_attraction_time;
	}
	public String getFboard_attraction_price() {
		return fboard_attraction_price;
	}
	public void setFboard_attraction_price(String fboard_attraction_price) {
		this.fboard_attraction_price = fboard_attraction_price;
	}
	public String getFboard_attraction_home_page() {
		return fboard_attraction_home_page;
	}
	public void setFboard_attraction_home_page(String fboard_attraction_home_page) {
		this.fboard_attraction_home_page = fboard_attraction_home_page;
	}
	public String getFboard_attraction_go() {
		return fboard_attraction_go;
	}
	public void setFboard_attraction_go(String fboard_attraction_go) {
		this.fboard_attraction_go = fboard_attraction_go;
	}
	public String getFboard_attraction_content() {
		return fboard_attraction_content;
	}
	public void setFboard_attraction_content(String fboard_attraction_content) {
		this.fboard_attraction_content = fboard_attraction_content;
	}
	public String getFboard_attraction_w_date() {
		return fboard_attraction_w_date;
	}
	public void setFboard_attraction_w_date(String fboard_attraction_w_date) {
		this.fboard_attraction_w_date = fboard_attraction_w_date;
	}
}
