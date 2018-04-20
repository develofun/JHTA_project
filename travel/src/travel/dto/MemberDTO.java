package travel.dto;

public class MemberDTO{
	private int member_num;
	private String customer_num;
	private String login_id;
	private String member_password;
	private String member_nickname;
	private String member_name;
	private String member_birthday;
	private int member_phone;
	private String member_email;
	private String member_power;
	private String member_regdate;
	
	public MemberDTO() {}
	
	public MemberDTO(int member_num, String customer_num, String login_id, String member_password,
			String member_nickname, String member_name, String member_birthday, int member_phone, String member_email,
			String member_power, String member_regdate) {
		super();
		this.member_num = member_num;
		this.customer_num = customer_num;
		this.login_id = login_id;
		this.member_password = member_password;
		this.member_nickname = member_nickname;
		this.member_name = member_name;
		this.member_birthday = member_birthday;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_power = member_power;
		this.member_regdate = member_regdate;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public String getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(String customer_num) {
		this.customer_num = customer_num;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_birthday() {
		return member_birthday;
	}

	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}

	public int getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(int member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_power() {
		return member_power;
	}

	public void setMember_power(String member_power) {
		this.member_power = member_power;
	}

	public String getMember_regdate() {
		return member_regdate;
	}

	public void setMember_regdate(String member_regdate) {
		this.member_regdate = member_regdate;
	}

	
}
	