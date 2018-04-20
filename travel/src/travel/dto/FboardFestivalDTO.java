package travel.dto;

public class FboardFestivalDTO {
	public int fboard_festival_num;
	public int fboard_num;
	public String fboard_festival_title;
	public String fboard_festival_sub_title;
	public String fboard_festival_period;
	public String fboard_festival_contents;
	public String fboard_festival_w_date;
	//디폴트 생성자
	public FboardFestivalDTO(){}
	
	public FboardFestivalDTO(int fboard_festival_num, int fboard_num, String fboard_festival_title,
			String fboard_festival_sub_title, String fboard_festival_period, String fboard_festival_contents,
			String fboard_festival_w_date) {
		super();
		this.fboard_festival_num = fboard_festival_num;
		this.fboard_num = fboard_num;
		this.fboard_festival_title = fboard_festival_title;
		this.fboard_festival_sub_title = fboard_festival_sub_title;
		this.fboard_festival_period = fboard_festival_period;
		this.fboard_festival_contents = fboard_festival_contents;
		this.fboard_festival_w_date = fboard_festival_w_date;
	}
	//Getter/Setter
	public int getFboard_festival_num() {
		return fboard_festival_num;
	}

	public void setFboard_festival_num(int fboard_festival_num) {
		this.fboard_festival_num = fboard_festival_num;
	}

	public int getFboard_num() {
		return fboard_num;
	}

	public void setFboard_num(int fboard_num) {
		this.fboard_num = fboard_num;
	}

	public String getFboard_festival_title() {
		return fboard_festival_title;
	}

	public void setFboard_festival_title(String fboard_festival_title) {
		this.fboard_festival_title = fboard_festival_title;
	}

	public String getFboard_festival_sub_title() {
		return fboard_festival_sub_title;
	}

	public void setFboard_festival_sub_title(String fboard_festival_sub_title) {
		this.fboard_festival_sub_title = fboard_festival_sub_title;
	}

	public String getFboard_festival_period() {
		return fboard_festival_period;
	}

	public void setFboard_festival_period(String fboard_festival_period) {
		this.fboard_festival_period = fboard_festival_period;
	}

	public String getFboard_festival_contents() {
		return fboard_festival_contents;
	}

	public void setFboard_festival_contents(String fboard_festival_contents) {
		this.fboard_festival_contents = fboard_festival_contents;
	}

	public String getFboard_festival_w_date() {
		return fboard_festival_w_date;
	}

	public void setFboard_festival_w_date(String fboard_festival_w_date) {
		this.fboard_festival_w_date = fboard_festival_w_date;
	}
}
