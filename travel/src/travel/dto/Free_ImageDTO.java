package travel.dto;

public class Free_ImageDTO {
	private int free_image_num;
	private int free_num;
	private String free_image_original_name;
	private String free_image_name;
	
	public Free_ImageDTO(){}

	public Free_ImageDTO(int free_image_num, int free_num, String free_image_original_name, String free_image_name) {
		super();
		this.free_image_num = free_image_num;
		this.free_num = free_num;
		this.free_image_original_name = free_image_original_name;
		this.free_image_name = free_image_name;
	}

	public int getFree_image_num() {
		return free_image_num;
	}

	public void setFree_image_num(int free_image_num) {
		this.free_image_num = free_image_num;
	}

	public int getFree_num() {
		return free_num;
	}

	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}

	public String getFree_image_original_name() {
		return free_image_original_name;
	}

	public void setFree_image_original_name(String free_image_original_name) {
		this.free_image_original_name = free_image_original_name;
	}

	public String getFree_image_name() {
		return free_image_name;
	}

	public void setFree_image_name(String free_image_name) {
		this.free_image_name = free_image_name;
	}
	
}