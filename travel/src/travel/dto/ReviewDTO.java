package travel.dto;

public class ReviewDTO {
	private int review_num;
	private String customer_num;
	private String review_category;
	private String review_title;
	private String review_content;
	private int review_hit;
	private String review_w_date;
	private String review_writer;
	
	public ReviewDTO(){}

	public ReviewDTO(int review_num, String customer_num, String review_category, String review_title,
			String review_content, int review_hit, String review_w_date, String review_writer) {
		super();
		this.review_num = review_num;
		this.customer_num = customer_num;
		this.review_category = review_category;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_hit = review_hit;
		this.review_w_date = review_w_date;
		this.review_writer = review_writer;
	}

	public ReviewDTO(int review_num, String customer_num, String review_category, String review_title,
			String review_content, String review_writer) {
		super();
		this.review_num = review_num;
		this.customer_num = customer_num;
		this.review_category = review_category;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_writer = review_writer;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(String customer_num) {
		this.customer_num = customer_num;
	}

	public String getReview_category() {
		return review_category;
	}

	public void setReview_category(String review_category) {
		this.review_category = review_category;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getReview_hit() {
		return review_hit;
	}

	public void setReview_hit(int review_hit) {
		this.review_hit = review_hit;
	}

	public String getReview_w_date() {
		return review_w_date;
	}

	public void setReview_w_date(String review_w_date) {
		this.review_w_date = review_w_date;
	}

	public String getReview_writer() {
		return review_writer;
	}

	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}
}