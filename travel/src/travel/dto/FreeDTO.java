package travel.dto;

public class FreeDTO {
	private int free_num;
	private String customer_num;
	private String free_title;
	private String free_content;
	private int free_hit;
	private String free_w_date;
	private int free_password;
	private String free_writer;
	
	public FreeDTO(){}

	public FreeDTO(int free_num, String customer_num, String free_title, String free_content, String free_writer){
		this.free_num = free_num;
		this.customer_num = customer_num;
		this.free_title = free_title;
		this.free_content = free_content;
		this.free_writer = free_writer;
	}
	
	public FreeDTO(String customer_num, String free_title, String free_content, String free_writer){
		this.customer_num = customer_num;
		this.free_title = free_title;
		this.free_content = free_content;
		this.free_writer = free_writer;
	}
	
	public FreeDTO(int free_num, String customer_num, String free_title, String free_content, int free_hit,
			String free_w_date, int free_password, String free_writer) {
		super();
		this.free_num = free_num;
		this.customer_num = customer_num;
		this.free_title = free_title;
		this.free_content = free_content;
		this.free_hit = free_hit;
		this.free_w_date = free_w_date;
		this.free_password = free_password;
		this.free_writer = free_writer;
	}
	
	
	public String getFree_writer() {
		return free_writer;
	}

	public void setFree_writer(String free_writer) {
		this.free_writer = free_writer;
	}

	public int getFree_num() {
		return free_num;
	}

	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}

	public String getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(String customer_num) {
		this.customer_num = customer_num;
	}

	public String getFree_title() {
		return free_title;
	}

	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}

	public String getFree_content() {
		return free_content;
	}

	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}

	public int getFree_hit() {
		return free_hit;
	}

	public void setFree_hit(int free_hit) {
		this.free_hit = free_hit;
	}

	public String getFree_w_date() {
		return free_w_date;
	}

	public void setFree_w_date(String free_w_date) {
		this.free_w_date = free_w_date;
	}

	public int getFree_password() {
		return free_password;
	}

	public void setFree_password(int free_password) {
		this.free_password = free_password;
	}

}

	