package net.stylesolo.www.vo;

import java.sql.Date;

public class TbMemberPrivacyVo {
	private int member_privacy_num;
	private String member_privacy_uni;
	private String member_privacy_id;
	private String member_privacy_pwd;
	private String member_privacy_name;
	private String member_privacy_gender;
	private String member_privacy_birth;
	private String member_privacy_email;
	private String member_privacy_phone;
	private String member_privacy_addr;
	private int member_privacy_point;
	private String member_privacy_gonggu;
	private String member_privacy_state;
	private Date member_privacy_date;
	
	public TbMemberPrivacyVo() {}

	public TbMemberPrivacyVo(int member_privacy_num, String member_privacy_uni, String member_privacy_id,
			String member_privacy_pwd, String member_privacy_name, String member_privacy_gender,
			String member_privacy_birth, String member_privacy_email, String member_privacy_phone,
			String member_privacy_addr, int member_privacy_point, String member_privacy_gonggu,
			String member_privacy_state, Date member_privacy_date) {
		super();
		this.member_privacy_num = member_privacy_num;
		this.member_privacy_uni = member_privacy_uni;
		this.member_privacy_id = member_privacy_id;
		this.member_privacy_pwd = member_privacy_pwd;
		this.member_privacy_name = member_privacy_name;
		this.member_privacy_gender = member_privacy_gender;
		this.member_privacy_birth = member_privacy_birth;
		this.member_privacy_email = member_privacy_email;
		this.member_privacy_phone = member_privacy_phone;
		this.member_privacy_addr = member_privacy_addr;
		this.member_privacy_point = member_privacy_point;
		this.member_privacy_gonggu = member_privacy_gonggu;
		this.member_privacy_state = member_privacy_state;
		this.member_privacy_date = member_privacy_date;
	}

	public int getMember_privacy_num() {
		return member_privacy_num;
	}

	public void setMember_privacy_num(int member_privacy_num) {
		this.member_privacy_num = member_privacy_num;
	}

	public String getMember_privacy_uni() {
		return member_privacy_uni;
	}

	public void setMember_privacy_uni(String member_privacy_uni) {
		this.member_privacy_uni = member_privacy_uni;
	}

	public String getMember_privacy_id() {
		return member_privacy_id;
	}

	public void setMember_privacy_id(String member_privacy_id) {
		this.member_privacy_id = member_privacy_id;
	}

	public String getMember_privacy_pwd() {
		return member_privacy_pwd;
	}

	public void setMember_privacy_pwd(String member_privacy_pwd) {
		this.member_privacy_pwd = member_privacy_pwd;
	}

	public String getMember_privacy_name() {
		return member_privacy_name;
	}

	public void setMember_privacy_name(String member_privacy_name) {
		this.member_privacy_name = member_privacy_name;
	}

	public String getMember_privacy_gender() {
		return member_privacy_gender;
	}

	public void setMember_privacy_gender(String member_privacy_gender) {
		this.member_privacy_gender = member_privacy_gender;
	}

	public String getMember_privacy_birth() {
		return member_privacy_birth;
	}

	public void setMember_privacy_birth(String member_privacy_birth) {
		this.member_privacy_birth = member_privacy_birth;
	}

	public String getMember_privacy_email() {
		return member_privacy_email;
	}

	public void setMember_privacy_email(String member_privacy_email) {
		this.member_privacy_email = member_privacy_email;
	}

	public String getMember_privacy_phone() {
		return member_privacy_phone;
	}

	public void setMember_privacy_phone(String member_privacy_phone) {
		this.member_privacy_phone = member_privacy_phone;
	}

	public String getMember_privacy_addr() {
		return member_privacy_addr;
	}

	public void setMember_privacy_addr(String member_privacy_addr) {
		this.member_privacy_addr = member_privacy_addr;
	}

	public int getMember_privacy_point() {
		return member_privacy_point;
	}

	public void setMember_privacy_point(int member_privacy_point) {
		this.member_privacy_point = member_privacy_point;
	}

	public String getMember_privacy_gonggu() {
		return member_privacy_gonggu;
	}

	public void setMember_privacy_gonggu(String member_privacy_gonggu) {
		this.member_privacy_gonggu = member_privacy_gonggu;
	}

	public String getMember_privacy_state() {
		return member_privacy_state;
	}

	public void setMember_privacy_state(String member_privacy_state) {
		this.member_privacy_state = member_privacy_state;
	}

	public Date getMember_privacy_date() {
		return member_privacy_date;
	}

	public void setMember_privacy_date(Date member_privacy_date) {
		this.member_privacy_date = member_privacy_date;
	}
}
