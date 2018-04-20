package travel.dto;

public class Free_CommentDTO {
	private int free_num;
	private int free_comment_num;
	private String free_comment_writer;
	private String free_comment_content;
	private String free_comment_w_date;
	private int lev;
	private int step;
	
	public Free_CommentDTO(){}

	public Free_CommentDTO(int free_num, int free_comment_num, String free_comment_writer, String free_comment_content,
			String free_comment_w_date, int lev, int step) {
		super();
		this.free_num = free_num;
		this.free_comment_num = free_comment_num;
		this.free_comment_writer = free_comment_writer;
		this.free_comment_content = free_comment_content;
		this.free_comment_w_date = free_comment_w_date;
		this.lev = lev;
		this.step = step;
	}

	public int getFree_num() {
		return free_num;
	}

	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}

	public int getFree_comment_num() {
		return free_comment_num;
	}

	public void setFree_comment_num(int free_comment_num) {
		this.free_comment_num = free_comment_num;
	}

	public String getFree_comment_writer() {
		return free_comment_writer;
	}

	public void setFree_comment_writer(String free_comment_writer) {
		this.free_comment_writer = free_comment_writer;
	}

	public String getFree_comment_content() {
		return free_comment_content;
	}

	public void setFree_comment_content(String free_comment_content) {
		this.free_comment_content = free_comment_content;
	}

	public String getFree_comment_w_date() {
		return free_comment_w_date;
	}

	public void setFree_comment_w_date(String free_comment_w_date) {
		this.free_comment_w_date = free_comment_w_date;
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
