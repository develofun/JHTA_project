package net.stylesolo.www.vo;

import java.sql.Date;

//TbMemberPrivacyVo + TbGongguInsertVo
public class TbMemberInfoGongguInfoVo {
	//멤버테이블정보들
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
	
	//공구테이블정보들
	private int gonggu_insert_num;
	private String gonggu_insert_title;
	private String gonggu_insert_content;
	private String gonggu_insert_category;
	private String gonggu_insert_price;
	private int gonggu_insert_minnum;
	private int gonggu_insert_maxnum;
	private Date gonggu_insert_openingdate;
	private Date gonggu_insert_closingdate;
	private String gonggu_insert_bankname;
	private String gonggu_insert_account;
	private Date gonggu_insert_date;
	
	public TbMemberInfoGongguInfoVo() {}

	public TbMemberInfoGongguInfoVo(int member_privacy_num, String member_privacy_uni, String member_privacy_id,
			String member_privacy_pwd, String member_privacy_name, String member_privacy_gender,
			String member_privacy_birth, String member_privacy_email, String member_privacy_phone,
			String member_privacy_addr, int member_privacy_point, String member_privacy_gonggu,
			String member_privacy_state, Date member_privacy_date, int gonggu_insert_num, String gonggu_insert_title,
			String gonggu_insert_content, String gonggu_insert_category, String gonggu_insert_price,
			int gonggu_insert_minnum, int gonggu_insert_maxnum, Date gonggu_insert_openingdate,
			Date gonggu_insert_closingdate, String gonggu_insert_bankname, String gonggu_insert_account,
			Date gonggu_insert_date) {
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
		this.gonggu_insert_num = gonggu_insert_num;
		this.gonggu_insert_title = gonggu_insert_title;
		this.gonggu_insert_content = gonggu_insert_content;
		this.gonggu_insert_category = gonggu_insert_category;
		this.gonggu_insert_price = gonggu_insert_price;
		this.gonggu_insert_minnum = gonggu_insert_minnum;
		this.gonggu_insert_maxnum = gonggu_insert_maxnum;
		this.gonggu_insert_openingdate = gonggu_insert_openingdate;
		this.gonggu_insert_closingdate = gonggu_insert_closingdate;
		this.gonggu_insert_bankname = gonggu_insert_bankname;
		this.gonggu_insert_account = gonggu_insert_account;
		this.gonggu_insert_date = gonggu_insert_date;
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

	public int getGonggu_insert_num() {
		return gonggu_insert_num;
	}

	public void setGonggu_insert_num(int gonggu_insert_num) {
		this.gonggu_insert_num = gonggu_insert_num;
	}

	public String getGonggu_insert_title() {
		return gonggu_insert_title;
	}

	public void setGonggu_insert_title(String gonggu_insert_title) {
		this.gonggu_insert_title = gonggu_insert_title;
	}

	public String getGonggu_insert_content() {
		return gonggu_insert_content;
	}

	public void setGonggu_insert_content(String gonggu_insert_content) {
		this.gonggu_insert_content = gonggu_insert_content;
	}

	public String getGonggu_insert_category() {
		return gonggu_insert_category;
	}

	public void setGonggu_insert_category(String gonggu_insert_category) {
		this.gonggu_insert_category = gonggu_insert_category;
	}

	public String getGonggu_insert_price() {
		return gonggu_insert_price;
	}

	public void setGonggu_insert_price(String gonggu_insert_price) {
		this.gonggu_insert_price = gonggu_insert_price;
	}

	public int getGonggu_insert_minnum() {
		return gonggu_insert_minnum;
	}

	public void setGonggu_insert_minnum(int gonggu_insert_minnum) {
		this.gonggu_insert_minnum = gonggu_insert_minnum;
	}

	public int getGonggu_insert_maxnum() {
		return gonggu_insert_maxnum;
	}

	public void setGonggu_insert_maxnum(int gonggu_insert_maxnum) {
		this.gonggu_insert_maxnum = gonggu_insert_maxnum;
	}

	public Date getGonggu_insert_openingdate() {
		return gonggu_insert_openingdate;
	}

	public void setGonggu_insert_openingdate(Date gonggu_insert_openingdate) {
		this.gonggu_insert_openingdate = gonggu_insert_openingdate;
	}

	public Date getGonggu_insert_closingdate() {
		return gonggu_insert_closingdate;
	}

	public void setGonggu_insert_closingdate(Date gonggu_insert_closingdate) {
		this.gonggu_insert_closingdate = gonggu_insert_closingdate;
	}

	public String getGonggu_insert_bankname() {
		return gonggu_insert_bankname;
	}

	public void setGonggu_insert_bankname(String gonggu_insert_bankname) {
		this.gonggu_insert_bankname = gonggu_insert_bankname;
	}

	public String getGonggu_insert_account() {
		return gonggu_insert_account;
	}

	public void setGonggu_insert_account(String gonggu_insert_account) {
		this.gonggu_insert_account = gonggu_insert_account;
	}

	public Date getGonggu_insert_date() {
		return gonggu_insert_date;
	}

	public void setGonggu_insert_date(Date gonggu_insert_date) {
		this.gonggu_insert_date = gonggu_insert_date;
	}
}
