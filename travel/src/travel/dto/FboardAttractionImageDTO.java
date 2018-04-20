package travel.dto;

public class FboardAttractionImageDTO {
	private int fboard_attraction_image_num;
	private int fboard_attraction_num;
	private String fboard_attraction_image_name;
	//디폴트 생성자
	public FboardAttractionImageDTO(){}

	public FboardAttractionImageDTO(int fboard_attraction_image_num, int fboard_attraction_num,
			String fboard_attraction_image_name) {
		super();
		this.fboard_attraction_image_num = fboard_attraction_image_num;
		this.fboard_attraction_num = fboard_attraction_num;
		this.fboard_attraction_image_name = fboard_attraction_image_name;
	}
	//Getter/Setter
	public int getFboard_attraction_image_num() {
		return fboard_attraction_image_num;
	}

	public void setFboard_attraction_image_num(int fboard_attraction_image_num) {
		this.fboard_attraction_image_num = fboard_attraction_image_num;
	}

	public int getFboard_attraction_num() {
		return fboard_attraction_num;
	}

	public void setFboard_attraction_num(int fboard_attraction_num) {
		this.fboard_attraction_num = fboard_attraction_num;
	}

	public String getFboard_attraction_image_name() {
		return fboard_attraction_image_name;
	}

	public void setFboard_attraction_image_name(String fboard_attraction_image_name) {
		this.fboard_attraction_image_name = fboard_attraction_image_name;
	}
}
