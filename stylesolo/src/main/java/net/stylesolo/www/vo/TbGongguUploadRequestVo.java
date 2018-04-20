package net.stylesolo.www.vo;

import java.sql.Date;

public class TbGongguUploadRequestVo {
	private int gonggu_upload_request_num;
	private String gonggu_upload_request_part;
	private String gonggu_upload_request_reason;
	private Date gonggu_upload_request_date;
	private String member_privacy_id;
	
	public TbGongguUploadRequestVo() {}

	public TbGongguUploadRequestVo(int gonggu_upload_request_num, String gonggu_upload_request_part,
			String gonggu_upload_request_reason, Date gonggu_upload_request_date, String member_privacy_id) {
		super();
		this.gonggu_upload_request_num = gonggu_upload_request_num;
		this.gonggu_upload_request_part = gonggu_upload_request_part;
		this.gonggu_upload_request_reason = gonggu_upload_request_reason;
		this.gonggu_upload_request_date = gonggu_upload_request_date;
		this.member_privacy_id = member_privacy_id;
	}

	public int getGonggu_upload_request_num() {
		return gonggu_upload_request_num;
	}

	public void setGonggu_upload_request_num(int gonggu_upload_request_num) {
		this.gonggu_upload_request_num = gonggu_upload_request_num;
	}

	public String getGonggu_upload_request_part() {
		return gonggu_upload_request_part;
	}

	public void setGonggu_upload_request_part(String gonggu_upload_request_part) {
		this.gonggu_upload_request_part = gonggu_upload_request_part;
	}

	public String getGonggu_upload_request_reason() {
		return gonggu_upload_request_reason;
	}

	public void setGonggu_upload_request_reason(String gonggu_upload_request_reason) {
		this.gonggu_upload_request_reason = gonggu_upload_request_reason;
	}

	public Date getGonggu_upload_request_date() {
		return gonggu_upload_request_date;
	}

	public void setGonggu_upload_request_date(Date gonggu_upload_request_date) {
		this.gonggu_upload_request_date = gonggu_upload_request_date;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}
	
}
