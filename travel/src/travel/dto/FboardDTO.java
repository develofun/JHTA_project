package travel.dto;

public class FboardDTO {
	private int fboard_num;
	private String fboard_area;
	private String fboard_city;
	private String fboard_category;
	//디폴트생성자
	public FboardDTO(){}

	public FboardDTO(int fboard_num, String fboard_area, String fboard_city, String fboard_category) {
		this.fboard_num = fboard_num;
		this.fboard_area = fboard_area;
		this.fboard_city = fboard_city;
		this.fboard_category = fboard_category;
	}
	//Getter/Setter
	public int getFboard_num() {
		return fboard_num;
	}

	public void setFboard_num(int fboard_num) {
		this.fboard_num = fboard_num;
	}

	public String getFboard_area() {
		return fboard_area;
	}

	public void setFboard_area(String fboard_area) {
		this.fboard_area = fboard_area;
	}

	public String getFboard_city() {
		return fboard_city;
	}

	public void setFboard_city(String fboard_city) {
		this.fboard_city = fboard_city;
	}

	public String getFboard_category() {
		return fboard_category;
	}

	public void setFboard_category(String fboard_category) {
		this.fboard_category = fboard_category;
	}
}
