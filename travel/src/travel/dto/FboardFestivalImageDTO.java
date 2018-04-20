package travel.dto;

public class FboardFestivalImageDTO {
	private int fboard_festival_image_num;
	private int fobard_festival_num;
	private String fboard_festival_image_name;
	//디폴트 생성자
	public FboardFestivalImageDTO(){}
	
	public FboardFestivalImageDTO(int fboard_festival_image_num, int fobard_festival_num,
			String fboard_festival_image_name) {
		super();
		this.fboard_festival_image_num = fboard_festival_image_num;
		this.fobard_festival_num = fobard_festival_num;
		this.fboard_festival_image_name = fboard_festival_image_name;
	}
	//Getter/Setter
	public int getFboard_festival_image_num() {
		return fboard_festival_image_num;
	}
	public void setFboard_festival_image_num(int fboard_festival_image_num) {
		this.fboard_festival_image_num = fboard_festival_image_num;
	}
	public int getFobard_festival_num() {
		return fobard_festival_num;
	}
	public void setFobard_festival_num(int fobard_festival_num) {
		this.fobard_festival_num = fobard_festival_num;
	}
	public String getFboard_festival_image_name() {
		return fboard_festival_image_name;
	}
	public void setFboard_festival_image_name(String fboard_festival_image_name) {
		this.fboard_festival_image_name = fboard_festival_image_name;
	}
}
