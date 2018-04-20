package travel.dto;

public class FboardShoppingDTO {
	private int fboard_shopping_num;
	private int fboard_num;
	private String fboard_shopping_title;
	private String fboard_shopping_sub_title;
	private String tb_fboard_shopping_time;//오타
	private String fboard_shopping_homepage;
	private String fboard_shopping_go;
	private String fboard_shopping_contents;
	private String fboard_shopping_w_date;
	//디폴트 생성자
	public FboardShoppingDTO(){}
	
	public FboardShoppingDTO(int fboard_shopping_num, int fboard_num, String fboard_shopping_title,
			String fboard_shopping_sub_title, String tb_fboard_shopping_time, String fboard_shopping_homepage,
			String fboard_shopping_go, String fboard_shopping_contents, String fboard_shopping_w_date) {
		super();
		this.fboard_shopping_num = fboard_shopping_num;
		this.fboard_num = fboard_num;
		this.fboard_shopping_title = fboard_shopping_title;
		this.fboard_shopping_sub_title = fboard_shopping_sub_title;
		this.tb_fboard_shopping_time = tb_fboard_shopping_time;
		this.fboard_shopping_homepage = fboard_shopping_homepage;
		this.fboard_shopping_go = fboard_shopping_go;
		this.fboard_shopping_contents = fboard_shopping_contents;
		this.fboard_shopping_w_date = fboard_shopping_w_date;
	}
	//Getter/Setter
	public int getFboard_shopping_num() {
		return fboard_shopping_num;
	}
	public void setFboard_shopping_num(int fboard_shopping_num) {
		this.fboard_shopping_num = fboard_shopping_num;
	}
	public int getFboard_num() {
		return fboard_num;
	}
	public void setFboard_num(int fboard_num) {
		this.fboard_num = fboard_num;
	}
	public String getFboard_shopping_title() {
		return fboard_shopping_title;
	}
	public void setFboard_shopping_title(String fboard_shopping_title) {
		this.fboard_shopping_title = fboard_shopping_title;
	}
	public String getFboard_shopping_sub_title() {
		return fboard_shopping_sub_title;
	}
	public void setFboard_shopping_sub_title(String fboard_shopping_sub_title) {
		this.fboard_shopping_sub_title = fboard_shopping_sub_title;
	}
	public String getTb_fboard_shopping_time() {
		return tb_fboard_shopping_time;
	}
	public void setTb_fboard_shopping_time(String tb_fboard_shopping_time) {
		this.tb_fboard_shopping_time = tb_fboard_shopping_time;
	}
	public String getFboard_shopping_homepage() {
		return fboard_shopping_homepage;
	}
	public void setFboard_shopping_homepage(String fboard_shopping_homepage) {
		this.fboard_shopping_homepage = fboard_shopping_homepage;
	}
	public String getFboard_shopping_go() {
		return fboard_shopping_go;
	}
	public void setFboard_shopping_go(String fboard_shopping_go) {
		this.fboard_shopping_go = fboard_shopping_go;
	}
	public String getFboard_shopping_contents() {
		return fboard_shopping_contents;
	}
	public void setFboard_shopping_contents(String fboard_shopping_contents) {
		this.fboard_shopping_contents = fboard_shopping_contents;
	}
	public String getFboard_shopping_w_date() {
		return fboard_shopping_w_date;
	}
	public void setFboard_shopping_w_date(String fboard_shopping_w_date) {
		this.fboard_shopping_w_date = fboard_shopping_w_date;
	}
}
