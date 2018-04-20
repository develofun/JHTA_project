package travel.dto;

public class FboardShoppingImageDTO {
	private int fboard_shopping_num;
	private int fboard_num;
	private String fboard_shopping_image_name;
	//디폴트생성자
	public FboardShoppingImageDTO(){}
	
	public FboardShoppingImageDTO(int fboard_shopping_num, int fboard_num, String fboard_shopping_image_name) {
		super();
		this.fboard_shopping_num = fboard_shopping_num;
		this.fboard_num = fboard_num;
		this.fboard_shopping_image_name = fboard_shopping_image_name;
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
	public String getFboard_shopping_image_name() {
		return fboard_shopping_image_name;
	}
	public void setFboard_shopping_image_name(String fboard_shopping_image_name) {
		this.fboard_shopping_image_name = fboard_shopping_image_name;
	}
}
