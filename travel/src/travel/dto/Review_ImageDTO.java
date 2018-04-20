package travel.dto;

public class Review_ImageDTO {
	private int review_image_num;
	private int review_num;
	private String review_image_original_name;
	private String review_image_name;
	
	public Review_ImageDTO(){}

	public Review_ImageDTO(int review_image_num, int review_num, String review_image_original_name,
			String review_image_name) {
		super();
		this.review_image_num = review_image_num;
		this.review_num = review_num;
		this.review_image_original_name = review_image_original_name;
		this.review_image_name = review_image_name;
	}

	public int getReview_image_num() {
		return review_image_num;
	}

	public void setReview_image_num(int review_image_num) {
		this.review_image_num = review_image_num;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getReview_image_original_name() {
		return review_image_original_name;
	}

	public void setReview_image_original_name(String review_image_original_name) {
		this.review_image_original_name = review_image_original_name;
	}

	public String getReview_image_name() {
		return review_image_name;
	}

	public void setReview_image_name(String review_image_name) {
		this.review_image_name = review_image_name;
	}
	
	
}