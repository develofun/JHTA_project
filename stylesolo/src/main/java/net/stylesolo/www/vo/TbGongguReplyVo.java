package net.stylesolo.www.vo;

import java.sql.Date;

public class TbGongguReplyVo {
	private int gonggu_reply_num;
	private String gonggu_reply_comment;
	private Date gonggu_reply_date;
	private String member_privacy_id;
	private int gonggu_insert_num;
	
	public TbGongguReplyVo() {}

	public TbGongguReplyVo(int gonggu_reply_num, String gonggu_reply_comment, Date gonggu_reply_date,
			String member_privacy_id, int gonggu_insert_num) {
		super();
		this.gonggu_reply_num = gonggu_reply_num;
		this.gonggu_reply_comment = gonggu_reply_comment;
		this.gonggu_reply_date = gonggu_reply_date;
		this.member_privacy_id = member_privacy_id;
		this.gonggu_insert_num = gonggu_insert_num;
	}

	public int getGonggu_reply_num() {
		return gonggu_reply_num;
	}

	public void setGonggu_reply_num(int gonggu_reply_num) {
		this.gonggu_reply_num = gonggu_reply_num;
	}

	public String getGonggu_reply_comment() {
		return gonggu_reply_comment;
	}

	public void setGonggu_reply_comment(String gonggu_reply_comment) {
		this.gonggu_reply_comment = gonggu_reply_comment;
	}

	public Date getGonggu_reply_date() {
		return gonggu_reply_date;
	}

	public void setGonggu_reply_date(Date gonggu_reply_date) {
		this.gonggu_reply_date = gonggu_reply_date;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}

	public int getGonggu_insert_num() {
		return gonggu_insert_num;
	}

	public void setGonggu_insert_num(int gonggu_insert_num) {
		this.gonggu_insert_num = gonggu_insert_num;
	}
}
