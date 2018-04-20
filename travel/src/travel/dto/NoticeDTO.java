package travel.dto;

import java.sql.Date;

public class NoticeDTO {
	private int notice_num;
	private String notice_title;
	private String notice_content;
	private int notice_hit;
	private Date notice_w_date;
	
	public NoticeDTO(){}

	public NoticeDTO(int notice_num, String notice_title, String notice_content, int notice_hit, Date notice_w_date) {
		super();
		this.notice_num = notice_num;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_hit = notice_hit;
		this.notice_w_date = notice_w_date;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public int getNotice_hit() {
		return notice_hit;
	}

	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}

	public Date getNotice_w_date() {
		return notice_w_date;
	}

	public void setNotice_w_date(Date notice_w_date) {
		this.notice_w_date = notice_w_date;
	}
	
	
}
