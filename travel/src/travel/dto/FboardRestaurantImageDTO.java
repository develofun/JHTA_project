package travel.dto;

public class FboardRestaurantImageDTO {
	private int fboard_restaurant_imgae_num;
	private int fboard_restaurant_image_num;
	private String fboard_restaurant_image;//오타
	//디폴트생성자
	public FboardRestaurantImageDTO(){}
	
	public FboardRestaurantImageDTO(int fboard_restaurant_imgae_num, int fboard_restaurant_image_num,
			String fboard_restaurant_image) {
		this.fboard_restaurant_imgae_num = fboard_restaurant_imgae_num;
		this.fboard_restaurant_image_num = fboard_restaurant_image_num;
		this.fboard_restaurant_image = fboard_restaurant_image;
	}
	//Getter/Setter
	public int getFboard_restaurant_imgae_num() {
		return fboard_restaurant_imgae_num;
	}
	public void setFboard_restaurant_imgae_num(int fboard_restaurant_imgae_num) {
		this.fboard_restaurant_imgae_num = fboard_restaurant_imgae_num;
	}
	public int getFboard_restaurant_image_num() {
		return fboard_restaurant_image_num;
	}
	public void setFboard_restaurant_image_num(int fboard_restaurant_image_num) {
		this.fboard_restaurant_image_num = fboard_restaurant_image_num;
	}
	public String getFboard_restaurant_image() {
		return fboard_restaurant_image;
	}
	public void setFboard_restaurant_image(String fboard_restaurant_image) {
		this.fboard_restaurant_image = fboard_restaurant_image;
	}
}
