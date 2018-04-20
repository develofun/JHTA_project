package net.stylesoloadmin.www.vo;

import java.util.Date;

public class AdminMemberVo {
	private int admin_member_num;
	private String admin_member_code;
	private String admin_member_id;
	private String admin_member_password;
	private String admin_member_name;
	private String admin_member_birth;
	private String admin_member_phone;
	private String admin_member_ip;
	private String admin_member_email;
	private String admin_member_state;
	private String admin_member_authority;
	private Date admin_member_regdate;
	public AdminMemberVo() {}
	public AdminMemberVo(int admin_member_num, String admin_member_code, String admin_member_id,
			String admin_member_password, String admin_member_name, String admin_member_birth,
			String admin_member_phone, String admin_member_ip, String admin_member_email, String admin_member_state,
			String admin_member_authority, Date admin_member_regdate) {
		super();
		this.admin_member_num = admin_member_num;
		this.admin_member_code = admin_member_code;
		this.admin_member_id = admin_member_id;
		this.admin_member_password = admin_member_password;
		this.admin_member_name = admin_member_name;
		this.admin_member_birth = admin_member_birth;
		this.admin_member_phone = admin_member_phone;
		this.admin_member_ip = admin_member_ip;
		this.admin_member_email = admin_member_email;
		this.admin_member_state = admin_member_state;
		this.admin_member_authority = admin_member_authority;
		this.admin_member_regdate = admin_member_regdate;
	}
	public int getAdmin_member_num() {
		return admin_member_num;
	}
	public void setAdmin_member_num(int admin_member_num) {
		this.admin_member_num = admin_member_num;
	}
	public String getAdmin_member_code() {
		return admin_member_code;
	}
	public void setAdmin_member_code(String admin_member_code) {
		this.admin_member_code = admin_member_code;
	}
	public String getAdmin_member_id() {
		return admin_member_id;
	}
	public void setAdmin_member_id(String admin_member_id) {
		this.admin_member_id = admin_member_id;
	}
	public String getAdmin_member_password() {
		return admin_member_password;
	}
	public void setAdmin_member_password(String admin_member_password) {
		this.admin_member_password = admin_member_password;
	}
	public String getAdmin_member_name() {
		return admin_member_name;
	}
	public void setAdmin_member_name(String admin_member_name) {
		this.admin_member_name = admin_member_name;
	}
	public String getAdmin_member_birth() {
		return admin_member_birth;
	}
	public void setAdmin_member_birth(String admin_member_birth) {
		this.admin_member_birth = admin_member_birth;
	}
	public String getAdmin_member_phone() {
		return admin_member_phone;
	}
	public void setAdmin_member_phone(String admin_member_phone) {
		this.admin_member_phone = admin_member_phone;
	}
	public String getAdmin_member_ip() {
		return admin_member_ip;
	}
	public void setAdmin_member_ip(String admin_member_ip) {
		this.admin_member_ip = admin_member_ip;
	}
	public String getAdmin_member_email() {
		return admin_member_email;
	}
	public void setAdmin_member_email(String admin_member_email) {
		this.admin_member_email = admin_member_email;
	}
	public String getAdmin_member_state() {
		return admin_member_state;
	}
	public void setAdmin_member_state(String admin_member_state) {
		this.admin_member_state = admin_member_state;
	}
	public String getAdmin_member_authority() {
		return admin_member_authority;
	}
	public void setAdmin_member_authority(String admin_member_authority) {
		this.admin_member_authority = admin_member_authority;
	}
	public Date getAdmin_member_regdate() {
		return admin_member_regdate;
	}
	public void setAdmin_member_regdate(Date admin_member_regdate) {
		this.admin_member_regdate = admin_member_regdate;
	}
	
	
}
