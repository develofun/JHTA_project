package travel.dto;

public class FboardReadAllDTO {
	private int fboard_num;
	private String fboard_area;
	private String fboard_city;
	private String fboard_category;
	private String fboard_title;
	private String fboard_image;
	private int rnum;
	
	public FboardReadAllDTO(){}

	public FboardReadAllDTO(int fboard_num, String fboard_area, String fboard_city, String fboard_category,
			String fboard_title, String fboard_image, int rnum) {
		super();
		this.fboard_num = fboard_num;
		this.fboard_area = fboard_area;
		this.fboard_city = fboard_city;
		this.fboard_category = fboard_category;
		this.fboard_title = fboard_title;
		this.fboard_image = fboard_image;
		this.rnum = rnum;
	}

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

	public String getFboard_title() {
		return fboard_title;
	}

	public void setFboard_title(String fboard_title) {
		this.fboard_title = fboard_title;
	}

	public String getFboard_image() {
		return fboard_image;
	}

	public void setFboard_image(String fboard_image) {
		this.fboard_image = fboard_image;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	
}
