package travel.dto;

import java.sql.Date;

public class Notice_CommentsDTO {
	private int notice_comments_num;
	private int notice_num;
	private String notice_comments_content;
	private Date notice_comments_w_date;
	private String notice_comments_writer;
	
	public Notice_CommentsDTO(){}

	public Notice_CommentsDTO(int notice_comments_num, int notice_num, String notice_comments_content,
			Date notice_comments_w_date, String notice_comments_writer) {
		super();
		this.notice_comments_num = notice_comments_num;
		this.notice_num = notice_num;
		this.notice_comments_content = notice_comments_content;
		this.notice_comments_w_date = notice_comments_w_date;
		this.notice_comments_writer = notice_comments_writer;
	}

	public int getNotice_comments_num() {
		return notice_comments_num;
	}

	public void setNotice_comments_num(int notice_comments_num) {
		this.notice_comments_num = notice_comments_num;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getNotice_comments_content() {
		return notice_comments_content;
	}

	public void setNotice_comments_content(String notice_comments_content) {
		this.notice_comments_content = notice_comments_content;
	}

	public Date getNotice_comments_w_date() {
		return notice_comments_w_date;
	}

	public void setNotice_comments_w_date(Date notice_comments_w_date) {
		this.notice_comments_w_date = notice_comments_w_date;
	}

	public String getNotice_comments_writer() {
		return notice_comments_writer;
	}

	public void setNotice_comments_writer(String notice_comments_writer) {
		this.notice_comments_writer = notice_comments_writer;
	}

	
	
}
