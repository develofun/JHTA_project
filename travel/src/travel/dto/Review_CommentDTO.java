package travel.dto;

public class Review_CommentDTO {
	private int review_num;
	private int review_comment_num;
	private String review_comment_writer;
	private String review_comment_content;
	private String review_comment_w_date;
	private int lev;
	private int step;
	
	public Review_CommentDTO(){}

	public Review_CommentDTO(int review_num, int review_comment_num, String review_comment_writer,
			String review_comment_content, String review_comment_w_date, int lev, int step) {
		super();
		this.review_num = review_num;
		this.review_comment_num = review_comment_num;
		this.review_comment_writer = review_comment_writer;
		this.review_comment_content = review_comment_content;
		this.review_comment_w_date = review_comment_w_date;
		this.lev = lev;
		this.step = step;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public int getReview_comment_num() {
		return review_comment_num;
	}

	public void setReview_comment_num(int review_comment_num) {
		this.review_comment_num = review_comment_num;
	}

	public String getReview_comment_writer() {
		return review_comment_writer;
	}

	public void setReview_comment_writer(String review_comment_writer) {
		this.review_comment_writer = review_comment_writer;
	}

	public String getReview_comment_content() {
		return review_comment_content;
	}

	public void setReview_comment_content(String review_comment_content) {
		this.review_comment_content = review_comment_content;
	}

	public String getReview_comment_w_date() {
		return review_comment_w_date;
	}

	public void setReview_comment_w_date(String review_comment_w_date) {
		this.review_comment_w_date = review_comment_w_date;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	
}
